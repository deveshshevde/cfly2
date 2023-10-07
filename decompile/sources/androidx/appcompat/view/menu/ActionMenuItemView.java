package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ah;
import androidx.appcompat.widget.t;
import com.blankj.utilcode.constant.MemoryConstants;

public class ActionMenuItemView extends AppCompatTextView implements View.OnClickListener, n.a, ActionMenuView.a {

    /* renamed from: a  reason: collision with root package name */
    i f744a;

    /* renamed from: b  reason: collision with root package name */
    g.b f745b;

    /* renamed from: c  reason: collision with root package name */
    b f746c;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f747e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f748f;

    /* renamed from: g  reason: collision with root package name */
    private t f749g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f750h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f751i;

    /* renamed from: j  reason: collision with root package name */
    private int f752j;

    /* renamed from: k  reason: collision with root package name */
    private int f753k;

    /* renamed from: l  reason: collision with root package name */
    private int f754l;

    private class a extends t {
        public a() {
            super(ActionMenuItemView.this);
        }

        public p a() {
            if (ActionMenuItemView.this.f746c != null) {
                return ActionMenuItemView.this.f746c.a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
            r0 = a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean b() {
            /*
                r3 = this;
                androidx.appcompat.view.menu.ActionMenuItemView r0 = androidx.appcompat.view.menu.ActionMenuItemView.this
                androidx.appcompat.view.menu.g$b r0 = r0.f745b
                r1 = 0
                if (r0 == 0) goto L_0x0022
                androidx.appcompat.view.menu.ActionMenuItemView r0 = androidx.appcompat.view.menu.ActionMenuItemView.this
                androidx.appcompat.view.menu.g$b r0 = r0.f745b
                androidx.appcompat.view.menu.ActionMenuItemView r2 = androidx.appcompat.view.menu.ActionMenuItemView.this
                androidx.appcompat.view.menu.i r2 = r2.f744a
                boolean r0 = r0.a(r2)
                if (r0 == 0) goto L_0x0022
                androidx.appcompat.view.menu.p r0 = r3.a()
                if (r0 == 0) goto L_0x0022
                boolean r0 = r0.e()
                if (r0 == 0) goto L_0x0022
                r1 = 1
            L_0x0022:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ActionMenuItemView.a.b():boolean");
        }
    }

    public static abstract class b {
        public abstract p a();
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.f750h = e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i2, 0);
        this.f752j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f754l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f753k = -1;
        setSaveEnabled(false);
    }

    private boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void f() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f747e);
        if (this.f748f != null && (!this.f744a.m() || (!this.f750h && !this.f751i))) {
            z2 = false;
        }
        boolean z4 = z3 & z2;
        CharSequence charSequence = null;
        setText(z4 ? this.f747e : null);
        CharSequence contentDescription = this.f744a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z4 ? null : this.f744a.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.f744a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z4) {
                charSequence = this.f744a.getTitle();
            }
            ah.a(this, charSequence);
            return;
        }
        ah.a(this, tooltipText);
    }

    public void a(i iVar, int i2) {
        this.f744a = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.a((n.a) this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f749g == null) {
            this.f749g = new a();
        }
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    public boolean c() {
        return b() && this.f744a.getIcon() == null;
    }

    public boolean d() {
        return b();
    }

    public i getItemData() {
        return this.f744a;
    }

    public void onClick(View view) {
        g.b bVar = this.f745b;
        if (bVar != null) {
            bVar.a(this.f744a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f750h = e();
        f();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        boolean b2 = b();
        if (b2 && (i4 = this.f753k) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f752j) : this.f752j;
        if (mode != 1073741824 && this.f752j > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, MemoryConstants.GB), i3);
        }
        if (!b2 && this.f748f != null) {
            super.setPadding((getMeasuredWidth() - this.f748f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        t tVar;
        if (!this.f744a.hasSubMenu() || (tVar = this.f749g) == null || !tVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z2) {
    }

    public void setChecked(boolean z2) {
    }

    public void setExpandedFormat(boolean z2) {
        if (this.f751i != z2) {
            this.f751i = z2;
            i iVar = this.f744a;
            if (iVar != null) {
                iVar.h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f748f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.f754l;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i2) / ((float) intrinsicWidth)));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i2) / ((float) intrinsicHeight)));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        f();
    }

    public void setItemInvoker(g.b bVar) {
        this.f745b = bVar;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.f753k = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.f746c = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f747e = charSequence;
        f();
    }
}
