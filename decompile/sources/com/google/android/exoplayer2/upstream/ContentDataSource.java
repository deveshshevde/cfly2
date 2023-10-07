package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.exoplayer2.util.ad;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class ContentDataSource extends d {

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f16922a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f16923b;

    /* renamed from: c  reason: collision with root package name */
    private AssetFileDescriptor f16924c;

    /* renamed from: d  reason: collision with root package name */
    private FileInputStream f16925d;

    /* renamed from: e  reason: collision with root package name */
    private long f16926e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16927f;

    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f16922a = context.getContentResolver();
    }

    public int a(byte[] bArr, int i2, int i3) throws ContentDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f16926e;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            }
        }
        int read = ((FileInputStream) ad.a(this.f16925d)).read(bArr, i2, i3);
        if (read != -1) {
            long j3 = this.f16926e;
            if (j3 != -1) {
                this.f16926e = j3 - ((long) read);
            }
            a(read);
            return read;
        } else if (this.f16926e == -1) {
            return -1;
        } else {
            throw new ContentDataSourceException(new EOFException());
        }
    }

    public long a(h hVar) throws ContentDataSourceException {
        try {
            Uri uri = hVar.f16995a;
            this.f16923b = uri;
            b(hVar);
            AssetFileDescriptor openAssetFileDescriptor = this.f16922a.openAssetFileDescriptor(uri, "r");
            this.f16924c = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.f16925d = fileInputStream;
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(hVar.f17000f + startOffset) - startOffset;
                if (skip == hVar.f17000f) {
                    long j2 = -1;
                    if (hVar.f17001g != -1) {
                        this.f16926e = hVar.f17001g;
                    } else {
                        long length = openAssetFileDescriptor.getLength();
                        if (length == -1) {
                            FileChannel channel = fileInputStream.getChannel();
                            long size = channel.size();
                            if (size != 0) {
                                j2 = size - channel.position();
                            }
                            this.f16926e = j2;
                        } else {
                            this.f16926e = length - skip;
                        }
                    }
                    this.f16927f = true;
                    c(hVar);
                    return this.f16926e;
                }
                throw new EOFException();
            }
            String valueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
            sb.append("Could not open file descriptor for: ");
            sb.append(valueOf);
            throw new FileNotFoundException(sb.toString());
        } catch (IOException e2) {
            throw new ContentDataSourceException(e2);
        }
    }

    public Uri a() {
        return this.f16923b;
    }

    public void c() throws ContentDataSourceException {
        this.f16923b = null;
        try {
            FileInputStream fileInputStream = this.f16925d;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.f16925d = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f16924c;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f16924c = null;
                if (this.f16927f) {
                    this.f16927f = false;
                    d();
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            } catch (Throwable th) {
                this.f16924c = null;
                if (this.f16927f) {
                    this.f16927f = false;
                    d();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new ContentDataSourceException(e3);
        } catch (Throwable th2) {
            this.f16925d = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f16924c;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f16924c = null;
                if (this.f16927f) {
                    this.f16927f = false;
                    d();
                }
                throw th2;
            } catch (IOException e4) {
                throw new ContentDataSourceException(e4);
            } catch (Throwable th3) {
                this.f16924c = null;
                if (this.f16927f) {
                    this.f16927f = false;
                    d();
                }
                throw th3;
            }
        }
    }
}
