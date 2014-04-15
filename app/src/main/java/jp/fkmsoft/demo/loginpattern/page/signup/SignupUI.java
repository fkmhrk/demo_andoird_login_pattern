package jp.fkmsoft.demo.loginpattern.page.signup;

/**
 * UI for Signup Page
 */
public interface SignupUI {
    public static final int REQUEST_PROGRESS = 1000;

    String getUsername();

    String getPassword();

    void showEmptyUsernameError();

    void showEmptyPasswordError();

    void showProgress();
}
