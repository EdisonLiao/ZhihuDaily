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

public class NewsItemPopup extends RelativeLayout {
    private int mRadius; //圆半径
    private int mBackgroundColor;//中心按钮的背景色

    public NewsItemPopup(Context context) {
        super(context);
    }

    public NewsItemPopup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context,attrs);
    }

    public NewsItemPopup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context,attrs);
    }

    public NewsItemPopup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
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
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int width = mRadius;
        int height = mRadius * 2;
        int centerChildWidth = getChildAt(0).getWidth();//第一个子view是中心的view
        if (centerChildWidth >= mRadius/2 ){
            throw new IllegalArgumentException("center view's width cannot bigger than raduis/2");
        }
        setMeasuredDimension((widthMode == MeasureSpec.EXACTLY) ? sizeWidth
                : width, (heightMode == MeasureSpec.EXACTLY) ? sizeHeight
                : height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int cCount = getChildCount();
        int cWidth = 0;
        int cHeight = 0;
        int cl = 0;
        int ct = 0;
        int cr = 0;
        int cb = 0;
        int cX = 0;
        int cY = 0;
        double angle = 0d;

        View centerView = getChildAt(0);//第一个是中心的view
        int centerX = centerView.getRight();
        int centerY = centerView.getTop() + centerView.getMeasuredHeight()/2;
        for (int i = 1;i < cCount;i++){
            View childView = getChildAt(i);
            cWidth = getChildAt(i).getMeasuredWidth();
            cHeight = getChildAt(i).getMeasuredHeight();
            switch (i){   //先做写死5个的吧，不折腾了
                case 1:
                    cX = centerX - (int) Math.round(mRadius * Math.sin(30d));
                    cY = centerY + (int) Math.round(mRadius * Math.cos(30d));

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
            }

        childView.layout(cl,ct,cr,cb);
        }

    }
}
