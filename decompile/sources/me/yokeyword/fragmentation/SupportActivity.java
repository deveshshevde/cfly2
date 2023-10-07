package me.yokeyword.fragmentation;

import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class SupportActivity extends AppCompatActivity implements b {

    /* renamed from: a  reason: collision with root package name */
    final d f31093a = new d(this);

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f31093a.a(motionEvent) || super.dispatchTouchEvent(motionEvent);
    }

    public d g() {
        return this.f31093a;
    }

    public FragmentAnimator h() {
        return this.f31093a.b();
    }

    public FragmentAnimator i() {
        return this.f31093a.c();
    }

    public void j() {
        this.f31093a.f();
    }

    public final void onBackPressed() {
        this.f31093a.e();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f31093a.a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f31093a.g();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f31093a.b(bundle);
    }
}
