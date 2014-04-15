package jp.fkmsoft.demo.loginpattern.android.page.login;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import jp.fkmsoft.demo.loginpattern.R;
import jp.fkmsoft.demo.loginpattern.ViewUtils;
import jp.fkmsoft.demo.loginpattern.page.login.LoginUI;

/**
 * Implementation of {@link jp.fkmsoft.demo.loginpattern.page.login.LoginUI}
 */
class LoginUIImpl implements LoginUI {

    private WeakReference<LoginFragment> mFragmentRef;

    LoginUIImpl(LoginFragment fragment) {
        this.mFragmentRef = new WeakReference<LoginFragment>(fragment);
    }

    private LoginFragment getFragment() {
        return mFragmentRef.get();
    }

    private View getRootView() {
        LoginFragment fragment = getFragment();
        if (fragment == null) { return null; }
        return fragment.getView();
    }

    private Activity getActivity() {
        Fragment fragment = getFragment();
        if (fragment == null) { return null; }
        return fragment.getActivity();
    }

    @Override
    public String getUsername() {
        return ViewUtils.getValueOfEditText(getRootView(), R.id.edit_username);
    }

    @Override
    public String getPassword() {
        return ViewUtils.getValueOfEditText(getRootView(), R.id.edit_password);
    }

    @Override
    public void showEmptyUsernameError() {
        showToastMessage(R.string.login_error_empty_username);
    }

    @Override
    public void showEmptyPasswordError() {
        showToastMessage(R.string.login_error_empty_password);
    }

    @Override
    public void showProgress() {
        LoginFragment fragment = getFragment();
        if (fragment == null) { return; }
        View root = fragment.getView();
        if (root == null) { return; }
        Activity activity = fragment.getActivity();
        if (activity == null) { return; }

        activity.setProgressBarIndeterminateVisibility(true);

        ViewUtils.setEnabled(root, R.id.edit_username, false);
        ViewUtils.setEnabled(root, R.id.edit_password, false);

        Button button = (Button) root.findViewById(R.id.button_submit);
        button.setText(android.R.string.cancel);

        fragment.setInProgress(true);
    }

    @Override
    public boolean isInProgress() {
        LoginFragment fragment = getFragment();
        if (fragment == null) { return false; }

        return fragment.isInProgress();
    }

    @Override
    public void hideProgress() {
        LoginFragment fragment = getFragment();
        if (fragment == null) { return; }
        View root = fragment.getView();
        if (root == null) { return; }
        Activity activity = fragment.getActivity();
        if (activity == null) { return; }

        activity.setProgressBarIndeterminateVisibility(false);

        ViewUtils.setEnabled(root, R.id.edit_username, true);
        ViewUtils.setEnabled(root, R.id.edit_password, true);

        Button button = (Button) root.findViewById(R.id.button_submit);
        button.setText(R.string.login);

        fragment.setInProgress(false);

    }

    private void showToastMessage(int resId) {
        Activity activity = getActivity();
        if (activity == null) { return; }

        Toast.makeText(activity, activity.getString(resId), Toast.LENGTH_SHORT).show();
    }
}
