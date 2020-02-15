package com.jay.fragmentdemo4;

public class Computer {

    private String name;
    private int imageId;

    public Computer(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

}
