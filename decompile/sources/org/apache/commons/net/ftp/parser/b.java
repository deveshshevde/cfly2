package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import java.util.Calendar;
import org.apache.commons.net.ftp.a;
import org.apache.commons.net.ftp.d;

public abstract class b extends m implements a {

    /* renamed from: b  reason: collision with root package name */
    private final e f32876b = new f();

    public b(String str) {
        super(str);
    }

    public b(String str, int i2) {
        super(str, i2);
    }

    /* access modifiers changed from: protected */
    public abstract d a();

    public void a(d dVar) {
        if (this.f32876b instanceof a) {
            d a2 = a();
            if (dVar != null) {
                if (dVar.b() == null) {
                    dVar.a(a2.b());
                }
                if (dVar.c() == null) {
                    dVar.b(a2.c());
                }
                ((a) this.f32876b).a(dVar);
                return;
            }
            ((a) this.f32876b).a(a2);
        }
    }

    public Calendar b(String str) throws ParseException {
        return this.f32876b.a(str);
    }
}
