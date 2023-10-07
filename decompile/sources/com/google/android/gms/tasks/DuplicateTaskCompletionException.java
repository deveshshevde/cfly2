package com.google.android.gms.tasks;

public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(b<?> bVar) {
        String str;
        if (!bVar.d()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception a2 = bVar.a();
        if (a2 != null) {
            str = "failure";
        } else if (bVar.e()) {
            String valueOf = String.valueOf(bVar.b());
            String.valueOf(valueOf).length();
            str = "result ".concat(String.valueOf(valueOf));
        } else {
            str = bVar.c() ? "cancellation" : "unknown issue";
        }
        return new DuplicateTaskCompletionException(str.length() != 0 ? "Complete with: ".concat(str) : new String("Complete with: "), a2);
    }
}
