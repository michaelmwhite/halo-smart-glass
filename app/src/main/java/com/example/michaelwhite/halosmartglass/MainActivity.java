package com.example.michaelwhite.halosmartglass;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.michaelwhite.halosmartglass.bluetooth.DevicesUtil;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.device_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DevicesUtil.requestEnableBluetooth(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DevicesUtil.BLUETOOTH_REQUEST_CODE && resultCode == RESULT_OK) {
            adapter = new DevicesAdapter(DevicesUtil.getBlueToothAdapter().getBondedDevices());
            recyclerView.setAdapter(adapter);
        }
    }
}
