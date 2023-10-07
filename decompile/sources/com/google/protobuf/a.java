package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.a;
import com.google.protobuf.a.C0132a;
import com.google.protobuf.k;
import java.io.IOException;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0132a<MessageType, BuilderType>> implements k {

    /* renamed from: a  reason: collision with root package name */
    protected int f11845a = 0;

    /* renamed from: com.google.protobuf.a$a  reason: collision with other inner class name */
    public static abstract class C0132a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0132a<MessageType, BuilderType>> implements k.a {
        protected static UninitializedMessageException b(k kVar) {
            return new UninitializedMessageException(kVar);
        }

        /* renamed from: a */
        public abstract BuilderType clone();

        /* access modifiers changed from: protected */
        public abstract BuilderType a(MessageType messagetype);

        /* renamed from: a */
        public BuilderType c(k kVar) {
            if (k().getClass().isInstance(kVar)) {
                return a((a) kVar);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    private String a(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public ByteString a() {
        try {
            ByteString.d b2 = ByteString.b(l());
            a(b2.b());
            return b2.a();
        } catch (IOException e2) {
            throw new RuntimeException(a("ByteString"), e2);
        }
    }

    public byte[] b() {
        try {
            byte[] bArr = new byte[l()];
            CodedOutputStream a2 = CodedOutputStream.a(bArr);
            a(a2);
            a2.b();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(a("byte array"), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public UninitializedMessageException c() {
        return new UninitializedMessageException(this);
    }
}
