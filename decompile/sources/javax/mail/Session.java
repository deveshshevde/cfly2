package javax.mail;

import com.sun.mail.util.LineInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Provider;

public final class Session {
    private static Session defaultSession;
    /* access modifiers changed from: private */
    public final Properties addressMap = new Properties();
    private final Hashtable authTable = new Hashtable();
    private final Authenticator authenticator;
    private boolean debug = false;
    private PrintStream out;
    private final Properties props;
    private final Vector providers = new Vector();
    private final Hashtable providersByClassName = new Hashtable();
    private final Hashtable providersByProtocol = new Hashtable();

    private Session(Properties properties, Authenticator authenticator2) {
        this.props = properties;
        this.authenticator = authenticator2;
        if (Boolean.valueOf(properties.getProperty("mail.debug")).booleanValue()) {
            this.debug = true;
        }
        if (this.debug) {
            pr("DEBUG: JavaMail version 1.4.1");
        }
        Class<?> cls = authenticator2 != null ? authenticator2.getClass() : getClass();
        loadProviders(cls);
        loadAddressMap(cls);
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                try {
                    return Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused) {
                    return null;
                }
            }
        });
    }

    public static Session getDefaultInstance(Properties properties) {
        return getDefaultInstance(properties, (Authenticator) null);
    }

    public static synchronized Session getDefaultInstance(Properties properties, Authenticator authenticator2) {
        Session session;
        synchronized (Session.class) {
            Session session2 = defaultSession;
            if (session2 == null) {
                defaultSession = new Session(properties, authenticator2);
            } else {
                Authenticator authenticator3 = session2.authenticator;
                if (authenticator3 != authenticator2) {
                    if (authenticator3 == null || authenticator2 == null || authenticator3.getClass().getClassLoader() != authenticator2.getClass().getClassLoader()) {
                        throw new SecurityException("Access to default session denied");
                    }
                }
            }
            session = defaultSession;
        }
        return session;
    }

    public static Session getInstance(Properties properties) {
        return new Session(properties, (Authenticator) null);
    }

    public static Session getInstance(Properties properties, Authenticator authenticator2) {
        return new Session(properties, authenticator2);
    }

    private static InputStream getResourceAsStream(final Class cls, final String str) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() {
                public Object run() throws IOException {
                    return cls.getResourceAsStream(str);
                }
            });
        } catch (PrivilegedActionException e2) {
            throw ((IOException) e2.getException());
        }
    }

    private static URL[] getResources(final ClassLoader classLoader, final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                URL[] urlArr = null;
                try {
                    Vector vector = new Vector();
                    Enumeration<URL> resources = classLoader.getResources(str);
                    while (true) {
                        if (resources == null) {
                            break;
                        } else if (!resources.hasMoreElements()) {
                            break;
                        } else {
                            URL nextElement = resources.nextElement();
                            if (nextElement != null) {
                                vector.addElement(nextElement);
                            }
                        }
                    }
                    if (vector.size() <= 0) {
                        return urlArr;
                    }
                    URL[] urlArr2 = new URL[vector.size()];
                    vector.copyInto(urlArr2);
                    return urlArr2;
                } catch (IOException | SecurityException unused) {
                    return urlArr;
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1 = java.lang.Class.forName(r8.getClassName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007a, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007d, code lost:
        if (r7.debug != false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007f, code lost:
        r9.printStackTrace(getDebugOut());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        throw new javax.mail.NoSuchProviderException(r8.getProtocol());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object getService(javax.mail.Provider r8, javax.mail.URLName r9) throws javax.mail.NoSuchProviderException {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x0090
            if (r9 != 0) goto L_0x0013
            javax.mail.URLName r9 = new javax.mail.URLName
            java.lang.String r1 = r8.getProtocol()
            r2 = 0
            r3 = -1
            r4 = 0
            r5 = 0
            r6 = 0
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
        L_0x0013:
            javax.mail.Authenticator r0 = r7.authenticator
            if (r0 == 0) goto L_0x001c
            java.lang.Class r0 = r0.getClass()
            goto L_0x0020
        L_0x001c:
            java.lang.Class r0 = r7.getClass()
        L_0x0020:
            java.lang.ClassLoader r0 = r0.getClassLoader()
            r1 = 0
            java.lang.ClassLoader r2 = getContextClassLoader()     // Catch:{ Exception -> 0x0040 }
            if (r2 == 0) goto L_0x0035
            java.lang.String r3 = r8.getClassName()     // Catch:{ ClassNotFoundException -> 0x0034 }
            java.lang.Class r1 = r2.loadClass(r3)     // Catch:{ ClassNotFoundException -> 0x0034 }
            goto L_0x0035
        L_0x0034:
        L_0x0035:
            if (r1 != 0) goto L_0x0048
            java.lang.String r1 = r8.getClassName()     // Catch:{ Exception -> 0x0040 }
            java.lang.Class r1 = r0.loadClass(r1)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0048
        L_0x0040:
            java.lang.String r0 = r8.getClassName()     // Catch:{ Exception -> 0x007a }
            java.lang.Class r1 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x007a }
        L_0x0048:
            r0 = 2
            java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0064 }
            java.lang.Class<javax.mail.Session> r3 = javax.mail.Session.class
            r4 = 0
            r2[r4] = r3     // Catch:{ Exception -> 0x0064 }
            java.lang.Class<javax.mail.URLName> r3 = javax.mail.URLName.class
            r5 = 1
            r2[r5] = r3     // Catch:{ Exception -> 0x0064 }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r2)     // Catch:{ Exception -> 0x0064 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0064 }
            r0[r4] = r7     // Catch:{ Exception -> 0x0064 }
            r0[r5] = r9     // Catch:{ Exception -> 0x0064 }
            java.lang.Object r8 = r1.newInstance(r0)     // Catch:{ Exception -> 0x0064 }
            return r8
        L_0x0064:
            r9 = move-exception
            boolean r0 = r7.debug
            if (r0 == 0) goto L_0x0070
            java.io.PrintStream r0 = r7.getDebugOut()
            r9.printStackTrace(r0)
        L_0x0070:
            javax.mail.NoSuchProviderException r9 = new javax.mail.NoSuchProviderException
            java.lang.String r8 = r8.getProtocol()
            r9.<init>(r8)
            throw r9
        L_0x007a:
            r9 = move-exception
            boolean r0 = r7.debug
            if (r0 == 0) goto L_0x0086
            java.io.PrintStream r0 = r7.getDebugOut()
            r9.printStackTrace(r0)
        L_0x0086:
            javax.mail.NoSuchProviderException r9 = new javax.mail.NoSuchProviderException
            java.lang.String r8 = r8.getProtocol()
            r9.<init>(r8)
            throw r9
        L_0x0090:
            javax.mail.NoSuchProviderException r8 = new javax.mail.NoSuchProviderException
            java.lang.String r9 = "null"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.getService(javax.mail.Provider, javax.mail.URLName):java.lang.Object");
    }

    private Store getStore(Provider provider, URLName uRLName) throws NoSuchProviderException {
        if (provider == null || provider.getType() != Provider.Type.STORE) {
            throw new NoSuchProviderException("invalid provider");
        }
        try {
            return (Store) getService(provider, uRLName);
        } catch (ClassCastException unused) {
            throw new NoSuchProviderException("incorrect class");
        }
    }

    private static URL[] getSystemResources(final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                URL[] urlArr = null;
                try {
                    Vector vector = new Vector();
                    Enumeration<URL> systemResources = ClassLoader.getSystemResources(str);
                    while (true) {
                        if (systemResources == null) {
                            break;
                        } else if (!systemResources.hasMoreElements()) {
                            break;
                        } else {
                            URL nextElement = systemResources.nextElement();
                            if (nextElement != null) {
                                vector.addElement(nextElement);
                            }
                        }
                    }
                    if (vector.size() <= 0) {
                        return urlArr;
                    }
                    URL[] urlArr2 = new URL[vector.size()];
                    vector.copyInto(urlArr2);
                    return urlArr2;
                } catch (IOException | SecurityException unused) {
                    return urlArr;
                }
            }
        });
    }

    private Transport getTransport(Provider provider, URLName uRLName) throws NoSuchProviderException {
        if (provider == null || provider.getType() != Provider.Type.TRANSPORT) {
            throw new NoSuchProviderException("invalid provider");
        }
        try {
            return (Transport) getService(provider, uRLName);
        } catch (ClassCastException unused) {
            throw new NoSuchProviderException("incorrect class");
        }
    }

    private void loadAddressMap(Class cls) {
        AnonymousClass2 r0 = new StreamLoader() {
            public void load(InputStream inputStream) throws IOException {
                Session.this.addressMap.load(inputStream);
            }
        };
        loadResource("/META-INF/javamail.default.address.map", cls, r0);
        loadAllResources("META-INF/javamail.address.map", cls, r0);
        try {
            loadFile(String.valueOf(System.getProperty("java.home")) + File.separator + "lib" + File.separator + "javamail.address.map", r0);
        } catch (SecurityException e2) {
            if (this.debug) {
                pr("DEBUG: can't get java.home: " + e2);
            }
        }
        if (this.addressMap.isEmpty()) {
            if (this.debug) {
                pr("DEBUG: failed to load address map, using defaults");
            }
            this.addressMap.put("rfc822", "smtp");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ae, code lost:
        if (r5 == null) goto L_0x00b7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x00c3 */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0086 A[Catch:{ IOException -> 0x0098, SecurityException -> 0x007f, all -> 0x007d, all -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0097 A[Catch:{ IOException -> 0x0098, SecurityException -> 0x007f, all -> 0x007d, all -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009f A[Catch:{ IOException -> 0x0098, SecurityException -> 0x007f, all -> 0x007d, all -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c0 A[SYNTHETIC, Splitter:B:64:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAllResources(java.lang.String r9, java.lang.Class r10, javax.mail.StreamLoader r11) {
        /*
            r8 = this;
            java.lang.String r0 = "DEBUG: "
            r1 = 0
            java.lang.ClassLoader r2 = getContextClassLoader()     // Catch:{ Exception -> 0x00c7 }
            if (r2 != 0) goto L_0x000d
            java.lang.ClassLoader r2 = r10.getClassLoader()     // Catch:{ Exception -> 0x00c7 }
        L_0x000d:
            if (r2 == 0) goto L_0x0014
            java.net.URL[] r2 = getResources(r2, r9)     // Catch:{ Exception -> 0x00c7 }
            goto L_0x0018
        L_0x0014:
            java.net.URL[] r2 = getSystemResources(r9)     // Catch:{ Exception -> 0x00c7 }
        L_0x0018:
            if (r2 == 0) goto L_0x00db
            r3 = 0
        L_0x001b:
            int r4 = r2.length     // Catch:{ Exception -> 0x00c4 }
            if (r1 < r4) goto L_0x0021
            r1 = r3
            goto L_0x00db
        L_0x0021:
            r4 = r2[r1]     // Catch:{ Exception -> 0x00c4 }
            r5 = 0
            boolean r6 = r8.debug     // Catch:{ Exception -> 0x00c4 }
            if (r6 == 0) goto L_0x0039
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r7 = "DEBUG: URL "
            r6.<init>(r7)     // Catch:{ Exception -> 0x00c4 }
            r6.append(r4)     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00c4 }
            r8.pr(r6)     // Catch:{ Exception -> 0x00c4 }
        L_0x0039:
            r6 = 1
            java.io.InputStream r5 = openStream(r4)     // Catch:{ IOException -> 0x0098, SecurityException -> 0x007f, all -> 0x007d }
            if (r5 == 0) goto L_0x0062
            r11.load(r5)     // Catch:{ IOException -> 0x0098, SecurityException -> 0x007f, all -> 0x007d }
            boolean r3 = r8.debug     // Catch:{ IOException -> 0x0060, SecurityException -> 0x005e, all -> 0x005a }
            if (r3 == 0) goto L_0x0058
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0060, SecurityException -> 0x005e, all -> 0x005a }
            java.lang.String r7 = "DEBUG: successfully loaded resource: "
            r3.<init>(r7)     // Catch:{ IOException -> 0x0060, SecurityException -> 0x005e, all -> 0x005a }
            r3.append(r4)     // Catch:{ IOException -> 0x0060, SecurityException -> 0x005e, all -> 0x005a }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0060, SecurityException -> 0x005e, all -> 0x005a }
            r8.pr(r3)     // Catch:{ IOException -> 0x0060, SecurityException -> 0x005e, all -> 0x005a }
        L_0x0058:
            r3 = 1
            goto L_0x0077
        L_0x005a:
            r1 = move-exception
            r3 = 1
            goto L_0x00be
        L_0x005e:
            r3 = move-exception
            goto L_0x0082
        L_0x0060:
            r3 = move-exception
            goto L_0x009b
        L_0x0062:
            boolean r6 = r8.debug     // Catch:{ IOException -> 0x0098, SecurityException -> 0x007f, all -> 0x007d }
            if (r6 == 0) goto L_0x0077
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0098, SecurityException -> 0x007f, all -> 0x007d }
            java.lang.String r7 = "DEBUG: not loading resource: "
            r6.<init>(r7)     // Catch:{ IOException -> 0x0098, SecurityException -> 0x007f, all -> 0x007d }
            r6.append(r4)     // Catch:{ IOException -> 0x0098, SecurityException -> 0x007f, all -> 0x007d }
            java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x0098, SecurityException -> 0x007f, all -> 0x007d }
            r8.pr(r4)     // Catch:{ IOException -> 0x0098, SecurityException -> 0x007f, all -> 0x007d }
        L_0x0077:
            if (r5 == 0) goto L_0x00b8
            r5.close()     // Catch:{ IOException -> 0x00b8 }
            goto L_0x00b8
        L_0x007d:
            r1 = move-exception
            goto L_0x00be
        L_0x007f:
            r4 = move-exception
            r6 = r3
            r3 = r4
        L_0x0082:
            boolean r4 = r8.debug     // Catch:{ all -> 0x00bc }
            if (r4 == 0) goto L_0x0095
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            r4.<init>(r0)     // Catch:{ all -> 0x00bc }
            r4.append(r3)     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x00bc }
            r8.pr(r3)     // Catch:{ all -> 0x00bc }
        L_0x0095:
            if (r5 == 0) goto L_0x00b7
            goto L_0x00b0
        L_0x0098:
            r4 = move-exception
            r6 = r3
            r3 = r4
        L_0x009b:
            boolean r4 = r8.debug     // Catch:{ all -> 0x00bc }
            if (r4 == 0) goto L_0x00ae
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            r4.<init>(r0)     // Catch:{ all -> 0x00bc }
            r4.append(r3)     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x00bc }
            r8.pr(r3)     // Catch:{ all -> 0x00bc }
        L_0x00ae:
            if (r5 == 0) goto L_0x00b7
        L_0x00b0:
            r5.close()     // Catch:{ IOException -> 0x00b7, Exception -> 0x00b4 }
            goto L_0x00b7
        L_0x00b4:
            r2 = move-exception
            r1 = r6
            goto L_0x00c8
        L_0x00b7:
            r3 = r6
        L_0x00b8:
            int r1 = r1 + 1
            goto L_0x001b
        L_0x00bc:
            r1 = move-exception
            r3 = r6
        L_0x00be:
            if (r5 == 0) goto L_0x00c3
            r5.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x00c3:
            throw r1     // Catch:{ Exception -> 0x00c4 }
        L_0x00c4:
            r2 = move-exception
            r1 = r3
            goto L_0x00c8
        L_0x00c7:
            r2 = move-exception
        L_0x00c8:
            boolean r3 = r8.debug
            if (r3 == 0) goto L_0x00db
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            r8.pr(r0)
        L_0x00db:
            if (r1 != 0) goto L_0x00f7
            boolean r0 = r8.debug
            if (r0 == 0) goto L_0x00e6
            java.lang.String r0 = "DEBUG: !anyLoaded"
            r8.pr(r0)
        L_0x00e6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "/"
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r8.loadResource(r9, r10, r11)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.loadAllResources(java.lang.String, java.lang.Class, javax.mail.StreamLoader):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b A[Catch:{ all -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0064 A[Catch:{ all -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0088 A[SYNTHETIC, Splitter:B:32:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0060=Splitter:B:25:0x0060, B:17:0x0037=Splitter:B:17:0x0037} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:7:0x0027=Splitter:B:7:0x0027, B:22:0x005b=Splitter:B:22:0x005b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadFile(java.lang.String r6, javax.mail.StreamLoader r7) {
        /*
            r5 = this;
            java.lang.String r0 = "DEBUG: "
            java.lang.String r1 = "DEBUG: not loading file: "
            r2 = 0
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x005f, SecurityException -> 0x0036 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x005f, SecurityException -> 0x0036 }
            r4.<init>(r6)     // Catch:{ IOException -> 0x005f, SecurityException -> 0x0036 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x005f, SecurityException -> 0x0036 }
            r7.load(r3)     // Catch:{ IOException -> 0x0031, SecurityException -> 0x002e, all -> 0x002b }
            boolean r7 = r5.debug     // Catch:{ IOException -> 0x0031, SecurityException -> 0x002e, all -> 0x002b }
            if (r7 == 0) goto L_0x0027
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0031, SecurityException -> 0x002e, all -> 0x002b }
            java.lang.String r2 = "DEBUG: successfully loaded file: "
            r7.<init>(r2)     // Catch:{ IOException -> 0x0031, SecurityException -> 0x002e, all -> 0x002b }
            r7.append(r6)     // Catch:{ IOException -> 0x0031, SecurityException -> 0x002e, all -> 0x002b }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0031, SecurityException -> 0x002e, all -> 0x002b }
            r5.pr(r7)     // Catch:{ IOException -> 0x0031, SecurityException -> 0x002e, all -> 0x002b }
        L_0x0027:
            r3.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0085
        L_0x002b:
            r6 = move-exception
            r2 = r3
            goto L_0x0086
        L_0x002e:
            r7 = move-exception
            r2 = r3
            goto L_0x0037
        L_0x0031:
            r7 = move-exception
            r2 = r3
            goto L_0x0060
        L_0x0034:
            r6 = move-exception
            goto L_0x0086
        L_0x0036:
            r7 = move-exception
        L_0x0037:
            boolean r3 = r5.debug     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0059
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r3.<init>(r1)     // Catch:{ all -> 0x0034 }
            r3.append(r6)     // Catch:{ all -> 0x0034 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0034 }
            r5.pr(r6)     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r6.<init>(r0)     // Catch:{ all -> 0x0034 }
            r6.append(r7)     // Catch:{ all -> 0x0034 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0034 }
            r5.pr(r6)     // Catch:{ all -> 0x0034 }
        L_0x0059:
            if (r2 == 0) goto L_0x0085
        L_0x005b:
            r2.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0085
        L_0x005f:
            r7 = move-exception
        L_0x0060:
            boolean r3 = r5.debug     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0082
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r3.<init>(r1)     // Catch:{ all -> 0x0034 }
            r3.append(r6)     // Catch:{ all -> 0x0034 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0034 }
            r5.pr(r6)     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r6.<init>(r0)     // Catch:{ all -> 0x0034 }
            r6.append(r7)     // Catch:{ all -> 0x0034 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0034 }
            r5.pr(r6)     // Catch:{ all -> 0x0034 }
        L_0x0082:
            if (r2 == 0) goto L_0x0085
            goto L_0x005b
        L_0x0085:
            return
        L_0x0086:
            if (r2 == 0) goto L_0x008b
            r2.close()     // Catch:{ IOException -> 0x008b }
        L_0x008b:
            goto L_0x008d
        L_0x008c:
            throw r6
        L_0x008d:
            goto L_0x008c
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.loadFile(java.lang.String, javax.mail.StreamLoader):void");
    }

    private void loadProviders(Class cls) {
        AnonymousClass1 r0 = new StreamLoader() {
            public void load(InputStream inputStream) throws IOException {
                Session.this.loadProvidersFromStream(inputStream);
            }
        };
        try {
            loadFile(String.valueOf(System.getProperty("java.home")) + File.separator + "lib" + File.separator + "javamail.providers", r0);
        } catch (SecurityException e2) {
            if (this.debug) {
                pr("DEBUG: can't get java.home: " + e2);
            }
        }
        loadAllResources("META-INF/javamail.providers", cls, r0);
        loadResource("/META-INF/javamail.default.providers", cls, r0);
        if (this.providers.size() == 0) {
            if (this.debug) {
                pr("DEBUG: failed to load any providers, using defaults");
            }
            addProvider(new Provider(Provider.Type.STORE, "imap", "com.sun.mail.imap.IMAPStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Provider.Type.STORE, "imaps", "com.sun.mail.imap.IMAPSSLStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Provider.Type.STORE, "pop3", "com.sun.mail.pop3.POP3Store", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Provider.Type.STORE, "pop3s", "com.sun.mail.pop3.POP3SSLStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Provider.Type.TRANSPORT, "smtp", "com.sun.mail.smtp.SMTPTransport", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(Provider.Type.TRANSPORT, "smtps", "com.sun.mail.smtp.SMTPSSLTransport", "Sun Microsystems, Inc.", Version.version));
        }
        if (this.debug) {
            pr("DEBUG: Tables of loaded providers");
            pr("DEBUG: Providers Listed By Class Name: " + this.providersByClassName.toString());
            pr("DEBUG: Providers Listed By Protocol: " + this.providersByProtocol.toString());
        }
    }

    /* access modifiers changed from: private */
    public void loadProvidersFromStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            LineInputStream lineInputStream = new LineInputStream(inputStream);
            while (true) {
                String readLine = lineInputStream.readLine();
                if (readLine != null) {
                    if (!readLine.startsWith("#")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine, ";");
                        Provider.Type type = null;
                        String str = null;
                        String str2 = null;
                        String str3 = null;
                        String str4 = null;
                        while (stringTokenizer.hasMoreTokens()) {
                            String trim = stringTokenizer.nextToken().trim();
                            int indexOf = trim.indexOf("=");
                            if (trim.startsWith("protocol=")) {
                                str = trim.substring(indexOf + 1);
                            } else if (trim.startsWith("type=")) {
                                String substring = trim.substring(indexOf + 1);
                                if (substring.equalsIgnoreCase("store")) {
                                    type = Provider.Type.STORE;
                                } else if (substring.equalsIgnoreCase("transport")) {
                                    type = Provider.Type.TRANSPORT;
                                }
                            } else if (trim.startsWith("class=")) {
                                str2 = trim.substring(indexOf + 1);
                            } else if (trim.startsWith("vendor=")) {
                                str3 = trim.substring(indexOf + 1);
                            } else if (trim.startsWith("version=")) {
                                str4 = trim.substring(indexOf + 1);
                            }
                        }
                        if (type != null && str != null && str2 != null && str.length() > 0 && str2.length() > 0) {
                            addProvider(new Provider(type, str, str2, str3, str4));
                        } else if (this.debug) {
                            pr("DEBUG: Bad provider entry: " + readLine);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadResource(java.lang.String r3, java.lang.Class r4, javax.mail.StreamLoader r5) {
        /*
            r2 = this;
            java.lang.String r0 = "DEBUG: "
            r1 = 0
            java.io.InputStream r1 = getResourceAsStream(r4, r3)     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            if (r1 == 0) goto L_0x0022
            r5.load(r1)     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            boolean r4 = r2.debug     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            if (r4 == 0) goto L_0x0035
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            java.lang.String r5 = "DEBUG: successfully loaded resource: "
            r4.<init>(r5)     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            r4.append(r3)     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
        L_0x001e:
            r2.pr(r3)     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            goto L_0x0035
        L_0x0022:
            boolean r4 = r2.debug     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            if (r4 == 0) goto L_0x0035
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            java.lang.String r5 = "DEBUG: not loading resource: "
            r4.<init>(r5)     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            r4.append(r3)     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x0054, SecurityException -> 0x003d }
            goto L_0x001e
        L_0x0035:
            if (r1 == 0) goto L_0x006b
        L_0x0037:
            r1.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x006b
        L_0x003b:
            r3 = move-exception
            goto L_0x006c
        L_0x003d:
            r3 = move-exception
            boolean r4 = r2.debug     // Catch:{ all -> 0x003b }
            if (r4 == 0) goto L_0x0051
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            r4.<init>(r0)     // Catch:{ all -> 0x003b }
            r4.append(r3)     // Catch:{ all -> 0x003b }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x003b }
            r2.pr(r3)     // Catch:{ all -> 0x003b }
        L_0x0051:
            if (r1 == 0) goto L_0x006b
            goto L_0x0037
        L_0x0054:
            r3 = move-exception
            boolean r4 = r2.debug     // Catch:{ all -> 0x003b }
            if (r4 == 0) goto L_0x0068
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            r4.<init>(r0)     // Catch:{ all -> 0x003b }
            r4.append(r3)     // Catch:{ all -> 0x003b }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x003b }
            r2.pr(r3)     // Catch:{ all -> 0x003b }
        L_0x0068:
            if (r1 == 0) goto L_0x006b
            goto L_0x0037
        L_0x006b:
            return
        L_0x006c:
            if (r1 == 0) goto L_0x0071
            r1.close()     // Catch:{ IOException -> 0x0071 }
        L_0x0071:
            goto L_0x0073
        L_0x0072:
            throw r3
        L_0x0073:
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.loadResource(java.lang.String, java.lang.Class, javax.mail.StreamLoader):void");
    }

    private static InputStream openStream(final URL url) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() {
                public Object run() throws IOException {
                    return url.openStream();
                }
            });
        } catch (PrivilegedActionException e2) {
            throw ((IOException) e2.getException());
        }
    }

    private void pr(String str) {
        getDebugOut().println(str);
    }

    public synchronized void addProvider(Provider provider) {
        this.providers.addElement(provider);
        this.providersByClassName.put(provider.getClassName(), provider);
        if (!this.providersByProtocol.containsKey(provider.getProtocol())) {
            this.providersByProtocol.put(provider.getProtocol(), provider);
        }
    }

    public synchronized boolean getDebug() {
        return this.debug;
    }

    public synchronized PrintStream getDebugOut() {
        PrintStream printStream = this.out;
        if (printStream != null) {
            return printStream;
        }
        return System.out;
    }

    public Folder getFolder(URLName uRLName) throws MessagingException {
        Store store = getStore(uRLName);
        store.connect();
        return store.getFolder(uRLName);
    }

    public PasswordAuthentication getPasswordAuthentication(URLName uRLName) {
        return (PasswordAuthentication) this.authTable.get(uRLName);
    }

    public Properties getProperties() {
        return this.props;
    }

    public String getProperty(String str) {
        return this.props.getProperty(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized javax.mail.Provider getProvider(java.lang.String r5) throws javax.mail.NoSuchProviderException {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x0087
            int r0 = r5.length()     // Catch:{ all -> 0x008f }
            if (r0 <= 0) goto L_0x0087
            r0 = 0
            java.util.Properties r1 = r4.props     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r3 = "mail."
            r2.<init>(r3)     // Catch:{ all -> 0x008f }
            r2.append(r5)     // Catch:{ all -> 0x008f }
            java.lang.String r3 = ".class"
            r2.append(r3)     // Catch:{ all -> 0x008f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008f }
            java.lang.String r1 = r1.getProperty(r2)     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x004a
            boolean r0 = r4.debug     // Catch:{ all -> 0x008f }
            if (r0 == 0) goto L_0x0042
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "DEBUG: mail."
            r0.<init>(r2)     // Catch:{ all -> 0x008f }
            r0.append(r5)     // Catch:{ all -> 0x008f }
            java.lang.String r2 = ".class property exists and points to "
            r0.append(r2)     // Catch:{ all -> 0x008f }
            r0.append(r1)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008f }
            r4.pr(r0)     // Catch:{ all -> 0x008f }
        L_0x0042:
            java.util.Hashtable r0 = r4.providersByClassName     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x008f }
            javax.mail.Provider r0 = (javax.mail.Provider) r0     // Catch:{ all -> 0x008f }
        L_0x004a:
            if (r0 == 0) goto L_0x004e
            monitor-exit(r4)
            return r0
        L_0x004e:
            java.util.Hashtable r0 = r4.providersByProtocol     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x008f }
            javax.mail.Provider r0 = (javax.mail.Provider) r0     // Catch:{ all -> 0x008f }
            if (r0 == 0) goto L_0x0073
            boolean r5 = r4.debug     // Catch:{ all -> 0x008f }
            if (r5 == 0) goto L_0x0071
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r1 = "DEBUG: getProvider() returning "
            r5.<init>(r1)     // Catch:{ all -> 0x008f }
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x008f }
            r5.append(r1)     // Catch:{ all -> 0x008f }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x008f }
            r4.pr(r5)     // Catch:{ all -> 0x008f }
        L_0x0071:
            monitor-exit(r4)
            return r0
        L_0x0073:
            javax.mail.NoSuchProviderException r0 = new javax.mail.NoSuchProviderException     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "No provider for "
            r1.<init>(r2)     // Catch:{ all -> 0x008f }
            r1.append(r5)     // Catch:{ all -> 0x008f }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x008f }
            r0.<init>(r5)     // Catch:{ all -> 0x008f }
            throw r0     // Catch:{ all -> 0x008f }
        L_0x0087:
            javax.mail.NoSuchProviderException r5 = new javax.mail.NoSuchProviderException     // Catch:{ all -> 0x008f }
            java.lang.String r0 = "Invalid protocol: null"
            r5.<init>(r0)     // Catch:{ all -> 0x008f }
            throw r5     // Catch:{ all -> 0x008f }
        L_0x008f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.getProvider(java.lang.String):javax.mail.Provider");
    }

    public synchronized Provider[] getProviders() {
        Provider[] providerArr;
        providerArr = new Provider[this.providers.size()];
        this.providers.copyInto(providerArr);
        return providerArr;
    }

    public Store getStore() throws NoSuchProviderException {
        return getStore(getProperty("mail.store.protocol"));
    }

    public Store getStore(String str) throws NoSuchProviderException {
        return getStore(new URLName(str, (String) null, -1, (String) null, (String) null, (String) null));
    }

    public Store getStore(Provider provider) throws NoSuchProviderException {
        return getStore(provider, (URLName) null);
    }

    public Store getStore(URLName uRLName) throws NoSuchProviderException {
        return getStore(getProvider(uRLName.getProtocol()), uRLName);
    }

    public Transport getTransport() throws NoSuchProviderException {
        return getTransport(getProperty("mail.transport.protocol"));
    }

    public Transport getTransport(String str) throws NoSuchProviderException {
        return getTransport(new URLName(str, (String) null, -1, (String) null, (String) null, (String) null));
    }

    public Transport getTransport(Address address) throws NoSuchProviderException {
        String str = (String) this.addressMap.get(address.getType());
        if (str != null) {
            return getTransport(str);
        }
        throw new NoSuchProviderException("No provider for Address type: " + address.getType());
    }

    public Transport getTransport(Provider provider) throws NoSuchProviderException {
        return getTransport(provider, (URLName) null);
    }

    public Transport getTransport(URLName uRLName) throws NoSuchProviderException {
        return getTransport(getProvider(uRLName.getProtocol()), uRLName);
    }

    public PasswordAuthentication requestPasswordAuthentication(InetAddress inetAddress, int i2, String str, String str2, String str3) {
        Authenticator authenticator2 = this.authenticator;
        if (authenticator2 != null) {
            return authenticator2.requestPasswordAuthentication(inetAddress, i2, str, str2, str3);
        }
        return null;
    }

    public synchronized void setDebug(boolean z2) {
        this.debug = z2;
        if (z2) {
            pr("DEBUG: setDebug: JavaMail version 1.4.1");
        }
    }

    public synchronized void setDebugOut(PrintStream printStream) {
        this.out = printStream;
    }

    public void setPasswordAuthentication(URLName uRLName, PasswordAuthentication passwordAuthentication) {
        if (passwordAuthentication == null) {
            this.authTable.remove(uRLName);
        } else {
            this.authTable.put(uRLName, passwordAuthentication);
        }
    }

    public synchronized void setProtocolForAddress(String str, String str2) {
        if (str2 == null) {
            this.addressMap.remove(str);
        } else {
            this.addressMap.put(str, str2);
        }
    }

    public synchronized void setProvider(Provider provider) throws NoSuchProviderException {
        if (provider != null) {
            this.providersByProtocol.put(provider.getProtocol(), provider);
            Properties properties = this.props;
            properties.put("mail." + provider.getProtocol() + ".class", provider.getClassName());
        } else {
            throw new NoSuchProviderException("Can't set null provider");
        }
    }
}
