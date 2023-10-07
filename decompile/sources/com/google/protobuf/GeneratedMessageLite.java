package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.a;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a<MessageType, BuilderType> {

    /* renamed from: b  reason: collision with root package name */
    protected q f11843b = q.a();

    /* renamed from: c  reason: collision with root package name */
    protected int f11844c = -1;

    /* renamed from: com.google.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20049a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.protobuf.WireFormat$JavaType[] r0 = com.google.protobuf.WireFormat.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20049a = r0
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20049a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.AnonymousClass1.<clinit>():void");
        }
    }

    static class EqualsVisitor implements h {

        /* renamed from: a  reason: collision with root package name */
        static final EqualsVisitor f20050a = new EqualsVisitor();

        /* renamed from: b  reason: collision with root package name */
        static final NotEqualsException f20051b = new NotEqualsException();

        static final class NotEqualsException extends RuntimeException {
            NotEqualsException() {
            }
        }

        private EqualsVisitor() {
        }

        public int a(boolean z2, int i2, boolean z3, int i3) {
            if (z2 == z3 && i2 == i3) {
                return i2;
            }
            throw f20051b;
        }

        public ByteString a(boolean z2, ByteString byteString, boolean z3, ByteString byteString2) {
            if (z2 == z3 && byteString.equals(byteString2)) {
                return byteString;
            }
            throw f20051b;
        }

        public <T extends k> T a(T t2, T t3) {
            if (t2 == null && t3 == null) {
                return null;
            }
            if (t2 == null || t3 == null) {
                throw f20051b;
            }
            ((GeneratedMessageLite) t2).a(this, (k) t3);
            return t2;
        }

        public q a(q qVar, q qVar2) {
            if (qVar.equals(qVar2)) {
                return qVar;
            }
            throw f20051b;
        }

        public String a(boolean z2, String str, boolean z3, String str2) {
            if (z2 == z3 && str.equals(str2)) {
                return str;
            }
            throw f20051b;
        }
    }

    public enum MethodToInvoke {
        IS_INITIALIZED,
        VISIT,
        MERGE_FROM_STREAM,
        MAKE_IMMUTABLE,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.C0132a<MessageType, BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        protected MessageType f20061a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f20062b = false;

        /* renamed from: c  reason: collision with root package name */
        private final MessageType f20063c;

        protected a(MessageType messagetype) {
            this.f20063c = messagetype;
            this.f20061a = (GeneratedMessageLite) messagetype.a(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        /* access modifiers changed from: protected */
        public BuilderType a(MessageType messagetype) {
            return b(messagetype);
        }

        public BuilderType b(MessageType messagetype) {
            b();
            this.f20061a.a((h) g.f20070a, messagetype);
            return this;
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (this.f20062b) {
                MessageType messagetype = (GeneratedMessageLite) this.f20061a.a(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                messagetype.a((h) g.f20070a, this.f20061a);
                this.f20061a = messagetype;
                this.f20062b = false;
            }
        }

        /* renamed from: c */
        public BuilderType clone() {
            BuilderType f2 = k().f();
            f2.b(d());
            return f2;
        }

        public MessageType d() {
            if (this.f20062b) {
                return this.f20061a;
            }
            this.f20061a.g();
            this.f20062b = true;
            return this.f20061a;
        }

        /* renamed from: e */
        public final MessageType g() {
            MessageType d2 = d();
            if (d2.h()) {
                return d2;
            }
            throw b(d2);
        }

        /* renamed from: f */
        public MessageType k() {
            return this.f20063c;
        }

        public final boolean h() {
            return GeneratedMessageLite.a(this.f20061a, false);
        }
    }

    protected static class b<T extends GeneratedMessageLite<T, ?>> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        private T f20064a;

        public b(T t2) {
            this.f20064a = t2;
        }

        /* renamed from: a */
        public T b(d dVar, f fVar) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.a(this.f20064a, dVar, fVar);
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements d<MessageType, BuilderType> {

        /* renamed from: d  reason: collision with root package name */
        protected g<e> f20065d = g.a();
    }

    public interface d extends l {
    }

    static final class e implements g.a<e> {

        /* renamed from: a  reason: collision with root package name */
        final int f20066a;

        /* renamed from: b  reason: collision with root package name */
        final WireFormat.FieldType f20067b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f20068c;

        /* renamed from: a */
        public int compareTo(e eVar) {
            return this.f20066a - eVar.f20066a;
        }

        public WireFormat.FieldType a() {
            return this.f20067b;
        }

        public boolean b() {
            return this.f20068c;
        }

        public int c() {
            return this.f20066a;
        }
    }

    private static class f implements h {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f20069a;

        private f() {
            this.f20069a = 0;
        }

        /* synthetic */ f(AnonymousClass1 r1) {
            this();
        }

        public int a(boolean z2, int i2, boolean z3, int i3) {
            this.f20069a = (this.f20069a * 53) + i2;
            return i2;
        }

        public ByteString a(boolean z2, ByteString byteString, boolean z3, ByteString byteString2) {
            this.f20069a = (this.f20069a * 53) + byteString.hashCode();
            return byteString;
        }

        public <T extends k> T a(T t2, T t3) {
            this.f20069a = (this.f20069a * 53) + (t2 != null ? t2 instanceof GeneratedMessageLite ? ((GeneratedMessageLite) t2).a(this) : t2.hashCode() : 37);
            return t2;
        }

        public q a(q qVar, q qVar2) {
            this.f20069a = (this.f20069a * 53) + qVar.hashCode();
            return qVar;
        }

        public String a(boolean z2, String str, boolean z3, String str2) {
            this.f20069a = (this.f20069a * 53) + str.hashCode();
            return str;
        }
    }

    protected static class g implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final g f20070a = new g();

        private g() {
        }

        public int a(boolean z2, int i2, boolean z3, int i3) {
            return z3 ? i3 : i2;
        }

        public ByteString a(boolean z2, ByteString byteString, boolean z3, ByteString byteString2) {
            return z3 ? byteString2 : byteString;
        }

        public <T extends k> T a(T t2, T t3) {
            return (t2 == null || t3 == null) ? t2 != null ? t2 : t3 : t2.j().c(t3).g();
        }

        public q a(q qVar, q qVar2) {
            return qVar2 == q.a() ? qVar : q.a(qVar, qVar2);
        }

        public String a(boolean z2, String str, boolean z3, String str2) {
            return z3 ? str2 : str;
        }
    }

    protected interface h {
        int a(boolean z2, int i2, boolean z3, int i3);

        ByteString a(boolean z2, ByteString byteString, boolean z3, ByteString byteString2);

        <T extends k> T a(T t2, T t3);

        q a(q qVar, q qVar2);

        String a(boolean z2, String str, boolean z3, String str2);
    }

    private static <T extends GeneratedMessageLite<T, ?>> T a(T t2) throws InvalidProtocolBufferException {
        if (t2 == null || t2.h()) {
            return t2;
        }
        throw t2.c().a().a(t2);
    }

    static <T extends GeneratedMessageLite<T, ?>> T a(T t2, d dVar, f fVar) throws InvalidProtocolBufferException {
        T t3 = (GeneratedMessageLite) t2.a(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            t3.a(MethodToInvoke.MERGE_FROM_STREAM, (Object) dVar, (Object) fVar);
            t3.g();
            return t3;
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw e2;
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T a(T t2, byte[] bArr) throws InvalidProtocolBufferException {
        return a(a(t2, bArr, f.b()));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T a(T t2, byte[] bArr, f fVar) throws InvalidProtocolBufferException {
        T a2;
        try {
            d a3 = d.a(bArr);
            a2 = a(t2, a3, fVar);
            a3.a(0);
            return a2;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.a(a2);
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }

    static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean a(T t2, boolean z2) {
        return t2.a(MethodToInvoke.IS_INITIALIZED, (Object) Boolean.valueOf(z2)) != null;
    }

    /* access modifiers changed from: package-private */
    public int a(f fVar) {
        if (this.f11845a == 0) {
            int a2 = fVar.f20069a;
            int unused = fVar.f20069a = 0;
            a((h) fVar, this);
            this.f11845a = fVar.f20069a;
            int unused2 = fVar.f20069a = a2;
        }
        return this.f11845a;
    }

    /* access modifiers changed from: protected */
    public Object a(MethodToInvoke methodToInvoke) {
        return a(methodToInvoke, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public Object a(MethodToInvoke methodToInvoke, Object obj) {
        return a(methodToInvoke, obj, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object a(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public void a(h hVar, MessageType messagetype) {
        a(MethodToInvoke.VISIT, (Object) hVar, (Object) messagetype);
        this.f11843b = hVar.a(this.f11843b, messagetype.f11843b);
    }

    /* access modifiers changed from: package-private */
    public boolean a(EqualsVisitor equalsVisitor, k kVar) {
        if (this == kVar) {
            return true;
        }
        if (!k().getClass().isInstance(kVar)) {
            return false;
        }
        a((h) equalsVisitor, (GeneratedMessageLite) kVar);
        return true;
    }

    public final n<MessageType> d() {
        return (n) a(MethodToInvoke.GET_PARSER);
    }

    /* renamed from: e */
    public final MessageType k() {
        return (GeneratedMessageLite) a(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k().getClass().isInstance(obj)) {
            return false;
        }
        try {
            a((h) EqualsVisitor.f20050a, (GeneratedMessageLite) obj);
            return true;
        } catch (EqualsVisitor.NotEqualsException unused) {
            return false;
        }
    }

    public final BuilderType f() {
        return (a) a(MethodToInvoke.NEW_BUILDER);
    }

    /* access modifiers changed from: protected */
    public void g() {
        a(MethodToInvoke.MAKE_IMMUTABLE);
        this.f11843b.b();
    }

    public final boolean h() {
        return a(MethodToInvoke.IS_INITIALIZED, (Object) Boolean.TRUE) != null;
    }

    public int hashCode() {
        if (this.f11845a == 0) {
            f fVar = new f((AnonymousClass1) null);
            a((h) fVar, this);
            this.f11845a = fVar.f20069a;
        }
        return this.f11845a;
    }

    /* renamed from: i */
    public final BuilderType j() {
        BuilderType buildertype = (a) a(MethodToInvoke.NEW_BUILDER);
        buildertype.b(this);
        return buildertype;
    }

    public String toString() {
        return m.a(this, super.toString());
    }
}
