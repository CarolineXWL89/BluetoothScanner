package com.tutsplus.matt.bluetoothscanner;

import android.bluetooth.BluetoothDevice;

/**
 * Created by Matt on 5/12/2015.
 */
public class DeviceItem {

    private String deviceName;
    private String address;
    private boolean connected;

    public boolean isConnected() {
        return connected;
    }

    public BluetoothDevice getBluetoothDevice() {
        return bluetoothDevice;
    }

    private BluetoothDevice bluetoothDevice;

    public String getDeviceName() {
        return deviceName;
    }

    public boolean getConnected() {
        return connected;
    }

    public String getAddress() {
        return address;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public DeviceItem(String name, String address, String connected, BluetoothDevice bluetoothDevice){
        this.deviceName = name;
        this.address = address;
        if (connected == "true") {
            this.connected = true;
        }
        else {
            this.connected = false;
        }
        this.bluetoothDevice = bluetoothDevice;
    }
}
