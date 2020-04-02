package com.jay.fragmentdemo4.ui.air;

public class Air {

    private String name;
    private int imageId;

    public Air(String name, int imageId){
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
