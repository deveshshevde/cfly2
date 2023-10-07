package com.ctoo.mediaedit.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import com.ctoo.mediaedit.R;

public class a extends ProgressDialog {

    /* renamed from: a  reason: collision with root package name */
    private CircleProgressBar f10814a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f10815b;

    public a(Context context) {
        super(context, R.style.CustomProgressDialog);
    }

    private void a() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.custom_progress_dialog);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        this.f10814a = (CircleProgressBar) findViewById(R.id.loadProgress);
        this.f10815b = (TextView) findViewById(R.id.tv_load_dialog);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        setCancelable(true);
        super.setOnDismissListener(onDismissListener);
    }

    public void show() {
        super.show();
        CircleProgressBar circleProgressBar = this.f10814a;
        if (circleProgressBar != null) {
            circleProgressBar.setProgress(0);
        }
    }
}
