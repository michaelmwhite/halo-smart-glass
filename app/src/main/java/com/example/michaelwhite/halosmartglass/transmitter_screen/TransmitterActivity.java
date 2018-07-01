package com.example.michaelwhite.halosmartglass.transmitter_screen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.michaelwhite.halosmartglass.R;
import com.example.michaelwhite.halosmartglass.bluetooth.CommunicationUtil;

public class TransmitterActivity extends AppCompatActivity {
    public static final String BLUETOOTH_ADDRESS = "BLUETOOTH_ADDRESS";
    private TransmitterController transmitterController;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmitter);
        address = getIntent().getStringExtra(BLUETOOTH_ADDRESS);
        transmitterController = new TransmitterController(this);
        new CommunicationUtil.ConnectBluetooth(transmitterController, address).execute();
    }
}
