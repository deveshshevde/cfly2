package com.sun.mail.imap;

import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.ENVELOPE;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.INTERNALDATE;
import com.sun.mail.imap.protocol.Item;
import com.sun.mail.imap.protocol.RFC822DATA;
import com.sun.mail.imap.protocol.RFC822SIZE;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

public class IMAPMessage extends MimeMessage {
    private static String EnvelopeCmd = "ENVELOPE INTERNALDATE RFC822.SIZE";

    /* renamed from: bs  reason: collision with root package name */
    protected BODYSTRUCTURE f21757bs;
    private String description;
    protected ENVELOPE envelope;
    private boolean headersLoaded = false;
    private Hashtable loadedHeaders;
    private boolean peek;
    private Date receivedDate;
    protected String sectionId;
    private int seqnum;
    /* access modifiers changed from: private */
    public int size = -1;
    private String subject;
    private String type;
    private long uid = -1;

    protected IMAPMessage(IMAPFolder iMAPFolder, int i2, int i3) {
        super((Folder) iMAPFolder, i2);
        this.seqnum = i3;
        this.flags = null;
    }

    protected IMAPMessage(Session session) {
        super(session);
    }

    /* access modifiers changed from: private */
    public BODYSTRUCTURE _getBodyStructure() {
        return this.f21757bs;
    }

    /* access modifiers changed from: private */
    public ENVELOPE _getEnvelope() {
        return this.envelope;
    }

    /* access modifiers changed from: private */
    public Flags _getFlags() {
        return this.flags;
    }

