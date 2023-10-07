package com.ctoo.mediaedit.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.cloudbufferfly.uicorelib.utils.b;
import com.ctoo.mediaedit.R;
import com.ctoo.mediaedit.entity.MediaEditEntity;
import java.util.ArrayList;
import kotlin.jvm.internal.h;

public final class MutliVideoSeekBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f10983a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f10984b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f10985c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f10986d;

    /* renamed from: e  reason: collision with root package name */
    private float f10987e;

    /* renamed from: f  reason: collision with root package name */
    private float f10988f = 150.0f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<MediaEditEntity> f10989g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private a f10990h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10991i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10992j;

    public interface a {
        void a(float f2);

        void a(boolean z2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutliVideoSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.d(context, "context");
        h.d(attributeSet, "attributeSet");
        Paint paint = new Paint();
        this.f10983a = paint;
        if (paint != null) {
            paint.setColor(com.cloudbufferfly.uicorelib.utils.a.f10756a.a(context, R.color.text_sticker_blue_easy_photos));
        }
        Paint paint2 = new Paint();
        this.f10984b = paint2;
        if (paint2 != null) {
            paint2.setColor(com.cloudbufferfly.uicorelib.utils.a.f10756a.a(context, R.color.color_999999));
        }
        Paint paint3 = new Paint();
        this.f10985c = paint3;
        if (paint3 != null) {
            paint3.setColor(com.cloudbufferfly.uicorelib.utils.a.f10756a.a(context, R.color.white));
        }
        Paint paint4 = new Paint();
        this.f10986d = paint4;
        if (paint4 != null) {
            paint4.setColor(com.cloudbufferfly.uicorelib.utils.a.f10756a.a(context, R.color.black));
        }
    }

    private final void a() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private final void b() {
        this.f10992j = true;
    }

    private final void c() {
        this.f10992j = false;
    }

    public final boolean getMIsDragging() {
        return this.f10992j;
    }

    public final boolean getMIsTouchDown() {
        return this.f10991i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        com.cloudbufferfly.uicorelib.utils.a aVar = com.cloudbufferfly.uicorelib.utils.a.f10756a;
        Context context = getContext();
        h.b(context, "context");
        setBackgroundColor(aVar.a(context, R.color.black));
        if (canvas != null) {
            RectF rectF = new RectF(0.0f, ((float) getHeight()) * 0.15f, (float) getWidth(), ((float) getHeight()) * 0.85f);
            Paint paint = this.f10984b;
            h.a((Object) paint);
            canvas.drawRect(rectF, paint);
        }
        if (canvas != null) {
            RectF rectF2 = new RectF(0.0f, ((float) getHeight()) * 0.15f, this.f10988f, ((float) getHeight()) * 0.85f);
            Paint paint2 = this.f10983a;
            h.a((Object) paint2);
            canvas.drawRect(rectF2, paint2);
        }
        float f2 = 0.0f;
        for (MediaEditEntity c2 : this.f10989g) {
            f2 += (float) c2.c();
            if (canvas != null) {
                float f3 = (float) 5;
                RectF rectF3 = new RectF(((((float) getWidth()) * f2) / this.f10987e) - f3, ((float) getHeight()) * 0.15f, ((((float) getWidth()) * f2) / this.f10987e) + f3, ((float) getHeight()) * 0.85f);
                Paint paint3 = this.f10986d;
                h.a((Object) paint3);
                canvas.drawRect(rectF3, paint3);
            }
        }
        RectF rectF4 = new RectF(this.f10988f - (((float) getHeight()) * 0.75f), 0.0f, this.f10988f + (((float) getHeight()) * 0.75f), (float) getHeight());
        if (canvas != null) {
            b bVar = b.f10757a;
            Context context2 = getContext();
            h.b(context2, "context");
            b bVar2 = b.f10757a;
            Context context3 = getContext();
            h.b(context3, "context");
            Paint paint4 = this.f10985c;
            h.a((Object) paint4);
            canvas.drawRoundRect(rectF4, (float) bVar.a(context2, 5.0f), (float) bVar2.a(context3, 5.0f), paint4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getMode(i2) != 0 ? View.MeasureSpec.getSize(i2) : 300;
        int i4 = 60;
        if (View.MeasureSpec.getMode(i3) != 0) {
            i4 = View.MeasureSpec.getSize(i3);
        }
        setMeasuredDimension(size, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f10991i) {
            return super.onTouchEvent(motionEvent);
        }
        if ((motionEvent != null ? motionEvent.getPointerCount() : 0) > 1) {
            return super.onTouchEvent(motionEvent);
        }
        if (!isEnabled()) {
            return false;
        }
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f10988f = motionEvent.getX();
            b();
            a();
            a aVar = this.f10990h;
            if (aVar != null) {
                aVar.a(true);
            }
            a aVar2 = this.f10990h;
            if (aVar2 != null) {
                aVar2.a((this.f10988f * this.f10987e) / ((float) getWidth()));
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float x2 = motionEvent.getX();
            this.f10988f = x2;
            a aVar3 = this.f10990h;
            if (aVar3 != null) {
                aVar3.a((x2 * this.f10987e) / ((float) getWidth()));
            }
        } else {
            if (valueOf != null && valueOf.intValue() == 1) {
                c();
                float x3 = motionEvent.getX();
                this.f10988f = x3;
                a aVar4 = this.f10990h;
                if (aVar4 != null) {
                    aVar4.a((x3 * this.f10987e) / ((float) getWidth()));
                }
                this.f10992j = false;
                a aVar5 = this.f10990h;
                if (aVar5 != null) {
                    aVar5.a(false);
                }
            }
            return true;
        }
        postInvalidate();
        return true;
    }

    public final void setData(ArrayList<MediaEditEntity> arrayList) {
        h.d(arrayList, "list");
        this.f10989g.clear();
        this.f10989g.addAll(arrayList);
        this.f10987e = 0.0f;
        for (MediaEditEntity c2 : this.f10989g) {
            this.f10987e += (float) c2.c();
        }
        postInvalidate();
    }

    public final void setMIsDragging(boolean z2) {
        this.f10992j = z2;
    }

    public final void setMIsTouchDown(boolean z2) {
        this.f10991i = z2;
    }

    public final void setOnRangeSeekBarListener(a aVar) {
        h.d(aVar, "listener");
        this.f10990h = aVar;
    }
}
