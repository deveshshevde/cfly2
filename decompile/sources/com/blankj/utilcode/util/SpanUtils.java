package com.blankj.utilcode.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.b;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Objects;

public final class SpanUtils {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    public static final int ALIGN_TOP = 3;
    private static final int COLOR_DEFAULT = -16777217;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private int alignImage;
    private int alignLine;
    private Layout.Alignment alignment;
    private int backgroundColor;
    private float blurRadius;
    private int bulletColor;
    private int bulletGapWidth;
    private int bulletRadius;
    private ClickableSpan clickSpan;
    private int first;
    private int flag;
    private String fontFamily;
    private int fontSize;
    private boolean fontSizeIsDp;
    private int foregroundColor;
    private Bitmap imageBitmap;
    private Drawable imageDrawable;
    private int imageResourceId;
    private Uri imageUri;
    private boolean isBold;
    private boolean isBoldItalic;
    private boolean isCreated;
    private boolean isItalic;
    private boolean isStrikethrough;
    private boolean isSubscript;
    private boolean isSuperscript;
    private boolean isUnderline;
    private int lineHeight;
    private SerializableSpannableStringBuilder mBuilder;
    private CharSequence mText;
    private TextView mTextView;
    private int mType;
    private final int mTypeCharSequence;
    private final int mTypeImage;
    private final int mTypeSpace;
    private float proportion;
    private int quoteColor;
    private int quoteGapWidth;
    private int rest;
    private Shader shader;
    private int shadowColor;
    private float shadowDx;
    private float shadowDy;
    private float shadowRadius;
    private int spaceColor;
    private int spaceSize;
    private Object[] spans;
    private int stripeWidth;
    private BlurMaskFilter.Blur style;
    private Typeface typeface;
    private String url;
    private int verticalAlign;
    private float xProportion;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Align {
    }

    static class CustomBulletSpan implements LeadingMarginSpan {
        private final int color;
        private final int gapWidth;
        private final int radius;
        private Path sBulletPath;

        private CustomBulletSpan(int i2, int i3, int i4) {
            this.sBulletPath = null;
            this.color = i2;
            this.radius = i3;
            this.gapWidth = i4;
        }

        public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z2, Layout layout) {
            if (((Spanned) charSequence).getSpanStart(this) == i7) {
                Paint.Style style = paint.getStyle();
                int color2 = paint.getColor();
                paint.setColor(this.color);
                paint.setStyle(Paint.Style.FILL);
                if (canvas.isHardwareAccelerated()) {
                    if (this.sBulletPath == null) {
                        Path path = new Path();
                        this.sBulletPath = path;
                        path.addCircle(0.0f, 0.0f, (float) this.radius, Path.Direction.CW);
                    }
                    canvas.save();
                    canvas.translate((float) (i2 + (i3 * this.radius)), ((float) (i4 + i6)) / 2.0f);
                    canvas.drawPath(this.sBulletPath, paint);
                    canvas.restore();
                } else {
                    int i9 = this.radius;
                    canvas.drawCircle((float) (i2 + (i3 * i9)), ((float) (i4 + i6)) / 2.0f, (float) i9, paint);
                }
                paint.setColor(color2);
                paint.setStyle(style);
            }
        }

