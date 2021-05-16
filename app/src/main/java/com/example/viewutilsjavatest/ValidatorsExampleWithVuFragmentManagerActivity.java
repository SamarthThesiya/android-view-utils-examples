package com.example.viewutilsjavatest;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import customView.dependantHolders.VuButton;
import customView.fragmentManager.VuFragmentManager;
import fragments.VuValidationExampleFirstFragment;
import fragments.VuValidationExampleLoginFragment;
import fragments.VuValidationExampleSecondFragment;
import interfaces.FragmentStakeCommunicator;

public class ValidatorsExampleWithVuFragmentManagerActivity extends AppCompatActivity implements FragmentStakeCommunicator {

    public VuButton btnNext, btnBack;
    TextView tvPage, tvGoHome;
    VuFragmentManager.FragmentStack fragmentStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validators_example_with_vu_fragment_manager);

        init();

        VuFragmentManager fragmentManager = new VuFragmentManager(this, R.id.frame_layout);
        fragmentStack   = fragmentManager.getFragmentStack(3, this, false);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentStack.populateNextFragment();
                btnNext.dependantHandler.removeAllValidatables();
                updatePage();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentStack.popBackStack();
                updatePage();
            }
        });

        // Populate first page
        fragmentStack.populateNextFragment();
    }

    @Override
    public Fragment getFragmentFromByIndexNumber(int index) {

        updatePage();
        switch (index) {
            case 0:
                return VuValidationExampleFirstFragment.newInstance(this);
            case 1:
                return VuValidationExampleSecondFragment.newInstance(this);
            case 2:
                return VuValidationExampleLoginFragment.newInstance(this);
        }
        return null;
    }

    @Override
    public void fragmentStackOverflowed() {
        Toast.makeText(this, "Example finished", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean fragmentStackUnderFlow() {
        onBackPressed();

        // To know more about return value check here: interfaces.FragmentStakeCommunicator.fragmentStackUnderFlow()
        return true;
    }

    private void updatePage() {
        String page = "Page: " + (fragmentStack.getCurrentFragmentIndex()+1) + "/" +(fragmentStack.getFragments().length);
        tvPage.setText(page);
    }

    private void init() {
        btnNext = findViewById(R.id.btn_next);
        btnBack = findViewById(R.id.btn_back);
        tvPage = findViewById(R.id.tv_page);

        tvGoHome = findViewById(R.id.tv_go_home);
        tvGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}