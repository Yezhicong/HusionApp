package com.jay.fragmentdemo4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment3 extends Fragment {

    private List<Computer> computerList = new ArrayList<>();

    public MyFragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_computer, container,false);
        computerList.clear();
        initComputers();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_computer_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        ComputerAdapter adapter = new ComputerAdapter(computerList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initComputers(){
        Computer a1 = new Computer("付艳华", R.drawable.computer);
        computerList.add(a1);
        Computer a2 = new Computer("闲置", R.drawable.computer);
        computerList.add(a2);
        Computer a3 = new Computer("陈小豪", R.drawable.computer);
        computerList.add(a3);
        Computer a4 = new Computer("预留", R.drawable.computer);
        computerList.add(a4);
        Computer a5 = new Computer("前台", R.drawable.computer);
        computerList.add(a5);
        Computer a6 = new Computer("麦茂涛", R.drawable.computer);
        computerList.add(a6);
        Computer a7 = new Computer("蒙广南", R.drawable.computer);
        computerList.add(a7);
        Computer a8 = new Computer("中标", R.drawable.computer);
        computerList.add(a8);
        Computer a9 = new Computer("Dell-3", R.drawable.computer);
        computerList.add(a9);
        Computer a10 = new Computer("前台2", R.drawable.computer);
        computerList.add(a10);
        Computer a11 = new Computer("严神赐", R.drawable.computer);
        computerList.add(a11);
        Computer a12 = new Computer("陈琳", R.drawable.computer);
        computerList.add(a12);
    }

}
