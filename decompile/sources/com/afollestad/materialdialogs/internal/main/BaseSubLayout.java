package com.afollestad.materialdialogs.internal.main;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import ay.e;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.b;
import kotlin.jvm.internal.h;
import mm.a;

public abstract class BaseSubLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f7589a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7590b = e.f5573a.a(this, R.dimen.md_divider_height);

    /* renamed from: c  reason: collision with root package name */
    private boolean f7591c;

    /* renamed from: d  reason: collision with root package name */
    public b f7592d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseSubLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
        Paint paint = new Paint();
        this.f7589a = paint;
        setWillNotDraw(false);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(context.getResources().getDimension(R.dimen.md_divider_height));
        paint.setAntiAlias(true);
    }

    private final int getDividerColor() {
        e eVar = e.f5573a;
        b bVar = this.f7592d;
        if (bVar == null) {
            h.b("dialog");
        }
        Context context = bVar.getContext();
        h.a((Object) context, "dialog.context");
        return e.a(eVar, context, (Integer) null, Integer.valueOf(R.attr.md_divider_color), (a) null, 10, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Paint a() {
        this.f7589a.setColor(getDividerColor());
        return this.f7589a;
    }

    public final b getDialog() {
        b bVar = this.f7592d;
        if (bVar == null) {
            h.b("dialog");
        }
        return bVar;
    }

    /* access modifiers changed from: protected */
    public final int getDividerHeight() {
        return this.f7590b;
    }

    public final boolean getDrawDivider() {
        return this.f7591c;
    }

    public final void setDialog(b bVar) {
        h.c(bVar, "<set-?>");
        this.f7592d = bVar;
    }

    public final void setDrawDivider(boolean z2) {
        this.f7591c = z2;
        invalidate();
    }
}
