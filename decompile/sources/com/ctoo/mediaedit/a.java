package com.ctoo.mediaedit;

import com.ctoo.mediaedit.entity.MediaEditEntity;
import com.ctoo.mediaedit.filter.gpu.GPUImageFilterType;
import kotlin.jvm.internal.h;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f10788a = new a();

    private a() {
    }

    public final MediaEditEntity a(MyPhoto myPhoto) {
        h.d(myPhoto, "photo");
        return new MediaEditEntity(myPhoto, 0, 10000.0f, myPhoto.f(), false, false, 50.0f, "", GPUImageFilterType.NONE.name(), GPUImageFilterType.NONE.name(), "", 50, 50, 50, 50, 50, 50, 50, false);
    }
}
