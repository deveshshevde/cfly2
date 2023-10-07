package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import t.ad;

public class g implements n.a {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f863d = {1, 4, 5, 3, 2, 0};
    private boolean A;

    /* renamed from: a  reason: collision with root package name */
    CharSequence f864a;

    /* renamed from: b  reason: collision with root package name */
    Drawable f865b;

    /* renamed from: c  reason: collision with root package name */
    View f866c;

    /* renamed from: e  reason: collision with root package name */
    private final Context f867e;

    /* renamed from: f  reason: collision with root package name */
    private final Resources f868f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f869g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f870h;

    /* renamed from: i  reason: collision with root package name */
    private a f871i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<i> f872j;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<i> f873k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f874l;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<i> f875m;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<i> f876n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f877o;

    /* renamed from: p  reason: collision with root package name */
    private int f878p = 0;

    /* renamed from: q  reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f879q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f880r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f881s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f882t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f883u = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f884v = false;

    /* renamed from: w  reason: collision with root package name */
    private ArrayList<i> f885w = new ArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<m>> f886x = new CopyOnWriteArrayList<>();

    /* renamed from: y  reason: collision with root package name */
    private i f887y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f888z = false;

    public interface a {
        void a(g gVar);

        boolean a(g gVar, MenuItem menuItem);
    }

    public interface b {
        boolean a(i iVar);
    }

    public g(Context context) {
        this.f867e = context;
        this.f868f = context.getResources();
        this.f872j = new ArrayList<>();
        this.f873k = new ArrayList<>();
        this.f874l = true;
        this.f875m = new ArrayList<>();
        this.f876n = new ArrayList<>();
        this.f877o = true;
        e(true);
    }

    private static int a(ArrayList<i> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    private i a(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new i(this, i2, i3, i4, i5, charSequence, i6);
    }

    private void a(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources e2 = e();
        if (view != null) {
            this.f866c = view;
            this.f864a = null;
            this.f865b = null;
        } else {
            if (i2 > 0) {
                this.f864a = e2.getText(i2);
            } else if (charSequence != null) {
                this.f864a = charSequence;
            }
            if (i3 > 0) {
                this.f865b = androidx.core.content.b.a(f(), i3);
            } else if (drawable != null) {
                this.f865b = drawable;
            }
            this.f866c = null;
        }
        b(false);
    }

    private void a(int i2, boolean z2) {
        if (i2 >= 0 && i2 < this.f872j.size()) {
            this.f872j.remove(i2);
            if (z2) {
                b(true);
            }
        }
    }

    private boolean a(r rVar, m mVar) {
        boolean z2 = false;
        if (this.f886x.isEmpty()) {
            return false;
        }
        if (mVar != null) {
            z2 = mVar.a(rVar);
        }
        Iterator<WeakReference<m>> it2 = this.f886x.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            m mVar2 = (m) next.get();
            if (mVar2 == null) {
                this.f886x.remove(next);
            } else if (!z2) {
                z2 = mVar2.a(rVar);
            }
        }
        return z2;
    }

