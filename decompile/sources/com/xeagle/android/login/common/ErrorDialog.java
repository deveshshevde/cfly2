package com.xeagle.android.login.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.cfly.uav_pro.R;

public class ErrorDialog extends DialogFragment {
    private static final String ARG_MESSAGE = "message";

    public static ErrorDialog newInstance(String str) {
        ErrorDialog errorDialog = new ErrorDialog();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_MESSAGE, str);
        errorDialog.setArguments(bundle);
        return errorDialog;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        final Activity activity = getActivity();
        return new AlertDialog.Builder(activity).setMessage(getArguments().getString(ARG_MESSAGE)).setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                activity.finish();
            }
        }).create();
    }
}
