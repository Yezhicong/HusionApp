package com.jay.fragmentdemo4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.jay.fragmentdemo4.MyClass.MyCommand;
import java.util.ArrayList;
import java.util.List;

public class LightAdapter extends RecyclerView.Adapter<LightAdapter.ViewHolder> {

    private List<Light> mLightList;
    private List<MyCommand> CommandList = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder{
        View lightView;
        ImageView lightImage;
        TextView lightName;
        Switch switchId;

        public ViewHolder(View view){
            super(view);
            lightView = view;
            lightImage = view.findViewById(R.id.light_image);
            lightName = view.findViewById(R.id.light_name);
            switchId = view.findViewById(R.id.light_switch_id);
        }
    }

    public LightAdapter(List<Light> lightList) {
        mLightList = lightList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.light_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        CommandList.clear();
        initCommand();
        holder.switchId.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int position = holder.getAdapterPosition();
                //Light light = mLightList.get(position);
                MyCommand myCommand = CommandList.get(position);
                if(isChecked){
                    MySocket.TcpSocketConnect mySocket =  new MySocket.TcpSocketConnect(myCommand.getIp(), myCommand.getPort(), myCommand.getIsHex(), myCommand.getMsg());
                    mySocket.start();
                }else {
                    MySocket.TcpSocketConnect mySocket =  new MySocket.TcpSocketConnect(myCommand.getIp(), myCommand.getPort(), myCommand.getIsHex(), myCommand.getMsg() + "off");
                    mySocket.start();
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Light light = mLightList.get(position);
        holder.lightImage.setImageResource(light.getImageId());
        holder.lightName.setText(light.getName());
    }

    @Override
    public int getItemCount(){
        return mLightList.size();
    }

    public void initCommand(){
        MyCommand a1 = new MyCommand("192.168.88.221", 4800, 0, "HS-REL-setrelay-03-");
        CommandList.add(a1);
        MyCommand a2 = new MyCommand("192.168.88.221", 4800, 0, "HS-REL-setrelay-05-");
        CommandList.add(a2);
        MyCommand a3 = new MyCommand("192.168.88.221", 4800, 0, "HS-REL-setrelay-04-");
        CommandList.add(a3);
        MyCommand a4 = new MyCommand("192.168.88.221", 4800, 0, "HS-REL-setrelay-07-");
        CommandList.add(a4);
        MyCommand a5 = new MyCommand("192.168.88.220", 4800, 0, "HS-REL-setrelay-05-");
        CommandList.add(a5);
        MyCommand a6 = new MyCommand("192.168.88.221", 4800, 0, "HS-REL-setrelay-01-");
        CommandList.add(a6);
        MyCommand a7 = new MyCommand("192.168.88.221", 4800, 0, "HS-REL-setrelay-02-");
        CommandList.add(a7);
        MyCommand a8 = new MyCommand("192.168.88.223", 4800, 0, "HS-REL-getrelay-03");
        CommandList.add(a8);
        MyCommand a9 = new MyCommand("192.168.88.223", 4800, 0, "HS-REL-setrelay-06-");
        CommandList.add(a9);
        MyCommand a10 = new MyCommand("192.168.88.223", 4800, 0, "HS-REL-setrelay-05-");
        CommandList.add(a10);
        MyCommand a11 = new MyCommand("192.168.88.223", 4800, 0, "HS-REL-setrelay-04-");
        CommandList.add(a11);
        MyCommand a12 = new MyCommand("192.168.88.223", 4800, 0, "HS-REL-setrelay-02-");
        CommandList.add(a12);
        MyCommand a13 = new MyCommand("192.168.88.220", 4800, 0, "HS-REL-setrelay-03-");
        CommandList.add(a13);
    }

}
