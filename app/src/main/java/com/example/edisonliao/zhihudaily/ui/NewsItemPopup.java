package com.example.edisonliao.zhihudaily.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.PopupWindowCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.edisonliao.zhihudaily.R;


/**
 * Created by EdisonLiao on 2018/2/10.
 */

public class NewsItemPopup extends ViewGroup {
    private int mRadius; //圆半径
    private int mBackgroundColor;//中心按钮的背景色
    private Context mContext;
    private int mWidth;
    private int mHeight;

    public NewsItemPopup(Context context) {
        super(context);
    }

    public NewsItemPopup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initAttrs(context,attrs);
    }

    public NewsItemPopup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initAttrs(context,attrs);
    }

    private void initAttrs(Context context,AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.NewsItemPopup);
        mRadius = ta.getDimensionPixelSize(R.styleable.NewsItemPopup_circle_radius,100);
        mBackgroundColor = ta.getColor(R.styleable.NewsItemPopup_center_background_color,
                context.getResources().getColor(R.color.colorAccent));
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);

        int width = mRadius;
        int height = mRadius * 2;
        int centerChildWidth = getChildAt(1).getMeasuredWidth();//第一个子view是中心的view
        if (centerChildWidth >= mRadius/2 ){
            throw new IllegalArgumentException("center view's width cannot bigger than raduis/2");
        }

        mWidth = (widthMode == MeasureSpec.EXACTLY) ? sizeWidth : width;
        mHeight = (heightMode == MeasureSpec.EXACTLY) ? sizeHeight : height;
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int cCount = getChildCount();
        int cl = 0;
        int ct = 0;
        int cr = 0;
        int cb = 0;

        int centerX = mWidth;
        int centerY = mHeight/2;
        for (int i = 0;i < cCount;i++){
            View childView = getChildAt(i);
            switch (i){   //先做写死5个的吧，不折腾了
                case 0:
                    cl = mWidth - childView.getMeasuredWidth();
                    ct = mHeight/2 - childView.getMeasuredHeight()/2;
                    cb = mHeight/2 + childView.getMeasuredHeight()/2;
                    cr = mWidth;
                    break;
                case 1:
                    cl = centerX - (int) Math.round(mRadius * Math.sin(Math.toRadians(30d)));
                    cb = centerY + (int) Math.round(mRadius * Math.cos(Math.toRadians(30d)));
                    ct = cb - childView.getMeasuredHeight();
                    cr = cl + childView.getMeasuredWidth();
                    break;
                case 2:
                    cl = centerX - (int) Math.round(mRadius * Math.sin(Math.toRadians(60d)));
                    cb = centerY + (int) Math.round(mRadius * Math.cos(Math.toRadians(60d)));
                    ct = cb - childView.getMeasuredHeight();
                    cr = cl + childView.getMeasuredWidth();
                    break;
                case 3:
                    cl = 0;
                    cb = centerY;
                    ct = cb - childView.getMeasuredHeight();
                    cr = cl + childView.getMeasuredWidth();
                    break;
                case 4:
                    ct = centerY - (int) Math.round(mRadius * Math.cos(Math.toRadians(60d)));
                    cl = centerX - (int) Math.round(mRadius * Math.sin(Math.toRadians(60d)));
                    cr = cl + childView.getMeasuredWidth();
                    cb = ct + childView.getMeasuredHeight();
                    break;
                case 5:
                    ct = centerY - (int) Math.round(mRadius * Math.cos(Math.toRadians(30d)));
                    cl = centerX - (int) Math.round(mRadius * Math.sin(Math.toRadians(30d)));
                    cr = cl + childView.getMeasuredWidth();
                    cb = ct + childView.getMeasuredHeight();
                    break;
            }
            childView.layout(cl,ct,cr,cb);
        }

    }
}
