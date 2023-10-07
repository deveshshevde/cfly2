package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.MultipartDataSource;

public class MimeMultipart extends Multipart {
    private static boolean bmparse = true;
    private static boolean ignoreMissingBoundaryParameter = true;
    private static boolean ignoreMissingEndBoundary = true;
    private boolean complete;

    /* renamed from: ds  reason: collision with root package name */
    protected DataSource f29477ds;
    protected boolean parsed;
    private String preamble;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025 A[Catch:{ SecurityException -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[Catch:{ SecurityException -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0038 A[Catch:{ SecurityException -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039 A[Catch:{ SecurityException -> 0x003c }] */
    static {
        /*
            java.lang.String r0 = "mail.mime.multipart.ignoremissingendboundary"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x003c }
            r1 = 0
            java.lang.String r2 = "false"
            r3 = 1
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x003c }
            if (r0 == 0) goto L_0x0014
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 1
        L_0x0015:
            ignoreMissingEndBoundary = r0     // Catch:{ SecurityException -> 0x003c }
            java.lang.String r0 = "mail.mime.multipart.ignoremissingboundaryparameter"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x003c }
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x003c }
            if (r0 == 0) goto L_0x0027
            r0 = 0
            goto L_0x0028
        L_0x0027:
            r0 = 1
        L_0x0028:
            ignoreMissingBoundaryParameter = r0     // Catch:{ SecurityException -> 0x003c }
            java.lang.String r0 = "mail.mime.multipart.bmparse"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x003c }
            if (r0 == 0) goto L_0x0039
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ SecurityException -> 0x003c }
            if (r0 == 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r1 = 1
        L_0x003a:
            bmparse = r1     // Catch:{ SecurityException -> 0x003c }
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.<clinit>():void");
    }

    public MimeMultipart() {
        this("mixed");
    }

    public MimeMultipart(String str) {
        this.f29477ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        String uniqueBoundaryValue = UniqueValue.getUniqueBoundaryValue();
        ContentType contentType = new ContentType("multipart", str, (ParameterList) null);
        contentType.setParameter("boundary", uniqueBoundaryValue);
        this.contentType = contentType.toString();
    }

    public MimeMultipart(DataSource dataSource) throws MessagingException {
        this.f29477ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        if (dataSource instanceof MessageAware) {
            setParent(((MessageAware) dataSource).getMessageContext().getPart());
        }
        if (dataSource instanceof MultipartDataSource) {
            setMultipartDataSource((MultipartDataSource) dataSource);
            return;
        }
        this.parsed = false;
        this.f29477ds = dataSource;
        this.contentType = dataSource.getContentType();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cd, code lost:
        if (ignoreMissingEndBoundary == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00cf, code lost:
        r1.complete = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00df, code lost:
        throw new javax.mail.MessagingException("missing multipart end boundary");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:211:0x033d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00d4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x016c A[Catch:{ Exception -> 0x0346, IOException -> 0x0331, all -> 0x032f }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0178 A[Catch:{ Exception -> 0x0346, IOException -> 0x0331, all -> 0x032f }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0186 A[Catch:{ Exception -> 0x0346, IOException -> 0x0331, all -> 0x032f }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0191 A[Catch:{ Exception -> 0x0346, IOException -> 0x0331, all -> 0x032f }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01a1 A[Catch:{ Exception -> 0x0346, IOException -> 0x0331, all -> 0x032f }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01b0 A[Catch:{ Exception -> 0x0346, IOException -> 0x0331, all -> 0x032f }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0212 A[Catch:{ Exception -> 0x0346, IOException -> 0x0331, all -> 0x032f }, LOOP:8: B:128:0x01a3->B:155:0x0212, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x00cb A[EDGE_INSN: B:236:0x00cb->B:64:0x00cb ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x01af A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x01ab A[EDGE_INSN: B:251:0x01ab->B:132:0x01ab ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e0 A[Catch:{ Exception -> 0x0346, IOException -> 0x0331, all -> 0x032f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void parsebm() throws javax.mail.MessagingException {
        /*
            r31 = this;
            r1 = r31
            monitor-enter(r31)
            boolean r0 = r1.parsed     // Catch:{ all -> 0x034f }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r31)
            return
        L_0x0009:
            javax.activation.DataSource r0 = r1.f29477ds     // Catch:{ Exception -> 0x0346 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ Exception -> 0x0346 }
            boolean r2 = r0 instanceof java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0346 }
            if (r2 != 0) goto L_0x0021
            boolean r2 = r0 instanceof java.io.BufferedInputStream     // Catch:{ Exception -> 0x0346 }
            if (r2 != 0) goto L_0x0021
            boolean r2 = r0 instanceof javax.mail.internet.SharedInputStream     // Catch:{ Exception -> 0x0346 }
            if (r2 != 0) goto L_0x0021
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0346 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0346 }
            goto L_0x0022
        L_0x0021:
            r2 = r0
        L_0x0022:
            boolean r0 = r2 instanceof javax.mail.internet.SharedInputStream     // Catch:{ all -> 0x034f }
            if (r0 == 0) goto L_0x002b
            r0 = r2
            javax.mail.internet.SharedInputStream r0 = (javax.mail.internet.SharedInputStream) r0     // Catch:{ all -> 0x034f }
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            javax.mail.internet.ContentType r4 = new javax.mail.internet.ContentType     // Catch:{ all -> 0x034f }
            java.lang.String r5 = r1.contentType     // Catch:{ all -> 0x034f }
            r4.<init>(r5)     // Catch:{ all -> 0x034f }
            java.lang.String r5 = "boundary"
            java.lang.String r4 = r4.getParameter(r5)     // Catch:{ all -> 0x034f }
            if (r4 == 0) goto L_0x004a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x034f }
            java.lang.String r6 = "--"
            r5.<init>(r6)     // Catch:{ all -> 0x034f }
            r5.append(r4)     // Catch:{ all -> 0x034f }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x034f }
            goto L_0x004f
        L_0x004a:
            boolean r4 = ignoreMissingBoundaryParameter     // Catch:{ all -> 0x034f }
            if (r4 == 0) goto L_0x033e
            r4 = 0
        L_0x004f:
            com.sun.mail.util.LineInputStream r5 = new com.sun.mail.util.LineInputStream     // Catch:{ IOException -> 0x0331 }
            r5.<init>(r2)     // Catch:{ IOException -> 0x0331 }
            r6 = 0
            r7 = 0
        L_0x0056:
            java.lang.String r8 = r5.readLine()     // Catch:{ IOException -> 0x0331 }
            r9 = 9
            r10 = 32
            r12 = 0
            r13 = 1
            if (r8 != 0) goto L_0x0063
            goto L_0x008f
        L_0x0063:
            int r14 = r8.length()     // Catch:{ IOException -> 0x0331 }
            int r14 = r14 - r13
        L_0x0068:
            if (r14 >= 0) goto L_0x006b
            goto L_0x0073
        L_0x006b:
            char r15 = r8.charAt(r14)     // Catch:{ IOException -> 0x0331 }
            if (r15 == r10) goto L_0x031c
            if (r15 == r9) goto L_0x031c
        L_0x0073:
            int r14 = r14 + 1
            java.lang.String r8 = r8.substring(r12, r14)     // Catch:{ IOException -> 0x0331 }
            if (r4 == 0) goto L_0x0086
            boolean r14 = r8.equals(r4)     // Catch:{ IOException -> 0x0331 }
            if (r14 == 0) goto L_0x0082
            goto L_0x008f
        L_0x0082:
            r26 = r5
            goto L_0x02f0
        L_0x0086:
            java.lang.String r14 = "--"
            boolean r14 = r8.startsWith(r14)     // Catch:{ IOException -> 0x0331 }
            if (r14 == 0) goto L_0x0082
            r4 = r8
        L_0x008f:
            if (r8 == 0) goto L_0x02e8
            if (r6 == 0) goto L_0x0099
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0331 }
            r1.preamble = r6     // Catch:{ IOException -> 0x0331 }
        L_0x0099:
            byte[] r4 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r4)     // Catch:{ IOException -> 0x0331 }
            int r6 = r4.length     // Catch:{ IOException -> 0x0331 }
            r7 = 256(0x100, float:3.59E-43)
            int[] r7 = new int[r7]     // Catch:{ IOException -> 0x0331 }
            r8 = 0
        L_0x00a3:
            if (r8 < r6) goto L_0x02cd
            int[] r8 = new int[r6]     // Catch:{ IOException -> 0x0331 }
            r14 = r6
        L_0x00a8:
            if (r14 > 0) goto L_0x0299
            int r14 = r6 + -1
            r8[r14] = r13     // Catch:{ IOException -> 0x0331 }
            r15 = 0
            r17 = r15
            r19 = 0
        L_0x00b4:
            if (r19 == 0) goto L_0x00b7
            goto L_0x00d1
        L_0x00b7:
            if (r0 == 0) goto L_0x00e4
            long r15 = r0.getPosition()     // Catch:{ IOException -> 0x0331 }
        L_0x00bd:
            java.lang.String r20 = r5.readLine()     // Catch:{ IOException -> 0x0331 }
            if (r20 == 0) goto L_0x00c9
            int r21 = r20.length()     // Catch:{ IOException -> 0x0331 }
            if (r21 > 0) goto L_0x00bd
        L_0x00c9:
            if (r20 != 0) goto L_0x00e0
            boolean r0 = ignoreMissingEndBoundary     // Catch:{ IOException -> 0x0331 }
            if (r0 == 0) goto L_0x00d8
            r1.complete = r12     // Catch:{ IOException -> 0x0331 }
        L_0x00d1:
            r2.close()     // Catch:{ IOException -> 0x00d4 }
        L_0x00d4:
            r1.parsed = r13     // Catch:{ all -> 0x034f }
            monitor-exit(r31)
            return
        L_0x00d8:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x0331 }
            java.lang.String r3 = "missing multipart end boundary"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0331 }
            throw r0     // Catch:{ IOException -> 0x0331 }
        L_0x00e0:
            r22 = r15
            r15 = 0
            goto L_0x00ec
        L_0x00e4:
            javax.mail.internet.InternetHeaders r20 = r1.createInternetHeaders(r2)     // Catch:{ IOException -> 0x0331 }
            r22 = r15
            r15 = r20
        L_0x00ec:
            boolean r16 = r2.markSupported()     // Catch:{ IOException -> 0x0331 }
            if (r16 == 0) goto L_0x0291
            if (r0 != 0) goto L_0x00fc
            java.io.ByteArrayOutputStream r16 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0331 }
            r16.<init>()     // Catch:{ IOException -> 0x0331 }
            r3 = r16
            goto L_0x0101
        L_0x00fc:
            long r17 = r0.getPosition()     // Catch:{ IOException -> 0x0331 }
            r3 = 0
        L_0x0101:
            byte[] r9 = new byte[r6]     // Catch:{ IOException -> 0x0331 }
            byte[] r10 = new byte[r6]     // Catch:{ IOException -> 0x0331 }
            r13 = 0
            r24 = 1
        L_0x0108:
            int r11 = r6 + 4
            int r11 = r11 + 1000
            r2.mark(r11)     // Catch:{ IOException -> 0x0331 }
            int r11 = readFully(r2, r9, r12, r6)     // Catch:{ IOException -> 0x0331 }
            if (r11 >= r6) goto L_0x0136
            boolean r19 = ignoreMissingEndBoundary     // Catch:{ IOException -> 0x0331 }
            if (r19 == 0) goto L_0x012e
            if (r0 == 0) goto L_0x011f
            long r17 = r0.getPosition()     // Catch:{ IOException -> 0x0331 }
        L_0x011f:
            r1.complete = r12     // Catch:{ IOException -> 0x0331 }
            r26 = r5
            r12 = r7
            r28 = r8
            r7 = r17
            r19 = 1
            r29 = 0
            goto L_0x01c3
        L_0x012e:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x0331 }
            java.lang.String r3 = "missing multipart end boundary"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0331 }
            throw r0     // Catch:{ IOException -> 0x0331 }
        L_0x0136:
            r25 = r14
        L_0x0138:
            if (r25 >= 0) goto L_0x013d
            r26 = r5
            goto L_0x0145
        L_0x013d:
            byte r12 = r9[r25]     // Catch:{ IOException -> 0x0331 }
            r26 = r5
            byte r5 = r4[r25]     // Catch:{ IOException -> 0x0331 }
            if (r12 == r5) goto L_0x0284
        L_0x0145:
            if (r25 >= 0) goto L_0x021f
            r5 = 13
            if (r24 != 0) goto L_0x0169
            int r25 = r13 + -1
            byte r12 = r10[r25]     // Catch:{ IOException -> 0x0331 }
            if (r12 == r5) goto L_0x0156
            r5 = 10
            if (r12 != r5) goto L_0x0169
            goto L_0x0158
        L_0x0156:
            r5 = 10
        L_0x0158:
            if (r12 != r5) goto L_0x0167
            r5 = 2
            if (r13 < r5) goto L_0x0167
            int r5 = r13 + -2
            byte r5 = r10[r5]     // Catch:{ IOException -> 0x0331 }
            r12 = 13
            if (r5 != r12) goto L_0x0167
            r5 = 2
            goto L_0x016a
        L_0x0167:
            r5 = 1
            goto L_0x016a
        L_0x0169:
            r5 = 0
        L_0x016a:
            if (r24 != 0) goto L_0x0176
            if (r5 <= 0) goto L_0x016f
            goto L_0x0176
        L_0x016f:
            r27 = r4
            r12 = r7
            r28 = r8
            goto L_0x020f
        L_0x0176:
            if (r0 == 0) goto L_0x0186
            long r17 = r0.getPosition()     // Catch:{ IOException -> 0x0331 }
            r12 = r7
            r28 = r8
            long r7 = (long) r6     // Catch:{ IOException -> 0x0331 }
            long r17 = r17 - r7
            long r7 = (long) r5     // Catch:{ IOException -> 0x0331 }
            long r17 = r17 - r7
            goto L_0x0189
        L_0x0186:
            r12 = r7
            r28 = r8
        L_0x0189:
            int r7 = r2.read()     // Catch:{ IOException -> 0x0331 }
            r8 = 45
            if (r7 != r8) goto L_0x01a1
            r29 = r5
            int r5 = r2.read()     // Catch:{ IOException -> 0x0331 }
            if (r5 != r8) goto L_0x01a3
            r5 = 1
            r1.complete = r5     // Catch:{ IOException -> 0x0331 }
            r7 = r17
            r19 = 1
            goto L_0x01c3
        L_0x01a1:
            r29 = r5
        L_0x01a3:
            r5 = 32
            if (r7 == r5) goto L_0x0212
            r8 = 9
            if (r7 == r8) goto L_0x0212
            r5 = 10
            if (r7 != r5) goto L_0x01b0
            goto L_0x01c1
        L_0x01b0:
            r8 = 13
            if (r7 != r8) goto L_0x020d
            r7 = 1
            r2.mark(r7)     // Catch:{ IOException -> 0x0331 }
            int r7 = r2.read()     // Catch:{ IOException -> 0x0331 }
            if (r7 == r5) goto L_0x01c1
            r2.reset()     // Catch:{ IOException -> 0x0331 }
        L_0x01c1:
            r7 = r17
        L_0x01c3:
            if (r0 == 0) goto L_0x01d4
            r27 = r4
            r4 = r22
            java.io.InputStream r3 = r0.newStream(r4, r7)     // Catch:{ IOException -> 0x0331 }
            javax.mail.internet.MimeBodyPart r3 = r1.createMimeBodyPart(r3)     // Catch:{ IOException -> 0x0331 }
            r22 = r4
            goto L_0x01f7
        L_0x01d4:
            r27 = r4
            r4 = r22
            int r13 = r13 - r29
            if (r13 <= 0) goto L_0x01e3
            r22 = r4
            r4 = 0
            r3.write(r10, r4, r13)     // Catch:{ IOException -> 0x0331 }
            goto L_0x01e5
        L_0x01e3:
            r22 = r4
        L_0x01e5:
            boolean r4 = r1.complete     // Catch:{ IOException -> 0x0331 }
            if (r4 != 0) goto L_0x01ef
            if (r11 <= 0) goto L_0x01ef
            r4 = 0
            r3.write(r9, r4, r11)     // Catch:{ IOException -> 0x0331 }
        L_0x01ef:
            byte[] r3 = r3.toByteArray()     // Catch:{ IOException -> 0x0331 }
            javax.mail.internet.MimeBodyPart r3 = r1.createMimeBodyPart(r15, r3)     // Catch:{ IOException -> 0x0331 }
        L_0x01f7:
            super.addBodyPart(r3)     // Catch:{ IOException -> 0x0331 }
            r17 = r7
            r7 = r12
            r15 = r22
            r5 = r26
            r4 = r27
            r8 = r28
            r9 = 9
            r10 = 32
            r12 = 0
            r13 = 1
            goto L_0x00b4
        L_0x020d:
            r27 = r4
        L_0x020f:
            r25 = 0
            goto L_0x0224
        L_0x0212:
            r27 = r4
            r4 = 10
            r8 = 13
            int r7 = r2.read()     // Catch:{ IOException -> 0x0331 }
            r4 = r27
            goto L_0x01a3
        L_0x021f:
            r27 = r4
            r12 = r7
            r28 = r8
        L_0x0224:
            int r4 = r25 + 1
            byte r5 = r9[r25]     // Catch:{ IOException -> 0x0331 }
            r5 = r5 & 127(0x7f, float:1.78E-43)
            r5 = r12[r5]     // Catch:{ IOException -> 0x0331 }
            int r4 = r4 - r5
            r5 = r28[r25]     // Catch:{ IOException -> 0x0331 }
            int r4 = java.lang.Math.max(r4, r5)     // Catch:{ IOException -> 0x0331 }
            r5 = 2
            if (r4 >= r5) goto L_0x0260
            if (r0 != 0) goto L_0x0241
            r4 = 1
            if (r13 <= r4) goto L_0x0241
            int r4 = r13 + -1
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x0331 }
        L_0x0241:
            r2.reset()     // Catch:{ IOException -> 0x0331 }
            r4 = 1
            r1.skipFully(r2, r4)     // Catch:{ IOException -> 0x0331 }
            r5 = 1
            if (r13 < r5) goto L_0x0259
            int r13 = r13 + -1
            byte r4 = r10[r13]     // Catch:{ IOException -> 0x0331 }
            r7 = 0
            r10[r7] = r4     // Catch:{ IOException -> 0x0331 }
            byte r4 = r9[r7]     // Catch:{ IOException -> 0x0331 }
            r10[r5] = r4     // Catch:{ IOException -> 0x0331 }
            r13 = 2
            goto L_0x0278
        L_0x0259:
            r4 = 0
            byte r7 = r9[r4]     // Catch:{ IOException -> 0x0331 }
            r10[r4] = r7     // Catch:{ IOException -> 0x0331 }
            r13 = 1
            goto L_0x0278
        L_0x0260:
            r5 = 1
            if (r13 <= 0) goto L_0x026a
            if (r0 != 0) goto L_0x026a
            r7 = 0
            r3.write(r10, r7, r13)     // Catch:{ IOException -> 0x0331 }
            goto L_0x026b
        L_0x026a:
            r7 = 0
        L_0x026b:
            r2.reset()     // Catch:{ IOException -> 0x0331 }
            long r7 = (long) r4     // Catch:{ IOException -> 0x0331 }
            r1.skipFully(r2, r7)     // Catch:{ IOException -> 0x0331 }
            r13 = r4
            r30 = r10
            r10 = r9
            r9 = r30
        L_0x0278:
            r7 = r12
            r5 = r26
            r4 = r27
            r8 = r28
            r12 = 0
            r24 = 0
            goto L_0x0108
        L_0x0284:
            r27 = r4
            r12 = r7
            r28 = r8
            r5 = 1
            int r25 = r25 + -1
            r5 = r26
            r12 = 0
            goto L_0x0138
        L_0x0291:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x0331 }
            java.lang.String r3 = "Stream doesn't support mark"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0331 }
            throw r0     // Catch:{ IOException -> 0x0331 }
        L_0x0299:
            r27 = r4
            r26 = r5
            r12 = r7
            r28 = r8
            r5 = 1
            int r3 = r6 + -1
        L_0x02a3:
            if (r3 >= r14) goto L_0x02ad
        L_0x02a5:
            if (r3 > 0) goto L_0x02a8
            goto L_0x02bc
        L_0x02a8:
            int r3 = r3 + -1
            r28[r3] = r14     // Catch:{ IOException -> 0x0331 }
            goto L_0x02a5
        L_0x02ad:
            byte r4 = r27[r3]     // Catch:{ IOException -> 0x0331 }
            int r7 = r3 - r14
            byte r7 = r27[r7]     // Catch:{ IOException -> 0x0331 }
            if (r4 != r7) goto L_0x02bc
            int r4 = r3 + -1
            r28[r4] = r14     // Catch:{ IOException -> 0x0331 }
            int r3 = r3 + -1
            goto L_0x02a3
        L_0x02bc:
            int r14 = r14 + -1
            r7 = r12
            r5 = r26
            r4 = r27
            r8 = r28
            r9 = 9
            r10 = 32
            r12 = 0
            r13 = 1
            goto L_0x00a8
        L_0x02cd:
            r27 = r4
            r26 = r5
            r12 = r7
            r3 = 9
            r5 = 1
            byte r4 = r27[r8]     // Catch:{ IOException -> 0x0331 }
            int r8 = r8 + 1
            r12[r4] = r8     // Catch:{ IOException -> 0x0331 }
            r7 = r12
            r5 = r26
            r4 = r27
            r9 = 9
            r10 = 32
            r12 = 0
            r13 = 1
            goto L_0x00a3
        L_0x02e8:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x0331 }
            java.lang.String r3 = "Missing start boundary"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0331 }
            throw r0     // Catch:{ IOException -> 0x0331 }
        L_0x02f0:
            int r3 = r8.length()     // Catch:{ IOException -> 0x0331 }
            if (r3 <= 0) goto L_0x0318
            if (r7 != 0) goto L_0x0304
            java.lang.String r3 = "line.separator"
            java.lang.String r5 = "\n"
            java.lang.String r3 = java.lang.System.getProperty(r3, r5)     // Catch:{ SecurityException -> 0x0301 }
            goto L_0x0303
        L_0x0301:
            java.lang.String r3 = "\n"
        L_0x0303:
            r7 = r3
        L_0x0304:
            if (r6 != 0) goto L_0x0312
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x0331 }
            int r5 = r8.length()     // Catch:{ IOException -> 0x0331 }
            r9 = 2
            int r5 = r5 + r9
            r3.<init>(r5)     // Catch:{ IOException -> 0x0331 }
            r6 = r3
        L_0x0312:
            r6.append(r8)     // Catch:{ IOException -> 0x0331 }
            r6.append(r7)     // Catch:{ IOException -> 0x0331 }
        L_0x0318:
            r5 = r26
            goto L_0x0056
        L_0x031c:
            r26 = r5
            r3 = 9
            r5 = 1
            r9 = 2
            r10 = 0
            int r14 = r14 + -1
            r5 = r26
            r9 = 9
            r10 = 32
            r12 = 0
            r13 = 1
            goto L_0x0068
        L_0x032f:
            r0 = move-exception
            goto L_0x033a
        L_0x0331:
            r0 = move-exception
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ all -> 0x032f }
            java.lang.String r4 = "IO Error"
            r3.<init>(r4, r0)     // Catch:{ all -> 0x032f }
            throw r3     // Catch:{ all -> 0x032f }
        L_0x033a:
            r2.close()     // Catch:{ IOException -> 0x033d }
        L_0x033d:
            throw r0     // Catch:{ all -> 0x034f }
        L_0x033e:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ all -> 0x034f }
            java.lang.String r2 = "Missing boundary parameter"
            r0.<init>(r2)     // Catch:{ all -> 0x034f }
            throw r0     // Catch:{ all -> 0x034f }
        L_0x0346:
            r0 = move-exception
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x034f }
            java.lang.String r3 = "No inputstream from datasource"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x034f }
            throw r2     // Catch:{ all -> 0x034f }
        L_0x034f:
            r0 = move-exception
            monitor-exit(r31)
            goto L_0x0353
        L_0x0352:
            throw r0
        L_0x0353:
            goto L_0x0352
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parsebm():void");
    }

    private static int readFully(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        while (i3 > 0) {
            int read = inputStream.read(bArr, i2, i3);
            if (read <= 0) {
                break;
            }
            i2 += read;
            i4 += read;
            i3 -= read;
        }
        if (i4 > 0) {
            return i4;
        }
        return -1;
    }

    private void skipFully(InputStream inputStream, long j2) throws IOException {
        while (j2 > 0) {
            long skip = inputStream.skip(j2);
            if (skip > 0) {
                j2 -= skip;
            } else {
                throw new EOFException("can't skip");
            }
        }
    }

    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart);
    }

    public synchronized void addBodyPart(BodyPart bodyPart, int i2) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart, i2);
    }

    /* access modifiers changed from: protected */
    public InternetHeaders createInternetHeaders(InputStream inputStream) throws MessagingException {
        return new InternetHeaders(inputStream);
    }

    /* access modifiers changed from: protected */
    public MimeBodyPart createMimeBodyPart(InputStream inputStream) throws MessagingException {
        return new MimeBodyPart(inputStream);
    }

    /* access modifiers changed from: protected */
    public MimeBodyPart createMimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        return new MimeBodyPart(internetHeaders, bArr);
    }

    public synchronized BodyPart getBodyPart(int i2) throws MessagingException {
        parse();
        return super.getBodyPart(i2);
    }

    public synchronized BodyPart getBodyPart(String str) throws MessagingException {
        parse();
        int count = getCount();
        for (int i2 = 0; i2 < count; i2++) {
            MimeBodyPart mimeBodyPart = (MimeBodyPart) getBodyPart(i2);
            String contentID = mimeBodyPart.getContentID();
            if (contentID != null && contentID.equals(str)) {
                return mimeBodyPart;
            }
        }
        return null;
    }

    public synchronized int getCount() throws MessagingException {
        parse();
        return super.getCount();
    }

    public synchronized String getPreamble() throws MessagingException {
        parse();
        return this.preamble;
    }

    public synchronized boolean isComplete() throws MessagingException {
        parse();
        return this.complete;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c4, code lost:
        if (ignoreMissingEndBoundary == false) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c6, code lost:
        r1.complete = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00d6, code lost:
        throw new javax.mail.MessagingException("missing multipart end boundary");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:180:0x024f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x00cb */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01b6 A[Catch:{ Exception -> 0x0258, IOException -> 0x0243, all -> 0x0241 }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x00c2 A[EDGE_INSN: B:201:0x00c2->B:66:0x00c2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0186 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d7 A[Catch:{ Exception -> 0x0258, IOException -> 0x0243, all -> 0x0241 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void parse() throws javax.mail.MessagingException {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            boolean r0 = r1.parsed     // Catch:{ all -> 0x0261 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r24)
            return
        L_0x0009:
            boolean r0 = bmparse     // Catch:{ all -> 0x0261 }
            if (r0 == 0) goto L_0x0012
            r24.parsebm()     // Catch:{ all -> 0x0261 }
            monitor-exit(r24)
            return
        L_0x0012:
            javax.activation.DataSource r0 = r1.f29477ds     // Catch:{ Exception -> 0x0258 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ Exception -> 0x0258 }
            boolean r2 = r0 instanceof java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0258 }
            if (r2 != 0) goto L_0x002a
            boolean r2 = r0 instanceof java.io.BufferedInputStream     // Catch:{ Exception -> 0x0258 }
            if (r2 != 0) goto L_0x002a
            boolean r2 = r0 instanceof javax.mail.internet.SharedInputStream     // Catch:{ Exception -> 0x0258 }
            if (r2 != 0) goto L_0x002a
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0258 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0258 }
            goto L_0x002b
        L_0x002a:
            r2 = r0
        L_0x002b:
            boolean r0 = r2 instanceof javax.mail.internet.SharedInputStream     // Catch:{ all -> 0x0261 }
            if (r0 == 0) goto L_0x0034
            r0 = r2
            javax.mail.internet.SharedInputStream r0 = (javax.mail.internet.SharedInputStream) r0     // Catch:{ all -> 0x0261 }
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            javax.mail.internet.ContentType r4 = new javax.mail.internet.ContentType     // Catch:{ all -> 0x0261 }
            java.lang.String r5 = r1.contentType     // Catch:{ all -> 0x0261 }
            r4.<init>(r5)     // Catch:{ all -> 0x0261 }
            java.lang.String r5 = "boundary"
            java.lang.String r4 = r4.getParameter(r5)     // Catch:{ all -> 0x0261 }
            if (r4 == 0) goto L_0x0053
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0261 }
            java.lang.String r6 = "--"
            r5.<init>(r6)     // Catch:{ all -> 0x0261 }
            r5.append(r4)     // Catch:{ all -> 0x0261 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0261 }
            goto L_0x0058
        L_0x0053:
            boolean r4 = ignoreMissingBoundaryParameter     // Catch:{ all -> 0x0261 }
            if (r4 == 0) goto L_0x0250
            r4 = 0
        L_0x0058:
            com.sun.mail.util.LineInputStream r5 = new com.sun.mail.util.LineInputStream     // Catch:{ IOException -> 0x0243 }
            r5.<init>(r2)     // Catch:{ IOException -> 0x0243 }
            r6 = 0
            r7 = 0
        L_0x005f:
            java.lang.String r8 = r5.readLine()     // Catch:{ IOException -> 0x0243 }
            r9 = 9
            r10 = 32
            r11 = 0
            r12 = 1
            if (r8 != 0) goto L_0x006c
            goto L_0x0098
        L_0x006c:
            int r13 = r8.length()     // Catch:{ IOException -> 0x0243 }
            int r13 = r13 - r12
        L_0x0071:
            if (r13 >= 0) goto L_0x0074
            goto L_0x007c
        L_0x0074:
            char r14 = r8.charAt(r13)     // Catch:{ IOException -> 0x0243 }
            if (r14 == r10) goto L_0x0230
            if (r14 == r9) goto L_0x0230
        L_0x007c:
            int r13 = r13 + 1
            java.lang.String r8 = r8.substring(r11, r13)     // Catch:{ IOException -> 0x0243 }
            if (r4 == 0) goto L_0x008f
            boolean r13 = r8.equals(r4)     // Catch:{ IOException -> 0x0243 }
            if (r13 == 0) goto L_0x008b
            goto L_0x0098
        L_0x008b:
            r21 = r5
            goto L_0x0204
        L_0x008f:
            java.lang.String r13 = "--"
            boolean r13 = r8.startsWith(r13)     // Catch:{ IOException -> 0x0243 }
            if (r13 == 0) goto L_0x008b
            r4 = r8
        L_0x0098:
            if (r8 == 0) goto L_0x01fc
            if (r6 == 0) goto L_0x00a2
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0243 }
            r1.preamble = r6     // Catch:{ IOException -> 0x0243 }
        L_0x00a2:
            byte[] r4 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r4)     // Catch:{ IOException -> 0x0243 }
            int r6 = r4.length     // Catch:{ IOException -> 0x0243 }
            r7 = 0
            r13 = r7
            r15 = 0
        L_0x00ab:
            if (r15 == 0) goto L_0x00ae
            goto L_0x00c8
        L_0x00ae:
            if (r0 == 0) goto L_0x00d9
            long r7 = r0.getPosition()     // Catch:{ IOException -> 0x0243 }
        L_0x00b4:
            java.lang.String r16 = r5.readLine()     // Catch:{ IOException -> 0x0243 }
            if (r16 == 0) goto L_0x00c0
            int r17 = r16.length()     // Catch:{ IOException -> 0x0243 }
            if (r17 > 0) goto L_0x00b4
        L_0x00c0:
            if (r16 != 0) goto L_0x00d7
            boolean r0 = ignoreMissingEndBoundary     // Catch:{ IOException -> 0x0243 }
            if (r0 == 0) goto L_0x00cf
            r1.complete = r11     // Catch:{ IOException -> 0x0243 }
        L_0x00c8:
            r2.close()     // Catch:{ IOException -> 0x00cb }
        L_0x00cb:
            r1.parsed = r12     // Catch:{ all -> 0x0261 }
            monitor-exit(r24)
            return
        L_0x00cf:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x0243 }
            java.lang.String r3 = "missing multipart end boundary"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0243 }
            throw r0     // Catch:{ IOException -> 0x0243 }
        L_0x00d7:
            r3 = 0
            goto L_0x00df
        L_0x00d9:
            javax.mail.internet.InternetHeaders r16 = r1.createInternetHeaders(r2)     // Catch:{ IOException -> 0x0243 }
            r3 = r16
        L_0x00df:
            boolean r17 = r2.markSupported()     // Catch:{ IOException -> 0x0243 }
            if (r17 == 0) goto L_0x01f4
            if (r0 != 0) goto L_0x00ef
            java.io.ByteArrayOutputStream r17 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0243 }
            r17.<init>()     // Catch:{ IOException -> 0x0243 }
            r11 = r17
            goto L_0x00f4
        L_0x00ef:
            long r13 = r0.getPosition()     // Catch:{ IOException -> 0x0243 }
            r11 = 0
        L_0x00f4:
            r9 = -1
            r19 = 1
            r20 = -1
        L_0x00f9:
            if (r19 == 0) goto L_0x0177
            int r10 = r6 + 4
            int r10 = r10 + 1000
            r2.mark(r10)     // Catch:{ IOException -> 0x0243 }
            r10 = 0
        L_0x0103:
            if (r10 < r6) goto L_0x0108
            r21 = r5
            goto L_0x0114
        L_0x0108:
            int r12 = r2.read()     // Catch:{ IOException -> 0x0243 }
            r21 = r5
            byte r5 = r4[r10]     // Catch:{ IOException -> 0x0243 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r12 == r5) goto L_0x016c
        L_0x0114:
            if (r10 != r6) goto L_0x0151
            int r5 = r2.read()     // Catch:{ IOException -> 0x0243 }
            r10 = 45
            if (r5 != r10) goto L_0x012a
            int r12 = r2.read()     // Catch:{ IOException -> 0x0243 }
            if (r12 != r10) goto L_0x012a
            r10 = 1
            r1.complete = r10     // Catch:{ IOException -> 0x0243 }
            r12 = 0
            r15 = 1
            goto L_0x0149
        L_0x012a:
            r12 = 32
            if (r5 == r12) goto L_0x014c
            r10 = 9
            if (r5 == r10) goto L_0x014c
            r10 = 10
            if (r5 != r10) goto L_0x0137
            goto L_0x0148
        L_0x0137:
            r12 = 13
            if (r5 != r12) goto L_0x0151
            r5 = 1
            r2.mark(r5)     // Catch:{ IOException -> 0x0243 }
            int r5 = r2.read()     // Catch:{ IOException -> 0x0243 }
            if (r5 == r10) goto L_0x0148
            r2.reset()     // Catch:{ IOException -> 0x0243 }
        L_0x0148:
            r12 = 0
        L_0x0149:
            r18 = 9
            goto L_0x018e
        L_0x014c:
            int r5 = r2.read()     // Catch:{ IOException -> 0x0243 }
            goto L_0x012a
        L_0x0151:
            r2.reset()     // Catch:{ IOException -> 0x0243 }
            if (r11 == 0) goto L_0x0179
            r5 = -1
            if (r9 == r5) goto L_0x0169
            r11.write(r9)     // Catch:{ IOException -> 0x0243 }
            r12 = r20
            if (r12 == r5) goto L_0x0163
            r11.write(r12)     // Catch:{ IOException -> 0x0243 }
        L_0x0163:
            r9 = -1
            r18 = 9
            r20 = -1
            goto L_0x0180
        L_0x0169:
            r12 = r20
            goto L_0x017c
        L_0x016c:
            r12 = r20
            r5 = -1
            r18 = 9
            int r10 = r10 + 1
            r5 = r21
            r12 = 1
            goto L_0x0103
        L_0x0177:
            r21 = r5
        L_0x0179:
            r12 = r20
            r5 = -1
        L_0x017c:
            r18 = 9
            r20 = r12
        L_0x0180:
            int r10 = r2.read()     // Catch:{ IOException -> 0x0243 }
            if (r10 >= 0) goto L_0x01b6
            boolean r5 = ignoreMissingEndBoundary     // Catch:{ IOException -> 0x0243 }
            if (r5 == 0) goto L_0x01ae
            r12 = 0
            r1.complete = r12     // Catch:{ IOException -> 0x0243 }
            r15 = 1
        L_0x018e:
            if (r0 == 0) goto L_0x0199
            java.io.InputStream r3 = r0.newStream(r7, r13)     // Catch:{ IOException -> 0x0243 }
            javax.mail.internet.MimeBodyPart r3 = r1.createMimeBodyPart(r3)     // Catch:{ IOException -> 0x0243 }
            goto L_0x01a1
        L_0x0199:
            byte[] r5 = r11.toByteArray()     // Catch:{ IOException -> 0x0243 }
            javax.mail.internet.MimeBodyPart r3 = r1.createMimeBodyPart(r3, r5)     // Catch:{ IOException -> 0x0243 }
        L_0x01a1:
            super.addBodyPart(r3)     // Catch:{ IOException -> 0x0243 }
            r5 = r21
            r9 = 9
            r10 = 32
            r11 = 0
            r12 = 1
            goto L_0x00ab
        L_0x01ae:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x0243 }
            java.lang.String r3 = "missing multipart end boundary"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0243 }
            throw r0     // Catch:{ IOException -> 0x0243 }
        L_0x01b6:
            r5 = 13
            r12 = 0
            if (r10 == r5) goto L_0x01cc
            r5 = 10
            if (r10 != r5) goto L_0x01c0
            goto L_0x01cc
        L_0x01c0:
            if (r11 == 0) goto L_0x01c5
            r11.write(r10)     // Catch:{ IOException -> 0x0243 }
        L_0x01c5:
            r5 = r21
            r12 = 1
            r19 = 0
            goto L_0x00f9
        L_0x01cc:
            if (r0 == 0) goto L_0x01d6
            long r13 = r0.getPosition()     // Catch:{ IOException -> 0x0243 }
            r22 = 1
            long r13 = r13 - r22
        L_0x01d6:
            r5 = 13
            if (r10 != r5) goto L_0x01ec
            r5 = 1
            r2.mark(r5)     // Catch:{ IOException -> 0x0243 }
            int r9 = r2.read()     // Catch:{ IOException -> 0x0243 }
            r5 = 10
            if (r9 != r5) goto L_0x01e9
            r20 = r9
            goto L_0x01ec
        L_0x01e9:
            r2.reset()     // Catch:{ IOException -> 0x0243 }
        L_0x01ec:
            r9 = r10
            r5 = r21
            r12 = 1
            r19 = 1
            goto L_0x00f9
        L_0x01f4:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x0243 }
            java.lang.String r3 = "Stream doesn't support mark"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0243 }
            throw r0     // Catch:{ IOException -> 0x0243 }
        L_0x01fc:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ IOException -> 0x0243 }
            java.lang.String r3 = "Missing start boundary"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0243 }
            throw r0     // Catch:{ IOException -> 0x0243 }
        L_0x0204:
            int r3 = r8.length()     // Catch:{ IOException -> 0x0243 }
            if (r3 <= 0) goto L_0x022c
            if (r7 != 0) goto L_0x0218
            java.lang.String r3 = "line.separator"
            java.lang.String r5 = "\n"
            java.lang.String r3 = java.lang.System.getProperty(r3, r5)     // Catch:{ SecurityException -> 0x0215 }
            goto L_0x0217
        L_0x0215:
            java.lang.String r3 = "\n"
        L_0x0217:
            r7 = r3
        L_0x0218:
            if (r6 != 0) goto L_0x0226
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x0243 }
            int r5 = r8.length()     // Catch:{ IOException -> 0x0243 }
            int r5 = r5 + 2
            r3.<init>(r5)     // Catch:{ IOException -> 0x0243 }
            r6 = r3
        L_0x0226:
            r6.append(r8)     // Catch:{ IOException -> 0x0243 }
            r6.append(r7)     // Catch:{ IOException -> 0x0243 }
        L_0x022c:
            r5 = r21
            goto L_0x005f
        L_0x0230:
            r21 = r5
            r12 = 0
            r18 = 9
            int r13 = r13 + -1
            r5 = r21
            r9 = 9
            r10 = 32
            r11 = 0
            r12 = 1
            goto L_0x0071
        L_0x0241:
            r0 = move-exception
            goto L_0x024c
        L_0x0243:
            r0 = move-exception
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ all -> 0x0241 }
            java.lang.String r4 = "IO Error"
            r3.<init>(r4, r0)     // Catch:{ all -> 0x0241 }
            throw r3     // Catch:{ all -> 0x0241 }
        L_0x024c:
            r2.close()     // Catch:{ IOException -> 0x024f }
        L_0x024f:
            throw r0     // Catch:{ all -> 0x0261 }
        L_0x0250:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch:{ all -> 0x0261 }
            java.lang.String r2 = "Missing boundary parameter"
            r0.<init>(r2)     // Catch:{ all -> 0x0261 }
            throw r0     // Catch:{ all -> 0x0261 }
        L_0x0258:
            r0 = move-exception
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x0261 }
            java.lang.String r3 = "No inputstream from datasource"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0261 }
            throw r2     // Catch:{ all -> 0x0261 }
        L_0x0261:
            r0 = move-exception
            monitor-exit(r24)
            goto L_0x0265
        L_0x0264:
            throw r0
        L_0x0265:
            goto L_0x0264
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parse():void");
    }

    public void removeBodyPart(int i2) throws MessagingException {
        parse();
        super.removeBodyPart(i2);
    }

    public boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        return super.removeBodyPart(bodyPart);
    }

    public synchronized void setPreamble(String str) throws MessagingException {
        this.preamble = str;
    }

    public synchronized void setSubType(String str) throws MessagingException {
        ContentType contentType = new ContentType(this.contentType);
        contentType.setSubType(str);
        this.contentType = contentType.toString();
    }

    /* access modifiers changed from: protected */
    public void updateHeaders() throws MessagingException {
        for (int i2 = 0; i2 < this.parts.size(); i2++) {
            ((MimeBodyPart) this.parts.elementAt(i2)).updateHeaders();
        }
    }

    public synchronized void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        parse();
        String str = "--" + new ContentType(this.contentType).getParameter("boundary");
        LineOutputStream lineOutputStream = new LineOutputStream(outputStream);
        String str2 = this.preamble;
        if (str2 != null) {
            byte[] bytes = ASCIIUtility.getBytes(str2);
            lineOutputStream.write(bytes);
            if (!(bytes.length <= 0 || bytes[bytes.length - 1] == 13 || bytes[bytes.length - 1] == 10)) {
                lineOutputStream.writeln();
            }
        }
        for (int i2 = 0; i2 < this.parts.size(); i2++) {
            lineOutputStream.writeln(str);
            ((MimeBodyPart) this.parts.elementAt(i2)).writeTo(outputStream);
            lineOutputStream.writeln();
        }
        lineOutputStream.writeln(String.valueOf(str) + "--");
    }
}
