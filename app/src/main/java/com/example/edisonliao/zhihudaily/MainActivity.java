package com.example.edisonliao.zhihudaily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.edisonliao.zhihudaily.entity.LastNewsStories;
import com.example.edisonliao.zhihudaily.entity.LastNewsTopStories;
import com.example.edisonliao.zhihudaily.presenter.MainActivityPresenter;
import com.example.edisonliao.zhihudaily.utils.GlideImageLoader;
import com.example.edisonliao.zhihudaily.view.IMainActivityView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainActivityView{

    private MainActivityPresenter mMainPresenter;
    @BindView(R.id.banner)
    Banner mBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (mMainPresenter == null){
            mMainPresenter = new MainActivityPresenter(this);
        }
        mMainPresenter.loadLastNews();
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
    public void showLastNews(LastNewsStories lastNewsStories) {

    }

    @Override
    protected void onDestroy() {
        mMainPresenter.detachView();//防止内存泄漏
        super.onDestroy();
    }
}
