package com.jay.fragmentdemo4.ui.air;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.jay.fragmentdemo4.R;
import com.jay.fragmentdemo4.View.MyCommand;
import com.jay.fragmentdemo4.socket.MySocket;

import java.util.ArrayList;
import java.util.List;

public class AirAdapter extends RecyclerView.Adapter<AirAdapter.ViewHolder> {

    private List<Air> mAirList;
    private List<MyCommand> CommandList = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder{
        View airView;
        ImageView airImage;
        TextView airName;
        Switch switchId;
        RadioGroup radioGroup;
        RadioButton radioButton_16;
        RadioButton radioButton_22;
        RadioButton radioButton_26;

        public ViewHolder(View view){
            super(view);
            airView = view;
            airImage = view.findViewById(R.id.air_image);
            airName = view.findViewById(R.id.air_name);
            switchId = view.findViewById(R.id.air_switch_id);
            radioGroup = view.findViewById(R.id.rg);
            radioButton_16 = view.findViewById(R.id.button_16);
            radioButton_22 = view.findViewById(R.id.button_22);
            radioButton_26 = view.findViewById(R.id.button_26);
        }
    }

    public AirAdapter(List<Air> airList) {
        mAirList = airList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.air_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        CommandList.clear();
        initCommand();
        holder.switchId.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int position = holder.getAdapterPosition();
                if(isChecked){
                    MyCommand myCommand = CommandList.get(position * 3);
                    MySocket.TcpSocketConnect mySocket =  new MySocket.TcpSocketConnect(myCommand.getIp(), myCommand.getPort(), myCommand.getIsHex(), myCommand.getMsg());
                    mySocket.start();
                    holder.radioButton_16.setEnabled(true);
                    holder.radioButton_22.setEnabled(true);
                    holder.radioButton_26.setEnabled(true);
                    holder.radioButton_22.setChecked(true);
                }else {
                    MyCommand myCommand = CommandList.get(position * 3 + 2);
                    MySocket.TcpSocketConnect mySocket =  new MySocket.TcpSocketConnect(myCommand.getIp(), myCommand.getPort(), myCommand.getIsHex(), myCommand.getMsg());
                    mySocket.start();
                    holder.radioGroup.clearCheck();
                    holder.radioButton_16.setEnabled(false);
                    holder.radioButton_22.setEnabled(false);
                    holder.radioButton_26.setEnabled(false);
                }
            }
        });
        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                int position = holder.getAdapterPosition();
                if(checkedId == R.id.button_16 || checkedId == R.id.button_22){
                    MyCommand myCommand = CommandList.get(position * 3);
                    MySocket.TcpSocketConnect mySocket =  new MySocket.TcpSocketConnect(myCommand.getIp(), myCommand.getPort(), myCommand.getIsHex(), myCommand.getMsg());
                    mySocket.start();
                }
                if(checkedId == R.id.button_26){
                    MyCommand myCommand = CommandList.get(position * 3 + 1);
                    MySocket.TcpSocketConnect mySocket =  new MySocket.TcpSocketConnect(myCommand.getIp(), myCommand.getPort(), myCommand.getIsHex(), myCommand.getMsg());
                    mySocket.start();
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Air air = mAirList.get(position);
        holder.airImage.setImageResource(air.getImageId());
        holder.airName.setText(air.getName());
        holder.radioButton_16.setEnabled(false);
        holder.radioButton_22.setEnabled(false);
        holder.radioButton_26.setEnabled(false);
    }

    @Override
    public int getItemCount(){
        return mAirList.size();
    }

    public void initCommand(){

        MyCommand a1 = new MyCommand("192.168.88.226", 4800, false, "HS-DNC-sndir-02-002");
        CommandList.add(a1);
        MyCommand a2 = new MyCommand("192.168.88.226", 4800, false, "HS-DNC-sndir-02-001");
        CommandList.add(a2);
        MyCommand a3 = new MyCommand("192.168.88.226", 4800, false, "HS-DNC-sndir-02-003");
        CommandList.add(a3);

        MyCommand a4 = new MyCommand("192.168.88.226", 4800, false, "HS-DNC-sndir-03-002");
        CommandList.add(a4);
        MyCommand a5 = new MyCommand("192.168.88.226", 4800, false, "HS-DNC-sndir-03-001");
        CommandList.add(a5);
        MyCommand a6 = new MyCommand("192.168.88.226", 4800, false, "HS-DNC-sndir-03-003");
        CommandList.add(a6);

        MyCommand a7 = new MyCommand("192.168.88.226", 4800, false, "HS-DNC-sndir-01-002");
        CommandList.add(a7);
        MyCommand a8 = new MyCommand("192.168.88.226", 4800, false, "HS-DNC-sndir-01-001");
        CommandList.add(a8);
        MyCommand a9 = new MyCommand("192.168.88.226", 4800, false, "HS-DNC-sndir-01-003");
        CommandList.add(a9);

        MyCommand a10 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-08-002");
        CommandList.add(a10);
        MyCommand a11 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-08-001");
        CommandList.add(a11);
        MyCommand a12 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-08-003");
        CommandList.add(a12);

        MyCommand a13 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-07-002");
        CommandList.add(a13);
        MyCommand a14 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-07-001");
        CommandList.add(a14);
        MyCommand a15 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-07-003");
        CommandList.add(a15);

        MyCommand a16 = new MyCommand("192.168.88.225", 4800, false, "HS-DNC-sndir-03-002");
        CommandList.add(a16);
        MyCommand a17 = new MyCommand("192.168.88.225", 4800, false, "HS-DNC-sndir-03-001");
        CommandList.add(a17);
        MyCommand a18 = new MyCommand("192.168.88.225", 4800, false, "HS-DNC-sndir-03-003");
        CommandList.add(a18);

        MyCommand a19 = new MyCommand("192.168.88.225", 4800, false, "HS-DNC-sndir-02-002");
        CommandList.add(a19);
        MyCommand a20 = new MyCommand("192.168.88.225", 4800, false, "HS-DNC-sndir-02-001");
        CommandList.add(a20);
        MyCommand a21 = new MyCommand("192.168.88.225", 4800, false, "HS-DNC-sndir-02-003");
        CommandList.add(a21);

        MyCommand a22 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-01-002");
        CommandList.add(a22);
        MyCommand a23 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-01-001");
        CommandList.add(a23);
        MyCommand a24 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-01-003");
        CommandList.add(a24);

        MyCommand a25 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-05-002");
        CommandList.add(a25);
        MyCommand a26 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-05-001");
        CommandList.add(a26);
        MyCommand a27 = new MyCommand("192.168.88.224", 4800, false, "HS-DNC-sndir-05-003");
        CommandList.add(a27);
    }

}
