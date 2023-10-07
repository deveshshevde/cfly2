package com.xeagle.android.login.pickImage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.xeagle.R;
import fg.i;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class CropImageView extends AppCompatImageView {
    private static final int DRAG = 1;
    private static final float MAX_SCALE = 4.0f;
    private static final int NONE = 0;
    private static final int ROTATE = 3;
    private static final int SAVE_ERROR = 1002;
    private static final int SAVE_SUCCESS = 1001;
    private static final int ZOOM = 2;
    private static final int ZOOM_OR_ROTATE = 4;
    private PointF doubleClickPos;
    private long doubleClickTime;
    private boolean isInited;
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private int mDefaultStyleIndex;
    private int mFocusHeight;
    private PointF mFocusMidPoint;
    private Path mFocusPath;
    private RectF mFocusRect;
    private int mFocusWidth;
    private InnerHandler mHandler;
    private int mImageHeight;
    private int mImageWidth;
    private OnBitmapSaveCompleteListener mListener;
    private int mMaskColor;
    private float mMaxScale;
    private int mRotatedImageHeight;
    private int mRotatedImageWidth;
    private boolean mSaving;
    private Style mStyle;
    private Matrix matrix;
    private PointF midPoint;
    private int mode;
    private float oldDist;
    private PointF pA;
    private PointF pB;
    private double rotation;
    private Matrix savedMatrix;
    private Style[] styles;
    private int sumRotateLevel;

    private static class InnerHandler extends Handler {
        private SoftReference<OnBitmapSaveCompleteListener> mListener;

        public InnerHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            File file = (File) message.obj;
            int i2 = message.what;
            if (i2 != 1001) {
                if (i2 == 1002 && this.mListener.get() != null) {
                    this.mListener.get().onBitmapSaveError(file);
                }
            } else if (this.mListener.get() != null) {
                this.mListener.get().onBitmapSaveSuccess(file);
            }
        }

        public void setListener(OnBitmapSaveCompleteListener onBitmapSaveCompleteListener) {
            this.mListener = new SoftReference<>(onBitmapSaveCompleteListener);
        }
    }

    public interface OnBitmapSaveCompleteListener {
        void onBitmapSaveError(File file);

        void onBitmapSaveSuccess(File file);
    }

    public enum Style {
        RECTANGLE,
        CIRCLE
    }

    public CropImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Style[] styleArr = {Style.RECTANGLE, Style.CIRCLE};
        this.styles = styleArr;
        this.mMaskColor = -1358954496;
        this.mBorderColor = -1434419072;
        this.mBorderWidth = 1;
        this.mFocusWidth = SpatialRelationUtil.A_CIRCLE_DEGREE;
        this.mFocusHeight = SpatialRelationUtil.A_CIRCLE_DEGREE;
        this.mDefaultStyleIndex = 0;
        this.mStyle = styleArr[0];
        this.mBorderPaint = new Paint();
        this.mFocusPath = new Path();
        this.mFocusRect = new RectF();
        this.matrix = new Matrix();
        this.savedMatrix = new Matrix();
        this.pA = new PointF();
        this.pB = new PointF();
        this.midPoint = new PointF();
        this.doubleClickPos = new PointF();
        this.mFocusMidPoint = new PointF();
        this.mode = 0;
        this.doubleClickTime = 0;
        this.rotation = i.f27244a;
        this.oldDist = 1.0f;
        this.sumRotateLevel = 0;
        this.mMaxScale = MAX_SCALE;
        this.isInited = false;
        this.mSaving = false;
        this.mHandler = new InnerHandler();
        this.mFocusWidth = (int) TypedValue.applyDimension(1, (float) this.mFocusWidth, getResources().getDisplayMetrics());
        this.mFocusHeight = (int) TypedValue.applyDimension(1, (float) this.mFocusHeight, getResources().getDisplayMetrics());
        this.mBorderWidth = (int) TypedValue.applyDimension(1, (float) this.mBorderWidth, getResources().getDisplayMetrics());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CropImageView);
        this.mMaskColor = obtainStyledAttributes.getColor(4, this.mMaskColor);
        this.mBorderColor = obtainStyledAttributes.getColor(0, this.mBorderColor);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(1, this.mBorderWidth);
        this.mFocusWidth = obtainStyledAttributes.getDimensionPixelSize(3, this.mFocusWidth);
        this.mFocusHeight = obtainStyledAttributes.getDimensionPixelSize(2, this.mFocusHeight);
        int integer = obtainStyledAttributes.getInteger(5, this.mDefaultStyleIndex);
        this.mDefaultStyleIndex = integer;
        this.mStyle = this.styles[integer];
        obtainStyledAttributes.recycle();
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private File createFile(File file, String str, String str2) {
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        try {
            File file2 = new File(file, ".nomedia");
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA);
        return new File(file, str + simpleDateFormat.format(new Date(System.currentTimeMillis())) + str2);
    }

    private void doubleClick(float f2, float f3) {
        float[] fArr = new float[9];
        this.matrix.getValues(fArr);
        float abs = Math.abs(fArr[0]) + Math.abs(fArr[1]);
        float scale = getScale(this.mRotatedImageWidth, this.mRotatedImageHeight, this.mFocusWidth, this.mFocusHeight, true);
        float f4 = this.mMaxScale;
        if (abs < f4) {
            float min = Math.min(scale + abs, f4) / abs;
            this.matrix.postScale(min, min, f2, f3);
        } else {
            float f5 = scale / abs;
            this.matrix.postScale(f5, f5, f2, f3);
            fixTranslation();
        }
        setImageMatrix(this.matrix);
    }

    private void fixScale() {
        float[] fArr = new float[9];
        this.matrix.getValues(fArr);
        float abs = Math.abs(fArr[0]) + Math.abs(fArr[1]);
        float scale = getScale(this.mRotatedImageWidth, this.mRotatedImageHeight, this.mFocusWidth, this.mFocusHeight, true);
        float f2 = MAX_SCALE * scale;
        this.mMaxScale = f2;
        if (abs < scale) {
            float f3 = scale / abs;
            this.matrix.postScale(f3, f3);
        } else if (abs > f2) {
            float f4 = f2 / abs;
            this.matrix.postScale(f4, f4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fixTranslation() {
        /*
            r5 = this;
            android.graphics.RectF r0 = new android.graphics.RectF
            int r1 = r5.mImageWidth
            float r1 = (float) r1
            int r2 = r5.mImageHeight
            float r2 = (float) r2
            r3 = 0
            r0.<init>(r3, r3, r1, r2)
            android.graphics.Matrix r1 = r5.matrix
            r1.mapRect(r0)
            float r1 = r0.left
            android.graphics.RectF r2 = r5.mFocusRect
            float r2 = r2.left
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0024
            float r1 = r0.left
            float r1 = -r1
            android.graphics.RectF r2 = r5.mFocusRect
            float r2 = r2.left
        L_0x0022:
            float r1 = r1 + r2
            goto L_0x0037
        L_0x0024:
            float r1 = r0.right
            android.graphics.RectF r2 = r5.mFocusRect
            float r2 = r2.right
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0036
            float r1 = r0.right
            float r1 = -r1
            android.graphics.RectF r2 = r5.mFocusRect
            float r2 = r2.right
            goto L_0x0022
        L_0x0036:
            r1 = 0
        L_0x0037:
            float r2 = r0.top
            android.graphics.RectF r4 = r5.mFocusRect
            float r4 = r4.top
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x004b
            float r0 = r0.top
            float r0 = -r0
            android.graphics.RectF r2 = r5.mFocusRect
            float r2 = r2.top
        L_0x0048:
            float r3 = r0 + r2
            goto L_0x005d
        L_0x004b:
            float r2 = r0.bottom
            android.graphics.RectF r4 = r5.mFocusRect
            float r4 = r4.bottom
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x005d
            float r0 = r0.bottom
            float r0 = -r0
            android.graphics.RectF r2 = r5.mFocusRect
            float r2 = r2.bottom
            goto L_0x0048
        L_0x005d:
            android.graphics.Matrix r0 = r5.matrix
            r0.postTranslate(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.pickImage.CropImageView.fixTranslation():void");
    }

    private RectF getImageMatrixRect() {
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, (float) getDrawable().getIntrinsicWidth(), (float) getDrawable().getIntrinsicHeight());
        this.matrix.mapRect(rectF);
        return rectF;
    }

    private float getScale(int i2, int i3, int i4, int i5, boolean z2) {
        float f2 = ((float) i4) / ((float) i2);
        float f3 = ((float) i5) / ((float) i3);
        if (z2) {
            if (f2 > f3) {
                return f2;
            }
        } else if (f2 < f3) {
            return f2;
        }
        return f3;
    }

    private void initImage() {
        Drawable drawable = getDrawable();
        if (this.isInited && drawable != null) {
            this.mode = 0;
            this.matrix = getImageMatrix();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            this.mRotatedImageWidth = intrinsicWidth;
            this.mImageWidth = intrinsicWidth;
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.mRotatedImageHeight = intrinsicHeight;
            this.mImageHeight = intrinsicHeight;
            int width = getWidth();
            int height = getHeight();
            this.mFocusMidPoint = new PointF(((float) width) / 2.0f, ((float) height) / 2.0f);
            if (this.mStyle == Style.CIRCLE) {
                int min = Math.min(this.mFocusWidth, this.mFocusHeight);
                this.mFocusWidth = min;
                this.mFocusHeight = min;
            }
            this.mFocusRect.left = this.mFocusMidPoint.x - ((float) (this.mFocusWidth / 2));
            this.mFocusRect.right = this.mFocusMidPoint.x + ((float) (this.mFocusWidth / 2));
            this.mFocusRect.top = this.mFocusMidPoint.y - ((float) (this.mFocusHeight / 2));
            this.mFocusRect.bottom = this.mFocusMidPoint.y + ((float) (this.mFocusHeight / 2));
            float scale = getScale(this.mImageWidth, this.mImageHeight, this.mFocusWidth, this.mFocusHeight, true);
            this.mMaxScale = MAX_SCALE * scale;
            float scale2 = getScale(this.mImageWidth, this.mImageHeight, width, height, false);
            if (scale2 > scale) {
                scale = scale2;
            }
            this.matrix.setScale(scale, scale, (float) (this.mImageWidth / 2), (float) (this.mImageHeight / 2));
            float[] fArr = new float[9];
            this.matrix.getValues(fArr);
            this.matrix.postTranslate(this.mFocusMidPoint.x - (fArr[2] + ((((float) this.mImageWidth) * fArr[0]) / 2.0f)), this.mFocusMidPoint.y - (fArr[5] + ((((float) this.mImageHeight) * fArr[4]) / 2.0f)));
            setImageMatrix(this.matrix);
            invalidate();
        }
    }

    private Bitmap makeCropBitmap(Bitmap bitmap, RectF rectF, RectF rectF2, int i2, int i3, boolean z2) {
        float width = rectF2.width() / ((float) bitmap.getWidth());
        int i4 = (int) ((rectF.left - rectF2.left) / width);
        int i5 = (int) ((rectF.top - rectF2.top) / width);
        int width2 = (int) (rectF.width() / width);
        int height = (int) (rectF.height() / width);
        if (i4 < 0) {
            i4 = 0;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        if (i4 + width2 > bitmap.getWidth()) {
            width2 = bitmap.getWidth() - i4;
        }
        if (i5 + height > bitmap.getHeight()) {
            height = bitmap.getHeight() - i5;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i4, i5, width2, height);
            if (i2 == width2 && i3 == height) {
                return createBitmap;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, i2, i3, true);
            if (this.mStyle != Style.CIRCLE || z2) {
                return createScaledBitmap;
            }
            int min = Math.min(i2, i3);
            int i6 = min / 2;
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            BitmapShader bitmapShader = new BitmapShader(createScaledBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            Paint paint = new Paint();
            paint.setShader(bitmapShader);
            canvas.drawCircle(((float) i2) / 2.0f, ((float) i3) / 2.0f, (float) i6, paint);
            return createBitmap2;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    private float maxPostScale() {
        float[] fArr = new float[9];
        this.matrix.getValues(fArr);
        return this.mMaxScale / (Math.abs(fArr[0]) + Math.abs(fArr[1]));
    }

    private Bitmap rotate(Bitmap bitmap, int i2) {
        if (!(i2 == 0 || bitmap == null)) {
            Matrix matrix2 = new Matrix();
            matrix2.setRotate((float) i2, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
                if (bitmap != createBitmap) {
                    return createBitmap;
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return bitmap;
    }

    /* access modifiers changed from: private */
    public void saveOutput(Bitmap bitmap, Bitmap.CompressFormat compressFormat, File file) {
        OutputStream outputStream = null;
        try {
            OutputStream openOutputStream = getContext().getContentResolver().openOutputStream(Uri.fromFile(file));
            if (openOutputStream != null) {
                bitmap.compress(compressFormat, 90, openOutputStream);
            }
            Message.obtain(this.mHandler, 1001, file).sendToTarget();
            if (openOutputStream != null) {
                try {
                    openOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            Message.obtain(this.mHandler, 1002, file).sendToTarget();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        this.mSaving = false;
        bitmap.recycle();
    }

    private float spacing(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }

    private float spacing(PointF pointF, PointF pointF2) {
        return spacing(pointF.x, pointF.y, pointF2.x, pointF2.y);
    }

    public abstract Bitmap getBitmap();

    public float getBorderWidth() {
        return (float) this.mBorderWidth;
    }

    public Bitmap getCropBitmap(int i2, int i3, boolean z2) {
        Bitmap bitmap;
        if (i2 <= 0 || i3 < 0 || (bitmap = getBitmap()) == null) {
            return null;
        }
        return makeCropBitmap(rotate(bitmap, this.sumRotateLevel * 90), this.mFocusRect, getImageMatrixRect(), i2, i3, z2);
    }

    public int getFocusColor() {
        return this.mBorderColor;
    }

    public int getFocusHeight() {
        return this.mFocusHeight;
    }

    public Style getFocusStyle() {
        return this.mStyle;
    }

    public int getFocusWidth() {
        return this.mFocusWidth;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Style.RECTANGLE == this.mStyle) {
            this.mFocusPath.addRect(this.mFocusRect, Path.Direction.CCW);
        } else {
            if (Style.CIRCLE == this.mStyle) {
                this.mFocusPath.addCircle(this.mFocusMidPoint.x, this.mFocusMidPoint.y, Math.min((this.mFocusRect.right - this.mFocusRect.left) / 2.0f, (this.mFocusRect.bottom - this.mFocusRect.top) / 2.0f), Path.Direction.CCW);
            }
            this.mBorderPaint.setColor(this.mBorderColor);
            this.mBorderPaint.setStyle(Paint.Style.STROKE);
            this.mBorderPaint.setStrokeWidth((float) this.mBorderWidth);
            this.mBorderPaint.setAntiAlias(true);
            canvas.drawPath(this.mFocusPath, this.mBorderPaint);
            this.mFocusPath.reset();
        }
        canvas.save();
        canvas.clipRect(0, 0, getWidth(), getHeight());
        canvas.clipPath(this.mFocusPath, Region.Op.DIFFERENCE);
        canvas.drawColor(this.mMaskColor);
        canvas.restore();
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth((float) this.mBorderWidth);
        this.mBorderPaint.setAntiAlias(true);
        canvas.drawPath(this.mFocusPath, this.mBorderPaint);
        this.mFocusPath.reset();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.isInited = true;
        initImage();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r2 != 6) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            boolean r2 = r0.mSaving
            if (r2 != 0) goto L_0x035b
            android.graphics.drawable.Drawable r2 = r21.getDrawable()
            if (r2 != 0) goto L_0x0010
            goto L_0x035b
        L_0x0010:
            int r2 = r22.getAction()
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 1
            if (r2 == 0) goto L_0x0333
            r4 = 4605249457297304856(0x3fe921fb54442d18, double:0.7853981633974483)
            r6 = 4
            r8 = 0
            if (r2 == r3) goto L_0x02a1
            r9 = 1092616192(0x41200000, float:10.0)
            r10 = 2
            if (r2 == r10) goto L_0x0086
            r10 = 5
            if (r2 == r10) goto L_0x0030
            r1 = 6
            if (r2 == r1) goto L_0x02a1
        L_0x002d:
            r1 = 1
            goto L_0x0357
        L_0x0030:
            int r2 = r22.getActionIndex()
            if (r2 <= r3) goto L_0x0037
            goto L_0x002d
        L_0x0037:
            android.graphics.PointF r2 = r0.pA
            float r4 = r1.getX(r8)
            float r5 = r1.getY(r8)
            r2.set(r4, r5)
            android.graphics.PointF r2 = r0.pB
            float r4 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r2.set(r4, r1)
            android.graphics.PointF r1 = r0.midPoint
            android.graphics.PointF r2 = r0.pA
            float r2 = r2.x
            android.graphics.PointF r4 = r0.pB
            float r4 = r4.x
            float r2 = r2 + r4
            r4 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r4
            android.graphics.PointF r5 = r0.pA
            float r5 = r5.y
            android.graphics.PointF r7 = r0.pB
            float r7 = r7.y
            float r5 = r5 + r7
            float r5 = r5 / r4
            r1.set(r2, r5)
            android.graphics.PointF r1 = r0.pA
            android.graphics.PointF r2 = r0.pB
            float r1 = r0.spacing(r1, r2)
            r0.oldDist = r1
            android.graphics.Matrix r1 = r0.savedMatrix
            android.graphics.Matrix r2 = r0.matrix
            r1.set(r2)
            float r1 = r0.oldDist
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x002d
            r0.mode = r6
            goto L_0x002d
        L_0x0086:
            int r2 = r0.mode
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            r13 = 4621819117588971520(0x4024000000000000, double:10.0)
            if (r2 != r6) goto L_0x0129
            android.graphics.PointF r2 = new android.graphics.PointF
            float r6 = r1.getX(r3)
            float r15 = r1.getX(r8)
            float r6 = r6 - r15
            android.graphics.PointF r15 = r0.pA
            float r15 = r15.x
            float r6 = r6 + r15
            float r15 = r1.getY(r3)
            float r16 = r1.getY(r8)
            float r15 = r15 - r16
            android.graphics.PointF r9 = r0.pA
            float r9 = r9.y
            float r15 = r15 + r9
            r2.<init>(r6, r15)
            android.graphics.PointF r6 = r0.pB
            float r6 = r6.x
            android.graphics.PointF r9 = r0.pB
            float r9 = r9.y
            float r15 = r2.x
            float r8 = r2.y
            float r6 = r0.spacing(r6, r9, r15, r8)
            double r8 = (double) r6
            android.graphics.PointF r6 = r0.pA
            float r6 = r6.x
            android.graphics.PointF r15 = r0.pA
            float r15 = r15.y
            float r3 = r2.x
            float r2 = r2.y
            float r2 = r0.spacing(r6, r15, r3, r2)
            double r2 = (double) r2
            android.graphics.PointF r6 = r0.pA
            float r6 = r6.x
            android.graphics.PointF r15 = r0.pA
            float r15 = r15.y
            android.graphics.PointF r10 = r0.pB
            float r10 = r10.x
            android.graphics.PointF r7 = r0.pB
            float r7 = r7.y
            float r6 = r0.spacing(r6, r15, r10, r7)
            double r6 = (double) r6
            int r10 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r10 < 0) goto L_0x0129
            java.lang.Double.isNaN(r8)
            java.lang.Double.isNaN(r8)
            double r17 = r8 * r8
            java.lang.Double.isNaN(r6)
            java.lang.Double.isNaN(r6)
            double r19 = r6 * r6
            double r17 = r17 + r19
            java.lang.Double.isNaN(r2)
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r2
            double r17 = r17 - r2
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r11
            java.lang.Double.isNaN(r6)
            double r8 = r8 * r6
            double r17 = r17 / r8
            double r2 = java.lang.Math.acos(r17)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0126
            r4 = 4612488097114038738(0x4002d97c7f3321d2, double:2.356194490192345)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0126
            r2 = 3
            goto L_0x0127
        L_0x0126:
            r2 = 2
        L_0x0127:
            r0.mode = r2
        L_0x0129:
            int r2 = r0.mode
            r3 = 1
            if (r2 != r3) goto L_0x0156
            android.graphics.Matrix r2 = r0.matrix
            android.graphics.Matrix r3 = r0.savedMatrix
            r2.set(r3)
            android.graphics.Matrix r2 = r0.matrix
            float r3 = r22.getX()
            android.graphics.PointF r4 = r0.pA
            float r4 = r4.x
            float r3 = r3 - r4
            float r1 = r22.getY()
            android.graphics.PointF r4 = r0.pA
            float r4 = r4.y
            float r1 = r1 - r4
            r2.postTranslate(r3, r1)
        L_0x014c:
            r21.fixTranslation()
        L_0x014f:
            android.graphics.Matrix r1 = r0.matrix
            r0.setImageMatrix(r1)
            goto L_0x002d
        L_0x0156:
            r3 = 2
            if (r2 != r3) goto L_0x019d
            r3 = 0
            float r2 = r1.getX(r3)
            float r3 = r1.getY(r3)
            r4 = 1
            float r5 = r1.getX(r4)
            float r1 = r1.getY(r4)
            float r1 = r0.spacing(r2, r3, r5, r1)
            r2 = 1092616192(0x41200000, float:10.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x002d
            android.graphics.Matrix r2 = r0.matrix
            android.graphics.Matrix r3 = r0.savedMatrix
            r2.set(r3)
            float r2 = r0.oldDist
            float r1 = r1 / r2
            float r2 = r21.maxPostScale()
            float r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x002d
            android.graphics.Matrix r2 = r0.matrix
            android.graphics.PointF r3 = r0.midPoint
            float r3 = r3.x
            android.graphics.PointF r4 = r0.midPoint
            float r4 = r4.y
            r2.postScale(r1, r1, r3, r4)
            r21.fixScale()
            goto L_0x014c
        L_0x019d:
            r3 = 3
            if (r2 != r3) goto L_0x002d
            android.graphics.PointF r2 = new android.graphics.PointF
            r3 = 1
            float r4 = r1.getX(r3)
            r5 = 0
            float r6 = r1.getX(r5)
            float r4 = r4 - r6
            android.graphics.PointF r6 = r0.pA
            float r6 = r6.x
            float r4 = r4 + r6
            float r6 = r1.getY(r3)
            float r1 = r1.getY(r5)
            float r6 = r6 - r1
            android.graphics.PointF r1 = r0.pA
            float r1 = r1.y
            float r6 = r6 + r1
            r2.<init>(r4, r6)
            android.graphics.PointF r1 = r0.pB
            float r1 = r1.x
            android.graphics.PointF r3 = r0.pB
            float r3 = r3.y
            float r4 = r2.x
            float r5 = r2.y
            float r1 = r0.spacing(r1, r3, r4, r5)
            double r3 = (double) r1
            android.graphics.PointF r1 = r0.pA
            float r1 = r1.x
            android.graphics.PointF r5 = r0.pA
            float r5 = r5.y
            float r6 = r2.x
            float r7 = r2.y
            float r1 = r0.spacing(r1, r5, r6, r7)
            double r5 = (double) r1
            android.graphics.PointF r1 = r0.pA
            float r1 = r1.x
            android.graphics.PointF r7 = r0.pA
            float r7 = r7.y
            android.graphics.PointF r8 = r0.pB
            float r8 = r8.x
            android.graphics.PointF r9 = r0.pB
            float r9 = r9.y
            float r1 = r0.spacing(r1, r7, r8, r9)
            double r7 = (double) r1
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 <= 0) goto L_0x002d
            java.lang.Double.isNaN(r5)
            java.lang.Double.isNaN(r5)
            double r9 = r5 * r5
            java.lang.Double.isNaN(r7)
            java.lang.Double.isNaN(r7)
            double r13 = r7 * r7
            double r9 = r9 + r13
            java.lang.Double.isNaN(r3)
            java.lang.Double.isNaN(r3)
            double r3 = r3 * r3
            double r9 = r9 - r3
            java.lang.Double.isNaN(r5)
            double r5 = r5 * r11
            java.lang.Double.isNaN(r7)
            double r5 = r5 * r7
            double r9 = r9 / r5
            double r3 = java.lang.Math.acos(r9)
            android.graphics.PointF r1 = r0.pB
            float r1 = r1.y
            android.graphics.PointF r5 = r0.pA
            float r5 = r5.y
            float r1 = r1 - r5
            double r5 = (double) r1
            android.graphics.PointF r1 = r0.pA
            float r1 = r1.x
            android.graphics.PointF r7 = r0.pB
            float r7 = r7.x
            float r1 = r1 - r7
            double r7 = (double) r1
            android.graphics.PointF r1 = r0.pB
            float r1 = r1.x
            android.graphics.PointF r9 = r0.pA
            float r9 = r9.y
            float r1 = r1 * r9
            android.graphics.PointF r9 = r0.pA
            float r9 = r9.x
            android.graphics.PointF r10 = r0.pB
            float r10 = r10.y
            float r9 = r9 * r10
            float r1 = r1 - r9
            double r9 = (double) r1
            float r1 = r2.x
            double r11 = (double) r1
            java.lang.Double.isNaN(r5)
            java.lang.Double.isNaN(r11)
            double r5 = r5 * r11
            float r1 = r2.y
            double r1 = (double) r1
            java.lang.Double.isNaN(r7)
            java.lang.Double.isNaN(r1)
            double r7 = r7 * r1
            double r5 = r5 + r7
            java.lang.Double.isNaN(r9)
            double r5 = r5 + r9
            r1 = 0
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 <= 0) goto L_0x0279
            r1 = 4618760256179416344(0x401921fb54442d18, double:6.283185307179586)
            double r3 = r1 - r3
        L_0x0279:
            r0.rotation = r3
            android.graphics.Matrix r1 = r0.matrix
            android.graphics.Matrix r2 = r0.savedMatrix
            r1.set(r2)
            android.graphics.Matrix r1 = r0.matrix
            double r2 = r0.rotation
            r4 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r2 = r2 * r4
            r4 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r2 = r2 / r4
            float r2 = (float) r2
            android.graphics.PointF r3 = r0.midPoint
            float r3 = r3.x
            android.graphics.PointF r4 = r0.midPoint
            float r4 = r4.y
            r1.postRotate(r2, r3, r4)
            goto L_0x014f
        L_0x02a1:
            int r1 = r0.mode
            r2 = 1
            if (r1 != r2) goto L_0x02e5
            android.graphics.PointF r1 = r0.pA
            android.graphics.PointF r2 = r0.pB
            float r1 = r0.spacing(r1, r2)
            r2 = 1112014848(0x42480000, float:50.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x032e
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = r0.doubleClickTime
            long r5 = r3 - r5
            r7 = 500(0x1f4, double:2.47E-321)
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x02db
            android.graphics.PointF r1 = r0.pA
            android.graphics.PointF r5 = r0.doubleClickPos
            float r1 = r0.spacing(r1, r5)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x02db
            android.graphics.PointF r1 = r0.pA
            float r1 = r1.x
            android.graphics.PointF r2 = r0.pA
            float r2 = r2.y
            r0.doubleClick(r1, r2)
            r3 = 0
        L_0x02db:
            android.graphics.PointF r1 = r0.doubleClickPos
            android.graphics.PointF r2 = r0.pA
            r1.set(r2)
            r0.doubleClickTime = r3
            goto L_0x032e
        L_0x02e5:
            r2 = 3
            if (r1 != r2) goto L_0x032e
            double r1 = r0.rotation
            double r1 = r1 + r4
            r3 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r1 = r1 / r3
            double r1 = java.lang.Math.floor(r1)
            int r3 = (int) r1
            if (r3 != r6) goto L_0x02f9
            r3 = 0
        L_0x02f9:
            android.graphics.Matrix r1 = r0.matrix
            android.graphics.Matrix r2 = r0.savedMatrix
            r1.set(r2)
            android.graphics.Matrix r1 = r0.matrix
            int r2 = r3 * 90
            float r2 = (float) r2
            android.graphics.PointF r4 = r0.midPoint
            float r4 = r4.x
            android.graphics.PointF r5 = r0.midPoint
            float r5 = r5.y
            r1.postRotate(r2, r4, r5)
            r1 = 1
            if (r3 == r1) goto L_0x0316
            r1 = 3
            if (r3 != r1) goto L_0x031e
        L_0x0316:
            int r1 = r0.mRotatedImageWidth
            int r2 = r0.mRotatedImageHeight
            r0.mRotatedImageWidth = r2
            r0.mRotatedImageHeight = r1
        L_0x031e:
            r21.fixScale()
            r21.fixTranslation()
            android.graphics.Matrix r1 = r0.matrix
            r0.setImageMatrix(r1)
            int r1 = r0.sumRotateLevel
            int r1 = r1 + r3
            r0.sumRotateLevel = r1
        L_0x032e:
            r1 = 0
            r0.mode = r1
            goto L_0x002d
        L_0x0333:
            android.graphics.Matrix r2 = r0.savedMatrix
            android.graphics.Matrix r3 = r0.matrix
            r2.set(r3)
            android.graphics.PointF r2 = r0.pA
            float r3 = r22.getX()
            float r4 = r22.getY()
            r2.set(r3, r4)
            android.graphics.PointF r2 = r0.pB
            float r3 = r22.getX()
            float r1 = r22.getY()
            r2.set(r3, r1)
            r1 = 1
            r0.mode = r1
        L_0x0357:
            t.ac.e(r21)
            return r1
        L_0x035b:
            boolean r1 = super.onTouchEvent(r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.pickImage.CropImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r6 = getCropBitmap(r6, r7, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean saveBitmapToFile(java.io.File r5, int r6, int r7, boolean r8) {
        /*
            r4 = this;
            boolean r0 = r4.mSaving
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            android.graphics.Bitmap r6 = r4.getCropBitmap(r6, r7, r8)
            if (r6 != 0) goto L_0x000d
            return r1
        L_0x000d:
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.JPEG
            java.lang.String r0 = "IMG_"
            java.lang.String r1 = ".jpg"
            java.io.File r1 = r4.createFile(r5, r0, r1)
            com.xeagle.android.login.pickImage.CropImageView$Style r2 = r4.mStyle
            com.xeagle.android.login.pickImage.CropImageView$Style r3 = com.xeagle.android.login.pickImage.CropImageView.Style.CIRCLE
            if (r2 != r3) goto L_0x0027
            if (r8 != 0) goto L_0x0027
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.PNG
            java.lang.String r8 = ".png"
            java.io.File r1 = r4.createFile(r5, r0, r8)
        L_0x0027:
            r5 = 1
            r4.mSaving = r5
            com.xeagle.android.login.pickImage.CropImageView$1 r8 = new com.xeagle.android.login.pickImage.CropImageView$1
            r8.<init>(r6, r7, r1)
            r8.start()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.pickImage.CropImageView.saveBitmapToFile(java.io.File, int, int, boolean):boolean");
    }

    public void setBorderColor(int i2) {
        this.mBorderColor = i2;
        invalidate();
    }

    public void setBorderWidth(int i2) {
        this.mBorderWidth = i2;
        invalidate();
    }

    public void setFocusHeight(int i2) {
        this.mFocusHeight = i2;
        initImage();
    }

    public void setFocusStyle(Style style) {
        this.mStyle = style;
        invalidate();
    }

    public void setFocusWidth(int i2) {
        this.mFocusWidth = i2;
        initImage();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        initImage();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        initImage();
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        initImage();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        initImage();
    }

    public void setMaskColor(int i2) {
        this.mMaskColor = i2;
        invalidate();
    }

    public void setOnBitmapSaveCompleteListener(OnBitmapSaveCompleteListener onBitmapSaveCompleteListener) {
        this.mListener = onBitmapSaveCompleteListener;
        this.mHandler.setListener(onBitmapSaveCompleteListener);
    }
}
