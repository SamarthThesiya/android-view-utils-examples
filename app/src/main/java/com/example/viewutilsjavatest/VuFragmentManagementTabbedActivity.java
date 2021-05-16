package com.example.viewutilsjavatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import customView.fragmentManager.VuFragmentManager;
import fragments.TabOneFragment;
import fragments.TabThreeFragment;
import fragments.TabTwoFragment;

public class VuFragmentManagementTabbedActivity extends AppCompatActivity implements View.OnClickListener {

    VuFragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vu_fragment_management_tabbed);

        Button btnTab1 = findViewById(R.id.btn_tab1);
        Button btnTab2 = findViewById(R.id.btn_tab2);
        Button btnTab3 = findViewById(R.id.btn_tab3);

        fragmentManager = new VuFragmentManager(this, R.id.frame_layout);

        btnTab1.setOnClickListener(this);
        btnTab2.setOnClickListener(this);
        btnTab3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.btn_tab1:
                fragment = TabOneFragment.newInstance();
                break;
            case R.id.btn_tab2:
                fragment = TabTwoFragment.newInstance();
                break;
            case R.id.btn_tab3:
                fragment = TabThreeFragment.newInstance();
                break;
        }
        fragmentManager.populateFragment(fragment, fragment.getClass().toString());
    }
}