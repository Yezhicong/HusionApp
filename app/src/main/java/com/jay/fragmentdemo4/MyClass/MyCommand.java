package com.jay.fragmentdemo4.MyClass;

import org.w3c.dom.Node;

public class MyCommand {

    private String ip;
    private int port;
    private int isHex;
    private String msg;

    public MyCommand(String ip, int port, int isHex, String msg){
        this.ip = ip;
        this.port = port;
        this.isHex = isHex;
        this.msg = msg;
    }

    public String getIp(){
        return ip;
    }

    public int getPort(){
        return port;
    }

    public int getIsHex(){
        return isHex;
    }

    public String getMsg(){
        return msg;
    }
}
