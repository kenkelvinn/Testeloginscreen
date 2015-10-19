package com.example.kenkelvin.ondealuga;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by KenKelvin on 13/10/2015.
 */
public class DetalhesFragment extends android.support.v4.app.Fragment{


    private WebView OndeAlugaWebView;

    private static final String ARG_SECTION_NUMBER = "section_number";
    public static DetalhesFragment newInstance(int sectionNumber) {
        DetalhesFragment fragment = new DetalhesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public DetalhesFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sobre, container, false);

        OndeAlugaWebView = (WebView) rootView.findViewById(R.id.sobre_webview);
        OndeAlugaWebView.setInitialScale(1);
        OndeAlugaWebView.getSettings().setJavaScriptEnabled(true);
        OndeAlugaWebView.getSettings().setLoadWithOverviewMode(true);
        OndeAlugaWebView.getSettings().setUseWideViewPort(true);
        OndeAlugaWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        OndeAlugaWebView.setScrollbarFadingEnabled(false);
        OndeAlugaWebView.loadUrl("http://ondealuga.hol.es/listaken.php");
        OndeAlugaWebView.setWebViewClient(new WebViewClient(){
        });;

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
