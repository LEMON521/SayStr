package com.ajohn.saystr.view.bottom_navigation_bar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ajohn.saystr.R;

import java.util.Map;

/**
 * Created by lemon on 2017/4/30.
 */

public class ViewBottomNavigationBar extends LinearLayout {
    private Context context;
    private View view;
    private LinearLayout ll_checked,ll_unchecked;
    private ImageView img_checked,img_unchecked;
    private TextView tv_checked;




    public ViewBottomNavigationBar(Context context) {
        super(context);
        this.context = context;
        initUI();
    }

    public ViewBottomNavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public ViewBottomNavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)//SDK版本为21时
    public ViewBottomNavigationBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }


    private void initUI(){
        view = LayoutInflater.from(context).inflate(R.layout.view_bottom_navigation_bar, this, true);
        ll_checked = (LinearLayout) view.findViewById(R.id.ll_checked);
        ll_unchecked = (LinearLayout) view.findViewById(R.id.ll_unchecked);
        img_checked = (ImageView) view.findViewById(R.id.img_checked);
        img_unchecked = (ImageView) view.findViewById(R.id.img_unchecked);
        tv_checked = (TextView) view.findViewById(R.id.tv_checked);
    }

    public void setData(Map<String ,String> viewData){
        String img_checked = "";
        String img_unchecked = "";
        String tv_checked="";
        String tv_color = "#";



        if (!viewData.isEmpty()) {//先判断是否为null
            img_checked = viewData.get("img_checked");
            img_unchecked = viewData.get("img_unchecked");
            tv_checked = viewData.get("tv_checked");
            tv_color = viewData.get("tv_color");
            if (!TextUtils.isEmpty(img_checked)) {
                this.img_checked.setImageResource(Integer.parseInt(img_checked));
            }
            if (!TextUtils.isEmpty(img_unchecked)) {
                this.img_unchecked.setImageResource(Integer.parseInt(img_unchecked));
            }
            if (!TextUtils.isEmpty(tv_checked)) {
                this.tv_checked.setText(tv_checked);
            }
            if (!TextUtils.isEmpty(tv_color)) {
                this.tv_checked.setTextColor(Color.parseColor(tv_color));
            }
        }

    }

    public void setChecked(){
        ll_checked.setVisibility(VISIBLE);
        ll_unchecked.setVisibility(GONE);
    }

    public void setUnChecked(){
        ll_checked.setVisibility(GONE);
        ll_unchecked.setVisibility(VISIBLE);
    }
}
