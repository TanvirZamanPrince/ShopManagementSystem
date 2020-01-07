package com.example.shopmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Product_Registration extends AppCompatActivity {

    private EditText p_codeEdittext,p_nameEdittext,p_prizeEdittext,p_unitEdittext;
    private Button p_registrationButton;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__registration);
        setTitle("                 Product Registration");

        databaseReference=FirebaseDatabase.getInstance().getReference("Product Registration");


        p_codeEdittext=findViewById(R.id.P_Code_editText);
        p_nameEdittext=findViewById(R.id.P_name_editText);
        p_prizeEdittext=findViewById(R.id.P_Prize_editText);
        p_unitEdittext=findViewById(R.id.P_Unit_editText);
        p_registrationButton=findViewById(R.id.P_Registration_button);


        p_registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productRegistration();
            }
        });
    }

    private void productRegistration() {
        String Pcode=p_codeEdittext.getText().toString().trim();
        String Pname=p_nameEdittext.getText().toString().trim();
        String Pprize=p_prizeEdittext.getText().toString().trim();
        String Punit=p_unitEdittext.getText().toString().trim();

        if(Pcode.isEmpty()){
            p_codeEdittext.setError("Enter Product Code");
            p_codeEdittext.requestFocus();
            return;

        }
        if(Pname.isEmpty()){
            p_nameEdittext.setError("Enter Product Name");
            p_nameEdittext.requestFocus();
            return;
        }
        if(Pprize.isEmpty()){
            p_prizeEdittext.setError("Enter Product Prize");
            p_prizeEdittext.requestFocus();
            return;
        }
        if(Punit.isEmpty()){
            p_unitEdittext.setError("Enter Product Prize");
            p_unitEdittext.requestFocus();
            return;
        }

        String key=databaseReference.push().getKey();
        Product_Registration_Data product_registration_data=new Product_Registration_Data(Pcode,Pname,Pprize,Punit);
        databaseReference.child(key).setValue(product_registration_data);
        Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_LONG).show();
        p_codeEdittext.setText("");
        p_nameEdittext.setText("");
        p_prizeEdittext.setText("");
        p_unitEdittext.setText("");






    }


}
