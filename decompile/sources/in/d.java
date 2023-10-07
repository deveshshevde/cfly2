package in;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.xeagle.android.login.pickImage.data.GLImage;
import in.a;
import iq.c;
import iq.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class d implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f13618a = new e(c.a()).getWritableDatabase();

    public class a implements a.C0100a {

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<FileDownloadModel> f13620b;

        /* renamed from: c  reason: collision with root package name */
        private b f13621c;

        /* renamed from: d  reason: collision with root package name */
        private final SparseArray<FileDownloadModel> f13622d;

        /* renamed from: e  reason: collision with root package name */
        private final SparseArray<List<com.liulishuo.filedownloader.model.a>> f13623e;

        a(d dVar) {
            this((SparseArray<FileDownloadModel>) null, (SparseArray<List<com.liulishuo.filedownloader.model.a>>) null);
        }

        a(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<com.liulishuo.filedownloader.model.a>> sparseArray2) {
            this.f13620b = new SparseArray<>();
            this.f13622d = sparseArray;
            this.f13623e = sparseArray2;
        }

        public void a() {
            b bVar = this.f13621c;
            if (bVar != null) {
                bVar.b();
            }
            int size = this.f13620b.size();
            if (size >= 0) {
                d.this.f13618a.beginTransaction();
                int i2 = 0;
                while (i2 < size) {
                    try {
                        int keyAt = this.f13620b.keyAt(i2);
                        FileDownloadModel fileDownloadModel = this.f13620b.get(keyAt);
                        d.this.f13618a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                        d.this.f13618a.insert("filedownloader", (String) null, fileDownloadModel.p());
                        if (fileDownloadModel.n() > 1) {
                            List<com.liulishuo.filedownloader.model.a> c2 = d.this.c(keyAt);
                            if (c2.size() > 0) {
                                d.this.f13618a.delete("filedownloaderConnection", "id = ?", new String[]{String.valueOf(keyAt)});
                                for (com.liulishuo.filedownloader.model.a next : c2) {
                                    next.a(fileDownloadModel.a());
                                    d.this.f13618a.insert("filedownloaderConnection", (String) null, next.f());
                                }
                            }
                        }
                        i2++;
                    } catch (Throwable th) {
                        d.this.f13618a.endTransaction();
                        throw th;
                    }
                }
                SparseArray<FileDownloadModel> sparseArray = this.f13622d;
                if (!(sparseArray == null || this.f13623e == null)) {
                    int size2 = sparseArray.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        int a2 = this.f13622d.valueAt(i3).a();
                        List<com.liulishuo.filedownloader.model.a> c3 = d.this.c(a2);
                        if (c3 != null && c3.size() > 0) {
                            this.f13623e.put(a2, c3);
                        }
                    }
                }
                d.this.f13618a.setTransactionSuccessful();
                d.this.f13618a.endTransaction();
            }
        }

        public void a(int i2, FileDownloadModel fileDownloadModel) {
            this.f13620b.put(i2, fileDownloadModel);
        }

        public void a(FileDownloadModel fileDownloadModel) {
        }

        public void b(FileDownloadModel fileDownloadModel) {
            SparseArray<FileDownloadModel> sparseArray = this.f13622d;
            if (sparseArray != null) {
                sparseArray.put(fileDownloadModel.a(), fileDownloadModel);
            }
        }

        public Iterator<FileDownloadModel> iterator() {
            b bVar = new b();
            this.f13621c = bVar;
            return bVar;
        }
    }

    class b implements Iterator<FileDownloadModel> {

        /* renamed from: b  reason: collision with root package name */
        private final Cursor f13625b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Integer> f13626c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private int f13627d;

        b() {
            this.f13625b = d.this.f13618a.rawQuery("SELECT * FROM filedownloader", (String[]) null);
        }

        /* renamed from: a */
        public FileDownloadModel next() {
            FileDownloadModel a2 = d.b(this.f13625b);
            this.f13627d = a2.a();
            return a2;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f13625b.close();
            if (!this.f13626c.isEmpty()) {
                String join = TextUtils.join(", ", this.f13626c);
                if (iq.d.f29057a) {
                    iq.d.c(this, "delete %s", join);
                }
                d.this.f13618a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "filedownloader", "_id", join));
                d.this.f13618a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "filedownloaderConnection", "id", join));
            }
        }

        public boolean hasNext() {
            return this.f13625b.moveToNext();
        }

        public void remove() {
            this.f13626c.add(Integer.valueOf(this.f13627d));
        }
    }

    private void a(int i2, ContentValues contentValues) {
        this.f13618a.update("filedownloader", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
    }

    /* access modifiers changed from: private */
    public static FileDownloadModel b(Cursor cursor) {
        FileDownloadModel fileDownloadModel = new FileDownloadModel();
        fileDownloadModel.a(cursor.getInt(cursor.getColumnIndex("_id")));
        fileDownloadModel.a(cursor.getString(cursor.getColumnIndex(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL)));
        String string = cursor.getString(cursor.getColumnIndex(GLImage.KEY_PATH));
        boolean z2 = true;
        if (cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) != 1) {
            z2 = false;
        }
        fileDownloadModel.a(string, z2);
        fileDownloadModel.a((byte) cursor.getShort(cursor.getColumnIndex("status")));
        fileDownloadModel.a(cursor.getLong(cursor.getColumnIndex("sofar")));
        fileDownloadModel.c(cursor.getLong(cursor.getColumnIndex("total")));
        fileDownloadModel.c(cursor.getString(cursor.getColumnIndex("errMsg")));
        fileDownloadModel.b(cursor.getString(cursor.getColumnIndex("etag")));
        fileDownloadModel.d(cursor.getString(cursor.getColumnIndex("filename")));
        fileDownloadModel.b(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return fileDownloadModel;
    }

    public a.C0100a a(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<com.liulishuo.filedownloader.model.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    public void a() {
        this.f13618a.delete("filedownloader", (String) null, (String[]) null);
        this.f13618a.delete("filedownloaderConnection", (String) null, (String[]) null);
    }

    public void a(int i2) {
    }

    public void a(int i2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i3));
        this.f13618a.update("filedownloader", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
    }

    public void a(int i2, int i3, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j2));
        this.f13618a.update("filedownloaderConnection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
    }

    public void a(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (byte) 3);
        contentValues.put("sofar", Long.valueOf(j2));
        a(i2, contentValues);
    }

    public void a(int i2, long j2, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (byte) 2);
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("filename", str2);
        a(i2, contentValues);
    }

    public void a(int i2, String str, long j2, long j3, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j2));
        contentValues.put("total", Long.valueOf(j3));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i3));
        a(i2, contentValues);
    }

    public void a(int i2, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (byte) 5);
        a(i2, contentValues);
    }

    public void a(int i2, Throwable th, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (byte) -1);
        contentValues.put("sofar", Long.valueOf(j2));
        a(i2, contentValues);
    }

    public void a(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            iq.d.d(this, "update but model == null!", new Object[0]);
        } else if (b(fileDownloadModel.a()) != null) {
            ContentValues p2 = fileDownloadModel.p();
            this.f13618a.update("filedownloader", p2, "_id = ? ", new String[]{String.valueOf(fileDownloadModel.a())});
        } else {
            b(fileDownloadModel);
        }
    }

    public void a(com.liulishuo.filedownloader.model.a aVar) {
        this.f13618a.insert("filedownloaderConnection", (String) null, aVar.f());
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.liulishuo.filedownloader.model.FileDownloadModel b(int r9) {
        /*
            r8 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r8.f13618a     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "SELECT * FROM %s WHERE %s = ?"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "filedownloader"
            r5 = 0
            r3[r5] = r4     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "_id"
            r6 = 1
            r3[r6] = r4     // Catch:{ all -> 0x003a }
            java.lang.String r2 = iq.f.a((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x003a }
            java.lang.String[] r3 = new java.lang.String[r6]     // Catch:{ all -> 0x003a }
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch:{ all -> 0x003a }
            r3[r5] = r9     // Catch:{ all -> 0x003a }
            android.database.Cursor r9 = r1.rawQuery(r2, r3)     // Catch:{ all -> 0x003a }
            boolean r1 = r9.moveToNext()     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x0032
            com.liulishuo.filedownloader.model.FileDownloadModel r0 = b((android.database.Cursor) r9)     // Catch:{ all -> 0x0038 }
            if (r9 == 0) goto L_0x0031
            r9.close()
        L_0x0031:
            return r0
        L_0x0032:
            if (r9 == 0) goto L_0x0037
            r9.close()
        L_0x0037:
            return r0
        L_0x0038:
            r0 = move-exception
            goto L_0x003e
        L_0x003a:
            r9 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
        L_0x003e:
            if (r9 == 0) goto L_0x0043
            r9.close()
        L_0x0043:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.d.b(int):com.liulishuo.filedownloader.model.FileDownloadModel");
    }

    public a.C0100a b() {
        return new a(this);
    }

    public void b(int i2, long j2) {
        e(i2);
    }

    public void b(FileDownloadModel fileDownloadModel) {
        this.f13618a.insert("filedownloader", (String) null, fileDownloadModel.p());
    }

    public List<com.liulishuo.filedownloader.model.a> c(int i2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.f13618a.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "filedownloaderConnection", "id"), new String[]{Integer.toString(i2)});
            while (cursor.moveToNext()) {
                com.liulishuo.filedownloader.model.a aVar = new com.liulishuo.filedownloader.model.a();
                aVar.a(i2);
                aVar.b(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                aVar.a(cursor.getLong(cursor.getColumnIndex("startOffset")));
                aVar.b(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                aVar.c(cursor.getLong(cursor.getColumnIndex("endOffset")));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void c(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (byte) -2);
        contentValues.put("sofar", Long.valueOf(j2));
        a(i2, contentValues);
    }

    public void d(int i2) {
        SQLiteDatabase sQLiteDatabase = this.f13618a;
        sQLiteDatabase.execSQL("DELETE FROM filedownloaderConnection WHERE id = " + i2);
    }

    public boolean e(int i2) {
        return this.f13618a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(i2)}) != 0;
    }

    public void f(int i2) {
    }
}
