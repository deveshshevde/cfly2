package com.bumptech.glide;

import ca.a;
import ca.c;
import com.bumptech.glide.i;

public abstract class i<CHILD extends i<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private c<? super TranscodeType> f10126a = a.a();

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (i) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final c<? super TranscodeType> b() {
        return this.f10126a;
    }
}
