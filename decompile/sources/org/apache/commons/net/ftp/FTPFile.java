package org.apache.commons.net.ftp;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Calendar;

public class FTPFile implements Serializable {
    private static final long serialVersionUID = 9010790363003271996L;

    /* renamed from: a  reason: collision with root package name */
    private int f32827a;

    /* renamed from: b  reason: collision with root package name */
    private int f32828b;

    /* renamed from: c  reason: collision with root package name */
    private long f32829c;

    /* renamed from: d  reason: collision with root package name */
    private String f32830d;

    /* renamed from: e  reason: collision with root package name */
    private String f32831e;

    /* renamed from: f  reason: collision with root package name */
    private String f32832f;

    /* renamed from: g  reason: collision with root package name */
    private String f32833g;

    /* renamed from: h  reason: collision with root package name */
    private String f32834h;

    /* renamed from: i  reason: collision with root package name */
    private Calendar f32835i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean[][] f32836j;

    public FTPFile() {
        this.f32827a = 3;
        this.f32829c = -1;
        this.f32831e = "";
        this.f32832f = "";
        this.f32836j = (boolean[][]) Array.newInstance(boolean.class, new int[]{3, 3});
    }

    FTPFile(String str) {
        this.f32827a = 3;
        this.f32829c = -1;
        this.f32831e = "";
        this.f32832f = "";
        this.f32836j = null;
        this.f32830d = str;
    }

    public String a() {
        return this.f32830d;
    }

    public void a(int i2) {
        this.f32828b = i2;
    }

    public void a(int i2, int i3, boolean z2) {
        this.f32836j[i2][i3] = z2;
    }

    public void a(long j2) {
        this.f32829c = j2;
    }

    public void a(String str) {
        this.f32832f = str;
    }

    public void a(Calendar calendar) {
        this.f32835i = calendar;
    }

    public long b() {
        return this.f32829c;
    }

    public void b(int i2) {
        this.f32827a = i2;
    }

    public void b(String str) {
        this.f32834h = str;
    }

    public void c(String str) {
        this.f32833g = str;
    }

    public boolean c() {
        return this.f32827a == 1;
    }

    public void d(String str) {
        this.f32830d = str;
    }

    public void e(String str) {
        this.f32831e = str;
    }

    public String toString() {
        return a();
    }
}
