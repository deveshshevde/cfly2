package com.sun.mail.iap;

import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Vector;

public class Protocol {
    private static final byte[] CRLF = {13, 10};
    private boolean connected;
    protected boolean debug;
    private volatile Vector handlers;
    protected String host;
    private volatile ResponseInputStream input;
    protected PrintStream out;
    private volatile DataOutputStream output;
    protected String prefix;
    protected Properties props;
    protected boolean quote;
    private Socket socket;
    private int tagCounter;
    private volatile long timestamp;
    private TraceInputStream traceInput;
    private TraceOutputStream traceOutput;

    public Protocol(InputStream inputStream, OutputStream outputStream, boolean z2) throws IOException {
        this.connected = false;
        this.tagCounter = 0;
        this.handlers = null;
        this.host = "localhost";
        this.debug = z2;
        this.quote = false;
        this.out = System.out;
        TraceInputStream traceInputStream = new TraceInputStream(inputStream, System.out);
        this.traceInput = traceInputStream;
        traceInputStream.setTrace(z2);
        this.traceInput.setQuote(this.quote);
        this.input = new ResponseInputStream(this.traceInput);
        TraceOutputStream traceOutputStream = new TraceOutputStream(outputStream, System.out);
        this.traceOutput = traceOutputStream;
        traceOutputStream.setTrace(z2);
        this.traceOutput.setQuote(this.quote);
        this.output = new DataOutputStream(new BufferedOutputStream(this.traceOutput));
        this.timestamp = System.currentTimeMillis();
    }

    public Protocol(String str, int i2, boolean z2, PrintStream printStream, Properties properties, String str2, boolean z3) throws IOException, ProtocolException {
        boolean z4 = false;
        this.connected = false;
        this.tagCounter = 0;
        this.handlers = null;
        try {
            this.host = str;
            this.debug = z2;
            this.out = printStream;
            this.props = properties;
            this.prefix = str2;
            this.socket = SocketFetcher.getSocket(str, i2, properties, str2, z3);
            String property = properties.getProperty("mail.debug.quote");
            if (property != null && property.equalsIgnoreCase("true")) {
                z4 = true;
            }
            this.quote = z4;
            initStreams(printStream);
            processGreeting(readResponse());
            this.timestamp = System.currentTimeMillis();
            this.connected = true;
        } catch (Throwable th) {
            if (!this.connected) {
                disconnect();
            }
            throw th;
        }
    }

