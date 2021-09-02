package com.example.customadapter2;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DriveHolder {
    public ImageView img;
    public TextView title;
    public TextView date;
    public TextView content;

    public DriveHolder(View root) {
        img = root.findViewById(R.id.custom_img);
        title = root.findViewById(R.id.custom_name);
        date = root.findViewById(R.id.custom_date);
        content = root.findViewById(R.id.custom_content);
    }
}
