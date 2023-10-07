package com.xeagle.android.widgets.MenuImageview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public class MyImageView extends ImageView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f25597a;

    /* renamed from: b  reason: collision with root package name */
    private int f25598b;

    /* renamed from: c  reason: collision with root package name */
    private int f25599c;

    /* renamed from: d  reason: collision with root package name */
    private int f25600d;

    /* renamed from: e  reason: collision with root package name */
    private int f25601e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f25602f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f25603g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public a f25604h;

    public interface a {
        void a(MyImageView myImageView);
    }

    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private Matrix f25605a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private int f25606b = 0;

        /* renamed from: c  reason: collision with root package name */
        private float f25607c;

        /* renamed from: d  reason: collision with root package name */
        private WeakReference<MyImageView> f25608d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f25609e;

        public b(MyImageView myImageView) {
            this.f25608d = new WeakReference<>(myImageView);
        }

        public void handleMessage(Message message) {
            float f2;
            MyImageView myImageView = (MyImageView) this.f25608d.get();
            if (myImageView == null) {
                Log.i("IV", "ImageView is null!");
                return;
            }
            this.f25605a.set(myImageView.getImageMatrix());
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 == 1) {
                    myImageView.a(this.f25605a, this.f25607c);
                    if (this.f25606b < 4) {
                        myImageView.f25597a.sendEmptyMessage(1);
                    } else {
                        boolean unused = myImageView.f25603g = true;
                        if (myImageView.f25604h == null || this.f25609e) {
                            this.f25609e = false;
                        } else {
                            this.f25609e = true;
                            myImageView.f25604h.a(myImageView);
                        }
                    }
                    this.f25606b++;
                    return;
                } else if (i2 == 6) {
                    if (!myImageView.f25603g) {
                        myImageView.f25597a.sendEmptyMessage(6);
                        return;
                    }
                    boolean unused2 = myImageView.f25603g = false;
                    this.f25606b = 0;
                    f2 = 1.0f / myImageView.f25602f;
                } else {
                    return;
                }
            } else if (!myImageView.f25603g) {
                myImageView.f25597a.sendEmptyMessage(0);
                return;
            } else {
                boolean unused3 = myImageView.f25603g = false;
                this.f25606b = 0;
                f2 = myImageView.f25602f;
            }
            float sqrt = (float) Math.sqrt(Math.sqrt((double) f2));
            this.f25607c = sqrt;
            myImageView.a(this.f25605a, sqrt);
            myImageView.f25597a.sendEmptyMessage(1);
        }
    }

    public MyImageView(Context context) {
        this(context.getApplicationContext(), (AttributeSet) null);
    }

    public MyImageView(Context context, AttributeSet attributeSet) {
        this(context.getApplicationContext(), attributeSet, 0);
    }

    public MyImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context.getApplicationContext(), attributeSet, i2);
        this.f25597a = new b(this);
        this.f25602f = 0.85f;
        this.f25603g = true;
    }

    /* access modifiers changed from: private */
    public synchronized void a(Matrix matrix, float f2) {
        matrix.postScale(f2, f2, (float) this.f25600d, (float) this.f25601e);
        setImageMatrix(matrix);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            this.f25598b = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            this.f25599c = height;
            this.f25600d = this.f25598b / 2;
            this.f25601e = height / 2;
            ((BitmapDrawable) getDrawable()).setAntiAlias(true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        int i2;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                bVar = this.f25597a;
                i2 = 6;
            }
            return true;
        }
        motionEvent.getX();
        motionEvent.getY();
        bVar = this.f25597a;
        i2 = 0;
        bVar.sendEmptyMessage(i2);
        return true;
    }

    public void setOnClickIntent(a aVar) {
        this.f25604h = aVar;
    }
}
