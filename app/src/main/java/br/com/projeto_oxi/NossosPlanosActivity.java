package br.com.projeto_oxi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class NossosPlanosActivity extends AppCompatActivity {

    ImageView imgView;
    PhotoViewAttacher photoView;
    FloatingActionButton btnWhatsapp;
    FloatingActionButton btnFixo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nossos_planos);

        btnFixo = findViewById(R.id.floatBtnFixo);
        btnWhatsapp = findViewById(R.id.floatBtnWhatsapp);

        btnFixo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFixo(v);
            }
        });


        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnChatWhatsApp(v);
            }
        });
    }

    public void redirecionaAplicativo(String caminho) {
        Uri uri = Uri.parse(caminho);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
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

    public void abrirImagem(View view) {

        switch (view.getId()) {
            case R.id.imageViewPlanosFibra:
                imgView = (ImageView) findViewById(R.id.imageViewPlanosFibra);
                photoView = new PhotoViewAttacher((ImageView) imgView);
                photoView.update();
                break;
            case R.id.imageViewQualRoteador:
                imgView = (ImageView) findViewById(R.id.imageViewQualRoteador);
                photoView = new PhotoViewAttacher((ImageView) imgView);
                photoView.update();
                break;
            case R.id.imageViewRoteadorMenor60:
                imgView = (ImageView) findViewById(R.id.imageViewRoteadorMenor60);
                photoView = new PhotoViewAttacher((ImageView) imgView);
                photoView.update();
                break;
            case R.id.imageViewRoteadorMaior60:
                imgView = (ImageView) findViewById(R.id.imageViewRoteadorMaior60);
                photoView = new PhotoViewAttacher((ImageView) imgView);
                photoView.update();
                break;

        }

    }

};
