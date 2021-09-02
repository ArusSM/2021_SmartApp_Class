package com.example.callapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean callPermission; // CALL_PHONE 퍼미션 사용 등록 판별
    ListView listView;
    Button btnAdd;
    ArrayList<CallLogVO> datas; // 데이터 저장하는 ArrayList 벼수
    CallLogAdapter adapter; // 커스텀 어댑터 변수

    // DB 관련 변수
    DBHelper helper;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // CALL_PHONE 퍼미션 사용 등록 여부 체크
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            callPermission = true;
        }

        // CALL_PHONE 퍼미션 사용 등록이 안되어 있는 경우 퍼미션 요청
        if(!callPermission) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 200);
        }

        listView = (ListView)findViewById(R.id.main_list);

        // Adapter 에 사용할 데이터 준비
        datas = new ArrayList<>();
        helper = new DBHelper(this);
        db = helper.getWritableDatabase();
        cursor = db.rawQuery("select _id, name, photo, date, phone from tb_calllog", null);
        while(cursor.moveToNext()) {
            CallLogVO vo = new CallLogVO();
            vo.id = cursor.getInt(0);
            vo.name = cursor.getString(1);
            vo.photo = cursor.getString(2);
            vo.date = cursor.getString(3);
            vo.phone = cursor.getString(4);
            datas.add(vo);
        }
        db.close();


        // 어댑터에 데이터, 레이아웃 설정 후 listView에 셋팅
        adapter = new CallLogAdapter(this, R.layout.main_list_item, datas);
        listView.setAdapter(adapter);

        // 리스트뷰 아이템을 클릭했을 때 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { // i -> positon
                // 리스트뷰에서 아이템을 클릭하면 DisplayCallLog 액티비티를 실행한다.
                final CallLogVO vo = datas.get(i);
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", vo.id); // DisplayCallLog 액티비티에 보내는 정보 : id(아이템과 DB id), isNew(연락처 추가 여부)
                dataBundle.putBoolean("isNew", false);
                Intent intent = new Intent(getApplicationContext(), DisplayCallLogActivity.class);
                intent.putExtra(dataBundle);
                startActivity(intent);
            }
        });

        // 연락처추가 버튼 클릭했을 때 이벤트 처리
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 연락처추가 버튼을 클릭하면 DisplayCallLog 액티비티를 실행한다.
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0); // DisplayCallLog 액티비티에 보내는 정보 : id(아이템과 DB id), isNew(연락처 추가 여부)
                dataBundle.putBoolean("isNew", true);
                Intent intent = new Intent(getApplicationContext(), DisplayCallLogActivity.class);
                intent.putExtra(dataBundle);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

        // Adapter에 사용할 데이터 준비
        datas.clear();
        helper = new DBHelper(this);
        db = helper.getReadableDatabase();
        cursor = db.rawQuery("select +id, name, photo, date, phone from tb_calllog", null);
        while(cursor.moveToNext()) {
            CallLogVO vo = new CallLogVO();
            vo.id = cursor.getInt(0);
            vo.name = cursor.getString(1);
            vo.photo = cursor.getString(2);
            vo.date = cursor.getString(3);
            vo.phone = cursor.getString(4);
            datas.add(vo);
        }
        db.close();

        adapter.addAll(datas);
        adapter.notifyDataSetChanged();
    }
}