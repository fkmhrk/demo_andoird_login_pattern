package jp.fkmsoft.demo.loginpattern.android.page.signup;

import jp.fkmsoft.demo.loginpattern.android.utils.AppUtils;
import jp.fkmsoft.demo.loginpattern.page.signup.SignupApp;
import jp.fkmsoft.demo.loginpattern.page.signup.SignupUI;

/**
 * Implementation of {@link jp.fkmsoft.demo.loginpattern.page.signup.SignupApp}
 */
class SignupAppImpl implements SignupApp {

    private final SignupUI mUI;

    SignupAppImpl(SignupUI ui) {
        this.mUI = ui;
    }

    @Override
    public void performSignup(String username, String password) {
        if (AppUtils.isEmpty(username)) {
            mUI.showEmptyUsernameError();
            return;
        }
        if (AppUtils.isEmpty(password)) {
            mUI.showEmptyPasswordError();
            return;
        }

        mUI.showProgress();
    }
}
