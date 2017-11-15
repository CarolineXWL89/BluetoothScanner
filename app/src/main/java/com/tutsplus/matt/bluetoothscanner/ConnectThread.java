package com.tutsplus.matt.bluetoothscanner;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.UUID;

/**
 * Created by princ on 12/11/2017.
 */

public class ConnectThread extends Thread{
    private BluetoothSocket bTSocket;
    private BluetoothSocket fallbackSocket;

    public boolean connect(BluetoothDevice bTDevice, UUID mUUID) throws IOException {


        try {
            bTSocket = bTDevice.createRfcommSocketToServiceRecord(mUUID);
            Log.d("Working", "device created from UUID");
        } catch (IOException e) {
            Log.d("CONNECTTHREAD","Could not create RFCOMM socket:" + e.toString());
            return false;
        }
        try {
            bTSocket.connect();
            Log.d("Working", "device connected");
        } catch(IOException e) {
            Log.d("CONNECTTHREAD","Could not connect: " + e.toString());
            try
            {
                Class<?> clazz = bTSocket.getRemoteDevice().getClass();
                Class<?>[] paramTypes = new Class<?>[] {Integer.TYPE};
                Method m = clazz.getMethod("createRfcommSocket", paramTypes);
                Object[] params = new Object[] {Integer.valueOf(1)};
                fallbackSocket = (BluetoothSocket) m.invoke(bTSocket.getRemoteDevice(), params);
                Thread.sleep(500);
                fallbackSocket.connect();
            }
            catch (Exception i)
            {
                Log.d("CONNECTTHREAD","Could not connect to fallback: " + i.toString());
            }
        }
        return true;
    }

    public boolean cancel() {
        try {
            bTSocket.close();
        } catch(IOException e) {
            Log.d("CONNECTTHREAD","Could not close connection:" + e.toString());
            return false;
        }
        return true;
    }
}
