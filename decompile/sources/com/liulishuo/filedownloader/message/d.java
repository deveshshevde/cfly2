package com.liulishuo.filedownloader.message;

import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.message.BlockCompleteMessage;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot;
import iq.f;
import java.io.File;

public class d {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: com.liulishuo.filedownloader.message.SmallMessageSnapshot$ErrorMessageSnapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: com.liulishuo.filedownloader.message.LargeMessageSnapshot$ErrorMessageSnapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: com.liulishuo.filedownloader.message.SmallMessageSnapshot$RetryMessageSnapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: com.liulishuo.filedownloader.message.LargeMessageSnapshot$RetryMessageSnapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: com.liulishuo.filedownloader.message.LargeMessageSnapshot$RetryMessageSnapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: com.liulishuo.filedownloader.message.LargeMessageSnapshot$RetryMessageSnapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.liulishuo.filedownloader.message.LargeMessageSnapshot$RetryMessageSnapshot} */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.liulishuo.filedownloader.message.MessageSnapshot a(byte r8, com.liulishuo.filedownloader.model.FileDownloadModel r9, com.liulishuo.filedownloader.download.e.a r10) {
        /*
            int r1 = r9.a()
            r0 = 1
            r2 = 0
            r3 = -4
            if (r8 == r3) goto L_0x0162
            r3 = -3
            if (r8 == r3) goto L_0x0147
            r3 = -1
            if (r8 == r3) goto L_0x0123
            if (r8 == r0) goto L_0x00fe
            r3 = 2
            if (r8 == r3) goto L_0x00c0
            r4 = 3
            if (r8 == r4) goto L_0x00a3
            r4 = 5
            if (r8 == r4) goto L_0x0075
            r4 = 6
            if (r8 == r4) goto L_0x006e
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r4[r2] = r9
            java.lang.Byte r5 = java.lang.Byte.valueOf(r8)
            r4[r0] = r5
            java.lang.String r5 = "it can't takes a snapshot for the task(%s) when its status is %d,"
            java.lang.String r4 = iq.f.a((java.lang.String) r5, (java.lang.Object[]) r4)
            java.lang.Class<com.liulishuo.filedownloader.message.d> r6 = com.liulishuo.filedownloader.message.d.class
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r9
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)
            r3[r0] = r8
            iq.d.d(r6, r5, r3)
            java.lang.Exception r8 = r10.b()
            if (r8 == 0) goto L_0x004c
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.Exception r10 = r10.b()
            r8.<init>(r4, r10)
            goto L_0x0051
        L_0x004c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r4)
        L_0x0051:
            boolean r10 = r9.q()
            if (r10 == 0) goto L_0x0062
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$ErrorMessageSnapshot r10 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$ErrorMessageSnapshot
            long r2 = r9.g()
            r10.<init>(r1, r2, r8)
            goto L_0x0161
        L_0x0062:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$ErrorMessageSnapshot r10 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$ErrorMessageSnapshot
            long r2 = r9.g()
            int r9 = (int) r2
            r10.<init>(r1, r9, r8)
            goto L_0x0161
        L_0x006e:
            com.liulishuo.filedownloader.message.MessageSnapshot$StartedMessageSnapshot r10 = new com.liulishuo.filedownloader.message.MessageSnapshot$StartedMessageSnapshot
            r10.<init>((int) r1)
            goto L_0x0161
        L_0x0075:
            boolean r8 = r9.q()
            if (r8 == 0) goto L_0x008f
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$RetryMessageSnapshot r8 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$RetryMessageSnapshot
            long r2 = r9.g()
            java.lang.Exception r4 = r10.b()
            int r5 = r10.c()
            r0 = r8
            r0.<init>(r1, r2, r4, r5)
            goto L_0x0145
        L_0x008f:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$RetryMessageSnapshot r8 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$RetryMessageSnapshot
            long r2 = r9.g()
            int r9 = (int) r2
            java.lang.Exception r0 = r10.b()
            int r10 = r10.c()
            r8.<init>(r1, r9, r0, r10)
            goto L_0x0145
        L_0x00a3:
            boolean r8 = r9.q()
            if (r8 == 0) goto L_0x00b4
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$ProgressMessageSnapshot r10 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$ProgressMessageSnapshot
            long r8 = r9.g()
            r10.<init>(r1, r8)
            goto L_0x0161
        L_0x00b4:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$ProgressMessageSnapshot r10 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$ProgressMessageSnapshot
            long r8 = r9.g()
            int r9 = (int) r8
            r10.<init>(r1, r9)
            goto L_0x0161
        L_0x00c0:
            boolean r8 = r9.l()
            if (r8 == 0) goto L_0x00cb
            java.lang.String r8 = r9.m()
            goto L_0x00cc
        L_0x00cb:
            r8 = 0
        L_0x00cc:
            boolean r0 = r9.q()
            if (r0 == 0) goto L_0x00e8
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$ConnectedMessageSnapshot r7 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$ConnectedMessageSnapshot
            boolean r2 = r10.a()
            long r3 = r9.h()
            java.lang.String r5 = r9.j()
            r0 = r7
            r6 = r8
            r0.<init>(r1, r2, r3, r5, r6)
            r10 = r7
            goto L_0x0161
        L_0x00e8:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$ConnectedMessageSnapshot r6 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$ConnectedMessageSnapshot
            boolean r2 = r10.a()
            long r3 = r9.h()
            int r3 = (int) r3
            java.lang.String r4 = r9.j()
            r0 = r6
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r10 = r6
            goto L_0x0161
        L_0x00fe:
            boolean r8 = r9.q()
            if (r8 == 0) goto L_0x0113
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$PendingMessageSnapshot r10 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$PendingMessageSnapshot
            long r2 = r9.g()
            long r4 = r9.h()
            r0 = r10
            r0.<init>(r1, r2, r4)
            goto L_0x0161
        L_0x0113:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$PendingMessageSnapshot r10 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$PendingMessageSnapshot
            long r2 = r9.g()
            int r8 = (int) r2
            long r2 = r9.h()
            int r9 = (int) r2
            r10.<init>(r1, r8, r9)
            goto L_0x0161
        L_0x0123:
            boolean r8 = r9.q()
            if (r8 == 0) goto L_0x0137
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$ErrorMessageSnapshot r8 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$ErrorMessageSnapshot
            long r2 = r9.g()
            java.lang.Exception r9 = r10.b()
            r8.<init>(r1, r2, r9)
            goto L_0x0145
        L_0x0137:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$ErrorMessageSnapshot r8 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$ErrorMessageSnapshot
            long r2 = r9.g()
            int r9 = (int) r2
            java.lang.Exception r10 = r10.b()
            r8.<init>(r1, r9, r10)
        L_0x0145:
            r10 = r8
            goto L_0x0161
        L_0x0147:
            boolean r8 = r9.q()
            if (r8 == 0) goto L_0x0157
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$CompletedSnapshot r10 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$CompletedSnapshot
            long r8 = r9.h()
            r10.<init>(r1, r2, r8)
            goto L_0x0161
        L_0x0157:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$CompletedSnapshot r10 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$CompletedSnapshot
            long r8 = r9.h()
            int r9 = (int) r8
            r10.<init>(r1, r2, r9)
        L_0x0161:
            return r10
        L_0x0162:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.Object[] r9 = new java.lang.Object[r0]
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)
            r9[r2] = r10
            java.lang.String r10 = "please use #catchWarn instead %d"
            java.lang.String r9 = iq.f.a((java.lang.String) r10, (java.lang.Object[]) r9)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.message.d.a(byte, com.liulishuo.filedownloader.model.FileDownloadModel, com.liulishuo.filedownloader.download.e$a):com.liulishuo.filedownloader.message.MessageSnapshot");
    }

    public static MessageSnapshot a(int i2, long j2, long j3, boolean z2) {
        return j3 > 2147483647L ? z2 ? new LargeMessageSnapshot.WarnFlowDirectlySnapshot(i2, j2, j3) : new LargeMessageSnapshot.WarnMessageSnapshot(i2, j2, j3) : z2 ? new SmallMessageSnapshot.WarnFlowDirectlySnapshot(i2, (int) j2, (int) j3) : new SmallMessageSnapshot.WarnMessageSnapshot(i2, (int) j2, (int) j3);
    }

    public static MessageSnapshot a(int i2, long j2, Throwable th) {
        return j2 > 2147483647L ? new LargeMessageSnapshot.ErrorMessageSnapshot(i2, j2, th) : new SmallMessageSnapshot.ErrorMessageSnapshot(i2, (int) j2, th);
    }

    public static MessageSnapshot a(int i2, File file, boolean z2) {
        long length = file.length();
        return length > 2147483647L ? z2 ? new LargeMessageSnapshot.CompletedFlowDirectlySnapshot(i2, true, length) : new LargeMessageSnapshot.CompletedSnapshot(i2, true, length) : z2 ? new SmallMessageSnapshot.CompletedFlowDirectlySnapshot(i2, true, (int) length) : new SmallMessageSnapshot.CompletedSnapshot(i2, true, (int) length);
    }

    public static MessageSnapshot a(a aVar) {
        return aVar.y() ? new LargeMessageSnapshot.PausedSnapshot(aVar.e(), aVar.o(), aVar.q()) : new SmallMessageSnapshot.PausedSnapshot(aVar.e(), aVar.n(), aVar.p());
    }

    public static MessageSnapshot a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.b() == -3) {
            return new BlockCompleteMessage.BlockCompleteMessageImpl(messageSnapshot);
        }
        throw new IllegalStateException(f.a("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b())));
    }
}
