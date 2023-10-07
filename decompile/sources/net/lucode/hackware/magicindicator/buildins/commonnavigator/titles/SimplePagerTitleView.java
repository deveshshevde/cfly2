package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import mz.b;

public class SimplePagerTitleView extends TextView implements b {

    /* renamed from: a  reason: collision with root package name */
    protected int f31526a;

    /* renamed from: b  reason: collision with root package name */
    protected int f31527b;

    public SimplePagerTitleView(Context context) {
        super(context, (AttributeSet) null);
        a(context);
    }

    private void a(Context context) {
        setGravity(17);
        int a2 = my.b.a(context, 10.0d);
        setPadding(a2, 0, a2, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public void a(int i2, int i3) {
        setTextColor(this.f31526a);
    }

    public void a(int i2, int i3, float f2, boolean z2) {
    }

    public void b(int i2, int i3) {
        setTextColor(this.f31527b);
    }

    public void b(int i2, int i3, float f2, boolean z2) {
    }

    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getContentLeft() {
        String str;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            str = "";
            for (String str2 : getText().toString().split("\\n")) {
                if (str2.length() > str.length()) {
                    str = str2;
                }
            }
        } else {
            str = getText().toString();
        }
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    public int getContentRight() {
        String str;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            str = "";
            for (String str2 : getText().toString().split("\\n")) {
                if (str2.length() > str.length()) {
                    str = str2;
                }
            }
        } else {
            str = getText().toString();
        }
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getNormalColor() {
        return this.f31527b;
    }

    public int getSelectedColor() {
        return this.f31526a;
    }

    public void setNormalColor(int i2) {
        this.f31527b = i2;
    }

    public void setSelectedColor(int i2) {
        this.f31526a = i2;
    }
}
