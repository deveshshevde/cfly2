package jp.co.cyberagent.android.gpuimage;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.view.WindowManager;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GPUImage {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f29618a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d f29619b;

    /* renamed from: c  reason: collision with root package name */
    private GLSurfaceView f29620c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f29621d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f29622e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ScaleType f29623f = ScaleType.CENTER_CROP;

    public enum ScaleType {
        CENTER_INSIDE,
        CENTER_CROP
    }

    private class a extends b {

        /* renamed from: c  reason: collision with root package name */
        private final File f29629c;

        public a(GPUImage gPUImage, File file) {
            super(gPUImage);
            this.f29629c = file;
        }

        /* access modifiers changed from: protected */
        public int a() throws IOException {
            int attributeInt = new ExifInterface(this.f29629c.getAbsolutePath()).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return SubsamplingScaleImageView.ORIENTATION_270;
        }

        /* access modifiers changed from: protected */
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeFile(this.f29629c.getAbsolutePath(), options);
        }
    }

    private abstract class b extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final GPUImage f29630a;

        /* renamed from: c  reason: collision with root package name */
        private int f29632c;

        /* renamed from: d  reason: collision with root package name */
        private int f29633d;

        public b(GPUImage gPUImage) {
            this.f29630a = gPUImage;
        }

        private boolean a(boolean z2, boolean z3) {
            return GPUImage.this.f29623f == ScaleType.CENTER_CROP ? z2 && z3 : z2 || z3;
        }

        private int[] a(int i2, int i3) {
            float f2;
            float f3;
            float f4 = (float) i2;
            float f5 = f4 / ((float) this.f29632c);
            float f6 = (float) i3;
            float f7 = f6 / ((float) this.f29633d);
            if (GPUImage.this.f29623f != ScaleType.CENTER_CROP ? f5 < f7 : f5 > f7) {
                f3 = (float) this.f29633d;
                f2 = (f3 / f6) * f4;
            } else {
                float f8 = (float) this.f29632c;
                float f9 = (f8 / f4) * f6;
                f2 = f8;
                f3 = f9;
            }
            return new int[]{Math.round(f2), Math.round(f3)};
        }

        private Bitmap b() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            a(options);
            int i2 = 1;
            while (true) {
                boolean z2 = false;
                boolean z3 = options.outWidth / i2 > this.f29632c;
                if (options.outHeight / i2 > this.f29633d) {
                    z2 = true;
                }
                if (!a(z3, z2)) {
                    break;
                }
                i2++;
            }
            int i3 = i2 - 1;
            if (i3 < 1) {
                i3 = 1;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i3;
            options2.inPreferredConfig = Bitmap.Config.RGB_565;
            options2.inPurgeable = true;
            options2.inTempStorage = new byte[32768];
            Bitmap a2 = a(options2);
            if (a2 == null) {
                return null;
            }
            return b(c(a2));
        }

        private Bitmap b(Bitmap bitmap) {
            int[] a2 = a(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, a2[0], a2[1], true);
            if (createScaledBitmap != bitmap) {
                bitmap.recycle();
                System.gc();
                bitmap = createScaledBitmap;
            }
            if (GPUImage.this.f29623f != ScaleType.CENTER_CROP) {
                return bitmap;
            }
            int i2 = a2[0] - this.f29632c;
            int i3 = a2[1] - this.f29633d;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i2 / 2, i3 / 2, a2[0] - i2, a2[1] - i3);
            if (createBitmap == bitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        }

        private Bitmap c(Bitmap bitmap) {
            Bitmap bitmap2;
            IOException e2;
            if (bitmap == null) {
                return null;
            }
            try {
                int a2 = a();
                if (a2 == 0) {
                    return bitmap;
                }
                Matrix matrix = new Matrix();
                matrix.postRotate((float) a2);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                try {
                    bitmap.recycle();
                } catch (IOException e3) {
                    e2 = e3;
                }
                return bitmap2;
            } catch (IOException e4) {
                IOException iOException = e4;
                bitmap2 = bitmap;
                e2 = iOException;
                e2.printStackTrace();
                return bitmap2;
            }
        }

        /* access modifiers changed from: protected */
        public abstract int a() throws IOException;

        /* access modifiers changed from: protected */
        public abstract Bitmap a(BitmapFactory.Options options);

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            if (GPUImage.this.f29619b != null && GPUImage.this.f29619b.b() == 0) {
                try {
                    synchronized (GPUImage.this.f29619b.f29684b) {
                        GPUImage.this.f29619b.f29684b.wait(3000);
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            this.f29632c = GPUImage.this.d();
            this.f29633d = GPUImage.this.e();
            return b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            this.f29630a.b();
            this.f29630a.a(bitmap);
        }
    }

    private class c extends b {

        /* renamed from: c  reason: collision with root package name */
        private final Uri f29635c;

        public c(GPUImage gPUImage, Uri uri) {
            super(gPUImage);
            this.f29635c = uri;
        }

        /* access modifiers changed from: protected */
        public int a() throws IOException {
            Cursor query = GPUImage.this.f29618a.getContentResolver().query(this.f29635c, new String[]{"orientation"}, (String) null, (String[]) null, (String) null);
            if (query == null || query.getCount() != 1) {
                return 0;
            }
            query.moveToFirst();
            int i2 = query.getInt(0);
            query.close();
            return i2;
        }

        /* access modifiers changed from: protected */
        public Bitmap a(BitmapFactory.Options options) {
            InputStream inputStream;
            try {
                if (!this.f29635c.getScheme().startsWith("http")) {
                    if (!this.f29635c.getScheme().startsWith("https")) {
                        inputStream = GPUImage.this.f29618a.getContentResolver().openInputStream(this.f29635c);
                        return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                    }
                }
                inputStream = new URL(this.f29635c.toString()).openStream();
                return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public GPUImage(Context context) {
        if (a(context)) {
            this.f29618a = context;
            this.f29621d = new a();
            this.f29619b = new d(this.f29621d);
            return;
        }
        throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
    }

    private boolean a(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    /* access modifiers changed from: private */
    public int d() {
        d dVar = this.f29619b;
        if (dVar != null && dVar.b() != 0) {
            return this.f29619b.b();
        }
        Bitmap bitmap = this.f29622e;
        return bitmap != null ? bitmap.getWidth() : ((WindowManager) this.f29618a.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    /* access modifiers changed from: private */
    public int e() {
        d dVar = this.f29619b;
        if (dVar != null && dVar.c() != 0) {
            return this.f29619b.c();
        }
        Bitmap bitmap = this.f29622e;
        return bitmap != null ? bitmap.getHeight() : ((WindowManager) this.f29618a.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public void a() {
        GLSurfaceView gLSurfaceView = this.f29620c;
        if (gLSurfaceView != null) {
            gLSurfaceView.requestRender();
        }
    }

    public void a(Bitmap bitmap) {
        this.f29622e = bitmap;
        this.f29619b.a(bitmap, false);
        a();
    }

    public void a(Uri uri) {
        new c(this, uri).execute(new Void[0]);
    }

    public void a(GLSurfaceView gLSurfaceView) {
        this.f29620c = gLSurfaceView;
        gLSurfaceView.setEGLContextClientVersion(2);
        this.f29620c.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.f29620c.getHolder().setFormat(1);
        this.f29620c.setRenderer(this.f29619b);
        this.f29620c.setRenderMode(0);
        this.f29620c.requestRender();
    }

    public void a(File file) {
        new a(this, file).execute(new Void[0]);
    }

    public void a(ScaleType scaleType) {
        this.f29623f = scaleType;
        this.f29619b.a(scaleType);
        this.f29619b.a();
        this.f29622e = null;
        a();
    }

    public void a(Rotation rotation) {
        this.f29619b.a(rotation);
    }

    public void a(a aVar) {
        this.f29621d = aVar;
        this.f29619b.a(aVar);
        a();
    }

    public Bitmap b(Bitmap bitmap) {
        if (this.f29620c != null) {
            this.f29619b.a();
            this.f29619b.a((Runnable) new Runnable() {
                public void run() {
                    synchronized (GPUImage.this.f29621d) {
                        GPUImage.this.f29621d.d();
                        GPUImage.this.f29621d.notify();
                    }
                }
            });
            synchronized (this.f29621d) {
                a();
                try {
                    this.f29621d.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        d dVar = new d(this.f29621d);
        dVar.a(Rotation.NORMAL, this.f29619b.d(), this.f29619b.e());
        dVar.a(this.f29623f);
        g gVar = new g(bitmap.getWidth(), bitmap.getHeight());
        gVar.a(dVar);
        dVar.a(bitmap, false);
        Bitmap a2 = gVar.a();
        this.f29621d.d();
        dVar.a();
        gVar.b();
        this.f29619b.a(this.f29621d);
        Bitmap bitmap2 = this.f29622e;
        if (bitmap2 != null) {
            this.f29619b.a(bitmap2, false);
        }
        a();
        return a2;
    }

    public void b() {
        this.f29619b.a();
        this.f29622e = null;
        a();
    }

    public Bitmap c() {
        return b(this.f29622e);
    }
}
