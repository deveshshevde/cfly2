package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.q;
import fj.u;

abstract class TagPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    protected final u f15482a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str);
        }
    }

    protected TagPayloadReader(u uVar) {
        this.f15482a = uVar;
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(q qVar) throws ParserException;

    /* access modifiers changed from: protected */
    public abstract boolean a(q qVar, long j2) throws ParserException;

    public final boolean b(q qVar, long j2) throws ParserException {
        return a(qVar) && a(qVar, j2);
    }
}
