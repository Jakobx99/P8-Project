package sw801.remindersystem.ActivityView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sw801.remindersystem.R;

/**
 * Created by clubd on 20-03-2018.
 */

public class LocationSettingAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> Title;


    public LocationSettingAdapter(Context context, ArrayList<String> text1) {
        mContext = context;
        Title = text1;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return Title.size();
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View row;
        row = inflater.inflate(R.layout.locationsettinglistlayout, parent, false);
        final TextView title;
        title = (TextView) row.findViewById(R.id.row_textview);
        title.setText(Title.get(position));

        //Click event for delete buttons
        ImageView delete = row.findViewById(R.id.imageView_locationsettingdelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Delete: " + Title.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        //Click event for edit buttons
        ImageView edit = row.findViewById(R.id.imageView_locationsettingedit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Edit: " + Title.get(position), Toast.LENGTH_SHORT).show();
            }
        });



        return (row);
    }
}