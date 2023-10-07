package com.xeagle.android.fragments;

import android.app.Dialog;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class d extends PreferenceFragment {
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        getActivity().finish();
        return false;
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (!(preference instanceof PreferenceScreen)) {
            return false;
        }
        final Dialog dialog = ((PreferenceScreen) preference).getDialog();
        View findViewById = dialog.findViewById(16908332);
        if (findViewById == null) {
            return true;
        }
        AnonymousClass1 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        };
        ViewParent parent = findViewById.getParent();
        if (parent instanceof FrameLayout) {
            ViewGroup viewGroup = (ViewGroup) parent.getParent();
            if (viewGroup instanceof LinearLayout) {
                viewGroup.setOnClickListener(r0);
                return true;
            }
            ((FrameLayout) parent).setOnClickListener(r0);
            return true;
        }
        findViewById.setOnClickListener(r0);
        return true;
    }
}
