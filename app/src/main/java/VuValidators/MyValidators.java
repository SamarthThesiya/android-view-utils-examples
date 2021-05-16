package VuValidators;

import android.text.TextUtils;

import models.Validations;
import utils.VuValidationMethods;

public class MyValidators extends VuValidationMethods {

    public static final String START_WITH_PLUS = "startWithPlus";
    public static final String END_WITH_PLUS   = "endWithPlus";

    public boolean startWithPlus(Validations.Validation validation) {
        if (TextUtils.isEmpty(vuValidatable.getText())) {
            validation.setMessage("Should start with '+'");
            return false;
        }

        if (vuValidatable.getText().toString().toCharArray()[0] != '+') {
            if (TextUtils.isEmpty(validation.getMessage())) {
                validation.setMessage("Should start with '+'");
            }
            return false;
        }
        return true;
    }
}
