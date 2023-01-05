package com.example.tp1androidstudioii;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    Button btncanc;
    Button btnokk;
    EditText txtusername;
    EditText txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        txtpassword=(EditText) findViewById(R.id.txtpassword);
        txtusername = (EditText) findViewById(R.id.txtusername);

        btnokk = (Button) findViewById(R.id.btnokk);
        btncanc = (Button) findViewById(R.id.btncanc);
        btnokk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(txtusername.getText().toString() ==("chaouki") && txtpassword.getText().toString()==("chaouki")){
                      Log.i("successsss","sucess");
                      Toast.makeText(Login.this,"appel",Toast.LENGTH_SHORT).show();
                      finish();
                    }
            }
        });

    }
}
