package com.jay.fragmentdemo4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.jay.fragmentdemo4.MyClass.DLRoundMenuView;

//import com.dlong.rep.dlroundmenuview.DLRoundMenuView;
//import com.dlong.rep.dlroundmenuview.Interface.OnMenuClickListener;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment4 extends Fragment {

    //private Button logoutBt;
    private DLRoundMenuView dlRoundMenuView;

    public MyFragment4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fg_camera,container,false);


        dlRoundMenuView = view.findViewById(R.id.dl_rmv);
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


        //logoutBt = view.findViewById(R.id.logout_button);
        //logoutBt.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent = new Intent(v.getContext(), LoginActivity.class);
        //        startActivity(intent);
        //   }
        //});

        return view;
    }
}
