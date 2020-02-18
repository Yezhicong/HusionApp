package com.jay.fragmentdemo4;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userName;
    private EditText passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.parseColor ("#ffffff"));

        Button loginBt = findViewById(R.id.login_button);
        Button registerBt = findViewById(R.id.register_button);
        Button forgetBt = findViewById(R.id.forget_button);
        userName = findViewById(R.id.user_name);
        passWord = findViewById(R.id.password);

        loginBt.setOnClickListener(this);
        registerBt.setOnClickListener(this);
        forgetBt.setOnClickListener(this);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addCategory(Intent.CATEGORY_HOME);
            startActivity(i);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                userLogin();
                break;
            case R.id.register_button:
                Toast.makeText(this, "不给注册，哈哈哈!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.forget_button:
                Toast.makeText(this, "忘了就随缘吧!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    public void userLogin(){
        String user_name = userName.getText().toString();
        String password = passWord.getText().toString();

        if (user_name.equals("admin") && password.equals("123456")){
            finish();
        }else {
            Toast.makeText(this, "账号或密码错误!", Toast.LENGTH_LONG).show();
        }
    }
}