    private InternetAddress[] aaclone(InternetAddress[] internetAddressArr) {
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    /* access modifiers changed from: private */
    public synchronized boolean areHeadersLoaded() {
        return this.headersLoaded;
    }

    private static String craftHeaderCmd(IMAPProtocol iMAPProtocol, String[] strArr) {
        StringBuffer stringBuffer = iMAPProtocol.isREV1() ? new StringBuffer("BODY.PEEK[HEADER.FIELDS (") : new StringBuffer("RFC822.HEADER.LINES (");
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(strArr[i2]);
        }
        stringBuffer.append(iMAPProtocol.isREV1() ? ")]" : ")");
        return stringBuffer.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: com.sun.mail.iap.Response[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: com.sun.mail.iap.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: com.sun.mail.iap.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: com.sun.mail.iap.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: com.sun.mail.imap.protocol.FetchResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: com.sun.mail.imap.protocol.FetchResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: com.sun.mail.iap.Response} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: com.sun.mail.iap.Response[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v56, resolved type: com.sun.mail.imap.protocol.FetchResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: com.sun.mail.iap.Response[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00ef, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01ea A[Catch:{ ConnectionException -> 0x0204, CommandFailedException -> 0x00d7, ProtocolException -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01ef A[Catch:{ ConnectionException -> 0x0204, CommandFailedException -> 0x00d7, ProtocolException -> 0x00cc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void fetch(com.sun.mail.imap.IMAPFolder r17, javax.mail.Message[] r18, javax.mail.FetchProfile r19) throws javax.mail.MessagingException {
        /*
            r1 = r17
            r0 = r19
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            javax.mail.FetchProfile$Item r3 = javax.mail.FetchProfile.Item.ENVELOPE
            boolean r3 = r0.contains((javax.mail.FetchProfile.Item) r3)
            if (r3 == 0) goto L_0x0018
            java.lang.String r3 = EnvelopeCmd
            r2.append(r3)
            r3 = 0
            goto L_0x0019
        L_0x0018:
            r3 = 1
        L_0x0019:
            javax.mail.FetchProfile$Item r6 = javax.mail.FetchProfile.Item.FLAGS
            boolean r6 = r0.contains((javax.mail.FetchProfile.Item) r6)
            if (r6 == 0) goto L_0x002c
            if (r3 == 0) goto L_0x0026
            java.lang.String r3 = "FLAGS"
            goto L_0x0028
        L_0x0026:
            java.lang.String r3 = " FLAGS"
        L_0x0028:
            r2.append(r3)
            r3 = 0
        L_0x002c:
            javax.mail.FetchProfile$Item r6 = javax.mail.FetchProfile.Item.CONTENT_INFO
            boolean r6 = r0.contains((javax.mail.FetchProfile.Item) r6)
            if (r6 == 0) goto L_0x003f
            if (r3 == 0) goto L_0x0039
            java.lang.String r3 = "BODYSTRUCTURE"
            goto L_0x003b
        L_0x0039:
            java.lang.String r3 = " BODYSTRUCTURE"
        L_0x003b:
            r2.append(r3)
            r3 = 0
        L_0x003f:
            javax.mail.UIDFolder$FetchProfileItem r6 = javax.mail.UIDFolder.FetchProfileItem.UID
            boolean r6 = r0.contains((javax.mail.FetchProfile.Item) r6)
            if (r6 == 0) goto L_0x0052
            if (r3 == 0) goto L_0x004c
            java.lang.String r3 = "UID"
            goto L_0x004e
        L_0x004c:
            java.lang.String r3 = " UID"
        L_0x004e:
            r2.append(r3)
            r3 = 0
        L_0x0052:
            com.sun.mail.imap.IMAPFolder$FetchProfileItem r6 = com.sun.mail.imap.IMAPFolder.FetchProfileItem.HEADERS
            boolean r6 = r0.contains((javax.mail.FetchProfile.Item) r6)
            if (r6 == 0) goto L_0x0077
            com.sun.mail.imap.protocol.IMAPProtocol r6 = r1.protocol
            boolean r6 = r6.isREV1()
            if (r6 == 0) goto L_0x006a
            if (r3 == 0) goto L_0x0067
            java.lang.String r3 = "BODY.PEEK[HEADER]"
            goto L_0x0071
        L_0x0067:
            java.lang.String r3 = " BODY.PEEK[HEADER]"
            goto L_0x0071
        L_0x006a:
            if (r3 == 0) goto L_0x006f
            java.lang.String r3 = "RFC822.HEADER"
            goto L_0x0071
        L_0x006f:
            java.lang.String r3 = " RFC822.HEADER"
        L_0x0071:
            r2.append(r3)
            r3 = 0
            r6 = 1
            goto L_0x0078
        L_0x0077:
            r6 = 0
        L_0x0078:
            com.sun.mail.imap.IMAPFolder$FetchProfileItem r7 = com.sun.mail.imap.IMAPFolder.FetchProfileItem.SIZE
            boolean r7 = r0.contains((javax.mail.FetchProfile.Item) r7)
            if (r7 == 0) goto L_0x008b
            if (r3 == 0) goto L_0x0085
            java.lang.String r3 = "RFC822.SIZE"
            goto L_0x0087
        L_0x0085:
            java.lang.String r3 = " RFC822.SIZE"
        L_0x0087:
            r2.append(r3)
            r3 = 0
        L_0x008b:
            r7 = 0
            r8 = r7
            java.lang.String[] r8 = (java.lang.String[]) r8
            if (r6 != 0) goto L_0x00a8
            java.lang.String[] r8 = r19.getHeaderNames()
            int r9 = r8.length
            if (r9 <= 0) goto L_0x00a8
            if (r3 != 0) goto L_0x009f
            java.lang.String r3 = " "
            r2.append(r3)
        L_0x009f:
            com.sun.mail.imap.protocol.IMAPProtocol r3 = r1.protocol
            java.lang.String r3 = craftHeaderCmd(r3, r8)
            r2.append(r3)
        L_0x00a8:
            com.sun.mail.imap.IMAPMessage$1FetchProfileCondition r3 = new com.sun.mail.imap.IMAPMessage$1FetchProfileCondition
            r3.<init>(r0)
            java.lang.Object r9 = r1.messageCacheLock
            monitor-enter(r9)
            r10 = r18
            com.sun.mail.imap.protocol.MessageSet[] r3 = com.sun.mail.imap.Utility.toMessageSet(r10, r3)     // Catch:{ all -> 0x020f }
            if (r3 != 0) goto L_0x00ba
            monitor-exit(r9)     // Catch:{ all -> 0x020f }
            return
        L_0x00ba:
            com.sun.mail.iap.Response[] r7 = (com.sun.mail.iap.Response[]) r7     // Catch:{ all -> 0x020f }
            java.util.Vector r10 = new java.util.Vector     // Catch:{ all -> 0x020f }
            r10.<init>()     // Catch:{ all -> 0x020f }
            com.sun.mail.imap.protocol.IMAPProtocol r11 = r1.protocol     // Catch:{ ConnectionException -> 0x0204, CommandFailedException -> 0x00d7, ProtocolException -> 0x00cc }
            java.lang.String r2 = r2.toString()     // Catch:{ ConnectionException -> 0x0204, CommandFailedException -> 0x00d7, ProtocolException -> 0x00cc }
            com.sun.mail.iap.Response[] r7 = r11.fetch((com.sun.mail.imap.protocol.MessageSet[]) r3, (java.lang.String) r2)     // Catch:{ ConnectionException -> 0x0204, CommandFailedException -> 0x00d7, ProtocolException -> 0x00cc }
            goto L_0x00d8
        L_0x00cc:
            r0 = move-exception
            javax.mail.MessagingException r1 = new javax.mail.MessagingException     // Catch:{ all -> 0x020f }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x020f }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x020f }
            throw r1     // Catch:{ all -> 0x020f }
        L_0x00d7:
        L_0x00d8:
            if (r7 != 0) goto L_0x00dc
            monitor-exit(r9)     // Catch:{ all -> 0x020f }
            return
        L_0x00dc:
            r2 = 0
        L_0x00dd:
            int r3 = r7.length     // Catch:{ all -> 0x020f }
            if (r2 < r3) goto L_0x00f0
            int r0 = r10.size()     // Catch:{ all -> 0x020f }
            if (r0 == 0) goto L_0x00ee
            com.sun.mail.iap.Response[] r0 = new com.sun.mail.iap.Response[r0]     // Catch:{ all -> 0x020f }
            r10.copyInto(r0)     // Catch:{ all -> 0x020f }
            r1.handleResponses(r0)     // Catch:{ all -> 0x020f }
        L_0x00ee:
            monitor-exit(r9)     // Catch:{ all -> 0x020f }
            return
        L_0x00f0:
            r3 = r7[r2]     // Catch:{ all -> 0x020f }
            if (r3 != 0) goto L_0x00f5
            goto L_0x0118
        L_0x00f5:
            r3 = r7[r2]     // Catch:{ all -> 0x020f }
            boolean r3 = r3 instanceof com.sun.mail.imap.protocol.FetchResponse     // Catch:{ all -> 0x020f }
            if (r3 != 0) goto L_0x0101
            r3 = r7[r2]     // Catch:{ all -> 0x020f }
        L_0x00fd:
            r10.addElement(r3)     // Catch:{ all -> 0x020f }
            goto L_0x0118
        L_0x0101:
            r3 = r7[r2]     // Catch:{ all -> 0x020f }
            com.sun.mail.imap.protocol.FetchResponse r3 = (com.sun.mail.imap.protocol.FetchResponse) r3     // Catch:{ all -> 0x020f }
            int r11 = r3.getNumber()     // Catch:{ all -> 0x020f }
            com.sun.mail.imap.IMAPMessage r11 = r1.getMessageBySeqNumber(r11)     // Catch:{ all -> 0x020f }
            int r12 = r3.getItemCount()     // Catch:{ all -> 0x020f }
            r13 = 0
            r14 = 0
        L_0x0113:
            if (r13 < r12) goto L_0x011b
            if (r14 == 0) goto L_0x0118
            goto L_0x00fd
        L_0x0118:
            int r2 = r2 + 1
            goto L_0x00dd
        L_0x011b:
            com.sun.mail.imap.protocol.Item r15 = r3.getItem((int) r13)     // Catch:{ all -> 0x020f }
            boolean r5 = r15 instanceof javax.mail.Flags     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x013b
            javax.mail.FetchProfile$Item r5 = javax.mail.FetchProfile.Item.FLAGS     // Catch:{ all -> 0x020f }
            boolean r5 = r0.contains((javax.mail.FetchProfile.Item) r5)     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x0133
            if (r11 != 0) goto L_0x012e
            goto L_0x0133
        L_0x012e:
            javax.mail.Flags r15 = (javax.mail.Flags) r15     // Catch:{ all -> 0x020f }
            r11.flags = r15     // Catch:{ all -> 0x020f }
            goto L_0x0143
        L_0x0133:
            r18 = r2
            r16 = r3
            r2 = 1
            r14 = 1
            goto L_0x01f4
        L_0x013b:
            boolean r5 = r15 instanceof com.sun.mail.imap.protocol.ENVELOPE     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x014a
            com.sun.mail.imap.protocol.ENVELOPE r15 = (com.sun.mail.imap.protocol.ENVELOPE) r15     // Catch:{ all -> 0x020f }
            r11.envelope = r15     // Catch:{ all -> 0x020f }
        L_0x0143:
            r18 = r2
            r16 = r3
        L_0x0147:
            r2 = 1
            goto L_0x01f4
        L_0x014a:
            boolean r5 = r15 instanceof com.sun.mail.imap.protocol.INTERNALDATE     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x0157
            com.sun.mail.imap.protocol.INTERNALDATE r15 = (com.sun.mail.imap.protocol.INTERNALDATE) r15     // Catch:{ all -> 0x020f }
            java.util.Date r5 = r15.getDate()     // Catch:{ all -> 0x020f }
            r11.receivedDate = r5     // Catch:{ all -> 0x020f }
            goto L_0x0143
        L_0x0157:
            boolean r5 = r15 instanceof com.sun.mail.imap.protocol.RFC822SIZE     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x0162
            com.sun.mail.imap.protocol.RFC822SIZE r15 = (com.sun.mail.imap.protocol.RFC822SIZE) r15     // Catch:{ all -> 0x020f }
            int r5 = r15.size     // Catch:{ all -> 0x020f }
            r11.size = r5     // Catch:{ all -> 0x020f }
            goto L_0x0143
        L_0x0162:
            boolean r5 = r15 instanceof com.sun.mail.imap.protocol.BODYSTRUCTURE     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x016b
            com.sun.mail.imap.protocol.BODYSTRUCTURE r15 = (com.sun.mail.imap.protocol.BODYSTRUCTURE) r15     // Catch:{ all -> 0x020f }
            r11.f21757bs = r15     // Catch:{ all -> 0x020f }
            goto L_0x0143
        L_0x016b:
            boolean r5 = r15 instanceof com.sun.mail.imap.protocol.UID     // Catch:{ all -> 0x020f }
            if (r5 == 0) goto L_0x0191
            com.sun.mail.imap.protocol.UID r15 = (com.sun.mail.imap.protocol.UID) r15     // Catch:{ all -> 0x020f }
            long r4 = r15.uid     // Catch:{ all -> 0x020f }
            r11.uid = r4     // Catch:{ all -> 0x020f }
            java.util.Hashtable r4 = r1.uidTable     // Catch:{ all -> 0x020f }
            if (r4 != 0) goto L_0x0180
            java.util.Hashtable r4 = new java.util.Hashtable     // Catch:{ all -> 0x020f }
            r4.<init>()     // Catch:{ all -> 0x020f }
            r1.uidTable = r4     // Catch:{ all -> 0x020f }
        L_0x0180:
            java.util.Hashtable r4 = r1.uidTable     // Catch:{ all -> 0x020f }
            java.lang.Long r5 = new java.lang.Long     // Catch:{ all -> 0x020f }
            r18 = r2
            r16 = r3
            long r2 = r15.uid     // Catch:{ all -> 0x020f }
            r5.<init>(r2)     // Catch:{ all -> 0x020f }
            r4.put(r5, r11)     // Catch:{ all -> 0x020f }
            goto L_0x0147
        L_0x0191:
            r18 = r2
            r16 = r3
            boolean r2 = r15 instanceof com.sun.mail.imap.protocol.RFC822DATA     // Catch:{ all -> 0x020f }
            if (r2 != 0) goto L_0x019d
            boolean r2 = r15 instanceof com.sun.mail.imap.protocol.BODY     // Catch:{ all -> 0x020f }
            if (r2 == 0) goto L_0x0147
        L_0x019d:
            boolean r2 = r15 instanceof com.sun.mail.imap.protocol.RFC822DATA     // Catch:{ all -> 0x020f }
            if (r2 == 0) goto L_0x01a8
            com.sun.mail.imap.protocol.RFC822DATA r15 = (com.sun.mail.imap.protocol.RFC822DATA) r15     // Catch:{ all -> 0x020f }
            java.io.ByteArrayInputStream r2 = r15.getByteArrayInputStream()     // Catch:{ all -> 0x020f }
            goto L_0x01ae
        L_0x01a8:
            com.sun.mail.imap.protocol.BODY r15 = (com.sun.mail.imap.protocol.BODY) r15     // Catch:{ all -> 0x020f }
            java.io.ByteArrayInputStream r2 = r15.getByteArrayInputStream()     // Catch:{ all -> 0x020f }
        L_0x01ae:
            javax.mail.internet.InternetHeaders r3 = new javax.mail.internet.InternetHeaders     // Catch:{ all -> 0x020f }
            r3.<init>()     // Catch:{ all -> 0x020f }
            r3.load(r2)     // Catch:{ all -> 0x020f }
            javax.mail.internet.InternetHeaders r2 = r11.headers     // Catch:{ all -> 0x020f }
            if (r2 == 0) goto L_0x01e6
            if (r6 == 0) goto L_0x01bd
            goto L_0x01e6
        L_0x01bd:
            java.util.Enumeration r2 = r3.getAllHeaders()     // Catch:{ all -> 0x020f }
        L_0x01c1:
            boolean r3 = r2.hasMoreElements()     // Catch:{ all -> 0x020f }
            if (r3 != 0) goto L_0x01c8
            goto L_0x01e8
        L_0x01c8:
            java.lang.Object r3 = r2.nextElement()     // Catch:{ all -> 0x020f }
            javax.mail.Header r3 = (javax.mail.Header) r3     // Catch:{ all -> 0x020f }
            java.lang.String r4 = r3.getName()     // Catch:{ all -> 0x020f }
            boolean r4 = r11.isHeaderLoaded(r4)     // Catch:{ all -> 0x020f }
            if (r4 != 0) goto L_0x01c1
            javax.mail.internet.InternetHeaders r4 = r11.headers     // Catch:{ all -> 0x020f }
            java.lang.String r5 = r3.getName()     // Catch:{ all -> 0x020f }
            java.lang.String r3 = r3.getValue()     // Catch:{ all -> 0x020f }
            r4.addHeader(r5, r3)     // Catch:{ all -> 0x020f }
            goto L_0x01c1
        L_0x01e6:
            r11.headers = r3     // Catch:{ all -> 0x020f }
        L_0x01e8:
            if (r6 == 0) goto L_0x01ef
            r2 = 1
            r11.setHeadersLoaded(r2)     // Catch:{ all -> 0x020f }
            goto L_0x01f4
        L_0x01ef:
            r2 = 1
            r3 = 0
        L_0x01f1:
            int r4 = r8.length     // Catch:{ all -> 0x020f }
            if (r3 < r4) goto L_0x01fc
        L_0x01f4:
            int r13 = r13 + 1
            r2 = r18
            r3 = r16
            goto L_0x0113
        L_0x01fc:
            r4 = r8[r3]     // Catch:{ all -> 0x020f }
            r11.setHeaderLoaded(r4)     // Catch:{ all -> 0x020f }
            int r3 = r3 + 1
            goto L_0x01f1
        L_0x0204:
            r0 = move-exception
            javax.mail.FolderClosedException r2 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x020f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x020f }
            r2.<init>(r1, r0)     // Catch:{ all -> 0x020f }
            throw r2     // Catch:{ all -> 0x020f }
        L_0x020f:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x020f }
            goto L_0x0213
        L_0x0212:
            throw r0
        L_0x0213:
            goto L_0x0212
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPMessage.fetch(com.sun.mail.imap.IMAPFolder, javax.mail.Message[], javax.mail.FetchProfile):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return r0 != null ? r0.containsKey(r3.toUpperCase(java.util.Locale.ENGLISH)) : false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isHeaderLoaded(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.headersLoaded     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0008
            r3 = 1
            monitor-exit(r2)
            return r3
        L_0x0008:
            java.util.Hashtable r0 = r2.loadedHeaders     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0017
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x001a }
            java.lang.String r3 = r3.toUpperCase(r1)     // Catch:{ all -> 0x001a }
            boolean r3 = r0.containsKey(r3)     // Catch:{ all -> 0x001a }
            goto L_0x0018
        L_0x0017:
            r3 = 0
        L_0x0018:
            monitor-exit(r2)
            return r3
        L_0x001a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPMessage.isHeaderLoaded(java.lang.String):boolean");
    }

    private synchronized void loadBODYSTRUCTURE() throws MessagingException {
        if (this.f21757bs == null) {
            synchronized (getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    BODYSTRUCTURE fetchBodyStructure = protocol.fetchBodyStructure(getSequenceNumber());
                    this.f21757bs = fetchBodyStructure;
                    if (fetchBodyStructure == null) {
                        forceCheckExpunged();
                        throw new MessagingException("Unable to load BODYSTRUCTURE");
                    }
                } catch (ConnectionException e2) {
                    throw new FolderClosedException(this.folder, e2.getMessage());
                } catch (ProtocolException e3) {
                    forceCheckExpunged();
                    throw new MessagingException(e3.getMessage(), e3);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        return;
    }

    private synchronized void loadEnvelope() throws MessagingException {
        if (this.envelope == null) {
            Response[] responseArr = null;
            synchronized (getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    int sequenceNumber = getSequenceNumber();
                    Response[] fetch = protocol.fetch(sequenceNumber, EnvelopeCmd);
                    for (int i2 = 0; i2 < fetch.length; i2++) {
                        if (fetch[i2] != null && (fetch[i2] instanceof FetchResponse)) {
                            if (((FetchResponse) fetch[i2]).getNumber() == sequenceNumber) {
                                FetchResponse fetchResponse = (FetchResponse) fetch[i2];
                                int itemCount = fetchResponse.getItemCount();
                                for (int i3 = 0; i3 < itemCount; i3++) {
                                    Item item = fetchResponse.getItem(i3);
                                    if (item instanceof ENVELOPE) {
                                        this.envelope = (ENVELOPE) item;
                                    } else if (item instanceof INTERNALDATE) {
                                        this.receivedDate = ((INTERNALDATE) item).getDate();
                                    } else if (item instanceof RFC822SIZE) {
                                        this.size = ((RFC822SIZE) item).size;
                                    }
                                }
                            }
                        }
                    }
                    protocol.notifyResponseHandlers(fetch);
                    protocol.handleResult(fetch[fetch.length - 1]);
                } catch (ConnectionException e2) {
                    throw new FolderClosedException(this.folder, e2.getMessage());
                } catch (ProtocolException e3) {
                    forceCheckExpunged();
                    throw new MessagingException(e3.getMessage(), e3);
                }
            }
            if (this.envelope == null) {
                throw new MessagingException("Failed to load IMAP envelope");
            }
        }
    }

    private synchronized void loadFlags() throws MessagingException {
        if (this.flags == null) {
            synchronized (getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    this.flags = protocol.fetchFlags(getSequenceNumber());
                } catch (ConnectionException e2) {
                    throw new FolderClosedException(this.folder, e2.getMessage());
                } catch (ProtocolException e3) {
                    forceCheckExpunged();
                    throw new MessagingException(e3.getMessage(), e3);
                }
            }
        }
    }

    private synchronized void loadHeaders() throws MessagingException {
        if (!this.headersLoaded) {
            ByteArrayInputStream byteArrayInputStream = null;
            synchronized (getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    if (protocol.isREV1()) {
                        BODY peekBody = protocol.peekBody(getSequenceNumber(), toSection("HEADER"));
                        if (peekBody != null) {
                            byteArrayInputStream = peekBody.getByteArrayInputStream();
                        }
                    } else {
                        RFC822DATA fetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), "HEADER");
                        if (fetchRFC822 != null) {
                            byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                        }
                    }
                } catch (ConnectionException e2) {
                    throw new FolderClosedException(this.folder, e2.getMessage());
                } catch (ProtocolException e3) {
                    forceCheckExpunged();
                    throw new MessagingException(e3.getMessage(), e3);
                }
            }
            if (byteArrayInputStream != null) {
                this.headers = new InternetHeaders(byteArrayInputStream);
                this.headersLoaded = true;
                return;
            }
            throw new MessagingException("Cannot load header");
        }
    }

    private synchronized void setHeaderLoaded(String str) {
        if (this.loadedHeaders == null) {
            this.loadedHeaders = new Hashtable(1);
        }
        this.loadedHeaders.put(str.toUpperCase(Locale.ENGLISH), str);
    }

    private synchronized void setHeadersLoaded(boolean z2) {
        this.headersLoaded = z2;
    }

    private String toSection(String str) {
        String str2 = this.sectionId;
        if (str2 == null) {
            return str;
        }
        return String.valueOf(str2) + "." + str;
    }

    /* access modifiers changed from: package-private */
    public Session _getSession() {
        return this.session;
    }

    /* access modifiers changed from: package-private */
    public void _setFlags(Flags flags) {
        this.flags = flags;
    }

    public void addFrom(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void addRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* access modifiers changed from: protected */
    public void checkExpunged() throws MessageRemovedException {
        if (this.expunged) {
            throw new MessageRemovedException();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000f */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0014 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void forceCheckExpunged() throws javax.mail.MessageRemovedException, javax.mail.FolderClosedException {
        /*
            r4 = this;
            java.lang.Object r0 = r4.getMessageCacheLock()
            monitor-enter(r0)
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r4.getProtocol()     // Catch:{ ConnectionException -> 0x001b, ProtocolException -> 0x000f }
            r1.noop()     // Catch:{ ConnectionException -> 0x001b, ProtocolException -> 0x000f }
            goto L_0x000f
        L_0x000d:
            r1 = move-exception
            goto L_0x0028
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            boolean r0 = r4.expunged
            if (r0 != 0) goto L_0x0015
            return
        L_0x0015:
            javax.mail.MessageRemovedException r0 = new javax.mail.MessageRemovedException
            r0.<init>()
            throw r0
        L_0x001b:
            r1 = move-exception
            javax.mail.FolderClosedException r2 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x000d }
            javax.mail.Folder r3 = r4.folder     // Catch:{ all -> 0x000d }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x000d }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x000d }
            throw r2     // Catch:{ all -> 0x000d }
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPMessage.forceCheckExpunged():void");
    }

    public Enumeration getAllHeaderLines() throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getAllHeaderLines();
    }

    public Enumeration getAllHeaders() throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getAllHeaders();
    }

    public String getContentID() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.f21757bs.f21758id;
    }

    public String[] getContentLanguage() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        if (this.f21757bs.language != null) {
            return (String[]) this.f21757bs.language.clone();
        }
        return null;
    }

    public String getContentMD5() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.f21757bs.md5;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
        if (r0 == null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0071, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0079, code lost:
        throw new javax.mail.MessagingException("No content");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.InputStream getContentStream() throws javax.mail.MessagingException {
        /*
            r6 = this;
            boolean r0 = r6.getPeek()
            java.lang.Object r1 = r6.getMessageCacheLock()
            monitor-enter(r1)
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r6.getProtocol()     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            r6.checkExpunged()     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            boolean r3 = r2.isREV1()     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            if (r3 == 0) goto L_0x0030
            int r3 = r6.getFetchBlockSize()     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            r4 = -1
            if (r3 == r4) goto L_0x0030
            com.sun.mail.imap.IMAPInputStream r2 = new com.sun.mail.imap.IMAPInputStream     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            java.lang.String r3 = "TEXT"
            java.lang.String r3 = r6.toSection(r3)     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            com.sun.mail.imap.protocol.BODYSTRUCTURE r5 = r6.f21757bs     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            if (r5 == 0) goto L_0x002b
            int r4 = r5.size     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
        L_0x002b:
            r2.<init>(r6, r3, r4, r0)     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            monitor-exit(r1)     // Catch:{ all -> 0x007a }
            return r2
        L_0x0030:
            boolean r3 = r2.isREV1()     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            if (r3 == 0) goto L_0x005c
            if (r0 == 0) goto L_0x0047
            int r0 = r6.getSequenceNumber()     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            java.lang.String r3 = "TEXT"
            java.lang.String r3 = r6.toSection(r3)     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            com.sun.mail.imap.protocol.BODY r0 = r2.peekBody(r0, r3)     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            goto L_0x0055
        L_0x0047:
            int r0 = r6.getSequenceNumber()     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            java.lang.String r3 = "TEXT"
            java.lang.String r3 = r6.toSection(r3)     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            com.sun.mail.imap.protocol.BODY r0 = r2.fetchBody(r0, r3)     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
        L_0x0055:
            if (r0 == 0) goto L_0x006d
            java.io.ByteArrayInputStream r0 = r0.getByteArrayInputStream()     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            goto L_0x006e
        L_0x005c:
            int r0 = r6.getSequenceNumber()     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            java.lang.String r3 = "TEXT"
            com.sun.mail.imap.protocol.RFC822DATA r0 = r2.fetchRFC822(r0, r3)     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            if (r0 == 0) goto L_0x006d
            java.io.ByteArrayInputStream r0 = r0.getByteArrayInputStream()     // Catch:{ ConnectionException -> 0x008a, ProtocolException -> 0x007c }
            goto L_0x006e
        L_0x006d:
            r0 = 0
        L_0x006e:
            monitor-exit(r1)     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0072
            return r0
        L_0x0072:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException
            java.lang.String r1 = "No content"
            r0.<init>(r1)
            throw r0
        L_0x007a:
            r0 = move-exception
            goto L_0x0097
        L_0x007c:
            r0 = move-exception
            r6.forceCheckExpunged()     // Catch:{ all -> 0x007a }
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x007a }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x007a }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x008a:
            r0 = move-exception
            javax.mail.FolderClosedException r2 = new javax.mail.FolderClosedException     // Catch:{ all -> 0x007a }
            javax.mail.Folder r3 = r6.folder     // Catch:{ all -> 0x007a }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x007a }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x0097:
            monitor-exit(r1)     // Catch:{ all -> 0x007a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPMessage.getContentStream():java.io.InputStream");
    }

    public String getContentType() throws MessagingException {
        checkExpunged();
        if (this.type == null) {
            loadBODYSTRUCTURE();
            this.type = new ContentType(this.f21757bs.type, this.f21757bs.subtype, this.f21757bs.cParams).toString();
        }
        return this.type;
    }

    public synchronized DataHandler getDataHandler() throws MessagingException {
        DataHandler dataHandler;
        String str;
        checkExpunged();
        if (this.f29476dh == null) {
            loadBODYSTRUCTURE();
            if (this.type == null) {
                this.type = new ContentType(this.f21757bs.type, this.f21757bs.subtype, this.f21757bs.cParams).toString();
            }
            if (this.f21757bs.isMulti()) {
                dataHandler = new DataHandler((DataSource) new IMAPMultipartDataSource(this, this.f21757bs.bodies, this.sectionId, this));
            } else if (this.f21757bs.isNested() && isREV1()) {
                BODYSTRUCTURE bodystructure = this.f21757bs.bodies[0];
                ENVELOPE envelope2 = this.f21757bs.envelope;
                String str2 = this.sectionId;
                if (str2 == null) {
                    str = "1";
                } else {
                    str = String.valueOf(str2) + ".1";
                }
                dataHandler = new DataHandler(new IMAPNestedMessage(this, bodystructure, envelope2, str), this.type);
            }
            this.f29476dh = dataHandler;
        }
        return super.getDataHandler();
    }

    public String getDescription() throws MessagingException {
        checkExpunged();
        String str = this.description;
        if (str != null) {
            return str;
        }
        loadBODYSTRUCTURE();
        if (this.f21757bs.description == null) {
            return null;
        }
        try {
            this.description = MimeUtility.decodeText(this.f21757bs.description);
        } catch (UnsupportedEncodingException unused) {
            this.description = this.f21757bs.description;
        }
        return this.description;
    }

    public String getDisposition() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.f21757bs.disposition;
    }

    public String getEncoding() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.f21757bs.encoding;
    }

    /* access modifiers changed from: protected */
    public int getFetchBlockSize() {
        return ((IMAPStore) this.folder.getStore()).getFetchBlockSize();
    }

    public String getFileName() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        String str = this.f21757bs.dParams != null ? this.f21757bs.dParams.get("filename") : null;
        return (str != null || this.f21757bs.cParams == null) ? str : this.f21757bs.cParams.get("name");
    }

    public synchronized Flags getFlags() throws MessagingException {
        checkExpunged();
        loadFlags();
        return super.getFlags();
    }

    public Address[] getFrom() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return aaclone(this.envelope.from);
    }

    public String getHeader(String str, String str2) throws MessagingException {
        checkExpunged();
        if (getHeader(str) == null) {
            return null;
        }
        return this.headers.getHeader(str, str2);
    }

    public String[] getHeader(String str) throws MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        checkExpunged();
        if (!isHeaderLoaded(str)) {
            synchronized (getMessageCacheLock()) {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    if (protocol.isREV1()) {
                        BODY peekBody = protocol.peekBody(getSequenceNumber(), toSection("HEADER.FIELDS (" + str + ")"));
                        if (peekBody != null) {
                            byteArrayInputStream = peekBody.getByteArrayInputStream();
                        }
                    } else {
                        RFC822DATA fetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), "HEADER.LINES (" + str + ")");
                        if (fetchRFC822 != null) {
                            byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                        }
                    }
                    byteArrayInputStream = null;
                } catch (ConnectionException e2) {
                    throw new FolderClosedException(this.folder, e2.getMessage());
                } catch (ProtocolException e3) {
                    forceCheckExpunged();
                    throw new MessagingException(e3.getMessage(), e3);
                }
            }
            if (byteArrayInputStream == null) {
                return null;
            }
            if (this.headers == null) {
                this.headers = new InternetHeaders();
            }
            this.headers.load(byteArrayInputStream);
            setHeaderLoaded(str);
        }
        return this.headers.getHeader(str);
    }

    public String getInReplyTo() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return this.envelope.inReplyTo;
    }

    public int getLineCount() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.f21757bs.lines;
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getMatchingHeaderLines(strArr);
    }

    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getMatchingHeaders(strArr);
    }

    /* access modifiers changed from: protected */
    public Object getMessageCacheLock() {
        return ((IMAPFolder) this.folder).messageCacheLock;
    }

    public String getMessageID() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return this.envelope.messageId;
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getNonMatchingHeaderLines(strArr);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getNonMatchingHeaders(strArr);
    }

    public synchronized boolean getPeek() {
        return this.peek;
    }

    /* access modifiers changed from: protected */
    public IMAPProtocol getProtocol() throws ProtocolException, FolderClosedException {
        ((IMAPFolder) this.folder).waitIfIdle();
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).protocol;
        if (iMAPProtocol != null) {
            return iMAPProtocol;
        }
        throw new FolderClosedException(this.folder);
    }

    public Date getReceivedDate() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        if (this.receivedDate == null) {
            return null;
        }
        return new Date(this.receivedDate.getTime());
    }

