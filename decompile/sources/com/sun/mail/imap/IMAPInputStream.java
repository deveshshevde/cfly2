package com.sun.mail.imap;

import com.sun.mail.iap.ByteArray;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.MessagingException;

public class IMAPInputStream extends InputStream {
    private static final int slop = 64;
    private int blksize;
    private byte[] buf;
    private int bufcount;
    private int bufpos;
    private int max;
    private IMAPMessage msg;
    private boolean peek;
    private int pos = 0;
    private ByteArray readbuf;
    private String section;

    public IMAPInputStream(IMAPMessage iMAPMessage, String str, int i2, boolean z2) {
        this.msg = iMAPMessage;
        this.section = str;
        this.max = i2;
        this.peek = z2;
        this.blksize = iMAPMessage.getFetchBlockSize();
    }

    private void checkSeen() {
        if (!this.peek) {
            try {
                Folder folder = this.msg.getFolder();
                if (folder != null && folder.getMode() != 1 && !this.msg.isSet(Flags.Flag.SEEN)) {
                    this.msg.setFlag(Flags.Flag.SEEN, true);
                }
            } catch (MessagingException unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050 A[Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b A[Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fill() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.max
            r1 = -1
            if (r0 == r1) goto L_0x0012
            int r2 = r9.pos
            if (r2 < r0) goto L_0x0012
            if (r2 != 0) goto L_0x000e
            r9.checkSeen()
        L_0x000e:
            r0 = 0
            r9.readbuf = r0
            return
        L_0x0012:
            com.sun.mail.iap.ByteArray r0 = r9.readbuf
            if (r0 != 0) goto L_0x0021
            com.sun.mail.iap.ByteArray r0 = new com.sun.mail.iap.ByteArray
            int r2 = r9.blksize
            int r2 = r2 + 64
            r0.<init>(r2)
            r9.readbuf = r0
        L_0x0021:
            com.sun.mail.imap.IMAPMessage r0 = r9.msg
            java.lang.Object r0 = r0.getMessageCacheLock()
            monitor-enter(r0)
            com.sun.mail.imap.IMAPMessage r2 = r9.msg     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            com.sun.mail.imap.protocol.IMAPProtocol r3 = r2.getProtocol()     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            com.sun.mail.imap.IMAPMessage r2 = r9.msg     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            boolean r2 = r2.isExpunged()     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            if (r2 != 0) goto L_0x009b
            com.sun.mail.imap.IMAPMessage r2 = r9.msg     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            int r4 = r2.getSequenceNumber()     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            int r2 = r9.blksize     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            int r5 = r9.max     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            if (r5 == r1) goto L_0x004b
            int r1 = r9.pos     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            int r6 = r1 + r2
            if (r6 <= r5) goto L_0x004b
            int r5 = r5 - r1
            r7 = r5
            goto L_0x004c
        L_0x004b:
            r7 = r2
        L_0x004c:
            boolean r1 = r9.peek     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            if (r1 == 0) goto L_0x005b
            java.lang.String r5 = r9.section     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            int r6 = r9.pos     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            com.sun.mail.iap.ByteArray r8 = r9.readbuf     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            com.sun.mail.imap.protocol.BODY r1 = r3.peekBody(r4, r5, r6, r7, r8)     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            goto L_0x0065
        L_0x005b:
            java.lang.String r5 = r9.section     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            int r6 = r9.pos     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            com.sun.mail.iap.ByteArray r8 = r9.readbuf     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            com.sun.mail.imap.protocol.BODY r1 = r3.fetchBody(r4, r5, r6, r7, r8)     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
        L_0x0065:
            if (r1 == 0) goto L_0x0090
            com.sun.mail.iap.ByteArray r1 = r1.getByteArray()     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x0090
            monitor-exit(r0)     // Catch:{ all -> 0x00a3 }
            int r0 = r9.pos
            if (r0 != 0) goto L_0x0075
            r9.checkSeen()
        L_0x0075:
            byte[] r0 = r1.getBytes()
            r9.buf = r0
            int r0 = r1.getStart()
            r9.bufpos = r0
            int r0 = r1.getCount()
            int r1 = r9.bufpos
            int r1 = r1 + r0
            r9.bufcount = r1
            int r1 = r9.pos
            int r1 = r1 + r0
            r9.pos = r1
            return
        L_0x0090:
            r9.forceCheckExpunged()     // Catch:{ all -> 0x00a3 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00a3 }
            java.lang.String r2 = "No content"
            r1.<init>(r2)     // Catch:{ all -> 0x00a3 }
            throw r1     // Catch:{ all -> 0x00a3 }
        L_0x009b:
            com.sun.mail.util.MessageRemovedIOException r1 = new com.sun.mail.util.MessageRemovedIOException     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            java.lang.String r2 = "No content for expunged message"
            r1.<init>(r2)     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
            throw r1     // Catch:{ ProtocolException -> 0x00b4, FolderClosedException -> 0x00a5 }
        L_0x00a3:
            r1 = move-exception
            goto L_0x00c2
        L_0x00a5:
            r1 = move-exception
            com.sun.mail.util.FolderClosedIOException r2 = new com.sun.mail.util.FolderClosedIOException     // Catch:{ all -> 0x00a3 }
            javax.mail.Folder r3 = r1.getFolder()     // Catch:{ all -> 0x00a3 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00a3 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x00a3 }
            throw r2     // Catch:{ all -> 0x00a3 }
        L_0x00b4:
            r1 = move-exception
            r9.forceCheckExpunged()     // Catch:{ all -> 0x00a3 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x00a3 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00a3 }
            r2.<init>(r1)     // Catch:{ all -> 0x00a3 }
            throw r2     // Catch:{ all -> 0x00a3 }
        L_0x00c2:
            monitor-exit(r0)     // Catch:{ all -> 0x00a3 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPInputStream.fill():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0013 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void forceCheckExpunged() throws com.sun.mail.util.MessageRemovedIOException, com.sun.mail.util.FolderClosedIOException {
        /*
            r4 = this;
            com.sun.mail.imap.IMAPMessage r0 = r4.msg
            java.lang.Object r0 = r0.getMessageCacheLock()
            monitor-enter(r0)
            com.sun.mail.imap.IMAPMessage r1 = r4.msg     // Catch:{ ConnectionException -> 0x0032, FolderClosedException -> 0x0023, ProtocolException -> 0x0013 }
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r1.getProtocol()     // Catch:{ ConnectionException -> 0x0032, FolderClosedException -> 0x0023, ProtocolException -> 0x0013 }
            r1.noop()     // Catch:{ ConnectionException -> 0x0032, FolderClosedException -> 0x0023, ProtocolException -> 0x0013 }
            goto L_0x0013
        L_0x0011:
            r1 = move-exception
            goto L_0x0043
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            com.sun.mail.imap.IMAPMessage r0 = r4.msg
            boolean r0 = r0.isExpunged()
            if (r0 != 0) goto L_0x001d
            return
        L_0x001d:
            com.sun.mail.util.MessageRemovedIOException r0 = new com.sun.mail.util.MessageRemovedIOException
            r0.<init>()
            throw r0
        L_0x0023:
            r1 = move-exception
            com.sun.mail.util.FolderClosedIOException r2 = new com.sun.mail.util.FolderClosedIOException     // Catch:{ all -> 0x0011 }
            javax.mail.Folder r3 = r1.getFolder()     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0011 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0011 }
            throw r2     // Catch:{ all -> 0x0011 }
        L_0x0032:
            r1 = move-exception
            com.sun.mail.util.FolderClosedIOException r2 = new com.sun.mail.util.FolderClosedIOException     // Catch:{ all -> 0x0011 }
            com.sun.mail.imap.IMAPMessage r3 = r4.msg     // Catch:{ all -> 0x0011 }
            javax.mail.Folder r3 = r3.getFolder()     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0011 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0011 }
            throw r2     // Catch:{ all -> 0x0011 }
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPInputStream.forceCheckExpunged():void");
    }

    public synchronized int available() throws IOException {
        return this.bufcount - this.bufpos;
    }

    public synchronized int read() throws IOException {
        byte b2;
        if (this.bufpos >= this.bufcount) {
            fill();
            if (this.bufpos >= this.bufcount) {
                b2 = -1;
            }
        }
        byte[] bArr = this.buf;
        int i2 = this.bufpos;
        this.bufpos = i2 + 1;
        b2 = bArr[i2] & 255;
        return b2;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.bufcount - this.bufpos;
        if (i4 <= 0) {
            fill();
            i4 = this.bufcount - this.bufpos;
            if (i4 <= 0) {
                return -1;
            }
        }
        if (i4 < i3) {
            i3 = i4;
        }
        System.arraycopy(this.buf, this.bufpos, bArr, i2, i3);
        this.bufpos += i3;
        return i3;
    }
}
