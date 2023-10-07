package ah;

import ag.c;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.File;

class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f108a;

    /* renamed from: b  reason: collision with root package name */
    private final String f109b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a f110c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f111d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f112e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private a f113f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f114g;

    static class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        final a[] f115a;

        /* renamed from: b  reason: collision with root package name */
        final c.a f116b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f117c;

        a(Context context, String str, final a[] aVarArr, final c.a aVar) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, aVar.f92a, new DatabaseErrorHandler() {
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    c.a.this.d(a.a(aVarArr, sQLiteDatabase));
                }
            });
            this.f116b = aVar;
            this.f115a = aVarArr;
        }

        static a a(a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        /* access modifiers changed from: package-private */
        public synchronized ag.b a() {
            this.f117c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f117c) {
                close();
                return a();
            }
            return a(writableDatabase);
        }

        /* access modifiers changed from: package-private */
        public a a(SQLiteDatabase sQLiteDatabase) {
            return a(this.f115a, sQLiteDatabase);
        }

        public synchronized void close() {
            super.close();
            this.f115a[0] = null;
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f116b.a((ag.b) a(sQLiteDatabase));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f116b.b(a(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f117c = true;
            this.f116b.b(a(sQLiteDatabase), i2, i3);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f117c) {
                this.f116b.c(a(sQLiteDatabase));
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f117c = true;
            this.f116b.a(a(sQLiteDatabase), i2, i3);
        }
    }

    b(Context context, String str, c.a aVar, boolean z2) {
        this.f108a = context;
        this.f109b = str;
        this.f110c = aVar;
        this.f111d = z2;
    }

    private a c() {
        a aVar;
        synchronized (this.f112e) {
            if (this.f113f == null) {
                a[] aVarArr = new a[1];
                if (Build.VERSION.SDK_INT < 23 || this.f109b == null || !this.f111d) {
                    this.f113f = new a(this.f108a, this.f109b, aVarArr, this.f110c);
                } else {
                    this.f113f = new a(this.f108a, new File(this.f108a.getNoBackupFilesDir(), this.f109b).getAbsolutePath(), aVarArr, this.f110c);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f113f.setWriteAheadLoggingEnabled(this.f114g);
                }
            }
            aVar = this.f113f;
        }
        return aVar;
    }

    public String a() {
        return this.f109b;
    }

    public void a(boolean z2) {
        synchronized (this.f112e) {
            a aVar = this.f113f;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z2);
            }
            this.f114g = z2;
        }
    }

    public ag.b b() {
        return c().a();
    }

    public void close() {
        c().close();
    }
}
