package jp.fkmsoft.demo.loginpattern.android.page.signup;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import jp.fkmsoft.demo.loginpattern.R;
import jp.fkmsoft.demo.loginpattern.ViewUtils;
import jp.fkmsoft.demo.loginpattern.android.dialog.ProgressDialogFragment;
import jp.fkmsoft.demo.loginpattern.page.signup.SignupUI;

/**
 * Implementation of {@link jp.fkmsoft.demo.loginpattern.page.signup.SignupUI}
 */
class SignupUIImpl implements SignupUI {
    private WeakReference<SignupFragment> mFragmentRef;

    SignupUIImpl(SignupFragment fragment) {
        this.mFragmentRef = new WeakReference<SignupFragment>(fragment);
    }

    private SignupFragment getFragment() {
        return mFragmentRef.get();
    }

    private Activity getActivity() {
        Fragment fragment = getFragment();
        if (fragment == null) { return null; }
        return fragment.getActivity();
    }

    private View getRootView() {
        Fragment fragment = getFragment();
        if (fragment == null) { return null; }
        return fragment.getView();
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
        showToastMessage(R.string.signup_error_empty_username);
    }

    @Override
    public void showEmptyPasswordError() {
        showToastMessage(R.string.signup_error_empty_password);
    }

    @Override
    public void showProgress() {
        Fragment fragment = getFragment();
        if (fragment == null) { return; }

        ProgressDialogFragment dialog = ProgressDialogFragment.newInstance(fragment, REQUEST_PROGRESS);
        dialog.show(fragment.getFragmentManager(), ProgressDialogFragment.FRGMENT_TAG);
    }

    private void showToastMessage(int resId) {
        Activity activity = getActivity();
        if (activity == null) { return; }

        Toast.makeText(activity, activity.getString(resId), Toast.LENGTH_SHORT).show();
    }
}
