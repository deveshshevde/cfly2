package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.s;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

public class d<T> implements i<T> {

    /* renamed from: b  reason: collision with root package name */
    private final Collection<? extends i<T>> f10158b;

    @SafeVarargs
    public d(i<T>... iVarArr) {
        if (iVarArr.length != 0) {
            this.f10158b = Arrays.asList(iVarArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public s<T> a(Context context, s<T> sVar, int i2, int i3) {
        s<T> sVar2 = sVar;
        for (i a2 : this.f10158b) {
            s<T> a3 = a2.a(context, sVar2, i2, i3);
            if (sVar2 != null && !sVar2.equals(sVar) && !sVar2.equals(a3)) {
                sVar2.f();
            }
            sVar2 = a3;
        }
        return sVar2;
    }

    public void a(MessageDigest messageDigest) {
        for (i a2 : this.f10158b) {
            a2.a(messageDigest);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f10158b.equals(((d) obj).f10158b);
        }
        return false;
    }

    public int hashCode() {
        return this.f10158b.hashCode();
    }
}
