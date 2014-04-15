package jp.fkmsoft.demo.loginpattern.android.page.login;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.fkmsoft.demo.loginpattern.R;
import jp.fkmsoft.demo.loginpattern.ViewUtils;
import jp.fkmsoft.demo.loginpattern.page.login.LoginApp;
import jp.fkmsoft.demo.loginpattern.page.login.LoginUI;

/**
 * Fragment for Login Page
 */
public class LoginFragment extends Fragment {
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    private LoginUI mUI;
    private LoginApp mApp;

    private boolean mInProgress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        ViewUtils.setClickListener(root, mCickListener, R.id.button_submit);

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.mUI = new LoginUIImpl(this);
        this.mApp = new LoginAppImpl(mUI);

        this.mInProgress = false;
    }

    private View.OnClickListener mCickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            case R.id.button_submit:
                if (mUI.isInProgress()) {
                    mApp.cancelRequest();
                } else {
                    mApp.performLogin(mUI.getUsername(), mUI.getPassword());
                }
                break;
            }
        }
    };

    boolean isInProgress() {
        return mInProgress;
    }

    void setInProgress(boolean value) {
        this.mInProgress = value;
    }
}
