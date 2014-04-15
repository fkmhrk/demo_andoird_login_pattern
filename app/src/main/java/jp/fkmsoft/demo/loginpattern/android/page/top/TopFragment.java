package jp.fkmsoft.demo.loginpattern.android.page.top;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.fkmsoft.demo.loginpattern.R;
import jp.fkmsoft.demo.loginpattern.ViewUtils;
import jp.fkmsoft.demo.loginpattern.page.top.TopApp;
import jp.fkmsoft.demo.loginpattern.page.top.TopUI;

/**
 * Fragment for Top Page
 */
public class TopFragment extends Fragment {
    public static TopFragment newInstance() {
        TopFragment fragment = new TopFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    private TopUI mUI;
    private TopApp mApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_top, container, false);

        ViewUtils.setClickListener(root, clickListener, R.id.button_dialog, R.id.button_disabled);

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.mUI = new TopUIImpl(this);
        this.mApp = new TopAppImpl(mUI);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            case R.id.button_dialog:
                mApp.showSignupPage();
                break;
            case R.id.button_disabled:
                mApp.showLoginPage();
                break;
            }
        }
    };


}
