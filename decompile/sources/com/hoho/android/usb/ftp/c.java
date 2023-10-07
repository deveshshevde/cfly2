package com.hoho.android.usb.ftp;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f11846a = false;

    /* renamed from: b  reason: collision with root package name */
    protected int f11847b;

    /* renamed from: c  reason: collision with root package name */
    protected ArrayList<String> f11848c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    protected boolean f11849d = false;

    /* renamed from: e  reason: collision with root package name */
    protected String f11850e = null;

    /* renamed from: f  reason: collision with root package name */
    protected String f11851f = "ISO-8859-1";

    /* renamed from: g  reason: collision with root package name */
    private boolean f11852g = true;

    private boolean b(String str, String str2) {
        return !str.startsWith(str2) || str.charAt(3) != ' ';
    }

    private String c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            sb.append(' ');
            sb.append(str2);
        }
        sb.append("\r\n");
        return sb.toString();
    }

    private boolean g(String str) {
        return str.length() <= 3 || str.charAt(3) == '-' || !Character.isDigit(str.charAt(0));
    }

    public int a(int i2) throws Exception {
        return a(UsbFtpCmd.TYPE, "AEILNTCFRPSBC".substring(i2, i2 + 1));
    }

    public int a(UsbFtpCmd usbFtpCmd, String str) throws Exception {
        return a(usbFtpCmd.a(), str);
    }

    public int a(String str, String str2) throws Exception {
        a(c(str, str2));
        b();
        return this.f11847b;
    }

    public abstract String a() throws Exception;

    public abstract boolean a(String str);

    /* access modifiers changed from: protected */
    public void b() throws Exception {
        this.f11849d = true;
        this.f11848c.clear();
        String a2 = a();
        if (a2 != null) {
            int length = a2.length();
            if (length >= 3) {
                try {
                    Log.i("FTP", "__getReply:==== " + a2);
                    String substring = a2.substring(0, 3);
                    this.f11847b = Integer.parseInt(substring);
                    this.f11848c.add(a2);
                    if (length > 3) {
                        char charAt = a2.charAt(3);
                        if (charAt == '-') {
                            while (true) {
                                String a3 = a();
                                if (a3 != null) {
                                    this.f11848c.add(a3);
                                    if (d()) {
                                        if (!b(a3, substring)) {
                                            break;
                                        }
                                    } else if (!g(a3)) {
                                        break;
                                    }
                                } else {
                                    throw new Exception("Connection closed without indication.");
                                }
                            }
                        } else if (e()) {
                            if (length == 4) {
                                throw new Exception("Truncated server reply:=='" + a2 + "'");
                            } else if (charAt != ' ') {
                                throw new Exception("Invalid server reply:=='" + a2 + "'");
                            }
                        }
                    } else if (e()) {
                        throw new Exception("Truncated server reply:=='" + a2 + "'");
                    }
                    if (this.f11847b == 421) {
                        throw new Exception("FTP response 421 received. Server closed connection.");
                    }
                } catch (NumberFormatException unused) {
                    throw new Exception("Could not parse response code.\nServer Reply:==" + a2);
                }
            } else {
                throw new Exception("Truncated server reply:===" + a2);
            }
        } else {
            throw new Exception("Connection closed without indication.");
        }
    }

    public void b(String str) {
        this.f11851f = str;
    }

    public int c(String str) throws Exception {
        return a(UsbFtpCmd.CWD, str);
    }

    public String c() {
        if (!this.f11849d) {
            return this.f11850e;
        }
        StringBuilder sb = new StringBuilder(256);
        Iterator<String> it2 = this.f11848c.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            sb.append("\r\n");
        }
        this.f11849d = false;
        String sb2 = sb.toString();
        this.f11850e = sb2;
        return sb2;
    }

    public int d(String str) throws Exception {
        return a(UsbFtpCmd.DELE, str);
    }

    public boolean d() {
        return this.f11846a;
    }

    public int e(String str) throws Exception {
        return a(UsbFtpCmd.MKD, str);
    }

    public boolean e() {
        return this.f11852g;
    }

    public int f(String str) throws Exception {
        return a(UsbFtpCmd.SIZE, str);
    }
}
