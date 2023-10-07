package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource extends d {

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f16917a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f16918b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f16919c;

    /* renamed from: d  reason: collision with root package name */
    private long f16920d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16921e;

    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f16917a = context.getAssets();
    }

    public int a(byte[] bArr, int i2, int i3) throws AssetDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f16920d;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new AssetDataSourceException(e2);
            }
        }
        int read = ((InputStream) ad.a(this.f16919c)).read(bArr, i2, i3);
        if (read != -1) {
            long j3 = this.f16920d;
            if (j3 != -1) {
                this.f16920d = j3 - ((long) read);
            }
            a(read);
            return read;
        } else if (this.f16920d == -1) {
            return -1;
        } else {
            throw new AssetDataSourceException(new EOFException());
        }
    }

    public long a(h hVar) throws AssetDataSourceException {
        try {
            Uri uri = hVar.f16995a;
            this.f16918b = uri;
            String str = (String) a.b(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            b(hVar);
            InputStream open = this.f16917a.open(str, 1);
            this.f16919c = open;
            if (open.skip(hVar.f17000f) >= hVar.f17000f) {
                if (hVar.f17001g != -1) {
                    this.f16920d = hVar.f17001g;
                } else {
                    long available = (long) this.f16919c.available();
                    this.f16920d = available;
                    if (available == 2147483647L) {
                        this.f16920d = -1;
                    }
                }
                this.f16921e = true;
                c(hVar);
                return this.f16920d;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2);
        }
    }

    public Uri a() {
        return this.f16918b;
    }

    public void c() throws AssetDataSourceException {
        this.f16918b = null;
        try {
            InputStream inputStream = this.f16919c;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f16919c = null;
            if (this.f16921e) {
                this.f16921e = false;
                d();
            }
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2);
        } catch (Throwable th) {
            this.f16919c = null;
            if (this.f16921e) {
                this.f16921e = false;
                d();
            }
            throw th;
        }
    }
}
