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
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        int x = (int) ev.getX();
        int y = (int)ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN: {
                intercept = false;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                Log.e(TAG,"name1..." + getChildAt(1).getVisibility());
//                if () {
//                    intercept = true;
//                } else {
//                    intercept = false;
//                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                intercept = false;
                break;
            }
            default:
                break;
        }

        mLastY = y;
        mLastX = x;
        return intercept;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
