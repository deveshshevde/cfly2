package org.apache.commons.net;

import java.io.PrintWriter;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final PrintWriter f32758a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32759b;

    /* renamed from: c  reason: collision with root package name */
    private final char f32760c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32761d;

    public a(PrintWriter printWriter) {
        this(printWriter, false);
    }

    public a(PrintWriter printWriter, boolean z2) {
        this(printWriter, z2, 0);
    }

    public a(PrintWriter printWriter, boolean z2, char c2) {
        this(printWriter, z2, c2, false);
    }

    public a(PrintWriter printWriter, boolean z2, char c2, boolean z3) {
        this.f32758a = printWriter;
        this.f32759b = z2;
        this.f32760c = c2;
        this.f32761d = z3;
    }

    private String a(String str) {
        int indexOf;
        if (this.f32760c == 0 || (indexOf = str.indexOf("\r\n")) <= 0) {
            return str;
        }
        return str.substring(0, indexOf) + this.f32760c + str.substring(indexOf);
    }

    public void a(ProtocolCommandEvent protocolCommandEvent) {
        if (this.f32761d) {
            this.f32758a.print("> ");
        }
        if (this.f32759b) {
            String a2 = protocolCommandEvent.a();
            if ("PASS".equalsIgnoreCase(a2) || "USER".equalsIgnoreCase(a2)) {
                this.f32758a.print(a2);
            } else if ("LOGIN".equalsIgnoreCase(a2)) {
                String b2 = protocolCommandEvent.b();
                this.f32758a.print(b2.substring(0, b2.indexOf("LOGIN") + 5));
            }
            this.f32758a.println(" *******");
            this.f32758a.flush();
        }
        this.f32758a.print(a(protocolCommandEvent.b()));
        this.f32758a.flush();
    }

    public void b(ProtocolCommandEvent protocolCommandEvent) {
        if (this.f32761d) {
            this.f32758a.print("< ");
        }
        this.f32758a.print(protocolCommandEvent.b());
        this.f32758a.flush();
    }
}
