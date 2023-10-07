package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.j;
import java.io.IOException;

public interface HlsPlaylistTracker {

    public static final class PlaylistResetException extends IOException {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f16262a;

        public PlaylistResetException(Uri uri) {
            this.f16262a = uri;
        }
    }

    public static final class PlaylistStuckException extends IOException {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f16263a;

        public PlaylistStuckException(Uri uri) {
            this.f16263a = uri;
        }
    }

    public interface a {
    }

    public interface b {
        boolean a(Uri uri, long j2);

        void i();
    }

    public interface c {
        void a(d dVar);
    }

    d a(Uri uri, boolean z2);

    void a();

    void a(Uri uri, j.a aVar, c cVar);

    void a(b bVar);

    boolean a(Uri uri);

    c b();

    void b(Uri uri) throws IOException;

    void b(b bVar);

    long c();

    void c(Uri uri);

    void d() throws IOException;

    boolean e();
}
