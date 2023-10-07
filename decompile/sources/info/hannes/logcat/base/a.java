package info.hannes.logcat.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.c;
import info.hannes.logcat.R;
import java.util.HashMap;
import kotlin.jvm.internal.h;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public static final C0188a f28638a = new C0188a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f28639b;

    /* renamed from: info.hannes.logcat.base.a$a  reason: collision with other inner class name */
    public static final class C0188a {
        private C0188a() {
        }

        public /* synthetic */ C0188a(f fVar) {
            this();
        }
    }

    static final class b implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f28640a = new b();

        b() {
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            return i2 == 4;
        }
    }

    public void a() {
        HashMap hashMap = this.f28639b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        setCancelable(false);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        h.b(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.requestWindowFeature(1);
        Bundle arguments = getArguments();
        boolean z2 = false;
        if (arguments != null) {
            z2 = arguments.getBoolean("CANCELABLE", false);
        }
        onCreateDialog.setCancelable(z2);
        if (!z2) {
            onCreateDialog.setOnKeyListener(b.f28640a);
        }
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.d(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.loading_dialog, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ((TextView) inflate.findViewById(R.id.loadingText)).setText(arguments.getInt("MESSAGE_ID", R.string.placeholder));
        }
        return inflate;
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            Dialog dialog = getDialog();
            h.a((Object) dialog);
            dialog.setDismissMessage((Message) null);
        }
        super.onDestroyView();
        a();
    }
}
