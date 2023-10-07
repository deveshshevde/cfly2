package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import iq.f;

public abstract class MessageSnapshot implements Parcelable, b {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new Parcelable.Creator<MessageSnapshot>() {
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0097  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.liulishuo.filedownloader.message.MessageSnapshot createFromParcel(android.os.Parcel r5) {
            /*
                r4 = this;
                byte r0 = r5.readByte()
                r1 = 1
                if (r0 != r1) goto L_0x0009
                r0 = 1
                goto L_0x000a
            L_0x0009:
                r0 = 0
            L_0x000a:
                byte r2 = r5.readByte()
                r3 = -4
                if (r2 == r3) goto L_0x0084
                r3 = -3
                if (r2 == r3) goto L_0x0076
                r3 = -1
                if (r2 == r3) goto L_0x0068
                if (r2 == r1) goto L_0x005a
                r1 = 2
                if (r2 == r1) goto L_0x004c
                r1 = 3
                if (r2 == r1) goto L_0x003e
                r1 = 5
                if (r2 == r1) goto L_0x0030
                r1 = 6
                if (r2 == r1) goto L_0x0028
                r5 = 0
                goto L_0x0092
            L_0x0028:
                com.liulishuo.filedownloader.message.MessageSnapshot$StartedMessageSnapshot r1 = new com.liulishuo.filedownloader.message.MessageSnapshot$StartedMessageSnapshot
                r1.<init>((android.os.Parcel) r5)
            L_0x002d:
                r5 = r1
                goto L_0x0092
            L_0x0030:
                if (r0 == 0) goto L_0x0038
                com.liulishuo.filedownloader.message.LargeMessageSnapshot$RetryMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$RetryMessageSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x0038:
                com.liulishuo.filedownloader.message.SmallMessageSnapshot$RetryMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$RetryMessageSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x003e:
                if (r0 == 0) goto L_0x0046
                com.liulishuo.filedownloader.message.LargeMessageSnapshot$ProgressMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$ProgressMessageSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x0046:
                com.liulishuo.filedownloader.message.SmallMessageSnapshot$ProgressMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$ProgressMessageSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x004c:
                if (r0 == 0) goto L_0x0054
                com.liulishuo.filedownloader.message.LargeMessageSnapshot$ConnectedMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$ConnectedMessageSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x0054:
                com.liulishuo.filedownloader.message.SmallMessageSnapshot$ConnectedMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$ConnectedMessageSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x005a:
                if (r0 == 0) goto L_0x0062
                com.liulishuo.filedownloader.message.LargeMessageSnapshot$PendingMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$PendingMessageSnapshot
                r1.<init>((android.os.Parcel) r5)
                goto L_0x002d
            L_0x0062:
                com.liulishuo.filedownloader.message.SmallMessageSnapshot$PendingMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$PendingMessageSnapshot
                r1.<init>((android.os.Parcel) r5)
                goto L_0x002d
            L_0x0068:
                if (r0 == 0) goto L_0x0070
                com.liulishuo.filedownloader.message.LargeMessageSnapshot$ErrorMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$ErrorMessageSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x0070:
                com.liulishuo.filedownloader.message.SmallMessageSnapshot$ErrorMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$ErrorMessageSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x0076:
                if (r0 == 0) goto L_0x007e
                com.liulishuo.filedownloader.message.LargeMessageSnapshot$CompletedSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$CompletedSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x007e:
                com.liulishuo.filedownloader.message.SmallMessageSnapshot$CompletedSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$CompletedSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x0084:
                if (r0 == 0) goto L_0x008c
                com.liulishuo.filedownloader.message.LargeMessageSnapshot$WarnMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$WarnMessageSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x008c:
                com.liulishuo.filedownloader.message.SmallMessageSnapshot$WarnMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$WarnMessageSnapshot
                r1.<init>(r5)
                goto L_0x002d
            L_0x0092:
                if (r5 == 0) goto L_0x0097
                r5.f21381a = r0
                return r5
            L_0x0097:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Can't restore the snapshot because unknown status: "
                r0.append(r1)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                r5.<init>(r0)
                goto L_0x00af
            L_0x00ae:
                throw r5
            L_0x00af:
                goto L_0x00ae
            */
            throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.message.MessageSnapshot.AnonymousClass1.createFromParcel(android.os.Parcel):com.liulishuo.filedownloader.message.MessageSnapshot");
        }

        /* renamed from: a */
        public MessageSnapshot[] newArray(int i2) {
            return new MessageSnapshot[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected boolean f21381a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21382b;

    public static class NoFieldException extends IllegalStateException {
        NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(f.a("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b()), messageSnapshot.getClass().getName()));
        }
    }

    public static class StartedMessageSnapshot extends MessageSnapshot {
        StartedMessageSnapshot(int i2) {
            super(i2);
        }

        StartedMessageSnapshot(Parcel parcel) {
            super(parcel);
        }

        public byte b() {
            return 6;
        }
    }

    public interface a {
        MessageSnapshot l();
    }

    MessageSnapshot(int i2) {
        this.f21382b = i2;
    }

    MessageSnapshot(Parcel parcel) {
        this.f21382b = parcel.readInt();
    }

    public int a() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int c() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public long d() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    public String f() {
        throw new NoFieldException("getFileName", this);
    }

    public boolean g() {
        throw new NoFieldException("isResuming", this);
    }

    public String h() {
        throw new NoFieldException("getEtag", this);
    }

    public long i() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public Throwable j() {
        throw new NoFieldException("getThrowable", this);
    }

    public int k() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public int m() {
        return this.f21382b;
    }

    public boolean n() {
        return this.f21381a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f21381a ? (byte) 1 : 0);
        parcel.writeByte(b());
        parcel.writeInt(this.f21382b);
    }
}
