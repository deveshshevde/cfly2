package com.amap.api.maps;

public interface ExceptionLogger {
    void onDownloaderException(int i2, int i3);

    void onException(Throwable th);
}
