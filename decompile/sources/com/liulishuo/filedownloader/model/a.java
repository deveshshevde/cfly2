package com.liulishuo.filedownloader.model;

import android.content.ContentValues;
import iq.f;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f21421a;

    /* renamed from: b  reason: collision with root package name */
    private int f21422b;

    /* renamed from: c  reason: collision with root package name */
    private long f21423c;

    /* renamed from: d  reason: collision with root package name */
    private long f21424d;

    /* renamed from: e  reason: collision with root package name */
    private long f21425e;

    public static long a(List<a> list) {
        long j2 = 0;
        for (a next : list) {
            j2 += next.d() - next.c();
        }
        return j2;
    }

    public int a() {
        return this.f21421a;
    }

    public void a(int i2) {
        this.f21421a = i2;
    }

    public void a(long j2) {
        this.f21423c = j2;
    }

    public int b() {
        return this.f21422b;
    }

    public void b(int i2) {
        this.f21422b = i2;
    }

    public void b(long j2) {
        this.f21424d = j2;
    }

    public long c() {
        return this.f21423c;
    }

    public void c(long j2) {
        this.f21425e = j2;
    }

    public long d() {
        return this.f21424d;
    }

    public long e() {
        return this.f21425e;
    }

    public ContentValues f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f21421a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f21422b));
        contentValues.put("startOffset", Long.valueOf(this.f21423c));
        contentValues.put("currentOffset", Long.valueOf(this.f21424d));
        contentValues.put("endOffset", Long.valueOf(this.f21425e));
        return contentValues;
    }

    public String toString() {
        return f.a("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f21421a), Integer.valueOf(this.f21422b), Long.valueOf(this.f21423c), Long.valueOf(this.f21425e), Long.valueOf(this.f21424d));
    }
}
