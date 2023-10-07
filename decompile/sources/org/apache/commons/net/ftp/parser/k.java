package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.d;

public class k extends b {
    public k() {
        this((d) null);
    }

    public k(d dVar) {
        super("\\s*([0-9]+)\\s*(\\s+|[A-Z]+)\\s*(DIR|\\s+)\\s*(\\S+)\\s+(\\S+)\\s+(\\S.*)");
        a(dVar);
    }

    public FTPFile a(String str) {
        FTPFile fTPFile = new FTPFile();
        if (!c(str)) {
            return null;
        }
        int i2 = 1;
        String b2 = b(1);
        String b3 = b(2);
        String b4 = b(3);
        String str2 = b(4) + " " + b(5);
        String b5 = b(6);
        try {
            fTPFile.a(super.b(str2));
        } catch (ParseException unused) {
        }
        if (!b4.trim().equals("DIR") && !b3.trim().equals("DIR")) {
            i2 = 0;
        }
        fTPFile.b(i2);
        fTPFile.c(b5.trim());
        fTPFile.a(Long.parseLong(b2.trim()));
        return fTPFile;
    }

    /* access modifiers changed from: protected */
    public d a() {
        return new d("OS/2", "MM-dd-yy HH:mm", (String) null);
    }
}
