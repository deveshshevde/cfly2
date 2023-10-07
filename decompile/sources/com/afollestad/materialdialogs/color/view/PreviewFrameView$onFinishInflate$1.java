package com.afollestad.materialdialogs.color.view;

import aw.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

final class PreviewFrameView$onFinishInflate$1 extends Lambda implements b<String, l> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PreviewFrameView f7549a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewFrameView$onFinishInflate$1(PreviewFrameView previewFrameView) {
        super(1);
        this.f7549a = previewFrameView;
    }

    public final void a(String str) {
        Integer a2;
        h.c(str, "it");
        if (str.length() >= 4 && (a2 = a.a(str)) != null) {
            int intValue = a2.intValue();
            if (this.f7549a.getOnHexChanged().invoke(Integer.valueOf(intValue)).booleanValue()) {
                this.f7549a.setColor(intValue);
            }
        }
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return l.f30254a;
    }
}
