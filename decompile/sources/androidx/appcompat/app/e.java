package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import f.b;
import t.g;

public class e extends Dialog implements c {

    /* renamed from: a  reason: collision with root package name */
    private d f660a;

    /* renamed from: b  reason: collision with root package name */
    private final g.a f661b = new g.a() {
        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return e.this.a(keyEvent);
        }
    };

    public e(Context context, int i2) {
        super(context, a(context, i2));
        d b2 = b();
        b2.a(a(context, i2));
        b2.a((Bundle) null);
    }

    private static int a(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public boolean a(int i2) {
        return b().d(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b().b(view, layoutParams);
    }

    public d b() {
        if (this.f660a == null) {
            this.f660a = d.a((Dialog) this, (c) this);
        }
        return this.f660a;
    }

    public void dismiss() {
        super.dismiss();
        b().g();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return g.a(this.f661b, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i2) {
        return b().b(i2);
    }

    public void invalidateOptionsMenu() {
        b().f();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        b().i();
        super.onCreate(bundle);
        b().a(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        b().d();
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void setContentView(int i2) {
        b().c(i2);
    }

    public void setContentView(View view) {
        b().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b().a(view, layoutParams);
    }

    public void setTitle(int i2) {
        super.setTitle(i2);
        b().a((CharSequence) getContext().getString(i2));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        b().a(charSequence);
    }
}
