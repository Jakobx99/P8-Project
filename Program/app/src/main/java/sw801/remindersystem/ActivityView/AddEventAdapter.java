package sw801.remindersystem.ActivityView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sw801.remindersystem.R;

/**
 * Created by cheec on 21-03-2018.
 */

public class AddEventAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> Title;


    public AddEventAdapter(Context context, ArrayList<String> text1) {
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
        row = inflater.inflate(R.layout.addeventlistlayout, parent, false);
        TextView title;
        title = (TextView) row.findViewById(R.id.addEventDoThis);
        title.setText(Title.get(position));
        ImageButton add = row.findViewById(R.id.addEventAddCondition);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });






        return (row);
    }

}
