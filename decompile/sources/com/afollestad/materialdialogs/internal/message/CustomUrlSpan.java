package com.afollestad.materialdialogs.internal.message;

import android.text.style.URLSpan;
import android.view.View;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class CustomUrlSpan extends URLSpan {

    /* renamed from: a  reason: collision with root package name */
    private final b<String, l> f7617a;

    public void onClick(View view) {
        h.c(view, "widget");
        b<String, l> bVar = this.f7617a;
        String url = getURL();
        h.a((Object) url, IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        bVar.invoke(url);
    }
}
