package androidx.room;

import ag.c;
import ag.e;
import android.database.Cursor;
import java.util.List;

public class j extends c.a {

    /* renamed from: b  reason: collision with root package name */
    private a f4446b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4447c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4448d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4449e;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4450a;

        public a(int i2) {
            this.f4450a = i2;
        }

        /* access modifiers changed from: protected */
        public abstract void a(ag.b bVar);

        /* access modifiers changed from: protected */
        public abstract void b(ag.b bVar);

        /* access modifiers changed from: protected */
        public abstract void c(ag.b bVar);

        /* access modifiers changed from: protected */
        public abstract void d(ag.b bVar);

        /* access modifiers changed from: protected */
        @Deprecated
        public void e(ag.b bVar) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        /* access modifiers changed from: protected */
        public b f(ag.b bVar) {
            e(bVar);
            return new b(true, (String) null);
        }

        /* access modifiers changed from: protected */
        public void g(ag.b bVar) {
        }

        /* access modifiers changed from: protected */
        public void h(ag.b bVar) {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f4451a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4452b;

        public b(boolean z2, String str) {
            this.f4451a = z2;
            this.f4452b = str;
        }
    }

    public j(a aVar, a aVar2, String str, String str2) {
        super(aVar2.f4450a);
        this.f4446b = aVar;
        this.f4447c = aVar2;
        this.f4448d = str;
        this.f4449e = str2;
    }

    /* JADX INFO: finally extract failed */
    private void e(ag.b bVar) {
        if (h(bVar)) {
            String str = null;
            Cursor a2 = bVar.a((e) new ag.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                if (a2.moveToFirst()) {
                    str = a2.getString(0);
                }
                a2.close();
                if (!this.f4448d.equals(str) && !this.f4449e.equals(str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
            } catch (Throwable th) {
                a2.close();
                throw th;
            }
        } else {
            b f2 = this.f4447c.f(bVar);
            if (f2.f4451a) {
                this.f4447c.h(bVar);
                f(bVar);
                return;
            }
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + f2.f4452b);
        }
    }

    private void f(ag.b bVar) {
        g(bVar);
        bVar.c(i.a(this.f4448d));
    }

    private void g(ag.b bVar) {
        bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean h(ag.b bVar) {
        Cursor b2 = bVar.b("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z2 = false;
            if (b2.moveToFirst() && b2.getInt(0) != 0) {
                z2 = true;
            }
            return z2;
        } finally {
            b2.close();
        }
    }

    private static boolean i(ag.b bVar) {
        Cursor b2 = bVar.b("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z2 = false;
            if (b2.moveToFirst() && b2.getInt(0) == 0) {
                z2 = true;
            }
            return z2;
        } finally {
            b2.close();
        }
    }

    public void a(ag.b bVar) {
        super.a(bVar);
    }

    public void a(ag.b bVar, int i2, int i3) {
        boolean z2;
        List<ae.a> a2;
        a aVar = this.f4446b;
        if (aVar == null || (a2 = aVar.f4385d.a(i2, i3)) == null) {
            z2 = false;
        } else {
            this.f4447c.g(bVar);
            for (ae.a a3 : a2) {
                a3.a(bVar);
            }
            b f2 = this.f4447c.f(bVar);
            if (f2.f4451a) {
                this.f4447c.h(bVar);
                f(bVar);
                z2 = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + f2.f4452b);
            }
        }
        if (!z2) {
            a aVar2 = this.f4446b;
            if (aVar2 == null || aVar2.a(i2, i3)) {
                throw new IllegalStateException("A migration from " + i2 + " to " + i3 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.f4447c.a(bVar);
            this.f4447c.b(bVar);
        }
    }

    public void b(ag.b bVar) {
        boolean i2 = i(bVar);
        this.f4447c.b(bVar);
        if (!i2) {
            b f2 = this.f4447c.f(bVar);
            if (!f2.f4451a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + f2.f4452b);
            }
        }
        f(bVar);
        this.f4447c.d(bVar);
    }

    public void b(ag.b bVar, int i2, int i3) {
        a(bVar, i2, i3);
    }

    public void c(ag.b bVar) {
        super.c(bVar);
        e(bVar);
        this.f4447c.c(bVar);
        this.f4446b = null;
    }
}
