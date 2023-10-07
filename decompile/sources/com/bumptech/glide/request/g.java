package com.bumptech.glide.request;

import bz.j;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;

public interface g<R> {
    boolean onLoadFailed(GlideException glideException, Object obj, j<R> jVar, boolean z2);

    boolean onResourceReady(R r2, Object obj, j<R> jVar, DataSource dataSource, boolean z2);
}
