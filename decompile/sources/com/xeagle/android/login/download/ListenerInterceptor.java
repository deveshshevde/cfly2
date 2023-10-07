package com.xeagle.android.login.download;

import java.io.IOException;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.u;

public class ListenerInterceptor implements u {
    private DownloadListener listener;

    public ListenerInterceptor(DownloadListener downloadListener) {
        this.listener = downloadListener;
    }

    public ab intercept(u.a aVar) throws IOException {
        ab a2 = aVar.a(aVar.a());
        return a2.h().a((ac) new DownloadPbResponseBody(a2.g(), this.listener)).a();
    }
}
