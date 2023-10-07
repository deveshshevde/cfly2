package androidx.appcompat.app;

import a.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ak;
import androidx.core.app.f;
import androidx.core.app.o;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ae;
import androidx.lifecycle.af;
import androidx.savedstate.a;
import androidx.savedstate.d;
import f.b;

public class AppCompatActivity extends FragmentActivity implements c, o.a {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private d mDelegate;
    private Resources mResources;

    public AppCompatActivity() {
        initDelegate();
    }

    public AppCompatActivity(int i2) {
        super(i2);
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().a(DELEGATE_TAG, (a.b) new a.b() {
            public Bundle a() {
                Bundle bundle = new Bundle();
                AppCompatActivity.this.getDelegate().c(bundle);
                return bundle;
            }
        });
        addOnContextAvailableListener(new b() {
            public void a(Context context) {
                d delegate = AppCompatActivity.this.getDelegate();
                delegate.i();
                delegate.a(AppCompatActivity.this.getSavedStateRegistry().a(AppCompatActivity.DELEGATE_TAG));
            }
        });
    }

    private void initViewTreeOwners() {
        ae.a(getWindow().getDecorView(), this);
        af.a(getWindow().getDecorView(), this);
        d.a(getWindow().getDecorView(), this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r0 = getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean performMenuItemShortcut(android.view.KeyEvent r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x003e
            boolean r0 = r3.isCtrlPressed()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getMetaState()
            boolean r0 = android.view.KeyEvent.metaStateHasNoModifiers(r0)
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getRepeatCount()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getKeyCode()
            boolean r0 = android.view.KeyEvent.isModifierKey(r0)
            if (r0 != 0) goto L_0x003e
            android.view.Window r0 = r2.getWindow()
            if (r0 == 0) goto L_0x003e
            android.view.View r1 = r0.getDecorView()
            if (r1 == 0) goto L_0x003e
            android.view.View r0 = r0.getDecorView()
            boolean r3 = r0.dispatchKeyShortcutEvent(r3)
            if (r3 == 0) goto L_0x003e
            r3 = 1
            return r3
        L_0x003e:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatActivity.performMenuItemShortcut(android.view.KeyEvent):boolean");
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().b(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().b(context));
    }

    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.f()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.a(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public <T extends View> T findViewById(int i2) {
        return getDelegate().b(i2);
    }

    public d getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = d.a((Activity) this, (c) this);
        }
        return this.mDelegate;
    }

    public a.C0017a getDrawerToggleDelegate() {
        return getDelegate().h();
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().b();
    }

    public Resources getResources() {
        if (this.mResources == null && ak.a()) {
            this.mResources = new ak(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().a();
    }

    public Intent getSupportParentActivityIntent() {
        return f.b(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().f();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().a(configuration);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(o oVar) {
        oVar.a((Activity) this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getDelegate().g();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.a() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onNightModeChanged(int i2) {
    }

    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        getDelegate().e();
    }

    public void onPrepareSupportNavigateUpTaskStack(o oVar) {
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getDelegate().c();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().d();
    }

    public void onSupportActionModeFinished(f.b bVar) {
    }

    public void onSupportActionModeStarted(f.b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            o a2 = o.a((Context) this);
            onCreateSupportNavigateUpTaskStack(a2);
            onPrepareSupportNavigateUpTaskStack(a2);
            a2.a();
            try {
                androidx.core.app.a.a(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getDelegate().a(charSequence);
    }

    public f.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.e()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i2) {
        initViewTreeOwners();
        getDelegate().c(i2);
    }

    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().a(view, layoutParams);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().a(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i2) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z2) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z2) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z2) {
    }

    public void setTheme(int i2) {
        super.setTheme(i2);
        getDelegate().a(i2);
    }

    public f.b startSupportActionMode(b.a aVar) {
        return getDelegate().a(aVar);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().f();
    }

    public void supportNavigateUpTo(Intent intent) {
        f.b((Activity) this, intent);
    }

    public boolean supportRequestWindowFeature(int i2) {
        return getDelegate().d(i2);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return f.a((Activity) this, intent);
    }
}
