package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class gd {

    /* renamed from: d  reason: collision with root package name */
    private static Map<Class<? extends gc>, gc> f8913d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private gg f8914a;

    /* renamed from: b  reason: collision with root package name */
    private SQLiteDatabase f8915b;

    /* renamed from: c  reason: collision with root package name */
    private gc f8916c;

    public gd(Context context, gc gcVar) {
        try {
            this.f8914a = new gg(context.getApplicationContext(), gcVar.b(), gcVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f8916c = gcVar;
    }

    private static ContentValues a(Object obj, ge geVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : a(obj.getClass(), geVar.b())) {
            field.setAccessible(true);
            a(obj, field, contentValues);
        }
        return contentValues;
    }

    private SQLiteDatabase a() {
        try {
            if (this.f8915b == null) {
                this.f8915b = this.f8914a.getReadableDatabase();
            }
        } catch (Throwable th) {
            fw.a(th, "dbs", "grd");
        }
        return this.f8915b;
    }

    private static <T> ge a(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(ge.class);
        if (!(annotation != null)) {
            return null;
        }
        return (ge) annotation;
    }

    private static <T> T a(Cursor cursor, Class<T> cls, ge geVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj;
        Field[] a2 = a((Class<?>) cls, geVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(gf.class);
            if (annotation != null) {
                gf gfVar = (gf) annotation;
                int b2 = gfVar.b();
                int columnIndex = cursor.getColumnIndex(gfVar.a());
                switch (b2) {
                    case 1:
                        obj = Short.valueOf(cursor.getShort(columnIndex));
                        break;
                    case 2:
                        obj = Integer.valueOf(cursor.getInt(columnIndex));
                        break;
                    case 3:
                        obj = Float.valueOf(cursor.getFloat(columnIndex));
                        break;
                    case 4:
                        obj = Double.valueOf(cursor.getDouble(columnIndex));
                        break;
                    case 5:
                        obj = Long.valueOf(cursor.getLong(columnIndex));
                        break;
                    case 6:
                        obj = cursor.getString(columnIndex);
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        continue;
                }
                field.set(newInstance, obj);
            }
        }
        return newInstance;
    }

    private static <T> String a(ge geVar) {
        if (geVar == null) {
            return null;
        }
        return geVar.a();
    }

    private static <T> void a(SQLiteDatabase sQLiteDatabase, T t2) {
        ge a2 = a(t2.getClass());
        String a3 = a(a2);
        if (!TextUtils.isEmpty(a3) && t2 != null && sQLiteDatabase != null) {
            sQLiteDatabase.insert(a3, (String) null, a((Object) t2, a2));
        }
    }

    private <T> void a(T t2) {
        b(t2);
    }

    private static void a(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(gf.class);
        if (annotation != null) {
            gf gfVar = (gf) annotation;
            switch (gfVar.b()) {
                case 1:
                    contentValues.put(gfVar.a(), Short.valueOf(field.getShort(obj)));
                    return;
                case 2:
                    contentValues.put(gfVar.a(), Integer.valueOf(field.getInt(obj)));
                    return;
                case 3:
                    contentValues.put(gfVar.a(), Float.valueOf(field.getFloat(obj)));
                    return;
                case 4:
                    contentValues.put(gfVar.a(), Double.valueOf(field.getDouble(obj)));
                    return;
                case 5:
                    contentValues.put(gfVar.a(), Long.valueOf(field.getLong(obj)));
                    return;
                case 6:
                    contentValues.put(gfVar.a(), (String) field.get(obj));
                    return;
                case 7:
                    try {
                        contentValues.put(gfVar.a(), (byte[]) field.get(obj));
                        return;
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private <T> void a(String str, Object obj) {
        synchronized (this.f8916c) {
            if (obj != null) {
                ge a2 = a(obj.getClass());
                String a3 = a(a2);
                if (!TextUtils.isEmpty(a3)) {
                    ContentValues a4 = a(obj, a2);
                    SQLiteDatabase b2 = b();
                    this.f8915b = b2;
                    if (b2 != null) {
                        try {
                            b2.update(a3, a4, str, (String[]) null);
                            SQLiteDatabase sQLiteDatabase = this.f8915b;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                                this.f8915b = null;
                            }
                        } catch (Throwable th) {
                            SQLiteDatabase sQLiteDatabase2 = this.f8915b;
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                                this.f8915b = null;
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }

    private static Field[] a(Class<?> cls, boolean z2) {
        if (cls == null) {
            return null;
        }
        return z2 ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private SQLiteDatabase b() {
        try {
            SQLiteDatabase sQLiteDatabase = this.f8915b;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase2 = this.f8915b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.f8915b = this.f8914a.getWritableDatabase();
            }
        } catch (Throwable th) {
            fw.a(th, "dbs", "gwd");
        }
        return this.f8915b;
    }

    private <T> void b(T t2) {
        synchronized (this.f8916c) {
            SQLiteDatabase b2 = b();
            this.f8915b = b2;
            if (b2 != null) {
                try {
                    a(b2, t2);
                    SQLiteDatabase sQLiteDatabase = this.f8915b;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        this.f8915b = null;
                    }
                } catch (Throwable th) {
                    SQLiteDatabase sQLiteDatabase2 = this.f8915b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                        this.f8915b = null;
                    }
                    throw th;
                }
            }
        }
    }

    private <T> void b(String str, Object obj) {
        a(str, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        com.amap.api.mapcore.util.fw.a(r13, "dbs", "sld");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00ba, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00bb, code lost:
        if (r13 != null) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00c1, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        com.amap.api.mapcore.util.fw.a(r13, "dbs", "sld");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00d3, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        com.amap.api.mapcore.util.fw.a(r13, "dbs", "sld");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x00dd, code lost:
        return r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:18:0x0040, B:57:0x0097, B:77:0x00bd, B:83:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x009c A[SYNTHETIC, Splitter:B:60:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ac A[Catch:{ all -> 0x00b2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> java.util.List<T> c(java.lang.String r13, java.lang.Class<T> r14) {
        /*
            r12 = this;
            com.amap.api.mapcore.util.gc r0 = r12.f8916c
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00de }
            r1.<init>()     // Catch:{ all -> 0x00de }
            com.amap.api.mapcore.util.ge r2 = a(r14)     // Catch:{ all -> 0x00de }
            java.lang.String r4 = a((com.amap.api.mapcore.util.ge) r2)     // Catch:{ all -> 0x00de }
            android.database.sqlite.SQLiteDatabase r3 = r12.f8915b     // Catch:{ all -> 0x00de }
            if (r3 != 0) goto L_0x001a
            android.database.sqlite.SQLiteDatabase r3 = r12.a()     // Catch:{ all -> 0x00de }
            r12.f8915b = r3     // Catch:{ all -> 0x00de }
        L_0x001a:
            android.database.sqlite.SQLiteDatabase r3 = r12.f8915b     // Catch:{ all -> 0x00de }
            if (r3 == 0) goto L_0x00dc
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00de }
            if (r3 != 0) goto L_0x00dc
            if (r13 != 0) goto L_0x0028
            goto L_0x00dc
        L_0x0028:
            r11 = 0
            android.database.sqlite.SQLiteDatabase r3 = r12.f8915b     // Catch:{ all -> 0x0091 }
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r6 = r13
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0091 }
            if (r13 != 0) goto L_0x0060
            android.database.sqlite.SQLiteDatabase r14 = r12.f8915b     // Catch:{ all -> 0x008f }
            r14.close()     // Catch:{ all -> 0x008f }
            r12.f8915b = r11     // Catch:{ all -> 0x008f }
            if (r13 == 0) goto L_0x004c
            r13.close()     // Catch:{ all -> 0x0044 }
            goto L_0x004c
        L_0x0044:
            r13 = move-exception
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00de }
        L_0x004c:
            android.database.sqlite.SQLiteDatabase r13 = r12.f8915b     // Catch:{ all -> 0x0056 }
            if (r13 == 0) goto L_0x005e
            r13.close()     // Catch:{ all -> 0x0056 }
            r12.f8915b = r11     // Catch:{ all -> 0x0056 }
            goto L_0x005e
        L_0x0056:
            r13 = move-exception
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00de }
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x00de }
            return r1
        L_0x0060:
            boolean r3 = r13.moveToNext()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x006e
            java.lang.Object r3 = a((android.database.Cursor) r13, r14, (com.amap.api.mapcore.util.ge) r2)     // Catch:{ all -> 0x008f }
            r1.add(r3)     // Catch:{ all -> 0x008f }
            goto L_0x0060
        L_0x006e:
            if (r13 == 0) goto L_0x007c
            r13.close()     // Catch:{ all -> 0x0074 }
            goto L_0x007c
        L_0x0074:
            r13 = move-exception
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00de }
        L_0x007c:
            android.database.sqlite.SQLiteDatabase r13 = r12.f8915b     // Catch:{ all -> 0x0086 }
            if (r13 == 0) goto L_0x00b8
            r13.close()     // Catch:{ all -> 0x0086 }
            r12.f8915b = r11     // Catch:{ all -> 0x0086 }
            goto L_0x00b8
        L_0x0086:
            r13 = move-exception
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
        L_0x008b:
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00de }
            goto L_0x00b8
        L_0x008f:
            r14 = move-exception
            goto L_0x0093
        L_0x0091:
            r14 = move-exception
            r13 = r11
        L_0x0093:
            java.lang.String r2 = "dbs"
            java.lang.String r3 = "sld"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r14, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00ba }
            if (r13 == 0) goto L_0x00a8
            r13.close()     // Catch:{ all -> 0x00a0 }
            goto L_0x00a8
        L_0x00a0:
            r13 = move-exception
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00de }
        L_0x00a8:
            android.database.sqlite.SQLiteDatabase r13 = r12.f8915b     // Catch:{ all -> 0x00b2 }
            if (r13 == 0) goto L_0x00b8
            r13.close()     // Catch:{ all -> 0x00b2 }
            r12.f8915b = r11     // Catch:{ all -> 0x00b2 }
            goto L_0x00b8
        L_0x00b2:
            r13 = move-exception
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
            goto L_0x008b
        L_0x00b8:
            monitor-exit(r0)     // Catch:{ all -> 0x00de }
            return r1
        L_0x00ba:
            r14 = move-exception
            if (r13 == 0) goto L_0x00c9
            r13.close()     // Catch:{ all -> 0x00c1 }
            goto L_0x00c9
        L_0x00c1:
            r13 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r2 = "sld"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r13, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00de }
        L_0x00c9:
            android.database.sqlite.SQLiteDatabase r13 = r12.f8915b     // Catch:{ all -> 0x00d3 }
            if (r13 == 0) goto L_0x00db
            r13.close()     // Catch:{ all -> 0x00d3 }
            r12.f8915b = r11     // Catch:{ all -> 0x00d3 }
            goto L_0x00db
        L_0x00d3:
            r13 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r2 = "sld"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r13, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00de }
        L_0x00db:
            throw r14     // Catch:{ all -> 0x00de }
        L_0x00dc:
            monitor-exit(r0)     // Catch:{ all -> 0x00de }
            return r1
        L_0x00de:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00de }
            goto L_0x00e2
        L_0x00e1:
            throw r13
        L_0x00e2:
            goto L_0x00e1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gd.c(java.lang.String, java.lang.Class):java.util.List");
    }

    public final void a(Object obj, String str) {
        synchronized (this.f8916c) {
            List<?> b2 = b(str, obj.getClass());
            if (b2 != null) {
                if (b2.size() != 0) {
                    b(str, obj);
                }
            }
            a(obj);
        }
    }

    public final <T> void a(String str, Class<T> cls) {
        synchronized (this.f8916c) {
            String a2 = a(a(cls));
            if (!TextUtils.isEmpty(a2)) {
                SQLiteDatabase b2 = b();
                this.f8915b = b2;
                if (b2 != null) {
                    try {
                        b2.delete(a2, str, (String[]) null);
                        SQLiteDatabase sQLiteDatabase = this.f8915b;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                            this.f8915b = null;
                        }
                    } catch (Throwable th) {
                        SQLiteDatabase sQLiteDatabase2 = this.f8915b;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                            this.f8915b = null;
                        }
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        com.amap.api.mapcore.util.fw.a(r6, "dbs", "ild");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0096, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        com.amap.api.mapcore.util.fw.a(r1, "dbs", "ild");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00a6, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        com.amap.api.mapcore.util.fw.a(r1, "dbs", "ild");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:18:0x0032, B:52:0x0088, B:60:0x009e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> void a(java.util.List<T> r6) {
        /*
            r5 = this;
            com.amap.api.mapcore.util.gc r0 = r5.f8916c
            monitor-enter(r0)
            int r1 = r6.size()     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            return
        L_0x000b:
            android.database.sqlite.SQLiteDatabase r1 = r5.b()     // Catch:{ all -> 0x00af }
            r5.f8915b = r1     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x0015
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            return
        L_0x0015:
            r2 = 0
            r1.beginTransaction()     // Catch:{ all -> 0x0059 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0059 }
        L_0x001d:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x002d
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x0059 }
            android.database.sqlite.SQLiteDatabase r3 = r5.f8915b     // Catch:{ all -> 0x0059 }
            a((android.database.sqlite.SQLiteDatabase) r3, r1)     // Catch:{ all -> 0x0059 }
            goto L_0x001d
        L_0x002d:
            android.database.sqlite.SQLiteDatabase r6 = r5.f8915b     // Catch:{ all -> 0x0059 }
            r6.setTransactionSuccessful()     // Catch:{ all -> 0x0059 }
            android.database.sqlite.SQLiteDatabase r6 = r5.f8915b     // Catch:{ all -> 0x0040 }
            boolean r6 = r6.inTransaction()     // Catch:{ all -> 0x0040 }
            if (r6 == 0) goto L_0x0048
            android.database.sqlite.SQLiteDatabase r6 = r5.f8915b     // Catch:{ all -> 0x0040 }
            r6.endTransaction()     // Catch:{ all -> 0x0040 }
            goto L_0x0048
        L_0x0040:
            r6 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r6, (java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x00af }
        L_0x0048:
            android.database.sqlite.SQLiteDatabase r6 = r5.f8915b     // Catch:{ all -> 0x0050 }
            r6.close()     // Catch:{ all -> 0x0050 }
            r5.f8915b = r2     // Catch:{ all -> 0x0050 }
            goto L_0x0085
        L_0x0050:
            r6 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r2 = "ild"
        L_0x0055:
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r6, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00af }
            goto L_0x0085
        L_0x0059:
            r6 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r6, (java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x0087 }
            android.database.sqlite.SQLiteDatabase r6 = r5.f8915b     // Catch:{ all -> 0x006f }
            boolean r6 = r6.inTransaction()     // Catch:{ all -> 0x006f }
            if (r6 == 0) goto L_0x0077
            android.database.sqlite.SQLiteDatabase r6 = r5.f8915b     // Catch:{ all -> 0x006f }
            r6.endTransaction()     // Catch:{ all -> 0x006f }
            goto L_0x0077
        L_0x006f:
            r6 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r6, (java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x00af }
        L_0x0077:
            android.database.sqlite.SQLiteDatabase r6 = r5.f8915b     // Catch:{ all -> 0x007f }
            r6.close()     // Catch:{ all -> 0x007f }
            r5.f8915b = r2     // Catch:{ all -> 0x007f }
            goto L_0x0085
        L_0x007f:
            r6 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r2 = "ild"
            goto L_0x0055
        L_0x0085:
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            return
        L_0x0087:
            r6 = move-exception
            android.database.sqlite.SQLiteDatabase r1 = r5.f8915b     // Catch:{ all -> 0x0096 }
            boolean r1 = r1.inTransaction()     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x009e
            android.database.sqlite.SQLiteDatabase r1 = r5.f8915b     // Catch:{ all -> 0x0096 }
            r1.endTransaction()     // Catch:{ all -> 0x0096 }
            goto L_0x009e
        L_0x0096:
            r1 = move-exception
            java.lang.String r3 = "dbs"
            java.lang.String r4 = "ild"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r1, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x00af }
        L_0x009e:
            android.database.sqlite.SQLiteDatabase r1 = r5.f8915b     // Catch:{ all -> 0x00a6 }
            r1.close()     // Catch:{ all -> 0x00a6 }
            r5.f8915b = r2     // Catch:{ all -> 0x00a6 }
            goto L_0x00ae
        L_0x00a6:
            r1 = move-exception
            java.lang.String r2 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00af }
        L_0x00ae:
            throw r6     // Catch:{ all -> 0x00af }
        L_0x00af:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            goto L_0x00b3
        L_0x00b2:
            throw r6
        L_0x00b3:
            goto L_0x00b2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gd.a(java.util.List):void");
    }

    public final <T> List<T> b(String str, Class<T> cls) {
        return c(str, cls);
    }
}
