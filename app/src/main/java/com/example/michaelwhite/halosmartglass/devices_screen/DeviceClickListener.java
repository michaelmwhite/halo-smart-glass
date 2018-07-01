package com.example.michaelwhite.halosmartglass.devices_screen;

import android.bluetooth.BluetoothDevice;
import android.view.View;

public class DeviceClickListener implements View.OnClickListener {
    private BluetoothDevice device;

    public DeviceClickListener(BluetoothDevice device){
        this.device = device;
    }

    @Override
    public void onClick(View v) {

    }
}
