package com.example.edisonliao.zhihudaily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.edisonliao.zhihudaily.entity.NewsDetailResponse;
import com.example.edisonliao.zhihudaily.presenter.NewsDetailPresenter;
import com.example.edisonliao.zhihudaily.utils.GlideUtil;
import com.example.edisonliao.zhihudaily.view.INewsDetailActivityView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends BaseActivity implements INewsDetailActivityView{

    @BindView(R.id.detail_iv)
    ImageView mImageView;
    @BindView(R.id.detail_webview)
    WebView mWebView;
    private NewsDetailPresenter mPresenter;
    private int id;
    private String CSS_TAG = "<link rel=\"stylesheet\" type=\"text/css\" href=\"%s\"/>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
        id = getIntent().getIntExtra("id",9670913);
        String title = getIntent().getStringExtra("title");
        setTitleText(title);
        mPresenter = new NewsDetailPresenter(this,id);
        initWebView();
        mPresenter.loadNewsDetail();
    }

    private void initWebView(){
        //声明WebSettings子类
        WebSettings webSettings = mWebView.getSettings();
//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
//设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
//缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
//其他细节操作
        webSettings.setTextZoom(200);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
    }

    @Override
    public void showNewsDetail(NewsDetailResponse newsDetail) {
        GlideUtil.getInstance().loadImgWithUrl(this,newsDetail.getImage(),mImageView);
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append(String.format(CSS_TAG,newsDetail.getCss().get(0)));
        sb.append("</head>");

        sb.append("<body>");
        sb.append(newsDetail.getBody());
        sb.append("</body>");
        sb.append("</html>");
        mWebView.loadData(sb.toString(), "text/html;charset=utf-8","utf-8");
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }
}
