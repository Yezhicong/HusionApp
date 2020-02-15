package com.jay.fragmentdemo4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment1 extends Fragment {

    private List<Light> lightList = new ArrayList<>();

    public MyFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_light, container,false);
        lightList.clear();
        initLights();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_light_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        LightAdapter adapter = new LightAdapter(lightList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initLights(){
        Light a1 = new Light("展厅左侧灯", R.drawable.light);
        lightList.add(a1);
        Light a2 = new Light("展厅右侧灯", R.drawable.light);
        lightList.add(a2);
        Light a3 = new Light("展厅方形灯", R.drawable.light);
        lightList.add(a3);
        Light a4 = new Light("展厅圆形灯", R.drawable.light);
        lightList.add(a4);
        Light a5 = new Light("展厅墙面灯", R.drawable.light);
        lightList.add(a5);
        Light a6 = new Light("技术部灯", R.drawable.light);
        lightList.add(a6);
        Light a7 = new Light("前台灯", R.drawable.light);
        lightList.add(a7);
        Light a8 = new Light("会商室灯", R.drawable.light);
        lightList.add(a8);
        Light a9 = new Light("会客室灯", R.drawable.light);
        lightList.add(a9);
        Light a10 = new Light("管理部灯", R.drawable.light);
        lightList.add(a10);
        Light a11 = new Light("财务室灯", R.drawable.light);
        lightList.add(a11);
        Light a12 = new Light("研发部灯", R.drawable.light);
        lightList.add(a12);
        Light a13 = new Light("走廊灯", R.drawable.light);
        lightList.add(a13);
    }
}
