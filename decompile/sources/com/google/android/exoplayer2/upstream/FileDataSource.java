package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource extends d {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f16929a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f16930b;

    /* renamed from: c  reason: collision with root package name */
    private long f16931c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16932d;

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }

        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException);
        }
    }

    public FileDataSource() {
        super(false);
    }

    private static RandomAccessFile a(Uri uri) throws FileDataSourceException {
        try {
            return new RandomAccessFile((String) a.b(uri.getPath()), "r");
        } catch (FileNotFoundException e2) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e2);
            }
            throw new FileDataSourceException(e2);
        }
    }

    public int a(byte[] bArr, int i2, int i3) throws FileDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        if (this.f16931c == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) ad.a(this.f16929a)).read(bArr, i2, (int) Math.min(this.f16931c, (long) i3));
            if (read > 0) {
                this.f16931c -= (long) read;
                a(read);
            }
            return read;
        } catch (IOException e2) {
            throw new FileDataSourceException(e2);
        }
    }

    public long a(h hVar) throws FileDataSourceException {
        try {
            Uri uri = hVar.f16995a;
            this.f16930b = uri;
            b(hVar);
            RandomAccessFile a2 = a(uri);
            this.f16929a = a2;
            a2.seek(hVar.f17000f);
            long length = hVar.f17001g == -1 ? this.f16929a.length() - hVar.f17000f : hVar.f17001g;
            this.f16931c = length;
            if (length >= 0) {
                this.f16932d = true;
                c(hVar);
                return this.f16931c;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new FileDataSourceException(e2);
        }
    }

    public Uri a() {
        return this.f16930b;
    }

    public void c() throws FileDataSourceException {
        this.f16930b = null;
        try {
            RandomAccessFile randomAccessFile = this.f16929a;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.f16929a = null;
            if (this.f16932d) {
                this.f16932d = false;
                d();
            }
        } catch (IOException e2) {
            throw new FileDataSourceException(e2);
        } catch (Throwable th) {
            this.f16929a = null;
            if (this.f16932d) {
                this.f16932d = false;
                d();
            }
            throw th;
        }
    }
}
