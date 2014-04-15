package jp.fkmsoft.demo.loginpattern.android.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;

/**
 * Dialog for displaying progress
 */
public class ProgressDialogFragment extends DialogFragment {
    public static final String FRGMENT_TAG = "progress";

    public static ProgressDialogFragment newInstance(Fragment target, int requestCode) {
        ProgressDialogFragment fragment = new ProgressDialogFragment();
        fragment.setTargetFragment(target, requestCode);

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        ProgressDialog dialog = new ProgressDialog(getActivity());
        return dialog;
    }
}
