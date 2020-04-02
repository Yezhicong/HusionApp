package com.jay.fragmentdemo4.ui.about;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jay.fragmentdemo4.R;


/**
 * Created by Jay on 2015/8/28 0028.
 */
public class AboutFragment extends Fragment  {

    //private Button logoutBt;

    /*private List<String> camera_list = new ArrayList<>();
    private ArrayAdapter< String> camera_adapter;

    private List<String> preset_list = new ArrayList<>();
    private ArrayAdapter< String> preset_adapter;

    private String presetId;
    private String cameraName;
    private boolean isSet = false;

    private CheckBox set_checkbox;
    private CheckBox call_checkbox;*/

    private SwipeRefreshLayout swipeRefreshLayout;
    private WebView webView;

    public AboutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fg_about, container,false);

        webView = view.findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.husion.cn");

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh1);
        swipeRefreshLayout.setColorSchemeResources(R.color.orange);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                webView.loadUrl("http://www.husion.cn");
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        /*final Context mContext = view.getContext();
        Spinner spin_camera = view.findViewById(R.id.camera_spinner);
        Spinner spin_preset = view.findViewById(R.id.camera_preset_id);
        DLRoundMenuView dlRoundMenuView = view.findViewById(R.id.dl_rmv);
        ImageView suoxiaoBt = view.findViewById(R.id.suoxiao_button);
        ImageView fangdaBt = view.findViewById(R.id.fangda_button);
        Button okBt = view.findViewById(R.id.ok_button);

        set_checkbox = view.findViewById(R.id.set_checkbox);
        call_checkbox = view.findViewById(R.id.call_checkbox);

        suoxiaoBt.setOnTouchListener(this);
        fangdaBt.setOnTouchListener(this);
        okBt.setOnTouchListener(this);

        set_checkbox.setOnCheckedChangeListener(this);
        call_checkbox.setOnCheckedChangeListener(this);

        camera_list.add("前摄像机");
        camera_list.add("后摄像机");
        camera_list.add("左摄像机");
        camera_list.add("右摄像机");

        preset_list.add("1");
        preset_list.add("2");
        preset_list.add("3");
        preset_list.add("4");
        preset_list.add("5");
        preset_list.add("6");

        camera_adapter = new ArrayAdapter<>(view.getContext(), R.layout.camera_spinner_selected_item, camera_list);
        camera_adapter.setDropDownViewResource(R.layout.camera_spinner_dropdown_item);
        spin_camera.setAdapter(camera_adapter);

        spin_camera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(mContext,"您选择的相机是：" + camera_adapter.getItem(position), Toast.LENGTH_SHORT).show();
                cameraName = camera_adapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        preset_adapter = new ArrayAdapter<>(view.getContext(), R.layout.camera_spinner_selected_item, preset_list);
        preset_adapter.setDropDownViewResource(R.layout.camera_spinner_dropdown_item);
        spin_preset.setAdapter(preset_adapter);

        spin_preset.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(mContext,"您选择的相机是：" + preset_adapter.getItem(position), Toast.LENGTH_SHORT).show();
                presetId = preset_adapter.getItem(position);
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
        });*/

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

    /*@Override
    @SuppressLint("ClickableViewAccessibility")
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
            case R.id.ok_button:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(v.getContext(), cameraName + (isSet ? "设置" : "调用") + "预置位" + presetId, Toast.LENGTH_SHORT).show();
                }
            break;
        }
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.set_checkbox:
                if (isChecked){
                    isSet = true;
                    call_checkbox.setChecked(false);
                }
            break;
            case R.id.call_checkbox:
                if (isChecked){
                    isSet = false;
                    set_checkbox.setChecked(false);
                }
            break;
        }
    }*/
}
