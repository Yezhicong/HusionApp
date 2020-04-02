package com.jay.fragmentdemo4.ui.light;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.jay.fragmentdemo4.R;
import com.jay.fragmentdemo4.socket.MySocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class LightFragment extends Fragment {

    private List<Light> lightList = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private LightAdapter adapter;
    private int i = 0;
    View view;

    public LightFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fg_light, container,false);

        lightList.clear();
        initLights();

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.orange);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                refreshLight();
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recycler_light);
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new LightAdapter(lightList);
        recyclerView.setAdapter(adapter);

        refreshLight();

        return view;
    }

    private void initLights(){
        Light a1 = new Light("展厅左侧灯", R.drawable.light, false);
        lightList.add(a1);
        Light a2 = new Light("展厅右侧灯", R.drawable.light, false);
        lightList.add(a2);
        Light a3 = new Light("展厅方形灯", R.drawable.light, false);
        lightList.add(a3);
        Light a4 = new Light("展厅圆形灯", R.drawable.light, false);
        lightList.add(a4);
        Light a5 = new Light("展厅墙面灯", R.drawable.light, false);
        lightList.add(a5);
        Light a6 = new Light("技术部灯", R.drawable.light, false);
        lightList.add(a6);
        Light a7 = new Light("前台灯", R.drawable.light, false);
        lightList.add(a7);
        Light a8 = new Light("会商室灯", R.drawable.light, false);
        lightList.add(a8);
        Light a9 = new Light("会客室灯", R.drawable.light, false);
        lightList.add(a9);
        Light a10 = new Light("管理部灯", R.drawable.light, false);
        lightList.add(a10);
        Light a11 = new Light("财务室灯", R.drawable.light, false);
        lightList.add(a11);
        Light a12 = new Light("研发部灯", R.drawable.light, false);
        lightList.add(a12);
        Light a13 = new Light("走廊灯", R.drawable.light, false);
        lightList.add(a13);
    }

    public void refreshLight() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                adapter.flag = false;
                String recvMsg;
                MySocket.TcpSocketConnect mySocket1 =  new MySocket.TcpSocketConnect(
                        "192.168.88.221", 4800, false, "HS-REL-getrelay-FF");
                mySocket1.start();
                while (mySocket1.getReturnMsg() == null);
                recvMsg = mySocket1.getReturnMsg();
                if (recvMsg.equals("null")) i++;
                if (recvMsg.contains("3-on")){
                    Light light = lightList.get(0);
                    lightList.set(0, new Light(light.getName(), light.getImageId(), true));
                }
                if (recvMsg.contains("5-on")){
                    Light light = lightList.get(1);
                    lightList.set(1, new Light(light.getName(), light.getImageId(), true));
                }
                if (recvMsg.contains("4-on")){
                    Light light = lightList.get(2);
                    lightList.set(2, new Light(light.getName(), light.getImageId(), true));
                }
                if (recvMsg.contains("7-on")){
                    Light light = lightList.get(3);
                    lightList.set(3, new Light(light.getName(), light.getImageId(), true));
                }
                if (recvMsg.contains("1-on")){
                    Light light = lightList.get(5);
                    lightList.set(5, new Light(light.getName(), light.getImageId(), true));
                }
                if (recvMsg.contains("2-on")){
                    Light light = lightList.get(6);
                    lightList.set(6, new Light(light.getName(), light.getImageId(), true));
                }
                MySocket.TcpSocketConnect mySocket2 =  new MySocket.TcpSocketConnect(
                        "192.168.88.220", 4800, false, "HS-REL-getrelay-FF");
                mySocket2.start();
                while (mySocket2.getReturnMsg() == null);
                recvMsg = mySocket2.getReturnMsg();
                if (recvMsg.equals("null")) i++;
                if (recvMsg.contains("5-on")){
                    Light light = lightList.get(4);
                    lightList.set(4, new Light(light.getName(), light.getImageId(), true));
                }
                if (recvMsg.contains("3-on")){
                    Light light = lightList.get(12);
                    lightList.set(12, new Light(light.getName(), light.getImageId(), true));
                }
                MySocket.TcpSocketConnect mySocket3 =  new MySocket.TcpSocketConnect(
                        "192.168.88.223", 4800, false, "HS-REL-getrelay-FF");
                mySocket3.start();
                while (mySocket3.getReturnMsg() == null);
                recvMsg = mySocket3.getReturnMsg();
                if (recvMsg.equals("null")) i++;
                if (recvMsg.contains("3-on")){
                    Light light = lightList.get(7);
                    lightList.set(7, new Light(light.getName(), light.getImageId(), true));
                }
                if (recvMsg.contains("6-on")){
                    Light light = lightList.get(8);
                    lightList.set(8, new Light(light.getName(), light.getImageId(), true));
                }
                if (recvMsg.contains("5-on")){
                    Light light = lightList.get(9);
                    lightList.set(9, new Light(light.getName(), light.getImageId(), true));
                }
                if (recvMsg.contains("4-on")){
                    Light light = lightList.get(10);
                    lightList.set(10, new Light(light.getName(), light.getImageId(), true));
                }
                if (recvMsg.contains("2-on")){
                    Light light = lightList.get(11);
                    lightList.set(11, new Light(light.getName(), light.getImageId(), true));
                }

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                        if (i == 0){
                            Toast.makeText(view.getContext(), "刷新成功！", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(view.getContext(), "加载失败，请重新刷新！", Toast.LENGTH_SHORT).show();
                            i = 0;
                        }
                    }
                });


                try {
                    Thread.sleep(3000);
                    adapter.flag = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
