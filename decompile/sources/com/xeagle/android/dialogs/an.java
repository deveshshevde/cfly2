package com.xeagle.android.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import java.util.Locale;

public class an extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    protected a f22581a;

    /* renamed from: b  reason: collision with root package name */
    private long f22582b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f22583c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22584d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22585e;

    /* renamed from: f  reason: collision with root package name */
    private String f22586f;

    /* renamed from: g  reason: collision with root package name */
    private IButton f22587g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22588h;

    /* renamed from: i  reason: collision with root package name */
    private ProgressBar f22589i;

    /* renamed from: j  reason: collision with root package name */
    private long f22590j = 0;

    /* renamed from: k  reason: collision with root package name */
    private String f22591k;

    public interface a {
        void a();
    }

    public an(Activity activity, String str, String str2, long j2, a aVar) {
        super(activity, R.style.dialog);
        this.f22586f = str;
        this.f22591k = str2;
        this.f22590j = j2;
        this.f22581a = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a aVar = this.f22581a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(int i2) {
    }

    public void a(long j2) {
        if (j2 != 0) {
            long j3 = this.f22590j;
            if (j3 != 0) {
                this.f22582b = (j2 * 100) / j3;
            }
        }
        ProgressBar progressBar = this.f22583c;
        if (progressBar != null) {
            progressBar.setProgress((int) this.f22582b);
        }
        TextView textView = this.f22584d;
        if (textView != null && this.f22583c != null) {
            textView.setText(String.format(Locale.US, "%d / %d", new Object[]{Long.valueOf(this.f22582b), Integer.valueOf(this.f22583c.getMax())}));
        }
    }

    public void a(String str) {
        TextView textView = this.f22585e;
        if (textView != null) {
            this.f22586f = str;
            textView.setText(str);
        }
    }

    public void a(boolean z2) {
        ProgressBar progressBar = this.f22583c;
        if (progressBar != null) {
            progressBar.setIndeterminate(z2);
        }
    }

    public void b(String str) {
        Log.i("APK", "setNotify_warn: ==============");
        if (this.f22588h != null) {
            Log.i("APK", "setNotify_warn:===== " + str);
            this.f22588h.setText(str);
        }
    }

    public void b(boolean z2) {
        IButton iButton = this.f22587g;
        if (iButton != null) {
            if (z2) {
                if (iButton.getVisibility() == 8) {
                    this.f22587g.setVisibility(0);
                }
            } else if (iButton.getVisibility() == 0) {
                this.f22587g.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = View.inflate(getContext(), R.layout.dlg_download_progress, (ViewGroup) null);
        setContentView(inflate);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.f22583c = progressBar;
        progressBar.setProgress((int) this.f22582b);
        this.f22587g = (IButton) inflate.findViewById(R.id.ib_close);
        this.f22589i = (ProgressBar) inflate.findViewById(R.id.load_view_pb);
        this.f22587g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                an.this.a(view);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.notify_warn);
        this.f22588h = textView;
        textView.setText(this.f22591k);
        this.f22588h.setMovementMethod(ScrollingMovementMethod.getInstance());
        TextView textView2 = (TextView) inflate.findViewById(R.id.notify_title);
        this.f22585e = textView2;
        textView2.setText(this.f22586f);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_progress);
        this.f22584d = textView3;
        textView3.setText(String.format(Locale.US, "%d / %d", new Object[]{Long.valueOf(this.f22582b), Integer.valueOf(this.f22583c.getMax())}));
        if (this.f22582b >= ((long) this.f22583c.getMax())) {
            dismiss();
        }
    }
}
