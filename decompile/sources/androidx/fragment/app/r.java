package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class r {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Fragment> f3422a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, p> f3423b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private l f3424c;

    r() {
    }

    /* access modifiers changed from: package-private */
    public Fragment a(String str) {
        if (str != null) {
            for (int size = this.f3422a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f3422a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (p next : this.f3423b.values()) {
            if (next != null) {
                Fragment a2 = next.a();
                if (str.equals(a2.mTag)) {
                    return a2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public l a() {
        return this.f3424c;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        for (p next : this.f3423b.values()) {
            if (next != null) {
                next.a(i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (!this.f3422a.contains(fragment)) {
            synchronized (this.f3422a) {
                this.f3422a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* access modifiers changed from: package-private */
    public void a(l lVar) {
        this.f3424c = lVar;
    }

    /* access modifiers changed from: package-private */
    public void a(p pVar) {
        Fragment a2 = pVar.a();
        if (!b(a2.mWho)) {
            this.f3423b.put(a2.mWho, pVar);
            if (a2.mRetainInstanceChangedWhileDetached) {
                if (a2.mRetainInstance) {
                    this.f3424c.a(a2);
                } else {
                    this.f3424c.c(a2);
                }
                a2.mRetainInstanceChangedWhileDetached = false;
            }
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Added fragment to active set " + a2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f3423b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (p next : this.f3423b.values()) {
                printWriter.print(str);
                if (next != null) {
                    Fragment a2 = next.a();
                    printWriter.println(a2);
                    a2.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f3422a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f3422a.get(i2).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<String> list) {
        this.f3422a.clear();
        if (list != null) {
            for (String next : list) {
                Fragment e2 = e(next);
                if (e2 != null) {
                    if (FragmentManager.a(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + next + "): " + e2);
                    }
                    a(e2);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + next + ")");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment b(int i2) {
        for (int size = this.f3422a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f3422a.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (p next : this.f3423b.values()) {
            if (next != null) {
                Fragment a2 = next.a();
                if (a2.mFragmentId == i2) {
                    return a2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f3423b.clear();
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment) {
        synchronized (this.f3422a) {
            this.f3422a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* access modifiers changed from: package-private */
    public void b(p pVar) {
        Fragment a2 = pVar.a();
        if (a2.mRetainInstance) {
            this.f3424c.c(a2);
        }
        if (this.f3423b.put(a2.mWho, (Object) null) != null && FragmentManager.a(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + a2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(String str) {
        return this.f3423b.get(str) != null;
    }

    /* access modifiers changed from: package-private */
    public int c(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f3422a.indexOf(fragment);
        for (int i2 = indexOf - 1; i2 >= 0; i2--) {
            Fragment fragment2 = this.f3422a.get(i2);
            if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                return viewGroup.indexOfChild(fragment2.mView) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f3422a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f3422a.get(indexOf);
            if (fragment3.mContainer == viewGroup && fragment3.mView != null) {
                return viewGroup.indexOfChild(fragment3.mView);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public p c(String str) {
        return this.f3423b.get(str);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Iterator<Fragment> it2 = this.f3422a.iterator();
        while (it2.hasNext()) {
            p pVar = this.f3423b.get(it2.next().mWho);
            if (pVar != null) {
                pVar.c();
            }
        }
        for (p next : this.f3423b.values()) {
            if (next != null) {
                next.c();
                Fragment a2 = next.a();
                if (a2.mRemoving && !a2.isInBackStack()) {
                    b(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment d(String str) {
        Fragment findFragmentByWho;
        for (p next : this.f3423b.values()) {
            if (next != null && (findFragmentByWho = next.a().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f3423b.values().removeAll(Collections.singleton((Object) null));
    }

    /* access modifiers changed from: package-private */
    public Fragment e(String str) {
        p pVar = this.f3423b.get(str);
        if (pVar != null) {
            return pVar.a();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<FragmentState> e() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.f3423b.size());
        for (p next : this.f3423b.values()) {
            if (next != null) {
                Fragment a2 = next.a();
                FragmentState m2 = next.m();
                arrayList.add(m2);
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "Saved state of " + a2 + ": " + m2.f3272m);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> f() {
        synchronized (this.f3422a) {
            if (this.f3422a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f3422a.size());
            Iterator<Fragment> it2 = this.f3422a.iterator();
            while (it2.hasNext()) {
                Fragment next = it2.next();
                arrayList.add(next.mWho);
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: package-private */
    public List<p> g() {
        ArrayList arrayList = new ArrayList();
        for (p next : this.f3423b.values()) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> h() {
        ArrayList arrayList;
        if (this.f3422a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3422a) {
            arrayList = new ArrayList(this.f3422a);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> i() {
        ArrayList arrayList = new ArrayList();
        Iterator<p> it2 = this.f3423b.values().iterator();
        while (it2.hasNext()) {
            p next = it2.next();
            arrayList.add(next != null ? next.a() : null);
        }
        return arrayList;
    }
}
