package org.jcodec.common.logging;

import java.io.PrintStream;
import java.util.Map;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.tools.MainUtils;

public class a implements Logger.a {

    /* renamed from: a  reason: collision with root package name */
    public static b f33172a = new b(MainUtils.a("[#level]", "#color_code") + MainUtils.a("\t#class.#method (#file:#line):") + "\t#message");

    /* renamed from: b  reason: collision with root package name */
    private PrintStream f33173b;

    /* renamed from: c  reason: collision with root package name */
    private C0241a f33174c;

    /* renamed from: org.jcodec.common.logging.a$a  reason: collision with other inner class name */
    public interface C0241a {
        String a(Logger.b bVar);
    }

    public static class b implements C0241a {

        /* renamed from: b  reason: collision with root package name */
        private static Map<Logger.Level, MainUtils.ANSIColor> f33175b = new OutLogSink$SimpleFormat$1();

        /* renamed from: a  reason: collision with root package name */
        private String f33176a;

        public b(String str) {
            this.f33176a = str;
        }

        public String a(Logger.b bVar) {
            return this.f33176a.replace("#level", String.valueOf(bVar.a())).replace("#color_code", String.valueOf(f33175b.get(bVar.a()).ordinal() + 30)).replace("#class", bVar.c()).replace("#method", bVar.d()).replace("#file", bVar.b()).replace("#line", String.valueOf(bVar.e())).replace("#message", bVar.f());
        }
    }

    public a() {
        this(System.out, f33172a);
    }

    public a(PrintStream printStream, C0241a aVar) {
        this.f33173b = printStream;
        this.f33174c = aVar;
    }

    public void a(Logger.b bVar) {
        this.f33173b.println(this.f33174c.a(bVar));
    }
}
