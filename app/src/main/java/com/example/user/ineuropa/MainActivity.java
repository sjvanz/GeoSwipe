package com.example.user.ineuropa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a new list of Geo Objects
        final List<GeoObject> mGeoObjects = new ArrayList<>();

        // Fill the geo objects with the predefined values
        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS.length; i++) {
            mGeoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_IS_IN_EUROPE[i],
                    GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i],
                    GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES[i]));
        }

        RecyclerView mGeoRecyclerView =  findViewById(R.id.imageList);

        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);

        mGeoRecyclerView.setLayoutManager(mLayoutManager);
        final GeoObjectAdapter mAdapter = new GeoObjectAdapter(this, mGeoObjects);
        mGeoRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                GeoObjectViewHolder geoObjectViewHolder = (GeoObjectViewHolder)viewHolder;
                int position = (viewHolder.getAdapterPosition());
                mGeoObjects.remove(position);
                mAdapter.notifyItemRemoved(position);
                String antwoord;
                if (geoObjectViewHolder.isInEurope) {
                    antwoord = "wel";
                }
                else {
                    antwoord = "niet";
                }

                if (swipeDir == ItemTouchHelper.LEFT && geoObjectViewHolder.isInEurope
                        || swipeDir == ItemTouchHelper.RIGHT && !geoObjectViewHolder.isInEurope) {
                    Toast.makeText(MainActivity.this, "Goed  "+geoObjectViewHolder.geoName.getText().toString()
                            +" ligt "+antwoord+" in Europa", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Fout  "+geoObjectViewHolder.geoName.getText().toString()
                            +" ligt "+antwoord+" in Europa", Toast.LENGTH_SHORT).show();

                }
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mGeoRecyclerView);
    }
}
