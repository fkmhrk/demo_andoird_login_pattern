package jp.fkmsoft.demo.loginpattern.page.login;

/**
 * App for Login Page
 */
public interface LoginApp {
    void performLogin(String username, String password);

    void cancelRequest();
}
