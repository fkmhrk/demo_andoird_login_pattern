package jp.fkmsoft.demo.loginpattern.android.page.top;

import java.lang.ref.WeakReference;

import jp.fkmsoft.demo.loginpattern.ViewUtils;
import jp.fkmsoft.demo.loginpattern.android.page.login.LoginFragment;
import jp.fkmsoft.demo.loginpattern.android.page.signup.SignupFragment;
import jp.fkmsoft.demo.loginpattern.page.top.TopUI;

/**
 * Implementation of {@link jp.fkmsoft.demo.loginpattern.page.top.TopUI}
 */
class TopUIImpl implements TopUI {

    private WeakReference<TopFragment> mFragmentRef;

    TopUIImpl(TopFragment fragment) {
        this.mFragmentRef = new WeakReference<TopFragment>(fragment);
    }

    private TopFragment getFragment() {
        return mFragmentRef.get();
    }

    @Override
    public void showSignupPage() {
        TopFragment fragment = getFragment();
        if (fragment == null) { return; }

        ViewUtils.toNextFragment(fragment.getFragmentManager(), SignupFragment.newInstance(), "Top");
    }

    @Override
    public void showLoginPage() {
        TopFragment fragment = getFragment();
        if (fragment == null) { return; }

        ViewUtils.toNextFragment(fragment.getFragmentManager(), LoginFragment.newInstance(), "Top");
    }
}
