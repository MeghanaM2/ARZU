package com.example.arzu;

public class Model {
    private int imageview1;
    private String textview1;
    private String textview2;
    private String textview3;
    private String textview4;
    private String textview5;

    Model (int imageview1,String textview1,String textview2,String textview3,String textview4,String textview5)
    {
        this.imageview1=imageview1;
        this.textview1=textview1;
        this.textview2=textview2;
        this.textview3=textview3;
        this.textview4=textview4;
        this.textview5=textview5;
    }

    public int getImageview1() {
        return imageview1;
    }

    public String getTextview1() {
        return textview1;
    }

    public String getTextview2() {
        return textview2;
    }

    public String getTextview3() {
        return textview3;
    }

    public String getTextview4() {
        return textview4;
    }

    public String getTextview5() {
        return textview5;
    }
}
