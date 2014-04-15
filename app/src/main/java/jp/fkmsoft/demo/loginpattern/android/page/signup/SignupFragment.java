package jp.fkmsoft.demo.loginpattern.android.page.signup;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.fkmsoft.demo.loginpattern.R;
import jp.fkmsoft.demo.loginpattern.ViewUtils;
import jp.fkmsoft.demo.loginpattern.page.signup.SignupApp;
import jp.fkmsoft.demo.loginpattern.page.signup.SignupUI;

/**
 * Fragment for Signup Page
 */
public class SignupFragment extends Fragment {
    public static SignupFragment newInstance() {
        SignupFragment fragment = new SignupFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    private SignupUI mUI;
    private SignupApp mApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_signup, container, false);

        ViewUtils.setClickListener(root, mClickListener, R.id.button_submit);

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.mUI = new SignupUIImpl(this);
        this.mApp = new SignupAppImpl(mUI);
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            case R.id.button_submit:
                mApp.performSignup(mUI.getUsername(), mUI.getPassword());
                break;
            }
        }
    };
}
