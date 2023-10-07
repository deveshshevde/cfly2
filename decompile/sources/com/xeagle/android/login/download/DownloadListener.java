package com.xeagle.android.login.download;

public interface DownloadListener {
    void onFail(String str);

    void onFinishDownload();

    void onProgress(long j2);

    void onStartDownload(long j2);
}
