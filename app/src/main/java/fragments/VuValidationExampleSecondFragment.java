package fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewutilsjavatest.R;
import com.example.viewutilsjavatest.ValidatorsExampleWithVuFragmentManagerActivity;

import customView.validatable.VuEditText;
import utils.VuValidationMethods;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VuValidationExampleSecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VuValidationExampleSecondFragment extends Fragment {

    ValidatorsExampleWithVuFragmentManagerActivity activity;
    public VuValidationExampleSecondFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment VuValidationExampleSecondFragment.
     */
    public static VuValidationExampleSecondFragment newInstance(ValidatorsExampleWithVuFragmentManagerActivity activity) {
        VuValidationExampleSecondFragment fragment = new VuValidationExampleSecondFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        VuEditText vuEditText = getView().findViewById(R.id.et_text);
        vuEditText.validations().add(VuValidationMethods.REQUIRED);
        vuEditText.validations().add(VuValidationMethods.MIN_LENGTH, 6);
        activity.btnNext.dependantHandler.setValidatables(vuEditText);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vu_validation_example_second, container, false);
    }
}