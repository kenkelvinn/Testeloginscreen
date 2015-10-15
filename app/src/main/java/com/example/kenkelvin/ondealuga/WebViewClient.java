package com.example.kenkelvin.ondealuga;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by KenKelvin on 14/10/2015.
 */
public class WebViewClient extends android.webkit.WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url){
        if(Uri.parse(url).getHost().endsWith("ondealuga.hol.es")){
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }

}
