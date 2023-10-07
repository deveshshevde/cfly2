package com.xeagle.android.editor.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.xeagle.android.utils.c;
import java.util.Objects;
import l.f;

public class b extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f22951a = true;

    /* renamed from: b  reason: collision with root package name */
    private int f22952b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f22953c;

    /* renamed from: d  reason: collision with root package name */
    private int f22954d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f22955e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f22956f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f22957g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f22958h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f22959i;

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f22960j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f22961k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public GestureDetector f22962l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayoutManager f22963m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public a f22964n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public float f22965o;

    public interface a {
        void a();

        void a(int i2);

        void a(int i2, float f2, float f3);
    }

    public b(Context context, final RecyclerView recyclerView) {
        Paint paint = new Paint();
        this.f22955e = paint;
        paint.setAntiAlias(true);
        this.f22955e.setColor(f.b(context.getResources(), R.color.greyText, (Resources.Theme) null));
        this.f22955e.setStrokeWidth(2.0f);
        this.f22955e.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f22956f = paint2;
        paint2.setTextSize(45.0f);
        this.f22956f.setColor(-1);
        Paint paint3 = new Paint();
        this.f22957g = paint3;
        paint3.setColor(-16777216);
        this.f22957g.setStrokeWidth(10.0f);
        this.f22955e.setAntiAlias(true);
        this.f22955e.setStyle(Paint.Style.FILL);
        this.f22952b = 250;
        this.f22953c = 120;
        this.f22958h = 50;
        this.f22959i = c.a(context, (int) R.drawable.editor_multi_cut);
        this.f22961k = c.a(context, (int) R.drawable.editor_multi_transition);
        this.f22960j = c.a(context, (int) R.drawable.editor_multi_add);
        this.f22962l = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (motionEvent.getX() >= b.this.f22965o - ((float) b.this.f22958h) && motionEvent.getX() <= b.this.f22965o + ((float) b.this.f22958h)) {
                    int[] a2 = b.this.a(recyclerView, motionEvent.getY());
                    if (a2[0] == 1) {
                        Log.i("editor", "onSingleTapUp: ---数字按钮===" + a2[1]);
                        if (b.this.f22964n != null) {
                            b.this.f22964n.a(a2[1]);
                        }
                    } else if (a2[0] == 2) {
                        Log.i("editor", "onSingleTapUp: ---转场按钮===" + a2[1]);
                        if (b.this.f22964n != null) {
                            b.this.f22964n.a(a2[1], b.this.f22965o, (float) a2[2]);
                        }
                    } else if (a2[0] == 3) {
                        Log.i("editor", "onSingleTapUp: ---添加按钮===" + a2[1]);
                        if (b.this.f22964n != null) {
                            b.this.f22964n.a();
                        }
                    }
                }
                return super.onSingleTapUp(motionEvent);
            }
        });
        this.f22965o = (float) (recyclerView.getPaddingLeft() + (this.f22952b / 2));
        Log.i("editor", "getItemOffsets: ---centerX---====" + recyclerView.getPaddingLeft() + (this.f22952b / 2));
        recyclerView.a((RecyclerView.k) new RecyclerView.q() {
            public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
                return b.this.f22962l.onTouchEvent(motionEvent);
            }

            public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
                super.b(recyclerView, motionEvent);
            }
        });
    }

    private void a(int i2, RecyclerView recyclerView, Canvas canvas) {
        float f2;
        float f3;
        Bitmap bitmap;
        this.f22963m = (LinearLayoutManager) recyclerView.getLayoutManager();
        int i3 = 0;
        while (i3 < i2) {
            if (f22951a || this.f22963m != null) {
                if (i3 >= this.f22963m.o() && i3 <= this.f22963m.q()) {
                    RecyclerView.h layoutManager = recyclerView.getLayoutManager();
                    Objects.requireNonNull(layoutManager);
                    View c2 = layoutManager.c(i3);
                    int f4 = recyclerView.f(c2);
                    float top = (float) (c2.getTop() - this.f22953c);
                    float bottom = (float) c2.getBottom();
                    recyclerView.getWidth();
                    recyclerView.getPaddingRight();
                    float paddingLeft = ((float) recyclerView.getPaddingLeft()) + ((float) (this.f22952b / 2));
                    float f5 = ((bottom - top) / 2.0f) + top;
                    float f6 = f5 - ((float) this.f22958h);
                    if (f4 != 0) {
                        canvas.drawLine(paddingLeft, top + ((float) (this.f22961k.getHeight() / 2)), paddingLeft, f6, this.f22955e);
                    }
                    int i4 = i2 - 1;
                    if (f4 != i4) {
                        bitmap = this.f22961k;
                        f3 = paddingLeft - ((float) (bitmap.getWidth() / 2));
                        f2 = bottom - ((float) (this.f22961k.getHeight() / 2));
                    } else {
                        bitmap = this.f22960j;
                        f3 = paddingLeft - ((float) (bitmap.getWidth() / 2));
                        f2 = ((float) this.f22960j.getHeight()) + bottom;
                    }
                    canvas.drawBitmap(bitmap, f3, f2, this.f22955e);
                    if (f4 == this.f22954d) {
                        Bitmap bitmap2 = this.f22959i;
                        int i5 = this.f22958h;
                        canvas.drawBitmap(bitmap2, paddingLeft - ((float) i5), f5 - ((float) i5), this.f22955e);
                    } else {
                        canvas.drawCircle(paddingLeft, f5, (float) this.f22958h, this.f22957g);
                        canvas.drawText((f4 + 1) + "", paddingLeft - 10.0f, 10.0f + f5, this.f22956f);
                    }
                    canvas.drawLine(paddingLeft, f5 + ((float) this.f22958h), paddingLeft, f4 != i4 ? bottom - ((float) (this.f22961k.getHeight() / 2)) : bottom + ((float) this.f22960j.getHeight()), this.f22955e);
                }
                i3++;
            } else {
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: private */
    public int[] a(RecyclerView recyclerView, float f2) {
        int i2 = 0;
        while (true) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Objects.requireNonNull(adapter);
            if (i2 >= adapter.getItemCount()) {
                return new int[]{0, 0};
            }
            if (i2 >= this.f22963m.o() && i2 <= this.f22963m.q()) {
                RecyclerView.h layoutManager = recyclerView.getLayoutManager();
                Objects.requireNonNull(layoutManager);
                View c2 = layoutManager.c(i2);
                int f3 = recyclerView.f(c2);
                float top = (float) (c2.getTop() - this.f22953c);
                float bottom = (float) c2.getBottom();
                float f4 = top + ((bottom - top) / 2.0f);
                int i3 = this.f22958h;
                if (f2 >= f4 - ((float) i3) && f2 <= f4 + ((float) i3)) {
                    return new int[]{1, f3};
                } else if (f2 >= bottom - ((float) (this.f22961k.getHeight() / 2)) && f2 <= ((float) (this.f22961k.getHeight() / 2)) + bottom) {
                    return new int[]{2, f3, (int) bottom};
                } else if (f2 >= ((float) this.f22960j.getHeight()) + bottom && f2 <= bottom + ((float) (this.f22960j.getHeight() * 2))) {
                    return new int[]{3, f3};
                }
            }
            i2++;
        }
    }

    public void a(int i2) {
        this.f22954d = i2;
    }

    public void a(a aVar) {
        this.f22964n = aVar;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        super.getItemOffsets(rect, view, recyclerView, sVar);
        rect.left = this.f22952b;
        rect.top = this.f22953c;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        super.onDraw(canvas, recyclerView, sVar);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Objects.requireNonNull(adapter);
        a(adapter.getItemCount(), recyclerView, canvas);
    }
}
