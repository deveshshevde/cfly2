package com.sun.mail.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;

public class SocketFetcher {
    private SocketFetcher() {
    }

    private static void configureSSLSocket(Socket socket, Properties properties, String str) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            String property = properties.getProperty(String.valueOf(str) + ".ssl.protocols", (String) null);
            if (property != null) {
                sSLSocket.setEnabledProtocols(stringArray(property));
            } else {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1"});
            }
            String property2 = properties.getProperty(String.valueOf(str) + ".ssl.ciphersuites", (String) null);
            if (property2 != null) {
                sSLSocket.setEnabledCipherSuites(stringArray(property2));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.Socket createSocket(java.net.InetAddress r0, int r1, java.lang.String r2, int r3, int r4, javax.net.SocketFactory r5, boolean r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x0007
        L_0x0002:
            java.net.Socket r5 = r5.createSocket()
            goto L_0x0013
        L_0x0007:
            if (r6 == 0) goto L_0x000e
            javax.net.SocketFactory r5 = javax.net.ssl.SSLSocketFactory.getDefault()
            goto L_0x0002
        L_0x000e:
            java.net.Socket r5 = new java.net.Socket
            r5.<init>()
        L_0x0013:
            if (r0 == 0) goto L_0x001d
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress
            r6.<init>(r0, r1)
            r5.bind(r6)
        L_0x001d:
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress
            if (r4 < 0) goto L_0x0028
            r0.<init>(r2, r3)
            r5.connect(r0, r4)
            goto L_0x002e
        L_0x0028:
            r0.<init>(r2, r3)
            r5.connect(r0)
        L_0x002e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.SocketFetcher.createSocket(java.net.InetAddress, int, java.lang.String, int, int, javax.net.SocketFactory, boolean):java.net.Socket");
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

    public static Socket getSocket(String str, int i2, Properties properties, String str2) throws IOException {
        return getSocket(str, i2, properties, str2, false);
    }

    /* JADX WARNING: type inference failed for: r1v6, types: [java.lang.Throwable] */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e9, code lost:
        r5 = r0;
        r3 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0106, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0107, code lost:
        r5 = r0;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0116, code lost:
        if ((r5 instanceof java.lang.reflect.InvocationTargetException) != false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0118, code lost:
        r1 = ((java.lang.reflect.InvocationTargetException) r5).getTargetException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0121, code lost:
        if ((r1 instanceof java.lang.Exception) != false) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0123, code lost:
        r5 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0128, code lost:
        if ((r5 instanceof java.io.IOException) != false) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x012c, code lost:
        throw ((java.io.IOException) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012d, code lost:
        r1 = new java.io.IOException("Couldn't connect using \"" + r3 + "\" socket factory to host, port: " + r18 + ", " + r0 + "; Exception: " + r5);
        r1.initCause(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x015d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0180, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0182, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0082 A[SYNTHETIC, Splitter:B:19:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cb A[Catch:{ SocketTimeoutException -> 0x0180, Exception -> 0x010e }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0171 A[SYNTHETIC, Splitter:B:71:0x0171] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0180 A[ExcHandler: SocketTimeoutException (r0v16 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:31:0x00c5] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.Socket getSocket(java.lang.String r18, int r19, java.util.Properties r20, java.lang.String r21, boolean r22) throws java.io.IOException {
        /*
            if (r21 != 0) goto L_0x0006
            java.lang.String r0 = "socket"
            r1 = r0
            goto L_0x0008
        L_0x0006:
            r1 = r21
        L_0x0008:
            if (r20 != 0) goto L_0x0011
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            r2 = r0
            goto L_0x0013
        L_0x0011:
            r2 = r20
        L_0x0013:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = java.lang.String.valueOf(r1)
            r0.<init>(r3)
            java.lang.String r3 = ".connectiontimeout"
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r3 = 0
            java.lang.String r0 = r2.getProperty(r0, r3)
            r4 = -1
            if (r0 == 0) goto L_0x0033
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0033 }
            r12 = r0
            goto L_0x0034
        L_0x0033:
            r12 = -1
        L_0x0034:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = java.lang.String.valueOf(r1)
            r0.<init>(r5)
            java.lang.String r5 = ".timeout"
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r13 = r2.getProperty(r0, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = java.lang.String.valueOf(r1)
            r0.<init>(r5)
            java.lang.String r5 = ".localaddress"
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r2.getProperty(r0, r3)
            if (r0 == 0) goto L_0x0068
            java.net.InetAddress r0 = java.net.InetAddress.getByName(r0)
            r14 = r0
            goto L_0x0069
        L_0x0068:
            r14 = r3
        L_0x0069:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = java.lang.String.valueOf(r1)
            r0.<init>(r5)
            java.lang.String r5 = ".localport"
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r2.getProperty(r0, r3)
            r5 = 0
            if (r0 == 0) goto L_0x0088
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0088 }
            r15 = r0
            goto L_0x0089
        L_0x0088:
            r15 = 0
        L_0x0089:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r1)
            r0.<init>(r6)
            java.lang.String r6 = ".socketFactory.fallback"
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r2.getProperty(r0, r3)
            if (r0 == 0) goto L_0x00ac
            java.lang.String r6 = "false"
            boolean r0 = r0.equalsIgnoreCase(r6)
            if (r0 == 0) goto L_0x00ac
            r16 = 0
            goto L_0x00af
        L_0x00ac:
            r5 = 1
            r16 = 1
        L_0x00af:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = java.lang.String.valueOf(r1)
            r0.<init>(r5)
            java.lang.String r5 = ".socketFactory.class"
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r11 = r2.getProperty(r0, r3)
            javax.net.SocketFactory r10 = getSocketFactory(r11)     // Catch:{ SocketTimeoutException -> 0x0180, Exception -> 0x010e }
            if (r10 == 0) goto L_0x010b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0180, Exception -> 0x010e }
            java.lang.String r5 = java.lang.String.valueOf(r1)     // Catch:{ SocketTimeoutException -> 0x0180, Exception -> 0x010e }
            r0.<init>(r5)     // Catch:{ SocketTimeoutException -> 0x0180, Exception -> 0x010e }
            java.lang.String r5 = ".socketFactory.port"
            r0.append(r5)     // Catch:{ SocketTimeoutException -> 0x0180, Exception -> 0x010e }
            java.lang.String r0 = r0.toString()     // Catch:{ SocketTimeoutException -> 0x0180, Exception -> 0x010e }
            java.lang.String r0 = r2.getProperty(r0, r3)     // Catch:{ SocketTimeoutException -> 0x0180, Exception -> 0x010e }
            if (r0 == 0) goto L_0x00ec
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x00ec, SocketTimeoutException -> 0x0180, Exception -> 0x00e8 }
            goto L_0x00ed
        L_0x00e8:
            r0 = move-exception
            r5 = r0
            r3 = r11
            goto L_0x0111
        L_0x00ec:
            r0 = -1
        L_0x00ed:
            if (r0 != r4) goto L_0x00f2
            r17 = r19
            goto L_0x00f4
        L_0x00f2:
            r17 = r0
        L_0x00f4:
            r5 = r14
            r6 = r15
            r7 = r18
            r8 = r17
            r9 = r12
            r3 = r11
            r11 = r22
            java.net.Socket r3 = createSocket(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SocketTimeoutException -> 0x0180, Exception -> 0x0106 }
            r0 = r3
            r3 = r18
            goto L_0x015f
        L_0x0106:
            r0 = move-exception
            r5 = r0
            r0 = r17
            goto L_0x0112
        L_0x010b:
            r3 = r18
            goto L_0x015e
        L_0x010e:
            r0 = move-exception
            r3 = r11
            r5 = r0
        L_0x0111:
            r0 = -1
        L_0x0112:
            if (r16 != 0) goto L_0x010b
            boolean r1 = r5 instanceof java.lang.reflect.InvocationTargetException
            if (r1 == 0) goto L_0x0126
            r1 = r5
            java.lang.reflect.InvocationTargetException r1 = (java.lang.reflect.InvocationTargetException) r1
            java.lang.Throwable r1 = r1.getTargetException()
            boolean r2 = r1 instanceof java.lang.Exception
            if (r2 == 0) goto L_0x0126
            r5 = r1
            java.lang.Exception r5 = (java.lang.Exception) r5
        L_0x0126:
            boolean r1 = r5 instanceof java.io.IOException
            if (r1 == 0) goto L_0x012d
            java.io.IOException r5 = (java.io.IOException) r5
            throw r5
        L_0x012d:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Couldn't connect using \""
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r3 = "\" socket factory to host, port: "
            r2.append(r3)
            r3 = r18
            r2.append(r3)
            java.lang.String r3 = ", "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "; Exception: "
            r2.append(r0)
            r2.append(r5)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            r1.initCause(r5)
            throw r1
        L_0x015e:
            r0 = 0
        L_0x015f:
            if (r0 != 0) goto L_0x016f
            r10 = 0
            r5 = r14
            r6 = r15
            r7 = r18
            r8 = r19
            r9 = r12
            r11 = r22
            java.net.Socket r0 = createSocket(r5, r6, r7, r8, r9, r10, r11)
        L_0x016f:
            if (r13 == 0) goto L_0x0177
            int r4 = java.lang.Integer.parseInt(r13)     // Catch:{ NumberFormatException -> 0x0176 }
            goto L_0x0177
        L_0x0176:
        L_0x0177:
            if (r4 < 0) goto L_0x017c
            r0.setSoTimeout(r4)
        L_0x017c:
            configureSSLSocket(r0, r2, r1)
            return r0
        L_0x0180:
            r0 = move-exception
            goto L_0x0183
        L_0x0182:
            throw r0
        L_0x0183:
            goto L_0x0182
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.SocketFetcher.getSocket(java.lang.String, int, java.util.Properties, java.lang.String, boolean):java.net.Socket");
    }

    private static SocketFactory getSocketFactory(String str) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> cls = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        ClassLoader contextClassLoader = getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                cls = contextClassLoader.loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (cls == null) {
            cls = Class.forName(str);
        }
        return (SocketFactory) cls.getMethod("getDefault", new Class[0]).invoke(new Object(), new Object[0]);
    }

    public static Socket startTLS(Socket socket) throws IOException {
        return startTLS(socket, new Properties(), "socket");
    }

    /* JADX WARNING: type inference failed for: r5v6, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.Socket startTLS(java.net.Socket r4, java.util.Properties r5, java.lang.String r6) throws java.io.IOException {
        /*
            java.net.InetAddress r0 = r4.getInetAddress()
            java.lang.String r0 = r0.getHostName()
            int r1 = r4.getPort()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003e }
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x003e }
            r2.<init>(r3)     // Catch:{ Exception -> 0x003e }
            java.lang.String r3 = ".socketFactory.class"
            r2.append(r3)     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x003e }
            r3 = 0
            java.lang.String r2 = r5.getProperty(r2, r3)     // Catch:{ Exception -> 0x003e }
            javax.net.SocketFactory r2 = getSocketFactory(r2)     // Catch:{ Exception -> 0x003e }
            if (r2 == 0) goto L_0x0030
            boolean r3 = r2 instanceof javax.net.ssl.SSLSocketFactory     // Catch:{ Exception -> 0x003e }
            if (r3 == 0) goto L_0x0030
        L_0x002d:
            javax.net.ssl.SSLSocketFactory r2 = (javax.net.ssl.SSLSocketFactory) r2     // Catch:{ Exception -> 0x003e }
            goto L_0x0035
        L_0x0030:
            javax.net.SocketFactory r2 = javax.net.ssl.SSLSocketFactory.getDefault()     // Catch:{ Exception -> 0x003e }
            goto L_0x002d
        L_0x0035:
            r3 = 1
            java.net.Socket r4 = r2.createSocket(r4, r0, r1, r3)     // Catch:{ Exception -> 0x003e }
            configureSSLSocket(r4, r5, r6)     // Catch:{ Exception -> 0x003e }
            return r4
        L_0x003e:
            r4 = move-exception
            boolean r5 = r4 instanceof java.lang.reflect.InvocationTargetException
            if (r5 == 0) goto L_0x0051
            r5 = r4
            java.lang.reflect.InvocationTargetException r5 = (java.lang.reflect.InvocationTargetException) r5
            java.lang.Throwable r5 = r5.getTargetException()
            boolean r6 = r5 instanceof java.lang.Exception
            if (r6 == 0) goto L_0x0051
            r4 = r5
            java.lang.Exception r4 = (java.lang.Exception) r4
        L_0x0051:
            boolean r5 = r4 instanceof java.io.IOException
            if (r5 == 0) goto L_0x0058
            java.io.IOException r4 = (java.io.IOException) r4
            throw r4
        L_0x0058:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = "Exception in startTLS: host "
            r6.<init>(r2)
            r6.append(r0)
            java.lang.String r0 = ", port "
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "; Exception: "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            r5.initCause(r4)
            goto L_0x0080
        L_0x007f:
            throw r5
        L_0x0080:
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.SocketFetcher.startTLS(java.net.Socket, java.util.Properties, java.lang.String):java.net.Socket");
    }

    private static String[] stringArray(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
