package com.example.shopmanagementsystem;

public class Customer_Info_Data {
    private String C_Name;
    private String C_Phone;
    private String C_Address;


    public Customer_Info_Data() {

    }

    public Customer_Info_Data(String c_Name, String c_Phone, String c_Address) {
        C_Name = c_Name;
        C_Phone = c_Phone;
        C_Address = c_Address;
    }

    public String getC_Name() {
        return C_Name;
    }

    public void setC_Name(String c_Name) {
        C_Name = c_Name;
    }

    public String getC_Phone() {
        return C_Phone;
    }

    public void setC_Phone(String c_Phone) {
        C_Phone = c_Phone;
    }

    public String getC_Address() {
        return C_Address;
    }

    public void setC_Address(String c_Address) {
        C_Address = c_Address;
    }
}
