package com.example.diplom;

public class ResorsesForRow {

    String name;
    int img;

    ResorsesForRow(String name1, int img1){
        name=name1;
        img=img1;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getImg(){
        return this.img = img;
    }

    public void setImg(int img){
        this.img = img;
    }
}
