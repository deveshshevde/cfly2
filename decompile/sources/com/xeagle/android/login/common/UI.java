package com.xeagle.android.login.common;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import com.flypro.core.util.e;
import com.xeagle.android.utils.r;
import java.util.ArrayList;
import java.util.List;

public abstract class UI extends AppCompatActivity {
    private static Handler handler;
    private boolean destroyed = false;
    public e function;
    private Toolbar toolbar;

    private void invokeFragmentManagerNoteStateNotSaved() {
        r.a(getSupportFragmentManager(), "noteStateNotSaved", (Object[]) null);
    }

    private boolean isDestroyedCompatible17() {
        return super.isDestroyed();
    }

    public TFragment addFragment(TFragment tFragment) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(tFragment);
        return addFragments(arrayList).get(0);
    }

    public List<TFragment> addFragments(List<TFragment> list) {
        ArrayList arrayList = new ArrayList(list.size());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        s a2 = supportFragmentManager.a();
        boolean z2 = false;
        for (int i2 = 0; i2 < list.size(); i2++) {
            TFragment tFragment = list.get(i2);
            int containerId = tFragment.getContainerId();
            TFragment tFragment2 = (TFragment) supportFragmentManager.d(containerId);
            if (tFragment2 == null) {
                a2.a(containerId, (Fragment) tFragment);
                z2 = true;
            } else {
                tFragment = tFragment2;
            }
            arrayList.add(i2, tFragment);
        }
        if (z2) {
            try {
                a2.d();
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public boolean displayHomeAsUpEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findView(int i2) {
        return findViewById(i2);
    }

    /* access modifiers changed from: protected */
    public final Handler getHandler() {
        if (handler == null) {
            handler = new Handler(getMainLooper());
        }
        return handler;
    }

    public Toolbar getToolBar() {
        return this.toolbar;
    }

    public int getToolBarHeight() {
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 != null) {
            return toolbar2.getHeight();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean isCompatible(int i2) {
        return Build.VERSION.SDK_INT >= i2;
    }

    public boolean isDestroyedCompatible() {
        return Build.VERSION.SDK_INT >= 17 ? isDestroyedCompatible17() : this.destroyed || super.isFinishing();
    }

    public void onBackPressed() {
        invokeFragmentManagerNoteStateNotSaved();
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        this.function = new e(getApplicationContext());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.destroyed = true;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return i2 != 82 ? super.onKeyDown(i2, keyEvent) : onMenuKeyDown();
    }

    /* access modifiers changed from: protected */
    public boolean onMenuKeyDown() {
        return false;
    }

    public void onNavigateUpClicked() {
        onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onNavigateUpClicked();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    public void setSubTitle(String str) {
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 != null) {
            toolbar2.setSubtitle((CharSequence) str);
        }
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 != null) {
            toolbar2.setTitle(charSequence);
        }
    }

    public void setToolBar(int i2, int i3, int i4) {
        Toolbar toolbar2 = (Toolbar) findViewById(i2);
        this.toolbar = toolbar2;
        toolbar2.setTitle(i3);
        this.toolbar.setLogo(i4);
        setSupportActionBar(this.toolbar);
    }

    public void setToolBar(int i2, ToolBarOptions toolBarOptions) {
        this.toolbar = (Toolbar) findViewById(i2);
        if (toolBarOptions.titleId != 0) {
            this.toolbar.setTitle(toolBarOptions.titleId);
        }
        if (!TextUtils.isEmpty(toolBarOptions.titleString)) {
            this.toolbar.setTitle((CharSequence) toolBarOptions.titleString);
        }
        if (toolBarOptions.logoId != 0) {
            this.toolbar.setLogo(toolBarOptions.logoId);
        }
        setSupportActionBar(this.toolbar);
        if (toolBarOptions.isNeedNavigate) {
            this.toolbar.setNavigationIcon(toolBarOptions.navigateId);
            this.toolbar.setContentInsetStartWithNavigation(0);
            this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    UI.this.onNavigateUpClicked();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void showKeyboard(boolean z2) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (z2) {
            if (getCurrentFocus() == null) {
                inputMethodManager.toggleSoftInput(2, 0);
            } else {
                inputMethodManager.showSoftInput(getCurrentFocus(), 0);
            }
        } else if (getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
    }

    /* access modifiers changed from: protected */
    public void showKeyboardDelayed(final View view) {
        if (view != null) {
            view.requestFocus();
        }
        getHandler().postDelayed(new Runnable() {
            public void run() {
                View view = view;
                if (view == null || view.isFocused()) {
                    UI.this.showKeyboard(true);
                }
            }
        }, 200);
    }

    public TFragment switchContent(TFragment tFragment) {
        return switchContent(tFragment, false);
    }

    /* access modifiers changed from: protected */
    public TFragment switchContent(TFragment tFragment, boolean z2) {
        s a2 = getSupportFragmentManager().a();
        a2.b(tFragment.getContainerId(), tFragment);
        if (z2) {
            a2.a((String) null);
        }
        try {
            a2.d();
        } catch (Exception unused) {
        }
        return tFragment;
    }

    /* access modifiers changed from: protected */
    public void switchFragmentContent(TFragment tFragment) {
        s a2 = getSupportFragmentManager().a();
        a2.b(tFragment.getContainerId(), tFragment);
        try {
            a2.d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
