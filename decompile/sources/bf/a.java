package bf;

import android.content.Context;
import bb.b;
import com.alibaba.android.arouter.exception.InitException;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static be.a f5606a = null;

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f5607b = null;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f5608c = false;

    private a() {
    }

    public static a a() {
        if (f5608c) {
            if (f5607b == null) {
                synchronized (a.class) {
                    if (f5607b == null) {
                        f5607b = new a();
                    }
                }
            }
            return f5607b;
        }
        throw new InitException("ARouter::Init::Invoke init(context) first!");
    }

    public static boolean b() {
        return b.b();
    }

    public ba.a a(String str) {
        return b.a().a(str);
    }

    public Object a(Context context, ba.a aVar, int i2, b bVar) {
        return b.a().a(context, aVar, i2, bVar);
    }

    public <T> T a(Class<? extends T> cls) {
        return b.a().a(cls);
    }

    public void a(Object obj) {
        b.a(obj);
    }
}
