package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import t.ac;
import t.ad;

class ai implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {

    /* renamed from: j  reason: collision with root package name */
    private static ai f1430j;

    /* renamed from: k  reason: collision with root package name */
    private static ai f1431k;

    /* renamed from: a  reason: collision with root package name */
    private final View f1432a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f1433b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1434c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f1435d = new Runnable() {
        public void run() {
            ai.this.a(false);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f1436e = new Runnable() {
        public void run() {
            ai.this.a();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private int f1437f;

    /* renamed from: g  reason: collision with root package name */
    private int f1438g;

    /* renamed from: h  reason: collision with root package name */
    private aj f1439h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1440i;

    private ai(View view, CharSequence charSequence) {
        this.f1432a = view;
        this.f1433b = charSequence;
        this.f1434c = ad.b(ViewConfiguration.get(view.getContext()));
        d();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void a(View view, CharSequence charSequence) {
        ai aiVar = f1430j;
        if (aiVar != null && aiVar.f1432a == view) {
            a((ai) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            ai aiVar2 = f1431k;
            if (aiVar2 != null && aiVar2.f1432a == view) {
                aiVar2.a();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new ai(view, charSequence);
    }

    private static void a(ai aiVar) {
        ai aiVar2 = f1430j;
        if (aiVar2 != null) {
            aiVar2.c();
        }
        f1430j = aiVar;
        if (aiVar != null) {
            aiVar.b();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (Math.abs(x2 - this.f1437f) <= this.f1434c && Math.abs(y2 - this.f1438g) <= this.f1434c) {
            return false;
        }
        this.f1437f = x2;
        this.f1438g = y2;
        return true;
    }

    private void b() {
        this.f1432a.postDelayed(this.f1435d, (long) ViewConfiguration.getLongPressTimeout());
    }

    private void c() {
        this.f1432a.removeCallbacks(this.f1435d);
    }

    private void d() {
        this.f1437f = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f1438g = SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (f1431k == this) {
            f1431k = null;
            aj ajVar = this.f1439h;
            if (ajVar != null) {
                ajVar.a();
                this.f1439h = null;
                d();
                this.f1432a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1430j == this) {
            a((ai) null);
        }
        this.f1432a.removeCallbacks(this.f1436e);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        long j2;
        if (ac.J(this.f1432a)) {
            a((ai) null);
            ai aiVar = f1431k;
            if (aiVar != null) {
                aiVar.a();
            }
            f1431k = this;
            this.f1440i = z2;
            aj ajVar = new aj(this.f1432a.getContext());
            this.f1439h = ajVar;
            ajVar.a(this.f1432a, this.f1437f, this.f1438g, this.f1440i, this.f1433b);
            this.f1432a.addOnAttachStateChangeListener(this);
            if (this.f1440i) {
                j2 = 2500;
            } else {
                j2 = ((ac.v(this.f1432a) & 1) == 1 ? 3000 : 15000) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f1432a.removeCallbacks(this.f1436e);
            this.f1432a.postDelayed(this.f1436e, j2);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1439h != null && this.f1440i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1432a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                d();
                a();
            }
        } else if (this.f1432a.isEnabled() && this.f1439h == null && a(motionEvent)) {
            a(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f1437f = view.getWidth() / 2;
        this.f1438g = view.getHeight() / 2;
        a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
