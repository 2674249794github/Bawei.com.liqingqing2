package com.example.mydemo_02;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private TextView textView;
    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_text = (TextView) findViewById(R.id.jieshou02);
        String html = "<font>我爱</font><img src=‘strawberry'><font>工作</font>";
        CharSequence text = Html.fromHtml(html, new Html.ImageGetter() {
            public Drawable getDrawable(String source) {
//根据图片资源ID获取图片
                Log.d("source", source);
                if (source.equals("‘strawberry'")) {
                    Drawable draw = getResources().getDrawable(R.mipmap.account_icon_kaixin);
                    draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
                    return draw;
                }
                return null;
            }
        }, null);
        tv_text.setText(text);


        webView = (WebView) findViewById(R.id.webView);
        MyWebViewClient myWebViewClient = new MyWebViewClient();
        webView.setWebViewClient(myWebViewClient);

    }
//    private String descString() {
//        return "八维" + "<img src='" + R.mipmap.account_icon_kaixin
//                + "'/>" + "教育" ;
//
//    }
//
    public void dianji(View view){
        StringBuffer sb = new StringBuffer("http://www.baidu八维考试.com");
        sb.deleteCharAt(sb.length()-8);
        sb.deleteCharAt(sb.length()-7);
        sb.deleteCharAt(sb.length()-6);
        sb.deleteCharAt(sb.length()-5);
        System.out.println(sb);
        webView.loadUrl(String.valueOf(sb));
    }
}
