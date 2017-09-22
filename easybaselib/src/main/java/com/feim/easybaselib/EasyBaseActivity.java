package com.feim.easybaselib;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.feim.easybaselib.entity.EventCenter;
import com.feim.easybaselib.util.ActivityStackManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.ref.WeakReference;

/**
 * Created by SLF-001 on 2017/9/21.
 */

public abstract class EasyBaseActivity extends AppCompatActivity {

    public Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStackManager.getInstance().addActivity(new WeakReference<Activity>(this));

        EventBus.getDefault().register(this);
        Bundle extras = getIntent().getExtras();
        initContentView(savedInstanceState, extras);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (null != mToolbar) {
            initTitle();
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        initView();
        initLogic();
    }

    /**
     * 替代onCreate的使用
     */
    protected abstract void initContentView(Bundle savedInstanceState, Bundle extras);

    /**
     * 初始化标题
     */
    protected abstract void initTitle();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化逻辑
     */
    protected abstract void initLogic();

    /**
     * EventBus接收消息
     *
     * @param center 消息接收
     */
    @Subscribe
    public void onEventMainThread(EventCenter center) {
        if (null != center) {
            onEventComing(center);
        }
    }

    /**
     * EventBus接收消息
     *
     * @param center 获取事件总线信息
     */
    protected abstract void onEventComing(EventCenter center);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        ActivityStackManager.getInstance().removeActivity(new WeakReference<Activity>(this));
        super.onDestroy();
    }
}