    public Address[] getRecipients(Message.RecipientType recipientType) throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return recipientType == Message.RecipientType.TO ? aaclone(this.envelope.to) : recipientType == Message.RecipientType.CC ? aaclone(this.envelope.f21759cc) : recipientType == Message.RecipientType.BCC ? aaclone(this.envelope.bcc) : super.getRecipients(recipientType);
    }

    public Address[] getReplyTo() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        return aaclone(this.envelope.replyTo);
    }

    public Address getSender() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        if (this.envelope.sender != null) {
            return this.envelope.sender[0];
        }
        return null;
    }

    public Date getSentDate() throws MessagingException {
        checkExpunged();
        loadEnvelope();
        if (this.envelope.date == null) {
            return null;
        }
        return new Date(this.envelope.date.getTime());
    }

    /* access modifiers changed from: protected */
    public int getSequenceNumber() {
        return this.seqnum;
    }

    public int getSize() throws MessagingException {
        checkExpunged();
        if (this.size == -1) {
            loadEnvelope();
        }
        return this.size;
    }

    public String getSubject() throws MessagingException {
        checkExpunged();
        String str = this.subject;
        if (str != null) {
            return str;
        }
        loadEnvelope();
        if (this.envelope.subject == null) {
            return null;
        }
        try {
            this.subject = MimeUtility.decodeText(this.envelope.subject);
        } catch (UnsupportedEncodingException unused) {
            this.subject = this.envelope.subject;
        }
        return this.subject;
    }

    /* access modifiers changed from: protected */
    public long getUID() {
        return this.uid;
    }

    public synchronized void invalidateHeaders() {
        this.headersLoaded = false;
        this.loadedHeaders = null;
        this.envelope = null;
        this.f21757bs = null;
        this.receivedDate = null;
        this.size = -1;
        this.type = null;
        this.subject = null;
        this.description = null;
    }

    /* access modifiers changed from: protected */
    public boolean isREV1() throws FolderClosedException {
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).protocol;
        if (iMAPProtocol != null) {
            return iMAPProtocol.isREV1();
        }
        throw new FolderClosedException(this.folder);
    }

    public synchronized boolean isSet(Flags.Flag flag) throws MessagingException {
        checkExpunged();
        loadFlags();
        return super.isSet(flag);
    }

    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setContentID(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setContentLanguage(String[] strArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* access modifiers changed from: protected */
    public void setExpunged(boolean z2) {
        super.setExpunged(z2);
        this.seqnum = -1;
    }

    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public synchronized void setFlags(Flags flags, boolean z2) throws MessagingException {
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                protocol.storeFlags(getSequenceNumber(), flags, z2);
            } catch (ConnectionException e2) {
                throw new FolderClosedException(this.folder, e2.getMessage());
            } catch (ProtocolException e3) {
                throw new MessagingException(e3.getMessage(), e3);
            }
        }
    }

    public void setFrom(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* access modifiers changed from: protected */
    public void setMessageNumber(int i2) {
        super.setMessageNumber(i2);
    }

    public synchronized void setPeek(boolean z2) {
        this.peek = z2;
    }

    public void setRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setReplyTo(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setSender(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public void setSentDate(Date date) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* access modifiers changed from: protected */
    public void setSequenceNumber(int i2) {
        this.seqnum = i2;
    }

    public void setSubject(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* access modifiers changed from: protected */
    public void setUID(long j2) {
        this.uid = j2;
    }

    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        boolean peek2 = getPeek();
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                byteArrayInputStream = null;
                if (protocol.isREV1()) {
                    BODY peekBody = peek2 ? protocol.peekBody(getSequenceNumber(), this.sectionId) : protocol.fetchBody(getSequenceNumber(), this.sectionId);
                    if (peekBody != null) {
                        byteArrayInputStream = peekBody.getByteArrayInputStream();
                    }
                } else {
                    RFC822DATA fetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), (String) null);
                    if (fetchRFC822 != null) {
                        byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                    }
                }
            } catch (ConnectionException e2) {
                throw new FolderClosedException(this.folder, e2.getMessage());
            } catch (ProtocolException e3) {
                forceCheckExpunged();
                throw new MessagingException(e3.getMessage(), e3);
            }
        }
        if (byteArrayInputStream != null) {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } else {
            throw new MessagingException("No content");
        }
    }
}
