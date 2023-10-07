package com.sun.mail.smtp;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.internet.ParseException;

public class SMTPTransport extends Transport {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] CRLF = {13, 10};
    private static final String UNKNOWN = "UNKNOWN";
    private static char[] hexchar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String[] ignoreList = {"Bcc", "Content-Length"};
    private Address[] addresses;
    private SMTPOutputStream dataStream;
    private int defaultPort;
    private MessagingException exception;
    private Hashtable extMap;
    private Address[] invalidAddr;
    private boolean isSSL;
    private int lastReturnCode;
    private String lastServerResponse;
    private LineInputStream lineInputStream;
    private String localHostName;
    private DigestMD5 md5support;
    private MimeMessage message;
    private String name;
    private PrintStream out;
    private boolean quitWait;
    private boolean reportSuccess;
    private String saslRealm;
    private boolean sendPartiallyFailed;
    private BufferedInputStream serverInput;
    private OutputStream serverOutput;
    private Socket serverSocket;
    private boolean useRset;
    private boolean useStartTLS;
    private Address[] validSentAddr;
    private Address[] validUnsentAddr;

    public SMTPTransport(Session session, URLName uRLName) {
        this(session, uRLName, "smtp", 25, false);
    }

    protected SMTPTransport(Session session, URLName uRLName, String str, int i2, boolean z2) {
        super(session, uRLName);
        this.name = "smtp";
        this.defaultPort = 25;
        boolean z3 = false;
        this.isSSL = false;
        this.sendPartiallyFailed = false;
        this.quitWait = false;
        this.saslRealm = UNKNOWN;
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.name = str;
        this.defaultPort = i2;
        this.isSSL = z2;
        this.out = session.getDebugOut();
        String property = session.getProperty("mail." + str + ".quitwait");
        this.quitWait = property == null || property.equalsIgnoreCase("true");
        String property2 = session.getProperty("mail." + str + ".reportsuccess");
        this.reportSuccess = property2 != null && property2.equalsIgnoreCase("true");
        String property3 = session.getProperty("mail." + str + ".starttls.enable");
        this.useStartTLS = property3 != null && property3.equalsIgnoreCase("true");
        String property4 = session.getProperty("mail." + str + ".userset");
        if (property4 != null && property4.equalsIgnoreCase("true")) {
            z3 = true;
        }
        this.useRset = z3;
    }

    private void closeConnection() throws MessagingException {
        try {
            Socket socket = this.serverSocket;
            if (socket != null) {
                socket.close();
            }
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (super.isConnected()) {
                super.close();
            }
        } catch (IOException e2) {
            throw new MessagingException("Server Close Failed", e2);
        } catch (Throwable th) {
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (super.isConnected()) {
                super.close();
            }
            throw th;
        }
    }

    private boolean convertTo8Bit(MimePart mimePart) {
        int i2 = 0;
        try {
            if (mimePart.isMimeType("text/*")) {
                String encoding = mimePart.getEncoding();
                if (encoding == null) {
                    return false;
                }
                if ((!encoding.equalsIgnoreCase("quoted-printable") && !encoding.equalsIgnoreCase("base64")) || !is8Bit(mimePart.getInputStream())) {
                    return false;
                }
                mimePart.setContent(mimePart.getContent(), mimePart.getContentType());
                mimePart.setHeader("Content-Transfer-Encoding", "8bit");
                return true;
            } else if (!mimePart.isMimeType("multipart/*")) {
                return false;
            } else {
                MimeMultipart mimeMultipart = (MimeMultipart) mimePart.getContent();
                int count = mimeMultipart.getCount();
                boolean z2 = false;
                while (i2 < count) {
                    try {
                        if (convertTo8Bit((MimePart) mimeMultipart.getBodyPart(i2))) {
                            z2 = true;
                        }
                        i2++;
                    } catch (IOException | MessagingException unused) {
                    }
                }
                return z2;
            }
        } catch (IOException | MessagingException unused2) {
            return false;
        }
    }

    private void expandGroups() {
        Vector vector = null;
        int i2 = 0;
        while (true) {
            Address[] addressArr = this.addresses;
            if (i2 >= addressArr.length) {
                break;
            }
            InternetAddress internetAddress = (InternetAddress) addressArr[i2];
            if (internetAddress.isGroup()) {
                if (vector == null) {
                    Vector vector2 = new Vector();
                    for (int i3 = 0; i3 < i2; i3++) {
                        vector2.addElement(this.addresses[i3]);
                    }
                    vector = vector2;
                }
                try {
                    InternetAddress[] group = internetAddress.getGroup(true);
                    if (group != null) {
                        for (InternetAddress addElement : group) {
                            vector.addElement(addElement);
                        }
                    } else {
                        vector.addElement(internetAddress);
                    }
                } catch (ParseException unused) {
                }
            } else {
                if (vector == null) {
                }
                vector.addElement(internetAddress);
            }
            i2++;
        }
        if (vector != null) {
            InternetAddress[] internetAddressArr = new InternetAddress[vector.size()];
            vector.copyInto(internetAddressArr);
            this.addresses = internetAddressArr;
        }
    }

    private synchronized DigestMD5 getMD5() {
        if (this.md5support == null) {
            this.md5support = new DigestMD5(this.debug ? this.out : null);
        }
        return this.md5support;
    }

    private void initStreams() throws IOException {
        Properties properties = this.session.getProperties();
        PrintStream debugOut = this.session.getDebugOut();
        boolean debug = this.session.getDebug();
        String property = properties.getProperty("mail.debug.quote");
        boolean z2 = property != null && property.equalsIgnoreCase("true");
        TraceInputStream traceInputStream = new TraceInputStream(this.serverSocket.getInputStream(), debugOut);
        traceInputStream.setTrace(debug);
        traceInputStream.setQuote(z2);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.serverSocket.getOutputStream(), debugOut);
        traceOutputStream.setTrace(debug);
        traceOutputStream.setQuote(z2);
        this.serverOutput = new BufferedOutputStream(traceOutputStream);
        this.serverInput = new BufferedInputStream(traceInputStream);
        this.lineInputStream = new LineInputStream(this.serverInput);
    }

    private boolean is8Bit(InputStream inputStream) {
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            try {
                int read = inputStream.read();
                if (read < 0) {
                    if (this.debug && z2) {
                        this.out.println("DEBUG SMTP: found an 8bit part");
                    }
                    return z2;
                }
                int i3 = read & 255;
                if (i3 == 13 || i3 == 10) {
                    i2 = 0;
                } else if (i3 == 0 || (i2 = i2 + 1) > 998) {
                    return false;
                }
                if (i3 > 127) {
                    z2 = true;
                }
            } catch (IOException unused) {
                return false;
            }
        }
    }

    private boolean isNotLastLine(String str) {
        return str != null && str.length() >= 4 && str.charAt(3) == '-';
    }

    private void issueSendCommand(String str, int i2) throws MessagingException {
        sendCommand(str);
        int readServerResponse = readServerResponse();
        if (readServerResponse != i2) {
            Address[] addressArr = this.validSentAddr;
            int length = addressArr == null ? 0 : addressArr.length;
            Address[] addressArr2 = this.validUnsentAddr;
            int length2 = addressArr2 == null ? 0 : addressArr2.length;
            Address[] addressArr3 = new Address[(length + length2)];
            if (length > 0) {
                System.arraycopy(addressArr, 0, addressArr3, 0, length);
            }
            if (length2 > 0) {
                System.arraycopy(this.validUnsentAddr, 0, addressArr3, length, length2);
            }
            this.validSentAddr = null;
            this.validUnsentAddr = addressArr3;
            if (this.debug) {
                PrintStream printStream = this.out;
                printStream.println("DEBUG SMTP: got response code " + readServerResponse + ", with response: " + this.lastServerResponse);
            }
            String str2 = this.lastServerResponse;
            int i3 = this.lastReturnCode;
            if (this.serverSocket != null) {
                issueCommand("RSET", 250);
            }
            this.lastServerResponse = str2;
            this.lastReturnCode = i3;
            throw new SMTPSendFailedException(str, readServerResponse, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
        }
    }

    private String normalizeAddress(String str) {
        if (str.startsWith("<") || str.endsWith(">")) {
            return str;
        }
        return "<" + str + ">";
    }

    private void openServer() throws MessagingException {
        String str = UNKNOWN;
        int i2 = -1;
        try {
            i2 = this.serverSocket.getPort();
            str = this.serverSocket.getInetAddress().getHostName();
            if (this.debug) {
                PrintStream printStream = this.out;
                printStream.println("DEBUG SMTP: starting protocol to host \"" + str + "\", port " + i2);
            }
            initStreams();
            int readServerResponse = readServerResponse();
            if (readServerResponse != 220) {
                this.serverSocket.close();
                this.serverSocket = null;
                this.serverOutput = null;
                this.serverInput = null;
                this.lineInputStream = null;
                if (this.debug) {
                    PrintStream printStream2 = this.out;
                    printStream2.println("DEBUG SMTP: got bad greeting from host \"" + str + "\", port: " + i2 + ", response: " + readServerResponse + "\n");
                }
                throw new MessagingException("Got bad greeting from SMTP host: " + str + ", port: " + i2 + ", response: " + readServerResponse);
            } else if (this.debug) {
                PrintStream printStream3 = this.out;
                printStream3.println("DEBUG SMTP: protocol started to host \"" + str + "\", port: " + i2 + "\n");
            }
        } catch (IOException e2) {
            throw new MessagingException("Could not start protocol to SMTP host: " + str + ", port: " + i2, e2);
        }
    }

    private void openServer(String str, int i2) throws MessagingException {
        if (this.debug) {
            PrintStream printStream = this.out;
            printStream.println("DEBUG SMTP: trying to connect to host \"" + str + "\", port " + i2 + ", isSSL " + this.isSSL);
        }
        try {
            Properties properties = this.session.getProperties();
            Socket socket = SocketFetcher.getSocket(str, i2, properties, "mail." + this.name, this.isSSL);
            this.serverSocket = socket;
            i2 = socket.getPort();
            initStreams();
            int readServerResponse = readServerResponse();
            if (readServerResponse != 220) {
                this.serverSocket.close();
                this.serverSocket = null;
                this.serverOutput = null;
                this.serverInput = null;
                this.lineInputStream = null;
                if (this.debug) {
                    PrintStream printStream2 = this.out;
                    printStream2.println("DEBUG SMTP: could not connect to host \"" + str + "\", port: " + i2 + ", response: " + readServerResponse + "\n");
                }
                throw new MessagingException("Could not connect to SMTP host: " + str + ", port: " + i2 + ", response: " + readServerResponse);
            } else if (this.debug) {
                PrintStream printStream3 = this.out;
                printStream3.println("DEBUG SMTP: connected to host \"" + str + "\", port: " + i2 + "\n");
            }
        } catch (UnknownHostException e2) {
            throw new MessagingException("Unknown SMTP host: " + str, e2);
        } catch (IOException e3) {
            throw new MessagingException("Could not connect to SMTP host: " + str + ", port: " + i2, e3);
        }
    }

    private void sendCommand(byte[] bArr) throws MessagingException {
        try {
            this.serverOutput.write(bArr);
            this.serverOutput.write(CRLF);
            this.serverOutput.flush();
        } catch (IOException e2) {
            throw new MessagingException("Can't send command to SMTP host", e2);
        }
    }

    protected static String xtext(String str) {
        StringBuffer stringBuffer = null;
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                if (charAt < '!' || charAt > '~' || charAt == '+' || charAt == '=') {
                    if (stringBuffer == null) {
                        stringBuffer = new StringBuffer(str.length() + 4);
                        stringBuffer.append(str.substring(0, i2));
                    }
                    stringBuffer.append('+');
                    stringBuffer.append(hexchar[(charAt & 240) >> 4]);
                    charAt = hexchar[charAt & 15];
                } else if (stringBuffer == null) {
                    i2++;
                }
                stringBuffer.append(charAt);
                i2++;
            } else {
                throw new IllegalArgumentException("Non-ASCII character in SMTP submitter: " + str);
            }
        }
        return stringBuffer != null ? stringBuffer.toString() : str;
    }

    /* access modifiers changed from: protected */
    public void checkConnected() {
        if (!super.isConnected()) {
            throw new IllegalStateException("Not connected");
        }
    }

    public synchronized void close() throws MessagingException {
        int readServerResponse;
        if (super.isConnected()) {
            try {
                if (this.serverSocket != null) {
                    sendCommand("QUIT");
                    if (!(!this.quitWait || (readServerResponse = readServerResponse()) == 221 || readServerResponse == -1)) {
                        PrintStream printStream = this.out;
                        printStream.println("DEBUG SMTP: QUIT failed with " + readServerResponse);
                    }
                }
            } finally {
                closeConnection();
            }
        }
    }

    public synchronized void connect(Socket socket) throws MessagingException {
        this.serverSocket = socket;
        super.connect();
    }

    /* access modifiers changed from: protected */
    public OutputStream data() throws MessagingException {
        issueSendCommand("DATA", 354);
        SMTPOutputStream sMTPOutputStream = new SMTPOutputStream(this.serverOutput);
        this.dataStream = sMTPOutputStream;
        return sMTPOutputStream;
    }

    /* access modifiers changed from: protected */
    public boolean ehlo(String str) throws MessagingException {
        String str2;
        if (str != null) {
            str2 = "EHLO " + str;
        } else {
            str2 = "EHLO";
        }
        sendCommand(str2);
        int readServerResponse = readServerResponse();
        if (readServerResponse == 250) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(this.lastServerResponse));
            this.extMap = new Hashtable();
            boolean z2 = true;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (z2) {
                        z2 = false;
                    } else if (readLine.length() >= 5) {
                        String substring = readLine.substring(4);
                        int indexOf = substring.indexOf(32);
                        String str3 = "";
                        if (indexOf > 0) {
                            str3 = substring.substring(indexOf + 1);
                            substring = substring.substring(0, indexOf);
                        }
                        if (this.debug) {
                            this.out.println("DEBUG SMTP: Found extension \"" + substring + "\", arg \"" + str3 + "\"");
                        }
                        this.extMap.put(substring.toUpperCase(Locale.ENGLISH), str3);
                    }
                } catch (IOException unused) {
                }
            }
        }
        return readServerResponse == 250;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        try {
            closeConnection();
        } catch (MessagingException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void finishData() throws IOException, MessagingException {
        this.dataStream.ensureAtBOL();
        issueSendCommand(".", 250);
    }

    public String getExtensionParameter(String str) {
        Hashtable hashtable = this.extMap;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str.toUpperCase(Locale.ENGLISH));
    }

    public synchronized int getLastReturnCode() {
        return this.lastReturnCode;
    }

    public synchronized String getLastServerResponse() {
        return this.lastServerResponse;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0081 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String getLocalHost() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.localHostName     // Catch:{ UnknownHostException -> 0x0081 }
            if (r0 == 0) goto L_0x000b
            int r0 = r0.length()     // Catch:{ UnknownHostException -> 0x0081 }
            if (r0 > 0) goto L_0x0028
        L_0x000b:
            javax.mail.Session r0 = r3.session     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r2 = "mail."
            r1.<init>(r2)     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r2 = r3.name     // Catch:{ UnknownHostException -> 0x0081 }
            r1.append(r2)     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r2 = ".localhost"
            r1.append(r2)     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r1 = r1.toString()     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r0 = r0.getProperty(r1)     // Catch:{ UnknownHostException -> 0x0081 }
            r3.localHostName = r0     // Catch:{ UnknownHostException -> 0x0081 }
        L_0x0028:
            java.lang.String r0 = r3.localHostName     // Catch:{ UnknownHostException -> 0x0081 }
            if (r0 == 0) goto L_0x0032
            int r0 = r0.length()     // Catch:{ UnknownHostException -> 0x0081 }
            if (r0 > 0) goto L_0x004f
        L_0x0032:
            javax.mail.Session r0 = r3.session     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r2 = "mail."
            r1.<init>(r2)     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r2 = r3.name     // Catch:{ UnknownHostException -> 0x0081 }
            r1.append(r2)     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r2 = ".localaddress"
            r1.append(r2)     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r1 = r1.toString()     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r0 = r0.getProperty(r1)     // Catch:{ UnknownHostException -> 0x0081 }
            r3.localHostName = r0     // Catch:{ UnknownHostException -> 0x0081 }
        L_0x004f:
            java.lang.String r0 = r3.localHostName     // Catch:{ UnknownHostException -> 0x0081 }
            if (r0 == 0) goto L_0x0059
            int r0 = r0.length()     // Catch:{ UnknownHostException -> 0x0081 }
            if (r0 > 0) goto L_0x0081
        L_0x0059:
            java.net.InetAddress r0 = java.net.InetAddress.getLocalHost()     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r1 = r0.getHostName()     // Catch:{ UnknownHostException -> 0x0081 }
            r3.localHostName = r1     // Catch:{ UnknownHostException -> 0x0081 }
            if (r1 != 0) goto L_0x0081
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r2 = "["
            r1.<init>(r2)     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r0 = r0.getHostAddress()     // Catch:{ UnknownHostException -> 0x0081 }
            r1.append(r0)     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r0 = "]"
            r1.append(r0)     // Catch:{ UnknownHostException -> 0x0081 }
            java.lang.String r0 = r1.toString()     // Catch:{ UnknownHostException -> 0x0081 }
            r3.localHostName = r0     // Catch:{ UnknownHostException -> 0x0081 }
            goto L_0x0081
        L_0x007f:
            r0 = move-exception
            goto L_0x0085
        L_0x0081:
            java.lang.String r0 = r3.localHostName     // Catch:{ all -> 0x007f }
            monitor-exit(r3)
            return r0
        L_0x0085:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.getLocalHost():java.lang.String");
    }

    public synchronized boolean getReportSuccess() {
        return this.reportSuccess;
    }

    public synchronized String getSASLRealm() {
        if (this.saslRealm == UNKNOWN) {
            Session session = this.session;
            String property = session.getProperty("mail." + this.name + ".sasl.realm");
            this.saslRealm = property;
            if (property == null) {
                Session session2 = this.session;
                this.saslRealm = session2.getProperty("mail." + this.name + ".saslrealm");
            }
        }
        return this.saslRealm;
    }

    public synchronized boolean getStartTLS() {
        return this.useStartTLS;
    }

    public synchronized boolean getUseRset() {
        return this.useRset;
    }

    /* access modifiers changed from: protected */
    public void helo(String str) throws MessagingException {
        String str2;
        if (str != null) {
            str2 = "HELO " + str;
        } else {
            str2 = "HELO";
        }
        issueCommand(str2, 250);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:25|26|27|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        closeConnection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x002d, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isConnected() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = super.isConnected()     // Catch:{ all -> 0x002e }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r3)
            return r1
        L_0x000a:
            boolean r0 = r3.useRset     // Catch:{ Exception -> 0x0029 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r0 = "RSET"
        L_0x0010:
            r3.sendCommand((java.lang.String) r0)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0017
        L_0x0014:
            java.lang.String r0 = "NOOP"
            goto L_0x0010
        L_0x0017:
            int r0 = r3.readServerResponse()     // Catch:{ Exception -> 0x0029 }
            if (r0 < 0) goto L_0x0024
            r2 = 421(0x1a5, float:5.9E-43)
            if (r0 == r2) goto L_0x0024
            r0 = 1
            monitor-exit(r3)
            return r0
        L_0x0024:
            r3.closeConnection()     // Catch:{ MessagingException -> 0x0027 }
        L_0x0027:
            monitor-exit(r3)
            return r1
        L_0x0029:
            r3.closeConnection()     // Catch:{ MessagingException -> 0x002c }
        L_0x002c:
            monitor-exit(r3)
            return r1
        L_0x002e:
            r0 = move-exception
            monitor-exit(r3)
            goto L_0x0032
        L_0x0031:
            throw r0
        L_0x0032:
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.isConnected():boolean");
    }

    public synchronized void issueCommand(String str, int i2) throws MessagingException {
        sendCommand(str);
        if (readServerResponse() != i2) {
            throw new MessagingException(this.lastServerResponse);
        }
    }

    /* access modifiers changed from: protected */
    public void mailFrom() throws MessagingException {
        Address[] from;
        MimeMessage mimeMessage = this.message;
        String str = null;
        String envelopeFrom = mimeMessage instanceof SMTPMessage ? ((SMTPMessage) mimeMessage).getEnvelopeFrom() : null;
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            envelopeFrom = this.session.getProperty("mail." + this.name + ".from");
        }
        if (envelopeFrom == null || envelopeFrom.length() <= 0) {
            MimeMessage mimeMessage2 = this.message;
            Address localAddress = (mimeMessage2 == null || (from = mimeMessage2.getFrom()) == null || from.length <= 0) ? InternetAddress.getLocalAddress(this.session) : from[0];
            if (localAddress != null) {
                envelopeFrom = ((InternetAddress) localAddress).getAddress();
            } else {
                throw new MessagingException("can't determine local email address");
            }
        }
        String str2 = "MAIL FROM:" + normalizeAddress(envelopeFrom);
        if (supportsExtension("DSN")) {
            MimeMessage mimeMessage3 = this.message;
            String dSNRet = mimeMessage3 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage3).getDSNRet() : null;
            if (dSNRet == null) {
                dSNRet = this.session.getProperty("mail." + this.name + ".dsn.ret");
            }
            if (dSNRet != null) {
                str2 = String.valueOf(str2) + " RET=" + dSNRet;
            }
        }
        if (supportsExtension("AUTH")) {
            MimeMessage mimeMessage4 = this.message;
            String submitter = mimeMessage4 instanceof SMTPMessage ? ((SMTPMessage) mimeMessage4).getSubmitter() : null;
            if (submitter == null) {
                submitter = this.session.getProperty("mail." + this.name + ".submitter");
            }
            if (submitter != null) {
                try {
                    str2 = String.valueOf(str2) + " AUTH=" + xtext(submitter);
                } catch (IllegalArgumentException e2) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: ignoring invalid submitter: " + submitter + ", Exception: " + e2);
                    }
                }
            }
        }
        MimeMessage mimeMessage5 = this.message;
        if (mimeMessage5 instanceof SMTPMessage) {
            str = ((SMTPMessage) mimeMessage5).getMailExtension();
        }
        if (str == null) {
            str = this.session.getProperty("mail." + this.name + ".mailextension");
        }
        if (str != null && str.length() > 0) {
            str2 = String.valueOf(str2) + " " + str;
        }
        issueSendCommand(str2, 250);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean protocolConnect(java.lang.String r15, int r16, java.lang.String r17, java.lang.String r18) throws javax.mail.MessagingException {
        /*
            r14 = this;
            r1 = r14
            javax.mail.Session r0 = r1.session
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "mail."
            r2.<init>(r3)
            java.lang.String r4 = r1.name
            r2.append(r4)
            java.lang.String r4 = ".ehlo"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = r0.getProperty(r2)
            r8 = 1
            r9 = 0
            if (r0 == 0) goto L_0x002a
            java.lang.String r2 = "false"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x002a
            r0 = 0
            goto L_0x002b
        L_0x002a:
            r0 = 1
        L_0x002b:
            javax.mail.Session r2 = r1.session
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r5 = r1.name
            r4.append(r5)
            java.lang.String r5 = ".auth"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r2 = r2.getProperty(r4)
            if (r2 == 0) goto L_0x0050
            java.lang.String r4 = "true"
            boolean r2 = r2.equalsIgnoreCase(r4)
            if (r2 == 0) goto L_0x0050
            r2 = 1
            goto L_0x0051
        L_0x0050:
            r2 = 0
        L_0x0051:
            boolean r4 = r1.debug
            if (r4 == 0) goto L_0x0070
            java.io.PrintStream r4 = r1.out
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "DEBUG SMTP: useEhlo "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r6 = ", useAuth "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            r4.println(r5)
        L_0x0070:
            if (r2 == 0) goto L_0x0077
            if (r17 == 0) goto L_0x0076
            if (r18 != 0) goto L_0x0077
        L_0x0076:
            return r9
        L_0x0077:
            r10 = -1
            r4 = r16
            if (r4 != r10) goto L_0x009f
            javax.mail.Session r4 = r1.session
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = r1.name
            r5.append(r3)
            java.lang.String r3 = ".port"
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.String r3 = r4.getProperty(r3)
            if (r3 == 0) goto L_0x009c
            int r3 = java.lang.Integer.parseInt(r3)
            goto L_0x00a0
        L_0x009c:
            int r3 = r1.defaultPort
            goto L_0x00a0
        L_0x009f:
            r3 = r4
        L_0x00a0:
            if (r15 == 0) goto L_0x00ab
            int r4 = r15.length()
            if (r4 != 0) goto L_0x00a9
            goto L_0x00ab
        L_0x00a9:
            r4 = r15
            goto L_0x00ad
        L_0x00ab:
            java.lang.String r4 = "localhost"
        L_0x00ad:
            java.net.Socket r5 = r1.serverSocket
            if (r5 == 0) goto L_0x00b5
            r14.openServer()
            goto L_0x00b8
        L_0x00b5:
            r14.openServer(r4, r3)
        L_0x00b8:
            if (r0 == 0) goto L_0x00c3
            java.lang.String r0 = r14.getLocalHost()
            boolean r0 = r14.ehlo(r0)
            goto L_0x00c4
        L_0x00c3:
            r0 = 0
        L_0x00c4:
            if (r0 != 0) goto L_0x00cd
            java.lang.String r0 = r14.getLocalHost()
            r14.helo(r0)
        L_0x00cd:
            boolean r0 = r1.useStartTLS
            if (r0 == 0) goto L_0x00e3
            java.lang.String r0 = "STARTTLS"
            boolean r0 = r14.supportsExtension(r0)
            if (r0 == 0) goto L_0x00e3
            r14.startTLS()
            java.lang.String r0 = r14.getLocalHost()
            r14.ehlo(r0)
        L_0x00e3:
            if (r2 != 0) goto L_0x00e9
            if (r17 == 0) goto L_0x0244
            if (r18 == 0) goto L_0x0244
        L_0x00e9:
            java.lang.String r0 = "AUTH"
            boolean r0 = r14.supportsExtension(r0)
            java.lang.String r2 = "AUTH=LOGIN"
            if (r0 != 0) goto L_0x00f9
            boolean r0 = r14.supportsExtension(r2)
            if (r0 == 0) goto L_0x0244
        L_0x00f9:
            boolean r0 = r1.debug
            java.lang.String r3 = "LOGIN"
            if (r0 == 0) goto L_0x0119
            java.io.PrintStream r0 = r1.out
            java.lang.String r5 = "DEBUG SMTP: Attempt to authenticate"
            r0.println(r5)
            boolean r0 = r14.supportsAuthentication(r3)
            if (r0 != 0) goto L_0x0119
            boolean r0 = r14.supportsExtension(r2)
            if (r0 == 0) goto L_0x0119
            java.io.PrintStream r0 = r1.out
            java.lang.String r5 = "DEBUG SMTP: use AUTH=LOGIN hack"
            r0.println(r5)
        L_0x0119:
            boolean r0 = r14.supportsAuthentication(r3)
            r3 = 2147483647(0x7fffffff, float:NaN)
            r11 = 334(0x14e, float:4.68E-43)
            r12 = 235(0xeb, float:3.3E-43)
            if (r0 != 0) goto L_0x01e6
            boolean r0 = r14.supportsExtension(r2)
            if (r0 == 0) goto L_0x012e
            goto L_0x01e6
        L_0x012e:
            java.lang.String r0 = "PLAIN"
            boolean r0 = r14.supportsAuthentication(r0)
            if (r0 == 0) goto L_0x017c
            java.lang.String r0 = "AUTH PLAIN"
            int r2 = r14.simpleCommand((java.lang.String) r0)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            r0.<init>()     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            com.sun.mail.util.BASE64EncoderStream r4 = new com.sun.mail.util.BASE64EncoderStream     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            r4.<init>(r0, r3)     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            if (r2 != r11) goto L_0x0167
            r4.write(r9)     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            byte[] r3 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r17)     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            r4.write(r3)     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            r4.write(r9)     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            byte[] r3 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r18)     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            r4.write(r3)     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            r4.flush()     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            byte[] r0 = r0.toByteArray()     // Catch:{ IOException -> 0x0175, all -> 0x016d }
            int r2 = r14.simpleCommand((byte[]) r0)     // Catch:{ IOException -> 0x0175, all -> 0x016d }
        L_0x0167:
            if (r2 == r12) goto L_0x0244
            r14.closeConnection()
            return r9
        L_0x016d:
            r0 = move-exception
            if (r2 == r12) goto L_0x0174
            r14.closeConnection()
            return r9
        L_0x0174:
            throw r0
        L_0x0175:
            if (r2 == r12) goto L_0x0244
            r14.closeConnection()
            return r9
        L_0x017c:
            java.lang.String r0 = "DIGEST-MD5"
            boolean r0 = r14.supportsAuthentication(r0)
            if (r0 == 0) goto L_0x0244
            com.sun.mail.smtp.DigestMD5 r0 = r14.getMD5()
            if (r0 == 0) goto L_0x0244
            java.lang.String r2 = "AUTH DIGEST-MD5"
            int r13 = r14.simpleCommand((java.lang.String) r2)
            if (r13 != r11) goto L_0x01df
            java.lang.String r6 = r14.getSASLRealm()     // Catch:{ Exception -> 0x01ba }
            java.lang.String r7 = r1.lastServerResponse     // Catch:{ Exception -> 0x01ba }
            r2 = r0
            r3 = r4
            r4 = r17
            r5 = r18
            byte[] r2 = r2.authClient(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01ba }
            int r13 = r14.simpleCommand((byte[]) r2)     // Catch:{ Exception -> 0x01ba }
            if (r13 != r11) goto L_0x01df
            java.lang.String r2 = r1.lastServerResponse     // Catch:{ Exception -> 0x01ba }
            boolean r0 = r0.authServer(r2)     // Catch:{ Exception -> 0x01ba }
            if (r0 != 0) goto L_0x01b1
            goto L_0x01e0
        L_0x01b1:
            byte[] r0 = new byte[r9]     // Catch:{ Exception -> 0x01ba }
            int r10 = r14.simpleCommand((byte[]) r0)     // Catch:{ Exception -> 0x01ba }
            goto L_0x01e0
        L_0x01b8:
            r0 = move-exception
            goto L_0x01d8
        L_0x01ba:
            r0 = move-exception
            boolean r2 = r1.debug     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x01d2
            java.io.PrintStream r2 = r1.out     // Catch:{ all -> 0x01b8 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = "DEBUG SMTP: DIGEST-MD5: "
            r3.<init>(r4)     // Catch:{ all -> 0x01b8 }
            r3.append(r0)     // Catch:{ all -> 0x01b8 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01b8 }
            r2.println(r0)     // Catch:{ all -> 0x01b8 }
        L_0x01d2:
            if (r13 == r12) goto L_0x0244
            r14.closeConnection()
            return r9
        L_0x01d8:
            if (r13 == r12) goto L_0x01de
            r14.closeConnection()
            return r9
        L_0x01de:
            throw r0
        L_0x01df:
            r10 = r13
        L_0x01e0:
            if (r10 == r12) goto L_0x0244
            r14.closeConnection()
            return r9
        L_0x01e6:
            java.lang.String r0 = "AUTH LOGIN"
            int r2 = r14.simpleCommand((java.lang.String) r0)
            r4 = 530(0x212, float:7.43E-43)
            if (r2 != r4) goto L_0x01f7
            r14.startTLS()
            int r2 = r14.simpleCommand((java.lang.String) r0)
        L_0x01f7:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            r0.<init>()     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            com.sun.mail.util.BASE64EncoderStream r4 = new com.sun.mail.util.BASE64EncoderStream     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            r4.<init>(r0, r3)     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            if (r2 != r11) goto L_0x0218
            byte[] r3 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r17)     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            r4.write(r3)     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            r4.flush()     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            byte[] r3 = r0.toByteArray()     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            int r2 = r14.simpleCommand((byte[]) r3)     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            r0.reset()     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
        L_0x0218:
            if (r2 != r11) goto L_0x022f
            byte[] r3 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r18)     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            r4.write(r3)     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            r4.flush()     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            byte[] r3 = r0.toByteArray()     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            int r2 = r14.simpleCommand((byte[]) r3)     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
            r0.reset()     // Catch:{ IOException -> 0x023d, all -> 0x0235 }
        L_0x022f:
            if (r2 == r12) goto L_0x0244
            r14.closeConnection()
            return r9
        L_0x0235:
            r0 = move-exception
            if (r2 == r12) goto L_0x023c
            r14.closeConnection()
            return r9
        L_0x023c:
            throw r0
        L_0x023d:
            if (r2 == r12) goto L_0x0244
            r14.closeConnection()
            return r9
        L_0x0244:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.protocolConnect(java.lang.String, int, java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x020a, code lost:
        r7.lastServerResponse = r1;
        r7.lastReturnCode = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x020e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x027d, code lost:
        if (r12 == null) goto L_0x02eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02b6, code lost:
        if (r4 != false) goto L_0x02b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02b8, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02b9, code lost:
        r1.addElement(r11);
        r8 = new com.sun.mail.smtp.SMTPAddressFailedException(r11, r6, r13, r7.lastServerResponse);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02c3, code lost:
        if (r12 != null) goto L_0x02c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02d7, code lost:
        if (r12 == null) goto L_0x02eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02e9, code lost:
        if (r12 == null) goto L_0x02eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02eb, code lost:
        r12 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01ef, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01f0, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01f3, code lost:
        if (r7.debug != false) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f5, code lost:
        r3.printStackTrace(r7.out);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:90:0x01eb */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x00a1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rcptTo() throws javax.mail.MessagingException {
        /*
            r16 = this;
            r7 = r16
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
            java.util.Vector r1 = new java.util.Vector
            r1.<init>()
            java.util.Vector r2 = new java.util.Vector
            r2.<init>()
            r3 = 0
            r7.invalidAddr = r3
            r7.validUnsentAddr = r3
            r7.validSentAddr = r3
            javax.mail.internet.MimeMessage r4 = r7.message
            boolean r5 = r4 instanceof com.sun.mail.smtp.SMTPMessage
            if (r5 == 0) goto L_0x0025
            com.sun.mail.smtp.SMTPMessage r4 = (com.sun.mail.smtp.SMTPMessage) r4
            boolean r4 = r4.getSendPartial()
            goto L_0x0026
        L_0x0025:
            r4 = 0
        L_0x0026:
            java.lang.String r5 = "mail."
            r8 = 1
            if (r4 != 0) goto L_0x0051
            javax.mail.Session r4 = r7.session
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r5)
            java.lang.String r10 = r7.name
            r9.append(r10)
            java.lang.String r10 = ".sendpartial"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r4 = r4.getProperty(r9)
            if (r4 == 0) goto L_0x0050
            java.lang.String r9 = "true"
            boolean r4 = r4.equalsIgnoreCase(r9)
            if (r4 == 0) goto L_0x0050
            r4 = 1
            goto L_0x0051
        L_0x0050:
            r4 = 0
        L_0x0051:
            boolean r9 = r7.debug
            if (r9 == 0) goto L_0x005e
            if (r4 == 0) goto L_0x005e
            java.io.PrintStream r9 = r7.out
            java.lang.String r10 = "DEBUG SMTP: sendPartial set"
            r9.println(r10)
        L_0x005e:
            java.lang.String r9 = "DSN"
            boolean r9 = r7.supportsExtension(r9)
            if (r9 == 0) goto L_0x0093
            javax.mail.internet.MimeMessage r9 = r7.message
            boolean r10 = r9 instanceof com.sun.mail.smtp.SMTPMessage
            if (r10 == 0) goto L_0x0073
            com.sun.mail.smtp.SMTPMessage r9 = (com.sun.mail.smtp.SMTPMessage) r9
            java.lang.String r9 = r9.getDSNNotify()
            goto L_0x0074
        L_0x0073:
            r9 = r3
        L_0x0074:
            if (r9 != 0) goto L_0x008f
            javax.mail.Session r9 = r7.session
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r5)
            java.lang.String r5 = r7.name
            r10.append(r5)
            java.lang.String r5 = ".dsn.notify"
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            java.lang.String r9 = r9.getProperty(r5)
        L_0x008f:
            if (r9 == 0) goto L_0x0094
            r5 = 1
            goto L_0x0095
        L_0x0093:
            r9 = r3
        L_0x0094:
            r5 = 0
        L_0x0095:
            r12 = r3
            r3 = 0
            r10 = 0
        L_0x0098:
            javax.mail.Address[] r11 = r7.addresses
            int r13 = r11.length
            java.lang.String r14 = "RSET"
            r15 = 250(0xfa, float:3.5E-43)
            if (r3 < r13) goto L_0x0210
            if (r4 == 0) goto L_0x00aa
            int r3 = r0.size()
            if (r3 != 0) goto L_0x00aa
            r10 = 1
        L_0x00aa:
            if (r10 == 0) goto L_0x00f4
            int r3 = r2.size()
            javax.mail.Address[] r3 = new javax.mail.Address[r3]
            r7.invalidAddr = r3
            r2.copyInto(r3)
            int r2 = r0.size()
            int r3 = r1.size()
            int r2 = r2 + r3
            javax.mail.Address[] r2 = new javax.mail.Address[r2]
            r7.validUnsentAddr = r2
            r2 = 0
            r3 = 0
        L_0x00c6:
            int r4 = r0.size()
            if (r2 < r4) goto L_0x00e4
            r0 = 0
        L_0x00cd:
            int r2 = r1.size()
            if (r0 < r2) goto L_0x00d4
            goto L_0x0131
        L_0x00d4:
            javax.mail.Address[] r2 = r7.validUnsentAddr
            int r4 = r3 + 1
            java.lang.Object r5 = r1.elementAt(r0)
            javax.mail.Address r5 = (javax.mail.Address) r5
            r2[r3] = r5
            int r0 = r0 + 1
            r3 = r4
            goto L_0x00cd
        L_0x00e4:
            javax.mail.Address[] r4 = r7.validUnsentAddr
            int r5 = r3 + 1
            java.lang.Object r8 = r0.elementAt(r2)
            javax.mail.Address r8 = (javax.mail.Address) r8
            r4[r3] = r8
            int r2 = r2 + 1
            r3 = r5
            goto L_0x00c6
        L_0x00f4:
            boolean r3 = r7.reportSuccess
            if (r3 != 0) goto L_0x010c
            if (r4 == 0) goto L_0x0107
            int r3 = r2.size()
            if (r3 > 0) goto L_0x010c
            int r3 = r1.size()
            if (r3 <= 0) goto L_0x0107
            goto L_0x010c
        L_0x0107:
            javax.mail.Address[] r0 = r7.addresses
            r7.validSentAddr = r0
            goto L_0x0131
        L_0x010c:
            r7.sendPartiallyFailed = r8
            r7.exception = r12
            int r3 = r2.size()
            javax.mail.Address[] r3 = new javax.mail.Address[r3]
            r7.invalidAddr = r3
            r2.copyInto(r3)
            int r2 = r1.size()
            javax.mail.Address[] r2 = new javax.mail.Address[r2]
            r7.validUnsentAddr = r2
            r1.copyInto(r2)
            int r1 = r0.size()
            javax.mail.Address[] r1 = new javax.mail.Address[r1]
            r7.validSentAddr = r1
            r0.copyInto(r1)
        L_0x0131:
            boolean r0 = r7.debug
            if (r0 == 0) goto L_0x01be
            javax.mail.Address[] r0 = r7.validSentAddr
            java.lang.String r1 = "DEBUG SMTP:   "
            if (r0 == 0) goto L_0x0164
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0164
            java.io.PrintStream r0 = r7.out
            java.lang.String r2 = "DEBUG SMTP: Verified Addresses"
            r0.println(r2)
            r0 = 0
        L_0x0146:
            javax.mail.Address[] r2 = r7.validSentAddr
            int r2 = r2.length
            if (r0 < r2) goto L_0x014c
            goto L_0x0164
        L_0x014c:
            java.io.PrintStream r2 = r7.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            javax.mail.Address[] r4 = r7.validSentAddr
            r4 = r4[r0]
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
            int r0 = r0 + 1
            goto L_0x0146
        L_0x0164:
            javax.mail.Address[] r0 = r7.validUnsentAddr
            if (r0 == 0) goto L_0x0191
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0191
            java.io.PrintStream r0 = r7.out
            java.lang.String r2 = "DEBUG SMTP: Valid Unsent Addresses"
            r0.println(r2)
            r0 = 0
        L_0x0173:
            javax.mail.Address[] r2 = r7.validUnsentAddr
            int r2 = r2.length
            if (r0 < r2) goto L_0x0179
            goto L_0x0191
        L_0x0179:
            java.io.PrintStream r2 = r7.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            javax.mail.Address[] r4 = r7.validUnsentAddr
            r4 = r4[r0]
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
            int r0 = r0 + 1
            goto L_0x0173
        L_0x0191:
            javax.mail.Address[] r0 = r7.invalidAddr
            if (r0 == 0) goto L_0x01be
            int r0 = r0.length
            if (r0 <= 0) goto L_0x01be
            java.io.PrintStream r0 = r7.out
            java.lang.String r2 = "DEBUG SMTP: Invalid Addresses"
            r0.println(r2)
            r6 = 0
        L_0x01a0:
            javax.mail.Address[] r0 = r7.invalidAddr
            int r0 = r0.length
            if (r6 < r0) goto L_0x01a6
            goto L_0x01be
        L_0x01a6:
            java.io.PrintStream r0 = r7.out
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            javax.mail.Address[] r3 = r7.invalidAddr
            r3 = r3[r6]
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.println(r2)
            int r6 = r6 + 1
            goto L_0x01a0
        L_0x01be:
            if (r10 == 0) goto L_0x020f
            boolean r0 = r7.debug
            if (r0 == 0) goto L_0x01cb
            java.io.PrintStream r0 = r7.out
            java.lang.String r1 = "DEBUG SMTP: Sending failed because of invalid destination addresses"
            r0.println(r1)
        L_0x01cb:
            r2 = 2
            javax.mail.Address[] r3 = r7.validSentAddr
            javax.mail.Address[] r4 = r7.validUnsentAddr
            javax.mail.Address[] r5 = r7.invalidAddr
            javax.mail.internet.MimeMessage r6 = r7.message
            r1 = r16
            r1.notifyTransportListeners(r2, r3, r4, r5, r6)
            java.lang.String r1 = r7.lastServerResponse
            int r2 = r7.lastReturnCode
            java.net.Socket r0 = r7.serverSocket     // Catch:{ MessagingException -> 0x01eb }
            if (r0 == 0) goto L_0x01e4
            r7.issueCommand(r14, r15)     // Catch:{ MessagingException -> 0x01eb }
        L_0x01e4:
            r7.lastServerResponse = r1
            r7.lastReturnCode = r2
            goto L_0x01fb
        L_0x01e9:
            r0 = move-exception
            goto L_0x020a
        L_0x01eb:
            r16.close()     // Catch:{ MessagingException -> 0x01ef }
            goto L_0x01e4
        L_0x01ef:
            r0 = move-exception
            r3 = r0
            boolean r0 = r7.debug     // Catch:{ all -> 0x01e9 }
            if (r0 == 0) goto L_0x01e4
            java.io.PrintStream r0 = r7.out     // Catch:{ all -> 0x01e9 }
            r3.printStackTrace(r0)     // Catch:{ all -> 0x01e9 }
            goto L_0x01e4
        L_0x01fb:
            javax.mail.SendFailedException r0 = new javax.mail.SendFailedException
            javax.mail.Address[] r13 = r7.validSentAddr
            javax.mail.Address[] r14 = r7.validUnsentAddr
            javax.mail.Address[] r15 = r7.invalidAddr
            java.lang.String r11 = "Invalid Addresses"
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15)
            throw r0
        L_0x020a:
            r7.lastServerResponse = r1
            r7.lastReturnCode = r2
            throw r0
        L_0x020f:
            return
        L_0x0210:
            r11 = r11[r3]
            javax.mail.internet.InternetAddress r11 = (javax.mail.internet.InternetAddress) r11
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r6 = "RCPT TO:"
            r13.<init>(r6)
            java.lang.String r6 = r11.getAddress()
            java.lang.String r6 = r7.normalizeAddress(r6)
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            if (r5 == 0) goto L_0x0241
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r13.<init>(r6)
            java.lang.String r6 = " NOTIFY="
            r13.append(r6)
            r13.append(r9)
            java.lang.String r6 = r13.toString()
        L_0x0241:
            r7.sendCommand((java.lang.String) r6)
            int r13 = r16.readServerResponse()
            if (r13 == r15) goto L_0x02da
            r8 = 251(0xfb, float:3.52E-43)
            if (r13 == r8) goto L_0x02da
            r8 = 501(0x1f5, float:7.02E-43)
            if (r13 == r8) goto L_0x02ca
            r8 = 503(0x1f7, float:7.05E-43)
            if (r13 == r8) goto L_0x02ca
            switch(r13) {
                case 450: goto L_0x02b6;
                case 451: goto L_0x02b6;
                case 452: goto L_0x02b6;
                default: goto L_0x0259;
            }
        L_0x0259:
            switch(r13) {
                case 550: goto L_0x02ca;
                case 551: goto L_0x02ca;
                case 552: goto L_0x02b6;
                case 553: goto L_0x02ca;
                default: goto L_0x025c;
            }
        L_0x025c:
            r8 = 400(0x190, float:5.6E-43)
            if (r13 < r8) goto L_0x0268
            r8 = 499(0x1f3, float:6.99E-43)
            if (r13 > r8) goto L_0x0268
            r1.addElement(r11)
            goto L_0x0273
        L_0x0268:
            r8 = 500(0x1f4, float:7.0E-43)
            if (r13 < r8) goto L_0x0280
            r8 = 599(0x257, float:8.4E-43)
            if (r13 > r8) goto L_0x0280
            r2.addElement(r11)
        L_0x0273:
            if (r4 != 0) goto L_0x0276
            r10 = 1
        L_0x0276:
            com.sun.mail.smtp.SMTPAddressFailedException r8 = new com.sun.mail.smtp.SMTPAddressFailedException
            java.lang.String r14 = r7.lastServerResponse
            r8.<init>(r11, r6, r13, r14)
            if (r12 != 0) goto L_0x02c6
            goto L_0x02eb
        L_0x0280:
            boolean r0 = r7.debug
            if (r0 == 0) goto L_0x02a1
            java.io.PrintStream r0 = r7.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG SMTP: got response code "
            r1.<init>(r2)
            r1.append(r13)
            java.lang.String r2 = ", with response: "
            r1.append(r2)
            java.lang.String r2 = r7.lastServerResponse
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
        L_0x02a1:
            java.lang.String r0 = r7.lastServerResponse
            int r1 = r7.lastReturnCode
            java.net.Socket r2 = r7.serverSocket
            if (r2 == 0) goto L_0x02ac
            r7.issueCommand(r14, r15)
        L_0x02ac:
            r7.lastServerResponse = r0
            r7.lastReturnCode = r1
            com.sun.mail.smtp.SMTPAddressFailedException r1 = new com.sun.mail.smtp.SMTPAddressFailedException
            r1.<init>(r11, r6, r13, r0)
            throw r1
        L_0x02b6:
            if (r4 != 0) goto L_0x02b9
            r10 = 1
        L_0x02b9:
            r1.addElement(r11)
            com.sun.mail.smtp.SMTPAddressFailedException r8 = new com.sun.mail.smtp.SMTPAddressFailedException
            java.lang.String r14 = r7.lastServerResponse
            r8.<init>(r11, r6, r13, r14)
            if (r12 != 0) goto L_0x02c6
            goto L_0x02eb
        L_0x02c6:
            r12.setNextException(r8)
            goto L_0x02ec
        L_0x02ca:
            if (r4 != 0) goto L_0x02cd
            r10 = 1
        L_0x02cd:
            r2.addElement(r11)
            com.sun.mail.smtp.SMTPAddressFailedException r8 = new com.sun.mail.smtp.SMTPAddressFailedException
            java.lang.String r14 = r7.lastServerResponse
            r8.<init>(r11, r6, r13, r14)
            if (r12 != 0) goto L_0x02c6
            goto L_0x02eb
        L_0x02da:
            r0.addElement(r11)
            boolean r8 = r7.reportSuccess
            if (r8 != 0) goto L_0x02e2
            goto L_0x02ec
        L_0x02e2:
            com.sun.mail.smtp.SMTPAddressSucceededException r8 = new com.sun.mail.smtp.SMTPAddressSucceededException
            java.lang.String r14 = r7.lastServerResponse
            r8.<init>(r11, r6, r13, r14)
            if (r12 != 0) goto L_0x02c6
        L_0x02eb:
            r12 = r8
        L_0x02ec:
            int r3 = r3 + 1
            r8 = 1
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.rcptTo():void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        if (r6.debug == false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        r1.printStackTrace(r6.out);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0070, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
        if (r6.debug == false) goto L_0x0076;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:20:0x005d, B:26:0x006c] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x005d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int readServerResponse() throws javax.mail.MessagingException {
        /*
            r6 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r1 = 100
            r0.<init>(r1)
        L_0x0007:
            r1 = 0
            com.sun.mail.util.LineInputStream r2 = r6.lineInputStream     // Catch:{ IOException -> 0x0095 }
            java.lang.String r2 = r2.readLine()     // Catch:{ IOException -> 0x0095 }
            r3 = -1
            if (r2 != 0) goto L_0x0039
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0095 }
            int r2 = r0.length()     // Catch:{ IOException -> 0x0095 }
            if (r2 != 0) goto L_0x001d
            java.lang.String r0 = "[EOF]"
        L_0x001d:
            r6.lastServerResponse = r0     // Catch:{ IOException -> 0x0095 }
            r6.lastReturnCode = r3     // Catch:{ IOException -> 0x0095 }
            boolean r2 = r6.debug     // Catch:{ IOException -> 0x0095 }
            if (r2 == 0) goto L_0x0038
            java.io.PrintStream r2 = r6.out     // Catch:{ IOException -> 0x0095 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0095 }
            java.lang.String r5 = "DEBUG SMTP: EOF: "
            r4.<init>(r5)     // Catch:{ IOException -> 0x0095 }
            r4.append(r0)     // Catch:{ IOException -> 0x0095 }
            java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x0095 }
            r2.println(r0)     // Catch:{ IOException -> 0x0095 }
        L_0x0038:
            return r3
        L_0x0039:
            r0.append(r2)     // Catch:{ IOException -> 0x0095 }
            java.lang.String r4 = "\n"
            r0.append(r4)     // Catch:{ IOException -> 0x0095 }
            boolean r2 = r6.isNotLastLine(r2)     // Catch:{ IOException -> 0x0095 }
            if (r2 != 0) goto L_0x0007
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0095 }
            if (r0 == 0) goto L_0x0076
            int r2 = r0.length()
            r4 = 3
            if (r2 < r4) goto L_0x0076
            java.lang.String r1 = r0.substring(r1, r4)     // Catch:{ NumberFormatException -> 0x006c, StringIndexOutOfBoundsException -> 0x005d }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x006c, StringIndexOutOfBoundsException -> 0x005d }
            goto L_0x0077
        L_0x005d:
            r6.close()     // Catch:{ MessagingException -> 0x0061 }
            goto L_0x0076
        L_0x0061:
            r1 = move-exception
            boolean r2 = r6.debug
            if (r2 == 0) goto L_0x0076
        L_0x0066:
            java.io.PrintStream r2 = r6.out
            r1.printStackTrace(r2)
            goto L_0x0076
        L_0x006c:
            r6.close()     // Catch:{ MessagingException -> 0x0070 }
            goto L_0x0076
        L_0x0070:
            r1 = move-exception
            boolean r2 = r6.debug
            if (r2 == 0) goto L_0x0076
            goto L_0x0066
        L_0x0076:
            r1 = -1
        L_0x0077:
            if (r1 != r3) goto L_0x0090
            boolean r2 = r6.debug
            if (r2 == 0) goto L_0x0090
            java.io.PrintStream r2 = r6.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "DEBUG SMTP: bad server response: "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
        L_0x0090:
            r6.lastServerResponse = r0
            r6.lastReturnCode = r1
            return r1
        L_0x0095:
            r0 = move-exception
            boolean r2 = r6.debug
            if (r2 == 0) goto L_0x00ad
            java.io.PrintStream r2 = r6.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "DEBUG SMTP: exception reading response: "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
        L_0x00ad:
            java.lang.String r2 = ""
            r6.lastServerResponse = r2
            r6.lastReturnCode = r1
            javax.mail.MessagingException r1 = new javax.mail.MessagingException
            java.lang.String r2 = "Exception reading response"
            r1.<init>(r2, r0)
            goto L_0x00bc
        L_0x00bb:
            throw r1
        L_0x00bc:
            goto L_0x00bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.readServerResponse():int");
    }

    /* access modifiers changed from: protected */
    public void sendCommand(String str) throws MessagingException {
        sendCommand(ASCIIUtility.getBytes(str));
    }

    public synchronized void sendMessage(Message message2, Address[] addressArr) throws MessagingException, SendFailedException {
        Message message3 = message2;
        Address[] addressArr2 = addressArr;
        synchronized (this) {
            checkConnected();
            if (!(message3 instanceof MimeMessage)) {
                if (this.debug) {
                    this.out.println("DEBUG SMTP: Can only send RFC822 msgs");
                }
                throw new MessagingException("SMTP can only send RFC822 messages");
            }
            int i2 = 0;
            while (i2 < addressArr2.length) {
                if (addressArr2[i2] instanceof InternetAddress) {
                    i2++;
                } else {
                    throw new MessagingException(addressArr2[i2] + " is not an InternetAddress");
                }
            }
            this.message = (MimeMessage) message3;
            this.addresses = addressArr2;
            this.validUnsentAddr = addressArr2;
            expandGroups();
            boolean allow8bitMIME = message3 instanceof SMTPMessage ? ((SMTPMessage) message3).getAllow8bitMIME() : false;
            if (!allow8bitMIME) {
                Session session = this.session;
                String property = session.getProperty("mail." + this.name + ".allow8bitmime");
                allow8bitMIME = property != null && property.equalsIgnoreCase("true");
            }
            if (this.debug) {
                PrintStream printStream = this.out;
                printStream.println("DEBUG SMTP: use8bit " + allow8bitMIME);
            }
            if (allow8bitMIME && supportsExtension("8BITMIME") && convertTo8Bit(this.message)) {
                try {
                    this.message.saveChanges();
                } catch (MessagingException unused) {
                }
            }
            try {
                mailFrom();
                rcptTo();
                this.message.writeTo(data(), ignoreList);
                finishData();
                if (this.sendPartiallyFailed) {
                    if (this.debug) {
                        this.out.println("DEBUG SMTP: Sending partially failed because of invalid destination addresses");
                    }
                    notifyTransportListeners(3, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                    throw new SMTPSendFailedException(".", this.lastReturnCode, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
                }
                notifyTransportListeners(1, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                this.invalidAddr = null;
                this.validUnsentAddr = null;
                this.validSentAddr = null;
                this.addresses = null;
                this.message = null;
                this.exception = null;
                this.sendPartiallyFailed = false;
            } catch (MessagingException e2) {
                if (this.debug) {
                    e2.printStackTrace(this.out);
                }
                notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                throw e2;
            } catch (IOException e3) {
                if (this.debug) {
                    e3.printStackTrace(this.out);
                }
                try {
                    closeConnection();
                } catch (MessagingException unused2) {
                }
                notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                throw new MessagingException("IOException while sending message", e3);
            } catch (Throwable th) {
                this.invalidAddr = null;
                this.validUnsentAddr = null;
                this.validSentAddr = null;
                this.addresses = null;
                this.message = null;
                this.exception = null;
                this.sendPartiallyFailed = false;
                throw th;
            }
        }
    }

    public synchronized void setLocalHost(String str) {
        this.localHostName = str;
    }

    public synchronized void setReportSuccess(boolean z2) {
        this.reportSuccess = z2;
    }

    public synchronized void setSASLRealm(String str) {
        this.saslRealm = str;
    }

    public synchronized void setStartTLS(boolean z2) {
        this.useStartTLS = z2;
    }

    public synchronized void setUseRset(boolean z2) {
        this.useRset = z2;
    }

    public synchronized int simpleCommand(String str) throws MessagingException {
        sendCommand(str);
        return readServerResponse();
    }

    /* access modifiers changed from: protected */
    public int simpleCommand(byte[] bArr) throws MessagingException {
        sendCommand(bArr);
        return readServerResponse();
    }

    /* access modifiers changed from: protected */
    public void startTLS() throws MessagingException {
        issueCommand("STARTTLS", 220);
        try {
            Socket socket = this.serverSocket;
            Properties properties = this.session.getProperties();
            this.serverSocket = SocketFetcher.startTLS(socket, properties, "mail." + this.name);
            initStreams();
        } catch (IOException e2) {
            closeConnection();
            throw new MessagingException("Could not convert socket to TLS", e2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean supportsAuthentication(String str) {
        String str2;
        Hashtable hashtable = this.extMap;
        if (hashtable == null || (str2 = (String) hashtable.get("AUTH")) == null) {
            return false;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str2);
        while (stringTokenizer.hasMoreTokens()) {
            if (stringTokenizer.nextToken().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean supportsExtension(String str) {
        Hashtable hashtable = this.extMap;
        return (hashtable == null || hashtable.get(str.toUpperCase(Locale.ENGLISH)) == null) ? false : true;
    }
}
