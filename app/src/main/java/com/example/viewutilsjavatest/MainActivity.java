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

        LinearLayout btnValidators                       = findViewById(R.id.layout_validator_demo);
        LinearLayout btnVuFragmentManager                = findViewById(R.id.layout_vu_fragment_management);
        LinearLayout btnVuFragmentManagerTabs            = findViewById(R.id.layout_vu_fragment_management_tabs);
        LinearLayout btnVuRecyclerView                   = findViewById(R.id.layout_vu_recyclerview);
        LinearLayout btnVuRecyclerViewWithoutDataBinding = findViewById(R.id.layout_vu_recyclerview_without_data_binding);

        btnValidators.setOnClickListener(this);
        btnVuFragmentManager.setOnClickListener(this);
        btnVuFragmentManagerTabs.setOnClickListener(this);
        btnVuRecyclerView.setOnClickListener(this);
        btnVuRecyclerViewWithoutDataBinding.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_validator_demo:
                startActivity(new Intent(this, ValidatorsDemoActivity.class));
                break;
            case R.id.layout_vu_fragment_management:
                startActivity(new Intent(this, ValidatorsExampleWithVuFragmentManagerActivity.class));
                break;
            case R.id.layout_vu_fragment_management_tabs:
                startActivity(new Intent(this, VuFragmentManagementTabbedActivity.class));
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