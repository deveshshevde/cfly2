package javax.mail;

import java.util.Vector;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.MailEvent;

public abstract class Service {
    private boolean connected = false;
    private Vector connectionListeners = null;
    protected boolean debug = false;

    /* renamed from: q  reason: collision with root package name */
    private EventQueue f29473q;
    private Object qLock = new Object();
    protected Session session;
    protected URLName url = null;

    static class TerminatorEvent extends MailEvent {
        private static final long serialVersionUID = 5542172141759168416L;

        TerminatorEvent() {
            super(new Object());
        }

        public void dispatch(Object obj) {
            Thread.currentThread().interrupt();
        }
    }

    protected Service(Session session2, URLName uRLName) {
        this.session = session2;
        this.url = uRLName;
        this.debug = session2.getDebug();
    }

    private void terminateQueue() {
        synchronized (this.qLock) {
            if (this.f29473q != null) {
                Vector vector = new Vector();
                vector.setSize(1);
                this.f29473q.enqueue(new TerminatorEvent(), vector);
                this.f29473q = null;
            }
        }
    }

    public synchronized void addConnectionListener(ConnectionListener connectionListener) {
        if (this.connectionListeners == null) {
            this.connectionListeners = new Vector();
        }
        this.connectionListeners.addElement(connectionListener);
    }

    public synchronized void close() throws MessagingException {
        setConnected(false);
        notifyConnectionListeners(3);
    }

