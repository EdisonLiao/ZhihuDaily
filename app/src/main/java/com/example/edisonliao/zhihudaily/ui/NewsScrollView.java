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
    private Context mContext;
    private boolean mIsOverBanner = false;

    public interface ScrollOverBannerListener{
        void scrollOverBanner();//向下滑动距离超过了banner的高度，banner不可见
        void scrollReturnToTop();//向上滑动，banner回到原位置，banner可见
    }

    public void addScrollOverBannerLisenter(ScrollOverBannerListener listener){
        mScrollListener = listener;
    }

    public NewsScrollView(Context context) {
        super(context);
        mContext = context;
    }

    public NewsScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public NewsScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public NewsScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Log.e(TAG,"t..." + t);
        Log.e(TAG,"oldt..." + oldt);
        int bannerHeight = dp2px(mContext,150);
        if (t >= bannerHeight){
            mIsOverBanner = true;
            mScrollListener.scrollOverBanner();
        }else if (t <= bannerHeight/2){
            if (mIsOverBanner) {
                mIsOverBanner = false;
                mScrollListener.scrollReturnToTop();
            }
        }
    }

    private int dp2px(Context context,float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5f);
    }

}
