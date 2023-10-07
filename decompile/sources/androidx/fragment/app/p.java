package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ad;
import t.ac;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

class p {

    /* renamed from: a  reason: collision with root package name */
    private final j f3407a;

    /* renamed from: b  reason: collision with root package name */
    private final r f3408b;

    /* renamed from: c  reason: collision with root package name */
    private final Fragment f3409c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3410d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f3411e = -1;

    /* renamed from: androidx.fragment.app.p$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3414a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3414a = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3414a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3414a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3414a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.p.AnonymousClass2.<clinit>():void");
        }
    }

    p(j jVar, r rVar, Fragment fragment) {
        this.f3407a = jVar;
        this.f3408b = rVar;
        this.f3409c = fragment;
    }

    p(j jVar, r rVar, Fragment fragment, FragmentState fragmentState) {
        this.f3407a = jVar;
        this.f3408b = rVar;
        this.f3409c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        fragment.mTargetWho = fragment.mTarget != null ? fragment.mTarget.mWho : null;
        fragment.mTarget = null;
        fragment.mSavedFragmentState = fragmentState.f3272m != null ? fragmentState.f3272m : new Bundle();
    }

    p(j jVar, r rVar, ClassLoader classLoader, g gVar, FragmentState fragmentState) {
        this.f3407a = jVar;
        this.f3408b = rVar;
        Fragment c2 = gVar.c(classLoader, fragmentState.f3260a);
        this.f3409c = c2;
        if (fragmentState.f3269j != null) {
            fragmentState.f3269j.setClassLoader(classLoader);
        }
        c2.setArguments(fragmentState.f3269j);
        c2.mWho = fragmentState.f3261b;
        c2.mFromLayout = fragmentState.f3262c;
        c2.mRestored = true;
        c2.mFragmentId = fragmentState.f3263d;
        c2.mContainerId = fragmentState.f3264e;
        c2.mTag = fragmentState.f3265f;
        c2.mRetainInstance = fragmentState.f3266g;
        c2.mRemoving = fragmentState.f3267h;
        c2.mDetached = fragmentState.f3268i;
        c2.mHidden = fragmentState.f3270k;
        c2.mMaxState = Lifecycle.State.values()[fragmentState.f3271l];
        c2.mSavedFragmentState = fragmentState.f3272m != null ? fragmentState.f3272m : new Bundle();
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + c2);
        }
    }

    private boolean a(View view) {
        if (view == this.f3409c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f3409c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle t() {
        Bundle bundle = new Bundle();
        this.f3409c.performSaveInstanceState(bundle);
        this.f3407a.d(this.f3409c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f3409c.mView != null) {
            o();
        }
        if (this.f3409c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f3409c.mSavedViewState);
        }
        if (this.f3409c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f3409c.mSavedViewRegistryState);
        }
        if (!this.f3409c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f3409c.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public Fragment a() {
        return this.f3409c;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.f3411e = i2;
    }

    /* access modifiers changed from: package-private */
    public void a(ClassLoader classLoader) {
        if (this.f3409c.mSavedFragmentState != null) {
            this.f3409c.mSavedFragmentState.setClassLoader(classLoader);
            Fragment fragment = this.f3409c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f3409c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
            Fragment fragment3 = this.f3409c;
            fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
            if (this.f3409c.mTargetWho != null) {
                Fragment fragment4 = this.f3409c;
                fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            if (this.f3409c.mSavedUserVisibleHint != null) {
                Fragment fragment5 = this.f3409c;
                fragment5.mUserVisibleHint = fragment5.mSavedUserVisibleHint.booleanValue();
                this.f3409c.mSavedUserVisibleHint = null;
            } else {
                Fragment fragment6 = this.f3409c;
                fragment6.mUserVisibleHint = fragment6.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            if (!this.f3409c.mUserVisibleHint) {
                this.f3409c.mDeferStart = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        if (this.f3409c.mFragmentManager == null) {
            return this.f3409c.mState;
        }
        int i2 = this.f3411e;
        int i3 = AnonymousClass2.f3414a[this.f3409c.mMaxState.ordinal()];
        if (i3 != 1) {
            i2 = i3 != 2 ? i3 != 3 ? i3 != 4 ? Math.min(i2, -1) : Math.min(i2, 0) : Math.min(i2, 1) : Math.min(i2, 5);
        }
        if (this.f3409c.mFromLayout) {
            if (this.f3409c.mInLayout) {
                i2 = Math.max(this.f3411e, 2);
                if (this.f3409c.mView != null && this.f3409c.mView.getParent() == null) {
                    i2 = Math.min(i2, 2);
                }
            } else {
                i2 = this.f3411e < 4 ? Math.min(i2, this.f3409c.mState) : Math.min(i2, 1);
            }
        }
        if (!this.f3409c.mAdded) {
            i2 = Math.min(i2, 1);
        }
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = null;
        if (FragmentManager.f3199a && this.f3409c.mContainer != null) {
            lifecycleImpact = SpecialEffectsController.a(this.f3409c.mContainer, this.f3409c.getParentFragmentManager()).a(this);
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i2 = Math.min(i2, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i2 = Math.max(i2, 3);
        } else if (this.f3409c.mRemoving) {
            i2 = this.f3409c.isInBackStack() ? Math.min(i2, 1) : Math.min(i2, -1);
        }
        if (this.f3409c.mDeferStart && this.f3409c.mState < 5) {
            i2 = Math.min(i2, 4);
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i2 + " for " + this.f3409c);
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (!this.f3410d) {
            boolean z2 = false;
            z2 = true;
            try {
                while (true) {
                    int b2 = b();
                    if (b2 != this.f3409c.mState) {
                        if (b2 <= this.f3409c.mState) {
                            switch (this.f3409c.mState - (z2 ? 1 : 0)) {
                                case -1:
                                    r();
                                    break;
                                case 0:
                                    q();
                                    break;
                                case 1:
                                    p();
                                    this.f3409c.mState = z2;
                                    break;
                                case 2:
                                    this.f3409c.mInLayout = z2;
                                    this.f3409c.mState = 2;
                                    break;
                                case 3:
                                    if (FragmentManager.a(3)) {
                                        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f3409c);
                                    }
                                    if (this.f3409c.mView != null && this.f3409c.mSavedViewState == null) {
                                        o();
                                    }
                                    if (!(this.f3409c.mView == null || this.f3409c.mContainer == null)) {
                                        SpecialEffectsController.a(this.f3409c.mContainer, this.f3409c.getParentFragmentManager()).d(this);
                                    }
                                    this.f3409c.mState = 3;
                                    break;
                                case 4:
                                    l();
                                    break;
                                case 5:
                                    this.f3409c.mState = 5;
                                    break;
                                case 6:
                                    k();
                                    break;
                            }
                        } else {
                            switch (this.f3409c.mState + z2) {
                                case 0:
                                    e();
                                    break;
                                case 1:
                                    f();
                                    break;
                                case 2:
                                    d();
                                    g();
                                    break;
                                case 3:
                                    h();
                                    break;
                                case 4:
                                    if (!(this.f3409c.mView == null || this.f3409c.mContainer == null)) {
                                        SpecialEffectsController.a(this.f3409c.mContainer, this.f3409c.getParentFragmentManager()).a(SpecialEffectsController.Operation.State.a(this.f3409c.mView.getVisibility()), this);
                                    }
                                    this.f3409c.mState = 4;
                                    break;
                                case 5:
                                    i();
                                    break;
                                case 6:
                                    this.f3409c.mState = 6;
                                    break;
                                case 7:
                                    j();
                                    break;
                            }
                        }
                    } else {
                        if (FragmentManager.f3199a && this.f3409c.mHiddenChanged) {
                            if (!(this.f3409c.mView == null || this.f3409c.mContainer == null)) {
                                SpecialEffectsController a2 = SpecialEffectsController.a(this.f3409c.mContainer, this.f3409c.getParentFragmentManager());
                                if (this.f3409c.mHidden) {
                                    a2.c(this);
                                } else {
                                    a2.b(this);
                                }
                            }
                            if (this.f3409c.mFragmentManager != null) {
                                this.f3409c.mFragmentManager.r(this.f3409c);
                            }
                            this.f3409c.mHiddenChanged = z2;
                            Fragment fragment = this.f3409c;
                            fragment.onHiddenChanged(fragment.mHidden);
                        }
                        this.f3410d = z2;
                        return;
                    }
                }
            } finally {
                this.f3410d = z2;
            }
        } else if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + a());
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.f3409c.mFromLayout && this.f3409c.mInLayout && !this.f3409c.mPerformedCreateView) {
            if (FragmentManager.a(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3409c);
            }
            Fragment fragment = this.f3409c;
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), (ViewGroup) null, this.f3409c.mSavedFragmentState);
            if (this.f3409c.mView != null) {
                this.f3409c.mView.setSaveFromParentEnabled(false);
                this.f3409c.mView.setTag(R.id.fragment_container_view_tag, this.f3409c);
                if (this.f3409c.mHidden) {
                    this.f3409c.mView.setVisibility(8);
                }
                this.f3409c.performViewCreated();
                j jVar = this.f3407a;
                Fragment fragment2 = this.f3409c;
                jVar.a(fragment2, fragment2.mView, this.f3409c.mSavedFragmentState, false);
                this.f3409c.mState = 2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f3409c);
        }
        p pVar = null;
        if (this.f3409c.mTarget != null) {
            p c2 = this.f3408b.c(this.f3409c.mTarget.mWho);
            if (c2 != null) {
                Fragment fragment = this.f3409c;
                fragment.mTargetWho = fragment.mTarget.mWho;
                this.f3409c.mTarget = null;
                pVar = c2;
            } else {
                throw new IllegalStateException("Fragment " + this.f3409c + " declared target fragment " + this.f3409c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else if (this.f3409c.mTargetWho != null && (pVar = this.f3408b.c(this.f3409c.mTargetWho)) == null) {
            throw new IllegalStateException("Fragment " + this.f3409c + " declared target fragment " + this.f3409c.mTargetWho + " that does not belong to this FragmentManager!");
        }
        if (pVar != null && (FragmentManager.f3199a || pVar.a().mState < 1)) {
            pVar.c();
        }
        Fragment fragment2 = this.f3409c;
        fragment2.mHost = fragment2.mFragmentManager.m();
        Fragment fragment3 = this.f3409c;
        fragment3.mParentFragment = fragment3.mFragmentManager.n();
        this.f3407a.a(this.f3409c, false);
        this.f3409c.performAttach();
        this.f3407a.b(this.f3409c, false);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f3409c);
        }
        if (!this.f3409c.mIsCreated) {
            j jVar = this.f3407a;
            Fragment fragment = this.f3409c;
            jVar.a(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f3409c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            j jVar2 = this.f3407a;
            Fragment fragment3 = this.f3409c;
            jVar2.b(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        Fragment fragment4 = this.f3409c;
        fragment4.restoreChildFragmentState(fragment4.mSavedFragmentState);
        this.f3409c.mState = 1;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        String str;
        if (!this.f3409c.mFromLayout) {
            if (FragmentManager.a(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3409c);
            }
            Fragment fragment = this.f3409c;
            LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
            ViewGroup viewGroup = null;
            if (this.f3409c.mContainer != null) {
                viewGroup = this.f3409c.mContainer;
            } else if (this.f3409c.mContainerId != 0) {
                if (this.f3409c.mContainerId != -1) {
                    viewGroup = (ViewGroup) this.f3409c.mFragmentManager.o().a(this.f3409c.mContainerId);
                    if (viewGroup == null && !this.f3409c.mRestored) {
                        try {
                            str = this.f3409c.getResources().getResourceName(this.f3409c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f3409c.mContainerId) + " (" + str + ") for fragment " + this.f3409c);
                    }
                } else {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f3409c + " for a container view with no id");
                }
            }
            this.f3409c.mContainer = viewGroup;
            Fragment fragment2 = this.f3409c;
            fragment2.performCreateView(performGetLayoutInflater, viewGroup, fragment2.mSavedFragmentState);
            if (this.f3409c.mView != null) {
                boolean z2 = false;
                this.f3409c.mView.setSaveFromParentEnabled(false);
                this.f3409c.mView.setTag(R.id.fragment_container_view_tag, this.f3409c);
                if (viewGroup != null) {
                    s();
                }
                if (this.f3409c.mHidden) {
                    this.f3409c.mView.setVisibility(8);
                }
                if (ac.J(this.f3409c.mView)) {
                    ac.w(this.f3409c.mView);
                } else {
                    final View view = this.f3409c.mView;
                    view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                        public void onViewAttachedToWindow(View view) {
                            view.removeOnAttachStateChangeListener(this);
                            ac.w(view);
                        }

                        public void onViewDetachedFromWindow(View view) {
                        }
                    });
                }
                this.f3409c.performViewCreated();
                j jVar = this.f3407a;
                Fragment fragment3 = this.f3409c;
                jVar.a(fragment3, fragment3.mView, this.f3409c.mSavedFragmentState, false);
                int visibility = this.f3409c.mView.getVisibility();
                float alpha = this.f3409c.mView.getAlpha();
                if (FragmentManager.f3199a) {
                    this.f3409c.setPostOnViewCreatedAlpha(alpha);
                    if (this.f3409c.mContainer != null && visibility == 0) {
                        View findFocus = this.f3409c.mView.findFocus();
                        if (findFocus != null) {
                            this.f3409c.setFocusedView(findFocus);
                            if (FragmentManager.a(2)) {
                                Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f3409c);
                            }
                        }
                        this.f3409c.mView.setAlpha(0.0f);
                    }
                } else {
                    Fragment fragment4 = this.f3409c;
                    if (visibility == 0 && fragment4.mContainer != null) {
                        z2 = true;
                    }
                    fragment4.mIsNewlyAdded = z2;
                }
            }
            this.f3409c.mState = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f3409c);
        }
        Fragment fragment = this.f3409c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        j jVar = this.f3407a;
        Fragment fragment2 = this.f3409c;
        jVar.c(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f3409c);
        }
        this.f3409c.performStart();
        this.f3407a.c(this.f3409c, false);
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f3409c);
        }
        View focusedView = this.f3409c.getFocusedView();
        if (focusedView != null && a(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.a(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f3409c);
                sb.append(" resulting in focused view ");
                sb.append(this.f3409c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f3409c.setFocusedView((View) null);
        this.f3409c.performResume();
        this.f3407a.d(this.f3409c, false);
        this.f3409c.mSavedFragmentState = null;
        this.f3409c.mSavedViewState = null;
        this.f3409c.mSavedViewRegistryState = null;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f3409c);
        }
        this.f3409c.performPause();
        this.f3407a.e(this.f3409c, false);
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f3409c);
        }
        this.f3409c.performStop();
        this.f3407a.f(this.f3409c, false);
    }

    /* access modifiers changed from: package-private */
    public FragmentState m() {
        FragmentState fragmentState = new FragmentState(this.f3409c);
        if (this.f3409c.mState <= -1 || fragmentState.f3272m != null) {
            fragmentState.f3272m = this.f3409c.mSavedFragmentState;
        } else {
            fragmentState.f3272m = t();
            if (this.f3409c.mTargetWho != null) {
                if (fragmentState.f3272m == null) {
                    fragmentState.f3272m = new Bundle();
                }
                fragmentState.f3272m.putString("android:target_state", this.f3409c.mTargetWho);
                if (this.f3409c.mTargetRequestCode != 0) {
                    fragmentState.f3272m.putInt("android:target_req_state", this.f3409c.mTargetRequestCode);
                }
            }
        }
        return fragmentState;
    }

    /* access modifiers changed from: package-private */
    public Fragment.SavedState n() {
        Bundle t2;
        if (this.f3409c.mState <= -1 || (t2 = t()) == null) {
            return null;
        }
        return new Fragment.SavedState(t2);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        if (this.f3409c.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f3409c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f3409c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f3409c.mViewLifecycleOwner.b(bundle);
            if (!bundle.isEmpty()) {
                this.f3409c.mSavedViewRegistryState = bundle;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f3409c);
        }
        if (!(this.f3409c.mContainer == null || this.f3409c.mView == null)) {
            this.f3409c.mContainer.removeView(this.f3409c.mView);
        }
        this.f3409c.performDestroyView();
        this.f3407a.g(this.f3409c, false);
        this.f3409c.mContainer = null;
        this.f3409c.mView = null;
        this.f3409c.mViewLifecycleOwner = null;
        this.f3409c.mViewLifecycleOwnerLiveData.b(null);
        this.f3409c.mInLayout = false;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        Fragment e2;
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f3409c);
        }
        boolean z2 = true;
        boolean z3 = this.f3409c.mRemoving && !this.f3409c.isInBackStack();
        if (z3 || this.f3408b.a().b(this.f3409c)) {
            h<?> hVar = this.f3409c.mHost;
            if (hVar instanceof ad) {
                z2 = this.f3408b.a().b();
            } else if (hVar.g() instanceof Activity) {
                z2 = true ^ ((Activity) hVar.g()).isChangingConfigurations();
            }
            if (z3 || z2) {
                this.f3408b.a().f(this.f3409c);
            }
            this.f3409c.performDestroy();
            this.f3407a.h(this.f3409c, false);
            for (p next : this.f3408b.g()) {
                if (next != null) {
                    Fragment a2 = next.a();
                    if (this.f3409c.mWho.equals(a2.mTargetWho)) {
                        a2.mTarget = this.f3409c;
                        a2.mTargetWho = null;
                    }
                }
            }
            if (this.f3409c.mTargetWho != null) {
                Fragment fragment = this.f3409c;
                fragment.mTarget = this.f3408b.e(fragment.mTargetWho);
            }
            this.f3408b.b(this);
            return;
        }
        if (!(this.f3409c.mTargetWho == null || (e2 = this.f3408b.e(this.f3409c.mTargetWho)) == null || !e2.mRetainInstance)) {
            this.f3409c.mTarget = e2;
        }
        this.f3409c.mState = 0;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f3409c);
        }
        this.f3409c.performDetach();
        boolean z2 = false;
        this.f3407a.i(this.f3409c, false);
        this.f3409c.mState = -1;
        this.f3409c.mHost = null;
        this.f3409c.mParentFragment = null;
        this.f3409c.mFragmentManager = null;
        if (this.f3409c.mRemoving && !this.f3409c.isInBackStack()) {
            z2 = true;
        }
        if (z2 || this.f3408b.a().b(this.f3409c)) {
            if (FragmentManager.a(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f3409c);
            }
            this.f3409c.initState();
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.f3409c.mContainer.addView(this.f3409c.mView, this.f3408b.c(this.f3409c));
    }
}
