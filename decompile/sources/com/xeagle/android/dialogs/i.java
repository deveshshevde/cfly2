package com.xeagle.android.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import java.util.Locale;

public class i extends a {

    /* renamed from: b  reason: collision with root package name */
    protected a f22661b;

    /* renamed from: c  reason: collision with root package name */
    private long f22662c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f22663d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22664e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22665f;

    /* renamed from: g  reason: collision with root package name */
    private String f22666g;

    /* renamed from: h  reason: collision with root package name */
    private IButton f22667h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f22668i;

    /* renamed from: j  reason: collision with root package name */
    private ProgressBar f22669j;

    /* renamed from: k  reason: collision with root package name */
    private long f22670k = 0;

    public interface a {
        void a();
    }

    protected i() {
    }

    public static i a(String str, String str2, long j2, a aVar) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putString("extra_download_title", str);
        bundle.putLong("extra_download_size", j2);
        bundle.putString("extra_download_warn", str2);
        iVar.setArguments(bundle);
        iVar.f22661b = aVar;
        return iVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a aVar = this.f22661b;
        if (aVar != null) {
            aVar.a();
        }
        dismiss();
    }

    public int a() {
        ProgressBar progressBar = this.f22663d;
        return progressBar != null ? progressBar.getProgress() : (int) this.f22662c;
    }

    public void a(int i2) {
    }

    public void a(long j2) {
        if (j2 != 0) {
            long j3 = this.f22670k;
            if (j3 != 0) {
                this.f22662c = (j2 * 100) / j3;
            }
        }
        ProgressBar progressBar = this.f22663d;
        if (progressBar != null) {
            progressBar.setProgress((int) this.f22662c);
        }
        TextView textView = this.f22664e;
        if (textView != null && this.f22663d != null) {
            textView.setText(String.format(Locale.US, "%d / %d", new Object[]{Long.valueOf(this.f22662c), Integer.valueOf(this.f22663d.getMax())}));
        }
    }

    public void a(String str) {
        TextView textView = this.f22665f;
        if (textView != null) {
            this.f22666g = str;
            textView.setText(str);
        }
    }

    public void a(boolean z2) {
        IButton iButton = this.f22667h;
        if (iButton != null) {
            if (z2) {
                if (iButton.getVisibility() == 8) {
                    this.f22667h.setVisibility(0);
                }
            } else if (iButton.getVisibility() == 0) {
                this.f22667h.setVisibility(8);
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 4;
            }
        });
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dlg_download_progress, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.upgrade_warning);
        String str = "";
        if (arguments != null) {
            str = arguments.getString("extra_download_title", str);
            this.f22670k = arguments.getLong("extra_download_size", this.f22670k);
            string = arguments.getString("extra_download_warn", string);
        }
        Log.i("APK", "onCreateView:------file size---- " + this.f22670k);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.f22663d = progressBar;
        progressBar.setProgress((int) this.f22662c);
        this.f22667h = (IButton) inflate.findViewById(R.id.ib_close);
        this.f22669j = (ProgressBar) inflate.findViewById(R.id.load_view_pb);
        this.f22667h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.this.a(view);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.notify_warn);
        this.f22668i = textView;
        textView.setText(string);
        this.f22668i.setMovementMethod(ScrollingMovementMethod.getInstance());
        TextView textView2 = (TextView) inflate.findViewById(R.id.notify_title);
        this.f22665f = textView2;
        textView2.setText(str);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_progress);
        this.f22664e = textView3;
        textView3.setText(String.format(Locale.US, "%d / %d", new Object[]{Long.valueOf(this.f22662c), Integer.valueOf(this.f22663d.getMax())}));
        if (this.f22662c >= ((long) this.f22663d.getMax())) {
            dismiss();
        }
        return inflate;
    }
}
