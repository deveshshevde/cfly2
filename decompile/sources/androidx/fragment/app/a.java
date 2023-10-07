package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

final class a extends s implements FragmentManager.a, FragmentManager.e {

    /* renamed from: a  reason: collision with root package name */
    final FragmentManager f3316a;

    /* renamed from: b  reason: collision with root package name */
    boolean f3317b;

    /* renamed from: c  reason: collision with root package name */
    int f3318c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    a(FragmentManager fragmentManager) {
        super(fragmentManager.E(), fragmentManager.m() != null ? fragmentManager.m().g().getClassLoader() : null);
        this.f3318c = -1;
        this.f3316a = fragmentManager;
    }

    private static boolean b(s.a aVar) {
        Fragment fragment = aVar.f3445b;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    public int a() {
        return this.f3318c;
    }

    /* access modifiers changed from: package-private */
    public int a(boolean z2) {
        if (!this.f3317b) {
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new z("FragmentManager"));
                a("  ", printWriter);
                printWriter.close();
            }
            this.f3317b = true;
            this.f3318c = this.f3433j ? this.f3316a.k() : -1;
            this.f3316a.a((FragmentManager.e) this, z2);
            return this.f3318c;
        }
        throw new IllegalStateException("commit already called");
    }

    /* access modifiers changed from: package-private */
    public Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.f3427d.size()) {
            s.a aVar = (s.a) this.f3427d.get(i2);
            int i3 = aVar.f3444a;
            if (i3 != 1) {
                if (i3 == 2) {
                    Fragment fragment3 = aVar.f3445b;
                    int i4 = fragment3.mContainerId;
                    boolean z2 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList2.get(size);
                        if (fragment4.mContainerId == i4) {
                            if (fragment4 == fragment3) {
                                z2 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f3427d.add(i2, new s.a(9, fragment4));
                                    i2++;
                                    fragment2 = null;
                                }
                                s.a aVar2 = new s.a(3, fragment4);
                                aVar2.f3446c = aVar.f3446c;
                                aVar2.f3448e = aVar.f3448e;
                                aVar2.f3447d = aVar.f3447d;
                                aVar2.f3449f = aVar.f3449f;
                                this.f3427d.add(i2, aVar2);
                                arrayList2.remove(fragment4);
                                i2++;
                            }
                        }
                    }
                    if (z2) {
                        this.f3427d.remove(i2);
                        i2--;
                    } else {
                        aVar.f3444a = 1;
                        arrayList2.add(fragment3);
                    }
                } else if (i3 == 3 || i3 == 6) {
                    arrayList2.remove(aVar.f3445b);
                    if (aVar.f3445b == fragment2) {
                        this.f3427d.add(i2, new s.a(9, aVar.f3445b));
                        i2++;
                        fragment2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.f3427d.add(i2, new s.a(9, fragment2));
                        i2++;
                        fragment2 = aVar.f3445b;
                    }
                }
                i2++;
            }
            arrayList2.add(aVar.f3445b);
            i2++;
        }
        return fragment2;
    }

    public s a(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f3316a) {
            return super.a(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public s a(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f3316a) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f3316a);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            return super.a(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.f3433j) {
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f3427d.size();
            for (int i3 = 0; i3 < size; i3++) {
                s.a aVar = (s.a) this.f3427d.get(i3);
                if (aVar.f3445b != null) {
                    aVar.f3445b.mBackStackNesting += i2;
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f3445b + " to " + aVar.f3445b.mBackStackNesting);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Fragment fragment, String str, int i3) {
        super.a(i2, fragment, str, i3);
        fragment.mFragmentManager = this.f3316a;
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment.c cVar) {
        for (int i2 = 0; i2 < this.f3427d.size(); i2++) {
            s.a aVar = (s.a) this.f3427d.get(i2);
            if (b(aVar)) {
                aVar.f3445b.setOnStartEnterTransitionListener(cVar);
            }
        }
    }

    public void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z2) {
        String str2;
        if (z2) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3435l);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3318c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3317b);
            if (this.f3432i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3432i));
            }
            if (!(this.f3428e == 0 && this.f3429f == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3428e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3429f));
            }
            if (!(this.f3430g == 0 && this.f3431h == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3430g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3431h));
            }
            if (!(this.f3436m == 0 && this.f3437n == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3436m));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3437n);
            }
            if (!(this.f3438o == 0 && this.f3439p == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3438o));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3439p);
            }
        }
        if (!this.f3427d.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f3427d.size();
            for (int i2 = 0; i2 < size; i2++) {
                s.a aVar = (s.a) this.f3427d.get(i2);
                switch (aVar.f3444a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f3444a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f3445b);
                if (z2) {
                    if (!(aVar.f3446c == 0 && aVar.f3447d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f3446c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f3447d));
                    }
                    if (aVar.f3448e != 0 || aVar.f3449f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f3448e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f3449f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f3427d.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            s.a aVar = (s.a) this.f3427d.get(i5);
            int i6 = aVar.f3445b != null ? aVar.f3445b.mContainerId : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar2 = arrayList.get(i7);
                    int size2 = aVar2.f3427d.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        s.a aVar3 = (s.a) aVar2.f3427d.get(i8);
                        if ((aVar3.f3445b != null ? aVar3.f3445b.mContainerId : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.f3433j) {
            return true;
        }
        this.f3316a.a(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f3427d.size() - 1; size >= 0; size--) {
            s.a aVar = (s.a) this.f3427d.get(size);
            int i2 = aVar.f3444a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f3445b;
                            break;
                        case 10:
                            aVar.f3451h = aVar.f3450g;
                            break;
                    }
                }
                arrayList.add(aVar.f3445b);
            }
            arrayList.remove(aVar.f3445b);
        }
        return fragment;
    }

    public s b(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f3316a) {
            return super.b(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void b() {
        if (this.f3443t != null) {
            for (int i2 = 0; i2 < this.f3443t.size(); i2++) {
                ((Runnable) this.f3443t.get(i2)).run();
            }
            this.f3443t = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        for (int size = this.f3427d.size() - 1; size >= 0; size--) {
            s.a aVar = (s.a) this.f3427d.get(size);
            Fragment fragment = aVar.f3445b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.e(this.f3432i));
                fragment.setSharedElementNames(this.f3441r, this.f3440q);
            }
            switch (aVar.f3444a) {
                case 1:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.a(fragment, true);
                    this.f3316a.k(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.j(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.m(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.a(fragment, true);
                    this.f3316a.l(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.o(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.a(fragment, true);
                    this.f3316a.n(fragment);
                    break;
                case 8:
                    this.f3316a.p((Fragment) null);
                    break;
                case 9:
                    this.f3316a.p(fragment);
                    break;
                case 10:
                    this.f3316a.a(fragment, aVar.f3450g);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3444a);
            }
            if (!this.f3442s && aVar.f3444a != 3 && fragment != null && !FragmentManager.f3199a) {
                this.f3316a.h(fragment);
            }
        }
        if (!this.f3442s && z2 && !FragmentManager.f3199a) {
            FragmentManager fragmentManager = this.f3316a;
            fragmentManager.a(fragmentManager.f3202c, true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2) {
        int size = this.f3427d.size();
        for (int i3 = 0; i3 < size; i3++) {
            s.a aVar = (s.a) this.f3427d.get(i3);
            int i4 = aVar.f3445b != null ? aVar.f3445b.mContainerId : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    public int c() {
        return a(false);
    }

    public s c(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f3316a) {
            return super.c(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public int d() {
        return a(true);
    }

    public s d(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f3316a) {
            return super.d(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void e() {
        k();
        this.f3316a.b((FragmentManager.e) this, false);
    }

    public void f() {
        k();
        this.f3316a.b((FragmentManager.e) this, true);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        int size = this.f3427d.size();
        for (int i2 = 0; i2 < size; i2++) {
            s.a aVar = (s.a) this.f3427d.get(i2);
            Fragment fragment = aVar.f3445b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f3432i);
                fragment.setSharedElementNames(this.f3440q, this.f3441r);
            }
            switch (aVar.f3444a) {
                case 1:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.a(fragment, false);
                    this.f3316a.j(fragment);
                    break;
                case 3:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.k(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.l(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.a(fragment, false);
                    this.f3316a.m(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.n(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f3446c, aVar.f3447d, aVar.f3448e, aVar.f3449f);
                    this.f3316a.a(fragment, false);
                    this.f3316a.o(fragment);
                    break;
                case 8:
                    this.f3316a.p(fragment);
                    break;
                case 9:
                    this.f3316a.p((Fragment) null);
                    break;
                case 10:
                    this.f3316a.a(fragment, aVar.f3451h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3444a);
            }
            if (!this.f3442s && aVar.f3444a != 1 && fragment != null && !FragmentManager.f3199a) {
                this.f3316a.h(fragment);
            }
        }
        if (!this.f3442s && !FragmentManager.f3199a) {
            FragmentManager fragmentManager = this.f3316a;
            fragmentManager.a(fragmentManager.f3202c, true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        for (int i2 = 0; i2 < this.f3427d.size(); i2++) {
            if (b((s.a) this.f3427d.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public String i() {
        return this.f3435l;
    }

    public boolean j() {
        return this.f3427d.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3318c >= 0) {
            sb.append(" #");
            sb.append(this.f3318c);
        }
        if (this.f3435l != null) {
            sb.append(" ");
            sb.append(this.f3435l);
        }
        sb.append("}");
        return sb.toString();
    }
}
