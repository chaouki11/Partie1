package com.example.tp1androidstudioii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    ImageButton btncall;
    ImageButton btnnet;
    ImageButton btnperso;
    EditText txtwebsite;
    EditText txtphone;
    EditText txtchallenge1;
    EditText txtchallenge2;

    int somme;
    private int CALL_Perm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.CALL_PHONE}, CALL_Perm);
        btncall = (ImageButton) findViewById(R.id.btncall);
        btnnet = (ImageButton) findViewById(R.id.btnnet);

        btnperso = (ImageButton) findViewById(R.id.btnperso);
        txtphone = (EditText) findViewById(R.id.txtphone);
        txtwebsite = (EditText) findViewById(R.id.txtwebsite);
        txtchallenge1 = (EditText) findViewById(R.id.txtchallenge1);
        txtchallenge2 = (EditText) findViewById(R.id.txtchallenge2);




        btncall.setOnClickListener(new View.OnClickListener() {
                                       private int CALL_Perm;

                                       @Override
                                       public void onClick(View view) {

                                           Intent intent = new Intent(Intent.ACTION_CALL);
                                           intent.setData(Uri.parse("tel:" + txtphone.getText().toString()));
                                           startActivity(intent);


                                       }


                                   }


        );
        btnnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtchallenge1.getText().toString().equals("") && !txtchallenge2.getText().toString().equals("")) {

                    Intent intenttocall = new Intent(MainActivity.this, Check.class);

                    intenttocall.putExtra("txtchallenge1", Integer.parseInt(txtchallenge1.getText().toString()));
                    intenttocall.putExtra("txtchallenge2", Integer.parseInt(txtchallenge2.getText().toString()));
                    setResult(1, intenttocall);
                    somme = Integer.parseInt(txtchallenge1.getText().toString()) + Integer.parseInt(txtchallenge2.getText().toString());
                    Log.i("sommedenombres",""+somme);
                    startActivityForResult(intenttocall, 1);



                }

            }

        });
        btnperso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode==RESULT_OK  &&  data!=null) {

            int resultat = data.getIntExtra("somme",0);



            if (resultat == somme) {

                //String link =txtwebsite.getText().toString();

                Uri uri = Uri.parse("https://www.google.com");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));


            } else {
                Log.i("not woorking", "not done");

            }
        }

    }
}
