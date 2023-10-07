package org.apache.commons.net.ftp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import nm.a;
import org.apache.commons.net.MalformedServerReplyException;
import org.apache.commons.net.ProtocolCommandSupport;
import org.apache.commons.net.c;

public class b extends c {

    /* renamed from: j  reason: collision with root package name */
    protected int f32837j;

    /* renamed from: k  reason: collision with root package name */
    protected ArrayList<String> f32838k;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f32839l;

    /* renamed from: m  reason: collision with root package name */
    protected String f32840m;

    /* renamed from: n  reason: collision with root package name */
    protected String f32841n;

    /* renamed from: o  reason: collision with root package name */
    protected ProtocolCommandSupport f32842o;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f32843p;

    /* renamed from: q  reason: collision with root package name */
    protected BufferedReader f32844q;

    /* renamed from: r  reason: collision with root package name */
    protected BufferedWriter f32845r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f32846s = true;

    public b() {
        a(21);
        this.f32838k = new ArrayList<>();
        this.f32839l = false;
        this.f32840m = null;
        this.f32841n = "ISO-8859-1";
        this.f32842o = new ProtocolCommandSupport(this);
    }

    private int a(boolean z2) throws IOException {
        this.f32839l = true;
        this.f32838k.clear();
        String readLine = this.f32844q.readLine();
        if (readLine != null) {
            int length = readLine.length();
            if (length >= 3) {
                try {
                    String substring = readLine.substring(0, 3);
                    this.f32837j = Integer.parseInt(substring);
                    this.f32838k.add(readLine);
                    if (length > 3) {
                        char charAt = readLine.charAt(3);
                        if (charAt == '-') {
                            while (true) {
                                String readLine2 = this.f32844q.readLine();
                                if (readLine2 != null) {
                                    this.f32838k.add(readLine2);
                                    if (p()) {
                                        if (!c(readLine2, substring)) {
                                            break;
                                        }
                                    } else if (!h(readLine2)) {
                                        break;
                                    }
                                } else {
                                    throw new FTPConnectionClosedException("Connection closed without indication.");
                                }
                            }
                        } else if (q()) {
                            if (length == 4) {
                                throw new MalformedServerReplyException("Truncated server reply: '" + readLine + "'");
                            } else if (charAt != ' ') {
                                throw new MalformedServerReplyException("Invalid server reply: '" + readLine + "'");
                            }
                        }
                    } else if (q()) {
                        throw new MalformedServerReplyException("Truncated server reply: '" + readLine + "'");
                    }
                    if (z2) {
                        a(this.f32837j, k());
                    }
                    int i2 = this.f32837j;
                    if (i2 != 421) {
                        return i2;
                    }
                    throw new FTPConnectionClosedException("FTP response 421 received.  Server closed connection.");
                } catch (NumberFormatException unused) {
                    throw new MalformedServerReplyException("Could not parse response code.\nServer Reply: " + readLine);
                }
            } else {
                throw new MalformedServerReplyException("Truncated server reply: " + readLine);
            }
        } else {
            throw new FTPConnectionClosedException("Connection closed without indication.");
        }
    }

    private boolean c(String str, String str2) {
        return !str.startsWith(str2) || str.charAt(3) != ' ';
    }

