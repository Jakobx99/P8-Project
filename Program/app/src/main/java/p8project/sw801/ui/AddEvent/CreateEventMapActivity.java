package p8project.sw801.ui.AddEvent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import p8project.sw801.R;

public class CreateEventMapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener{

    private GoogleMap gmap;
    private static LocationManager locManager;
    private Marker marker;
    private static Geocoder geocoder;
    private EditText editText;
    private Button cancelButton;
    private Button confirmButton;
    private Address a;
    private Location location = null;
    private LocationManager mLocationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.g_map);
        mapFragment.getMapAsync(this);
        editText = findViewById(R.id.editText_createEventMapAddressbar);
        cancelButton = findViewById(R.id.button_createEventMapCancel);
        confirmButton = findViewById(R.id.button_createEventConfirm);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();

                Bundle b = new Bundle();
                b.putParcelable("address", a);
                resultIntent.putExtra("address", b);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;

        gmap.setMinZoomPreference(8);

        // Get current location
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();



        location = getLastKnownLocation();

        //Set current location on map
        LatLng currentLoc = new LatLng(location.getLatitude(), location.getLongitude());

        marker = gmap.addMarker(new MarkerOptions().position(currentLoc).title("Current position"));
        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLoc, 12.0f));

        //Write address in textfield
        a = convertCoordinateToAddress(currentLoc);
        editText.setText(a.getAddressLine(0)+ ", " + a.getAddressLine(1) + ", " + a.getAddressLine(2));

        //Current location button on map
        gmap.setMyLocationEnabled(true);
        gmap.setOnMyLocationButtonClickListener(this);
        gmap.setOnMyLocationClickListener(this);


        gmap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                marker.remove();
                marker = gmap.addMarker(new MarkerOptions().position(latLng).title("Chosen position"));
                a = convertCoordinateToAddress(latLng);
                editText.setText(a.getAddressLine(0)+ ", " + a.getAddressLine(1) + ", " + a.getAddressLine(2));
            }
        });

    }

    //TODO Click event on map i.e. set marker and write address in textbox.
    //TODO Confirm and exit button.


    private Address convertCoordinateToAddress(LatLng latLng){
        //TODO MAKE DEFAULT ADDRESS TO RETURN TO AVOID NULL
        Address address = null;
        geocoder = new Geocoder(this, Locale.getDefault());
        double lat = latLng.latitude;
        double lon = latLng.longitude;
        try {
            List<Address> addressList = geocoder.getFromLocation(lat, lon, 1);
            address = addressList.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return address;
    }



    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }

    @Override
    public boolean onMyLocationButtonClick() {
       return false;
    }

    private Location getLastKnownLocation() {
        mLocationManager = (LocationManager)getApplicationContext().getSystemService(LOCATION_SERVICE);
        List<String> providers = mLocationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = mLocationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }



}
