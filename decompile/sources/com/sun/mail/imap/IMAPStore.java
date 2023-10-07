package com.sun.mail.imap;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.iap.ResponseHandler;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.Namespaces;
import java.io.PrintStream;
import java.util.Vector;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Quota;
import javax.mail.QuotaAwareStore;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.StoreClosedException;
import javax.mail.URLName;

public class IMAPStore extends Store implements ResponseHandler, QuotaAwareStore {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int RESPONSE = 1000;
    private int appendBufferSize;
    private String authorizationID;
    private int blksize;
    private volatile boolean connected;
    private int defaultPort;
    private boolean disableAuthLogin;
    private boolean disableAuthPlain;
    private boolean enableImapEvents;
    private boolean enableSASL;
    private boolean enableStartTLS;
    private boolean forcePasswordRefresh;
    private String host;
    private boolean isSSL;
    private int minIdleTime;
    private String name;
    private Namespaces namespaces;
    private PrintStream out;
    private String password;
    private ConnectionPool pool;
    private int port;
    private String proxyAuthUser;
    private String[] saslMechanisms;
    private String saslRealm;
    private int statusCacheTimeout;
    private String user;

    static class ConnectionPool {
        private static final int ABORTING = 2;
        private static final int IDLE = 1;
        private static final int RUNNING = 0;
        /* access modifiers changed from: private */
        public Vector authenticatedConnections = new Vector();
        /* access modifiers changed from: private */
        public long clientTimeoutInterval = 45000;
        /* access modifiers changed from: private */
        public boolean debug = false;
        /* access modifiers changed from: private */
        public Vector folders;
        /* access modifiers changed from: private */
        public IMAPProtocol idleProtocol;
        /* access modifiers changed from: private */
        public int idleState = 0;
        /* access modifiers changed from: private */
        public long lastTimePruned;
        /* access modifiers changed from: private */
        public int poolSize = 1;
        /* access modifiers changed from: private */
        public long pruningInterval = 60000;
        /* access modifiers changed from: private */
        public boolean separateStoreConnection = false;
        /* access modifiers changed from: private */
        public long serverTimeoutInterval = 1800000;
        /* access modifiers changed from: private */
        public boolean storeConnectionInUse = false;

        ConnectionPool() {
        }
    }

