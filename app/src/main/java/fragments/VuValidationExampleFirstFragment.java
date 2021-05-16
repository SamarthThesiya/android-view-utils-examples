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
 * Use the {@link VuValidationExampleFirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VuValidationExampleFirstFragment extends Fragment {

    ValidatorsExampleWithVuFragmentManagerActivity activity;
    public VuValidationExampleFirstFragment() {
    }

    public static VuValidationExampleFirstFragment newInstance(ValidatorsExampleWithVuFragmentManagerActivity activity) {
        VuValidationExampleFirstFragment fragment = new VuValidationExampleFirstFragment();
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
        activity.btnNext.dependantHandler.setValidatables(vuEditText);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_vu_validation_example_first, container, false);
    }
}