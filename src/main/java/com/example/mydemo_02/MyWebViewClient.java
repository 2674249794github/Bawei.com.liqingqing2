package com.example.mydemo_02;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Liqf on 2017.09.27.
 */

public class MyWebViewClient extends WebViewClient {
    //重写父类方法，让新打开的网页在当前的WebView中显示
         public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
}
