package com.example.michaelwhite.halosmartglass.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

public class DevicesUtil {
    public final static int BLUETOOTH_REQUEST_CODE = 1337;

    public static BluetoothAdapter getBlueToothAdapter() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return bluetoothAdapter != null ? bluetoothAdapter : null;
    }

    public static void requestEnableBluetooth(Activity activity) {
        Intent enableBluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        activity.startActivityForResult(enableBluetoothIntent, BLUETOOTH_REQUEST_CODE);
    }

}
