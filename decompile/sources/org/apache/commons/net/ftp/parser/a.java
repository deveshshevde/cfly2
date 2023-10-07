package org.apache.commons.net.ftp.parser;

import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.e;
import org.apache.commons.net.ftp.f;

public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final e[] f32874a;

    /* renamed from: b  reason: collision with root package name */
    private e f32875b = null;

    public a(e[] eVarArr) {
        this.f32874a = eVarArr;
    }

    public FTPFile a(String str) {
        e eVar = this.f32875b;
        if (eVar != null) {
            FTPFile a2 = eVar.a(str);
            if (a2 != null) {
                return a2;
            }
            return null;
        }
        for (e eVar2 : this.f32874a) {
            FTPFile a3 = eVar2.a(str);
            if (a3 != null) {
                this.f32875b = eVar2;
                return a3;
            }
        }
        return null;
    }
}
