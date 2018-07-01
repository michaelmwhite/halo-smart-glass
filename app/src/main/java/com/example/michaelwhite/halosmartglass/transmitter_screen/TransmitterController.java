package com.example.michaelwhite.halosmartglass.transmitter_screen;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.widget.Toast;

import com.example.michaelwhite.halosmartglass.R;
import com.example.michaelwhite.halosmartglass.bluetooth.CommunicationUtil;
import com.example.michaelwhite.halosmartglass.bluetooth.Communicator;

public class TransmitterController implements Communicator {
    private Context context;
    private BluetoothSocket socket;

    public TransmitterController(Context context) {
        this.context = context;
    }

    @Override
    public void connectionInProgress() {
        Toast.makeText(context, context.getString(R.string.connection_in_progress), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void connectionSuccess() {
        Toast.makeText(context, context.getString(R.string.connection_success), Toast.LENGTH_SHORT).show();
        CommunicationUtil.sendMessage(socket, "Connection established!!!1!");
    }

    @Override
    public void connectionFailure() {
        Toast.makeText(context, context.getString(R.string.connection_failure), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setSocket(BluetoothSocket socket) {
        this.socket = socket;
    }
}
