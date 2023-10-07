package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class o implements p {

    /* renamed from: a  reason: collision with root package name */
    private final int f17078a;

    public o() {
        this(-1);
    }

    public o(int i2) {
        this.f17078a = i2;
    }

    public int a(int i2) {
        int i3 = this.f17078a;
        return i3 == -1 ? i2 == 7 ? 6 : 3 : i3;
    }

    public long a(int i2, long j2, IOException iOException, int i3) {
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return -9223372036854775807L;
        }
        int i4 = ((HttpDataSource.InvalidResponseCodeException) iOException).f16937c;
        return (i4 == 404 || i4 == 410 || i4 == 416) ? 60000 : -9223372036854775807L;
    }

    public long b(int i2, long j2, IOException iOException, int i3) {
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof Loader.UnexpectedLoaderException)) {
            return -9223372036854775807L;
        }
        return (long) Math.min((i3 - 1) * 1000, 5000);
    }
}
