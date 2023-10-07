package com.sun.mail.pop3;

import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;

public class POP3Store extends Store {
    private int defaultPort;
    boolean disableTop;
    boolean forgetTopHeaders;
    private String host;
    private boolean isSSL;
    Constructor messageConstructor;
    private String name;
    private String passwd;
    private Protocol port;
    private int portNum;
    private POP3Folder portOwner;
    boolean rsetBeforeQuit;
    private String user;

    public POP3Store(Session session, URLName uRLName) {
        this(session, uRLName, "pop3", 110, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r5 = java.lang.Class.forName(r5);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00d1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public POP3Store(javax.mail.Session r4, javax.mail.URLName r5, java.lang.String r6, int r7, boolean r8) {
        /*
            r3 = this;
            r3.<init>(r4, r5)
            java.lang.String r0 = "pop3"
            r3.name = r0
            r0 = 110(0x6e, float:1.54E-43)
            r3.defaultPort = r0
            r0 = 0
            r3.isSSL = r0
            r1 = 0
            r3.port = r1
            r3.portOwner = r1
            r3.host = r1
            r2 = -1
            r3.portNum = r2
            r3.user = r1
            r3.passwd = r1
            r3.rsetBeforeQuit = r0
            r3.disableTop = r0
            r3.forgetTopHeaders = r0
            r3.messageConstructor = r1
            if (r5 == 0) goto L_0x002a
            java.lang.String r6 = r5.getProtocol()
        L_0x002a:
            r3.name = r6
            r3.defaultPort = r7
            r3.isSSL = r8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "mail."
            r5.<init>(r7)
            r5.append(r6)
            java.lang.String r8 = ".rsetbeforequit"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            java.lang.String r8 = "true"
            r1 = 1
            if (r5 == 0) goto L_0x0054
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0054
            r3.rsetBeforeQuit = r1
        L_0x0054:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r7)
            r5.append(r6)
            java.lang.String r2 = ".disabletop"
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0073
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0073
            r3.disableTop = r1
        L_0x0073:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r7)
            r5.append(r6)
            java.lang.String r2 = ".forgettopheaders"
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0092
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x0092
            r3.forgetTopHeaders = r1
        L_0x0092:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r7)
            r5.append(r6)
            java.lang.String r6 = ".message.class"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r4.getProperty(r5)
            if (r5 == 0) goto L_0x0103
            boolean r6 = r4.getDebug()
            if (r6 == 0) goto L_0x00c4
            java.io.PrintStream r6 = r4.getDebugOut()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "DEBUG: POP3 message class: "
            r7.<init>(r8)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            r6.println(r7)
        L_0x00c4:
            java.lang.Class r6 = r3.getClass()     // Catch:{ Exception -> 0x00e7 }
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ Exception -> 0x00e7 }
            java.lang.Class r5 = r6.loadClass(r5)     // Catch:{ ClassNotFoundException -> 0x00d1 }
            goto L_0x00d5
        L_0x00d1:
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ Exception -> 0x00e7 }
        L_0x00d5:
            r6 = 2
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x00e7 }
            java.lang.Class<javax.mail.Folder> r7 = javax.mail.Folder.class
            r6[r0] = r7     // Catch:{ Exception -> 0x00e7 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00e7 }
            r6[r1] = r7     // Catch:{ Exception -> 0x00e7 }
            java.lang.reflect.Constructor r5 = r5.getConstructor(r6)     // Catch:{ Exception -> 0x00e7 }
            r3.messageConstructor = r5     // Catch:{ Exception -> 0x00e7 }
            goto L_0x0103
        L_0x00e7:
            r5 = move-exception
            boolean r6 = r4.getDebug()
            if (r6 == 0) goto L_0x0103
            java.io.PrintStream r4 = r4.getDebugOut()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "DEBUG: failed to load POP3 message class: "
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r4.println(r5)
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Store.<init>(javax.mail.Session, javax.mail.URLName, java.lang.String, int, boolean):void");
    }

    private void checkConnected() throws MessagingException {
        if (!super.isConnected()) {
            throw new MessagingException("Not connected");
        }
    }

    public synchronized void close() throws MessagingException {
        try {
            Protocol protocol = this.port;
            if (protocol != null) {
                protocol.quit();
            }
            this.port = null;
        } catch (IOException unused) {
            this.port = null;
        } catch (Throwable th) {
            throw th;
        }
        super.close();
    }

    /* access modifiers changed from: package-private */
    public synchronized void closePort(POP3Folder pOP3Folder) {
        if (this.portOwner == pOP3Folder) {
            this.port = null;
            this.portOwner = null;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.port != null) {
            close();
        }
    }

    public Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new DefaultFolder(this);
    }

    public Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new POP3Folder(this, str);
    }

    public Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new POP3Folder(this, uRLName.getFile());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        return r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.sun.mail.pop3.Protocol getPort(com.sun.mail.pop3.POP3Folder r10) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.sun.mail.pop3.Protocol r0 = r9.port     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x000d
            com.sun.mail.pop3.POP3Folder r1 = r9.portOwner     // Catch:{ all -> 0x0060 }
            if (r1 != 0) goto L_0x000d
            r9.portOwner = r10     // Catch:{ all -> 0x0060 }
            monitor-exit(r9)
            return r0
        L_0x000d:
            com.sun.mail.pop3.Protocol r8 = new com.sun.mail.pop3.Protocol     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = r9.host     // Catch:{ all -> 0x0060 }
            int r2 = r9.portNum     // Catch:{ all -> 0x0060 }
            javax.mail.Session r0 = r9.session     // Catch:{ all -> 0x0060 }
            boolean r3 = r0.getDebug()     // Catch:{ all -> 0x0060 }
            javax.mail.Session r0 = r9.session     // Catch:{ all -> 0x0060 }
            java.io.PrintStream r4 = r0.getDebugOut()     // Catch:{ all -> 0x0060 }
            javax.mail.Session r0 = r9.session     // Catch:{ all -> 0x0060 }
            java.util.Properties r5 = r0.getProperties()     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = "mail."
            r0.<init>(r6)     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = r9.name     // Catch:{ all -> 0x0060 }
            r0.append(r6)     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0060 }
            boolean r7 = r9.isSSL     // Catch:{ all -> 0x0060 }
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = r9.user     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = r9.passwd     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = r8.login(r0, r1)     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x0057
            com.sun.mail.pop3.Protocol r0 = r9.port     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x004f
            if (r10 == 0) goto L_0x004f
            r9.port = r8     // Catch:{ all -> 0x0060 }
            r9.portOwner = r10     // Catch:{ all -> 0x0060 }
        L_0x004f:
            com.sun.mail.pop3.POP3Folder r0 = r9.portOwner     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x0055
            r9.portOwner = r10     // Catch:{ all -> 0x0060 }
        L_0x0055:
            monitor-exit(r9)
            return r8
        L_0x0057:
            r8.quit()     // Catch:{ IOException -> 0x005a }
        L_0x005a:
            java.io.EOFException r10 = new java.io.EOFException     // Catch:{ all -> 0x0060 }
            r10.<init>(r0)     // Catch:{ all -> 0x0060 }
            throw r10     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Store.getPort(com.sun.mail.pop3.POP3Folder):com.sun.mail.pop3.Protocol");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized boolean isConnected() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = super.isConnected()     // Catch:{ all -> 0x0028 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r2)
            return r1
        L_0x000a:
            monitor-enter(r2)     // Catch:{ all -> 0x0028 }
            com.sun.mail.pop3.Protocol r0 = r2.port     // Catch:{ IOException -> 0x0020 }
            if (r0 != 0) goto L_0x0017
            r0 = 0
            com.sun.mail.pop3.Protocol r0 = r2.getPort(r0)     // Catch:{ IOException -> 0x0020 }
            r2.port = r0     // Catch:{ IOException -> 0x0020 }
            goto L_0x001a
        L_0x0017:
            r0.noop()     // Catch:{ IOException -> 0x0020 }
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            r0 = 1
            monitor-exit(r2)
            return r0
        L_0x001e:
            r0 = move-exception
            goto L_0x0026
        L_0x0020:
            super.close()     // Catch:{ MessagingException -> 0x0023 }
        L_0x0023:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            monitor-exit(r2)
            return r1
        L_0x0026:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r0     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Store.isConnected():boolean");
    }

    /* access modifiers changed from: protected */
    public synchronized boolean protocolConnect(String str, int i2, String str2, String str3) throws MessagingException {
        boolean z2;
        if (str == null || str3 == null || str2 == null) {
            z2 = false;
        } else {
            if (i2 == -1) {
                try {
                    Session session = this.session;
                    String property = session.getProperty("mail." + this.name + ".port");
                    if (property != null) {
                        i2 = Integer.parseInt(property);
                    }
                } catch (EOFException e2) {
                    throw new AuthenticationFailedException(e2.getMessage());
                } catch (IOException e3) {
                    throw new MessagingException("Connect failed", e3);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (i2 == -1) {
                i2 = this.defaultPort;
            }
            this.host = str;
            this.portNum = i2;
            this.user = str2;
            this.passwd = str3;
            this.port = getPort((POP3Folder) null);
            z2 = true;
        }
        return z2;
    }
}
