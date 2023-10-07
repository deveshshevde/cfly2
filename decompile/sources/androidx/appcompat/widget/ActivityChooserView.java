package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.p;
import com.blankj.utilcode.constant.MemoryConstants;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import t.ac;
import u.c;

public class ActivityChooserView extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    final a f1074a;

    /* renamed from: b  reason: collision with root package name */
    final FrameLayout f1075b;

    /* renamed from: c  reason: collision with root package name */
    final FrameLayout f1076c;

    /* renamed from: d  reason: collision with root package name */
    t.b f1077d;

    /* renamed from: e  reason: collision with root package name */
    final DataSetObserver f1078e;

    /* renamed from: f  reason: collision with root package name */
    PopupWindow.OnDismissListener f1079f;

    /* renamed from: g  reason: collision with root package name */
    boolean f1080g;

    /* renamed from: h  reason: collision with root package name */
    int f1081h;

    /* renamed from: i  reason: collision with root package name */
    private final b f1082i;

    /* renamed from: j  reason: collision with root package name */
    private final View f1083j;

    /* renamed from: k  reason: collision with root package name */
    private final Drawable f1084k;

    /* renamed from: l  reason: collision with root package name */
    private final ImageView f1085l;

    /* renamed from: m  reason: collision with root package name */
    private final ImageView f1086m;

    /* renamed from: n  reason: collision with root package name */
    private final int f1087n;

    /* renamed from: o  reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f1088o;

    /* renamed from: p  reason: collision with root package name */
    private ListPopupWindow f1089p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1090q;

    /* renamed from: r  reason: collision with root package name */
    private int f1091r;

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f1097a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            af a2 = af.a(context, attributeSet, f1097a);
            setBackgroundDrawable(a2.a(0));
            a2.b();
        }
    }

    private class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private c f1099b;

        /* renamed from: c  reason: collision with root package name */
        private int f1100c = 4;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1101d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1102e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1103f;

        a() {
        }

        public int a() {
            int i2 = this.f1100c;
            this.f1100c = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            for (int i4 = 0; i4 < count; i4++) {
                view = getView(i4, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
            }
            this.f1100c = i2;
            return i3;
        }

        public void a(int i2) {
            if (this.f1100c != i2) {
                this.f1100c = i2;
                notifyDataSetChanged();
            }
        }

        public void a(c cVar) {
            c e2 = ActivityChooserView.this.f1074a.e();
            if (e2 != null && ActivityChooserView.this.isShown()) {
                e2.unregisterObserver(ActivityChooserView.this.f1078e);
            }
            this.f1099b = cVar;
            if (cVar != null && ActivityChooserView.this.isShown()) {
                cVar.registerObserver(ActivityChooserView.this.f1078e);
            }
            notifyDataSetChanged();
        }

        public void a(boolean z2) {
            if (this.f1103f != z2) {
                this.f1103f = z2;
                notifyDataSetChanged();
            }
        }

        public void a(boolean z2, boolean z3) {
            if (this.f1101d != z2 || this.f1102e != z3) {
                this.f1101d = z2;
                this.f1102e = z3;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo b() {
            return this.f1099b.b();
        }

        public int c() {
            return this.f1099b.a();
        }

        public int d() {
            return this.f1099b.c();
        }

        public c e() {
            return this.f1099b;
        }

        public boolean f() {
            return this.f1101d;
        }

        public int getCount() {
            int a2 = this.f1099b.a();
            if (!this.f1101d && this.f1099b.b() != null) {
                a2--;
            }
            int min = Math.min(a2, this.f1100c);
            return this.f1103f ? min + 1 : min;
        }

        public Object getItem(int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                if (!this.f1101d && this.f1099b.b() != null) {
                    i2++;
                }
                return this.f1099b.a(i2);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public int getItemViewType(int i2) {
            return (!this.f1103f || i2 != getCount() - 1) ? 0 : 1;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R.id.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i2);
                ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.f1101d || i2 != 0 || !this.f1102e) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    private class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        b() {
        }

        private void a() {
            if (ActivityChooserView.this.f1079f != null) {
                ActivityChooserView.this.f1079f.onDismiss();
            }
        }

        public void onClick(View view) {
            if (view == ActivityChooserView.this.f1076c) {
                ActivityChooserView.this.b();
                Intent b2 = ActivityChooserView.this.f1074a.e().b(ActivityChooserView.this.f1074a.e().a(ActivityChooserView.this.f1074a.b()));
                if (b2 != null) {
                    b2.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(b2);
                }
            } else if (view == ActivityChooserView.this.f1075b) {
                ActivityChooserView.this.f1080g = false;
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                activityChooserView.a(activityChooserView.f1081h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            a();
            if (ActivityChooserView.this.f1077d != null) {
                ActivityChooserView.this.f1077d.a(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            int itemViewType = ((a) adapterView.getAdapter()).getItemViewType(i2);
            if (itemViewType == 0) {
                ActivityChooserView.this.b();
                if (!ActivityChooserView.this.f1080g) {
                    if (!ActivityChooserView.this.f1074a.f()) {
                        i2++;
                    }
                    Intent b2 = ActivityChooserView.this.f1074a.e().b(i2);
                    if (b2 != null) {
                        b2.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(b2);
                    }
                } else if (i2 > 0) {
                    ActivityChooserView.this.f1074a.e().c(i2);
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.a(SubsamplingScaleImageView.TILE_SIZE_AUTO);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.f1076c) {
                if (ActivityChooserView.this.f1074a.getCount() > 0) {
                    ActivityChooserView.this.f1080g = true;
                    ActivityChooserView activityChooserView = ActivityChooserView.this;
                    activityChooserView.a(activityChooserView.f1081h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1078e = new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f1074a.notifyDataSetChanged();
            }

            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f1074a.notifyDataSetInvalidated();
            }
        };
        this.f1088o = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (!ActivityChooserView.this.c()) {
                    return;
                }
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().d();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().c_();
                if (ActivityChooserView.this.f1077d != null) {
                    ActivityChooserView.this.f1077d.a(true);
                }
            }
        };
        this.f1081h = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityChooserView, i2, 0);
        ac.a(this, context, R.styleable.ActivityChooserView, attributeSet, obtainStyledAttributes, i2, 0);
        this.f1081h = obtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
        b bVar = new b();
        this.f1082i = bVar;
        View findViewById = findViewById(R.id.activity_chooser_view_content);
        this.f1083j = findViewById;
        this.f1084k = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.default_activity_button);
        this.f1076c = frameLayout;
        frameLayout.setOnClickListener(bVar);
        frameLayout.setOnLongClickListener(bVar);
        this.f1086m = (ImageView) frameLayout.findViewById(R.id.image);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout2.setOnClickListener(bVar);
        frameLayout2.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                c.a(accessibilityNodeInfo).l(true);
            }
        });
        frameLayout2.setOnTouchListener(new t(frameLayout2) {
            public p a() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            /* access modifiers changed from: protected */
            public boolean b() {
                ActivityChooserView.this.a();
                return true;
            }

            /* access modifiers changed from: protected */
            public boolean c() {
                ActivityChooserView.this.b();
                return true;
            }
        });
        this.f1075b = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(R.id.image);
        this.f1085l = imageView;
        imageView.setImageDrawable(drawable);
        a aVar = new a();
        this.f1074a = aVar;
        aVar.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.d();
            }
        });
        Resources resources = context.getResources();
        this.f1087n = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        a aVar;
        if (this.f1074a.e() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.f1088o);
            boolean z2 = this.f1076c.getVisibility() == 0;
            int c2 = this.f1074a.c();
            if (i2 == Integer.MAX_VALUE || c2 <= i2 + (z2 ? 1 : 0)) {
                this.f1074a.a(false);
                aVar = this.f1074a;
            } else {
                this.f1074a.a(true);
                aVar = this.f1074a;
                i2--;
            }
            aVar.a(i2);
            ListPopupWindow listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.e()) {
                if (this.f1080g || !z2) {
                    this.f1074a.a(true, z2);
                } else {
                    this.f1074a.a(false, false);
                }
                listPopupWindow.h(Math.min(this.f1074a.a(), this.f1087n));
                listPopupWindow.c_();
                t.b bVar = this.f1077d;
                if (bVar != null) {
                    bVar.a(true);
                }
                listPopupWindow.g().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
                listPopupWindow.g().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public boolean a() {
        if (c() || !this.f1090q) {
            return false;
        }
        this.f1080g = false;
        a(this.f1081h);
        return true;
    }

    public boolean b() {
        if (!c()) {
            return true;
        }
        getListPopupWindow().d();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1088o);
        return true;
    }

    public boolean c() {
        return getListPopupWindow().e();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Drawable drawable;
        View view;
        if (this.f1074a.getCount() > 0) {
            this.f1075b.setEnabled(true);
        } else {
            this.f1075b.setEnabled(false);
        }
        int c2 = this.f1074a.c();
        int d2 = this.f1074a.d();
        if (c2 == 1 || (c2 > 1 && d2 > 0)) {
            this.f1076c.setVisibility(0);
            ResolveInfo b2 = this.f1074a.b();
            PackageManager packageManager = getContext().getPackageManager();
            this.f1086m.setImageDrawable(b2.loadIcon(packageManager));
            if (this.f1091r != 0) {
                CharSequence loadLabel = b2.loadLabel(packageManager);
                this.f1076c.setContentDescription(getContext().getString(this.f1091r, new Object[]{loadLabel}));
            }
        } else {
            this.f1076c.setVisibility(8);
        }
        if (this.f1076c.getVisibility() == 0) {
            view = this.f1083j;
            drawable = this.f1084k;
        } else {
            view = this.f1083j;
            drawable = null;
        }
        view.setBackgroundDrawable(drawable);
    }

    public c getDataModel() {
        return this.f1074a.e();
    }

    /* access modifiers changed from: package-private */
    public ListPopupWindow getListPopupWindow() {
        if (this.f1089p == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f1089p = listPopupWindow;
            listPopupWindow.a((ListAdapter) this.f1074a);
            this.f1089p.b((View) this);
            this.f1089p.a(true);
            this.f1089p.a((AdapterView.OnItemClickListener) this.f1082i);
            this.f1089p.a((PopupWindow.OnDismissListener) this.f1082i);
        }
        return this.f1089p;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c e2 = this.f1074a.e();
        if (e2 != null) {
            e2.registerObserver(this.f1078e);
        }
        this.f1090q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c e2 = this.f1074a.e();
        if (e2 != null) {
            e2.unregisterObserver(this.f1078e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1088o);
        }
        if (c()) {
            b();
        }
        this.f1090q = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.f1083j.layout(0, 0, i4 - i2, i5 - i3);
        if (!c()) {
            b();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        View view = this.f1083j;
        if (this.f1076c.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), MemoryConstants.GB);
        }
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(c cVar) {
        this.f1074a.a(cVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.f1091r = i2;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.f1085l.setContentDescription(getContext().getString(i2));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1085l.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i2) {
        this.f1081h = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1079f = onDismissListener;
    }

    public void setProvider(t.b bVar) {
        this.f1077d = bVar;
    }
}
