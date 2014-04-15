package jp.fkmsoft.demo.loginpattern.android.page.login;

import jp.fkmsoft.demo.loginpattern.android.utils.AppUtils;
import jp.fkmsoft.demo.loginpattern.page.login.LoginApp;
import jp.fkmsoft.demo.loginpattern.page.login.LoginUI;

/**
 * Implementation of {@link jp.fkmsoft.demo.loginpattern.page.login.LoginApp}
 */
class LoginAppImpl implements LoginApp {

    private final LoginUI mUI;

    LoginAppImpl(LoginUI ui) {
        this.mUI = ui;
    }

    @Override
    public void performLogin(String username, String password) {
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

    @Override
    public void cancelRequest() {
        mUI.hideProgress();
    }
}
