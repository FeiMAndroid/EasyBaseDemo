package com.feim.easybaselib.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.feim.easybaselib.R;
import com.feim.easybaselib.callback.EmptyCallback;
import com.feim.easybaselib.callback.ErrorCallback;
import com.feim.easybaselib.callback.LoadingCallback;
import com.feim.easybaselib.callback.PlaceholderCallback;
import com.feim.easybaselib.callback.TimeoutCallback;
import com.feim.easybaselib.entity.EventCenter;
import com.feim.easybaselib.util.ActivityStackManager;
import com.feim.easybaselib.util.EmptyUtils;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by SLF-001 on 2017/9/21.
 */

public abstract class EasyBaseActivity extends SupportActivity implements Toolbar.OnMenuItemClickListener {

    protected Context mContext;
    protected Toolbar mToolbar;
    protected FrameLayout mContent;
    protected LoadService loadService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_base);
        mContext = this;
        ActivityStackManager.getInstance().addActivity(new WeakReference<Activity>(this));

        EventBus.getDefault().register(this);
        Bundle extras = getIntent().getExtras();

        mContent = (FrameLayout) findViewById(R.id.content);
        View view = LayoutInflater.from(this).inflate(initContentView(savedInstanceState, extras), mContent, false);
        mContent.addView(view);
        ButterKnife.bind(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        String mTitle = initTitle();
        if (EmptyUtils.isEmpty(mTitle)) {
            mToolbar.setVisibility(View.GONE);
        } else {
            setTitle(mTitle);
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setOnMenuItemClickListener(this);
        }

        initView();
        initLogic();
    }

    /**
     * 替代onCreate的使用
     */
    @LayoutRes
    protected abstract int initContentView(Bundle savedInstanceState, Bundle extras);

    /**
     * 初始化标题
     */
    @Nullable
    protected abstract String initTitle();

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

    /**
     * 设置menu资源id
     *
     * @return menu资源id
     */
    @MenuRes
    protected abstract int initMenuRes();

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int menuId = initMenuRes();
        if (menuId != 0) {
            getMenuInflater().inflate(initMenuRes(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

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

    protected void showLoading() {
        if (loadService == null) {
            loadService = LoadSir.getDefault().register(mContent, new Callback.OnReloadListener() {
                @Override
                public void onReload(View v) {
                    initLogic();
                }
            });
        }
        loadService.showCallback(LoadingCallback.class);
    }

    protected void showPlaceHolder() {
        if (loadService == null) {
            loadService = LoadSir.getDefault().register(mContent, new Callback.OnReloadListener() {
                @Override
                public void onReload(View v) {
                    initLogic();
                }
            });
        }
        loadService.showCallback(PlaceholderCallback.class);
    }

    protected void showEmpty() {
        loadService.showCallback(EmptyCallback.class);
    }

    protected void showTimeout() {
        loadService.showCallback(TimeoutCallback.class);
    }

    protected void showError() {
        loadService.showCallback(ErrorCallback.class);
    }

    protected void showSuccess() {
        loadService.showSuccess();
    }
}
