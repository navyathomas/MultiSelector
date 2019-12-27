package com.example.MultiSelectorModel;

public class MultipleData {


    private String title;
    private boolean aBoolean;

    public MultipleData(String title1,boolean aBoolean1){
        this.title=title1;
        this.aBoolean=aBoolean1;

    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title1){
        this.title=title1;
    }


    public boolean isaBoolean(){
        return aBoolean;
    }
    public void setaBoolean(boolean isaBoolean1){
        this.aBoolean=isaBoolean1;
    }

}