    public IMAPStore(Session session, URLName uRLName) {
        this(session, uRLName, "imap", 143, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x040e  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x019b A[SYNTHETIC, Splitter:B:42:0x019b] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e0 A[SYNTHETIC, Splitter:B:52:0x01e0] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0226 A[SYNTHETIC, Splitter:B:62:0x0226] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0303  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected IMAPStore(javax.mail.Session r5, javax.mail.URLName r6, java.lang.String r7, int r8, boolean r9) {
        /*
            r4 = this;
            r4.<init>(r5, r6)
            java.lang.String r0 = "imap"
            r4.name = r0
            r0 = 143(0x8f, float:2.0E-43)
            r4.defaultPort = r0
            r0 = 0
            r4.isSSL = r0
            r1 = -1
            r4.port = r1
            r2 = 16384(0x4000, float:2.2959E-41)
            r4.blksize = r2
            r2 = 1000(0x3e8, float:1.401E-42)
            r4.statusCacheTimeout = r2
            r4.appendBufferSize = r1
            r2 = 10
            r4.minIdleTime = r2
            r4.disableAuthLogin = r0
            r4.disableAuthPlain = r0
            r4.enableStartTLS = r0
            r4.enableSASL = r0
            r4.forcePasswordRefresh = r0
            r4.enableImapEvents = r0
            r4.connected = r0
            com.sun.mail.imap.IMAPStore$ConnectionPool r0 = new com.sun.mail.imap.IMAPStore$ConnectionPool
            r0.<init>()
            r4.pool = r0
            if (r6 == 0) goto L_0x003a
            java.lang.String r7 = r6.getProtocol()
        L_0x003a:
            r4.name = r7
            r4.defaultPort = r8
            r4.isSSL = r9
            com.sun.mail.imap.IMAPStore$ConnectionPool r6 = r4.pool
            long r8 = java.lang.System.currentTimeMillis()
            r6.lastTimePruned = r8
            boolean r6 = r5.getDebug()
            r4.debug = r6
            java.io.PrintStream r6 = r5.getDebugOut()
            r4.out = r6
            if (r6 != 0) goto L_0x005b
            java.io.PrintStream r6 = java.lang.System.out
            r4.out = r6
        L_0x005b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "mail."
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r9 = ".connectionpool.debug"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            r9 = 1
            java.lang.String r0 = "true"
            if (r6 == 0) goto L_0x0082
            boolean r6 = r6.equalsIgnoreCase(r0)
            if (r6 == 0) goto L_0x0082
            com.sun.mail.imap.IMAPStore$ConnectionPool r6 = r4.pool
            r6.debug = r9
        L_0x0082:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r2 = ".partialfetch"
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x00ac
            java.lang.String r2 = "false"
            boolean r6 = r6.equalsIgnoreCase(r2)
            if (r6 == 0) goto L_0x00ac
            r4.blksize = r1
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x00e2
            java.io.PrintStream r6 = r4.out
            java.lang.String r1 = "DEBUG: mail.imap.partialfetch: false"
            goto L_0x00df
        L_0x00ac:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".fetchsize"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x00c9
            int r6 = java.lang.Integer.parseInt(r6)
            r4.blksize = r6
        L_0x00c9:
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x00e2
            java.io.PrintStream r6 = r4.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG: mail.imap.fetchsize: "
            r1.<init>(r2)
            int r2 = r4.blksize
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L_0x00df:
            r6.println(r1)
        L_0x00e2:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".statuscachetimeout"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x0118
            int r6 = java.lang.Integer.parseInt(r6)
            r4.statusCacheTimeout = r6
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x0118
            java.io.PrintStream r6 = r4.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG: mail.imap.statuscachetimeout: "
            r1.<init>(r2)
            int r2 = r4.statusCacheTimeout
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.println(r1)
        L_0x0118:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".appendbuffersize"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x014e
            int r6 = java.lang.Integer.parseInt(r6)
            r4.appendBufferSize = r6
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x014e
            java.io.PrintStream r6 = r4.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG: mail.imap.appendbuffersize: "
            r1.<init>(r2)
            int r2 = r4.appendBufferSize
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.println(r1)
        L_0x014e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".minidletime"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x0184
            int r6 = java.lang.Integer.parseInt(r6)
            r4.minIdleTime = r6
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x0184
            java.io.PrintStream r6 = r4.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG: mail.imap.minidletime: "
            r1.<init>(r2)
            int r2 = r4.minIdleTime
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.println(r1)
        L_0x0184:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".connectionpoolsize"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x01c9
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x01a7 }
            if (r6 <= 0) goto L_0x01a8
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r4.pool     // Catch:{ NumberFormatException -> 0x01a7 }
            r1.poolSize = r6     // Catch:{ NumberFormatException -> 0x01a7 }
            goto L_0x01a8
        L_0x01a7:
        L_0x01a8:
            com.sun.mail.imap.IMAPStore$ConnectionPool r6 = r4.pool
            boolean r6 = r6.debug
            if (r6 == 0) goto L_0x01c9
            java.io.PrintStream r6 = r4.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG: mail.imap.connectionpoolsize: "
            r1.<init>(r2)
            com.sun.mail.imap.IMAPStore$ConnectionPool r2 = r4.pool
            int r2 = r2.poolSize
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.println(r1)
        L_0x01c9:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".connectionpooltimeout"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x020f
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x01ed }
            if (r6 <= 0) goto L_0x01ee
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r4.pool     // Catch:{ NumberFormatException -> 0x01ed }
            long r2 = (long) r6     // Catch:{ NumberFormatException -> 0x01ed }
            r1.clientTimeoutInterval = r2     // Catch:{ NumberFormatException -> 0x01ed }
            goto L_0x01ee
        L_0x01ed:
        L_0x01ee:
            com.sun.mail.imap.IMAPStore$ConnectionPool r6 = r4.pool
            boolean r6 = r6.debug
            if (r6 == 0) goto L_0x020f
            java.io.PrintStream r6 = r4.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG: mail.imap.connectionpooltimeout: "
            r1.<init>(r2)
            com.sun.mail.imap.IMAPStore$ConnectionPool r2 = r4.pool
            long r2 = r2.clientTimeoutInterval
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.println(r1)
        L_0x020f:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".servertimeout"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x0255
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x0233 }
            if (r6 <= 0) goto L_0x0234
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r4.pool     // Catch:{ NumberFormatException -> 0x0233 }
            long r2 = (long) r6     // Catch:{ NumberFormatException -> 0x0233 }
            r1.serverTimeoutInterval = r2     // Catch:{ NumberFormatException -> 0x0233 }
            goto L_0x0234
        L_0x0233:
        L_0x0234:
            com.sun.mail.imap.IMAPStore$ConnectionPool r6 = r4.pool
            boolean r6 = r6.debug
            if (r6 == 0) goto L_0x0255
            java.io.PrintStream r6 = r4.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG: mail.imap.servertimeout: "
            r1.<init>(r2)
            com.sun.mail.imap.IMAPStore$ConnectionPool r2 = r4.pool
            long r2 = r2.serverTimeoutInterval
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.println(r1)
        L_0x0255:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".separatestoreconnection"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x0286
            boolean r6 = r6.equalsIgnoreCase(r0)
            if (r6 == 0) goto L_0x0286
            com.sun.mail.imap.IMAPStore$ConnectionPool r6 = r4.pool
            boolean r6 = r6.debug
            if (r6 == 0) goto L_0x0281
            java.io.PrintStream r6 = r4.out
            java.lang.String r1 = "DEBUG: dedicate a store connection"
            r6.println(r1)
        L_0x0281:
            com.sun.mail.imap.IMAPStore$ConnectionPool r6 = r4.pool
            r6.separateStoreConnection = r9
        L_0x0286:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".proxyauth.user"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x02b8
            r4.proxyAuthUser = r6
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x02b8
            java.io.PrintStream r6 = r4.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG: mail.imap.proxyauth.user: "
            r1.<init>(r2)
            java.lang.String r2 = r4.proxyAuthUser
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.println(r1)
        L_0x02b8:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".auth.login.disable"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x02e2
            boolean r6 = r6.equalsIgnoreCase(r0)
            if (r6 == 0) goto L_0x02e2
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x02e0
            java.io.PrintStream r6 = r4.out
            java.lang.String r1 = "DEBUG: disable AUTH=LOGIN"
            r6.println(r1)
        L_0x02e0:
            r4.disableAuthLogin = r9
        L_0x02e2:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".auth.plain.disable"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x030c
            boolean r6 = r6.equalsIgnoreCase(r0)
            if (r6 == 0) goto L_0x030c
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x030a
            java.io.PrintStream r6 = r4.out
            java.lang.String r1 = "DEBUG: disable AUTH=PLAIN"
            r6.println(r1)
        L_0x030a:
            r4.disableAuthPlain = r9
        L_0x030c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".starttls.enable"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x0336
            boolean r6 = r6.equalsIgnoreCase(r0)
            if (r6 == 0) goto L_0x0336
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x0334
            java.io.PrintStream r6 = r4.out
            java.lang.String r1 = "DEBUG: enable STARTTLS"
            r6.println(r1)
        L_0x0334:
            r4.enableStartTLS = r9
        L_0x0336:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".sasl.enable"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x0360
            boolean r6 = r6.equalsIgnoreCase(r0)
            if (r6 == 0) goto L_0x0360
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x035e
            java.io.PrintStream r6 = r4.out
            java.lang.String r1 = "DEBUG: enable SASL"
            r6.println(r1)
        L_0x035e:
            r4.enableSASL = r9
        L_0x0360:
            boolean r6 = r4.enableSASL
            if (r6 == 0) goto L_0x03c5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".sasl.mechanisms"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x03c5
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x03c5
            boolean r1 = r4.debug
            if (r1 == 0) goto L_0x0398
            java.io.PrintStream r1 = r4.out
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "DEBUG: SASL mechanisms allowed: "
            r2.<init>(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.println(r2)
        L_0x0398:
            java.util.Vector r1 = new java.util.Vector
            r2 = 5
            r1.<init>(r2)
            java.util.StringTokenizer r2 = new java.util.StringTokenizer
            java.lang.String r3 = " ,"
            r2.<init>(r6, r3)
        L_0x03a5:
            boolean r6 = r2.hasMoreTokens()
            if (r6 != 0) goto L_0x03b7
            int r6 = r1.size()
            java.lang.String[] r6 = new java.lang.String[r6]
            r4.saslMechanisms = r6
            r1.copyInto(r6)
            goto L_0x03c5
        L_0x03b7:
            java.lang.String r6 = r2.nextToken()
            int r3 = r6.length()
            if (r3 <= 0) goto L_0x03a5
            r1.addElement(r6)
            goto L_0x03a5
        L_0x03c5:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".sasl.authorizationid"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x03f7
            r4.authorizationID = r6
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x03f7
            java.io.PrintStream r6 = r4.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG: mail.imap.sasl.authorizationid: "
            r1.<init>(r2)
            java.lang.String r2 = r4.authorizationID
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.println(r1)
        L_0x03f7:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".sasl.realm"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x0429
            r4.saslRealm = r6
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x0429
            java.io.PrintStream r6 = r4.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DEBUG: mail.imap.sasl.realm: "
            r1.<init>(r2)
            java.lang.String r2 = r4.saslRealm
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.println(r1)
        L_0x0429:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r1 = ".forcepasswordrefresh"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r5.getProperty(r6)
            if (r6 == 0) goto L_0x0453
            boolean r6 = r6.equalsIgnoreCase(r0)
            if (r6 == 0) goto L_0x0453
            boolean r6 = r4.debug
            if (r6 == 0) goto L_0x0451
            java.io.PrintStream r6 = r4.out
            java.lang.String r1 = "DEBUG: enable forcePasswordRefresh"
            r6.println(r1)
        L_0x0451:
            r4.forcePasswordRefresh = r9
        L_0x0453:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r7 = ".enableimapevents"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r5 = r5.getProperty(r6)
            if (r5 == 0) goto L_0x047d
            boolean r5 = r5.equalsIgnoreCase(r0)
            if (r5 == 0) goto L_0x047d
            boolean r5 = r4.debug
            if (r5 == 0) goto L_0x047b
            java.io.PrintStream r5 = r4.out
            java.lang.String r6 = "DEBUG: enable IMAP events"
            r5.println(r6)
        L_0x047b:
            r4.enableImapEvents = r9
        L_0x047d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.<init>(javax.mail.Session, javax.mail.URLName, java.lang.String, int, boolean):void");
    }

    private void checkConnected() {
        if (!this.connected) {
            super.setConnected(false);
            throw new IllegalStateException("Not connected");
        }
    }

    private void cleanup() {
        cleanup(false);
    }

    private void cleanup(boolean z2) {
        boolean z3;
        if (this.debug) {
            this.out.println("DEBUG: IMAPStore cleanup, force " + z2);
        }
        Vector vector = null;
        while (true) {
            synchronized (this.pool) {
                if (this.pool.folders != null) {
                    vector = this.pool.folders;
                    this.pool.folders = null;
                    z3 = false;
                } else {
                    z3 = true;
                }
            }
            if (z3) {
                synchronized (this.pool) {
                    emptyConnectionPool(z2);
                }
                this.connected = false;
                notifyConnectionListeners(3);
                if (this.debug) {
                    this.out.println("DEBUG: IMAPStore cleanup done");
                    return;
                }
                return;
            }
            int size = vector.size();
            for (int i2 = 0; i2 < size; i2++) {
                IMAPFolder iMAPFolder = (IMAPFolder) vector.elementAt(i2);
                if (z2) {
                    try {
                        if (this.debug) {
                            this.out.println("DEBUG: force folder to close");
                        }
                        iMAPFolder.forceClose();
                    } catch (IllegalStateException | MessagingException unused) {
                    }
                } else {
                    if (this.debug) {
                        this.out.println("DEBUG: close folder");
                    }
                    iMAPFolder.close(false);
                }
            }
        }
        while (true) {
        }
    }

    private void emptyConnectionPool(boolean z2) {
        synchronized (this.pool) {
            for (int size = this.pool.authenticatedConnections.size() - 1; size >= 0; size--) {
                try {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.pool.authenticatedConnections.elementAt(size);
                    iMAPProtocol.removeResponseHandler(this);
                    if (z2) {
                        iMAPProtocol.disconnect();
                    } else {
                        iMAPProtocol.logout();
                    }
                } catch (ProtocolException unused) {
                }
            }
            this.pool.authenticatedConnections.removeAllElements();
        }
        if (this.pool.debug) {
            this.out.println("DEBUG: removed all authenticated connections");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r0 == null) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.sun.mail.imap.protocol.Namespaces getNamespaces() throws javax.mail.MessagingException {
        /*
            r4 = this;
            monitor-enter(r4)
            r4.checkConnected()     // Catch:{ all -> 0x0047 }
            r0 = 0
            com.sun.mail.imap.protocol.Namespaces r1 = r4.namespaces     // Catch:{ all -> 0x0047 }
            if (r1 != 0) goto L_0x0043
            com.sun.mail.imap.protocol.IMAPProtocol r0 = r4.getStoreProtocol()     // Catch:{ BadCommandException -> 0x003d, ConnectionException -> 0x0029, ProtocolException -> 0x001e }
            com.sun.mail.imap.protocol.Namespaces r1 = r0.namespace()     // Catch:{ BadCommandException -> 0x003d, ConnectionException -> 0x0029, ProtocolException -> 0x001e }
            r4.namespaces = r1     // Catch:{ BadCommandException -> 0x003d, ConnectionException -> 0x0029, ProtocolException -> 0x001e }
            r4.releaseStoreProtocol(r0)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0043
        L_0x0018:
            r4.cleanup()     // Catch:{ all -> 0x0047 }
            goto L_0x0043
        L_0x001c:
            r1 = move-exception
            goto L_0x0034
        L_0x001e:
            r1 = move-exception
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch:{ all -> 0x001c }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x001c }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x001c }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0029:
            r1 = move-exception
            javax.mail.StoreClosedException r2 = new javax.mail.StoreClosedException     // Catch:{ all -> 0x001c }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x001c }
            r2.<init>(r4, r1)     // Catch:{ all -> 0x001c }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0034:
            r4.releaseStoreProtocol(r0)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x003c
            r4.cleanup()     // Catch:{ all -> 0x0047 }
        L_0x003c:
            throw r1     // Catch:{ all -> 0x0047 }
        L_0x003d:
            r4.releaseStoreProtocol(r0)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0043
            goto L_0x0018
        L_0x0043:
            com.sun.mail.imap.protocol.Namespaces r0 = r4.namespaces     // Catch:{ all -> 0x0047 }
            monitor-exit(r4)
            return r0
        L_0x0047:
            r0 = move-exception
            monitor-exit(r4)
            goto L_0x004b
        L_0x004a:
            throw r0
        L_0x004b:
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.getNamespaces():com.sun.mail.imap.protocol.Namespaces");
    }

    private void login(IMAPProtocol iMAPProtocol, String str, String str2) throws ProtocolException {
        if (this.enableStartTLS && iMAPProtocol.hasCapability("STARTTLS")) {
            iMAPProtocol.startTLS();
            iMAPProtocol.capability();
        }
        if (!iMAPProtocol.isAuthenticated()) {
            iMAPProtocol.getCapabilities().put("__PRELOGIN__", "");
            String str3 = this.authorizationID;
            if (str3 == null && (str3 = this.proxyAuthUser) == null) {
                str3 = str;
            }
            if (this.enableSASL) {
                iMAPProtocol.sasllogin(this.saslMechanisms, this.saslRealm, str3, str, str2);
            }
            if (!iMAPProtocol.isAuthenticated()) {
                if (iMAPProtocol.hasCapability("AUTH=PLAIN") && !this.disableAuthPlain) {
                    iMAPProtocol.authplain(str3, str, str2);
                } else if ((iMAPProtocol.hasCapability("AUTH-LOGIN") || iMAPProtocol.hasCapability("AUTH=LOGIN")) && !this.disableAuthLogin) {
                    iMAPProtocol.authlogin(str, str2);
                } else if (!iMAPProtocol.hasCapability("LOGINDISABLED")) {
                    iMAPProtocol.login(str, str2);
                } else {
                    throw new ProtocolException("No login methods supported!");
                }
            }
            String str4 = this.proxyAuthUser;
            if (str4 != null) {
                iMAPProtocol.proxyauth(str4);
            }
            if (iMAPProtocol.hasCapability("__PRELOGIN__")) {
                try {
                    iMAPProtocol.capability();
                } catch (ConnectionException e2) {
                    throw e2;
                } catch (ProtocolException unused) {
                }
            }
        }
    }

    private Folder[] namespaceToFolders(Namespaces.Namespace[] namespaceArr, String str) {
        int length = namespaceArr.length;
        Folder[] folderArr = new Folder[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str2 = namespaceArr[i2].prefix;
            if (str == null) {
                int length2 = str2.length();
                if (length2 > 0) {
                    int i3 = length2 - 1;
                    if (str2.charAt(i3) == namespaceArr[i2].delimiter) {
                        str2 = str2.substring(0, i3);
                    }
                }
            } else {
                str2 = String.valueOf(str2) + str;
            }
            folderArr[i2] = new IMAPFolder(str2, namespaceArr[i2].delimiter, this, str == null);
        }
        return folderArr;
    }

    private void timeoutConnections() {
        synchronized (this.pool) {
            if (System.currentTimeMillis() - this.pool.lastTimePruned > this.pool.pruningInterval && this.pool.authenticatedConnections.size() > 1) {
                if (this.pool.debug) {
                    this.out.println("DEBUG: checking for connections to prune: " + (System.currentTimeMillis() - this.pool.lastTimePruned));
                    this.out.println("DEBUG: clientTimeoutInterval: " + this.pool.clientTimeoutInterval);
                }
                for (int size = this.pool.authenticatedConnections.size() - 1; size > 0; size--) {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.pool.authenticatedConnections.elementAt(size);
                    if (this.pool.debug) {
                        this.out.println("DEBUG: protocol last used: " + (System.currentTimeMillis() - iMAPProtocol.getTimestamp()));
                    }
                    if (System.currentTimeMillis() - iMAPProtocol.getTimestamp() > this.pool.clientTimeoutInterval) {
                        if (this.pool.debug) {
                            this.out.println("DEBUG: authenticated connection timed out");
                            this.out.println("DEBUG: logging out the connection");
                        }
                        iMAPProtocol.removeResponseHandler(this);
                        this.pool.authenticatedConnections.removeElementAt(size);
                        try {
                            iMAPProtocol.logout();
                        } catch (ProtocolException unused) {
                        }
                    }
                }
                this.pool.lastTimePruned = System.currentTimeMillis();
            }
        }
    }

    private void waitIfIdle() throws ProtocolException {
        while (this.pool.idleState != 0) {
            if (this.pool.idleState == 1) {
                this.pool.idleProtocol.idleAbort();
                this.pool.idleState = 2;
            }
            try {
                this.pool.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean allowReadOnlySelect() {
        Session session = this.session;
        String property = session.getProperty("mail." + this.name + ".allowreadonlyselect");
        return property != null && property.equalsIgnoreCase("true");
    }

    public synchronized void close() throws MessagingException {
        boolean isEmpty;
        if (super.isConnected()) {
            IMAPProtocol iMAPProtocol = null;
            try {
                synchronized (this.pool) {
                    isEmpty = this.pool.authenticatedConnections.isEmpty();
                }
                if (isEmpty) {
                    if (this.pool.debug) {
                        this.out.println("DEBUG: close() - no connections ");
                    }
                    cleanup();
                    releaseStoreProtocol((IMAPProtocol) null);
                    return;
                }
                iMAPProtocol = getStoreProtocol();
                synchronized (this.pool) {
                    this.pool.authenticatedConnections.removeElement(iMAPProtocol);
                }
                iMAPProtocol.logout();
                releaseStoreProtocol(iMAPProtocol);
            } catch (ProtocolException e2) {
                try {
                    cleanup();
                    throw new MessagingException(e2.getMessage(), e2);
                } catch (Throwable th) {
                    releaseStoreProtocol(iMAPProtocol);
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    /* access modifiers changed from: package-private */
    public int getAppendBufferSize() {
        return this.appendBufferSize;
    }

    /* access modifiers changed from: package-private */
    public boolean getConnectionPoolDebug() {
        return this.pool.debug;
    }

    public synchronized Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new DefaultFolder(this);
    }

    /* access modifiers changed from: package-private */
    public int getFetchBlockSize() {
        return this.blksize;
    }

    public synchronized Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new IMAPFolder(str, 65535, this);
    }

    public synchronized Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new IMAPFolder(uRLName.getFile(), 65535, this);
    }

