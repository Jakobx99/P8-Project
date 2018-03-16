package sw801.remindersystem.ActivityView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import sw801.remindersystem.R;

/**
 * Created by Jakob on 16-03-2018.
 */

public class MySmartDeviceAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<String> Title;


    public MySmartDeviceAdapter(Context context, ArrayList<String> text1) {
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

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View row;
        row = inflater.inflate(R.layout.mysmartdeviceslistlayout, parent, false);
        TextView title;
        title = (TextView) row.findViewById(R.id.row_textview);
        title.setText(Title.get(position));


        return (row);
    }
}