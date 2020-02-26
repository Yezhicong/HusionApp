package com.jay.fragmentdemo4;

public class Camera {

    private int cIcon;
    private String cName;

    public Camera() {
    }

    public Camera(int cIcon, String cName) {
        this.cIcon = cIcon;
        this.cName = cName;
    }

    public int getcIcon() {
        return cIcon;
    }

    public String getcName() {
        return cName;
    }

    public void setcIcon(int cIcon) {
        this.cIcon = cIcon;
    }

    public void sethName(String hName) {
        this.cName = cName;
    }
}
