package jp.fkmsoft.demo.loginpattern.page.login;

/**
 * UI for Login Page
 */
public interface LoginUI {
    String getUsername();

    String getPassword();

    void showEmptyUsernameError();

    void showEmptyPasswordError();

    void showProgress();

    boolean isInProgress();

    void hideProgress();
}
