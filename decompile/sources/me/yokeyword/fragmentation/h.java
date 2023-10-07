package me.yokeyword.fragmentation;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.x;
import me.yokeyword.fragmentation.exception.AfterSaveStateTransactionWarning;
import me.yokeyword.fragmentation.helper.internal.ResultRecord;
import mw.a;
import mw.b;

class h {

    /* renamed from: a  reason: collision with root package name */
    b f31171a;

    /* renamed from: b  reason: collision with root package name */
    private b f31172b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentActivity f31173c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f31174d;

    h(b bVar) {
        this.f31172b = bVar;
        this.f31173c = (FragmentActivity) bVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f31174d = handler;
        this.f31171a = new b(handler);
    }

    /* access modifiers changed from: private */
    public void a(FragmentManager fragmentManager, String str) {
        if (x.a(fragmentManager)) {
            AfterSaveStateTransactionWarning afterSaveStateTransactionWarning = new AfterSaveStateTransactionWarning(str);
            if (a.a().b() != null) {
                a.a().b().a(afterSaveStateTransactionWarning);
            }
        }
    }

    private void a(FragmentManager fragmentManager, a aVar) {
        if (fragmentManager == null) {
            Log.w("Fragmentation", "FragmentManager is null, skip the action!");
        } else {
            this.f31171a.a(aVar);
        }
    }

    /* access modifiers changed from: private */
    public void b(FragmentManager fragmentManager) {
        try {
            c b2 = g.b(fragmentManager);
            if (b2 != null) {
                fragmentManager.a().c(8194).a((Fragment) b2).d();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        ResultRecord resultRecord;
        try {
            Bundle arguments = fragment.getArguments();
            if (arguments != null && (resultRecord = (ResultRecord) arguments.getParcelable("fragment_arg_result_record")) != null) {
                ((c) fragment.getFragmentManager().a(fragment.getArguments(), "fragmentation_state_save_result")).a(resultRecord.f31177a, resultRecord.f31178b, resultRecord.f31179c);
            }
        } catch (IllegalStateException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(final FragmentManager fragmentManager) {
        a(fragmentManager, (a) new a(1, fragmentManager) {
            public void a() {
                h.this.a(fragmentManager, "pop()");
                x.b(fragmentManager);
                h.this.b(fragmentManager);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean a(c cVar) {
        if (cVar != null) {
            return cVar.l() || a((c) ((Fragment) cVar).getParentFragment());
        }
        return false;
    }
}
