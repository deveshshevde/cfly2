package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.d;

public class j extends b {
    public j() {
        this((d) null);
    }

    public j(d dVar) {
        super("(d|-){1}\\s+\\[([-A-Z]+)\\]\\s+(\\S+)\\s+(\\d+)\\s+(\\S+\\s+\\S+\\s+((\\d+:\\d+)|(\\d{4})))\\s+(.*)");
        a(dVar);
    }

    public FTPFile a(String str) {
        FTPFile fTPFile = new FTPFile();
        if (!c(str)) {
            return null;
        }
        String b2 = b(1);
        String b3 = b(2);
        String b4 = b(3);
        String b5 = b(4);
        String b6 = b(5);
        String b7 = b(9);
        try {
            fTPFile.a(super.b(b6));
        } catch (ParseException unused) {
        }
        if (b2.trim().equals("d")) {
            fTPFile.b(1);
        } else {
            fTPFile.b(0);
        }
        fTPFile.e(b4);
        fTPFile.c(b7.trim());
        fTPFile.a(Long.parseLong(b5.trim()));
        if (b3.indexOf(82) != -1) {
            fTPFile.a(0, 0, true);
        }
        if (b3.indexOf(87) != -1) {
            fTPFile.a(0, 1, true);
        }
        return fTPFile;
    }

    /* access modifiers changed from: protected */
    public d a() {
        return new d("NETWARE", "MMM dd yyyy", "MMM dd HH:mm");
    }
}
