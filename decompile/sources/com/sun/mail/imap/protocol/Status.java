package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;

public class Status {
    static final String[] standardItems = {"MESSAGES", "RECENT", "UNSEEN", "UIDNEXT", "UIDVALIDITY"};
    public String mbox = null;
    public int recent = -1;
    public int total = -1;
    public long uidnext = -1;
    public long uidvalidity = -1;
    public int unseen = -1;

    public Status(Response response) throws ParsingException {
        this.mbox = response.readAtomString();
        response.skipSpaces();
        if (response.readByte() == 40) {
            do {
                String readAtom = response.readAtom();
                if (readAtom.equalsIgnoreCase("MESSAGES")) {
                    this.total = response.readNumber();
                } else if (readAtom.equalsIgnoreCase("RECENT")) {
                    this.recent = response.readNumber();
                } else if (readAtom.equalsIgnoreCase("UIDNEXT")) {
                    this.uidnext = response.readLong();
                } else if (readAtom.equalsIgnoreCase("UIDVALIDITY")) {
                    this.uidvalidity = response.readLong();
                } else if (readAtom.equalsIgnoreCase("UNSEEN")) {
                    this.unseen = response.readNumber();
                }
            } while (response.readByte() != 41);
            return;
        }
        throw new ParsingException("parse error in STATUS");
    }

    public static void add(Status status, Status status2) {
        int i2 = status2.total;
        if (i2 != -1) {
            status.total = i2;
        }
        int i3 = status2.recent;
        if (i3 != -1) {
            status.recent = i3;
        }
        long j2 = status2.uidnext;
        if (j2 != -1) {
            status.uidnext = j2;
        }
        long j3 = status2.uidvalidity;
        if (j3 != -1) {
            status.uidvalidity = j3;
        }
        int i4 = status2.unseen;
        if (i4 != -1) {
            status.unseen = i4;
        }
    }
}