    private void initStreams(PrintStream printStream) throws IOException {
        TraceInputStream traceInputStream = new TraceInputStream(this.socket.getInputStream(), printStream);
        this.traceInput = traceInputStream;
        traceInputStream.setTrace(this.debug);
        this.traceInput.setQuote(this.quote);
        this.input = new ResponseInputStream(this.traceInput);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.socket.getOutputStream(), printStream);
        this.traceOutput = traceOutputStream;
        traceOutputStream.setTrace(this.debug);
        this.traceOutput.setQuote(this.quote);
        this.output = new DataOutputStream(new BufferedOutputStream(this.traceOutput));
    }

    public synchronized void addResponseHandler(ResponseHandler responseHandler) {
        if (this.handlers == null) {
            this.handlers = new Vector();
        }
        this.handlers.addElement(responseHandler);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030 A[SYNTHETIC, Splitter:B:17:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x001f A[SYNTHETIC] */
    public synchronized com.sun.mail.iap.Response[] command(java.lang.String r5, com.sun.mail.iap.Argument r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Vector r0 = new java.util.Vector     // Catch:{ all -> 0x0057 }
            r0.<init>()     // Catch:{ all -> 0x0057 }
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r2 = r4.writeCommand(r5, r6)     // Catch:{ LiteralException -> 0x0014, Exception -> 0x000e }
            goto L_0x001d
        L_0x000e:
            r5 = move-exception
            com.sun.mail.iap.Response r5 = com.sun.mail.iap.Response.byeResponse(r5)     // Catch:{ all -> 0x0057 }
            goto L_0x0019
        L_0x0014:
            r5 = move-exception
            com.sun.mail.iap.Response r5 = r5.getResponse()     // Catch:{ all -> 0x0057 }
        L_0x0019:
            r0.addElement(r5)     // Catch:{ all -> 0x0057 }
        L_0x001c:
            r1 = 1
        L_0x001d:
            if (r1 == 0) goto L_0x0030
            int r5 = r0.size()     // Catch:{ all -> 0x0057 }
            com.sun.mail.iap.Response[] r5 = new com.sun.mail.iap.Response[r5]     // Catch:{ all -> 0x0057 }
            r0.copyInto(r5)     // Catch:{ all -> 0x0057 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0057 }
            r4.timestamp = r0     // Catch:{ all -> 0x0057 }
            monitor-exit(r4)
            return r5
        L_0x0030:
            com.sun.mail.iap.Response r5 = r4.readResponse()     // Catch:{ IOException -> 0x0037, ProtocolException -> 0x0035 }
            goto L_0x003c
        L_0x0035:
            goto L_0x001d
        L_0x0037:
            r5 = move-exception
            com.sun.mail.iap.Response r5 = com.sun.mail.iap.Response.byeResponse(r5)     // Catch:{ all -> 0x0057 }
        L_0x003c:
            r0.addElement(r5)     // Catch:{ all -> 0x0057 }
            boolean r6 = r5.isBYE()     // Catch:{ all -> 0x0057 }
            if (r6 == 0) goto L_0x0046
            r1 = 1
        L_0x0046:
            boolean r6 = r5.isTagged()     // Catch:{ all -> 0x0057 }
            if (r6 == 0) goto L_0x001d
            java.lang.String r5 = r5.getTag()     // Catch:{ all -> 0x0057 }
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x0057 }
            if (r5 == 0) goto L_0x001d
            goto L_0x001c
        L_0x0057:
            r5 = move-exception
            monitor-exit(r4)
            goto L_0x005b
        L_0x005a:
            throw r5
        L_0x005b:
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.iap.Protocol.command(java.lang.String, com.sun.mail.iap.Argument):com.sun.mail.iap.Response[]");
    }

    /* access modifiers changed from: protected */
    public synchronized void disconnect() {
        Socket socket2 = this.socket;
        if (socket2 != null) {
            try {
                socket2.close();
            } catch (IOException unused) {
            }
            this.socket = null;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        disconnect();
    }

    /* access modifiers changed from: protected */
    public ResponseInputStream getInputStream() {
        return this.input;
    }

    /* access modifiers changed from: protected */
    public OutputStream getOutputStream() {
        return this.output;
    }

    /* access modifiers changed from: protected */
    public ByteArray getResponseBuffer() {
        return null;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void handleResult(Response response) throws ProtocolException {
        if (!response.isOK()) {
            if (response.isNO()) {
                throw new CommandFailedException(response);
            } else if (response.isBAD()) {
                throw new BadCommandException(response);
            } else if (response.isBYE()) {
                disconnect();
                throw new ConnectionException(this, response);
            }
        }
    }

    public void notifyResponseHandlers(Response[] responseArr) {
        if (this.handlers != null) {
            for (Response response : responseArr) {
                if (response != null) {
                    int size = this.handlers.size();
                    if (size != 0) {
                        Object[] objArr = new Object[size];
                        this.handlers.copyInto(objArr);
                        for (int i2 = 0; i2 < size; i2++) {
                            ((ResponseHandler) objArr[i2]).handleResponse(response);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processGreeting(Response response) throws ProtocolException {
        if (response.isBYE()) {
            throw new ConnectionException(this, response);
        }
    }

    public Response readResponse() throws IOException, ProtocolException {
        return new Response(this);
    }

    public synchronized void removeResponseHandler(ResponseHandler responseHandler) {
        if (this.handlers != null) {
            this.handlers.removeElement(responseHandler);
        }
    }

    public void simpleCommand(String str, Argument argument) throws ProtocolException {
        Response[] command = command(str, argument);
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
    }

    public synchronized void startTLS(String str) throws IOException, ProtocolException {
        simpleCommand(str, (Argument) null);
        this.socket = SocketFetcher.startTLS(this.socket, this.props, this.prefix);
        initStreams(this.out);
    }

    /* access modifiers changed from: protected */
    public synchronized boolean supportsNonSyncLiterals() {
        return false;
    }

    public String writeCommand(String str, Argument argument) throws IOException, ProtocolException {
        StringBuilder sb = new StringBuilder("A");
        int i2 = this.tagCounter;
        this.tagCounter = i2 + 1;
        sb.append(Integer.toString(i2, 10));
        String sb2 = sb.toString();
        DataOutputStream dataOutputStream = this.output;
        dataOutputStream.writeBytes(String.valueOf(sb2) + " " + str);
        if (argument != null) {
            this.output.write(32);
            argument.write(this);
        }
        this.output.write(CRLF);
        this.output.flush();
        return sb2;
    }
}
