package com.xeagle.android.login.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.xeagle.R;
import com.xeagle.android.vjoystick.utils.e;

public class ListenerStickView extends View {
    private static final int BREATH_INTERVAL_TIME = 1000;
    private static final int NUM_AVG = 20;
    public static final int RC_RANGE = 400;
    public static final int RC_TRIM = 1500;
    private int alph = 255;
    private int animate_flag = 0;
    private Rect bgRect;
    private Rect btRect;
    private Context context;
    private int flag;
    private e handler;
    private boolean isAnimate = true;
    public boolean isLeftHand;
    public boolean isLeftStick;
    private boolean isMap;
    private boolean isOut;
    private boolean isPushT;
    public boolean isRC;
    private boolean isShowDirector = true;
    private boolean isTouch;
    private boolean isVisible = false;
    private float lastValue;
    private float lastValue_x;
    private float lastValue_y;
    /* access modifiers changed from: private */
    public Bitmap mBmpRockerBg;
    /* access modifiers changed from: private */
    public Bitmap mBmpRockerBtn;
    private RectF mBounds;
    /* access modifiers changed from: private */
    public PointF mCenterPoint;
    private Bitmap mDirectionBmp;
    /* access modifiers changed from: private */
    public float mRockerBg_R;
    /* access modifiers changed from: private */
    public float mRockerBg_X;
    /* access modifiers changed from: private */
    public float mRockerBg_Y;
    /* access modifiers changed from: private */
    public float mRockerBtn_R;
    /* access modifiers changed from: private */
    public float mRockerBtn_X;
    /* access modifiers changed from: private */
    public float mRockerBtn_Y;
    RockerChangeListener mRockerChangeListener = null;
    StickMoveListener mStickMoveListner;
    private Bitmap originalBg;
    private Bitmap originalBtn;
    Runnable stickCallback = new Runnable() {
        public void run() {
            ListenerStickView.this.postStickView();
        }
    };
    private int stickDrawable;

    public interface RockerChangeListener {
        void report(float f2, float f3);
    }

    public interface StickMoveListener {
        void onMove(float f2, float f3);

        void onTouch();

        void onUp();
    }

    public ListenerStickView(Context context2) {
        super(context2);
    }

