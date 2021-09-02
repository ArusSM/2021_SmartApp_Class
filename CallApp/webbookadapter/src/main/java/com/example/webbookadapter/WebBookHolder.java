package com.example.webbookadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WebBookHolder {
    TextView title;
    TextView date;
    TextView size;
    ImageView personImageView;
    ImageView downImageView;
    public WebBookHolder(View root) {
        title = root.findViewById(R.id.main_item_name);
        date = root.findViewById(R.id.main_item_date);
        size = root.findViewById(R.id.main_item_size);
        personImageView = root.findViewById(R.id.main_item_person);
        downImageView = root.findViewById(R.id.main_item_download);
    }
}
