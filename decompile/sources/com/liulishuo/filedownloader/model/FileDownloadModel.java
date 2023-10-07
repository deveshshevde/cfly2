package com.liulishuo.filedownloader.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.xeagle.android.login.pickImage.data.GLImage;
import iq.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class FileDownloadModel implements Parcelable {
    public static final Parcelable.Creator<FileDownloadModel> CREATOR = new Parcelable.Creator<FileDownloadModel>() {
        /* renamed from: a */
        public FileDownloadModel createFromParcel(Parcel parcel) {
            return new FileDownloadModel(parcel);
        }

        /* renamed from: a */
        public FileDownloadModel[] newArray(int i2) {
            return new FileDownloadModel[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f21406a;

    /* renamed from: b  reason: collision with root package name */
    private String f21407b;

    /* renamed from: c  reason: collision with root package name */
    private String f21408c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21409d;

    /* renamed from: e  reason: collision with root package name */
    private String f21410e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f21411f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicLong f21412g;

    /* renamed from: h  reason: collision with root package name */
    private long f21413h;

    /* renamed from: i  reason: collision with root package name */
    private String f21414i;

    /* renamed from: j  reason: collision with root package name */
    private String f21415j;

    /* renamed from: k  reason: collision with root package name */
    private int f21416k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f21417l;

    public FileDownloadModel() {
        this.f21412g = new AtomicLong();
        this.f21411f = new AtomicInteger();
    }

    protected FileDownloadModel(Parcel parcel) {
        this.f21406a = parcel.readInt();
        this.f21407b = parcel.readString();
        this.f21408c = parcel.readString();
        boolean z2 = true;
        this.f21409d = parcel.readByte() != 0;
        this.f21410e = parcel.readString();
        this.f21411f = new AtomicInteger(parcel.readByte());
        this.f21412g = new AtomicLong(parcel.readLong());
        this.f21413h = parcel.readLong();
        this.f21414i = parcel.readString();
        this.f21415j = parcel.readString();
        this.f21416k = parcel.readInt();
        this.f21417l = parcel.readByte() == 0 ? false : z2;
    }

    public int a() {
        return this.f21406a;
    }

    public void a(byte b2) {
        this.f21411f.set(b2);
    }

    public void a(int i2) {
        this.f21406a = i2;
    }

    public void a(long j2) {
        this.f21412g.set(j2);
    }

    public void a(String str) {
        this.f21407b = str;
    }

    public void a(String str, boolean z2) {
        this.f21408c = str;
        this.f21409d = z2;
    }

    public String b() {
        return this.f21407b;
    }

    public void b(int i2) {
        this.f21416k = i2;
    }

    public void b(long j2) {
        this.f21412g.addAndGet(j2);
    }

    public void b(String str) {
        this.f21415j = str;
    }

    public String c() {
        return this.f21408c;
    }

    public void c(long j2) {
        this.f21417l = j2 > 2147483647L;
        this.f21413h = j2;
    }

    public void c(String str) {
        this.f21414i = str;
    }

    public String d() {
        return f.a(c(), l(), m());
    }

    public void d(String str) {
        this.f21410e = str;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        if (d() == null) {
            return null;
        }
        return f.d(d());
    }

    public byte f() {
        return (byte) this.f21411f.get();
    }

    public long g() {
        return this.f21412g.get();
    }

    public long h() {
        return this.f21413h;
    }

    public boolean i() {
        return this.f21413h == -1;
    }

    public String j() {
        return this.f21415j;
    }

    public String k() {
        return this.f21414i;
    }

    public boolean l() {
        return this.f21409d;
    }

    public String m() {
        return this.f21410e;
    }

    public int n() {
        return this.f21416k;
    }

    public void o() {
        this.f21416k = 1;
    }

    public ContentValues p() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(a()));
        contentValues.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, b());
        contentValues.put(GLImage.KEY_PATH, c());
        contentValues.put("status", Byte.valueOf(f()));
        contentValues.put("sofar", Long.valueOf(g()));
        contentValues.put("total", Long.valueOf(h()));
        contentValues.put("errMsg", k());
        contentValues.put("etag", j());
        contentValues.put("connectionCount", Integer.valueOf(n()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(l()));
        if (l() && m() != null) {
            contentValues.put("filename", m());
        }
        return contentValues;
    }

    public boolean q() {
        return this.f21417l;
    }

    public String toString() {
        return f.a("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f21406a), this.f21407b, this.f21408c, Integer.valueOf(this.f21411f.get()), this.f21412g, Long.valueOf(this.f21413h), this.f21415j, super.toString());
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f21406a);
        parcel.writeString(this.f21407b);
        parcel.writeString(this.f21408c);
        parcel.writeByte(this.f21409d ? (byte) 1 : 0);
        parcel.writeString(this.f21410e);
        parcel.writeByte((byte) this.f21411f.get());
        parcel.writeLong(this.f21412g.get());
        parcel.writeLong(this.f21413h);
        parcel.writeString(this.f21414i);
        parcel.writeString(this.f21415j);
        parcel.writeInt(this.f21416k);
        parcel.writeByte(this.f21417l ? (byte) 1 : 0);
    }
}
