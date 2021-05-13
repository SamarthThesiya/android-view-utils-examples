package com.example.viewutilsjavatest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout btnBuiltInValidators                = findViewById(R.id.layout_built_in_validators);
        LinearLayout btnVuRecyclerView                   = findViewById(R.id.layout_vu_recyclerview);
        LinearLayout btnVuRecyclerViewWithoutDataBinding = findViewById(R.id.layout_vu_recyclerview_without_data_binding);

        btnBuiltInValidators.setOnClickListener(this);
        btnVuRecyclerView.setOnClickListener(this);
        btnVuRecyclerViewWithoutDataBinding.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_built_in_validators:
                startActivity(new Intent(this, ValidatorsDemoActivity.class));
                break;
            case R.id.layout_vu_recyclerview:
                startActivity(new Intent(this, VuRecyclerViewDemoActivity.class));
                break;
            case R.id.layout_vu_recyclerview_without_data_binding:
                startActivity(new Intent(this, VuRecyclerViewWithoutBindingActivity.class));
                break;
        }
    }
}