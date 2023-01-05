package com.example.tp1androidstudioii;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Check extends AppCompatActivity {
    Button btnok;
    Button btncancel;
    EditText inputtext;
    TextView txtview1;
    TextView txtview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);

        btnok= (Button) findViewById(R.id.btnok);
        btncancel= (Button) findViewById(R.id.btncancel);
        inputtext = (EditText) findViewById(R.id.inputtext);
        txtview1 = (TextView) findViewById(R.id.txtview1);
        txtview2 = (TextView) findViewById(R.id.txtview2);
        txtview1.setText(Integer.toString(getIntent().getIntExtra("txtchallenge1",0)));
        txtview2.setText(Integer.toString(getIntent().getIntExtra("txtchallenge2",0)));
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int number1 = Integer.parseInt(inputtext.getText().toString());
                Log.i("numbershow",""+number1);
                Intent intent1= new Intent(Check.this,MainActivity.class);
                intent1.putExtra("somme",number1);
                setResult(RESULT_OK,intent1);
               // startActivityForResult(intent1,1);

                finish();

            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast t = Toast.makeText(Check.this,"operation annulée", Toast.LENGTH_LONG);
               t.show();
               finish();


            }
        });


    }
}
