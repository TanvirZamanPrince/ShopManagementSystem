package com.example.shopmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUp extends AppCompatActivity {
    private EditText emailEdittext,paswordEdittext;
    private Button registrationButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("                     "+"Registration");

        emailEdittext=findViewById(R.id.Email_editText);
        paswordEdittext=findViewById(R.id.Password_editText);
        registrationButton=findViewById(R.id.Registration_button);

        mAuth = FirebaseAuth.getInstance();

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRegistration();

            }
        });
    }

    private void UserRegistration() {

        String Email=emailEdittext.getText().toString().trim();
        String Password=paswordEdittext.getText().toString().trim();


        if(Email.isEmpty()){
            // Toast.makeText(this,"Must not be empty",Toast.LENGTH_LONG).show();
            emailEdittext.setError("Enter Email");
            emailEdittext.requestFocus();
            return;

        }
        if(Password.isEmpty()){
            // Toast.makeText(this,"Must not be empty",Toast.LENGTH_LONG).show();
            paswordEdittext.setError("Enter Password");
            paswordEdittext.requestFocus();
            return;
        }


        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){

            emailEdittext.setError("Enter Valid Email Addres");
            emailEdittext.requestFocus();
            return;

        }

        if (Password.length()<6) {
            paswordEdittext.setError("At least 6 Number");
            paswordEdittext.requestFocus();
            return;

        }


        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Sucessful",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                } else {

                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"Already Sign Up",Toast.LENGTH_LONG).show();

                    }else {

                        Toast.makeText(getApplicationContext(),"Error"+task.getException().getMessage(),Toast.LENGTH_LONG).show();

                    }

                }


            }
        });

    }
}
