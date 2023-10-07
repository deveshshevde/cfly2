package com.sun.mail.pop3;

import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.SocketFetcher;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.StringTokenizer;

class Protocol {
    private static final String CRLF = "\r\n";
    private static final int POP3_PORT = 110;
    private static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String apopChallenge = null;
    private boolean debug = false;
    private DataInputStream input;
    private PrintStream out;
    private PrintWriter output;
    private Socket socket;

    Protocol(String str, int i2, boolean z2, PrintStream printStream, Properties properties, String str2, boolean z3) throws IOException {
        boolean z4 = false;
        this.debug = z2;
        this.out = printStream;
        String property = properties.getProperty(String.valueOf(str2) + ".apop.enable");
        if (property != null && property.equalsIgnoreCase("true")) {
            z4 = true;
        }
        i2 = i2 == -1 ? 110 : i2;
        if (z2) {
            try {
                printStream.println("DEBUG POP3: connecting to host \"" + str + "\", port " + i2 + ", isSSL " + z3);
            } catch (IOException e2) {
                this.socket.close();
            } catch (Throwable unused) {
            }
        }
        this.socket = SocketFetcher.getSocket(str, i2, properties, str2, z3);
        this.input = new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
        this.output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream(), "iso-8859-1")));
        Response simpleCommand = simpleCommand((String) null);
        if (!simpleCommand.f21762ok) {
            try {
                this.socket.close();
            } catch (Throwable unused2) {
            }
            throw new IOException("Connect failed");
        } else if (z4) {
            int indexOf = simpleCommand.data.indexOf(60);
            int indexOf2 = simpleCommand.data.indexOf(62, indexOf);
            if (!(indexOf == -1 || indexOf2 == -1)) {
                this.apopChallenge = simpleCommand.data.substring(indexOf, indexOf2 + 1);
            }
            if (z2) {
                printStream.println("DEBUG POP3: APOP challenge: " + this.apopChallenge);
                return;
            }
            return;
        } else {
            return;
        }
        throw e2;
    }

    private String getDigest(String str) {
        try {
            return toHex(MessageDigest.getInstance("MD5").digest((String.valueOf(this.apopChallenge) + str).getBytes("iso-8859-1")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private Response multilineCommand(String str, int i2) throws IOException {
        int read;
        Response simpleCommand = simpleCommand(str);
        if (!simpleCommand.f21762ok) {
            return simpleCommand;
        }
        SharedByteArrayOutputStream sharedByteArrayOutputStream = new SharedByteArrayOutputStream(i2);
        int i3 = 10;
        while (true) {
            read = this.input.read();
            if (read < 0) {
                break;
            }
            if (i3 == 10 && read == 46) {
                if (this.debug) {
                    this.out.write(read);
                }
                i3 = this.input.read();
                if (i3 == 13) {
                    if (this.debug) {
                        this.out.write(i3);
                    }
                    read = this.input.read();
                    if (this.debug) {
                        this.out.write(read);
                    }
                }
            } else {
                i3 = read;
            }
            sharedByteArrayOutputStream.write(i3);
            if (this.debug) {
                this.out.write(i3);
            }
        }
        if (read >= 0) {
            simpleCommand.bytes = sharedByteArrayOutputStream.toStream();
            return simpleCommand;
        }
        throw new EOFException("EOF on socket");
    }

    private Response simpleCommand(String str) throws IOException {
        if (this.socket != null) {
            if (str != null) {
                if (this.debug) {
                    PrintStream printStream = this.out;
                    printStream.println("C: " + str);
                }
                this.output.print(String.valueOf(str) + CRLF);
                this.output.flush();
            }
            String readLine = this.input.readLine();
            if (readLine == null) {
                if (this.debug) {
                    this.out.println("S: EOF");
                }
                throw new EOFException("EOF on socket");
            }
            if (this.debug) {
                PrintStream printStream2 = this.out;
                printStream2.println("S: " + readLine);
            }
            Response response = new Response();
            if (readLine.startsWith("+OK")) {
                response.f21762ok = true;
            } else if (readLine.startsWith("-ERR")) {
                response.f21762ok = false;
            } else {
                throw new IOException("Unexpected response: " + readLine);
            }
            int indexOf = readLine.indexOf(32);
            if (indexOf >= 0) {
                response.data = readLine.substring(indexOf + 1);
            }
            return response;
        }
        throw new IOException("Folder is closed");
    }

    private static String toHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            int i3 = i2 + 1;
            char[] cArr2 = digits;
            cArr[i2] = cArr2[b3 >> 4];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b3 & 15];
        }
        return new String(cArr);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean dele(int i2) throws IOException {
        return simpleCommand("DELE " + i2).f21762ok;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.socket != null) {
            quit();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized int list(int i2) throws IOException {
        int i3;
        Response simpleCommand = simpleCommand("LIST " + i2);
        i3 = -1;
        if (simpleCommand.f21762ok && simpleCommand.data != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(simpleCommand.data);
                stringTokenizer.nextToken();
                i3 = Integer.parseInt(stringTokenizer.nextToken());
            } catch (Exception unused) {
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public synchronized InputStream list() throws IOException {
        return multilineCommand("LIST", 128).bytes;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        return r4.data != null ? r4.data : "USER command failed";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006b, code lost:
        return r4.data != null ? r4.data : "login failed";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String login(java.lang.String r4, java.lang.String r5) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.apopChallenge     // Catch:{ all -> 0x006e }
            r1 = 0
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r3.getDigest(r5)     // Catch:{ all -> 0x006e }
            goto L_0x000c
        L_0x000b:
            r0 = r1
        L_0x000c:
            java.lang.String r2 = r3.apopChallenge     // Catch:{ all -> 0x006e }
            if (r2 == 0) goto L_0x002d
            if (r0 == 0) goto L_0x002d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            java.lang.String r2 = "APOP "
            r5.<init>(r2)     // Catch:{ all -> 0x006e }
            r5.append(r4)     // Catch:{ all -> 0x006e }
            java.lang.String r4 = " "
            r5.append(r4)     // Catch:{ all -> 0x006e }
            r5.append(r0)     // Catch:{ all -> 0x006e }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x006e }
        L_0x0028:
            com.sun.mail.pop3.Response r4 = r3.simpleCommand(r4)     // Catch:{ all -> 0x006e }
            goto L_0x005d
        L_0x002d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            java.lang.String r2 = "USER "
            r0.<init>(r2)     // Catch:{ all -> 0x006e }
            r0.append(r4)     // Catch:{ all -> 0x006e }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x006e }
            com.sun.mail.pop3.Response r4 = r3.simpleCommand(r4)     // Catch:{ all -> 0x006e }
            boolean r0 = r4.f21762ok     // Catch:{ all -> 0x006e }
            if (r0 != 0) goto L_0x004e
            java.lang.String r5 = r4.data     // Catch:{ all -> 0x006e }
            if (r5 == 0) goto L_0x004a
            java.lang.String r4 = r4.data     // Catch:{ all -> 0x006e }
            goto L_0x004c
        L_0x004a:
            java.lang.String r4 = "USER command failed"
        L_0x004c:
            monitor-exit(r3)
            return r4
        L_0x004e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            java.lang.String r0 = "PASS "
            r4.<init>(r0)     // Catch:{ all -> 0x006e }
            r4.append(r5)     // Catch:{ all -> 0x006e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x006e }
            goto L_0x0028
        L_0x005d:
            boolean r5 = r4.f21762ok     // Catch:{ all -> 0x006e }
            if (r5 != 0) goto L_0x006c
            java.lang.String r5 = r4.data     // Catch:{ all -> 0x006e }
            if (r5 == 0) goto L_0x0068
            java.lang.String r4 = r4.data     // Catch:{ all -> 0x006e }
            goto L_0x006a
        L_0x0068:
            java.lang.String r4 = "login failed"
        L_0x006a:
            monitor-exit(r3)
            return r4
        L_0x006c:
            monitor-exit(r3)
            return r1
        L_0x006e:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x0072
        L_0x0071:
            throw r4
        L_0x0072:
            goto L_0x0071
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.Protocol.login(java.lang.String, java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean noop() throws IOException {
        return simpleCommand("NOOP").f21762ok;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean quit() throws IOException {
        boolean z2;
        try {
            z2 = simpleCommand("QUIT").f21762ok;
            this.socket.close();
        } catch (Throwable th) {
            throw th;
        } finally {
            this.socket = null;
            this.input = null;
            this.output = null;
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public synchronized InputStream retr(int i2, int i3) throws IOException {
        return multilineCommand("RETR " + i2, i3).bytes;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean rset() throws IOException {
        return simpleCommand("RSET").f21762ok;
    }

    /* access modifiers changed from: package-private */
    public synchronized Status stat() throws IOException {
        Status status;
        Response simpleCommand = simpleCommand("STAT");
        status = new Status();
        if (simpleCommand.f21762ok && simpleCommand.data != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(simpleCommand.data);
                status.total = Integer.parseInt(stringTokenizer.nextToken());
                status.size = Integer.parseInt(stringTokenizer.nextToken());
            } catch (Exception unused) {
            }
        }
        return status;
    }

    /* access modifiers changed from: package-private */
    public synchronized InputStream top(int i2, int i3) throws IOException {
        return multilineCommand("TOP " + i2 + " " + i3, 0).bytes;
    }

    /* access modifiers changed from: package-private */
    public synchronized String uidl(int i2) throws IOException {
        Response simpleCommand = simpleCommand("UIDL " + i2);
        if (!simpleCommand.f21762ok) {
            return null;
        }
        int indexOf = simpleCommand.data.indexOf(32);
        if (indexOf <= 0) {
            return null;
        }
        return simpleCommand.data.substring(indexOf + 1);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean uidl(String[] strArr) throws IOException {
        Response multilineCommand = multilineCommand("UIDL", strArr.length * 15);
        if (!multilineCommand.f21762ok) {
            return false;
        }
        LineInputStream lineInputStream = new LineInputStream(multilineCommand.bytes);
        while (true) {
            String readLine = lineInputStream.readLine();
            if (readLine == null) {
                return true;
            }
            int indexOf = readLine.indexOf(32);
            if (indexOf >= 1) {
                if (indexOf < readLine.length()) {
                    int parseInt = Integer.parseInt(readLine.substring(0, indexOf));
                    if (parseInt > 0 && parseInt <= strArr.length) {
                        strArr[parseInt - 1] = readLine.substring(indexOf + 1);
                    }
                }
            }
        }
    }
}
