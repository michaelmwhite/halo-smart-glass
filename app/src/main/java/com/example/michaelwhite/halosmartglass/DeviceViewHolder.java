package com.example.michaelwhite.halosmartglass;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DeviceViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public DeviceViewHolder(View view) {
        super(view);
        textView = view.findViewById(R.id.device_name);
    }
}
