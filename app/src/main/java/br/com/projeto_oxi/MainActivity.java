package br.com.projeto_oxi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String CAMINHO = "CAMINHO_SITE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamarWebView(String caminho_url) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(CAMINHO, caminho_url);
        startActivity(intent);
    }

    public void redirecionarParaAplicativo(String packageName, String avisoNomeApp) {

        Intent intent;
        final String pacote = packageName;

        //Se for o whatsapp apenas redireciona para o aplicativo
        if (packageName.equals("https://api.whatsapp.com/send?phone=5575999656515")) {
            Uri uri = Uri.parse(pacote);
            intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else {

            //Pego o packageName baseado no que já tenho instalado no android
            intent = getPackageManager().getLaunchIntentForPackage(pacote);

            //Verifico se de fato o nome do pacote existe no android em questão
            if (intent != null) {
                startActivity(intent);
            } else {

                AlertDialog.Builder alerta = new AlertDialog.Builder(this);

                alerta.setTitle("Alerta");
                alerta.setMessage("Para realizar esta ação, será necessário baixar o app " + avisoNomeApp);

                //Utilizando Lambda no segundo parâmetro
                alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Caso não existe eu concateno o pacote com a url da playstore, para que possa ser redirecionado para baixar o app.

                        StringBuilder sb = new StringBuilder("https://play.google.com/store/apps/details?id=");
                        sb.append(pacote);

                        Uri uri = Uri.parse(sb.toString());
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });

                //Utilizando Lambda no segundo parâmetro
                alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });

                alerta.show();
            }
        }
    }

    public void onClickTesteVelocidade(View view) {
        chamarWebView("http://jsaplication.speedtestcustom.com/");
    }

    public void onClickSegundaViaBoleto(View view) {
        onClickAreaCliente(view);
    }

    public void onClickSite(View view) {
        chamarWebView("https://crm.oxibrasiltelecom.com.br/");
    }

    public void onClickNovidade(View view) {
        chamarWebView("https://crm.oxibrasiltelecom.com.br/news");
    }

    public void onClickAreaCliente(View view) {
        chamarWebView("https://crm.oxibrasiltelecom.com.br/central_assinante_web/");
    }

    public void onClickRedeSocial(View view) {

        Intent intent = new Intent(this, RedeSocialActivity.class);
        startActivity(intent);
    }

    public void onClickSobre(View view) {
        Intent intent = new Intent(this, SobreActivity.class);
        startActivity(intent);
    }

    public void onClickAparelhosConectados(View view) {

        redirecionarParaAplicativo("com.overlook.android.fing", "Fing");
        //redirecionarParaAplicativo("https://play.google.com/store/apps/details?id=com.overlook.android.fing");
    }

    public void onClickChatWhatsapp(View view) {
        redirecionarParaAplicativo("https://api.whatsapp.com/send?phone=5575999656515", "Analisador de Canal Wifi");
    }

    public void onClickNivelSinalWifi(View view) {
        redirecionarParaAplicativo("com.wifi.signal.wifisignalmeter.wifisignalbooster", "Medidor de Sinal.");
    }

    public void onClickNossosPlanos(View view) {
        Intent intent = new Intent(this, NossosPlanosActivity.class);
        startActivity(intent);
    }

    public void onClickCentralAtendimento(View view) {
        Intent intent = new Intent(this, CentralAtendimentoActivity.class);
        startActivity(intent);
    }

    public void onClickAnalisadorCanal(View view) {
        redirecionarParaAplicativo("com.wifianalyzer.networktools.wifitest", "Analisador de Canal");
    }

}