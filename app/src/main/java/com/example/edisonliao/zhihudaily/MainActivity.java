package com.example.edisonliao.zhihudaily;

import android.content.Intent;
import android.graphics.Rect;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.edisonliao.zhihudaily.adapters.NewsAdapter;
import com.example.edisonliao.zhihudaily.entity.LastNewsStories;
import com.example.edisonliao.zhihudaily.entity.LastNewsTopStories;
import com.example.edisonliao.zhihudaily.entity.NewsItemData;
import com.example.edisonliao.zhihudaily.presenter.MainActivityPresenter;
import com.example.edisonliao.zhihudaily.ui.NewsScrollView;
import com.example.edisonliao.zhihudaily.utils.GlideImageLoader;
import com.example.edisonliao.zhihudaily.view.IMainActivityView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IMainActivityView,View.OnClickListener{

    private MainActivityPresenter mMainPresenter;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.recyclerView)
    RecyclerView mRecycleView;
    @BindView(R.id.scrollView)
    NewsScrollView mScrollView;
    @BindView(R.id.news_type_tv)
    TextView mNewsTypeTv;
//    @BindView(R.id.float_button)
//    FloatingActionButton mFbutton;
    private NewsAdapter mAdapter;
    private Rect mRect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (mMainPresenter == null){
            mMainPresenter = new MainActivityPresenter(this);
        }
        mRecycleView.setNestedScrollingEnabled(false);
        mScrollView.addScrollOverBannerLisenter(mScrollLinstener);
        initRecyclerView();
        mMainPresenter.loadLastNews();
    }


    private NewsScrollView.ScrollOverBannerListener mScrollLinstener = new NewsScrollView.ScrollOverBannerListener() {
        @Override
        public void scrollOverBanner() {
            setTitleText(mNewsTypeTv.getText().toString());
        }

        @Override
        public void scrollReturnToTop() {
            setTitleText(getResources().getString(R.string.app_name));
        }
    };

    private void initRecyclerView(){
        if (mAdapter == null){
            mAdapter = new NewsAdapter(this);
        }
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(mAdapter);
    }

    /**
     * 最新消息的banner显示
     * @param lastNewsTopStories
     */
    @Override
    public void showLastNewsBannerImg(List<LastNewsTopStories> lastNewsTopStories) {
        List<String> list = new ArrayList<>();
        for (LastNewsTopStories stories : lastNewsTopStories){
            list.add(stories.getImage());
        }

        mBanner.setImageLoader(GlideImageLoader.getInstance());
        mBanner.isAutoPlay(true);
        mBanner.setDelayTime(1500);
        mBanner.setImages(list);
        mBanner.start();
    }

    /**
     * 最新消息的新闻列表
     * @param lastNewsStories
     */
    @Override
    public void showLastNews(List<LastNewsStories> lastNewsStories) {
        List<NewsItemData> list = new ArrayList<>();
        for (LastNewsStories stories : lastNewsStories){
            NewsItemData data = new NewsItemData();
            if(stories.getImages().size() > 0){
                data.setImgUrl(stories.getImages().get(0));
            }
            data.setTxt(stories.getTitle());
            data.setId(stories.getId());
            list.add(data);
        }
        mAdapter.updateList(list);
    }

    @Override
    protected void onDestroy() {
        mMainPresenter.detachView();//防止内存泄漏
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){

        }
    }
}
