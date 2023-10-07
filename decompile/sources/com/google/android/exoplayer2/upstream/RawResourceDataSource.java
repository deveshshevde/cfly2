package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class RawResourceDataSource extends d {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f16963a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f16964b;

    /* renamed from: c  reason: collision with root package name */
    private AssetFileDescriptor f16965c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f16966d;

    /* renamed from: e  reason: collision with root package name */
    private long f16967e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16968f;

    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(IOException iOException) {
            super(iOException);
        }

        public RawResourceDataSourceException(String str) {
            super(str);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f16963a = context.getResources();
    }

    public static Uri buildRawResourceUri(int i2) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("rawresource:///");
        sb.append(i2);
        return Uri.parse(sb.toString());
    }

    public int a(byte[] bArr, int i2, int i3) throws RawResourceDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f16967e;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(e2);
            }
        }
        int read = ((InputStream) ad.a(this.f16966d)).read(bArr, i2, i3);
        if (read != -1) {
            long j3 = this.f16967e;
            if (j3 != -1) {
                this.f16967e = j3 - ((long) read);
            }
            a(read);
            return read;
        } else if (this.f16967e == -1) {
            return -1;
        } else {
            throw new RawResourceDataSourceException((IOException) new EOFException());
        }
    }

    public long a(h hVar) throws RawResourceDataSourceException {
        try {
            Uri uri = hVar.f16995a;
            this.f16964b = uri;
            if (TextUtils.equals("rawresource", uri.getScheme())) {
                int parseInt = Integer.parseInt((String) a.b(uri.getLastPathSegment()));
                b(hVar);
                AssetFileDescriptor openRawResourceFd = this.f16963a.openRawResourceFd(parseInt);
                this.f16965c = openRawResourceFd;
                if (openRawResourceFd != null) {
                    FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
                    this.f16966d = fileInputStream;
                    fileInputStream.skip(openRawResourceFd.getStartOffset());
                    if (fileInputStream.skip(hVar.f17000f) >= hVar.f17000f) {
                        long j2 = -1;
                        if (hVar.f17001g != -1) {
                            this.f16967e = hVar.f17001g;
                        } else {
                            long length = openRawResourceFd.getLength();
                            if (length != -1) {
                                j2 = length - hVar.f17000f;
                            }
                            this.f16967e = j2;
                        }
                        this.f16968f = true;
                        c(hVar);
                        return this.f16967e;
                    }
                    throw new EOFException();
                }
                String valueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
                sb.append("Resource is compressed: ");
                sb.append(valueOf);
                throw new RawResourceDataSourceException(sb.toString());
            }
            throw new RawResourceDataSourceException("URI must use scheme rawresource");
        } catch (NumberFormatException unused) {
            throw new RawResourceDataSourceException("Resource identifier must be an integer.");
        } catch (IOException e2) {
            throw new RawResourceDataSourceException(e2);
        }
    }

    public Uri a() {
        return this.f16964b;
    }

    public void c() throws RawResourceDataSourceException {
        this.f16964b = null;
        try {
            InputStream inputStream = this.f16966d;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f16966d = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f16965c;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f16965c = null;
                if (this.f16968f) {
                    this.f16968f = false;
                    d();
                }
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(e2);
            } catch (Throwable th) {
                this.f16965c = null;
                if (this.f16968f) {
                    this.f16968f = false;
                    d();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new RawResourceDataSourceException(e3);
        } catch (Throwable th2) {
            this.f16966d = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f16965c;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f16965c = null;
                if (this.f16968f) {
                    this.f16968f = false;
                    d();
                }
                throw th2;
            } catch (IOException e4) {
                throw new RawResourceDataSourceException(e4);
            } catch (Throwable th3) {
                this.f16965c = null;
                if (this.f16968f) {
                    this.f16968f = false;
                    d();
                }
                throw th3;
            }
        }
    }
}
