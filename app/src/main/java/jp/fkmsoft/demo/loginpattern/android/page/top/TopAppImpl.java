package jp.fkmsoft.demo.loginpattern.android.page.top;

import jp.fkmsoft.demo.loginpattern.page.top.TopApp;
import jp.fkmsoft.demo.loginpattern.page.top.TopUI;

/**
 * Implementation of {@link jp.fkmsoft.demo.loginpattern.page.top.TopApp}
 */
class TopAppImpl implements TopApp {

    private final TopUI mUI;

    TopAppImpl(TopUI ui) {
        this.mUI = ui;
    }

    @Override
    public void showSignupPage() {
        mUI.showSignupPage();
    }

    @Override
    public void showLoginPage() {
        mUI.showLoginPage();
    }
}
