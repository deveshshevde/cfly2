package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.liulishuo.filedownloader.message.MessageSnapshot;

public abstract class LargeMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements a {
        CompletedFlowDirectlySnapshot(int i2, boolean z2, long j2) {
            super(i2, z2, j2);
        }
    }

    public static class CompletedSnapshot extends LargeMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f21369b;

        /* renamed from: c  reason: collision with root package name */
        private final long f21370c;

        CompletedSnapshot(int i2, boolean z2, long j2) {
            super(i2);
            this.f21369b = z2;
            this.f21370c = j2;
        }

        CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.f21369b = parcel.readByte() != 0;
            this.f21370c = parcel.readLong();
        }

        public byte b() {
            return -3;
        }

        public long d() {
            return this.f21370c;
        }

        public int describeContents() {
            return 0;
        }

        public boolean e() {
            return this.f21369b;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            LargeMessageSnapshot.super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f21369b ? (byte) 1 : 0);
            parcel.writeLong(this.f21370c);
        }
    }

    public static class ConnectedMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f21371b;

        /* renamed from: c  reason: collision with root package name */
        private final long f21372c;

        /* renamed from: d  reason: collision with root package name */
        private final String f21373d;

        /* renamed from: e  reason: collision with root package name */
        private final String f21374e;

        ConnectedMessageSnapshot(int i2, boolean z2, long j2, String str, String str2) {
            super(i2);
            this.f21371b = z2;
            this.f21372c = j2;
            this.f21373d = str;
            this.f21374e = str2;
        }

        ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f21371b = parcel.readByte() != 0;
            this.f21372c = parcel.readLong();
            this.f21373d = parcel.readString();
            this.f21374e = parcel.readString();
        }

        public byte b() {
            return 2;
        }

        public long d() {
            return this.f21372c;
        }

        public int describeContents() {
            return 0;
        }

        public String f() {
            return this.f21374e;
        }

        public boolean g() {
            return this.f21371b;
        }

        public String h() {
            return this.f21373d;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            LargeMessageSnapshot.super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f21371b ? (byte) 1 : 0);
            parcel.writeLong(this.f21372c);
            parcel.writeString(this.f21373d);
            parcel.writeString(this.f21374e);
        }
    }

    public static class ErrorMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final long f21375b;

        /* renamed from: c  reason: collision with root package name */
        private final Throwable f21376c;

        ErrorMessageSnapshot(int i2, long j2, Throwable th) {
            super(i2);
            this.f21375b = j2;
            this.f21376c = th;
        }

        ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f21375b = parcel.readLong();
            this.f21376c = (Throwable) parcel.readSerializable();
        }

        public byte b() {
            return -1;
        }

        public int describeContents() {
            return 0;
        }

        public long i() {
            return this.f21375b;
        }

        public Throwable j() {
            return this.f21376c;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            LargeMessageSnapshot.super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f21375b);
            parcel.writeSerializable(this.f21376c);
        }
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        PausedSnapshot(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }

        public byte b() {
            return -2;
        }
    }

    public static class PendingMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final long f21377b;

        /* renamed from: c  reason: collision with root package name */
        private final long f21378c;

        PendingMessageSnapshot(int i2, long j2, long j3) {
            super(i2);
            this.f21377b = j2;
            this.f21378c = j3;
        }

        PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f21377b = parcel.readLong();
            this.f21378c = parcel.readLong();
        }

        PendingMessageSnapshot(PendingMessageSnapshot pendingMessageSnapshot) {
            this(pendingMessageSnapshot.m(), pendingMessageSnapshot.i(), pendingMessageSnapshot.d());
        }

        public byte b() {
            return 1;
        }

        public long d() {
            return this.f21378c;
        }

        public int describeContents() {
            return 0;
        }

        public long i() {
            return this.f21377b;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            LargeMessageSnapshot.super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f21377b);
            parcel.writeLong(this.f21378c);
        }
    }

    public static class ProgressMessageSnapshot extends LargeMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final long f21379b;

        ProgressMessageSnapshot(int i2, long j2) {
            super(i2);
            this.f21379b = j2;
        }

        ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f21379b = parcel.readLong();
        }

        public byte b() {
            return 3;
        }

        public int describeContents() {
            return 0;
        }

        public long i() {
            return this.f21379b;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            LargeMessageSnapshot.super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f21379b);
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {

        /* renamed from: b  reason: collision with root package name */
        private final int f21380b;

        RetryMessageSnapshot(int i2, long j2, Throwable th, int i3) {
            super(i2, j2, th);
            this.f21380b = i3;
        }

        RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.f21380b = parcel.readInt();
        }

        public byte b() {
            return 5;
        }

        public int describeContents() {
            return 0;
        }

        public int k() {
            return this.f21380b;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f21380b);
        }
    }

    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements a {
        WarnFlowDirectlySnapshot(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }
    }

    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements MessageSnapshot.a {
        WarnMessageSnapshot(int i2, long j2, long j3) {
            super(i2, j2, j3);
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

    LargeMessageSnapshot(int i2) {
        super(i2);
        this.f21381a = true;
    }

    LargeMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    public int a() {
        return i() > 2147483647L ? SubsamplingScaleImageView.TILE_SIZE_AUTO : (int) i();
    }

    public int c() {
        return d() > 2147483647L ? SubsamplingScaleImageView.TILE_SIZE_AUTO : (int) d();
    }
}