    public void connect() throws MessagingException {
        connect((String) null, (String) null, (String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0102, code lost:
        if (r0.equals(r3.getUserName()) != false) goto L_0x00f5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011a A[SYNTHETIC, Splitter:B:66:0x011a] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x013b A[Catch:{ SecurityException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0144 A[Catch:{ SecurityException -> 0x00b9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void connect(java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21) throws javax.mail.MessagingException {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            monitor-enter(r17)
            boolean r2 = r17.isConnected()     // Catch:{ all -> 0x0173 }
            if (r2 != 0) goto L_0x016b
            javax.mail.URLName r2 = r1.url     // Catch:{ all -> 0x0173 }
            if (r2 == 0) goto L_0x005a
            java.lang.String r2 = r2.getProtocol()     // Catch:{ all -> 0x0173 }
            if (r18 != 0) goto L_0x001c
            javax.mail.URLName r4 = r1.url     // Catch:{ all -> 0x0173 }
            java.lang.String r4 = r4.getHost()     // Catch:{ all -> 0x0173 }
            goto L_0x001e
        L_0x001c:
            r4 = r18
        L_0x001e:
            r5 = -1
            r6 = r19
            if (r6 != r5) goto L_0x002a
            javax.mail.URLName r5 = r1.url     // Catch:{ all -> 0x0173 }
            int r5 = r5.getPort()     // Catch:{ all -> 0x0173 }
            goto L_0x002b
        L_0x002a:
            r5 = r6
        L_0x002b:
            if (r0 != 0) goto L_0x003c
            javax.mail.URLName r0 = r1.url     // Catch:{ all -> 0x0173 }
            java.lang.String r0 = r0.getUsername()     // Catch:{ all -> 0x0173 }
            if (r21 != 0) goto L_0x004d
            javax.mail.URLName r6 = r1.url     // Catch:{ all -> 0x0173 }
        L_0x0037:
            java.lang.String r6 = r6.getPassword()     // Catch:{ all -> 0x0173 }
            goto L_0x004f
        L_0x003c:
            if (r21 != 0) goto L_0x004d
            javax.mail.URLName r6 = r1.url     // Catch:{ all -> 0x0173 }
            java.lang.String r6 = r6.getUsername()     // Catch:{ all -> 0x0173 }
            boolean r6 = r0.equals(r6)     // Catch:{ all -> 0x0173 }
            if (r6 == 0) goto L_0x004d
            javax.mail.URLName r6 = r1.url     // Catch:{ all -> 0x0173 }
            goto L_0x0037
        L_0x004d:
            r6 = r21
        L_0x004f:
            javax.mail.URLName r7 = r1.url     // Catch:{ all -> 0x0173 }
            java.lang.String r7 = r7.getFile()     // Catch:{ all -> 0x0173 }
            r13 = r2
            r2 = r5
            r12 = r6
            r14 = r7
            goto L_0x0063
        L_0x005a:
            r6 = r19
            r4 = r18
            r12 = r21
            r2 = r6
            r13 = 0
            r14 = 0
        L_0x0063:
            if (r13 == 0) goto L_0x009b
            if (r4 != 0) goto L_0x0080
            javax.mail.Session r4 = r1.session     // Catch:{ all -> 0x0173 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0173 }
            java.lang.String r6 = "mail."
            r5.<init>(r6)     // Catch:{ all -> 0x0173 }
            r5.append(r13)     // Catch:{ all -> 0x0173 }
            java.lang.String r6 = ".host"
            r5.append(r6)     // Catch:{ all -> 0x0173 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0173 }
            java.lang.String r4 = r4.getProperty(r5)     // Catch:{ all -> 0x0173 }
        L_0x0080:
            if (r0 != 0) goto L_0x009b
            javax.mail.Session r0 = r1.session     // Catch:{ all -> 0x0173 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0173 }
            java.lang.String r6 = "mail."
            r5.<init>(r6)     // Catch:{ all -> 0x0173 }
            r5.append(r13)     // Catch:{ all -> 0x0173 }
            java.lang.String r6 = ".user"
            r5.append(r6)     // Catch:{ all -> 0x0173 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0173 }
            java.lang.String r0 = r0.getProperty(r5)     // Catch:{ all -> 0x0173 }
        L_0x009b:
            if (r4 != 0) goto L_0x00a5
            javax.mail.Session r4 = r1.session     // Catch:{ all -> 0x0173 }
            java.lang.String r5 = "mail.host"
            java.lang.String r4 = r4.getProperty(r5)     // Catch:{ all -> 0x0173 }
        L_0x00a5:
            if (r0 != 0) goto L_0x00af
            javax.mail.Session r0 = r1.session     // Catch:{ all -> 0x0173 }
            java.lang.String r5 = "mail.user"
            java.lang.String r0 = r0.getProperty(r5)     // Catch:{ all -> 0x0173 }
        L_0x00af:
            r5 = r0
            if (r5 != 0) goto L_0x00c7
            java.lang.String r0 = "user.name"
            java.lang.String r5 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x00b9 }
            goto L_0x00c7
        L_0x00b9:
            r0 = move-exception
            boolean r6 = r1.debug     // Catch:{ all -> 0x0173 }
            if (r6 == 0) goto L_0x00c7
            javax.mail.Session r6 = r1.session     // Catch:{ all -> 0x0173 }
            java.io.PrintStream r6 = r6.getDebugOut()     // Catch:{ all -> 0x0173 }
            r0.printStackTrace(r6)     // Catch:{ all -> 0x0173 }
        L_0x00c7:
            r0 = r5
            r11 = 1
            if (r12 != 0) goto L_0x0109
            javax.mail.URLName r5 = r1.url     // Catch:{ all -> 0x0173 }
            if (r5 == 0) goto L_0x0109
            javax.mail.URLName r10 = new javax.mail.URLName     // Catch:{ all -> 0x0173 }
            r16 = 0
            r5 = r10
            r6 = r13
            r7 = r4
            r8 = r2
            r9 = r14
            r3 = r10
            r10 = r0
            r15 = 1
            r11 = r16
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0173 }
            r1.setURLName(r3)     // Catch:{ all -> 0x0173 }
            javax.mail.Session r3 = r1.session     // Catch:{ all -> 0x0173 }
            javax.mail.URLName r5 = r17.getURLName()     // Catch:{ all -> 0x0173 }
            javax.mail.PasswordAuthentication r3 = r3.getPasswordAuthentication(r5)     // Catch:{ all -> 0x0173 }
            if (r3 == 0) goto L_0x0105
            if (r0 != 0) goto L_0x00fa
            java.lang.String r0 = r3.getUserName()     // Catch:{ all -> 0x0173 }
        L_0x00f5:
            java.lang.String r12 = r3.getPassword()     // Catch:{ all -> 0x0173 }
            goto L_0x010a
        L_0x00fa:
            java.lang.String r5 = r3.getUserName()     // Catch:{ all -> 0x0173 }
            boolean r5 = r0.equals(r5)     // Catch:{ all -> 0x0173 }
            if (r5 == 0) goto L_0x010a
            goto L_0x00f5
        L_0x0105:
            r3 = r0
            r11 = r12
            r12 = 1
            goto L_0x010d
        L_0x0109:
            r15 = 1
        L_0x010a:
            r3 = r0
            r11 = r12
            r12 = 0
        L_0x010d:
            boolean r0 = r1.protocolConnect(r4, r2, r3, r11)     // Catch:{ AuthenticationFailedException -> 0x0114 }
            r16 = 0
            goto L_0x0118
        L_0x0114:
            r0 = move-exception
            r16 = r0
            r0 = 0
        L_0x0118:
            if (r0 != 0) goto L_0x0139
            java.net.InetAddress r5 = java.net.InetAddress.getByName(r4)     // Catch:{ UnknownHostException -> 0x0120 }
            r6 = r5
            goto L_0x0121
        L_0x0120:
            r6 = 0
        L_0x0121:
            javax.mail.Session r5 = r1.session     // Catch:{ all -> 0x0173 }
            r9 = 0
            r7 = r2
            r8 = r13
            r10 = r3
            javax.mail.PasswordAuthentication r5 = r5.requestPasswordAuthentication(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0173 }
            if (r5 == 0) goto L_0x0139
            java.lang.String r3 = r5.getUserName()     // Catch:{ all -> 0x0173 }
            java.lang.String r11 = r5.getPassword()     // Catch:{ all -> 0x0173 }
            boolean r0 = r1.protocolConnect(r4, r2, r3, r11)     // Catch:{ all -> 0x0173 }
        L_0x0139:
            if (r0 != 0) goto L_0x0144
            if (r16 == 0) goto L_0x013e
            throw r16     // Catch:{ all -> 0x0173 }
        L_0x013e:
            javax.mail.AuthenticationFailedException r0 = new javax.mail.AuthenticationFailedException     // Catch:{ all -> 0x0173 }
            r0.<init>()     // Catch:{ all -> 0x0173 }
            throw r0     // Catch:{ all -> 0x0173 }
        L_0x0144:
            javax.mail.URLName r0 = new javax.mail.URLName     // Catch:{ all -> 0x0173 }
            r5 = r0
            r6 = r13
            r7 = r4
            r8 = r2
            r9 = r14
            r10 = r3
            r2 = r11
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0173 }
            r1.setURLName(r0)     // Catch:{ all -> 0x0173 }
            if (r12 == 0) goto L_0x0163
            javax.mail.Session r0 = r1.session     // Catch:{ all -> 0x0173 }
            javax.mail.URLName r4 = r17.getURLName()     // Catch:{ all -> 0x0173 }
            javax.mail.PasswordAuthentication r5 = new javax.mail.PasswordAuthentication     // Catch:{ all -> 0x0173 }
            r5.<init>(r3, r2)     // Catch:{ all -> 0x0173 }
            r0.setPasswordAuthentication(r4, r5)     // Catch:{ all -> 0x0173 }
        L_0x0163:
            r1.setConnected(r15)     // Catch:{ all -> 0x0173 }
            r1.notifyConnectionListeners(r15)     // Catch:{ all -> 0x0173 }
            monitor-exit(r17)
            return
        L_0x016b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0173 }
            java.lang.String r2 = "already connected"
            r0.<init>(r2)     // Catch:{ all -> 0x0173 }
            throw r0     // Catch:{ all -> 0x0173 }
        L_0x0173:
            r0 = move-exception
            monitor-exit(r17)
            goto L_0x0177
        L_0x0176:
            throw r0
        L_0x0177:
            goto L_0x0176
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Service.connect(java.lang.String, int, java.lang.String, java.lang.String):void");
    }

    public void connect(String str, String str2) throws MessagingException {
        connect((String) null, str, str2);
    }

    public void connect(String str, String str2, String str3) throws MessagingException {
        connect(str, -1, str2, str3);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        terminateQueue();
    }

    public synchronized URLName getURLName() {
        URLName uRLName = this.url;
        if (uRLName == null || (uRLName.getPassword() == null && this.url.getFile() == null)) {
            return this.url;
        }
        return new URLName(this.url.getProtocol(), this.url.getHost(), this.url.getPort(), (String) null, this.url.getUsername(), (String) null);
    }

    public synchronized boolean isConnected() {
        return this.connected;
    }

    /* access modifiers changed from: protected */
    public synchronized void notifyConnectionListeners(int i2) {
        if (this.connectionListeners != null) {
            queueEvent(new ConnectionEvent(this, i2), this.connectionListeners);
        }
        if (i2 == 3) {
            terminateQueue();
        }
    }

    /* access modifiers changed from: protected */
    public boolean protocolConnect(String str, int i2, String str2, String str3) throws MessagingException {
        return false;
    }

    /* access modifiers changed from: protected */
    public void queueEvent(MailEvent mailEvent, Vector vector) {
        synchronized (this.qLock) {
            if (this.f29473q == null) {
                this.f29473q = new EventQueue();
            }
        }
        this.f29473q.enqueue(mailEvent, (Vector) vector.clone());
    }

    public synchronized void removeConnectionListener(ConnectionListener connectionListener) {
        Vector vector = this.connectionListeners;
        if (vector != null) {
            vector.removeElement(connectionListener);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void setConnected(boolean z2) {
        this.connected = z2;
    }

    /* access modifiers changed from: protected */
    public synchronized void setURLName(URLName uRLName) {
        this.url = uRLName;
    }

    public String toString() {
        URLName uRLName = getURLName();
        return uRLName != null ? uRLName.toString() : super.toString();
    }
}