    private String d(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            sb.append(' ');
            sb.append(str2);
        }
        sb.append("\r\n");
        return sb.toString();
    }

    private boolean h(String str) {
        return str.length() <= 3 || str.charAt(3) == '-' || !Character.isDigit(str.charAt(0));
    }

    private void i(String str) throws IOException, FTPConnectionClosedException, SocketException {
        try {
            this.f32845r.write(str);
            this.f32845r.flush();
        } catch (SocketException e2) {
            if (!d()) {
                throw new FTPConnectionClosedException("Connection unexpectedly closed.");
            }
            throw e2;
        }
    }

    public int a(InetAddress inetAddress, int i2) throws IOException {
        StringBuilder sb = new StringBuilder(24);
        sb.append(inetAddress.getHostAddress().replace('.', ','));
        sb.append(',');
        sb.append(i2 >>> 8);
        sb.append(',');
        sb.append(i2 & 255);
        return a(FTPCmd.PORT, sb.toString());
    }

    public int a(FTPCmd fTPCmd) throws IOException {
        return a(fTPCmd, (String) null);
    }

    public int a(FTPCmd fTPCmd, String str) throws IOException {
        return b(fTPCmd.a(), str);
    }

    /* access modifiers changed from: protected */
    public void a() throws IOException {
        a((Reader) null);
    }

    /* access modifiers changed from: protected */
    public void a(Reader reader) throws IOException {
        super.a();
        if (reader == null) {
            this.f32844q = new a(new InputStreamReader(this.f32768e, h()));
        } else {
            this.f32844q = new a(reader);
        }
        this.f32845r = new BufferedWriter(new OutputStreamWriter(this.f32769f, h()));
        if (this.f32772i > 0) {
            int soTimeout = this.f32765b.getSoTimeout();
            this.f32765b.setSoTimeout(this.f32772i);
            try {
                j();
                if (j.a(this.f32837j)) {
                    j();
                }
                this.f32765b.setSoTimeout(soTimeout);
            } catch (SocketTimeoutException e2) {
                IOException iOException = new IOException("Timed out waiting for initial connect reply");
                iOException.initCause(e2);
                throw iOException;
            } catch (Throwable th) {
                this.f32765b.setSoTimeout(soTimeout);
                throw th;
            }
        } else {
            j();
            if (j.a(this.f32837j)) {
                j();
            }
        }
    }

    public void a(String str) {
        this.f32841n = str;
    }

    public int b(int i2) throws IOException {
        return a(FTPCmd.TYPE, "AEILNTCFRPSBC".substring(i2, i2 + 1));
    }

    public int b(String str) throws IOException {
        return a(FTPCmd.USER, str);
    }

    public int b(String str, String str2) throws IOException {
        if (this.f32845r != null) {
            String d2 = d(str, str2);
            i(d2);
            a(str, d2);
            return j();
        }
        throw new IOException("Connection is not open");
    }

    public int b(InetAddress inetAddress, int i2) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder();
        String hostAddress = inetAddress.getHostAddress();
        int indexOf = hostAddress.indexOf(37);
        if (indexOf > 0) {
            hostAddress = hostAddress.substring(0, indexOf);
        }
        sb.append("|");
        if (inetAddress instanceof Inet4Address) {
            str = "1";
        } else {
            if (inetAddress instanceof Inet6Address) {
                str = "2";
            }
            sb.append("|");
            sb.append(hostAddress);
            sb.append("|");
            sb.append(i2);
            sb.append("|");
            return a(FTPCmd.EPRT, sb.toString());
        }
        sb.append(str);
        sb.append("|");
        sb.append(hostAddress);
        sb.append("|");
        sb.append(i2);
        sb.append("|");
        return a(FTPCmd.EPRT, sb.toString());
    }

    public int c(String str) throws IOException {
        return a(FTPCmd.PASS, str);
    }

    public void c() throws IOException {
        super.c();
        this.f32844q = null;
        this.f32845r = null;
        this.f32839l = false;
        this.f32840m = null;
    }

    public int d(String str) throws IOException {
        return a(FTPCmd.CWD, str);
    }

    public int e(String str) throws IOException {
        return a(FTPCmd.REST, str);
    }

    public int f(String str) throws IOException {
        return a(FTPCmd.DELE, str);
    }

    public int g(String str) throws IOException {
        return a(FTPCmd.MKD, str);
    }

    /* access modifiers changed from: protected */
    public ProtocolCommandSupport g() {
        return this.f32842o;
    }

    public String h() {
        return this.f32841n;
    }

    public int i() {
        return this.f32837j;
    }

    public int j() throws IOException {
        return a(true);
    }

    public String k() {
        if (!this.f32839l) {
            return this.f32840m;
        }
        StringBuilder sb = new StringBuilder(256);
        Iterator<String> it2 = this.f32838k.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            sb.append("\r\n");
        }
        this.f32839l = false;
        String sb2 = sb.toString();
        this.f32840m = sb2;
        return sb2;
    }

    public int l() throws IOException {
        return a(FTPCmd.PASV);
    }

    public int m() throws IOException {
        return a(FTPCmd.EPSV);
    }

    public int n() throws IOException {
        return a(FTPCmd.FEAT);
    }

    public int o() throws IOException {
        return a(FTPCmd.SYST);
    }

    public boolean p() {
        return this.f32843p;
    }

    public boolean q() {
        return this.f32846s;
    }
}
