package bf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import bd.c;
import bd.d;
import bd.e;
import be.a;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import java.util.concurrent.ThreadPoolExecutor;

final class b {

    /* renamed from: a  reason: collision with root package name */
    static a f5609a = new bh.a("ARouter::");

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f5610b = false;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f5611c = false;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f5612d = false;

    /* renamed from: e  reason: collision with root package name */
    private static volatile b f5613e = null;

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f5614f = false;

    /* renamed from: g  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f5615g = bg.a.a();

    /* renamed from: h  reason: collision with root package name */
    private static Handler f5616h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static Context f5617i;

    /* renamed from: j  reason: collision with root package name */
    private static c f5618j;

    /* renamed from: bf.b$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5632a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.alibaba.android.arouter.facade.enums.RouteType[] r0 = com.alibaba.android.arouter.facade.enums.RouteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5632a = r0
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5632a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.PROVIDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5632a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.BOARDCAST     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5632a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.CONTENT_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5632a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.FRAGMENT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f5632a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.METHOD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f5632a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.SERVICE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bf.b.AnonymousClass4.<clinit>():void");
        }
    }

    private b() {
    }

    protected static b a() {
        if (f5614f) {
            if (f5613e == null) {
                synchronized (b.class) {
                    if (f5613e == null) {
                        f5613e = new b();
                    }
                }
            }
            return f5613e;
        }
        throw new InitException("ARouterCore::Init::Invoke init(context) first!");
    }

    /* access modifiers changed from: private */
    public void a(int i2, Context context, Intent intent, ba.a aVar, bb.b bVar) {
        if (i2 < 0) {
            androidx.core.app.a.a(context, intent, aVar.a());
        } else if (context instanceof Activity) {
            androidx.core.app.a.a((Activity) context, intent, i2, aVar.a());
        } else {
            f5609a.c("ARouter::", "Must use [navigation(activity, ...)] to support [startActivityForResult]");
        }
        if (!(-1 == aVar.b() || -1 == aVar.c() || !(context instanceof Activity))) {
            ((Activity) context).overridePendingTransition(aVar.b(), aVar.c());
        }
        if (bVar != null) {
            bVar.c(aVar);
        }
    }

    static void a(Object obj) {
        bd.a aVar = (bd.a) a.a().a("/arouter/service/autowired").h();
        if (aVar != null) {
            aVar.a(obj);
        }
    }

    private void a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            f5616h.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object b(android.content.Context r9, ba.a r10, int r11, bb.b r12) {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x0004
            android.content.Context r9 = f5617i
        L_0x0004:
            r3 = r9
            int[] r9 = bf.b.AnonymousClass4.f5632a
            com.alibaba.android.arouter.facade.enums.RouteType r0 = r10.m()
            int r0 = r0.ordinal()
            r9 = r9[r0]
            r0 = 1
            r7 = 0
            if (r9 == r0) goto L_0x0078
            r11 = 2
            if (r9 == r11) goto L_0x0073
            r11 = 3
            if (r9 == r11) goto L_0x0022
            r11 = 4
            if (r9 == r11) goto L_0x0022
            r11 = 5
            if (r9 == r11) goto L_0x0022
            goto L_0x0072
        L_0x0022:
            java.lang.Class r9 = r10.n()
            r11 = 0
            java.lang.Class[] r12 = new java.lang.Class[r11]     // Catch:{ Exception -> 0x0051 }
            java.lang.reflect.Constructor r9 = r9.getConstructor(r12)     // Catch:{ Exception -> 0x0051 }
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x0051 }
            java.lang.Object r9 = r9.newInstance(r11)     // Catch:{ Exception -> 0x0051 }
            boolean r11 = r9 instanceof android.app.Fragment     // Catch:{ Exception -> 0x0051 }
            if (r11 == 0) goto L_0x0042
            r11 = r9
            android.app.Fragment r11 = (android.app.Fragment) r11     // Catch:{ Exception -> 0x0051 }
            android.os.Bundle r10 = r10.f()     // Catch:{ Exception -> 0x0051 }
            r11.setArguments(r10)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0050
        L_0x0042:
            boolean r11 = r9 instanceof androidx.fragment.app.Fragment     // Catch:{ Exception -> 0x0051 }
            if (r11 == 0) goto L_0x0050
            r11 = r9
            androidx.fragment.app.Fragment r11 = (androidx.fragment.app.Fragment) r11     // Catch:{ Exception -> 0x0051 }
            android.os.Bundle r10 = r10.f()     // Catch:{ Exception -> 0x0051 }
            r11.setArguments(r10)     // Catch:{ Exception -> 0x0051 }
        L_0x0050:
            return r9
        L_0x0051:
            r9 = move-exception
            be.a r10 = f5609a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Fetch fragment instance error, "
            r11.append(r12)
            java.lang.StackTraceElement[] r9 = r9.getStackTrace()
            java.lang.String r9 = bh.c.a((java.lang.StackTraceElement[]) r9)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String r11 = "ARouter::"
            r10.d(r11, r9)
        L_0x0072:
            return r7
        L_0x0073:
            be.b r9 = r10.d()
            return r9
        L_0x0078:
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class r9 = r10.n()
            r4.<init>(r3, r9)
            android.os.Bundle r9 = r10.f()
            r4.putExtras(r9)
            int r9 = r10.j()
            r0 = -1
            if (r0 == r9) goto L_0x0093
        L_0x008f:
            r4.setFlags(r9)
            goto L_0x009a
        L_0x0093:
            boolean r9 = r3 instanceof android.app.Activity
            if (r9 != 0) goto L_0x009a
            r9 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x008f
        L_0x009a:
            java.lang.String r9 = r10.k()
            boolean r0 = bh.c.a((java.lang.CharSequence) r9)
            if (r0 != 0) goto L_0x00a7
            r4.setAction(r9)
        L_0x00a7:
            bf.b$3 r9 = new bf.b$3
            r0 = r9
            r1 = r8
            r2 = r11
            r5 = r10
            r6 = r12
            r0.<init>(r2, r3, r4, r5, r6)
            r8.a((java.lang.Runnable) r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.b.b(android.content.Context, ba.a, int, bb.b):java.lang.Object");
    }

