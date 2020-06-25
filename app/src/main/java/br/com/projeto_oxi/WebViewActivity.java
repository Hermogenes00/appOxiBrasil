package br.com.projeto_oxi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webViewSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webViewSite = (WebView) findViewById(R.id.webViewSite);

        Intent intent = getIntent();
        String caminho_recebido = intent.getStringExtra(MainActivity.CAMINHO).toString();
        carregarWebView(caminho_recebido);
    }

    public void carregarWebView(String caminho) {

        Uri uri_caminho = Uri.parse(caminho);
        
        webViewSite.getSettings().setJavaScriptEnabled(true);
        webViewSite.getSettings().setDomStorageEnabled(true);
        webViewSite.getSettings().setLoadsImagesAutomatically(true);

        webViewSite.loadUrl(uri_caminho.toString());
    }
}