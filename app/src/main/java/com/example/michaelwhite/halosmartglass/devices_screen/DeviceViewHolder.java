package com.example.michaelwhite.halosmartglass.devices_screen;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.michaelwhite.halosmartglass.R;

public class DeviceViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public DeviceViewHolder(View view) {
        super(view);
        textView = view.findViewById(R.id.device_name);
    }
}
