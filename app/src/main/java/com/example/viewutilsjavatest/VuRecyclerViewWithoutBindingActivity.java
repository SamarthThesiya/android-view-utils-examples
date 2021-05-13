package com.example.viewutilsjavatest;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import customView.VuRecyclerView;
import interfaces.RecyclerViewListener;
import models.ItemVuRecyclerView;

public class VuRecyclerViewWithoutBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vu_recycler_view_without_binding);

        VuRecyclerView vuRecyclerView = findViewById(R.id.vu_recycler_view);

        final ArrayList<ItemVuRecyclerView> items = getItems();

        vuRecyclerView.setData(R.layout.item_view_without_data_binding, items.size(), this, new RecyclerViewListener() {
            @Override
            public void onBindViewHolder(@NonNull VuRecyclerView.VuRecyclerViewAdaptor.VuViewHolder holder, int position) {
                TextView tvTitle       = holder.itemView.findViewById(R.id.tv_title);
                TextView tvSubTitle    = holder.itemView.findViewById(R.id.tv_sub_title);
                TextView tvDescription = holder.itemView.findViewById(R.id.tv_description);

                tvTitle.setText(items.get(position).getTitle());
                tvSubTitle.setText(items.get(position).getSubTitle());
                tvDescription.setText(items.get(position).getDescription());
            }
        });
    }

    public ArrayList<ItemVuRecyclerView> getItems() {
        ArrayList<ItemVuRecyclerView> items = new ArrayList<>(5);
        for (int i = 0; i < 10; i++) {
            ItemVuRecyclerView itemVuRecyclerView = new ItemVuRecyclerView();
            itemVuRecyclerView.setTitle("Title " + (i + 1));
            itemVuRecyclerView.setSubTitle("Sub Title " + (i + 1));
            itemVuRecyclerView.setDescription("Description " + (i + 1));

            items.add(itemVuRecyclerView);
        }

        return items;
    }
}