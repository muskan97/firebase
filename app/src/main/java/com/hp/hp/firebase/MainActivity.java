package com.hp.hp.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public  void sign(View v){
    Intent i = new Intent(MainActivity.this,firebase.class);
    startActivity(i);
}

    public void login1(View view) {


        EditText username = findViewById(R.id.et_1);

        EditText password = findViewById(R.id.et_2);




    }
}
