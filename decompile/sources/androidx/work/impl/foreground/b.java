package androidx.work.impl.foreground;

import al.c;
import al.d;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.j;
import ao.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class b implements c, androidx.work.impl.b {

    /* renamed from: a  reason: collision with root package name */
    static final String f5258a = j.a("SystemFgDispatcher");

    /* renamed from: b  reason: collision with root package name */
    final Object f5259b = new Object();

    /* renamed from: c  reason: collision with root package name */
    String f5260c;

    /* renamed from: d  reason: collision with root package name */
    final Map<String, e> f5261d;

    /* renamed from: e  reason: collision with root package name */
    final Map<String, p> f5262e;

    /* renamed from: f  reason: collision with root package name */
    final Set<p> f5263f;

    /* renamed from: g  reason: collision with root package name */
    final d f5264g;

    /* renamed from: h  reason: collision with root package name */
    private Context f5265h;

    /* renamed from: i  reason: collision with root package name */
    private androidx.work.impl.j f5266i;

    /* renamed from: j  reason: collision with root package name */
    private final ap.a f5267j;

    /* renamed from: k  reason: collision with root package name */
    private a f5268k;

    interface a {
        void a();

        void a(int i2);

        void a(int i2, int i3, Notification notification);

        void a(int i2, Notification notification);
    }

    b(Context context) {
        this.f5265h = context;
        androidx.work.impl.j b2 = androidx.work.impl.j.b(this.f5265h);
        this.f5266i = b2;
        ap.a g2 = b2.g();
        this.f5267j = g2;
        this.f5260c = null;
        this.f5261d = new LinkedHashMap();
        this.f5263f = new HashSet();
        this.f5262e = new HashMap();
        this.f5264g = new d(this.f5265h, g2, this);
        this.f5266i.f().a((androidx.work.impl.b) this);
    }

    public static Intent a(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    public static Intent a(Context context, String str, e eVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.a());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.b());
        intent.putExtra("KEY_NOTIFICATION", eVar.c());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent b(Context context, String str, e eVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.a());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.b());
        intent.putExtra("KEY_NOTIFICATION", eVar.c());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    private void c(Intent intent) {
        j.a().c(f5258a, String.format("Started foreground service %s", new Object[]{intent}), new Throwable[0]);
        final String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        final WorkDatabase c2 = this.f5266i.c();
        this.f5267j.a(new Runnable() {
            public void run() {
                p b2 = c2.o().b(stringExtra);
                if (b2 != null && b2.d()) {
                    synchronized (b.this.f5259b) {
                        b.this.f5262e.put(stringExtra, b2);
                        b.this.f5263f.add(b2);
                        b.this.f5264g.a((Iterable<p>) b.this.f5263f);
                    }
                }
            }
        });
    }

    private void d(Intent intent) {
        int i2 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        j.a().b(f5258a, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)}), new Throwable[0]);
        if (notification != null && this.f5268k != null) {
            this.f5261d.put(stringExtra, new e(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f5260c)) {
                this.f5260c = stringExtra;
                this.f5268k.a(intExtra, intExtra2, notification);
                return;
            }
            this.f5268k.a(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, e> value : this.f5261d.entrySet()) {
                    i2 |= ((e) value.getValue()).b();
                }
                e eVar = this.f5261d.get(this.f5260c);
                if (eVar != null) {
                    this.f5268k.a(eVar.a(), i2, eVar.c());
                }
            }
        }
    }

    private void e(Intent intent) {
        j.a().c(f5258a, String.format("Stopping foreground work for %s", new Object[]{intent}), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.f5266i.a(UUID.fromString(stringExtra));
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f5268k = null;
        synchronized (this.f5259b) {
            this.f5264g.a();
        }
        this.f5266i.f().b((androidx.work.impl.b) this);
    }

    /* access modifiers changed from: package-private */
    public void a(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            c(intent);
        } else if (!"ACTION_NOTIFY".equals(action)) {
            if ("ACTION_CANCEL_WORK".equals(action)) {
                e(intent);
                return;
            } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
                b(intent);
                return;
            } else {
                return;
            }
        }
        d(intent);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        if (this.f5268k != null) {
            j.a().e(f5258a, "A callback already exists.", new Throwable[0]);
        } else {
            this.f5268k = aVar;
        }
    }

    public void a(String str, boolean z2) {
        Map.Entry next;
        synchronized (this.f5259b) {
            p remove = this.f5262e.remove(str);
            if (remove != null ? this.f5263f.remove(remove) : false) {
                this.f5264g.a((Iterable<p>) this.f5263f);
            }
        }
        e remove2 = this.f5261d.remove(str);
        if (str.equals(this.f5260c) && this.f5261d.size() > 0) {
            Iterator<Map.Entry<String, e>> it2 = this.f5261d.entrySet().iterator();
            do {
                next = it2.next();
            } while (it2.hasNext());
            this.f5260c = (String) next.getKey();
            if (this.f5268k != null) {
                e eVar = (e) next.getValue();
                this.f5268k.a(eVar.a(), eVar.b(), eVar.c());
                this.f5268k.a(eVar.a());
            }
        }
        a aVar = this.f5268k;
        if (remove2 != null && aVar != null) {
            j.a().b(f5258a, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[]{Integer.valueOf(remove2.a()), str, Integer.valueOf(remove2.b())}), new Throwable[0]);
            aVar.a(remove2.a());
        }
    }

    public void a(List<String> list) {
    }

    /* access modifiers changed from: package-private */
    public void b(Intent intent) {
        j.a().c(f5258a, "Stopping foreground service", new Throwable[0]);
        a aVar = this.f5268k;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void b(List<String> list) {
        if (!list.isEmpty()) {
            for (String next : list) {
                j.a().b(f5258a, String.format("Constraints unmet for WorkSpec %s", new Object[]{next}), new Throwable[0]);
                this.f5266i.c(next);
            }
        }
    }
}
