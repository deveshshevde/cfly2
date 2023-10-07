package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f2940a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f2941b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence[] f2942c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2943d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2944e;

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f2945f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<String> f2946g;

    static RemoteInput a(m mVar) {
        Set<String> d2;
        RemoteInput.Builder addExtras = new RemoteInput.Builder(mVar.a()).setLabel(mVar.b()).setChoices(mVar.c()).setAllowFreeFormInput(mVar.e()).addExtras(mVar.g());
        if (Build.VERSION.SDK_INT >= 26 && (d2 = mVar.d()) != null) {
            for (String allowDataType : d2) {
                addExtras.setAllowDataType(allowDataType, true);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(mVar.f());
        }
        return addExtras.build();
    }

    static RemoteInput[] a(m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[mVarArr.length];
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            remoteInputArr[i2] = a(mVarArr[i2]);
        }
        return remoteInputArr;
    }

    public String a() {
        return this.f2940a;
    }

    public CharSequence b() {
        return this.f2941b;
    }

    public CharSequence[] c() {
        return this.f2942c;
    }

    public Set<String> d() {
        return this.f2946g;
    }

    public boolean e() {
        return this.f2943d;
    }

    public int f() {
        return this.f2944e;
    }

    public Bundle g() {
        return this.f2945f;
    }
}
