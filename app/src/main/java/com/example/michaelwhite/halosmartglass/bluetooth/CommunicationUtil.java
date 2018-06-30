package com.example.michaelwhite.halosmartglass.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;

import java.util.UUID;

public class CommunicationUtil {
    private static final UUID SPP_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    public static boolean sendMessage(BluetoothSocket socket, String text) {
        boolean sendSuccesful = true;
        try {
            socket.getOutputStream().write(text.getBytes());
        } catch (Exception e) {
            sendSuccesful = false;
        }
        return sendSuccesful;
    }

    public class ConnectBluetooth extends AsyncTask<Void, Void, Void> {
        private Communicator communicator;
        private BluetoothSocket socket;
        private String address;
        private boolean isConnected, didConnect = true;

        public ConnectBluetooth(Communicator communicator, String address) {
            this.address = address;
            this.communicator = communicator;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            communicator.connectionInProgress();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                if (socket == null || !isConnected) {
                    BluetoothAdapter adapter = DevicesUtil.getBlueToothAdapter();
                    BluetoothDevice device = adapter.getRemoteDevice(address);
                    socket = device.createInsecureRfcommSocketToServiceRecord(CommunicationUtil.SPP_UUID);
                    adapter.cancelDiscovery();
                    socket.connect();
                    communicator.setSocket(socket);
                }
            } catch (Exception e) {
                didConnect = false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (didConnect) {
                communicator.connectionSuccess();
            } else {
                communicator.connectionFailure();
            }
        }
    }
}
