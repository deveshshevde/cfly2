package com.danikula.videocache;

public class ProxyCacheException extends Exception {
    public ProxyCacheException(String str) {
        super(str + ". Version: 1.0.1");
    }

    public ProxyCacheException(String str, Throwable th) {
        super(str + ". Version: 1.0.1", th);
    }
}
