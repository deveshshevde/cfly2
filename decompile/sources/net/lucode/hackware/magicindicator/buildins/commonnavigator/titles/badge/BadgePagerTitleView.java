package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import mz.b;
import mz.d;

public class BadgePagerTitleView extends FrameLayout implements b {

    /* renamed from: a  reason: collision with root package name */
    private d f31543a;

    /* renamed from: b  reason: collision with root package name */
    private View f31544b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31545c = true;

    /* renamed from: d  reason: collision with root package name */
    private a f31546d;

    /* renamed from: e  reason: collision with root package name */
    private a f31547e;

    public BadgePagerTitleView(Context context) {
        super(context);
    }

    public void a(int i2, int i3) {
        d dVar = this.f31543a;
        if (dVar != null) {
            dVar.a(i2, i3);
        }
        if (this.f31545c) {
            setBadgeView((View) null);
        }
    }

    public void a(int i2, int i3, float f2, boolean z2) {
        d dVar = this.f31543a;
        if (dVar != null) {
            dVar.a(i2, i3, f2, z2);
        }
    }

    public void b(int i2, int i3) {
        d dVar = this.f31543a;
        if (dVar != null) {
            dVar.b(i2, i3);
        }
    }

    public void b(int i2, int i3, float f2, boolean z2) {
        d dVar = this.f31543a;
        if (dVar != null) {
            dVar.b(i2, i3, f2, z2);
        }
    }

    public View getBadgeView() {
        return this.f31544b;
    }

    public int getContentBottom() {
        d dVar = this.f31543a;
        return dVar instanceof b ? ((b) dVar).getContentBottom() : getBottom();
    }

    public int getContentLeft() {
        return this.f31543a instanceof b ? getLeft() + ((b) this.f31543a).getContentLeft() : getLeft();
    }

    public int getContentRight() {
        return this.f31543a instanceof b ? getLeft() + ((b) this.f31543a).getContentRight() : getRight();
    }

    public int getContentTop() {
        d dVar = this.f31543a;
        return dVar instanceof b ? ((b) dVar).getContentTop() : getTop();
    }

    public d getInnerPagerTitleView() {
        return this.f31543a;
    }

    public a getXBadgeRule() {
        return this.f31546d;
    }

    public a getYBadgeRule() {
        return this.f31547e;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        d dVar = this.f31543a;
        if ((dVar instanceof View) && this.f31544b != null) {
            int[] iArr = new int[14];
            View view = (View) dVar;
            iArr[0] = view.getLeft();
            iArr[1] = view.getTop();
            iArr[2] = view.getRight();
            iArr[3] = view.getBottom();
            d dVar2 = this.f31543a;
            if (dVar2 instanceof b) {
                b bVar = (b) dVar2;
                iArr[4] = bVar.getContentLeft();
                iArr[5] = bVar.getContentTop();
                iArr[6] = bVar.getContentRight();
                iArr[7] = bVar.getContentBottom();
            } else {
                for (int i6 = 4; i6 < 8; i6++) {
                    iArr[i6] = iArr[i6 - 4];
                }
            }
            iArr[8] = view.getWidth() / 2;
            iArr[9] = view.getHeight() / 2;
            iArr[10] = iArr[4] / 2;
            iArr[11] = iArr[5] / 2;
            iArr[12] = iArr[6] + ((iArr[2] - iArr[6]) / 2);
            iArr[13] = iArr[7] + ((iArr[3] - iArr[7]) / 2);
            a aVar = this.f31546d;
            if (aVar != null) {
                int b2 = iArr[aVar.a().ordinal()] + this.f31546d.b();
                View view2 = this.f31544b;
                view2.offsetLeftAndRight(b2 - view2.getLeft());
            }
            a aVar2 = this.f31547e;
            if (aVar2 != null) {
                int b3 = iArr[aVar2.a().ordinal()] + this.f31547e.b();
                View view3 = this.f31544b;
                view3.offsetTopAndBottom(b3 - view3.getTop());
            }
        }
    }

    public void setAutoCancelBadge(boolean z2) {
        this.f31545c = z2;
    }

    public void setBadgeView(View view) {
        if (this.f31544b != view) {
            this.f31544b = view;
            removeAllViews();
            if (this.f31543a instanceof View) {
                addView((View) this.f31543a, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f31544b != null) {
                addView(this.f31544b, new FrameLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void setInnerPagerTitleView(d dVar) {
        if (this.f31543a != dVar) {
            this.f31543a = dVar;
            removeAllViews();
            if (this.f31543a instanceof View) {
                addView((View) this.f31543a, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f31544b != null) {
                addView(this.f31544b, new FrameLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void setXBadgeRule(a aVar) {
        BadgeAnchor a2;
        if (aVar == null || (a2 = aVar.a()) == BadgeAnchor.LEFT || a2 == BadgeAnchor.RIGHT || a2 == BadgeAnchor.CONTENT_LEFT || a2 == BadgeAnchor.CONTENT_RIGHT || a2 == BadgeAnchor.CENTER_X || a2 == BadgeAnchor.LEFT_EDGE_CENTER_X || a2 == BadgeAnchor.RIGHT_EDGE_CENTER_X) {
            this.f31546d = aVar;
            return;
        }
        throw new IllegalArgumentException("x badge rule is wrong.");
    }

    public void setYBadgeRule(a aVar) {
        BadgeAnchor a2;
        if (aVar == null || (a2 = aVar.a()) == BadgeAnchor.TOP || a2 == BadgeAnchor.BOTTOM || a2 == BadgeAnchor.CONTENT_TOP || a2 == BadgeAnchor.CONTENT_BOTTOM || a2 == BadgeAnchor.CENTER_Y || a2 == BadgeAnchor.TOP_EDGE_CENTER_Y || a2 == BadgeAnchor.BOTTOM_EDGE_CENTER_Y) {
            this.f31547e = aVar;
            return;
        }
        throw new IllegalArgumentException("y badge rule is wrong.");
    }
}