    /* access modifiers changed from: package-private */
    public int getMinIdleTime() {
        return this.minIdleTime;
    }

    public Folder[] getPersonalNamespaces() throws MessagingException {
        Namespaces namespaces2 = getNamespaces();
        return (namespaces2 == null || namespaces2.personal == null) ? super.getPersonalNamespaces() : namespaceToFolders(namespaces2.personal, (String) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:22|23|24|25|26) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x007f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0085 */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0117 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sun.mail.imap.protocol.IMAPProtocol getProtocol(com.sun.mail.imap.IMAPFolder r13) throws javax.mail.MessagingException {
        /*
            r12 = this;
            r0 = 0
        L_0x0001:
            r1 = r0
        L_0x0002:
            if (r1 == 0) goto L_0x0005
            return r1
        L_0x0005:
            com.sun.mail.imap.IMAPStore$ConnectionPool r2 = r12.pool
            monitor-enter(r2)
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r3 = r3.authenticatedConnections     // Catch:{ all -> 0x011f }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x011f }
            if (r3 != 0) goto L_0x008d
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r3 = r3.authenticatedConnections     // Catch:{ all -> 0x011f }
            int r3 = r3.size()     // Catch:{ all -> 0x011f }
            r4 = 1
            if (r3 != r4) goto L_0x0032
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            boolean r3 = r3.separateStoreConnection     // Catch:{ all -> 0x011f }
            if (r3 != 0) goto L_0x008d
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            boolean r3 = r3.storeConnectionInUse     // Catch:{ all -> 0x011f }
            if (r3 == 0) goto L_0x0032
            goto L_0x008d
        L_0x0032:
            boolean r1 = r12.debug     // Catch:{ all -> 0x011f }
            if (r1 == 0) goto L_0x0053
            java.io.PrintStream r1 = r12.out     // Catch:{ all -> 0x011f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "DEBUG: connection available -- size: "
            r3.<init>(r4)     // Catch:{ all -> 0x011f }
            com.sun.mail.imap.IMAPStore$ConnectionPool r4 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r4 = r4.authenticatedConnections     // Catch:{ all -> 0x011f }
            int r4 = r4.size()     // Catch:{ all -> 0x011f }
            r3.append(r4)     // Catch:{ all -> 0x011f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x011f }
            r1.println(r3)     // Catch:{ all -> 0x011f }
        L_0x0053:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r1 = r1.authenticatedConnections     // Catch:{ all -> 0x011f }
            java.lang.Object r1 = r1.lastElement()     // Catch:{ all -> 0x011f }
            com.sun.mail.imap.protocol.IMAPProtocol r1 = (com.sun.mail.imap.protocol.IMAPProtocol) r1     // Catch:{ all -> 0x011f }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r3 = r3.authenticatedConnections     // Catch:{ all -> 0x011f }
            r3.removeElement(r1)     // Catch:{ all -> 0x011f }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x011f }
            long r5 = r1.getTimestamp()     // Catch:{ all -> 0x011f }
            long r3 = r3 - r5
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r12.pool     // Catch:{ all -> 0x011f }
            long r5 = r5.serverTimeoutInterval     // Catch:{ all -> 0x011f }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0088
            r1.noop()     // Catch:{ ProtocolException -> 0x007f }
            goto L_0x0088
        L_0x007f:
            r1.removeResponseHandler(r12)     // Catch:{ all -> 0x0085 }
            r1.disconnect()     // Catch:{ all -> 0x0085 }
        L_0x0085:
            monitor-exit(r2)     // Catch:{ all -> 0x011f }
            goto L_0x0001
        L_0x0088:
            r1.removeResponseHandler(r12)     // Catch:{ all -> 0x011f }
            goto L_0x00f4
        L_0x008d:
            boolean r3 = r12.debug     // Catch:{ all -> 0x011f }
            if (r3 == 0) goto L_0x0098
            java.io.PrintStream r3 = r12.out     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "DEBUG: no connections in the pool, creating a new one"
            r3.println(r4)     // Catch:{ all -> 0x011f }
        L_0x0098:
            boolean r3 = r12.forcePasswordRefresh     // Catch:{ Exception -> 0x00ea }
            if (r3 == 0) goto L_0x00c0
            java.lang.String r3 = r12.host     // Catch:{ UnknownHostException -> 0x00a4 }
            java.net.InetAddress r3 = java.net.InetAddress.getByName(r3)     // Catch:{ UnknownHostException -> 0x00a4 }
            r4 = r3
            goto L_0x00a5
        L_0x00a4:
            r4 = r0
        L_0x00a5:
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x00ea }
            int r5 = r12.port     // Catch:{ Exception -> 0x00ea }
            java.lang.String r6 = r12.name     // Catch:{ Exception -> 0x00ea }
            r7 = 0
            java.lang.String r8 = r12.user     // Catch:{ Exception -> 0x00ea }
            javax.mail.PasswordAuthentication r3 = r3.requestPasswordAuthentication(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00ea }
            if (r3 == 0) goto L_0x00c0
            java.lang.String r4 = r3.getUserName()     // Catch:{ Exception -> 0x00ea }
            r12.user = r4     // Catch:{ Exception -> 0x00ea }
            java.lang.String r3 = r3.getPassword()     // Catch:{ Exception -> 0x00ea }
            r12.password = r3     // Catch:{ Exception -> 0x00ea }
        L_0x00c0:
            com.sun.mail.imap.protocol.IMAPProtocol r11 = new com.sun.mail.imap.protocol.IMAPProtocol     // Catch:{ Exception -> 0x00ea }
            java.lang.String r4 = r12.name     // Catch:{ Exception -> 0x00ea }
            java.lang.String r5 = r12.host     // Catch:{ Exception -> 0x00ea }
            int r6 = r12.port     // Catch:{ Exception -> 0x00ea }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x00ea }
            boolean r7 = r3.getDebug()     // Catch:{ Exception -> 0x00ea }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x00ea }
            java.io.PrintStream r8 = r3.getDebugOut()     // Catch:{ Exception -> 0x00ea }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x00ea }
            java.util.Properties r9 = r3.getProperties()     // Catch:{ Exception -> 0x00ea }
            boolean r10 = r12.isSSL     // Catch:{ Exception -> 0x00ea }
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00ea }
            java.lang.String r1 = r12.user     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r3 = r12.password     // Catch:{ Exception -> 0x00e8 }
            r12.login(r11, r1, r3)     // Catch:{ Exception -> 0x00e8 }
            goto L_0x00f1
        L_0x00e8:
            r1 = r11
            goto L_0x00eb
        L_0x00ea:
        L_0x00eb:
            if (r1 == 0) goto L_0x00f0
            r1.disconnect()     // Catch:{ Exception -> 0x00f0 }
        L_0x00f0:
            r11 = r0
        L_0x00f1:
            if (r11 == 0) goto L_0x0117
            r1 = r11
        L_0x00f4:
            r12.timeoutConnections()     // Catch:{ all -> 0x011f }
            if (r13 == 0) goto L_0x0114
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r3 = r3.folders     // Catch:{ all -> 0x011f }
            if (r3 != 0) goto L_0x010b
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r4 = new java.util.Vector     // Catch:{ all -> 0x011f }
            r4.<init>()     // Catch:{ all -> 0x011f }
            r3.folders = r4     // Catch:{ all -> 0x011f }
        L_0x010b:
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x011f }
            java.util.Vector r3 = r3.folders     // Catch:{ all -> 0x011f }
            r3.addElement(r13)     // Catch:{ all -> 0x011f }
        L_0x0114:
            monitor-exit(r2)     // Catch:{ all -> 0x011f }
            goto L_0x0002
        L_0x0117:
            javax.mail.MessagingException r13 = new javax.mail.MessagingException     // Catch:{ all -> 0x011f }
            java.lang.String r0 = "connection failure"
            r13.<init>(r0)     // Catch:{ all -> 0x011f }
            throw r13     // Catch:{ all -> 0x011f }
        L_0x011f:
            r13 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x011f }
            goto L_0x0123
        L_0x0122:
            throw r13
        L_0x0123:
            goto L_0x0122
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.getProtocol(com.sun.mail.imap.IMAPFolder):com.sun.mail.imap.protocol.IMAPProtocol");
    }

    public synchronized Quota[] getQuota(String str) throws MessagingException {
        Quota[] quotaRoot;
        checkConnected();
        Quota[] quotaArr = null;
        try {
            IMAPProtocol storeProtocol = getStoreProtocol();
            quotaRoot = storeProtocol.getQuotaRoot(str);
            releaseStoreProtocol(storeProtocol);
            if (storeProtocol == null) {
                cleanup();
            }
        } catch (BadCommandException e2) {
            throw new MessagingException("QUOTA not supported", e2);
        } catch (ConnectionException e3) {
            throw new StoreClosedException(this, e3.getMessage());
        } catch (ProtocolException e4) {
            throw new MessagingException(e4.getMessage(), e4);
        } catch (Throwable th) {
            releaseStoreProtocol((IMAPProtocol) null);
            if (0 == 0) {
                cleanup();
            }
            throw th;
        }
        return quotaRoot;
    }

    /* access modifiers changed from: package-private */
    public Session getSession() {
        return this.session;
    }

    public Folder[] getSharedNamespaces() throws MessagingException {
        Namespaces namespaces2 = getNamespaces();
        return (namespaces2 == null || namespaces2.shared == null) ? super.getSharedNamespaces() : namespaceToFolders(namespaces2.shared, (String) null);
    }

    /* access modifiers changed from: package-private */
    public int getStatusCacheTimeout() {
        return this.statusCacheTimeout;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.sun.mail.imap.protocol.IMAPProtocol} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059 A[SYNTHETIC, Splitter:B:24:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0066 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sun.mail.imap.protocol.IMAPProtocol getStoreProtocol() throws com.sun.mail.iap.ProtocolException {
        /*
            r12 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            if (r1 == 0) goto L_0x0005
            return r1
        L_0x0005:
            com.sun.mail.imap.IMAPStore$ConnectionPool r2 = r12.pool
            monitor-enter(r2)
            r12.waitIfIdle()     // Catch:{ all -> 0x00cb }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x00cb }
            java.util.Vector r3 = r3.authenticatedConnections     // Catch:{ all -> 0x00cb }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00cb }
            if (r3 == 0) goto L_0x006e
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r12.pool     // Catch:{ all -> 0x00cb }
            boolean r3 = r3.debug     // Catch:{ all -> 0x00cb }
            if (r3 == 0) goto L_0x0026
            java.io.PrintStream r3 = r12.out     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = "DEBUG: getStoreProtocol() - no connections in the pool, creating a new one"
            r3.println(r4)     // Catch:{ all -> 0x00cb }
        L_0x0026:
            com.sun.mail.imap.protocol.IMAPProtocol r11 = new com.sun.mail.imap.protocol.IMAPProtocol     // Catch:{ Exception -> 0x0050 }
            java.lang.String r4 = r12.name     // Catch:{ Exception -> 0x0050 }
            java.lang.String r5 = r12.host     // Catch:{ Exception -> 0x0050 }
            int r6 = r12.port     // Catch:{ Exception -> 0x0050 }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x0050 }
            boolean r7 = r3.getDebug()     // Catch:{ Exception -> 0x0050 }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x0050 }
            java.io.PrintStream r8 = r3.getDebugOut()     // Catch:{ Exception -> 0x0050 }
            javax.mail.Session r3 = r12.session     // Catch:{ Exception -> 0x0050 }
            java.util.Properties r9 = r3.getProperties()     // Catch:{ Exception -> 0x0050 }
            boolean r10 = r12.isSSL     // Catch:{ Exception -> 0x0050 }
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = r12.user     // Catch:{ Exception -> 0x004e }
            java.lang.String r3 = r12.password     // Catch:{ Exception -> 0x004e }
            r12.login(r11, r1, r3)     // Catch:{ Exception -> 0x004e }
            goto L_0x0057
        L_0x004e:
            r1 = r11
            goto L_0x0051
        L_0x0050:
        L_0x0051:
            if (r1 == 0) goto L_0x0056
            r1.logout()     // Catch:{ Exception -> 0x0056 }
        L_0x0056:
            r11 = r0
        L_0x0057:
            if (r11 == 0) goto L_0x0066
            r11.addResponseHandler(r12)     // Catch:{ all -> 0x00cb }
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00cb }
            java.util.Vector r1 = r1.authenticatedConnections     // Catch:{ all -> 0x00cb }
            r1.addElement(r11)     // Catch:{ all -> 0x00cb }
            goto L_0x00a0
        L_0x0066:
            com.sun.mail.iap.ConnectionException r0 = new com.sun.mail.iap.ConnectionException     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = "failed to create new store connection"
            r0.<init>(r1)     // Catch:{ all -> 0x00cb }
            throw r0     // Catch:{ all -> 0x00cb }
        L_0x006e:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00cb }
            boolean r1 = r1.debug     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x0093
            java.io.PrintStream r1 = r12.out     // Catch:{ all -> 0x00cb }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = "DEBUG: getStoreProtocol() - connection available -- size: "
            r3.<init>(r4)     // Catch:{ all -> 0x00cb }
            com.sun.mail.imap.IMAPStore$ConnectionPool r4 = r12.pool     // Catch:{ all -> 0x00cb }
            java.util.Vector r4 = r4.authenticatedConnections     // Catch:{ all -> 0x00cb }
            int r4 = r4.size()     // Catch:{ all -> 0x00cb }
            r3.append(r4)     // Catch:{ all -> 0x00cb }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00cb }
            r1.println(r3)     // Catch:{ all -> 0x00cb }
        L_0x0093:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00cb }
            java.util.Vector r1 = r1.authenticatedConnections     // Catch:{ all -> 0x00cb }
            java.lang.Object r1 = r1.firstElement()     // Catch:{ all -> 0x00cb }
            r11 = r1
            com.sun.mail.imap.protocol.IMAPProtocol r11 = (com.sun.mail.imap.protocol.IMAPProtocol) r11     // Catch:{ all -> 0x00cb }
        L_0x00a0:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00cb }
            boolean r1 = r1.storeConnectionInUse     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x00af
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ InterruptedException -> 0x00ad }
            r1.wait()     // Catch:{ InterruptedException -> 0x00ad }
        L_0x00ad:
            r1 = r0
            goto L_0x00c5
        L_0x00af:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00cb }
            r3 = 1
            r1.storeConnectionInUse = r3     // Catch:{ all -> 0x00cb }
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r12.pool     // Catch:{ all -> 0x00cb }
            boolean r1 = r1.debug     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x00c4
            java.io.PrintStream r1 = r12.out     // Catch:{ all -> 0x00cb }
            java.lang.String r3 = "DEBUG: getStoreProtocol() -- storeConnectionInUse"
            r1.println(r3)     // Catch:{ all -> 0x00cb }
        L_0x00c4:
            r1 = r11
        L_0x00c5:
            r12.timeoutConnections()     // Catch:{ all -> 0x00cb }
            monitor-exit(r2)     // Catch:{ all -> 0x00cb }
            goto L_0x0002
        L_0x00cb:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00cb }
            goto L_0x00cf
        L_0x00ce:
            throw r0
        L_0x00cf:
            goto L_0x00ce
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.getStoreProtocol():com.sun.mail.imap.protocol.IMAPProtocol");
    }

    public Folder[] getUserNamespaces(String str) throws MessagingException {
        Namespaces namespaces2 = getNamespaces();
        return (namespaces2 == null || namespaces2.otherUsers == null) ? super.getUserNamespaces(str) : namespaceToFolders(namespaces2.otherUsers, str);
    }

    public void handleResponse(Response response) {
        if (response.isOK() || response.isNO() || response.isBAD() || response.isBYE()) {
            handleResponseCode(response);
        }
        if (response.isBYE()) {
            if (this.debug) {
                this.out.println("DEBUG: IMAPStore connection dead");
            }
            if (this.connected) {
                cleanup(response.isSynthetic());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleResponseCode(Response response) {
        String rest = response.getRest();
        boolean z2 = false;
        if (rest.startsWith("[")) {
            int indexOf = rest.indexOf(93);
            if (indexOf > 0 && rest.substring(0, indexOf + 1).equalsIgnoreCase("[ALERT]")) {
                z2 = true;
            }
            rest = rest.substring(indexOf + 1).trim();
        }
        if (z2) {
            notifyStoreListeners(1, rest);
        } else if (response.isUnTagged() && rest.length() > 0) {
            notifyStoreListeners(2, rest);
        }
    }

    public synchronized boolean hasCapability(String str) throws MessagingException {
        boolean hasCapability;
        try {
            IMAPProtocol storeProtocol = getStoreProtocol();
            hasCapability = storeProtocol.hasCapability(str);
            releaseStoreProtocol(storeProtocol);
        } catch (ProtocolException e2) {
            if (0 == 0) {
                cleanup();
            }
            throw new MessagingException(e2.getMessage(), e2);
        } catch (Throwable th) {
            releaseStoreProtocol((IMAPProtocol) null);
            throw th;
        }
        return hasCapability;
    }

    /* access modifiers changed from: package-private */
    public boolean hasSeparateStoreConnection() {
        return this.pool.separateStoreConnection;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public void idle() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkConnected()     // Catch:{ all -> 0x00d9 }
            monitor-exit(r5)     // Catch:{ all -> 0x00d9 }
            r0 = 0
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r5.pool     // Catch:{ BadCommandException -> 0x00b9, ConnectionException -> 0x00ad, ProtocolException -> 0x00a1, all -> 0x009e }
            monitor-enter(r1)     // Catch:{ BadCommandException -> 0x00b9, ConnectionException -> 0x00ad, ProtocolException -> 0x00a1, all -> 0x009e }
            com.sun.mail.imap.protocol.IMAPProtocol r2 = r5.getStoreProtocol()     // Catch:{ all -> 0x0094 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ all -> 0x0092 }
            int r3 = r3.idleState     // Catch:{ all -> 0x0092 }
            if (r3 != 0) goto L_0x0077
            r2.idleStart()     // Catch:{ all -> 0x0092 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ all -> 0x0092 }
            r4 = 1
            r3.idleState = r4     // Catch:{ all -> 0x0092 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ all -> 0x0092 }
            r3.idleProtocol = r2     // Catch:{ all -> 0x0092 }
            monitor-exit(r1)     // Catch:{ all -> 0x0092 }
        L_0x0024:
            com.sun.mail.iap.Response r1 = r2.readIdleResponse()     // Catch:{ BadCommandException -> 0x009c, ConnectionException -> 0x009a, ProtocolException -> 0x0098 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ BadCommandException -> 0x009c, ConnectionException -> 0x009a, ProtocolException -> 0x0098 }
            monitor-enter(r3)     // Catch:{ BadCommandException -> 0x009c, ConnectionException -> 0x009a, ProtocolException -> 0x0098 }
            if (r1 == 0) goto L_0x0049
            boolean r4 = r2.processIdleResponse(r1)     // Catch:{ all -> 0x0074 }
            if (r4 != 0) goto L_0x0034
            goto L_0x0049
        L_0x0034:
            monitor-exit(r3)     // Catch:{ all -> 0x0074 }
            boolean r3 = r5.enableImapEvents     // Catch:{ BadCommandException -> 0x009c, ConnectionException -> 0x009a, ProtocolException -> 0x0098 }
            if (r3 == 0) goto L_0x0024
            boolean r3 = r1.isUnTagged()     // Catch:{ BadCommandException -> 0x009c, ConnectionException -> 0x009a, ProtocolException -> 0x0098 }
            if (r3 == 0) goto L_0x0024
            r3 = 1000(0x3e8, float:1.401E-42)
            java.lang.String r1 = r1.toString()     // Catch:{ BadCommandException -> 0x009c, ConnectionException -> 0x009a, ProtocolException -> 0x0098 }
            r5.notifyStoreListeners(r3, r1)     // Catch:{ BadCommandException -> 0x009c, ConnectionException -> 0x009a, ProtocolException -> 0x0098 }
            goto L_0x0024
        L_0x0049:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r5.pool     // Catch:{ all -> 0x0074 }
            r4 = 0
            r1.idleState = r4     // Catch:{ all -> 0x0074 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r5.pool     // Catch:{ all -> 0x0074 }
            r1.notifyAll()     // Catch:{ all -> 0x0074 }
            monitor-exit(r3)     // Catch:{ all -> 0x0074 }
            int r1 = r5.getMinIdleTime()     // Catch:{ BadCommandException -> 0x009c, ConnectionException -> 0x009a, ProtocolException -> 0x0098 }
            if (r1 <= 0) goto L_0x005f
            long r3 = (long) r1
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x005f }
        L_0x005f:
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r5.pool
            monitor-enter(r1)
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ all -> 0x0071 }
            r3.idleProtocol = r0     // Catch:{ all -> 0x0071 }
            monitor-exit(r1)     // Catch:{ all -> 0x0071 }
            r5.releaseStoreProtocol(r2)
            if (r2 != 0) goto L_0x0070
            r5.cleanup()
        L_0x0070:
            return
        L_0x0071:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0071 }
            throw r0
        L_0x0074:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0074 }
            throw r1     // Catch:{ BadCommandException -> 0x009c, ConnectionException -> 0x009a, ProtocolException -> 0x0098 }
        L_0x0077:
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool     // Catch:{ InterruptedException -> 0x007c }
            r3.wait()     // Catch:{ InterruptedException -> 0x007c }
        L_0x007c:
            monitor-exit(r1)     // Catch:{ all -> 0x0092 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool
            monitor-enter(r3)
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r5.pool     // Catch:{ all -> 0x008f }
            r1.idleProtocol = r0     // Catch:{ all -> 0x008f }
            monitor-exit(r3)     // Catch:{ all -> 0x008f }
            r5.releaseStoreProtocol(r2)
            if (r2 != 0) goto L_0x008e
            r5.cleanup()
        L_0x008e:
            return
        L_0x008f:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x008f }
            throw r0
        L_0x0092:
            r3 = move-exception
            goto L_0x0096
        L_0x0094:
            r3 = move-exception
            r2 = r0
        L_0x0096:
            monitor-exit(r1)     // Catch:{ all -> 0x0092 }
            throw r3     // Catch:{ BadCommandException -> 0x009c, ConnectionException -> 0x009a, ProtocolException -> 0x0098 }
        L_0x0098:
            r1 = move-exception
            goto L_0x00a3
        L_0x009a:
            r1 = move-exception
            goto L_0x00af
        L_0x009c:
            r1 = move-exception
            goto L_0x00bb
        L_0x009e:
            r1 = move-exception
            r2 = r0
            goto L_0x00c4
        L_0x00a1:
            r1 = move-exception
            r2 = r0
        L_0x00a3:
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ all -> 0x00c3 }
            java.lang.String r4 = r1.getMessage()     // Catch:{ all -> 0x00c3 }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x00c3 }
            throw r3     // Catch:{ all -> 0x00c3 }
        L_0x00ad:
            r1 = move-exception
            r2 = r0
        L_0x00af:
            javax.mail.StoreClosedException r3 = new javax.mail.StoreClosedException     // Catch:{ all -> 0x00c3 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00c3 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x00c3 }
            throw r3     // Catch:{ all -> 0x00c3 }
        L_0x00b9:
            r1 = move-exception
            r2 = r0
        L_0x00bb:
            javax.mail.MessagingException r3 = new javax.mail.MessagingException     // Catch:{ all -> 0x00c3 }
            java.lang.String r4 = "IDLE not supported"
            r3.<init>(r4, r1)     // Catch:{ all -> 0x00c3 }
            throw r3     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r1 = move-exception
        L_0x00c4:
            com.sun.mail.imap.IMAPStore$ConnectionPool r3 = r5.pool
            monitor-enter(r3)
            com.sun.mail.imap.IMAPStore$ConnectionPool r4 = r5.pool     // Catch:{ all -> 0x00d6 }
            r4.idleProtocol = r0     // Catch:{ all -> 0x00d6 }
            monitor-exit(r3)     // Catch:{ all -> 0x00d6 }
            r5.releaseStoreProtocol(r2)
            if (r2 != 0) goto L_0x00d5
            r5.cleanup()
        L_0x00d5:
            throw r1
        L_0x00d6:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00d6 }
            throw r0
        L_0x00d9:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00d9 }
            goto L_0x00dd
        L_0x00dc:
            throw r0
        L_0x00dd:
            goto L_0x00dc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.idle():void");
    }

    public synchronized boolean isConnected() {
        if (!this.connected) {
            super.setConnected(false);
            return false;
        }
        IMAPProtocol iMAPProtocol = null;
        try {
            iMAPProtocol = getStoreProtocol();
            iMAPProtocol.noop();
        } catch (ProtocolException unused) {
            if (iMAPProtocol == null) {
                try {
                    cleanup();
                } catch (Throwable th) {
                    releaseStoreProtocol(iMAPProtocol);
                    throw th;
                }
            }
        }
        releaseStoreProtocol(iMAPProtocol);
        return super.isConnected();
    }

    /* access modifiers changed from: package-private */
    public boolean isConnectionPoolFull() {
        boolean z2;
        synchronized (this.pool) {
            if (this.pool.debug) {
                PrintStream printStream = this.out;
                printStream.println("DEBUG: current size: " + this.pool.authenticatedConnections.size() + "   pool size: " + this.pool.poolSize);
            }
            z2 = this.pool.authenticatedConnections.size() >= this.pool.poolSize;
        }
        return z2;
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
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    protected synchronized boolean protocolConnect(java.lang.String r11, int r12, java.lang.String r13, java.lang.String r14) throws javax.mail.MessagingException {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            if (r11 == 0) goto L_0x00df
            if (r14 == 0) goto L_0x00df
            if (r13 != 0) goto L_0x000a
            goto L_0x00df
        L_0x000a:
            r1 = -1
            if (r12 == r1) goto L_0x0010
        L_0x000d:
            r10.port = r12     // Catch:{ all -> 0x0110 }
            goto L_0x0032
        L_0x0010:
            javax.mail.Session r12 = r10.session     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = "mail."
            r2.<init>(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r10.name     // Catch:{ all -> 0x0110 }
            r2.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = ".port"
            r2.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0110 }
            java.lang.String r12 = r12.getProperty(r2)     // Catch:{ all -> 0x0110 }
            if (r12 == 0) goto L_0x0032
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ all -> 0x0110 }
            goto L_0x000d
        L_0x0032:
            int r12 = r10.port     // Catch:{ all -> 0x0110 }
            if (r12 != r1) goto L_0x003a
            int r12 = r10.defaultPort     // Catch:{ all -> 0x0110 }
            r10.port = r12     // Catch:{ all -> 0x0110 }
        L_0x003a:
            com.sun.mail.imap.IMAPStore$ConnectionPool r12 = r10.pool     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            monitor-enter(r12)     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r10.pool     // Catch:{ all -> 0x00b2 }
            java.util.Vector r1 = r1.authenticatedConnections     // Catch:{ all -> 0x00b2 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00b2 }
            monitor-exit(r12)     // Catch:{ all -> 0x00b2 }
            if (r1 == 0) goto L_0x00ad
            com.sun.mail.imap.protocol.IMAPProtocol r12 = new com.sun.mail.imap.protocol.IMAPProtocol     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            java.lang.String r3 = r10.name     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            int r5 = r10.port     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            javax.mail.Session r1 = r10.session     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            boolean r6 = r1.getDebug()     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            javax.mail.Session r1 = r10.session     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            java.io.PrintStream r7 = r1.getDebugOut()     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            javax.mail.Session r1 = r10.session     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            java.util.Properties r8 = r1.getProperties()     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            boolean r9 = r10.isSSL     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            r2 = r12
            r4 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            boolean r0 = r10.debug     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            if (r0 == 0) goto L_0x008d
            java.io.PrintStream r0 = r10.out     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            java.lang.String r2 = "DEBUG: protocolConnect login, host="
            r1.<init>(r2)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            r1.append(r11)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            java.lang.String r2 = ", user="
            r1.append(r2)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            r1.append(r13)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            java.lang.String r2 = ", password=<non-null>"
            r1.append(r2)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            java.lang.String r1 = r1.toString()     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            r0.println(r1)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
        L_0x008d:
            r10.login(r12, r13, r14)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            r12.addResponseHandler(r10)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            r10.host = r11     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            r10.user = r13     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            r10.password = r14     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r11 = r10.pool     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            monitor-enter(r11)     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
            com.sun.mail.imap.IMAPStore$ConnectionPool r13 = r10.pool     // Catch:{ all -> 0x00a7 }
            java.util.Vector r13 = r13.authenticatedConnections     // Catch:{ all -> 0x00a7 }
            r13.addElement(r12)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r11)     // Catch:{ all -> 0x00a7 }
            goto L_0x00ad
        L_0x00a7:
            r13 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00a7 }
            throw r13     // Catch:{ CommandFailedException -> 0x00aa, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
        L_0x00aa:
            r11 = move-exception
            r0 = r12
            goto L_0x00cc
        L_0x00ad:
            r11 = 1
            r10.connected = r11     // Catch:{ all -> 0x0110 }
            monitor-exit(r10)
            return r11
        L_0x00b2:
            r11 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00b2 }
            throw r11     // Catch:{ CommandFailedException -> 0x00cb, ProtocolException -> 0x00c0, IOException -> 0x00b5 }
        L_0x00b5:
            r11 = move-exception
            javax.mail.MessagingException r12 = new javax.mail.MessagingException     // Catch:{ all -> 0x0110 }
            java.lang.String r13 = r11.getMessage()     // Catch:{ all -> 0x0110 }
            r12.<init>(r13, r11)     // Catch:{ all -> 0x0110 }
            throw r12     // Catch:{ all -> 0x0110 }
        L_0x00c0:
            r11 = move-exception
            javax.mail.MessagingException r12 = new javax.mail.MessagingException     // Catch:{ all -> 0x0110 }
            java.lang.String r13 = r11.getMessage()     // Catch:{ all -> 0x0110 }
            r12.<init>(r13, r11)     // Catch:{ all -> 0x0110 }
            throw r12     // Catch:{ all -> 0x0110 }
        L_0x00cb:
            r11 = move-exception
        L_0x00cc:
            if (r0 == 0) goto L_0x00d1
            r0.disconnect()     // Catch:{ all -> 0x0110 }
        L_0x00d1:
            javax.mail.AuthenticationFailedException r12 = new javax.mail.AuthenticationFailedException     // Catch:{ all -> 0x0110 }
            com.sun.mail.iap.Response r11 = r11.getResponse()     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r11.getRest()     // Catch:{ all -> 0x0110 }
            r12.<init>(r11)     // Catch:{ all -> 0x0110 }
            throw r12     // Catch:{ all -> 0x0110 }
        L_0x00df:
            boolean r12 = r10.debug     // Catch:{ all -> 0x0110 }
            if (r12 == 0) goto L_0x010d
            java.io.PrintStream r12 = r10.out     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = "DEBUG: protocolConnect returning false, host="
            r0.<init>(r1)     // Catch:{ all -> 0x0110 }
            r0.append(r11)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = ", user="
            r0.append(r11)     // Catch:{ all -> 0x0110 }
            r0.append(r13)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = ", password="
            r0.append(r11)     // Catch:{ all -> 0x0110 }
            if (r14 == 0) goto L_0x0101
            java.lang.String r11 = "<non-null>"
            goto L_0x0103
        L_0x0101:
            java.lang.String r11 = "<null>"
        L_0x0103:
            r0.append(r11)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x0110 }
            r12.println(r11)     // Catch:{ all -> 0x0110 }
        L_0x010d:
            r11 = 0
            monitor-exit(r10)
            return r11
        L_0x0110:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0114
        L_0x0113:
            throw r11
        L_0x0114:
            goto L_0x0113
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.protocolConnect(java.lang.String, int, java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:(3:3|4|(2:6|(1:8))(4:9|(1:11)|12|13))|14|15|(1:17)|18|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0047 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void releaseProtocol(com.sun.mail.imap.IMAPFolder r4, com.sun.mail.imap.protocol.IMAPProtocol r5) {
        /*
            r3 = this;
            com.sun.mail.imap.IMAPStore$ConnectionPool r0 = r3.pool
            monitor-enter(r0)
            if (r5 == 0) goto L_0x0047
            boolean r1 = r3.isConnectionPoolFull()     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x0039
            r5.addResponseHandler(r3)     // Catch:{ all -> 0x005d }
            com.sun.mail.imap.IMAPStore$ConnectionPool r1 = r3.pool     // Catch:{ all -> 0x005d }
            java.util.Vector r1 = r1.authenticatedConnections     // Catch:{ all -> 0x005d }
            r1.addElement(r5)     // Catch:{ all -> 0x005d }
            boolean r5 = r3.debug     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x0047
            java.io.PrintStream r5 = r3.out     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            java.lang.String r2 = "DEBUG: added an Authenticated connection -- size: "
            r1.<init>(r2)     // Catch:{ all -> 0x005d }
            com.sun.mail.imap.IMAPStore$ConnectionPool r2 = r3.pool     // Catch:{ all -> 0x005d }
            java.util.Vector r2 = r2.authenticatedConnections     // Catch:{ all -> 0x005d }
            int r2 = r2.size()     // Catch:{ all -> 0x005d }
            r1.append(r2)     // Catch:{ all -> 0x005d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x005d }
            r5.println(r1)     // Catch:{ all -> 0x005d }
            goto L_0x0047
        L_0x0039:
            boolean r1 = r3.debug     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0044
            java.io.PrintStream r1 = r3.out     // Catch:{ all -> 0x005d }
            java.lang.String r2 = "DEBUG: pool is full, not adding an Authenticated connection"
            r1.println(r2)     // Catch:{ all -> 0x005d }
        L_0x0044:
            r5.logout()     // Catch:{ ProtocolException -> 0x0047 }
        L_0x0047:
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r3.pool     // Catch:{ all -> 0x005d }
            java.util.Vector r5 = r5.folders     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x0058
            com.sun.mail.imap.IMAPStore$ConnectionPool r5 = r3.pool     // Catch:{ all -> 0x005d }
            java.util.Vector r5 = r5.folders     // Catch:{ all -> 0x005d }
            r5.removeElement(r4)     // Catch:{ all -> 0x005d }
        L_0x0058:
            r3.timeoutConnections()     // Catch:{ all -> 0x005d }
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return
        L_0x005d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.releaseProtocol(com.sun.mail.imap.IMAPFolder, com.sun.mail.imap.protocol.IMAPProtocol):void");
    }

    /* access modifiers changed from: package-private */
    public void releaseStoreProtocol(IMAPProtocol iMAPProtocol) {
        if (iMAPProtocol != null) {
            synchronized (this.pool) {
                this.pool.storeConnectionInUse = false;
                this.pool.notifyAll();
                if (this.pool.debug) {
                    this.out.println("DEBUG: releaseStoreProtocol()");
                }
                timeoutConnections();
            }
        }
    }

    public synchronized void setPassword(String str) {
        this.password = str;
    }

    public synchronized void setQuota(Quota quota) throws MessagingException {
        checkConnected();
        IMAPProtocol iMAPProtocol = null;
        try {
            iMAPProtocol = getStoreProtocol();
            iMAPProtocol.setQuota(quota);
            releaseStoreProtocol(iMAPProtocol);
            if (iMAPProtocol == null) {
                cleanup();
            }
        } catch (BadCommandException e2) {
            throw new MessagingException("QUOTA not supported", e2);
        } catch (ConnectionException e3) {
            throw new StoreClosedException(this, e3.getMessage());
        } catch (ProtocolException e4) {
            throw new MessagingException(e4.getMessage(), e4);
        } catch (Throwable th) {
            releaseStoreProtocol(iMAPProtocol);
            if (iMAPProtocol == null) {
                cleanup();
            }
            throw th;
        }
    }

    public synchronized void setUsername(String str) {
        this.user = str;
    }
}
