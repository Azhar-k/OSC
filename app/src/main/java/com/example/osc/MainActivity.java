package com.example.osc;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import static android.webkit.WebView.*;

public class MainActivity extends AppCompatActivity {
    private WebView webView1,webView2;
    private Toolbar toolbar;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //https://www.flipkart.com/search?q=jblt110
        //https://www.amazon.in/s?k=jblt110

        webView1=(WebView)findViewById(R.id.idmywebview);
        webView2=(WebView)findViewById(R.id.idmywebview2);
        searchView=(SearchView)findViewById(R.id.idSearchView);
        ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();

                webView1.getSettings().setJavaScriptEnabled(true);
                webView2.getSettings().setJavaScriptEnabled(true);

                webView1.loadUrl("https://www.flipkart.com/search?q="+s);
                webView2.loadUrl("https://www.amazon.in/s?k="+s);
                progressDialog.dismiss();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });





        /*webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                //webView.loadUrl("javascript:(function(){"+"var head=document.getElementsByClassName('header')[0].style.display='none';"+"})()");

                webView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByClassName('_3ybBIU')[0].style.display='none'; " +
                        "})()");


            }
        });*/
    }
}
