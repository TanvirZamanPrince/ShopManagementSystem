package com.example.shopmanagementsystem;

public class Product_Registration_Data {

    private String Pcode;
    private String Pname;
    private String Pprize;
    private String Punit;

    public Product_Registration_Data() {

    }

    public Product_Registration_Data(String pcode, String pname, String pprize, String punit) {
        Pcode = pcode;
        Pname = pname;
        Pprize = pprize;
        Punit = punit;
    }

    public String getPcode() {
        return Pcode;
    }

    public void setPcode(String pcode) {
        Pcode = pcode;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getPprize() {
        return Pprize;
    }

    public void setPprize(String pprize) {
        Pprize = pprize;
    }

    public String getPunit() {
        return Punit;
    }

    public void setPunit(String punit) {
        Punit = punit;
    }
}
