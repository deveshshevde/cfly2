package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: h  reason: collision with root package name */
    static final PorterDuff.Mode f2958h = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f2959a = -1;

    /* renamed from: b  reason: collision with root package name */
    Object f2960b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f2961c = null;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f2962d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f2963e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f2964f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f2965g = null;

    /* renamed from: i  reason: collision with root package name */
    PorterDuff.Mode f2966i = f2958h;

    /* renamed from: j  reason: collision with root package name */
    public String f2967j = null;

    /* renamed from: k  reason: collision with root package name */
    public String f2968k;

    public IconCompat() {
    }

    private IconCompat(int i2) {
        this.f2959a = i2;
    }

    private static int a(Icon icon) {
        StringBuilder sb;
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            Log.e("IconCompat", sb.toString(), e);
            return -1;
        } catch (InvocationTargetException e3) {
            e = e3;
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            Log.e("IconCompat", sb.toString(), e);
            return -1;
        } catch (NoSuchMethodException e4) {
            e = e4;
            sb = new StringBuilder();
            sb.append("Unable to get icon type ");
            sb.append(icon);
            Log.e("IconCompat", sb.toString(), e);
            return -1;
        }
    }

    static Bitmap a(Bitmap bitmap, boolean z2) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = (float) min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z2) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    public static IconCompat a(Resources resources, String str, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        } else if (i2 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f2963e = i2;
            if (resources != null) {
                try {
                    iconCompat.f2960b = resources.getResourceName(i2);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f2960b = str;
            }
            iconCompat.f2968k = str;
            return iconCompat;
        } else {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
    }

    private static String a(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    private static String b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    private static int c(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (NoSuchMethodException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    private static Uri d(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            Log.e("IconCompat", "Unable to get icon uri", e4);
            return null;
        }
    }

    public int a() {
        return (this.f2959a != -1 || Build.VERSION.SDK_INT < 23) ? this.f2959a : a((Icon) this.f2960b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r0 >= 26) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        r5 = android.graphics.drawable.Icon.createWithAdaptiveBitmap(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
        r5 = a(r5, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a2, code lost:
        r5 = android.graphics.drawable.Icon.createWithBitmap(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a6, code lost:
        r0 = r4.f2965g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a8, code lost:
        if (r0 == null) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00aa, code lost:
        r5.setTintList(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ad, code lost:
        r0 = r4.f2966i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b1, code lost:
        if (r0 == f2958h) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b3, code lost:
        r5.setTintMode(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b6, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Icon a(android.content.Context r5) {
        /*
            r4 = this;
            int r0 = r4.f2959a
            r1 = 0
            r2 = 26
            switch(r0) {
                case -1: goto L_0x00b7;
                case 0: goto L_0x0008;
                case 1: goto L_0x009e;
                case 2: goto L_0x0093;
                case 3: goto L_0x0086;
                case 4: goto L_0x007d;
                case 5: goto L_0x0067;
                case 6: goto L_0x0010;
                default: goto L_0x0008;
            }
        L_0x0008:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Unknown type"
            r5.<init>(r0)
            throw r5
        L_0x0010:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r0 < r3) goto L_0x0020
            android.net.Uri r5 = r4.d()
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithAdaptiveBitmapContentUri(r5)
            goto L_0x00a6
        L_0x0020:
            if (r5 == 0) goto L_0x004c
            java.io.InputStream r5 = r4.b((android.content.Context) r5)
            if (r5 == 0) goto L_0x0031
            int r0 = android.os.Build.VERSION.SDK_INT
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)
            if (r0 < r2) goto L_0x0078
            goto L_0x006f
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot load adaptive icon from uri: "
            r0.append(r1)
            android.net.Uri r1 = r4.d()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x004c:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
            r0.append(r1)
            android.net.Uri r1 = r4.d()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0067:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r2) goto L_0x0074
            java.lang.Object r5 = r4.f2960b
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
        L_0x006f:
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithAdaptiveBitmap(r5)
            goto L_0x00a6
        L_0x0074:
            java.lang.Object r5 = r4.f2960b
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
        L_0x0078:
            android.graphics.Bitmap r5 = a(r5, r1)
            goto L_0x00a2
        L_0x007d:
            java.lang.Object r5 = r4.f2960b
            java.lang.String r5 = (java.lang.String) r5
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithContentUri(r5)
            goto L_0x00a6
        L_0x0086:
            java.lang.Object r5 = r4.f2960b
            byte[] r5 = (byte[]) r5
            int r0 = r4.f2963e
            int r1 = r4.f2964f
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithData(r5, r0, r1)
            goto L_0x00a6
        L_0x0093:
            java.lang.String r5 = r4.b()
            int r0 = r4.f2963e
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithResource(r5, r0)
            goto L_0x00a6
        L_0x009e:
            java.lang.Object r5 = r4.f2960b
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
        L_0x00a2:
            android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithBitmap(r5)
        L_0x00a6:
            android.content.res.ColorStateList r0 = r4.f2965g
            if (r0 == 0) goto L_0x00ad
            r5.setTintList(r0)
        L_0x00ad:
            android.graphics.PorterDuff$Mode r0 = r4.f2966i
            android.graphics.PorterDuff$Mode r1 = f2958h
            if (r0 == r1) goto L_0x00b6
            r5.setTintMode(r0)
        L_0x00b6:
            return r5
        L_0x00b7:
            java.lang.Object r5 = r4.f2960b
            android.graphics.drawable.Icon r5 = (android.graphics.drawable.Icon) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.a(android.content.Context):android.graphics.drawable.Icon");
    }

    public void a(boolean z2) {
        this.f2967j = this.f2966i.name();
        switch (this.f2959a) {
            case -1:
                if (z2) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 1:
            case 5:
                if (z2) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f2960b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f2961c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f2961c = ((String) this.f2960b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2961c = (byte[]) this.f2960b;
                return;
            case 4:
            case 6:
                this.f2961c = this.f2960b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
        this.f2962d = (Parcelable) this.f2960b;
    }

    public InputStream b(Context context) {
        String str;
        StringBuilder sb;
        Uri d2 = d();
        String scheme = d2.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(d2);
            } catch (Exception e2) {
                e = e2;
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
                sb.append(str);
                sb.append(d2);
                Log.w("IconCompat", sb.toString(), e);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f2960b));
            } catch (FileNotFoundException e3) {
                e = e3;
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
                sb.append(str);
                sb.append(d2);
                Log.w("IconCompat", sb.toString(), e);
                return null;
            }
        }
    }

    public String b() {
        if (this.f2959a == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.f2960b);
        }
        if (this.f2959a == 2) {
            return TextUtils.isEmpty(this.f2968k) ? ((String) this.f2960b).split(":", -1)[0] : this.f2968k;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int c() {
        if (this.f2959a == -1 && Build.VERSION.SDK_INT >= 23) {
            return c((Icon) this.f2960b);
        }
        if (this.f2959a == 2) {
            return this.f2963e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public Uri d() {
        if (this.f2959a == -1 && Build.VERSION.SDK_INT >= 23) {
            return d((Icon) this.f2960b);
        }
        int i2 = this.f2959a;
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f2960b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    @Deprecated
    public Icon e() {
        return a((Context) null);
    }

    public void f() {
        Parcelable parcelable;
        this.f2966i = PorterDuff.Mode.valueOf(this.f2967j);
        switch (this.f2959a) {
            case -1:
                parcelable = this.f2962d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 1:
            case 5:
                parcelable = this.f2962d;
                if (parcelable == null) {
                    byte[] bArr = this.f2961c;
                    this.f2960b = bArr;
                    this.f2959a = 3;
                    this.f2963e = 0;
                    this.f2964f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f2961c, Charset.forName("UTF-16"));
                this.f2960b = str;
                if (this.f2959a == 2 && this.f2968k == null) {
                    this.f2968k = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f2960b = this.f2961c;
                return;
            default:
                return;
        }
        this.f2960b = parcelable;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f2959a
            r1 = -1
            if (r0 != r1) goto L_0x000c
            java.lang.Object r0 = r4.f2960b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L_0x000c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f2959a
            java.lang.String r1 = a((int) r1)
            r0.append(r1)
            int r1 = r4.f2959a
            switch(r1) {
                case 1: goto L_0x006a;
                case 2: goto L_0x0043;
                case 3: goto L_0x002d;
                case 4: goto L_0x0022;
                case 5: goto L_0x006a;
                case 6: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x008a
        L_0x0022:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f2960b
            r0.append(r1)
            goto L_0x008a
        L_0x002d:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f2963e
            r0.append(r1)
            int r1 = r4.f2964f
            if (r1 == 0) goto L_0x008a
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f2964f
            goto L_0x0087
        L_0x0043:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.f2968k
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r4.c()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L_0x008a
        L_0x006a:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f2960b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f2960b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
        L_0x0087:
            r0.append(r1)
        L_0x008a:
            android.content.res.ColorStateList r1 = r4.f2965g
            if (r1 == 0) goto L_0x0098
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.f2965g
            r0.append(r1)
        L_0x0098:
            android.graphics.PorterDuff$Mode r1 = r4.f2966i
            android.graphics.PorterDuff$Mode r2 = f2958h
            if (r1 == r2) goto L_0x00a8
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.f2966i
            r0.append(r1)
        L_0x00a8:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }
}
