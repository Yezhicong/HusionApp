package com.jay.fragmentdemo4.ui.air;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jay.fragmentdemo4.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class AirFragment extends Fragment {

    private List<Air> airList = new ArrayList<>();

    public AirFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_air, container,false);
        airList.clear();
        initAirs();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_air_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        AirAdapter adapter = new AirAdapter(airList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initAirs(){
        Air a1 = new Air("展厅左", R.drawable.air);
        airList.add(a1);
        Air a2 = new Air("展厅中", R.drawable.air);
        airList.add(a2);
        Air a3 = new Air("展厅右", R.drawable.air);
        airList.add(a3);
        Air a4 = new Air("会客室", R.drawable.air);
        airList.add(a4);
        Air a5 = new Air("管理部", R.drawable.air);
        airList.add(a5);
        Air a6 = new Air("会商室", R.drawable.air);
        airList.add(a6);
        Air a7 = new Air("财务室", R.drawable.air);
        airList.add(a7);
        Air a8 = new Air("技术部", R.drawable.air);
        airList.add(a8);
        Air a9 = new Air("走廊", R.drawable.air);
        airList.add(a9);
    }

}