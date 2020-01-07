package com.example.shopmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText emailEdittext,paswordEdittext;
    private Button loginButton;
    private TextView signupTextview;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("                          Login");

        emailEdittext=findViewById(R.id.Email_editText);
        paswordEdittext=findViewById(R.id.Password_editText);
        loginButton=findViewById(R.id.Login_button);
        signupTextview=findViewById(R.id.signup_Textview);

        mAuth = FirebaseAuth.getInstance();

        signupTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserSignin();

            }
        });
    }

    private void UserSignin() {

        String Email=emailEdittext.getText().toString().trim();
        String Password=paswordEdittext.getText().toString().trim();

        if(Email.isEmpty()){
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

        mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Login sucessful",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),SellsPage.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(),"Login Unsucessful",Toast.LENGTH_LONG).show();



                }

            }
        });



    }
}
