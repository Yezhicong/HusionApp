package com.jay.fragmentdemo4;

import android.util.Log;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class MySocket {

    public static class TcpSocketConnect extends Thread{
        private String ip;
        private int port;
        private String msg;
        private int isHex;
        public TcpSocketConnect(String ip, int port, int isHex, String msg){
            this.ip = ip;
            this.port = port;
            this.msg = msg;
            this.isHex = isHex;
        }
        public void run(){
            try {
                Socket mSocket = new Socket(ip, port);
                mSocket.setSoTimeout(1000);
                if(mSocket != null){
                    OutputStream mOutStream = mSocket.getOutputStream();
                    if (isHex == 1) {
                        mOutStream.write(hexStringToByteArray(msg));
                    } else {
                        mOutStream.write(msg.getBytes());
                    }
                    mOutStream.flush();
                    mSocket.shutdownOutput();
                    mSocket.close();
                }
            } catch (Exception e) {
                Log.e("TAG", e.getMessage() + " / send: " + msg + " failed!");
                return;
            }
            Log.i("TAG", " / send:" + msg + " success!");
        }
    }

    public static class UdpSocketConnect extends Thread{
        private String ip;
        private int port;
        private String msg;
        private int isHex;
        public UdpSocketConnect(String ip, int port, int isHex, String msg){
            this.ip = ip;
            this.port = port;
            this.msg = msg;
            this.isHex = isHex;
        }
        public void run(){
            try {
                DatagramSocket mSocket = new DatagramSocket();
                InetAddress address = InetAddress.getByName(ip);
                if (isHex == 1) {
                    DatagramPacket dp = new DatagramPacket(hexStringToByteArray(msg), msg.length(), address, port);
                    mSocket.send(dp);
                } else {
                    DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), address, port);
                    mSocket.send(dp);
                }
            } catch (Exception e) {
                Log.e("TAG", e.getMessage() + " / send: " + msg + " failed!");
                return;
            }
            Log.i("TAG", " / send:" + msg + " success!");
        }
    }

    public static byte[] hexStringToByteArray(String str) {
        str = str.replace(" ", "");
        int len = str.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4)
                    + Character.digit(str.charAt(i + 1), 16));
        }
        return data;
    }
}
