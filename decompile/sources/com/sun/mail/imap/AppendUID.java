package com.sun.mail.imap;

public class AppendUID {
    public long uid = -1;
    public long uidvalidity = -1;

    public AppendUID(long j2, long j3) {
        this.uidvalidity = j2;
        this.uid = j3;
    }
}