    /* JADX INFO: finally extract failed */
    public ListenerStickView(Context context2, AttributeSet attributeSet) {
        super(context2.getApplicationContext(), attributeSet);
        this.context = context2.getApplicationContext();
        this.handler = new e(context2.getMainLooper());
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.JoyStickView);
        try {
            this.isLeftStick = obtainStyledAttributes.getBoolean(0, true);
            this.stickDrawable = obtainStyledAttributes.getResourceId(1, com.cfly.uav_pro.R.drawable.weili_sitck_left_bg);
            obtainStyledAttributes.recycle();
            this.originalBg = BitmapFactory.decodeResource(getResources(), this.stickDrawable);
            this.originalBtn = BitmapFactory.decodeResource(getResources(), com.cfly.uav_pro.R.drawable.listener_stick_bt);
            recycleBitmap(this.mBmpRockerBg);
            this.mBmpRockerBg = toGrayscale(this.originalBg, 0);
            recycleBitmap(this.mBmpRockerBtn);
            this.mBmpRockerBtn = toGrayscale(this.originalBtn, 0);
            this.bgRect = new Rect();
            this.btRect = new Rect();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private static void drawRotateBitmap(Canvas canvas, Bitmap bitmap, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        matrix.postTranslate((float) (-width), (float) (-height));
        matrix.postRotate(f2);
        matrix.postTranslate(f3 + ((float) width), f4 + ((float) height));
        canvas.drawBitmap(bitmap, matrix, (Paint) null);
    }

    public static Bitmap getTransparentBitmap(Bitmap bitmap, int i2) {
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i3 = (i2 * 255) / 100;
        for (int i4 = 0; i4 < width; i4++) {
            if (iArr[i4] != 0) {
                iArr[i4] = (i3 << 24) | (iArr[i4] & 16777215);
            }
        }
        return Bitmap.createBitmap(iArr, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }

    private void initViewPoint() {
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                PointF pointF;
                ListenerStickView listenerStickView;
                Log.i("Listener", "onPreDraw:----draw ");
                ListenerStickView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                if (ListenerStickView.this.isLeftStick) {
                    listenerStickView = ListenerStickView.this;
                    pointF = new PointF((float) ((ListenerStickView.this.getWidth() * 3) / 8), (float) (ListenerStickView.this.getHeight() / 2));
                } else {
                    listenerStickView = ListenerStickView.this;
                    pointF = new PointF((float) ((ListenerStickView.this.getWidth() * 5) / 9), (float) (ListenerStickView.this.getHeight() / 2));
                }
                PointF unused = listenerStickView.mCenterPoint = pointF;
                ListenerStickView listenerStickView2 = ListenerStickView.this;
                float unused2 = listenerStickView2.mRockerBg_X = listenerStickView2.mCenterPoint.x;
                ListenerStickView listenerStickView3 = ListenerStickView.this;
                float unused3 = listenerStickView3.mRockerBg_Y = listenerStickView3.mCenterPoint.y;
                ListenerStickView listenerStickView4 = ListenerStickView.this;
                float unused4 = listenerStickView4.mRockerBtn_X = listenerStickView4.mCenterPoint.x;
                ListenerStickView listenerStickView5 = ListenerStickView.this;
                float unused5 = listenerStickView5.mRockerBtn_Y = listenerStickView5.mCenterPoint.y;
                float width = ((float) ListenerStickView.this.mBmpRockerBg.getWidth()) / ((float) (ListenerStickView.this.mBmpRockerBg.getWidth() + ListenerStickView.this.mBmpRockerBtn.getWidth()));
                ListenerStickView listenerStickView6 = ListenerStickView.this;
                float unused6 = listenerStickView6.mRockerBg_R = ((((float) listenerStickView6.getWidth()) * width) * 1.0f) / 4.0f;
                ListenerStickView listenerStickView7 = ListenerStickView.this;
                float unused7 = listenerStickView7.mRockerBtn_R = (((1.0f - width) * ((float) listenerStickView7.getWidth())) * 1.0f) / 5.0f;
                return true;
            }
        });
        postStickView();
    }

    private int measureHeight(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int height = (getHeight() / 2) + getPaddingTop() + getPaddingBottom();
        return mode == Integer.MIN_VALUE ? Math.min(height, size) : height;
    }

    private int measureWidth(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int width = (getWidth() / 2) + getPaddingLeft() + getPaddingRight();
        return mode == Integer.MIN_VALUE ? Math.min(width, size) : width;
    }

    /* access modifiers changed from: private */
    public void postStickView() {
        postInvalidate();
        this.handler.b(this.stickCallback);
        this.handler.a(this.stickCallback, 10);
    }

    private void recycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
            System.gc();
        }
    }

    private Bitmap translate(Bitmap bitmap, float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f2, f3);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public PointF getPoint() {
        this.mCenterPoint = this.isLeftStick ? new PointF((float) ((getWidth() * 3) / 8), (float) (getHeight() / 2)) : new PointF((float) ((getWidth() * 5) / 9), (float) (getHeight() / 2));
        return this.mCenterPoint;
    }

    public float getR() {
        return this.mRockerBg_R;
    }

    public double getRad(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float acos = (float) Math.acos((double) (f6 / ((float) Math.sqrt(Math.pow((double) f6, 2.0d) + Math.pow((double) (f3 - f5), 2.0d)))));
        if (f5 < f3) {
            acos = -acos;
        }
        return (double) acos;
    }

    public void getXY(float f2, float f3, float f4, double d2) {
        double d3 = (double) f4;
        double cos = Math.cos(d2);
        Double.isNaN(d3);
        this.mRockerBtn_X = ((float) (cos * d3)) + f2;
        double sin = Math.sin(d2);
        Double.isNaN(d3);
        this.mRockerBtn_Y = ((float) (d3 * sin)) + f3;
    }

    public boolean isPushT() {
        return this.isPushT;
    }

    public boolean isTouch() {
        return this.isTouch;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        initViewPoint();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.bgRect;
        float f2 = this.mRockerBg_X;
        float f3 = this.mRockerBg_R;
        float f4 = this.mRockerBg_Y;
        rect.set((int) (f2 - f3), (int) (f4 - f3), (int) (f2 + f3), (int) (f4 + f3));
        canvas.drawBitmap(this.mBmpRockerBg, (Rect) null, this.bgRect, (Paint) null);
        Rect rect2 = this.btRect;
        float f5 = this.mRockerBtn_X;
        float f6 = this.mRockerBtn_R;
        float f7 = this.mRockerBtn_Y;
        rect2.set((int) (f5 - f6), (int) (f7 - f6), (int) (f5 + f6), (int) (f7 + f6));
        canvas.drawBitmap(this.mBmpRockerBtn, (Rect) null, this.btRect, (Paint) null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(i2, i3);
    }

    public void setIsRC(boolean z2) {
        Bitmap bitmap;
        int i2;
        this.isRC = z2;
        if (z2) {
            bitmap = this.originalBg;
            i2 = 0;
        } else {
            bitmap = this.originalBg;
            i2 = 255;
        }
        this.mBmpRockerBg = toGrayscale(bitmap, i2);
        this.mBmpRockerBtn = toGrayscale(this.originalBtn, i2);
    }

    public void setLayout(View view, int i2, int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        int left = view.getLeft() + i2;
        int top = view.getTop() + i3;
        int right = view.getRight() + i2;
        int bottom = view.getBottom() + i3;
        if (left < 0) {
            right = view.getWidth() + 0;
            left = 0;
        }
        if (right > i4) {
            left = i4 - view.getWidth();
        } else {
            i4 = right;
        }
        if (top < 0) {
            bottom = view.getHeight() + 0;
            top = 0;
        }
        if (bottom > i5) {
            top = i5 - view.getHeight();
        } else {
            i5 = bottom;
        }
        view.layout(left, top, i4, i5);
    }

    public void setLeftHand(boolean z2) {
        this.isLeftHand = z2;
    }

    public void setMap(boolean z2) {
        this.isMap = z2;
    }

    public void setRockerChangeListener(RockerChangeListener rockerChangeListener) {
        this.mRockerChangeListener = rockerChangeListener;
    }

    public void setStickMoveListener(StickMoveListener stickMoveListener) {
        this.mStickMoveListner = stickMoveListener;
    }

    public void setStickVisible(boolean z2) {
        this.isVisible = z2;
        if (!z2) {
            recycleBitmap(this.mBmpRockerBg);
            this.mBmpRockerBg = toGrayscale(this.originalBg, 0);
            recycleBitmap(this.mBmpRockerBtn);
            this.mBmpRockerBtn = toGrayscale(this.originalBtn, 0);
        }
    }

    public void setmRockerBtn_X(float f2) {
        if (this.mRockerBtn_X != f2) {
            this.mRockerBtn_X = f2;
        }
    }

    public void setmRockerBtn_Y(float f2) {
        if (this.mRockerBtn_Y != f2) {
            this.mRockerBtn_Y = f2;
        }
    }

    public Bitmap toGrayscale(Bitmap bitmap, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAlpha(i2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }
}
