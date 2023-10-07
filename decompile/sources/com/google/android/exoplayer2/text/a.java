package com.google.android.exoplayer2.text;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.ad;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16577a = new a(-1, -16777216, 0, 0, -1, (Typeface) null);

    /* renamed from: b  reason: collision with root package name */
    public final int f16578b;

    /* renamed from: c  reason: collision with root package name */
    public final int f16579c;

    /* renamed from: d  reason: collision with root package name */
    public final int f16580d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16581e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16582f;

    /* renamed from: g  reason: collision with root package name */
    public final Typeface f16583g;

    public a(int i2, int i3, int i4, int i5, int i6, Typeface typeface) {
        this.f16578b = i2;
        this.f16579c = i3;
        this.f16580d = i4;
        this.f16581e = i5;
        this.f16582f = i6;
        this.f16583g = typeface;
    }

    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        return ad.f11755a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    private static a b(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static a c(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f16577a.f16578b, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f16577a.f16579c, captionStyle.hasWindowColor() ? captionStyle.windowColor : f16577a.f16580d, captionStyle.hasEdgeType() ? captionStyle.edgeType : f16577a.f16581e, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f16577a.f16582f, captionStyle.getTypeface());
    }
}
