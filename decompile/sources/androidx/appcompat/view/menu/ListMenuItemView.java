package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.af;
import t.ac;

public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, n.a {

    /* renamed from: a  reason: collision with root package name */
    private i f759a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f760b;

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f761c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f762d;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f763e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f764f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f765g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f766h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f767i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f768j;

    /* renamed from: k  reason: collision with root package name */
    private int f769k;

    /* renamed from: l  reason: collision with root package name */
    private Context f770l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f771m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f772n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f773o;

    /* renamed from: p  reason: collision with root package name */
    private LayoutInflater f774p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f775q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        af a2 = af.a(getContext(), attributeSet, R.styleable.MenuView, i2, 0);
        this.f768j = a2.a(R.styleable.MenuView_android_itemBackground);
        this.f769k = a2.g(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f771m = a2.a(R.styleable.MenuView_preserveIconSpacing, false);
        this.f770l = context;
        this.f772n = a2.a(R.styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, R.attr.dropDownListViewStyle, 0);
        this.f773o = obtainStyledAttributes.hasValue(0);
        a2.b();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        a(view, -1);
    }

    private void a(View view, int i2) {
        LinearLayout linearLayout = this.f767i;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    private void b() {
        ImageView imageView = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
        this.f760b = imageView;
        a((View) imageView, 0);
    }

    private void c() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
        this.f761c = radioButton;
        a(radioButton);
    }

    private void d() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
        this.f763e = checkBox;
        a(checkBox);
    }

    private LayoutInflater getInflater() {
        if (this.f774p == null) {
            this.f774p = LayoutInflater.from(getContext());
        }
        return this.f774p;
    }

    private void setSubMenuArrowVisible(boolean z2) {
        ImageView imageView = this.f765g;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    public void a(i iVar, int i2) {
        this.f759a = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.a((n.a) this));
        setCheckable(iVar.isCheckable());
        a(iVar.f(), iVar.d());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    public void a(boolean z2, char c2) {
        int i2 = (!z2 || !this.f759a.f()) ? 8 : 0;
        if (i2 == 0) {
            this.f764f.setText(this.f759a.e());
        }
        if (this.f764f.getVisibility() != i2) {
            this.f764f.setVisibility(i2);
        }
    }

    public boolean a() {
        return false;
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f766h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f766h.getLayoutParams();
            rect.top += this.f766h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public i getItemData() {
        return this.f759a;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ac.a((View) this, this.f768j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f762d = textView;
        int i2 = this.f769k;
        if (i2 != -1) {
            textView.setTextAppearance(this.f770l, i2);
        }
        this.f764f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f765g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f772n);
        }
        this.f766h = (ImageView) findViewById(R.id.group_divider);
        this.f767i = (LinearLayout) findViewById(R.id.content);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f760b != null && this.f771m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f760b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z2) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z2 || this.f761c != null || this.f763e != null) {
            if (this.f759a.g()) {
                if (this.f761c == null) {
                    c();
                }
                compoundButton2 = this.f761c;
                compoundButton = this.f763e;
            } else {
                if (this.f763e == null) {
                    d();
                }
                compoundButton2 = this.f763e;
                compoundButton = this.f761c;
            }
            if (z2) {
                compoundButton2.setChecked(this.f759a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f763e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f761c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton compoundButton;
        if (this.f759a.g()) {
            if (this.f761c == null) {
                c();
            }
            compoundButton = this.f761c;
        } else {
            if (this.f763e == null) {
                d();
            }
            compoundButton = this.f763e;
        }
        compoundButton.setChecked(z2);
    }

    public void setForceShowIcon(boolean z2) {
        this.f775q = z2;
        this.f771m = z2;
    }

    public void setGroupDividerEnabled(boolean z2) {
        ImageView imageView = this.f766h;
        if (imageView != null) {
            imageView.setVisibility((this.f773o || !z2) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z2 = this.f759a.i() || this.f775q;
        if (z2 || this.f771m) {
            ImageView imageView = this.f760b;
            if (imageView != null || drawable != null || this.f771m) {
                if (imageView == null) {
                    b();
                }
                if (drawable != null || this.f771m) {
                    ImageView imageView2 = this.f760b;
                    if (!z2) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.f760b.getVisibility() != 0) {
                        this.f760b.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f760b.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        int i2;
        if (charSequence != null) {
            this.f762d.setText(charSequence);
            if (this.f762d.getVisibility() != 0) {
                textView = this.f762d;
                i2 = 0;
            } else {
                return;
            }
        } else {
            i2 = 8;
            if (this.f762d.getVisibility() != 8) {
                textView = this.f762d;
            } else {
                return;
            }
        }
        textView.setVisibility(i2);
    }
}
