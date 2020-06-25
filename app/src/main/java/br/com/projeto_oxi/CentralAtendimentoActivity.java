package br.com.projeto_oxi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

public class CentralAtendimentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_atendimento);
    }


    public void btnChatWhatsApp(View view) {

        Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=5575999656515");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void btnEmail(View view) {

        String[] endereço = new String[]{"suporte@oxibrasiltelecom.com.br"};
        String assunto = "Solicitação de contato via app";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, endereço);
        intent.putExtra(Intent.EXTRA_SUBJECT, assunto);

        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivity(intent);

        } else {
            Toast.makeText(this, "Ops. Talvez você não tenha um app para realizar esta ação",Toast.LENGTH_SHORT).show();
        }


    }

    public void btnFixo(View view) {
        Uri uri = Uri.parse("tel:07521029222");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        intent.setData(uri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            return;
        }
    }

    ;
}