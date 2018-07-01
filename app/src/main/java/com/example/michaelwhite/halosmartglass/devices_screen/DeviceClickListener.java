package com.example.michaelwhite.halosmartglass.devices_screen;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.view.View;

import com.example.michaelwhite.halosmartglass.transmitter_screen.TransmitterActivity;

public class DeviceClickListener implements View.OnClickListener {
    private BluetoothDevice device;

    public DeviceClickListener(BluetoothDevice device) {
        this.device = device;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), TransmitterActivity.class);
        intent.putExtra(TransmitterActivity.BLUETOOTH_ADDRESS, device.getAddress());
        v.getContext().startActivity(intent);
    }
}
