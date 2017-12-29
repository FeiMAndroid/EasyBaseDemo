package com.feim.easybasedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by feim on 2017/12/25.
 */

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.content_fl)
    FrameLayout content_fl;
    @BindView(R.id.to_placeholder_btn)
    Button to_placeholder_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_main, null, false);
        content_fl.addView(view);
        ButterKnife.bind(this);
        to_placeholder_btn.setText("aaaaaa");
    }

    @OnClick(value = {R.id.to_placeholder_btn})
    void btnClick(View v) {
        switch (v.getId()) {
            case R.id.to_placeholder_btn:
                Toast.makeText(TestActivity.this, "点击aaaaa", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
