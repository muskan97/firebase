package com.hp.hp.firebase;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class firebase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
    }

    public void start(View view) {


        EditText email_id = findViewById(R.id.email_id);

        EditText password_id = findViewById(R.id.password_id);

        String email = email_id.getText().toString();

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {

        }
        else
        {
            Toast.makeText(firebase.this,"invalid email syntax",Toast.LENGTH_SHORT).show();
            return;
        }

        String password = password_id.getText().toString();

        if (password.length() >= 8 && password.length() < 33)
        {

        }
else
        {
            Toast.makeText(firebase.this,"password must be between 8 to 32 characters",Toast.LENGTH_SHORT).show();
return;
        }

        final ProgressDialog progress_bar = new ProgressDialog(firebase.this);

        progress_bar.setTitle("Please Wait");

        progress_bar.setMessage("Creating account...");

        progress_bar.show();

        FirebaseAuth f_auth = FirebaseAuth.getInstance();


        OnCompleteListener<AuthResult> Listener = new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progress_bar.hide();

                if ( task.isSuccessful() ){
                    Toast.makeText(firebase.this, "done",Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(firebase.this , "error try again" , Toast.LENGTH_SHORT).show();
                }

            }
        };

        f_auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Listener);


        }

    }

