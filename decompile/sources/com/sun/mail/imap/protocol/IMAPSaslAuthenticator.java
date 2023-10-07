package com.sun.mail.imap.protocol;

import java.io.PrintStream;
import java.util.Properties;

public class IMAPSaslAuthenticator implements SaslAuthenticator {
    /* access modifiers changed from: private */
    public boolean debug;
    private String host;
    private String name;
    /* access modifiers changed from: private */
    public PrintStream out;
    private IMAPProtocol pr;
    private Properties props;

    public IMAPSaslAuthenticator(IMAPProtocol iMAPProtocol, String str, Properties properties, boolean z2, PrintStream printStream, String str2) {
        this.pr = iMAPProtocol;
        this.name = str;
        this.props = properties;
        this.debug = z2;
        this.out = printStream;
        this.host = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e7, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean authenticate(java.lang.String[] r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) throws com.sun.mail.iap.ProtocolException {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            com.sun.mail.imap.protocol.IMAPProtocol r8 = r1.pr
            monitor-enter(r8)
            java.util.Vector r9 = new java.util.Vector     // Catch:{ all -> 0x0204 }
            r9.<init>()     // Catch:{ all -> 0x0204 }
            boolean r2 = r1.debug     // Catch:{ all -> 0x0204 }
            r10 = 0
            if (r2 == 0) goto L_0x003a
            java.io.PrintStream r2 = r1.out     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = "IMAP SASL DEBUG: Mechanisms:"
            r2.print(r3)     // Catch:{ all -> 0x0204 }
            r2 = 0
        L_0x0019:
            int r3 = r0.length     // Catch:{ all -> 0x0204 }
            if (r2 < r3) goto L_0x0022
            java.io.PrintStream r2 = r1.out     // Catch:{ all -> 0x0204 }
            r2.println()     // Catch:{ all -> 0x0204 }
            goto L_0x003a
        L_0x0022:
            java.io.PrintStream r3 = r1.out     // Catch:{ all -> 0x0204 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0204 }
            java.lang.String r5 = " "
            r4.<init>(r5)     // Catch:{ all -> 0x0204 }
            r5 = r0[r2]     // Catch:{ all -> 0x0204 }
            r4.append(r5)     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0204 }
            r3.print(r4)     // Catch:{ all -> 0x0204 }
            int r2 = r2 + 1
            goto L_0x0019
        L_0x003a:
            com.sun.mail.imap.protocol.IMAPSaslAuthenticator$1 r7 = new com.sun.mail.imap.protocol.IMAPSaslAuthenticator$1     // Catch:{ all -> 0x0204 }
            r2 = r18
            r3 = r20
            r4 = r21
            r7.<init>(r3, r4, r2)     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = r1.name     // Catch:{ SaslException -> 0x01ea }
            java.lang.String r5 = r1.host     // Catch:{ SaslException -> 0x01ea }
            java.util.Properties r6 = r1.props     // Catch:{ SaslException -> 0x01ea }
            r2 = r17
            r3 = r19
            javax.security.sasl.SaslClient r2 = javax.security.sasl.Sasl.createSaslClient(r2, r3, r4, r5, r6, r7)     // Catch:{ SaslException -> 0x01ea }
            if (r2 != 0) goto L_0x0062
            boolean r0 = r1.debug     // Catch:{ all -> 0x0204 }
            if (r0 == 0) goto L_0x0060
            java.io.PrintStream r0 = r1.out     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "IMAP SASL DEBUG: No SASL support"
            r0.println(r2)     // Catch:{ all -> 0x0204 }
        L_0x0060:
            monitor-exit(r8)     // Catch:{ all -> 0x0204 }
            return r10
        L_0x0062:
            boolean r0 = r1.debug     // Catch:{ all -> 0x0204 }
            if (r0 == 0) goto L_0x007d
            java.io.PrintStream r0 = r1.out     // Catch:{ all -> 0x0204 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = "IMAP SASL DEBUG: SASL client "
            r3.<init>(r4)     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = r2.getMechanismName()     // Catch:{ all -> 0x0204 }
            r3.append(r4)     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0204 }
            r0.println(r3)     // Catch:{ all -> 0x0204 }
        L_0x007d:
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r1.pr     // Catch:{ Exception -> 0x01d0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r4 = "AUTHENTICATE "
            r3.<init>(r4)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r4 = r2.getMechanismName()     // Catch:{ Exception -> 0x01d0 }
            r3.append(r4)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01d0 }
            r4 = 0
            java.lang.String r3 = r0.writeCommand(r3, r4)     // Catch:{ Exception -> 0x01d0 }
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r1.pr     // Catch:{ all -> 0x0204 }
            java.io.OutputStream r5 = r0.getIMAPOutputStream()     // Catch:{ all -> 0x0204 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0204 }
            r6.<init>()     // Catch:{ all -> 0x0204 }
            r0 = 2
            byte[] r7 = new byte[r0]     // Catch:{ all -> 0x0204 }
            r0 = 13
            r7[r10] = r0     // Catch:{ all -> 0x0204 }
            r0 = 10
            r11 = 1
            r7[r11] = r0     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = r2.getMechanismName()     // Catch:{ all -> 0x0204 }
            java.lang.String r12 = "XGWTRUSTEDAPP"
            boolean r12 = r0.equals(r12)     // Catch:{ all -> 0x0204 }
            r13 = r4
            r0 = 0
        L_0x00b9:
            if (r0 == 0) goto L_0x0102
            boolean r0 = r2.isComplete()     // Catch:{ all -> 0x0204 }
            if (r0 == 0) goto L_0x00e8
            java.lang.String r0 = "javax.security.sasl.qop"
            java.lang.Object r0 = r2.getNegotiatedProperty(r0)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0204 }
            if (r0 == 0) goto L_0x00e8
            java.lang.String r2 = "auth-int"
            boolean r2 = r0.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0204 }
            if (r2 != 0) goto L_0x00db
            java.lang.String r2 = "auth-conf"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0204 }
            if (r0 == 0) goto L_0x00e8
        L_0x00db:
            boolean r0 = r1.debug     // Catch:{ all -> 0x0204 }
            if (r0 == 0) goto L_0x00e6
            java.io.PrintStream r0 = r1.out     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "IMAP SASL DEBUG: Mechanism requires integrity or confidentiality"
            r0.println(r2)     // Catch:{ all -> 0x0204 }
        L_0x00e6:
            monitor-exit(r8)     // Catch:{ all -> 0x0204 }
            return r10
        L_0x00e8:
            int r0 = r9.size()     // Catch:{ all -> 0x0204 }
            com.sun.mail.iap.Response[] r0 = new com.sun.mail.iap.Response[r0]     // Catch:{ all -> 0x0204 }
            r9.copyInto(r0)     // Catch:{ all -> 0x0204 }
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r1.pr     // Catch:{ all -> 0x0204 }
            r2.notifyResponseHandlers(r0)     // Catch:{ all -> 0x0204 }
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r1.pr     // Catch:{ all -> 0x0204 }
            r0.handleResult(r13)     // Catch:{ all -> 0x0204 }
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r1.pr     // Catch:{ all -> 0x0204 }
            r0.setCapabilities(r13)     // Catch:{ all -> 0x0204 }
            monitor-exit(r8)     // Catch:{ all -> 0x0204 }
            return r11
        L_0x0102:
            com.sun.mail.imap.protocol.IMAPProtocol r13 = r1.pr     // Catch:{ Exception -> 0x01bf }
            com.sun.mail.iap.Response r13 = r13.readResponse()     // Catch:{ Exception -> 0x01bf }
            boolean r14 = r13.isContinuation()     // Catch:{ Exception -> 0x01bf }
            if (r14 == 0) goto L_0x01a3
            r14 = r4
            byte[] r14 = (byte[]) r14     // Catch:{ Exception -> 0x01bf }
            boolean r15 = r2.isComplete()     // Catch:{ Exception -> 0x01bf }
            if (r15 != 0) goto L_0x014b
            com.sun.mail.iap.ByteArray r14 = r13.readByteArray()     // Catch:{ Exception -> 0x01bf }
            byte[] r14 = r14.getNewBytes()     // Catch:{ Exception -> 0x01bf }
            int r15 = r14.length     // Catch:{ Exception -> 0x01bf }
            if (r15 <= 0) goto L_0x0126
            byte[] r14 = com.sun.mail.util.BASE64DecoderStream.decode(r14)     // Catch:{ Exception -> 0x01bf }
        L_0x0126:
            boolean r15 = r1.debug     // Catch:{ Exception -> 0x01bf }
            if (r15 == 0) goto L_0x0147
            java.io.PrintStream r15 = r1.out     // Catch:{ Exception -> 0x01bf }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
            java.lang.String r11 = "IMAP SASL DEBUG: challenge: "
            r4.<init>(r11)     // Catch:{ Exception -> 0x01bf }
            int r11 = r14.length     // Catch:{ Exception -> 0x01bf }
            java.lang.String r11 = com.sun.mail.util.ASCIIUtility.toString(r14, r10, r11)     // Catch:{ Exception -> 0x01bf }
            r4.append(r11)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r11 = " :"
            r4.append(r11)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01bf }
            r15.println(r4)     // Catch:{ Exception -> 0x01bf }
        L_0x0147:
            byte[] r14 = r2.evaluateChallenge(r14)     // Catch:{ Exception -> 0x01bf }
        L_0x014b:
            if (r14 != 0) goto L_0x0162
            boolean r4 = r1.debug     // Catch:{ Exception -> 0x01bf }
            if (r4 == 0) goto L_0x0158
            java.io.PrintStream r4 = r1.out     // Catch:{ Exception -> 0x01bf }
            java.lang.String r11 = "IMAP SASL DEBUG: no response"
            r4.println(r11)     // Catch:{ Exception -> 0x01bf }
        L_0x0158:
            r5.write(r7)     // Catch:{ Exception -> 0x01bf }
            r5.flush()     // Catch:{ Exception -> 0x01bf }
        L_0x015e:
            r6.reset()     // Catch:{ Exception -> 0x01bf }
            goto L_0x01cc
        L_0x0162:
            boolean r4 = r1.debug     // Catch:{ Exception -> 0x01bf }
            if (r4 == 0) goto L_0x0183
            java.io.PrintStream r4 = r1.out     // Catch:{ Exception -> 0x01bf }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
            java.lang.String r15 = "IMAP SASL DEBUG: response: "
            r11.<init>(r15)     // Catch:{ Exception -> 0x01bf }
            int r15 = r14.length     // Catch:{ Exception -> 0x01bf }
            java.lang.String r15 = com.sun.mail.util.ASCIIUtility.toString(r14, r10, r15)     // Catch:{ Exception -> 0x01bf }
            r11.append(r15)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r15 = " :"
            r11.append(r15)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x01bf }
            r4.println(r11)     // Catch:{ Exception -> 0x01bf }
        L_0x0183:
            byte[] r4 = com.sun.mail.util.BASE64EncoderStream.encode(r14)     // Catch:{ Exception -> 0x01bf }
            if (r12 == 0) goto L_0x0192
            java.lang.String r11 = "XGWTRUSTEDAPP "
            byte[] r11 = r11.getBytes()     // Catch:{ Exception -> 0x01bf }
            r6.write(r11)     // Catch:{ Exception -> 0x01bf }
        L_0x0192:
            r6.write(r4)     // Catch:{ Exception -> 0x01bf }
            r6.write(r7)     // Catch:{ Exception -> 0x01bf }
            byte[] r4 = r6.toByteArray()     // Catch:{ Exception -> 0x01bf }
            r5.write(r4)     // Catch:{ Exception -> 0x01bf }
            r5.flush()     // Catch:{ Exception -> 0x01bf }
            goto L_0x015e
        L_0x01a3:
            boolean r4 = r13.isTagged()     // Catch:{ Exception -> 0x01bf }
            if (r4 == 0) goto L_0x01b4
            java.lang.String r4 = r13.getTag()     // Catch:{ Exception -> 0x01bf }
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x01bf }
            if (r4 == 0) goto L_0x01b4
            goto L_0x01cb
        L_0x01b4:
            boolean r4 = r13.isBYE()     // Catch:{ Exception -> 0x01bf }
            if (r4 == 0) goto L_0x01bb
            goto L_0x01cb
        L_0x01bb:
            r9.addElement(r13)     // Catch:{ Exception -> 0x01bf }
            goto L_0x01cc
        L_0x01bf:
            r0 = move-exception
            boolean r4 = r1.debug     // Catch:{ all -> 0x0204 }
            if (r4 == 0) goto L_0x01c7
            r0.printStackTrace()     // Catch:{ all -> 0x0204 }
        L_0x01c7:
            com.sun.mail.iap.Response r13 = com.sun.mail.iap.Response.byeResponse(r0)     // Catch:{ all -> 0x0204 }
        L_0x01cb:
            r0 = 1
        L_0x01cc:
            r4 = 0
            r11 = 1
            goto L_0x00b9
        L_0x01d0:
            r0 = move-exception
            boolean r2 = r1.debug     // Catch:{ all -> 0x0204 }
            if (r2 == 0) goto L_0x01e8
            java.io.PrintStream r2 = r1.out     // Catch:{ all -> 0x0204 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = "IMAP SASL DEBUG: AUTHENTICATE Exception: "
            r3.<init>(r4)     // Catch:{ all -> 0x0204 }
            r3.append(r0)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0204 }
            r2.println(r0)     // Catch:{ all -> 0x0204 }
        L_0x01e8:
            monitor-exit(r8)     // Catch:{ all -> 0x0204 }
            return r10
        L_0x01ea:
            r0 = move-exception
            boolean r2 = r1.debug     // Catch:{ all -> 0x0204 }
            if (r2 == 0) goto L_0x0202
            java.io.PrintStream r2 = r1.out     // Catch:{ all -> 0x0204 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = "IMAP SASL DEBUG: Failed to create SASL client: "
            r3.<init>(r4)     // Catch:{ all -> 0x0204 }
            r3.append(r0)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0204 }
            r2.println(r0)     // Catch:{ all -> 0x0204 }
        L_0x0202:
            monitor-exit(r8)     // Catch:{ all -> 0x0204 }
            return r10
        L_0x0204:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0204 }
            goto L_0x0208
        L_0x0207:
            throw r0
        L_0x0208:
            goto L_0x0207
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.IMAPSaslAuthenticator.authenticate(java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
