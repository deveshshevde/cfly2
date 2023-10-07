package com.xeagle.android.login.download;

import java.io.IOException;
import okhttp3.ac;
import okhttp3.v;
import okio.c;
import okio.e;
import okio.g;
import okio.k;
import okio.r;

public class DownloadPbResponseBody extends ac {
    private e bufferedSource;
    /* access modifiers changed from: private */
    public DownloadListener listener;
    private ac responseBody;

    public DownloadPbResponseBody(ac acVar, DownloadListener downloadListener) {
        this.responseBody = acVar;
        this.listener = downloadListener;
        downloadListener.onStartDownload(acVar.contentLength());
    }

    private r source1(r rVar) {
        return new g(rVar) {
            long lastProgress = 0;
            long totalBytesRead = 0;

            public long read(c cVar, long j2) throws IOException {
                long read = super.read(cVar, j2);
                this.totalBytesRead += read != -1 ? read : 0;
                if (!(DownloadPbResponseBody.this.listener == null || read == -1)) {
                    long j3 = this.totalBytesRead;
                    if (j3 != this.lastProgress) {
                        DownloadPbResponseBody.this.listener.onProgress(j3);
                        this.lastProgress = j3;
                    }
                }
                return read;
            }
        };
    }

    public long contentLength() {
        return this.responseBody.contentLength();
    }

    public v contentType() {
        return this.responseBody.contentType();
    }

    public e source() {
        if (this.bufferedSource == null) {
            this.bufferedSource = k.a(source1(this.responseBody.source()));
        }
        return this.bufferedSource;
    }
}