    private String b(String str) {
        if (bh.c.a((CharSequence) str) || !str.startsWith("/")) {
            throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String substring = str.substring(1, str.indexOf("/", 1));
            if (!bh.c.a((CharSequence) substring)) {
                return substring;
            }
            throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
        } catch (Exception e2) {
            a aVar = f5609a;
            aVar.c("ARouter::", "Failed to extract default group! " + e2.getMessage());
            return null;
        }
    }

    static boolean b() {
        return f5611c;
    }

    /* access modifiers changed from: protected */
    public ba.a a(String str) {
        if (!bh.c.a((CharSequence) str)) {
            d dVar = (d) a.a().a(d.class);
            if (dVar != null) {
                str = dVar.a(str);
            }
            return a(str, b(str));
        }
        throw new HandlerException("ARouter::Parameter is invalid!");
    }

    /* access modifiers changed from: protected */
    public ba.a a(String str, String str2) {
        if (bh.c.a((CharSequence) str) || bh.c.a((CharSequence) str2)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        d dVar = (d) a.a().a(d.class);
        if (dVar != null) {
            str = dVar.a(str);
        }
        return new ba.a(str, str2);
    }

    /* access modifiers changed from: protected */
    public Object a(Context context, final ba.a aVar, int i2, bb.b bVar) {
        e eVar = (e) a.a().a(e.class);
        if (eVar != null && !eVar.a(context, aVar)) {
            return null;
        }
        try {
            az.a.a(aVar);
            if (bVar != null) {
                bVar.a(aVar);
            }
            if (aVar.e()) {
                return b(context, aVar, i2, bVar);
            }
            final Context context2 = context;
            final int i3 = i2;
            final bb.b bVar2 = bVar;
            final ba.a aVar2 = aVar;
            f5618j.a(aVar, new bb.a() {
            });
            return null;
        } catch (NoRouteFoundException e2) {
            f5609a.c("ARouter::", e2.getMessage());
            if (b()) {
                a((Runnable) new Runnable() {
                    public void run() {
                        Context c2 = b.f5617i;
                        Toast.makeText(c2, "There's no route matched!\n Path = [" + aVar.o() + "]\n Group = [" + aVar.p() + "]", 1).show();
                    }
                });
            }
            if (bVar != null) {
                bVar.b(aVar);
            } else {
                bd.b bVar3 = (bd.b) a.a().a(bd.b.class);
                if (bVar3 != null) {
                    bVar3.a(context, aVar);
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public <T> T a(Class<? extends T> cls) {
        try {
            ba.a a2 = az.a.a(cls.getName());
            if (a2 == null) {
                a2 = az.a.a(cls.getSimpleName());
            }
            if (a2 == null) {
                return null;
            }
            az.a.a(a2);
            return a2.d();
        } catch (NoRouteFoundException e2) {
            f5609a.c("ARouter::", e2.getMessage());
            return null;
        }
    }
}
