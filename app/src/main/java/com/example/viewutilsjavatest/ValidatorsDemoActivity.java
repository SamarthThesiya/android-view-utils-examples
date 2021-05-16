package com.example.viewutilsjavatest;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import VuValidators.MyValidators;
import customView.dependantHolders.VuButton;
import customView.validatable.VuEditText;
import utils.VuValidationMethods;

public class ValidatorsDemoActivity extends AppCompatActivity implements View.OnClickListener {

    VuEditText etText, etMinLength, etRegex;
    EditText etRequiredMsg, etMinLengthMsg, etRegexMsg, etCustomMsg;
    LinearLayout layoutSpRegex;
    Button       btnApplyValidations;
    VuButton     btnValidate;
    CheckBox     cbRequired, cbMinLength, cbRegex, cbCustom;
    Spinner spRegex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_built_in_validators_demo);

        init();
        setListeners();
    }

    void applyValidations() {

        // Removes existing validations if it already exist
        etText.validations().remove(VuValidationMethods.REQUIRED);
        etText.validations().remove(VuValidationMethods.MIN_LENGTH);
        etText.validations().remove(VuValidationMethods.REGEX);
        etText.validations().remove(MyValidators.START_WITH_PLUS);
        etMinLength.validations().remove(VuValidationMethods.REQUIRED);
        etRegex.validations().remove(VuValidationMethods.REQUIRED);

        if (cbRequired.isChecked()) {

            if (TextUtils.isEmpty(etRequiredMsg.getText())) {
                etText.validations().add(VuValidationMethods.REQUIRED);
            } else {
                etText.validations().add(VuValidationMethods.REQUIRED, null, etRequiredMsg.getText().toString());
            }
        }

        if (cbMinLength.isChecked()) {

            etMinLength.validations().add(VuValidationMethods.REQUIRED);

            if (!TextUtils.isEmpty(etMinLength.getText())) {
                Integer minValue = Integer.parseInt(etMinLength.getText().toString());
                if (TextUtils.isEmpty(etMinLengthMsg.getText())) {
                    etText.validations().add(VuValidationMethods.MIN_LENGTH, minValue);
                } else {
                    etText.validations().add(VuValidationMethods.MIN_LENGTH, minValue, etMinLengthMsg.getText().toString());
                }
            }
        }

        if (cbRegex.isChecked()) {

            etRegex.validations().add(VuValidationMethods.REQUIRED);

            if (!TextUtils.isEmpty(etRegex.getText())) {
                if (TextUtils.isEmpty(etRegexMsg.getText())) {
                    etText.validations().add(VuValidationMethods.REGEX, etRegex.getText().toString());
                } else {
                    etText.validations().add(VuValidationMethods.REGEX, etRegex.getText().toString(), etRegexMsg.getText().toString());
                }
            }
        }
        
        if (cbCustom.isChecked()) {
            if (TextUtils.isEmpty(etRequiredMsg.getText())) {
                etText.validations().add(MyValidators.START_WITH_PLUS);
            } else {
                etText.validations().add(MyValidators.START_WITH_PLUS, null, etRequiredMsg.getText().toString());
            }

            btnValidate.dependantHandler.setValidatables(etText, etMinLength, etRegex).setCustomValidatableMethods(new MyValidators());
        } else {
            btnValidate.dependantHandler.setValidatables(etText, etMinLength, etRegex);
        }
    }

    void setListeners() {
        btnApplyValidations.setOnClickListener(this);
        btnValidate.setOnClickListener(this);

        cbRequired.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                handleRequiredView(isChecked);
            }
        });

        cbMinLength.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                handleMinLengthView(isChecked);
            }
        });

        cbRegex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                handleRegexView(isChecked);
            }
        });

        cbCustom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                handleCustomValidationView(isChecked);
            }
        });

        spRegex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        etRegex.setText(null);
                        etRegex.setEnabled(true);
                        break;
                    case 1:
                        etRegex.setText("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
                        etRegex.setEnabled(false);
                        break;
                    case 2:
                        etRegex.setText("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.])[A-Za-z\\d@$!%*?&.]{6,}$");
                        etRegex.setEnabled(false);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    void init() {
        etText = findViewById(R.id.et_text);

        cbRequired  = findViewById(R.id.cb_required);
        cbMinLength = findViewById(R.id.cb_min_length);
        cbRegex     = findViewById(R.id.cb_regex);
        cbCustom    = findViewById(R.id.cb_custom);

        spRegex = findViewById(R.id.sp_regex);

        etRequiredMsg  = findViewById(R.id.et_required_msg);
        etMinLength    = findViewById(R.id.et_min_length);
        etMinLengthMsg = findViewById(R.id.et_min_length_msg);
        etRegex        = findViewById(R.id.et_regex);
        etRegexMsg     = findViewById(R.id.et_regex_msg);
        etCustomMsg    = findViewById(R.id.et_custom_msg);

        layoutSpRegex = findViewById(R.id.layout_sp_regex);

        btnApplyValidations = findViewById(R.id.btn_apply);
        btnValidate         = findViewById(R.id.btn_validator);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_apply:
                applyValidations();
                etText.setError(null);
                Toast.makeText(this, "Validation Applied Successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_validator:
                etText.setError(null);
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    void handleRequiredView(boolean isChecked) {
        if (isChecked) {
            etRequiredMsg.setVisibility(View.VISIBLE);
        } else {
            etRequiredMsg.setVisibility(View.GONE);
        }
    }

    void handleMinLengthView(boolean isChecked) {
        if (isChecked) {
            etMinLengthMsg.setVisibility(View.VISIBLE);
            etMinLength.setVisibility(View.VISIBLE);
        } else {
            etMinLengthMsg.setVisibility(View.GONE);
            etMinLength.setVisibility(View.GONE);
        }
    }

    void handleRegexView(boolean isChecked) {
        if (isChecked) {
            etRegexMsg.setVisibility(View.VISIBLE);
            etRegex.setVisibility(View.VISIBLE);
            layoutSpRegex.setVisibility(View.VISIBLE);
        } else {
            etRegexMsg.setVisibility(View.GONE);
            etRegex.setVisibility(View.GONE);
            layoutSpRegex.setVisibility(View.GONE);
        }
    }
    
    void handleCustomValidationView(boolean isChecked) {
        if (isChecked) {
            etCustomMsg.setVisibility(View.VISIBLE);
        } else {
            etCustomMsg.setVisibility(View.GONE);
        }
    }

}