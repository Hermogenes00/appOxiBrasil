package br.com.projeto_oxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class SobreActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sobre);

    }

    public void btnInstagram(View view) {
        redirecionaAplicativo("https://instagram.com/oxibrasiltelecom?igshid=1v1tr8acq2ov8");
    }

    public void btnFacebook(View view) {
        redirecionaAplicativo("https://www.facebook.com/brasilconect/");
    }

    public void btnChatWhatsApp(View view) {
        redirecionaAplicativo("https://api.whatsapp.com/send?phone=5575999656515");
    }

    public void redirecionaAplicativo(String caminho) {
        Uri uri = Uri.parse(caminho);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}