package fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewutilsjavatest.R;
import com.example.viewutilsjavatest.ValidatorsExampleWithVuFragmentManagerActivity;

import VuValidators.MyValidators;
import customView.validatable.VuEditText;
import utils.VuValidationMethods;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VuValidationExampleLoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VuValidationExampleLoginFragment extends Fragment {

    ValidatorsExampleWithVuFragmentManagerActivity activity;
    public VuValidationExampleLoginFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment VuValidationExampleLoginFragment.
     */
    public static VuValidationExampleLoginFragment newInstance(ValidatorsExampleWithVuFragmentManagerActivity activity) {
        VuValidationExampleLoginFragment fragment = new VuValidationExampleLoginFragment();
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

        VuEditText etEmail = getView().findViewById(R.id.et_email);
        VuEditText etPassword = getView().findViewById(R.id.et_password);

        etEmail.validations().add(VuValidationMethods.REQUIRED);
        etEmail.validations().add(VuValidationMethods.REGEX, "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", "Invalid email");

        etPassword.validations().add(VuValidationMethods.REQUIRED);

        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.+])[A-Za-z\\d@$!%*?&.+]{6,}$";
        String passwordMsg = "Password must contain at least 6 chars, one upper case, one lower case, one number and one special character";
        etPassword.validations().add(VuValidationMethods.REGEX, passwordRegex, passwordMsg);
        etPassword.validations().add(MyValidators.START_WITH_PLUS, null, "Password must start with '+'");

        activity.btnNext.dependantHandler.setValidatables(etEmail, etPassword).setCustomValidatableMethods(new MyValidators());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vu_validation_example_login, container, false);
    }
}