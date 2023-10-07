package com.sun.mail.pop3;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.SharedInputStream;

public class POP3Message extends MimeMessage {
    static final String UNKNOWN = "UNKNOWN";
    private POP3Folder folder;
    private int hdrSize = -1;
    private int msgSize = -1;
    String uid = UNKNOWN;

    public POP3Message(Folder folder2, int i2) throws MessagingException {
        super(folder2, i2);
        this.folder = (POP3Folder) folder2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadHeaders() throws javax.mail.MessagingException {
        /*
            r3 = this;
            r0 = 0
            monitor-enter(r3)     // Catch:{ EOFException -> 0x0046, IOException -> 0x003d }
            javax.mail.internet.InternetHeaders r1 = r3.headers     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0008
            monitor-exit(r3)     // Catch:{ all -> 0x003a }
            return
        L_0x0008:
            com.sun.mail.pop3.POP3Folder r1 = r3.folder     // Catch:{ all -> 0x003a }
            javax.mail.Store r1 = r1.getStore()     // Catch:{ all -> 0x003a }
            com.sun.mail.pop3.POP3Store r1 = (com.sun.mail.pop3.POP3Store) r1     // Catch:{ all -> 0x003a }
            boolean r1 = r1.disableTop     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0031
            com.sun.mail.pop3.POP3Folder r1 = r3.folder     // Catch:{ all -> 0x003a }
            com.sun.mail.pop3.Protocol r1 = r1.getProtocol()     // Catch:{ all -> 0x003a }
            int r2 = r3.msgnum     // Catch:{ all -> 0x003a }
            java.io.InputStream r1 = r1.top(r2, r0)     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0023
            goto L_0x0031
        L_0x0023:
            int r2 = r1.available()     // Catch:{ all -> 0x003a }
            r3.hdrSize = r2     // Catch:{ all -> 0x003a }
            javax.mail.internet.InternetHeaders r2 = new javax.mail.internet.InternetHeaders     // Catch:{ all -> 0x003a }
            r2.<init>(r1)     // Catch:{ all -> 0x003a }
            r3.headers = r2     // Catch:{ all -> 0x003a }
            goto L_0x0038
        L_0x0031:
            java.io.InputStream r1 = r3.getContentStream()     // Catch:{ all -> 0x003a }
            r1.close()     // Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r3)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003a }
            throw r1     // Catch:{ EOFException -> 0x0046, IOException -> 0x003d }
        L_0x003d:
            r0 = move-exception
            javax.mail.MessagingException r1 = new javax.mail.MessagingException
            java.lang.String r2 = "error loading POP3 headers"
            r1.<init>(r2, r0)
            throw r1
        L_0x0046:
            r1 = move-exception
            com.sun.mail.pop3.POP3Folder r2 = r3.folder
            r2.close(r0)
            javax.mail.FolderClosedException r0 = new javax.mail.FolderClosedException
            com.sun.mail.pop3.POP3Folder r2 = r3.folder
            java.lang.String r1 = r1.toString()
            r0.<init>(r2, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Message.loadHeaders():void");
    }

    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    public Enumeration getAllHeaderLines() throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getAllHeaderLines();
    }

    public Enumeration getAllHeaders() throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getAllHeaders();
    }

    /* access modifiers changed from: protected */
    public InputStream getContentStream() throws MessagingException {
        long position;
        try {
            synchronized (this) {
                if (this.contentStream == null) {
                    Protocol protocol = this.folder.getProtocol();
                    int i2 = this.msgnum;
                    int i3 = this.msgSize;
                    InputStream retr = protocol.retr(i2, i3 > 0 ? i3 + this.hdrSize : 0);
                    if (retr != null) {
                        if (this.headers != null) {
                            if (!((POP3Store) this.folder.getStore()).forgetTopHeaders) {
                                while (true) {
                                    int i4 = 0;
                                    while (true) {
                                        int read = retr.read();
                                        if (read < 0) {
                                            break;
                                        } else if (read == 10) {
                                            break;
                                        } else if (read != 13) {
                                            i4++;
                                        } else if (retr.available() > 0) {
                                            retr.mark(1);
                                            if (retr.read() != 10) {
                                                retr.reset();
                                            }
                                        }
                                    }
                                    if (retr.available() != 0) {
                                        if (i4 == 0) {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                position = ((SharedInputStream) retr).getPosition();
                                this.hdrSize = (int) position;
                                this.contentStream = ((SharedInputStream) retr).newStream((long) this.hdrSize, -1);
                            }
                        }
                        this.headers = new InternetHeaders(retr);
                        position = ((SharedInputStream) retr).getPosition();
                        this.hdrSize = (int) position;
                        this.contentStream = ((SharedInputStream) retr).newStream((long) this.hdrSize, -1);
                    } else {
                        this.expunged = true;
                        throw new MessageRemovedException();
                    }
                }
            }
            return super.getContentStream();
        } catch (EOFException e2) {
            this.folder.close(false);
            throw new FolderClosedException(this.folder, e2.toString());
        } catch (IOException e3) {
            throw new MessagingException("error fetching POP3 content", e3);
        }
    }

    public String getHeader(String str, String str2) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getHeader(str, str2);
    }

    public String[] getHeader(String str) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getHeader(str);
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getMatchingHeaderLines(strArr);
    }

    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getMatchingHeaders(strArr);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            loadHeaders();
        }
        return this.headers.getNonMatchingHeaders(strArr);
    }

    public int getSize() throws MessagingException {
        try {
            synchronized (this) {
                int i2 = this.msgSize;
                if (i2 >= 0) {
                    return i2;
                }
                if (i2 < 0) {
                    if (this.headers == null) {
                        loadHeaders();
                    }
                    if (this.contentStream != null) {
                        this.msgSize = this.contentStream.available();
                    } else {
                        this.msgSize = this.folder.getProtocol().list(this.msgnum) - this.hdrSize;
                    }
                }
                int i3 = this.msgSize;
                return i3;
            }
        } catch (EOFException e2) {
            this.folder.close(false);
            throw new FolderClosedException(this.folder, e2.toString());
        } catch (IOException e3) {
            throw new MessagingException("error getting size", e3);
        }
    }

    public synchronized void invalidate(boolean z2) {
        this.content = null;
        this.contentStream = null;
        this.msgSize = -1;
        if (z2) {
            this.headers = null;
            this.hdrSize = -1;
        }
    }

    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    public void saveChanges() throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    public void setFlags(Flags flags, boolean z2) throws MessagingException {
        super.setFlags(flags, z2);
        if (!this.flags.equals((Flags) this.flags.clone())) {
            this.folder.notifyMessageChangedListeners(1, this);
        }
    }

    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    public InputStream top(int i2) throws MessagingException {
        InputStream pVar;
        try {
            synchronized (this) {
                pVar = this.folder.getProtocol().top(this.msgnum, i2);
            }
            return pVar;
        } catch (EOFException e2) {
            this.folder.close(false);
            throw new FolderClosedException(this.folder, e2.toString());
        } catch (IOException e3) {
            throw new MessagingException("error getting size", e3);
        }
    }
}
