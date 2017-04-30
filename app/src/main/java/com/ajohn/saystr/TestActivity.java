package com.ajohn.saystr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.common.util.LogUtil;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by lemon on 2017/4/28.
 */
@ContentView(R.layout.test_activity)
public class TestActivity extends FragmentActivity {
    @ViewInject(R.id.bottom_img)
    private ImageView bottom_img;
    @ViewInject(R.id.bottom_tv)
    private TextView bottom_tv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        LogUtil.e("-------------测试页面--------------");


    }

    private boolean click = true;

    @Event(value = {R.id.bottom_img})
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_img:
                if (click) {
                    bottom_tv.setVisibility(View.GONE);
                    click = false;
                } else {
                    bottom_tv.setVisibility(View.VISIBLE);
                    click = true;
                }
                break;
        }
    }

}
