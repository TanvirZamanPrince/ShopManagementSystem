package com.example.shopmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Customer_Info extends AppCompatActivity {
    private EditText c_nameEdittext,c_phoneEdittext,c_addressEdittext;
    private Button c_infoButton;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__info);
        setTitle("                     Customer Info");

        databaseReference= FirebaseDatabase.getInstance().getReference("Customer Info");

        c_nameEdittext=findViewById(R.id.C_name_editText);
        c_phoneEdittext=findViewById(R.id.C_phone_editText);
        c_addressEdittext=findViewById(R.id.C_address_editText);
        c_infoButton=findViewById(R.id.C_Info_button);

        c_infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerInfoSave();

            }
        });

    }

    private void CustomerInfoSave() {
        String C_Name=c_nameEdittext.getText().toString().trim();
        String C_Phone=c_phoneEdittext.getText().toString().trim();
        String C_Address=c_addressEdittext.getText().toString().trim();

        if(C_Name.isEmpty()){

            c_nameEdittext.setError("Enter Customer Name");
            c_nameEdittext.requestFocus();
            return;

        }
        if(C_Phone.isEmpty()){

            c_phoneEdittext.setError("Enter Phone Number");
            c_phoneEdittext.requestFocus();
            return;
        }
        if(C_Address.isEmpty()){

            c_addressEdittext.setError("Enter Customer Address");
            c_addressEdittext.requestFocus();
            return;
        }

        String key=databaseReference.push().getKey();
        Customer_Info_Data customer_info_data=new Customer_Info_Data(C_Name,C_Phone,C_Address);
        databaseReference.child(key).setValue(customer_info_data);
        Toast.makeText(getApplicationContext(),"Info Save",Toast.LENGTH_LONG).show();
        c_nameEdittext.setText("");
        c_phoneEdittext.setText("");
        c_addressEdittext.setText("");




    }
}
