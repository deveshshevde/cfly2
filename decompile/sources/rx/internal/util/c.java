package rx.internal.util;

import java.io.PrintStream;
import or.d;

public final class c {
    public static void a(Throwable th) {
        try {
            d.a().b().a(th);
        } catch (Throwable th2) {
            b(th2);
        }
    }

    private static void b(Throwable th) {
        PrintStream printStream = System.err;
        printStream.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + th.getMessage());
        th.printStackTrace();
    }
}
