package com.example.edisonliao.zhihudaily.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by EdisonLiao on 2018/2/7.
 */

public class NewsScrollView extends ScrollView {
    private static final String TAG = "NewsScrollView";
    private float mLastX;
    private float mLastY;
    private ScrollOverBannerListener mScrollListener;


    public interface ScrollOverBannerListener{
        void scrollOverBanner();
    }

    public void addScrollOverBannerLisenter(ScrollOverBannerListener listener){
        mScrollListener = listener;
    }

    public NewsScrollView(Context context) {
        super(context);
    }

    public NewsScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NewsScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NewsScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

    private int dp2px(Context context,float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5f);
    }

}
