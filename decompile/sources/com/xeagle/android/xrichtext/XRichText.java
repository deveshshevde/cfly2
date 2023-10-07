package com.xeagle.android.xrichtext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XRichText extends TextView implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d  reason: collision with root package name */
    private static Pattern f26198d = Pattern.compile("\\<img(.*?)\\>");

    /* renamed from: e  reason: collision with root package name */
    private static Pattern f26199e = Pattern.compile("width=\"(.*?)\"");

    /* renamed from: f  reason: collision with root package name */
    private static Pattern f26200f = Pattern.compile("height=\"(.*?)\"");

    /* renamed from: g  reason: collision with root package name */
    private static Pattern f26201g = Pattern.compile("src=\"(.*?)\"");

    /* renamed from: a  reason: collision with root package name */
    a f26202a;

    /* renamed from: b  reason: collision with root package name */
    b f26203b;

    /* renamed from: c  reason: collision with root package name */
    e f26204c;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, c> f26205h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private int f26206i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f26207j = true;

    /* renamed from: com.xeagle.android.xrichtext.XRichText$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26211a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.xeagle.android.xrichtext.XRichText$Style[] r0 = com.xeagle.android.xrichtext.XRichText.Style.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26211a = r0
                com.xeagle.android.xrichtext.XRichText$Style r1 = com.xeagle.android.xrichtext.XRichText.Style.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26211a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.xrichtext.XRichText$Style r1 = com.xeagle.android.xrichtext.XRichText.Style.CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26211a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.xrichtext.XRichText$Style r1 = com.xeagle.android.xrichtext.XRichText.Style.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.xrichtext.XRichText.AnonymousClass2.<clinit>():void");
        }
    }

    public static class LinkSpan extends URLSpan {

        /* renamed from: a  reason: collision with root package name */
        private a f26212a;

        public LinkSpan(String str, a aVar) {
            super(str);
            this.f26212a = aVar;
        }

        public void onClick(View view) {
            a aVar = this.f26212a;
            if (aVar == null || !aVar.a(getURL())) {
                super.onClick(view);
            }
        }
    }

    public enum Style {
        LEFT,
        CENTER,
        RIGHT
    }

    public interface a {
        void a(c cVar);

        void a(List<String> list, int i2);

        boolean a(String str);
    }

    public interface b {
        void a();
    }

    public static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f26217a;

        /* renamed from: b  reason: collision with root package name */
        private int f26218b;

        /* renamed from: c  reason: collision with root package name */
        private int f26219c = -1;

        /* renamed from: d  reason: collision with root package name */
        private int f26220d = -1;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public Style f26221e = Style.CENTER;

        public c(String str, int i2) {
            this.f26217a = str;
            this.f26218b = i2;
        }

        public Bitmap a(Bitmap bitmap, int i2) {
            if (bitmap == null) {
                return null;
            }
            int i3 = this.f26219c;
            int i4 = this.f26220d;
            if (i3 == -1 || i4 == -1) {
                i3 = bitmap.getWidth();
                i4 = bitmap.getHeight();
            }
            if (i3 >= i2) {
                i4 = (int) (((float) i4) * ((((float) i2) * 1.0f) / ((float) i3)));
            } else {
                i2 = i3;
            }
            this.f26219c = i2;
            this.f26220d = i4;
            return d.b(bitmap, i2, i4, false);
        }

        public String a() {
            return this.f26217a;
        }

        public void a(int i2) {
            this.f26219c = i2;
        }

        public void b(int i2) {
            this.f26220d = i2;
        }
    }

    private static class d {
        private static Bitmap a(Bitmap bitmap, float f2, float f3, boolean z2) {
            if (bitmap == null) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f2, f3);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (z2 && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        }

        /* access modifiers changed from: private */
        public static Bitmap b(Bitmap bitmap, int i2, int i3, boolean z2) {
            return a(bitmap, ((float) i2) / ((float) bitmap.getWidth()), ((float) i3) / ((float) bitmap.getHeight()), z2);
        }
    }

    private class e implements Html.ImageGetter {
        private e() {
        }

        public Drawable getDrawable(String str) {
            final f fVar = new f();
            final c cVar = (c) XRichText.this.f26205h.get(str);
            if (cVar == null) {
                return null;
            }
            if (XRichText.this.f26203b == null) {
                XRichText xRichText = XRichText.this;
                xRichText.f26203b = new a(xRichText.getContext());
            }
            c.b().execute(new Runnable() {
                public void run() {
                    try {
                        final Bitmap a2 = XRichText.this.f26203b.a(cVar.a());
                        if (a2 != null) {
                            c.a().obtainMessage(100, new b() {
                                public void a() {
                                    XRichText.this.a(fVar, cVar, a2);
                                }
                            }).sendToTarget();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return fVar;
        }
    }

    public static class f extends BitmapDrawable {

        /* renamed from: a  reason: collision with root package name */
        private Bitmap f26228a;

        /* renamed from: b  reason: collision with root package name */
        private Rect f26229b;

        /* renamed from: c  reason: collision with root package name */
        private Paint f26230c = new Paint();

        public void a(Bitmap bitmap, Rect rect) {
            this.f26228a = bitmap;
            this.f26229b = rect;
        }

        public void draw(Canvas canvas) {
            Bitmap bitmap = this.f26228a;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (float) this.f26229b.left, (float) this.f26229b.top, this.f26230c);
            }
        }
    }

    public XRichText(Context context) {
        super(context);
    }

    public XRichText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XRichText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private void b(f fVar, c cVar, Bitmap bitmap) {
        if (bitmap.getWidth() <= this.f26206i) {
            Rect rect = null;
            int i2 = AnonymousClass2.f26211a[cVar.f26221e.ordinal()];
            if (i2 == 1) {
                rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            } else if (i2 == 2) {
                int width = (this.f26206i - bitmap.getWidth()) / 2;
                if (width < 0) {
                    width = 0;
                }
                rect = new Rect(width, 0, bitmap.getWidth() + width, bitmap.getHeight());
            } else if (i2 == 3) {
                int width2 = this.f26206i - bitmap.getWidth();
                if (width2 < 0) {
                    width2 = 0;
                }
                rect = new Rect(width2, 0, this.f26206i, bitmap.getHeight());
            }
            fVar.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            fVar.a(bitmap, rect);
            setText(getText());
        }
    }

    private void b(String str) {
        Matcher matcher = f26198d.matcher(str);
        int i2 = 0;
        while (matcher.find()) {
            String trim = matcher.group().trim();
            Matcher matcher2 = f26201g.matcher(trim);
            String str2 = null;
            if (matcher2.find()) {
                str2 = c(matcher2.group().trim().substring(4));
            }
            if (!TextUtils.isEmpty(str2)) {
                c cVar = new c(str2, i2);
                Matcher matcher3 = f26199e.matcher(trim);
                if (matcher3.find()) {
                    cVar.a(d(c(matcher3.group().trim().substring(6))));
                }
                Matcher matcher4 = f26200f.matcher(trim);
                if (matcher4.find()) {
                    cVar.b(d(c(matcher4.group().trim().substring(6))));
                }
                this.f26205h.put(cVar.f26217a, cVar);
                i2++;
            }
        }
    }

    private static String c(String str) {
        Matcher matcher = Pattern.compile("\"(.*?)\"").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private int d(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public void a(f fVar, c cVar, Bitmap bitmap) {
        if (fVar != null && cVar != null && bitmap != null && this.f26206i > 0) {
            a aVar = this.f26202a;
            if (aVar != null) {
                aVar.a(cVar);
            }
            Bitmap a2 = cVar.a(bitmap, this.f26206i);
            if (a2 != null) {
                b(fVar, cVar, a2);
            }
        }
    }

    public void a(String str) {
        b(str);
        if (this.f26204c == null) {
            this.f26204c = new e();
        }
        Spanned fromHtml = Html.fromHtml(str, this.f26204c, (Html.TagHandler) null);
        SpannableStringBuilder spannableStringBuilder = fromHtml instanceof SpannableStringBuilder ? (SpannableStringBuilder) fromHtml : new SpannableStringBuilder(fromHtml);
        ImageSpan[] imageSpanArr = (ImageSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ImageSpan.class);
        final ArrayList arrayList = new ArrayList();
        int length = imageSpanArr.length;
        for (final int i2 = 0; i2 < length; i2++) {
            ImageSpan imageSpan = imageSpanArr[i2];
            String source = imageSpan.getSource();
            int spanStart = spannableStringBuilder.getSpanStart(imageSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(imageSpan);
            arrayList.add(source);
            AnonymousClass1 r8 = new ClickableSpan() {
                public void onClick(View view) {
                    if (XRichText.this.f26202a != null) {
                        XRichText.this.f26202a.a((ArrayList) arrayList, i2);
                    }
                }
            };
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannableStringBuilder.getSpans(spanStart, spanEnd, ClickableSpan.class);
            if (!(clickableSpanArr == null || clickableSpanArr.length == 0)) {
                for (ClickableSpan removeSpan : clickableSpanArr) {
                    spannableStringBuilder.removeSpan(removeSpan);
                }
            }
            spannableStringBuilder.setSpan(r8, spanStart, spanEnd, 33);
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
        int length2 = uRLSpanArr == null ? 0 : uRLSpanArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            URLSpan uRLSpan = uRLSpanArr[i3];
            int spanStart2 = spannableStringBuilder.getSpanStart(uRLSpan);
            int spanEnd2 = spannableStringBuilder.getSpanEnd(uRLSpan);
            spannableStringBuilder.removeSpan(uRLSpan);
            spannableStringBuilder.setSpan(new LinkSpan(uRLSpan.getURL(), this.f26202a), spanStart2, spanEnd2, 33);
        }
        super.setText(fromHtml);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public void onGlobalLayout() {
        if (this.f26207j) {
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            this.f26206i = width;
            if (width > 0) {
                this.f26207j = false;
            }
        }
    }
}
