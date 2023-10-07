package androidx.fragment.app;

import a.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.c;
import androidx.activity.result.d;
import androidx.core.app.a;
import androidx.core.app.n;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ac;
import androidx.lifecycle.ad;
import androidx.lifecycle.o;
import androidx.savedstate.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends ComponentActivity implements a.C0025a, a.c {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final o mFragmentLifecycleRegistry = new o(this);
    final f mFragments = f.a((h<?>) new a());
    boolean mResumed;
    boolean mStopped = true;

    class a extends h<FragmentActivity> implements c, d, m, ad {
        public a() {
            super(FragmentActivity.this);
        }

        public View a(int i2) {
            return FragmentActivity.this.findViewById(i2);
        }

        public void a(FragmentManager fragmentManager, Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean a() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public boolean a(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        public boolean a(String str) {
            return androidx.core.app.a.a((Activity) FragmentActivity.this, str);
        }

        public LayoutInflater b() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        /* renamed from: c */
        public FragmentActivity e() {
            return FragmentActivity.this;
        }

        public void d() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        public androidx.activity.result.c getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        public Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        public ac getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }
    }

    public FragmentActivity() {
        init();
    }

    public FragmentActivity(int i2) {
        super(i2);
        init();
    }

    private void init() {
        getSavedStateRegistry().a(FRAGMENTS_TAG, (a.b) new a.b() {
            public Bundle a() {
                Bundle bundle = new Bundle();
                FragmentActivity.this.markFragmentsCreated();
                FragmentActivity.this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_STOP);
                Parcelable c2 = FragmentActivity.this.mFragments.c();
                if (c2 != null) {
                    bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, c2);
                }
                return bundle;
            }
        });
        addOnContextAvailableListener(new b() {
            public void a(Context context) {
                FragmentActivity.this.mFragments.a((Fragment) null);
                Bundle a2 = FragmentActivity.this.getSavedStateRegistry().a(FragmentActivity.FRAGMENTS_TAG);
                if (a2 != null) {
                    FragmentActivity.this.mFragments.a(a2.getParcelable(FragmentActivity.FRAGMENTS_TAG));
                }
            }
        });
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z2 = false;
        for (Fragment next : fragmentManager.g()) {
            if (next != null) {
                if (next.getHost() != null) {
                    z2 |= markState(next.getChildFragmentManager(), state);
                }
                if (next.mViewLifecycleOwner != null && next.mViewLifecycleOwner.getLifecycle().a().a(Lifecycle.State.STARTED)) {
                    next.mViewLifecycleOwner.a(state);
                    z2 = true;
                }
                if (next.mLifecycleRegistry.a().a(Lifecycle.State.STARTED)) {
                    next.mLifecycleRegistry.b(state);
                    z2 = true;
                }
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.a(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            ac.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.a().a(str, fileDescriptor, printWriter, strArr);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.a();
    }

    @Deprecated
    public ac.a getSupportLoaderManager() {
        return ac.a.a(this);
    }

    /* access modifiers changed from: package-private */
    public void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.mFragments.b();
        super.onActivityResult(i2, i3, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.b();
        this.mFragments.a(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_CREATE);
        this.mFragments.d();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return i2 == 0 ? super.onCreatePanelMenu(i2, menu) | this.mFragments.a(menu, getMenuInflater()) : super.onCreatePanelMenu(i2, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView((View) null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.k();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.mFragments.a(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.mFragments.b(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z2) {
        this.mFragments.a(z2);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.b();
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.mFragments.b(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z2) {
        this.mFragments.b(z2);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return i2 == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.a(menu) : super.onPreparePanel(i2, view, menu);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mFragments.b();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.b();
        this.mFragments.l();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_RESUME);
        this.mFragments.g();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.e();
        }
        this.mFragments.b();
        this.mFragments.l();
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_START);
        this.mFragments.f();
    }

    public void onStateNotSaved() {
        this.mFragments.b();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.i();
        this.mFragmentLifecycleRegistry.a(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(n nVar) {
        androidx.core.app.a.a((Activity) this, nVar);
    }

    public void setExitSharedElementCallback(n nVar) {
        androidx.core.app.a.b(this, nVar);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        startActivityFromFragment(fragment, intent, i2, (Bundle) null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            androidx.core.app.a.a(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i2, bundle);
        }
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            androidx.core.app.a.a(this, intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.a.b(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.a.c(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.a.d(this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i2) {
    }
}