    private void d(boolean z2) {
        if (!this.f886x.isEmpty()) {
            h();
            Iterator<WeakReference<m>> it2 = this.f886x.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.f886x.remove(next);
                } else {
                    mVar.a(z2);
                }
            }
            i();
        }
    }

    private void e(Bundle bundle) {
        Parcelable f2;
        if (!this.f886x.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<m>> it2 = this.f886x.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.f886x.remove(next);
                } else {
                    int c2 = mVar.c();
                    if (c2 > 0 && (f2 = mVar.f()) != null) {
                        sparseArray.put(c2, f2);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private void e(boolean z2) {
        boolean z3 = true;
        if (!z2 || this.f868f.getConfiguration().keyboard == 1 || !ad.c(ViewConfiguration.get(this.f867e), this.f867e)) {
            z3 = false;
        }
        this.f870h = z3;
    }

    private static int f(int i2) {
        int i3 = (-65536 & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = f863d;
            if (i3 < iArr.length) {
                return (i2 & 65535) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void f(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f886x.isEmpty()) {
            Iterator<WeakReference<m>> it2 = this.f886x.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.f886x.remove(next);
                } else {
                    int c2 = mVar.c();
                    if (c2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(c2)) != null) {
                        mVar.a(parcelable);
                    }
                }
            }
        }
    }

    public int a(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.f872j.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int f2 = f(i4);
        i a2 = a(i2, i3, i4, f2, charSequence, this.f878p);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f879q;
        if (contextMenuInfo != null) {
            a2.a(contextMenuInfo);
        }
        ArrayList<i> arrayList = this.f872j;
        arrayList.add(a(arrayList, f2), a2);
        b(true);
        return a2;
    }

    public g a(int i2) {
        this.f878p = i2;
        return this;
    }

    /* access modifiers changed from: protected */
    public g a(Drawable drawable) {
        a(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public g a(View view) {
        a(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    /* access modifiers changed from: protected */
    public g a(CharSequence charSequence) {
        a(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: package-private */
    public i a(int i2, KeyEvent keyEvent) {
        ArrayList<i> arrayList = this.f885w;
        arrayList.clear();
        a((List<i>) arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean c2 = c();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = arrayList.get(i3);
            char alphabeticShortcut = c2 ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
            if ((alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) || (c2 && alphabeticShortcut == 8 && i2 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String a() {
        return "android:menu:actionviewstates";
    }

    public void a(Bundle bundle) {
        e(bundle);
    }

    /* access modifiers changed from: package-private */
    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f872j.size();
        h();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.f872j.get(i2);
            if (iVar.getGroupId() == groupId && iVar.g() && iVar.isCheckable()) {
                iVar.b(iVar == menuItem);
            }
        }
        i();
    }

    public void a(a aVar) {
        this.f871i = aVar;
    }

    /* access modifiers changed from: package-private */
    public void a(i iVar) {
        this.f874l = true;
        b(true);
    }

    public void a(m mVar) {
        a(mVar, this.f867e);
    }

    public void a(m mVar, Context context) {
        this.f886x.add(new WeakReference(mVar));
        mVar.a(context, this);
        this.f877o = true;
    }

    /* access modifiers changed from: package-private */
    public void a(List<i> list, int i2, KeyEvent keyEvent) {
        boolean c2 = c();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f872j.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar = this.f872j.get(i3);
                if (iVar.hasSubMenu()) {
                    ((g) iVar.getSubMenu()).a(list, i2, keyEvent);
                }
                char alphabeticShortcut = c2 ? iVar.getAlphabeticShortcut() : iVar.getNumericShortcut();
                if (((modifiers & 69647) == ((c2 ? iVar.getAlphabeticModifiers() : iVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (c2 && alphabeticShortcut == 8 && i2 == 67)) && iVar.isEnabled())) {
                    list.add(iVar);
                }
            }
        }
    }

    public final void a(boolean z2) {
        if (!this.f884v) {
            this.f884v = true;
            Iterator<WeakReference<m>> it2 = this.f886x.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.f886x.remove(next);
                } else {
                    mVar.a(this, z2);
                }
            }
            this.f884v = false;
        }
    }

    public boolean a(MenuItem menuItem, int i2) {
        return a(menuItem, (m) null, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r1 != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if ((r9 & 1) == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        if (r1 == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MenuItem r7, androidx.appcompat.view.menu.m r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.i r7 = (androidx.appcompat.view.menu.i) r7
            r0 = 0
            if (r7 == 0) goto L_0x006c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto L_0x000c
            goto L_0x006c
        L_0x000c:
            boolean r1 = r7.b()
            t.b r2 = r7.a()
            r3 = 1
            if (r2 == 0) goto L_0x001f
            boolean r4 = r2.c()
            if (r4 == 0) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            boolean r5 = r7.n()
            if (r5 == 0) goto L_0x0031
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L_0x006b
        L_0x002d:
            r6.a((boolean) r3)
            goto L_0x006b
        L_0x0031:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L_0x003f
            if (r4 == 0) goto L_0x003a
            goto L_0x003f
        L_0x003a:
            r7 = r9 & 1
            if (r7 != 0) goto L_0x006b
            goto L_0x002d
        L_0x003f:
            r9 = r9 & 4
            if (r9 != 0) goto L_0x0046
            r6.a((boolean) r0)
        L_0x0046:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L_0x0058
            androidx.appcompat.view.menu.r r9 = new androidx.appcompat.view.menu.r
            android.content.Context r0 = r6.f()
            r9.<init>(r0, r6, r7)
            r7.a((androidx.appcompat.view.menu.r) r9)
        L_0x0058:
            android.view.SubMenu r7 = r7.getSubMenu()
            androidx.appcompat.view.menu.r r7 = (androidx.appcompat.view.menu.r) r7
            if (r4 == 0) goto L_0x0063
            r2.a((android.view.SubMenu) r7)
        L_0x0063:
            boolean r7 = r6.a((androidx.appcompat.view.menu.r) r7, (androidx.appcompat.view.menu.m) r8)
            r1 = r1 | r7
            if (r1 != 0) goto L_0x006b
            goto L_0x002d
        L_0x006b:
            return r1
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.g.a(android.view.MenuItem, androidx.appcompat.view.menu.m, int):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean a(g gVar, MenuItem menuItem) {
        a aVar = this.f871i;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f868f.getString(i2));
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f868f.getString(i5));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f867e.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f868f.getString(i2));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, (CharSequence) this.f868f.getString(i5));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        i iVar = (i) a(i2, i3, i4, charSequence);
        r rVar = new r(this.f867e, this, iVar);
        iVar.a(rVar);
        return rVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int b(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f872j.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public void b(Bundle bundle) {
        f(bundle);
    }

    /* access modifiers changed from: package-private */
    public void b(i iVar) {
        this.f877o = true;
        b(true);
    }

    public void b(m mVar) {
        Iterator<WeakReference<m>> it2 = this.f886x.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            m mVar2 = (m) next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.f886x.remove(next);
            }
        }
    }

    public void b(boolean z2) {
        if (!this.f880r) {
            if (z2) {
                this.f874l = true;
                this.f877o = true;
            }
            d(z2);
            return;
        }
        this.f881s = true;
        if (z2) {
            this.f882t = true;
        }
    }

    public boolean b() {
        return this.f888z;
    }

    public int c(int i2) {
        return a(i2, 0);
    }

    public void c(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).c(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(a(), sparseArray);
        }
    }

    public void c(boolean z2) {
        this.A = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f869g;
    }

    public boolean c(i iVar) {
        boolean z2 = false;
        if (this.f886x.isEmpty()) {
            return false;
        }
        h();
        Iterator<WeakReference<m>> it2 = this.f886x.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            m mVar = (m) next.get();
            if (mVar == null) {
                this.f886x.remove(next);
            } else {
                z2 = mVar.a(this, iVar);
                if (z2) {
                    break;
                }
            }
        }
        i();
        if (z2) {
            this.f887y = iVar;
        }
        return z2;
    }

    public void clear() {
        i iVar = this.f887y;
        if (iVar != null) {
            d(iVar);
        }
        this.f872j.clear();
        b(true);
    }

    public void clearHeader() {
        this.f865b = null;
        this.f864a = null;
        this.f866c = null;
        b(false);
    }

    public void close() {
        a(true);
    }

    /* access modifiers changed from: protected */
    public g d(int i2) {
        a(i2, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public void d(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(a());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((r) item.getSubMenu()).d(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public boolean d() {
        return this.f870h;
    }

    public boolean d(i iVar) {
        boolean z2 = false;
        if (!this.f886x.isEmpty() && this.f887y == iVar) {
            h();
            Iterator<WeakReference<m>> it2 = this.f886x.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.f886x.remove(next);
                } else {
                    z2 = mVar.b(this, iVar);
                    if (z2) {
                        break;
                    }
                }
            }
            i();
            if (z2) {
                this.f887y = null;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public Resources e() {
        return this.f868f;
    }

    /* access modifiers changed from: protected */
    public g e(int i2) {
        a(0, (CharSequence) null, i2, (Drawable) null, (View) null);
        return this;
    }

    public Context f() {
        return this.f867e;
    }

    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f872j.get(i3);
            if (iVar.getItemId() == i2) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (findItem = iVar.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public void g() {
        a aVar = this.f871i;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public MenuItem getItem(int i2) {
        return this.f872j.get(i2);
    }

    public void h() {
        if (!this.f880r) {
            this.f880r = true;
            this.f881s = false;
            this.f882t = false;
        }
    }

    public boolean hasVisibleItems() {
        if (this.A) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f872j.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        this.f880r = false;
        if (this.f881s) {
            this.f881s = false;
            b(this.f882t);
        }
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return a(i2, keyEvent) != null;
    }

    public ArrayList<i> j() {
        if (!this.f874l) {
            return this.f873k;
        }
        this.f873k.clear();
        int size = this.f872j.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.f872j.get(i2);
            if (iVar.isVisible()) {
                this.f873k.add(iVar);
            }
        }
        this.f874l = false;
        this.f877o = true;
        return this.f873k;
    }

    public void k() {
        ArrayList<i> j2 = j();
        if (this.f877o) {
            Iterator<WeakReference<m>> it2 = this.f886x.iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.f886x.remove(next);
                } else {
                    z2 |= mVar.b();
                }
            }
            if (z2) {
                this.f875m.clear();
                this.f876n.clear();
                int size = j2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i iVar = j2.get(i2);
                    (iVar.j() ? this.f875m : this.f876n).add(iVar);
                }
            } else {
                this.f875m.clear();
                this.f876n.clear();
                this.f876n.addAll(j());
            }
            this.f877o = false;
        }
    }

    public ArrayList<i> l() {
        k();
        return this.f875m;
    }

    public ArrayList<i> m() {
        k();
        return this.f876n;
    }

    public CharSequence n() {
        return this.f864a;
    }

    public Drawable o() {
        return this.f865b;
    }

    public View p() {
        return this.f866c;
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return a(findItem(i2), i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        i a2 = a(i2, keyEvent);
        boolean a3 = a2 != null ? a((MenuItem) a2, i3) : false;
        if ((i3 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    public g q() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.f883u;
    }

    public void removeGroup(int i2) {
        int c2 = c(i2);
        if (c2 >= 0) {
            int size = this.f872j.size() - c2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.f872j.get(c2).getGroupId() != i2) {
                    b(true);
                } else {
                    a(c2, false);
                    i3 = i4;
                }
            }
            b(true);
        }
    }

    public void removeItem(int i2) {
        a(b(i2), true);
    }

    public i s() {
        return this.f887y;
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.f872j.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f872j.get(i3);
            if (iVar.getGroupId() == i2) {
                iVar.a(z3);
                iVar.setCheckable(z2);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z2) {
        this.f888z = z2;
    }

    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.f872j.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f872j.get(i3);
            if (iVar.getGroupId() == i2) {
                iVar.setEnabled(z2);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z2) {
        int size = this.f872j.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f872j.get(i3);
            if (iVar.getGroupId() == i2 && iVar.c(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            b(true);
        }
    }

    public void setQwertyMode(boolean z2) {
        this.f869g = z2;
        b(false);
    }

    public int size() {
        return this.f872j.size();
    }
}
