package com.cloudbufferfly.uicorelib.baseview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.x;
import bf.a;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import me.yokeyword.fragmentation.b;
import me.yokeyword.fragmentation.d;

public abstract class SupportActivity extends AppCompatActivity implements g, b {

    /* renamed from: a  reason: collision with root package name */
    private final l f10688a = new l();

    /* renamed from: b  reason: collision with root package name */
    private boolean f10689b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10690c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f10691d = new Handler();

    /* renamed from: e  reason: collision with root package name */
    private final k f10692e = new k(this);

    /* renamed from: f  reason: collision with root package name */
    private final d f10693f = new d(this);

    /* access modifiers changed from: protected */
    public void a() {
        if (!this.f10690c) {
            this.f10690c = true;
            this.f10693f.g();
            this.f10692e.a();
            this.f10688a.k();
            this.f10691d.removeCallbacksAndMessages((Object) null);
        }
    }

    public void a(FragmentManager fragmentManager, int i2, int i3, Intent intent) {
        List<Fragment> c2;
        if (fragmentManager != null && (c2 = x.c(fragmentManager)) != null && c2.size() > 0) {
            int i4 = 0;
            int size = c2.size();
            while (i4 < size) {
                Fragment fragment = c2.get(i4);
                if (fragment != null) {
                    Fragment fragment2 = fragment;
                    if (fragment2 != null) {
                        fragment2.onActivityResult(i2, i3, intent);
                        a(fragment2.getChildFragmentManager(), i2, i3, intent);
                    }
                    i4++;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
                }
            }
        }
    }

    public void a(i iVar) {
        this.f10688a.a(iVar);
    }

    public void b(i iVar) {
        this.f10688a.b(iVar);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f10693f.a(motionEvent) || super.dispatchTouchEvent(motionEvent);
    }

    public android.app.FragmentManager getFragmentManager() {
        return super.getFragmentManager();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.f10689b = false;
        this.f10688a.a(i2, i3, intent);
        a(getSupportFragmentManager(), i2, i3, intent);
    }

    public void onBackPressed() {
        this.f10693f.e();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10693f.a(bundle);
        a.a().a((Object) this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (!this.f10690c) {
            a();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f10688a.a(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f10688a.h();
        if (!this.f10690c && isFinishing()) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f10693f.b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        h.c(bundle, "savedInstanceState");
        this.f10689b = false;
        super.onRestoreInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f10689b = false;
        this.f10688a.g();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        h.c(bundle, "outState");
        this.f10689b = true;
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f10688a.f();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f10688a.i();
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        this.f10688a.onWindowFocusChanged(z2);
    }
}
