package com.feim.easybasedemo;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.feim.easybaselib.activity.EasyBaseActivity;
import com.feim.easybaselib.entity.EventCenter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends EasyBaseActivity {

    private RecyclerView recyclerView;
    private List<String> mData;
    private MyRecyclerAdapter recycleAdapter;

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
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        initData();
        recycleAdapter = new MyRecyclerAdapter(MainActivity.this, mData);
        recyclerView.setAdapter(recycleAdapter);
    }

    @Override
    protected void initLogic() {
    }

    @Override
    protected void onEventComing(EventCenter center) {

    }

    @Override
    protected int getMenuRes() {
        return R.menu.addr_toolbar_menu;
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Toast.makeText(mContext,"点击",Toast.LENGTH_SHORT).show();
        return super.onMenuItemClick(menuItem);
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add("HODV-21194"); //0
        mData.add("TEK-080"); //1
        mData.add("IPZ-777"); //2
        mData.add("MIMK-045"); //3
        mData.add("HODV-21193"); //4
        mData.add("MIDE-339"); //5
        mData.add("IPZ-780"); //6
        mData.add("VEC-205"); //7
        mData.add("VEMA-113"); //8
        mData.add("IPZ-776"); //9
        mData.add("MIAD-923"); //10
        mData.add("ARM-513"); //11
    }
}
