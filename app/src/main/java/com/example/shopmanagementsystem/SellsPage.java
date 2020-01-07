package com.example.shopmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SellsPage extends AppCompatActivity {
    private EditText ScodeEdittext,SquantityEdittext;
    private Button SellsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sells_page);

        setTitle("                     Sells Page");

        ScodeEdittext=findViewById(R.id.S_code_editText);
        SquantityEdittext=findViewById(R.id.S_quantity_editText);
        SellsButton=findViewById(R.id.Sells_button);


 }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.CustomerInfo_ID){
            Toast.makeText(getApplicationContext(),"Add Customer",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(),Customer_Info.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.Product_ID){
            Intent intent=new Intent(getApplicationContext(),Product_Registration.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
