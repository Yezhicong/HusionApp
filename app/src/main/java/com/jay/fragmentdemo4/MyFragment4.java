package com.jay.fragmentdemo4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.jay.fragmentdemo4.MyClass.DLRoundMenuView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment4 extends Fragment implements View.OnTouchListener{

    //private Button logoutBt;

    private List<String> list = new ArrayList<String>();
    private ArrayAdapter< String> adapter;

    public MyFragment4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fg_camera, container,false);

        final Context mContext = view.getContext();
        Spinner spin_camera = view.findViewById(R.id.camera_spinner);
        DLRoundMenuView dlRoundMenuView = view.findViewById(R.id.dl_rmv);
        ImageView suoxiaoBt = view.findViewById(R.id.suoxiao_button);
        ImageView fangdaBt = view.findViewById(R.id.fangda_button);

        suoxiaoBt.setOnTouchListener(this);
        fangdaBt.setOnTouchListener(this);

        list.add("前摄像机");
        list.add("后摄像机");
        list.add("左摄像机");
        list.add("右摄像机");


        adapter = new ArrayAdapter<String>(view.getContext(), R.layout.camera_spinner_selected_item, list);
        adapter.setDropDownViewResource(R.layout.camera_spinner_dropdown_item);
        spin_camera.setAdapter(adapter);

        spin_camera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"您选择的相机是：" + adapter.getItem(position),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        dlRoundMenuView.setOnMenuClickListener(new DLRoundMenuView.OnMenuClickListener() {
            @Override
            public void OnMenuClick(int position, int state) {
                if (state == 1){
                    Toast.makeText(view.getContext(), "按下：" + position, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(view.getContext(), "松开：" + position, Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*logoutBt = view.findViewById(R.id.logout_button);
        logoutBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                startActivity(intent);
           }
        });*/

        return view;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.suoxiao_button:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(v.getContext(), "按下缩小", Toast.LENGTH_SHORT).show();
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    Toast.makeText(v.getContext(), "弹起缩小", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.fangda_button:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(v.getContext(), "按下放大", Toast.LENGTH_SHORT).show();
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    Toast.makeText(v.getContext(), "弹起放大", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return false;
    }
}
