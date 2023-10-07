package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.g;

@Deprecated
public class PlaybackControlView extends PlayerControlView {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final a f16802a = new b();

    @Deprecated
    public interface a extends f {
    }

    @Deprecated
    private static final class b extends g implements a {
        private b() {
        }
    }

    public PlaybackControlView(Context context) {
        super(context);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
