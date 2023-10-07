package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.a;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2907a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static String f2908b;

    /* renamed from: c  reason: collision with root package name */
    private static Set<String> f2909c = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private static final Object f2910f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static d f2911g;

    /* renamed from: d  reason: collision with root package name */
    private final Context f2912d;

    /* renamed from: e  reason: collision with root package name */
    private final NotificationManager f2913e;

    private static class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final String f2914a;

        /* renamed from: b  reason: collision with root package name */
        final int f2915b;

        /* renamed from: c  reason: collision with root package name */
        final String f2916c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f2917d;

        a(String str) {
            this.f2914a = str;
            this.f2915b = 0;
            this.f2916c = null;
            this.f2917d = true;
        }

        a(String str, int i2, String str2) {
            this.f2914a = str;
            this.f2915b = i2;
            this.f2916c = str2;
            this.f2917d = false;
        }

        public void a(android.support.v4.app.a aVar) throws RemoteException {
            if (this.f2917d) {
                aVar.a(this.f2914a);
            } else {
                aVar.a(this.f2914a, this.f2915b, this.f2916c);
            }
        }

        public String toString() {
            return "CancelTask[" + "packageName:" + this.f2914a + ", id:" + this.f2915b + ", tag:" + this.f2916c + ", all:" + this.f2917d + "]";
        }
    }

    private static class b implements e {

        /* renamed from: a  reason: collision with root package name */
        final String f2918a;

        /* renamed from: b  reason: collision with root package name */
        final int f2919b;

        /* renamed from: c  reason: collision with root package name */
        final String f2920c;

        /* renamed from: d  reason: collision with root package name */
        final Notification f2921d;

        b(String str, int i2, String str2, Notification notification) {
            this.f2918a = str;
            this.f2919b = i2;
            this.f2920c = str2;
            this.f2921d = notification;
        }

        public void a(android.support.v4.app.a aVar) throws RemoteException {
            aVar.a(this.f2918a, this.f2919b, this.f2920c, this.f2921d);
        }

        public String toString() {
            return "NotifyTask[" + "packageName:" + this.f2918a + ", id:" + this.f2919b + ", tag:" + this.f2920c + "]";
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f2922a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f2923b;

        c(ComponentName componentName, IBinder iBinder) {
            this.f2922a = componentName;
            this.f2923b = iBinder;
        }
    }

    private static class d implements ServiceConnection, Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2924a;

        /* renamed from: b  reason: collision with root package name */
        private final HandlerThread f2925b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f2926c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<ComponentName, a> f2927d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private Set<String> f2928e = new HashSet();

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            final ComponentName f2929a;

            /* renamed from: b  reason: collision with root package name */
            boolean f2930b = false;

            /* renamed from: c  reason: collision with root package name */
            android.support.v4.app.a f2931c;

            /* renamed from: d  reason: collision with root package name */
            ArrayDeque<e> f2932d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            int f2933e = 0;

            a(ComponentName componentName) {
                this.f2929a = componentName;
            }
        }

        d(Context context) {
            this.f2924a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f2925b = handlerThread;
            handlerThread.start();
            this.f2926c = new Handler(handlerThread.getLooper(), this);
        }

        private void a() {
            Set<String> b2 = k.b(this.f2924a);
            if (!b2.equals(this.f2928e)) {
                this.f2928e = b2;
                List<ResolveInfo> queryIntentServices = this.f2924a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet<ComponentName> hashSet = new HashSet<>();
                for (ResolveInfo next : queryIntentServices) {
                    if (b2.contains(next.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(next.serviceInfo.packageName, next.serviceInfo.name);
                        if (next.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f2927d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f2927d.put(componentName2, new a(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, a>> it2 = this.f2927d.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry next2 = it2.next();
                    if (!hashSet.contains(next2.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + next2.getKey());
                        }
                        b((a) next2.getValue());
                        it2.remove();
                    }
                }
            }
        }

        private void a(ComponentName componentName) {
            a aVar = this.f2927d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void a(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f2927d.get(componentName);
            if (aVar != null) {
                aVar.f2931c = a.C0005a.a(iBinder);
                aVar.f2933e = 0;
                d(aVar);
            }
        }

        private boolean a(a aVar) {
            if (aVar.f2930b) {
                return true;
            }
            aVar.f2930b = this.f2924a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f2929a), this, 33);
            if (aVar.f2930b) {
                aVar.f2933e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f2929a);
                this.f2924a.unbindService(this);
            }
            return aVar.f2930b;
        }

        private void b(ComponentName componentName) {
            a aVar = this.f2927d.get(componentName);
            if (aVar != null) {
                d(aVar);
            }
        }

        private void b(a aVar) {
            if (aVar.f2930b) {
                this.f2924a.unbindService(this);
                aVar.f2930b = false;
            }
            aVar.f2931c = null;
        }

        private void b(e eVar) {
            a();
            for (a next : this.f2927d.values()) {
                next.f2932d.add(eVar);
                d(next);
            }
        }

        private void c(a aVar) {
            if (!this.f2926c.hasMessages(3, aVar.f2929a)) {
                aVar.f2933e++;
                if (aVar.f2933e > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + aVar.f2932d.size() + " tasks to " + aVar.f2929a + " after " + aVar.f2933e + " retries");
                    aVar.f2932d.clear();
                    return;
                }
                int i2 = (1 << (aVar.f2933e - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i2 + " ms");
                }
                this.f2926c.sendMessageDelayed(this.f2926c.obtainMessage(3, aVar.f2929a), (long) i2);
            }
        }

        private void d(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f2929a + ", " + aVar.f2932d.size() + " queued tasks");
            }
            if (!aVar.f2932d.isEmpty()) {
                if (!a(aVar) || aVar.f2931c == null) {
                    c(aVar);
                    return;
                }
                while (true) {
                    e peek = aVar.f2932d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.a(aVar.f2931c);
                        aVar.f2932d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.f2929a);
                        }
                    } catch (RemoteException e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f2929a, e2);
                    }
                }
                if (!aVar.f2932d.isEmpty()) {
                    c(aVar);
                }
            }
        }

        public void a(e eVar) {
            this.f2926c.obtainMessage(0, eVar).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                b((e) message.obj);
                return true;
            } else if (i2 == 1) {
                c cVar = (c) message.obj;
                a(cVar.f2922a, cVar.f2923b);
                return true;
            } else if (i2 == 2) {
                a((ComponentName) message.obj);
                return true;
            } else if (i2 != 3) {
                return false;
            } else {
                b((ComponentName) message.obj);
                return true;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f2926c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f2926c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    private interface e {
        void a(android.support.v4.app.a aVar) throws RemoteException;
    }

    private k(Context context) {
        this.f2912d = context;
        this.f2913e = (NotificationManager) context.getSystemService("notification");
    }

    public static k a(Context context) {
        return new k(context);
    }

    private void a(e eVar) {
        synchronized (f2910f) {
            if (f2911g == null) {
                f2911g = new d(this.f2912d.getApplicationContext());
            }
            f2911g.a(eVar);
        }
    }

    private static boolean a(Notification notification) {
        Bundle a2 = h.a(notification);
        return a2 != null && a2.getBoolean("android.support.useSideChannel");
    }

    public static Set<String> b(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f2907a) {
            if (string != null) {
                if (!string.equals(f2908b)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    f2909c = hashSet;
                    f2908b = string;
                }
            }
            set = f2909c;
        }
        return set;
    }

    public void a() {
        this.f2913e.cancelAll();
        if (Build.VERSION.SDK_INT <= 19) {
            a((e) new a(this.f2912d.getPackageName()));
        }
    }

    public void a(int i2) {
        a((String) null, i2);
    }

    public void a(int i2, Notification notification) {
        a((String) null, i2, notification);
    }

    public void a(String str, int i2) {
        this.f2913e.cancel(str, i2);
        if (Build.VERSION.SDK_INT <= 19) {
            a((e) new a(this.f2912d.getPackageName(), i2, str));
        }
    }

    public void a(String str, int i2, Notification notification) {
        if (a(notification)) {
            a((e) new b(this.f2912d.getPackageName(), i2, str, notification));
            this.f2913e.cancel(str, i2);
            return;
        }
        this.f2913e.notify(str, i2, notification);
    }

    public boolean b() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f2913e.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f2912d.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f2912d.getApplicationInfo();
        String packageName = this.f2912d.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName})).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
