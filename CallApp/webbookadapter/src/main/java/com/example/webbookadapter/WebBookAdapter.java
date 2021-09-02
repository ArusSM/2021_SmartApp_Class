package com.example.webbookadapter;

import android.content.Context;
import android.provider.CallLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class WebBookAdapter extends ArrayAdapter<WebBookVO> {
    Context context;
    int resId;
    ArrayList<WebBookVO> datas;
    public WebBookAdapter(@NonNull Context context, int resource, @NonNull ArrayList<WebBookVO> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resId = resource;
        this.datas = objects;
}

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            WebBookHolder holder = new WebBookHolder(convertView);
            convertView.setTag(holder);
        }

        WebBookHolder holder = (WebBookHolder)convertView.getTag();
        ImageView persoImageView = holder.personImageView;
        ImageView downImageView = holder.downImageView;
        TextView titleView = holder.title;
        TextView dateView = holder.date;
        TextView sizeView = holder.size;


        final WebBookVO vo = datas.get(position);
        titleView.setText(vo.title);
        dateView.setText(vo.date);
        sizeView.setText(vo.size);
        downImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_baseline_arrow_circle_down, null));
        persoImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.hong, null));

        downImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "다운로드가 불가능합니다.", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }



}
