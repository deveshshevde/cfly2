package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.a;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class b extends a<Cursor> {

    /* renamed from: f  reason: collision with root package name */
    final c<Cursor>.a f3697f = new c.a();

    /* renamed from: g  reason: collision with root package name */
    Uri f3698g;

    /* renamed from: h  reason: collision with root package name */
    String[] f3699h;

    /* renamed from: i  reason: collision with root package name */
    String f3700i;

    /* renamed from: j  reason: collision with root package name */
    String[] f3701j;

    /* renamed from: k  reason: collision with root package name */
    String f3702k;

    /* renamed from: l  reason: collision with root package name */
    Cursor f3703l;

    /* renamed from: m  reason: collision with root package name */
    androidx.core.os.b f3704m;

    public b(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f3698g = uri;
        this.f3699h = strArr;
        this.f3700i = str;
        this.f3701j = strArr2;
        this.f3702k = str2;
    }

    /* renamed from: a */
    public void b(Cursor cursor) {
        if (!p()) {
            Cursor cursor2 = this.f3703l;
            this.f3703l = cursor;
            if (n()) {
                super.b(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f3698g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f3699h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f3700i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f3701j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f3702k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f3703l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f3712u);
    }

    /* renamed from: b */
    public void a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public void f() {
        super.f();
        synchronized (this) {
            androidx.core.os.b bVar = this.f3704m;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    /* renamed from: h */
    public Cursor d() {
        Cursor a2;
        synchronized (this) {
            if (!g()) {
                this.f3704m = new androidx.core.os.b();
            } else {
                throw new OperationCanceledException();
            }
        }
        try {
            a2 = a.a(m().getContentResolver(), this.f3698g, this.f3699h, this.f3700i, this.f3701j, this.f3702k, this.f3704m);
            if (a2 != null) {
                a2.getCount();
                a2.registerContentObserver(this.f3697f);
            }
            synchronized (this) {
                this.f3704m = null;
            }
            return a2;
        } catch (RuntimeException e2) {
            a2.close();
            throw e2;
        } catch (Throwable th) {
            synchronized (this) {
                this.f3704m = null;
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        Cursor cursor = this.f3703l;
        if (cursor != null) {
            b(cursor);
        }
        if (x() || this.f3703l == null) {
            s();
        }
    }

    /* access modifiers changed from: protected */
    public void j() {
        r();
    }

    /* access modifiers changed from: protected */
    public void k() {
        super.k();
        j();
        Cursor cursor = this.f3703l;
        if (cursor != null && !cursor.isClosed()) {
            this.f3703l.close();
        }
        this.f3703l = null;
    }
}
