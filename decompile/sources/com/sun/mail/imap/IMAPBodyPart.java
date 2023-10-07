package com.sun.mail.imap;

import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.IMAPProtocol;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;

public class IMAPBodyPart extends MimeBodyPart {

    /* renamed from: bs  reason: collision with root package name */
    private BODYSTRUCTURE f21756bs;
    private String description;
    private boolean headersLoaded = false;
    private IMAPMessage message;
    private String sectionId;
    private String type;

    protected IMAPBodyPart(BODYSTRUCTURE bodystructure, String str, IMAPMessage iMAPMessage) {
        this.f21756bs = bodystructure;
        this.sectionId = str;
        this.message = iMAPMessage;
        this.type = new ContentType(bodystructure.type, bodystructure.subtype, bodystructure.cParams).toString();
    }

    private synchronized void loadHeaders() throws MessagingException {
        if (!this.headersLoaded) {
            if (this.headers == null) {
                this.headers = new InternetHeaders();
            }
            synchronized (this.message.getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = this.message.getProtocol();
                    this.message.checkExpunged();
                    if (protocol.isREV1()) {
                        int sequenceNumber = this.message.getSequenceNumber();
                        BODY peekBody = protocol.peekBody(sequenceNumber, String.valueOf(this.sectionId) + ".MIME");
                        if (peekBody != null) {
                            ByteArrayInputStream byteArrayInputStream = peekBody.getByteArrayInputStream();
                            if (byteArrayInputStream != null) {
                                this.headers.load(byteArrayInputStream);
                            } else {
                                throw new MessagingException("Failed to fetch headers");
                            }
                        } else {
                            throw new MessagingException("Failed to fetch headers");
                        }
                    } else {
                        this.headers.addHeader("Content-Type", this.type);
                        this.headers.addHeader("Content-Transfer-Encoding", this.f21756bs.encoding);
                        if (this.f21756bs.description != null) {
                            this.headers.addHeader("Content-Description", this.f21756bs.description);
                        }
                        if (this.f21756bs.f21758id != null) {
                            this.headers.addHeader("Content-ID", this.f21756bs.f21758id);
                        }
                        if (this.f21756bs.md5 != null) {
                            this.headers.addHeader("Content-MD5", this.f21756bs.md5);
                        }
                    }
                } catch (ConnectionException e2) {
                    throw new FolderClosedException(this.message.getFolder(), e2.getMessage());
                } catch (ProtocolException e3) {
                    throw new MessagingException(e3.getMessage(), e3);
                }
            }
            this.headersLoaded = true;
        }
    }

    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public Enumeration getAllHeaderLines() throws MessagingException {
        loadHeaders();
        return super.getAllHeaderLines();
    }

    public Enumeration getAllHeaders() throws MessagingException {
        loadHeaders();
        return super.getAllHeaders();
    }

    public String getContentID() throws MessagingException {
        return this.f21756bs.f21758id;
    }

    public String getContentMD5() throws MessagingException {
        return this.f21756bs.md5;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r0 == null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        throw new javax.mail.MessagingException("No content");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.InputStream getContentStream() throws javax.mail.MessagingException {
        /*
            r6 = this;
            com.sun.mail.imap.IMAPMessage r0 = r6.message
            boolean r0 = r0.getPeek()
            com.sun.mail.imap.IMAPMessage r1 = r6.message
            java.lang.Object r1 = r1.getMessageCacheLock()
            monitor-enter(r1)
            com.sun.mail.imap.IMAPMessage r2 = r6.message     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r2.getProtocol()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.IMAPMessage r3 = r6.message     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            r3.checkExpunged()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            boolean r3 = r2.isREV1()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            if (r3 == 0) goto L_0x0036
            com.sun.mail.imap.IMAPMessage r3 = r6.message     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            int r3 = r3.getFetchBlockSize()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            r4 = -1
            if (r3 == r4) goto L_0x0036
            com.sun.mail.imap.IMAPInputStream r2 = new com.sun.mail.imap.IMAPInputStream     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.IMAPMessage r3 = r6.message     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            java.lang.String r4 = r6.sectionId     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.protocol.BODYSTRUCTURE r5 = r6.f21756bs     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            int r5 = r5.size     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            r2.<init>(r3, r4, r5, r0)     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            return r2
        L_0x0036:
            com.sun.mail.imap.IMAPMessage r3 = r6.message     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            int r3 = r3.getSequenceNumber()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = r6.sectionId     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.protocol.BODY r0 = r2.peekBody(r3, r0)     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            goto L_0x004b
        L_0x0045:
            java.lang.String r0 = r6.sectionId     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            com.sun.mail.imap.protocol.BODY r0 = r2.fetchBody(r3, r0)     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
        L_0x004b:
            if (r0 == 0) goto L_0x0052
            java.io.ByteArrayInputStream r0 = r0.getByteArrayInputStream()     // Catch:{ ConnectionException -> 0x006c, ProtocolException -> 0x0061 }
            goto L_0x0053
        L_0x0052:
            r0 = 0
        L_0x0053:
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0057
            return r0
        L_0x0057:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException
            java.lang.String r1 = "No content"
            r0.<init>(r1)
            throw r0
        L_0x005f:
            r0 = move-exception
            goto L_0x007d
        L_0x0061:
            r0 = move-exception
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x005f }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x005f }
            throw r2     // Catch:{ all -> 0x005f }
        L_0x006c:
            r0 = move-exception
            javax.mail.FolderClosedException r2 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x005f }
            com.sun.mail.imap.IMAPMessage r3 = r6.message     // Catch:{ all -> 0x005f }
            javax.mail.Folder r3 = r3.getFolder()     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x005f }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x005f }
            throw r2     // Catch:{ all -> 0x005f }
        L_0x007d:
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPBodyPart.getContentStream():java.io.InputStream");
    }

    public String getContentType() throws MessagingException {
        return this.type;
    }

    public synchronized DataHandler getDataHandler() throws MessagingException {
        DataHandler dataHandler;
        if (this.f29475dh == null) {
            if (this.f21756bs.isMulti()) {
                dataHandler = new DataHandler((DataSource) new IMAPMultipartDataSource(this, this.f21756bs.bodies, this.sectionId, this.message));
            } else if (this.f21756bs.isNested() && this.message.isREV1()) {
                dataHandler = new DataHandler(new IMAPNestedMessage(this.message, this.f21756bs.bodies[0], this.f21756bs.envelope, this.sectionId), this.type);
            }
            this.f29475dh = dataHandler;
        }
        return super.getDataHandler();
    }

    public String getDescription() throws MessagingException {
        String str = this.description;
        if (str != null) {
            return str;
        }
        if (this.f21756bs.description == null) {
            return null;
        }
        try {
            this.description = MimeUtility.decodeText(this.f21756bs.description);
        } catch (UnsupportedEncodingException unused) {
            this.description = this.f21756bs.description;
        }
        return this.description;
    }

    public String getDisposition() throws MessagingException {
        return this.f21756bs.disposition;
    }

    public String getEncoding() throws MessagingException {
        return this.f21756bs.encoding;
    }

    public String getFileName() throws MessagingException {
        String str = this.f21756bs.dParams != null ? this.f21756bs.dParams.get("filename") : null;
        return (str != null || this.f21756bs.cParams == null) ? str : this.f21756bs.cParams.get("name");
    }

    public String[] getHeader(String str) throws MessagingException {
        loadHeaders();
        return super.getHeader(str);
    }

    public int getLineCount() throws MessagingException {
        return this.f21756bs.lines;
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getMatchingHeaderLines(strArr);
    }

    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getMatchingHeaders(strArr);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getNonMatchingHeaderLines(strArr);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getNonMatchingHeaders(strArr);
    }

    public int getSize() throws MessagingException {
        return this.f21756bs.size;
    }

    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setContent(Object obj, String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setContent(Multipart multipart) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    /* access modifiers changed from: protected */
    public void updateHeaders() {
    }
}
