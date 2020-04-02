package com.jay.fragmentdemo4.ui;

public class Light {

    private String name;
    private int imageId;
    private boolean ischecked;

    public Light(String name, int imageId, boolean ischecked){
        this.name = name;
        this.imageId = imageId;
        this.ischecked = ischecked;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

    public boolean getChecked(){
        return ischecked;
    }

}
