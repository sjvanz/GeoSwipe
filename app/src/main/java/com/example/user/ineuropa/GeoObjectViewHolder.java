package com.example.user.ineuropa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GeoObjectViewHolder extends RecyclerView.ViewHolder {

    public boolean isInEurope;
    public ImageView geoImage;
    public TextView geoName;
    public View view;

    public GeoObjectViewHolder(View itemView) {
        super(itemView);
        geoImage =  itemView.findViewById(R.id.geoImage);
        view = itemView;
        geoName = itemView.findViewById(R.id.geoTextView);
    }
}
