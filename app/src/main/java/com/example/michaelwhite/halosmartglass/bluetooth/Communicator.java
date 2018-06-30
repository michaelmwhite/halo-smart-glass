package com.example.michaelwhite.halosmartglass.bluetooth;

import android.bluetooth.BluetoothSocket;

public interface Communicator {
    void connectionInProgress();

    void connectionSuccess();

    void connectionFailure();

    void setSocket(BluetoothSocket socket);
}
