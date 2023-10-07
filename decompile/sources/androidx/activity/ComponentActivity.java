package androidx.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.d;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ab;
import androidx.lifecycle.ac;
import androidx.lifecycle.ad;
import androidx.lifecycle.ae;
import androidx.lifecycle.af;
import androidx.lifecycle.k;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import androidx.savedstate.b;
import androidx.savedstate.c;
import b.a;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements c, d, ad, n, c {
    private final androidx.activity.result.c mActivityResultRegistry;
    private int mContentLayoutId;
    final a.a mContextAwareHelper;
    private ab.b mDefaultFactory;
    private final o mLifecycleRegistry;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    final b mSavedStateRegistryController;
    private ac mViewModelStore;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        Object f436a;

        /* renamed from: b  reason: collision with root package name */
        ac f437b;

        a() {
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new a.a();
        this.mLifecycleRegistry = new o(this);
        this.mSavedStateRegistryController = b.a((c) this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() {
            public void run() {
                try {
                    ComponentActivity.super.onBackPressed();
                } catch (IllegalStateException e2) {
                    if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e2;
                    }
                }
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new androidx.activity.result.c() {
            public <I, O> void a(final int i2, b.a<I, O> aVar, I i3, androidx.core.app.b bVar) {
                ComponentActivity componentActivity = ComponentActivity.this;
                final a.C0047a<O> b2 = aVar.b(componentActivity, i3);
                if (b2 != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            AnonymousClass2.this.a(i2, b2.a());
                        }
                    });
                    return;
                }
                Intent a2 = aVar.a((Context) componentActivity, i3);
                Bundle bundle = null;
                if (a2.getExtras() != null && a2.getExtras().getClassLoader() == null) {
                    a2.setExtrasClassLoader(componentActivity.getClassLoader());
                }
                if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                    bundle = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                } else if (bVar != null) {
                    bundle = bVar.a();
                }
                Bundle bundle2 = bundle;
                if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a2.getAction())) {
                    String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    androidx.core.app.a.a(componentActivity, stringArrayExtra, i2);
                } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a2.getAction())) {
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                    try {
                        androidx.core.app.a.a(componentActivity, intentSenderRequest.a(), i2, intentSenderRequest.b(), intentSenderRequest.c(), intentSenderRequest.d(), 0, bundle2);
                    } catch (IntentSender.SendIntentException e2) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                AnonymousClass2.this.a(i2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", e2));
                            }
                        });
                    }
                } else {
                    androidx.core.app.a.a(componentActivity, a2, i2, bundle2);
                }
            }
        };
        if (getLifecycle() != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getLifecycle().a(new k() {
                    public void a(n nVar, Lifecycle.Event event) {
                        if (event == Lifecycle.Event.ON_STOP) {
                            Window window = ComponentActivity.this.getWindow();
                            View peekDecorView = window != null ? window.peekDecorView() : null;
                            if (peekDecorView != null) {
                                peekDecorView.cancelPendingInputEvents();
                            }
                        }
                    }
                });
            }
            getLifecycle().a(new k() {
                public void a(n nVar, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.b();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().b();
                        }
                    }
                }
            });
            getLifecycle().a(new k() {
                public void a(n nVar, Lifecycle.Event event) {
                    ComponentActivity.this.ensureViewModelStore();
                    ComponentActivity.this.getLifecycle().b(this);
                }
            });
            if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
                getLifecycle().a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public ComponentActivity(int i2) {
        this();
        this.mContentLayoutId = i2;
    }

    private void initViewTreeOwners() {
        ae.a(getWindow().getDecorView(), this);
        af.a(getWindow().getDecorView(), this);
        androidx.savedstate.d.a(getWindow().getDecorView(), this);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public final void addOnContextAvailableListener(a.b bVar) {
        this.mContextAwareHelper.a(bVar);
    }

    /* access modifiers changed from: package-private */
    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            a aVar = (a) getLastNonConfigurationInstance();
            if (aVar != null) {
                this.mViewModelStore = aVar.f437b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ac();
            }
        }
    }

    public final androidx.activity.result.c getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public ab.b getDefaultViewModelProviderFactory() {
        if (getApplication() != null) {
            if (this.mDefaultFactory == null) {
                this.mDefaultFactory = new y(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        a aVar = (a) getLastNonConfigurationInstance();
        if (aVar != null) {
            return aVar.f436a;
        }
        return null;
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a();
    }

    public ac getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!this.mActivityResultRegistry.a(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.a(bundle);
        this.mContextAwareHelper.a((Context) this);
        super.onCreate(bundle);
        this.mActivityResultRegistry.b(bundle);
        w.a((Activity) this);
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (!this.mActivityResultRegistry.a(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        a aVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ac acVar = this.mViewModelStore;
        if (acVar == null && (aVar = (a) getLastNonConfigurationInstance()) != null) {
            acVar = aVar.f437b;
        }
        if (acVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f436a = onRetainCustomNonConfigurationInstance;
        aVar2.f437b = acVar;
        return aVar2;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof o) {
            ((o) lifecycle).b(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
        this.mActivityResultRegistry.a(bundle);
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.a();
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(b.a<I, O> aVar, androidx.activity.result.a<O> aVar2) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, aVar2);
    }

    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(b.a<I, O> aVar, androidx.activity.result.c cVar, androidx.activity.result.a<O> aVar2) {
        return cVar.a("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), (n) this, aVar, aVar2);
    }

    public final void removeOnContextAvailableListener(a.b bVar) {
        this.mContextAwareHelper.b(bVar);
    }

    public void reportFullyDrawn() {
        try {
            if (ai.a.a()) {
                ai.a.a("reportFullyDrawn() for " + getComponentName());
            }
            if (Build.VERSION.SDK_INT > 19 || (Build.VERSION.SDK_INT == 19 && androidx.core.content.b.b((Context) this, "android.permission.UPDATE_DEVICE_STATS") == 0)) {
                super.reportFullyDrawn();
            }
        } finally {
            ai.a.b();
        }
    }

    public void setContentView(int i2) {
        initViewTreeOwners();
        super.setContentView(i2);
    }

    public void setContentView(View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }
}
