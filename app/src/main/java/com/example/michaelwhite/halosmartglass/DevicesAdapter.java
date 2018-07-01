package com.example.michaelwhite.halosmartglass;

import android.bluetooth.BluetoothDevice;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Set;

public class DevicesAdapter extends RecyclerView.Adapter<DeviceViewHolder> {
    private ArrayList<BluetoothDevice> devices;

    public DevicesAdapter(Set<BluetoothDevice> devices) {
        this.devices = new ArrayList(devices);
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.device_cell, parent, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder holder, int position) {
        holder.textView.setText(devices.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }
}
