package com.example.edisonliao.zhihudaily;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {

    private TextView mTitleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        View view = LayoutInflater.from(this).inflate(R.layout.action_bar_item,null);
        mTitleTv = (TextView) view.findViewById(R.id.trans_tv);
        actionBar.setCustomView(view);
    }

    public void setTitleText(String txt){
        mTitleTv.setText(txt);
    }
}
