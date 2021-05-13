package com.example.viewutilsjavatest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.viewutilsjavatest.databinding.ItemViewBinding;

import java.util.ArrayList;

import customView.VuRecyclerView;
import interfaces.RecyclerViewListener;
import models.ItemVuRecyclerView;

public class VuRecyclerViewDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vu_recycler_view_demo);

        VuRecyclerView vuRecyclerView = findViewById(R.id.vu_recycler_view);

        final ArrayList<ItemVuRecyclerView> items = getItems();

        vuRecyclerView.setData(R.layout.item_view, items.size(), this, new RecyclerViewListener() {
            @Override
            public void onBindViewHolder(@NonNull VuRecyclerView.VuRecyclerViewAdaptor.VuViewHolder holder, int position) {
                ItemViewBinding binding = (ItemViewBinding) holder.binding;
                binding.setModel(items.get(position));
            }
        });
    }

    public ArrayList<ItemVuRecyclerView> getItems() {
        ArrayList<ItemVuRecyclerView> items = new ArrayList<>(5);
        for (int i = 0; i < 10; i++) {
            ItemVuRecyclerView itemVuRecyclerView = new ItemVuRecyclerView();
            itemVuRecyclerView.setTitle("Title " + (i+1));
            itemVuRecyclerView.setSubTitle("Sub Title " + (i+1));
            itemVuRecyclerView.setDescription("Description " + (i+1));

            items.add(itemVuRecyclerView);
        }

        return items;
    }
}