package com.jay.fragmentdemo4.ui.computer;

import android.app.Dialog;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.jay.fragmentdemo4.R;
import com.jay.fragmentdemo4.View.CommomDialog;
import com.jay.fragmentdemo4.View.MyCommand;
import java.util.ArrayList;
import java.util.List;

public class ComputerAdapter extends RecyclerView.Adapter<ComputerAdapter.ViewHolder> {

    private List<Computer> mCompyterList;
    private List<MyCommand> CommandList = new ArrayList<>();
    private boolean flag = true;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View lightView;
        ImageView computerImage;
        TextView computerName;
        Switch switchId;

        public ViewHolder(View view){
            super(view);
            lightView = view;
            computerImage = view.findViewById(R.id.computer_image);
            computerName = view.findViewById(R.id.computer_name);
            switchId = view.findViewById(R.id.computer_switch_id);
        }
    }

    public ComputerAdapter(List<Computer> computerList) {
        mCompyterList = computerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.computer_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        CommandList.clear();
        initCommand();
        holder.switchId.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int position = holder.getAdapterPosition();
                //Light light = mLightList.get(position);
                //final MyCommand myCommand = CommandList.get(position);
                if(isChecked){
                    if (flag){
                        Log.i("TAG", "123");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Log.i("TAG", "321");
                            }
                        }, 2000);
                        //MySocket.TcpSocketConnect mySocket =  new MySocket.TcpSocketConnect(myCommand.getIp(), myCommand.getPort(), myCommand.getIsHex(), myCommand.getMsg() + "on");
                        //mySocket.start();
                    }
                }else {
                    new CommomDialog(view.getContext(), R.style.dialog, "确定关闭此电脑？", new CommomDialog.OnCloseListener() {
                        @Override
                        public void onClick(Dialog dialog, boolean confirm) {
                            if(confirm){
                                flag = true;
                                dialog.dismiss();
                            }else {
                                flag = false;
                                holder.switchId.setChecked(true);
                                dialog.dismiss();
                            }
                        }
                    }).setTitle("提示").show();
                    /*AlertDialog alertDialog = new AlertDialog.Builder(view.getContext())
                        .setTitle("是否关闭电脑?")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = false;
                                holder.switchId.setChecked(true);
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = true;
                                //MySocket.TcpSocketConnect mySocket =  new MySocket.TcpSocketConnect(myCommand.getIp(), myCommand.getPort(), myCommand.getIsHex(), myCommand.getMsg() + "off");
                                //mySocket.start();
                                dialog.dismiss();
                            }
                        }).create();
                    alertDialog.show();*/
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Computer computer = mCompyterList.get(position);
        holder.computerImage.setImageResource(computer.getImageId());
        holder.computerName.setText(computer.getName());
    }

    @Override
    public int getItemCount(){
        return mCompyterList.size();
    }

    public void initCommand(){
        MyCommand a1 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-01-on");
        CommandList.add(a1);
        MyCommand a2 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-01-off");
        CommandList.add(a2);
        MyCommand a3 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-02-on");
        CommandList.add(a3);
        MyCommand a4 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-02-off");
        CommandList.add(a4);
        MyCommand a5 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-03-on");
        CommandList.add(a5);
        MyCommand a6 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-03-off");
        CommandList.add(a6);
        MyCommand a7 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-04-on");
        CommandList.add(a7);
        MyCommand a8 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-04-off");
        CommandList.add(a8);
        MyCommand a9 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-05-on");
        CommandList.add(a9);
        MyCommand a10 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-05-off");
        CommandList.add(a10);
        MyCommand a11 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-06-on");
        CommandList.add(a11);
        MyCommand a12 = new MyCommand("192.168.88.247", 4800, false, "HS-REL-setrelay-06-off");
        CommandList.add(a12);
        MyCommand a13 = new MyCommand("192.168.88.220", 4800, false, "HS-REL-setrelay-03-");
        CommandList.add(a13);
    }

}