        public int getLeadingMargin(boolean z2) {
            return (this.radius * 2) + this.gapWidth;
        }
    }

    static abstract class CustomDynamicDrawableSpan extends ReplacementSpan {
        static final int ALIGN_BASELINE = 1;
        static final int ALIGN_BOTTOM = 0;
        static final int ALIGN_CENTER = 2;
        static final int ALIGN_TOP = 3;
        private WeakReference<Drawable> mDrawableRef;
        final int mVerticalAlignment;

        private CustomDynamicDrawableSpan() {
            this.mVerticalAlignment = 0;
        }

        private CustomDynamicDrawableSpan(int i2) {
            this.mVerticalAlignment = i2;
        }

        private Drawable getCachedDrawable() {
            WeakReference<Drawable> weakReference = this.mDrawableRef;
            Drawable drawable = weakReference != null ? (Drawable) weakReference.get() : null;
            if (drawable != null) {
                return drawable;
            }
            Drawable drawable2 = getDrawable();
            this.mDrawableRef = new WeakReference<>(drawable2);
            return drawable2;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
            float f3;
            int i7;
            int i8;
            Objects.requireNonNull(canvas, "Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Drawable cachedDrawable = getCachedDrawable();
            Rect bounds = cachedDrawable.getBounds();
            canvas.save();
            if (bounds.height() >= i6 - i4 || (i7 = this.mVerticalAlignment) == 3) {
                f3 = (float) i4;
            } else {
                if (i7 == 2) {
                    i8 = ((i6 + i4) - bounds.height()) / 2;
                } else {
                    int height = bounds.height();
                    if (i7 == 1) {
                        f3 = (float) (i5 - height);
                    } else {
                        i8 = i6 - height;
                    }
                }
                f3 = (float) i8;
            }
            canvas.translate(f2, f3);
            cachedDrawable.draw(canvas);
            canvas.restore();
        }

        public abstract Drawable getDrawable();

        public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
            int i4;
            int i5;
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Rect bounds = getCachedDrawable().getBounds();
            if (fontMetricsInt != null && (i4 = fontMetricsInt.bottom - fontMetricsInt.top) < bounds.height()) {
                int i6 = this.mVerticalAlignment;
                if (i6 == 3) {
                    fontMetricsInt.top = fontMetricsInt.top;
                    i5 = bounds.height() + fontMetricsInt.top;
                } else if (i6 == 2) {
                    int i7 = i4 / 4;
                    fontMetricsInt.top = ((-bounds.height()) / 2) - i7;
                    fontMetricsInt.bottom = (bounds.height() / 2) - i7;
                    fontMetricsInt.ascent = fontMetricsInt.top;
                    fontMetricsInt.descent = fontMetricsInt.bottom;
                } else {
                    fontMetricsInt.top = (-bounds.height()) + fontMetricsInt.bottom;
                    i5 = fontMetricsInt.bottom;
                }
                fontMetricsInt.bottom = i5;
                fontMetricsInt.ascent = fontMetricsInt.top;
                fontMetricsInt.descent = fontMetricsInt.bottom;
            }
            return bounds.right;
        }
    }

    static class CustomImageSpan extends CustomDynamicDrawableSpan {
        private Uri mContentUri;
        private Drawable mDrawable;
        private int mResourceId;

        private CustomImageSpan(int i2, int i3) {
            super(i3);
            this.mResourceId = i2;
        }

        private CustomImageSpan(Bitmap bitmap, int i2) {
            super(i2);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(Utils.getApp().getResources(), bitmap);
            this.mDrawable = bitmapDrawable;
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
        }

        private CustomImageSpan(Drawable drawable, int i2) {
            super(i2);
            this.mDrawable = drawable;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
        }

        private CustomImageSpan(Uri uri, int i2) {
            super(i2);
            this.mContentUri = uri;
        }

        public Drawable getDrawable() {
            Drawable drawable;
            Drawable drawable2 = this.mDrawable;
            if (drawable2 != null) {
                return drawable2;
            }
            BitmapDrawable bitmapDrawable = null;
            if (this.mContentUri != null) {
                try {
                    InputStream openInputStream = Utils.getApp().getContentResolver().openInputStream(this.mContentUri);
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(Utils.getApp().getResources(), BitmapFactory.decodeStream(openInputStream));
                    try {
                        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
                        if (openInputStream != null) {
                            openInputStream.close();
                        }
                        return bitmapDrawable2;
                    } catch (Exception e2) {
                        e = e2;
                        bitmapDrawable = bitmapDrawable2;
                        Log.e("sms", "Failed to loaded content " + this.mContentUri, e);
                        return bitmapDrawable;
                    }
                } catch (Exception e3) {
                    e = e3;
                    Log.e("sms", "Failed to loaded content " + this.mContentUri, e);
                    return bitmapDrawable;
                }
            } else {
                try {
                    drawable = b.a((Context) Utils.getApp(), this.mResourceId);
                    try {
                        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                        return drawable;
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    drawable = null;
                    Log.e("sms", "Unable to find resource: " + this.mResourceId);
                    return drawable;
                }
            }
        }
    }

    static class CustomLineHeightSpan implements LineHeightSpan {
        static final int ALIGN_CENTER = 2;
        static final int ALIGN_TOP = 3;
        static Paint.FontMetricsInt sfm;
        private final int height;
        final int mVerticalAlignment;

        CustomLineHeightSpan(int i2, int i3) {
            this.height = i2;
            this.mVerticalAlignment = i3;
        }

        public void chooseHeight(CharSequence charSequence, int i2, int i3, int i4, int i5, Paint.FontMetricsInt fontMetricsInt) {
            Paint.FontMetricsInt fontMetricsInt2 = sfm;
            if (fontMetricsInt2 == null) {
                Paint.FontMetricsInt fontMetricsInt3 = new Paint.FontMetricsInt();
                sfm = fontMetricsInt3;
                fontMetricsInt3.top = fontMetricsInt.top;
                sfm.ascent = fontMetricsInt.ascent;
                sfm.descent = fontMetricsInt.descent;
                sfm.bottom = fontMetricsInt.bottom;
                sfm.leading = fontMetricsInt.leading;
            } else {
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.ascent = sfm.ascent;
                fontMetricsInt.descent = sfm.descent;
                fontMetricsInt.bottom = sfm.bottom;
                fontMetricsInt.leading = sfm.leading;
            }
            int i6 = this.height - (((fontMetricsInt.descent + i5) - fontMetricsInt.ascent) - i4);
            if (i6 > 0) {
                int i7 = this.mVerticalAlignment;
                if (i7 == 3) {
                    fontMetricsInt.descent += i6;
                } else {
                    if (i7 == 2) {
                        i6 /= 2;
                        fontMetricsInt.descent += i6;
                    }
                    fontMetricsInt.ascent -= i6;
                }
            }
            int i8 = this.height - (((i5 + fontMetricsInt.bottom) - fontMetricsInt.top) - i4);
            if (i8 > 0) {
                int i9 = this.mVerticalAlignment;
                if (i9 == 3) {
                    fontMetricsInt.bottom += i8;
                } else {
                    if (i9 == 2) {
                        i8 /= 2;
                        fontMetricsInt.bottom += i8;
                    }
                    fontMetricsInt.top -= i8;
                }
            }
            if (i3 == ((Spanned) charSequence).getSpanEnd(this)) {
                sfm = null;
            }
        }
    }

    static class CustomQuoteSpan implements LeadingMarginSpan {
        private final int color;
        private final int gapWidth;
        private final int stripeWidth;

        private CustomQuoteSpan(int i2, int i3, int i4) {
            this.color = i2;
            this.stripeWidth = i3;
            this.gapWidth = i4;
        }

        public void drawLeadingMargin(Canvas canvas, Paint paint, int i2, int i3, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z2, Layout layout) {
            Paint paint2 = paint;
            int i9 = i2;
            Paint.Style style = paint.getStyle();
            int color2 = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.color);
            canvas.drawRect((float) i9, (float) i4, (float) (i9 + (this.stripeWidth * i3)), (float) i6, paint);
            paint.setStyle(style);
            paint.setColor(color2);
        }

        public int getLeadingMargin(boolean z2) {
            return this.stripeWidth + this.gapWidth;
        }
    }

    static class CustomTypefaceSpan extends TypefaceSpan {
        private final Typeface newType;

        private CustomTypefaceSpan(Typeface typeface) {
            super("");
            this.newType = typeface;
        }

        private void apply(Paint paint, Typeface typeface) {
            Typeface typeface2 = paint.getTypeface();
            int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (typeface.getStyle() ^ -1);
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.getShader();
            paint.setTypeface(typeface);
        }

        public void updateDrawState(TextPaint textPaint) {
            apply(textPaint, this.newType);
        }

        public void updateMeasureState(TextPaint textPaint) {
            apply(textPaint, this.newType);
        }
    }

    private static class SerializableSpannableStringBuilder extends SpannableStringBuilder implements Serializable {
        private static final long serialVersionUID = 4909567650765875771L;

        private SerializableSpannableStringBuilder() {
        }
    }

    static class ShaderSpan extends CharacterStyle implements UpdateAppearance {
        private Shader mShader;

        private ShaderSpan(Shader shader) {
            this.mShader = shader;
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShader(this.mShader);
        }
    }

    static class ShadowSpan extends CharacterStyle implements UpdateAppearance {

        /* renamed from: dx  reason: collision with root package name */
        private float f10024dx;

        /* renamed from: dy  reason: collision with root package name */
        private float f10025dy;
        private float radius;
        private int shadowColor;

        private ShadowSpan(float f2, float f3, float f4, int i2) {
            this.radius = f2;
            this.f10024dx = f3;
            this.f10025dy = f4;
            this.shadowColor = i2;
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShadowLayer(this.radius, this.f10024dx, this.f10025dy, this.shadowColor);
        }
    }

    static class SpaceSpan extends ReplacementSpan {
        private final Paint paint;
        private final int width;

        private SpaceSpan(int i2) {
            this(i2, 0);
        }

        private SpaceSpan(int i2, int i3) {
            Paint paint2 = new Paint();
            this.paint = paint2;
            this.width = i2;
            paint2.setColor(i3);
            paint2.setStyle(Paint.Style.FILL);
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint2) {
            Objects.requireNonNull(canvas, "Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(paint2, "Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            canvas.drawRect(f2, (float) i4, f2 + ((float) this.width), (float) i6, this.paint);
        }

        public int getSize(Paint paint2, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
            Objects.requireNonNull(paint2, "Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            return this.width;
        }
    }

    static class VerticalAlignSpan extends ReplacementSpan {
        static final int ALIGN_CENTER = 2;
        static final int ALIGN_TOP = 3;
        final int mVerticalAlignment;

        VerticalAlignSpan(int i2) {
            this.mVerticalAlignment = i2;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
            Objects.requireNonNull(canvas, "Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            CharSequence subSequence = charSequence.subSequence(i2, i3);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.drawText(subSequence.toString(), f2, (float) (i5 - (((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - ((i6 + i4) / 2))), paint);
        }

        public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            return (int) paint.measureText(charSequence.subSequence(i2, i3).toString());
        }
    }

    public SpanUtils() {
        this.mTypeCharSequence = 0;
        this.mTypeImage = 1;
        this.mTypeSpace = 2;
        this.mBuilder = new SerializableSpannableStringBuilder();
        this.mText = "";
        this.mType = -1;
        setDefault();
    }

    private SpanUtils(TextView textView) {
        this();
        this.mTextView = textView;
    }

    private void apply(int i2) {
        applyLast();
        this.mType = i2;
    }

    private void applyLast() {
        if (!this.isCreated) {
            int i2 = this.mType;
            if (i2 == 0) {
                updateCharCharSequence();
            } else if (i2 == 1) {
                updateImage();
            } else if (i2 == 2) {
                updateSpace();
            }
            setDefault();
        }
    }

    private void setDefault() {
        this.flag = 33;
        this.foregroundColor = COLOR_DEFAULT;
        this.backgroundColor = COLOR_DEFAULT;
        this.lineHeight = -1;
        this.quoteColor = COLOR_DEFAULT;
        this.first = -1;
        this.bulletColor = COLOR_DEFAULT;
        this.fontSize = -1;
        this.proportion = -1.0f;
        this.xProportion = -1.0f;
        this.isStrikethrough = false;
        this.isUnderline = false;
        this.isSuperscript = false;
        this.isSubscript = false;
        this.isBold = false;
        this.isItalic = false;
        this.isBoldItalic = false;
        this.fontFamily = null;
        this.typeface = null;
        this.alignment = null;
        this.verticalAlign = -1;
        this.clickSpan = null;
        this.url = null;
        this.blurRadius = -1.0f;
        this.shader = null;
        this.shadowRadius = -1.0f;
        this.spans = null;
        this.imageBitmap = null;
        this.imageDrawable = null;
        this.imageUri = null;
        this.imageResourceId = -1;
        this.spaceSize = -1;
    }

    private void setMovementMethodIfNeed() {
        TextView textView = this.mTextView;
        if (textView != null && textView.getMovementMethod() == null) {
            this.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private void updateCharCharSequence() {
        if (this.mText.length() != 0) {
            int length = this.mBuilder.length();
            if (length == 0 && this.lineHeight != -1) {
                this.mBuilder.append(Character.toString(2)).append("\n").setSpan(new AbsoluteSizeSpan(0), 0, 2, 33);
                length = 2;
            }
            this.mBuilder.append(this.mText);
            int length2 = this.mBuilder.length();
            if (this.verticalAlign != -1) {
                this.mBuilder.setSpan(new VerticalAlignSpan(this.verticalAlign), length, length2, this.flag);
            }
            if (this.foregroundColor != COLOR_DEFAULT) {
                this.mBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), length, length2, this.flag);
            }
            if (this.backgroundColor != COLOR_DEFAULT) {
                this.mBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), length, length2, this.flag);
            }
            if (this.first != -1) {
                this.mBuilder.setSpan(new LeadingMarginSpan.Standard(this.first, this.rest), length, length2, this.flag);
            }
            int i2 = this.quoteColor;
            if (i2 != COLOR_DEFAULT) {
                this.mBuilder.setSpan(new CustomQuoteSpan(i2, this.stripeWidth, this.quoteGapWidth), length, length2, this.flag);
            }
            int i3 = this.bulletColor;
            if (i3 != COLOR_DEFAULT) {
                this.mBuilder.setSpan(new CustomBulletSpan(i3, this.bulletRadius, this.bulletGapWidth), length, length2, this.flag);
            }
            if (this.fontSize != -1) {
                this.mBuilder.setSpan(new AbsoluteSizeSpan(this.fontSize, this.fontSizeIsDp), length, length2, this.flag);
            }
            if (this.proportion != -1.0f) {
                this.mBuilder.setSpan(new RelativeSizeSpan(this.proportion), length, length2, this.flag);
            }
            if (this.xProportion != -1.0f) {
                this.mBuilder.setSpan(new ScaleXSpan(this.xProportion), length, length2, this.flag);
            }
            int i4 = this.lineHeight;
            if (i4 != -1) {
                this.mBuilder.setSpan(new CustomLineHeightSpan(i4, this.alignLine), length, length2, this.flag);
            }
            if (this.isStrikethrough) {
                this.mBuilder.setSpan(new StrikethroughSpan(), length, length2, this.flag);
            }
            if (this.isUnderline) {
                this.mBuilder.setSpan(new UnderlineSpan(), length, length2, this.flag);
            }
            if (this.isSuperscript) {
                this.mBuilder.setSpan(new SuperscriptSpan(), length, length2, this.flag);
            }
            if (this.isSubscript) {
                this.mBuilder.setSpan(new SubscriptSpan(), length, length2, this.flag);
            }
            if (this.isBold) {
                this.mBuilder.setSpan(new StyleSpan(1), length, length2, this.flag);
            }
            if (this.isItalic) {
                this.mBuilder.setSpan(new StyleSpan(2), length, length2, this.flag);
            }
            if (this.isBoldItalic) {
                this.mBuilder.setSpan(new StyleSpan(3), length, length2, this.flag);
            }
            if (this.fontFamily != null) {
                this.mBuilder.setSpan(new TypefaceSpan(this.fontFamily), length, length2, this.flag);
            }
            if (this.typeface != null) {
                this.mBuilder.setSpan(new CustomTypefaceSpan(this.typeface), length, length2, this.flag);
            }
            if (this.alignment != null) {
                this.mBuilder.setSpan(new AlignmentSpan.Standard(this.alignment), length, length2, this.flag);
            }
            ClickableSpan clickableSpan = this.clickSpan;
            if (clickableSpan != null) {
                this.mBuilder.setSpan(clickableSpan, length, length2, this.flag);
            }
            if (this.url != null) {
                this.mBuilder.setSpan(new URLSpan(this.url), length, length2, this.flag);
            }
            if (this.blurRadius != -1.0f) {
                this.mBuilder.setSpan(new MaskFilterSpan(new BlurMaskFilter(this.blurRadius, this.style)), length, length2, this.flag);
            }
            if (this.shader != null) {
                this.mBuilder.setSpan(new ShaderSpan(this.shader), length, length2, this.flag);
            }
            if (this.shadowRadius != -1.0f) {
                this.mBuilder.setSpan(new ShadowSpan(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor), length, length2, this.flag);
            }
            Object[] objArr = this.spans;
            if (objArr != null) {
                for (Object span : objArr) {
                    this.mBuilder.setSpan(span, length, length2, this.flag);
                }
            }
        }
    }

    private void updateImage() {
        SerializableSpannableStringBuilder serializableSpannableStringBuilder;
        CustomImageSpan customImageSpan;
        int length = this.mBuilder.length();
        this.mText = "<img>";
        updateCharCharSequence();
        int length2 = this.mBuilder.length();
        if (this.imageBitmap != null) {
            serializableSpannableStringBuilder = this.mBuilder;
            customImageSpan = new CustomImageSpan(this.imageBitmap, this.alignImage);
        } else if (this.imageDrawable != null) {
            serializableSpannableStringBuilder = this.mBuilder;
            customImageSpan = new CustomImageSpan(this.imageDrawable, this.alignImage);
        } else if (this.imageUri != null) {
            serializableSpannableStringBuilder = this.mBuilder;
            customImageSpan = new CustomImageSpan(this.imageUri, this.alignImage);
        } else if (this.imageResourceId != -1) {
            serializableSpannableStringBuilder = this.mBuilder;
            customImageSpan = new CustomImageSpan(this.imageResourceId, this.alignImage);
        } else {
            return;
        }
        serializableSpannableStringBuilder.setSpan(customImageSpan, length, length2, this.flag);
    }

    private void updateSpace() {
        int length = this.mBuilder.length();
        this.mText = "< >";
        updateCharCharSequence();
        this.mBuilder.setSpan(new SpaceSpan(this.spaceSize, this.spaceColor), length, this.mBuilder.length(), this.flag);
    }

    public static SpanUtils with(TextView textView) {
        return new SpanUtils(textView);
    }

    public SpanUtils append(CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "Argument 'text' of type CharSequence (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        apply(0);
        this.mText = charSequence;
        return this;
    }

    public SpanUtils appendImage(int i2) {
        return appendImage(i2, 0);
    }

    public SpanUtils appendImage(int i2, int i3) {
        apply(1);
        this.imageResourceId = i2;
        this.alignImage = i3;
        return this;
    }

    public SpanUtils appendImage(Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "Argument 'bitmap' of type Bitmap (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return appendImage(bitmap, 0);
    }

    public SpanUtils appendImage(Bitmap bitmap, int i2) {
        Objects.requireNonNull(bitmap, "Argument 'bitmap' of type Bitmap (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        apply(1);
        this.imageBitmap = bitmap;
        this.alignImage = i2;
        return this;
    }

    public SpanUtils appendImage(Drawable drawable) {
        Objects.requireNonNull(drawable, "Argument 'drawable' of type Drawable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return appendImage(drawable, 0);
    }

    public SpanUtils appendImage(Drawable drawable, int i2) {
        Objects.requireNonNull(drawable, "Argument 'drawable' of type Drawable (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        apply(1);
        this.imageDrawable = drawable;
        this.alignImage = i2;
        return this;
    }

    public SpanUtils appendImage(Uri uri) {
        Objects.requireNonNull(uri, "Argument 'uri' of type Uri (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return appendImage(uri, 0);
    }

    public SpanUtils appendImage(Uri uri, int i2) {
        Objects.requireNonNull(uri, "Argument 'uri' of type Uri (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        apply(1);
        this.imageUri = uri;
        this.alignImage = i2;
        return this;
    }

    public SpanUtils appendLine() {
        apply(0);
        this.mText = LINE_SEPARATOR;
        return this;
    }

    public SpanUtils appendLine(CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "Argument 'text' of type CharSequence (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        apply(0);
        this.mText = charSequence + LINE_SEPARATOR;
        return this;
    }

    public SpanUtils appendSpace(int i2) {
        return appendSpace(i2, 0);
    }

    public SpanUtils appendSpace(int i2, int i3) {
        apply(2);
        this.spaceSize = i2;
        this.spaceColor = i3;
        return this;
    }

    public SpannableStringBuilder create() {
        applyLast();
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(this.mBuilder);
        }
        this.isCreated = true;
        return this.mBuilder;
    }

    public SpannableStringBuilder get() {
        return this.mBuilder;
    }

    public SpanUtils setBackgroundColor(int i2) {
        this.backgroundColor = i2;
        return this;
    }

    public SpanUtils setBlur(float f2, BlurMaskFilter.Blur blur) {
        this.blurRadius = f2;
        this.style = blur;
        return this;
    }

    public SpanUtils setBold() {
        this.isBold = true;
        return this;
    }

    public SpanUtils setBoldItalic() {
        this.isBoldItalic = true;
        return this;
    }

    public SpanUtils setBullet(int i2) {
        return setBullet(0, 3, i2);
    }

    public SpanUtils setBullet(int i2, int i3, int i4) {
        this.bulletColor = i2;
        this.bulletRadius = i3;
        this.bulletGapWidth = i4;
        return this;
    }

    public SpanUtils setClickSpan(final int i2, final boolean z2, final View.OnClickListener onClickListener) {
        setMovementMethodIfNeed();
        this.clickSpan = new ClickableSpan() {
            public void onClick(View view) {
                Objects.requireNonNull(view, "Argument 'widget' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                Objects.requireNonNull(textPaint, "Argument 'paint' of type TextPaint (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                textPaint.setColor(i2);
                textPaint.setUnderlineText(z2);
            }
        };
        return this;
    }

    public SpanUtils setClickSpan(ClickableSpan clickableSpan) {
        Objects.requireNonNull(clickableSpan, "Argument 'clickSpan' of type ClickableSpan (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        setMovementMethodIfNeed();
        this.clickSpan = clickableSpan;
        return this;
    }

    public SpanUtils setFlag(int i2) {
        this.flag = i2;
        return this;
    }

    public SpanUtils setFontFamily(String str) {
        Objects.requireNonNull(str, "Argument 'fontFamily' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.fontFamily = str;
        return this;
    }

    public SpanUtils setFontProportion(float f2) {
        this.proportion = f2;
        return this;
    }

    public SpanUtils setFontSize(int i2) {
        return setFontSize(i2, false);
    }

    public SpanUtils setFontSize(int i2, boolean z2) {
        this.fontSize = i2;
        this.fontSizeIsDp = z2;
        return this;
    }

    public SpanUtils setFontXProportion(float f2) {
        this.xProportion = f2;
        return this;
    }

    public SpanUtils setForegroundColor(int i2) {
        this.foregroundColor = i2;
        return this;
    }

    public SpanUtils setHorizontalAlign(Layout.Alignment alignment2) {
        Objects.requireNonNull(alignment2, "Argument 'alignment' of type Alignment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.alignment = alignment2;
        return this;
    }

    public SpanUtils setItalic() {
        this.isItalic = true;
        return this;
    }

    public SpanUtils setLeadingMargin(int i2, int i3) {
        this.first = i2;
        this.rest = i3;
        return this;
    }

    public SpanUtils setLineHeight(int i2) {
        return setLineHeight(i2, 2);
    }

    public SpanUtils setLineHeight(int i2, int i3) {
        this.lineHeight = i2;
        this.alignLine = i3;
        return this;
    }

    public SpanUtils setQuoteColor(int i2) {
        return setQuoteColor(i2, 2, 2);
    }

    public SpanUtils setQuoteColor(int i2, int i3, int i4) {
        this.quoteColor = i2;
        this.stripeWidth = i3;
        this.quoteGapWidth = i4;
        return this;
    }

    public SpanUtils setShader(Shader shader2) {
        Objects.requireNonNull(shader2, "Argument 'shader' of type Shader (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.shader = shader2;
        return this;
    }

    public SpanUtils setShadow(float f2, float f3, float f4, int i2) {
        this.shadowRadius = f2;
        this.shadowDx = f3;
        this.shadowDy = f4;
        this.shadowColor = i2;
        return this;
    }

    public SpanUtils setSpans(Object... objArr) {
        Objects.requireNonNull(objArr, "Argument 'spans' of type Object[] (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (objArr.length > 0) {
            this.spans = objArr;
        }
        return this;
    }

    public SpanUtils setStrikethrough() {
        this.isStrikethrough = true;
        return this;
    }

    public SpanUtils setSubscript() {
        this.isSubscript = true;
        return this;
    }

    public SpanUtils setSuperscript() {
        this.isSuperscript = true;
        return this;
    }

    public SpanUtils setTypeface(Typeface typeface2) {
        Objects.requireNonNull(typeface2, "Argument 'typeface' of type Typeface (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.typeface = typeface2;
        return this;
    }

    public SpanUtils setUnderline() {
        this.isUnderline = true;
        return this;
    }

    public SpanUtils setUrl(String str) {
        Objects.requireNonNull(str, "Argument 'url' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        setMovementMethodIfNeed();
        this.url = str;
        return this;
    }

    public SpanUtils setVerticalAlign(int i2) {
        this.verticalAlign = i2;
        return this;
    }
}
