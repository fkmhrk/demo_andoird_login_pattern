package jp.fkmsoft.demo.loginpattern;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/**
 * Utility class for View
 */
public class ViewUtils {
    public static void toNextFragment(FragmentManager manager, Fragment next, String tag) {
        if (manager == null) { return; }
        FragmentTransaction transaction = manager.beginTransaction();
        if (tag != null) {
            transaction.addToBackStack(tag);
        }
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.replace(R.id.content, next);

        transaction.commit();
    }

    public static void setClickListener(View root, View.OnClickListener listener, int... ids) {
        if (root == null) { return; }
        for (int id : ids) {
            View view = root.findViewById(id);
            if (view == null) { continue; }
            view.setOnClickListener(listener);
        }
    }

    public static String getValueOfEditText(View root, int id) {
        EditText edit = (EditText) root.findViewById(id);
        if (edit == null) { return null; }
        Editable text = edit.getText();
        if (text == null) { return null; }
        return text.toString();
    }

    public static void setEnabled(View root, int id, boolean value) {
        root.findViewById(id).setEnabled(value);
    }
}
