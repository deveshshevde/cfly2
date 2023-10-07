package com.xeagle.android.login.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.core.app.a;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.pickImage.CaptureActivity;

public class ConfirmationDialog extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        return new AlertDialog.Builder(getActivity()).setMessage(R.string.permission_request).setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                a.a(ConfirmationDialog.this.getActivity(), CaptureActivity.VIDEO_PERMISSIONS, 1);
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                ConfirmationDialog.this.getActivity().finish();
            }
        }).create();
    }
}
