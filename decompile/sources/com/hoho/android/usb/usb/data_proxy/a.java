package com.hoho.android.usb.usb.data_proxy;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class a {

    /* renamed from: f  reason: collision with root package name */
    private static int f20264f;

    /* renamed from: a  reason: collision with root package name */
    protected int f20265a;

    /* renamed from: b  reason: collision with root package name */
    protected C0135a f20266b;

    /* renamed from: c  reason: collision with root package name */
    protected d f20267c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f20268d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    private final Object f20269e = new Object();

    /* renamed from: com.hoho.android.usb.usb.data_proxy.a$a  reason: collision with other inner class name */
    public interface C0135a {
        void a(int i2, String str, int i3, int i4, int i5, String str2);

        void a(byte[] bArr, String str, int i2);
    }

    a(d dVar, int i2) {
        this.f20267c = dVar;
        this.f20265a = i2;
    }

    public int a(String str, int i2) {
        return 10003;
    }

    public int a(byte[] bArr) {
        return 10003;
    }

    public int a(byte[] bArr, String str, int i2) {
        return 10003;
    }

    public C0135a a() {
        return this.f20266b;
    }

    public String a(String str, String str2, String str3) {
        String str4 = "OPTIONS " + str + " RTSP/1.0" + "\r\n";
        if (str3 != null) {
            str4 = str4 + "Authorization: " + str3 + "\r\n";
        }
        String str5 = str4 + "CSeq: " + this.f20268d.addAndGet(1) + "\r\n";
        if (str2 != null) {
            str5 = str5 + "User-Agent: " + str2 + "\r\n";
        }
        return str5 + "\r\n";
    }

    public String a(String str, String str2, String str3, String str4) {
        String str5 = "GET_PARAMETER " + str + " RTSP/1.0" + "\r\n";
        if (str4 != null) {
            str5 = str5 + "Authorization: " + str4 + "\r\n";
        }
        String str6 = str5 + "CSeq: " + this.f20268d.addAndGet(1) + "\r\n";
        if (str2 != null) {
            str6 = str6 + "User-Agent: " + str2 + "\r\n";
        }
        if (str3 != null) {
            str6 = str6 + "Session: " + str3 + "\r\n";
        }
        return str6 + "\r\n";
    }

    public String a(String str, String str2, String str3, String str4, String str5) {
        String str6 = ("SETUP " + str + " RTSP/1.0" + "\r\n") + "Transport: RTP/AVP/UDP;unicast;client_port=9898-9899\r\n";
        if (str3 != null) {
            str6 = str6 + "Authorization: " + str3 + "\r\n";
        }
        String str7 = str6 + "CSeq: " + this.f20268d.addAndGet(1) + "\r\n";
        if (str2 != null) {
            str7 = str7 + "User-Agent: " + str2 + "\r\n";
        }
        if (str4 != null) {
            str7 = str7 + "Session: " + str4 + "\r\n";
        }
        return str7 + "\r\n";
    }

    public void a(C0135a aVar) {
        this.f20266b = aVar;
    }

    public String b(String str, String str2, String str3) {
        String str4 = ("DESCRIBE " + str + " RTSP/1.0" + "\r\n") + "Accept: application/sdp\r\n";
        if (str3 != null) {
            str4 = str4 + "Authorization: " + str3 + "\r\n";
        }
        String str5 = str4 + "CSeq: " + this.f20268d.addAndGet(1) + "\r\n";
        if (str2 != null) {
            str5 = str5 + "User-Agent: " + str2 + "\r\n";
        }
        return str5 + "\r\n";
    }

    public String b(String str, String str2, String str3, String str4) {
        String str5 = "TEARDOWN " + str + " RTSP/1.0" + "\r\n";
        if (str3 != null) {
            str5 = str5 + "Authorization: " + str3 + "\r\n";
        }
        String str6 = str5 + "CSeq: " + this.f20268d.addAndGet(1) + "\r\n";
        if (str2 != null) {
            str6 = str6 + "User-Agent: " + str2 + "\r\n";
        }
        if (str4 != null) {
            str6 = str6 + "Session: " + str4 + "\r\n";
        }
        return str6 + "\r\n";
    }

    public String c(String str, String str2, String str3, String str4) {
        String str5 = ("PLAY " + str + " RTSP/1.0" + "\r\n") + "Range: npt=0.000-\r\n";
        if (str3 != null) {
            str5 = str5 + "Authorization: " + str3 + "\r\n";
        }
        String str6 = str5 + "CSeq: " + this.f20268d.addAndGet(1) + "\r\n";
        if (str2 != null) {
            str6 = str6 + "User-Agent: " + str2 + "\r\n";
        }
        return (str6 + "Session: " + str4 + "\r\n") + "\r\n";
    }
}
