package com.feim.easybasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.feim.easybaselib.activity.EasyBaseActivity;
import com.feim.easybaselib.entity.EventCenter;


import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends EasyBaseActivity {

    @BindView(R.id.to_placeholder_btn)
    Button to_placeholder_btn;

    @Override
    protected int initContentView(Bundle savedInstanceState, Bundle extras) {
        return R.layout.activity_main;
    }

    @Override
    protected String initTitle() {
        return "首页";
    }

    @Override
    protected void initView() {
    }

    @OnClick(value = {R.id.to_placeholder_btn,R.id.to_loading_btn})
    void btnClick(View v) {
        switch (v.getId()) {
            case R.id.to_placeholder_btn:
                startActivity(new Intent(this,PlaceHolderActivity.class));
                break;
            case R.id.to_loading_btn:
                startActivity(new Intent(this,LoadingActivity.class));
                break;
        }
    }

    @Override
    protected void initLogic() {
    }

    @Override
    protected void onEventComing(EventCenter center) {

    }

    @Override
    protected int initMenuRes() {
        return R.menu.addr_toolbar_menu;
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(mContext, "点击" + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onMenuItemClick(menuItem);
    }
}
