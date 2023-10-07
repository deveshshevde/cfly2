package com.xeagle.android.login.retrofitLogin;

import java.io.IOException;
import okhttp3.aa;
import okhttp3.v;
import okio.c;
import okio.d;
import okio.f;
import okio.k;
import okio.q;

public class FileRequestBody<T> extends aa {
    private d bufferedSink;
    /* access modifiers changed from: private */
    public UploadCallBack<T> callBack;
    private aa requestBody;

    public FileRequestBody(aa aaVar, UploadCallBack<T> uploadCallBack) {
        this.requestBody = aaVar;
        this.callBack = uploadCallBack;
    }

    private q sink(d dVar) {
        return new f(dVar) {
            long bytesWritten = 0;
            long contentLength = 0;

            public void write(c cVar, long j2) throws IOException {
                super.write(cVar, j2);
                if (this.contentLength == 0) {
                    this.contentLength = FileRequestBody.this.contentLength();
                }
                this.bytesWritten += j2;
                FileRequestBody.this.callBack.onLoading(this.contentLength, this.bytesWritten);
            }
        };
    }

    public long contentLength() throws IOException {
        return this.requestBody.contentLength();
    }

    public v contentType() {
        return this.requestBody.contentType();
    }

    public void writeTo(d dVar) throws IOException {
        if (this.bufferedSink == null) {
            this.bufferedSink = k.a(sink(dVar));
        }
        this.requestBody.writeTo(this.bufferedSink);
        this.bufferedSink.flush();
    }
}
