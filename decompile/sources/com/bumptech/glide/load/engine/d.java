package com.bumptech.glide.load.engine;

import bm.a;
import com.bumptech.glide.load.f;
import java.io.File;

class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.a<DataType> f10275a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f10276b;

    /* renamed from: c  reason: collision with root package name */
    private final f f10277c;

    d(com.bumptech.glide.load.a<DataType> aVar, DataType datatype, f fVar) {
        this.f10275a = aVar;
        this.f10276b = datatype;
        this.f10277c = fVar;
    }

    public boolean a(File file) {
        return this.f10275a.a(this.f10276b, file, this.f10277c);
    }
}
