package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import com.liulishuo.filedownloader.message.MessageSnapshot;

public abstract class SmallMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements a {
        CompletedFlowDirectlySnapshot(int i2, boolean z2, int i3) {
            super(i2, z2, i3);
        }
    }

    public static class CompletedSnapshot extends SmallMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f21383b;

        /* renamed from: c  reason: collision with root package name */
        private final int f21384c;

        CompletedSnapshot(int i2, boolean z2, int i3) {
            super(i2);
            this.f21383b = z2;
            this.f21384c = i3;
        }

        CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.f21383b = parcel.readByte() != 0;
            this.f21384c = parcel.readInt();
        }

        public byte b() {
            return -3;
        }

        public int c() {
            return this.f21384c;
        }

        public int describeContents() {
            return 0;
        }

        public boolean e() {
            return this.f21383b;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            SmallMessageSnapshot.super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f21383b ? (byte) 1 : 0);
            parcel.writeInt(this.f21384c);
        }
    }

    public static class ConnectedMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f21385b;

        /* renamed from: c  reason: collision with root package name */
        private final int f21386c;

        /* renamed from: d  reason: collision with root package name */
        private final String f21387d;

        /* renamed from: e  reason: collision with root package name */
        private final String f21388e;

        ConnectedMessageSnapshot(int i2, boolean z2, int i3, String str, String str2) {
            super(i2);
            this.f21385b = z2;
            this.f21386c = i3;
            this.f21387d = str;
            this.f21388e = str2;
        }

        ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f21385b = parcel.readByte() != 0;
            this.f21386c = parcel.readInt();
            this.f21387d = parcel.readString();
            this.f21388e = parcel.readString();
        }

        public byte b() {
            return 2;
        }

        public int c() {
            return this.f21386c;
        }

        public int describeContents() {
            return 0;
        }

        public String f() {
            return this.f21388e;
        }

        public boolean g() {
            return this.f21385b;
        }

        public String h() {
            return this.f21387d;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            SmallMessageSnapshot.super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f21385b ? (byte) 1 : 0);
            parcel.writeInt(this.f21386c);
            parcel.writeString(this.f21387d);
            parcel.writeString(this.f21388e);
        }
    }

    public static class ErrorMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final int f21389b;

        /* renamed from: c  reason: collision with root package name */
        private final Throwable f21390c;

        ErrorMessageSnapshot(int i2, int i3, Throwable th) {
            super(i2);
            this.f21389b = i3;
            this.f21390c = th;
        }

        ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f21389b = parcel.readInt();
            this.f21390c = (Throwable) parcel.readSerializable();
        }

        public int a() {
            return this.f21389b;
        }

        public byte b() {
            return -1;
        }

        public int describeContents() {
            return 0;
        }

        public Throwable j() {
            return this.f21390c;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            SmallMessageSnapshot.super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f21389b);
            parcel.writeSerializable(this.f21390c);
        }
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        PausedSnapshot(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        public byte b() {
            return -2;
        }
    }

    public static class PendingMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final int f21391b;

        /* renamed from: c  reason: collision with root package name */
        private final int f21392c;

        PendingMessageSnapshot(int i2, int i3, int i4) {
            super(i2);
            this.f21391b = i3;
            this.f21392c = i4;
        }

        PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f21391b = parcel.readInt();
            this.f21392c = parcel.readInt();
        }

        PendingMessageSnapshot(PendingMessageSnapshot pendingMessageSnapshot) {
            this(pendingMessageSnapshot.m(), pendingMessageSnapshot.a(), pendingMessageSnapshot.c());
        }

        public int a() {
            return this.f21391b;
        }

        public byte b() {
            return 1;
        }

        public int c() {
            return this.f21392c;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            SmallMessageSnapshot.super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f21391b);
            parcel.writeInt(this.f21392c);
        }
    }

    public static class ProgressMessageSnapshot extends SmallMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final int f21393b;

        ProgressMessageSnapshot(int i2, int i3) {
            super(i2);
            this.f21393b = i3;
        }

        ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f21393b = parcel.readInt();
        }

        public int a() {
            return this.f21393b;
        }

        public byte b() {
            return 3;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            SmallMessageSnapshot.super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f21393b);
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final int f21394b;

        RetryMessageSnapshot(int i2, int i3, Throwable th, int i4) {
            super(i2, i3, th);
            this.f21394b = i4;
        }

        RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f21394b = parcel.readInt();
        }

        public byte b() {
            return 5;
        }

        public int describeContents() {
            return 0;
        }

        public int k() {
            return this.f21394b;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f21394b);
        }
    }

    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements a {
        WarnFlowDirectlySnapshot(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }
    }

    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements MessageSnapshot.a {
        WarnMessageSnapshot(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        WarnMessageSnapshot(Parcel parcel) {
            super(parcel);
        }

        public byte b() {
            return -4;
        }

        public MessageSnapshot l() {
            return new PendingMessageSnapshot((PendingMessageSnapshot) this);
        }
    }

    SmallMessageSnapshot(int i2) {
        super(i2);
        this.f21381a = false;
    }

    SmallMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    public long d() {
        return (long) c();
    }

    public long i() {
        return (long) a();
    }
}
