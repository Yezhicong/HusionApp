package com.jay.fragmentdemo4;

import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class MySocket {

    public final static String TAG = "Socket";

    public static class TcpSocketConnect extends Thread{
        private String ip;
        private int port;
        private String msg;
        private boolean isHex;
        private String recvMsg;

        public TcpSocketConnect(String ip, int port, boolean isHex, String msg){
            this.ip = ip;
            this.port = port;
            this.msg = msg;
            this.isHex = isHex;
        }

        public void run(){
            try {
                Socket mSocket = new Socket();
                SocketAddress socketAddress = new InetSocketAddress(ip, port);
                mSocket.connect(socketAddress, 1000);
                if(mSocket.isConnected()){
                    OutputStream mOutStream = mSocket.getOutputStream();
                    InputStream mInputStream = mSocket.getInputStream();

                    if (!isHex) {
                        mOutStream.write(msg.getBytes());
                    } else {
                        mOutStream.write(hexStringToByteArray(msg));
                    }

                    final byte[] buffer = new byte[102400];
                    final int len = mInputStream.read(buffer);
                    if (len > 0){
                        recvMsg = new String(buffer,0, len);
                    }

                    mOutStream.flush();
                    mSocket.shutdownOutput();
                    mSocket.close();
                }
            } catch (Exception e) {
                Log.e(TAG, e.getMessage() + " / send: " + msg + " failed!");
                recvMsg = "null";
                return;
            }
            Log.i(TAG, "succeed to connect to /" + ip + " (port " + port + ") / send: " + msg + " success!");
        }

        public String getReturnMsg(){
            return recvMsg;
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
            Log.i("TAG", " / send: " + msg + " success!");
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
