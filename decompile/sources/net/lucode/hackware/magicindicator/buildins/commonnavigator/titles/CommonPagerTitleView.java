package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class CommonPagerTitleView extends FrameLayout implements mz.b {

    /* renamed from: a  reason: collision with root package name */
    private b f31524a;

    /* renamed from: b  reason: collision with root package name */
    private a f31525b;

    public interface a {
        int a();

        int b();

        int c();

        int d();
    }

    public interface b {
        void onDeselected(int i2, int i3);

        void onEnter(int i2, int i3, float f2, boolean z2);

        void onLeave(int i2, int i3, float f2, boolean z2);

        void onSelected(int i2, int i3);
    }

    public CommonPagerTitleView(Context context) {
        super(context);
    }

    public void a(int i2, int i3) {
        b bVar = this.f31524a;
        if (bVar != null) {
            bVar.onSelected(i2, i3);
        }
    }

    public void a(int i2, int i3, float f2, boolean z2) {
        b bVar = this.f31524a;
        if (bVar != null) {
            bVar.onEnter(i2, i3, f2, z2);
        }
    }

    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    public void b(int i2, int i3) {
        b bVar = this.f31524a;
        if (bVar != null) {
            bVar.onDeselected(i2, i3);
        }
    }

    public void b(int i2, int i3, float f2, boolean z2) {
        b bVar = this.f31524a;
        if (bVar != null) {
            bVar.onLeave(i2, i3, f2, z2);
        }
    }

    public int getContentBottom() {
        a aVar = this.f31525b;
        return aVar != null ? aVar.d() : getBottom();
    }

    public int getContentLeft() {
        a aVar = this.f31525b;
        return aVar != null ? aVar.a() : getLeft();
    }

    public a getContentPositionDataProvider() {
        return this.f31525b;
    }

    public int getContentRight() {
        a aVar = this.f31525b;
        return aVar != null ? aVar.c() : getRight();
    }

    public int getContentTop() {
        a aVar = this.f31525b;
        return aVar != null ? aVar.b() : getTop();
    }

    public b getOnPagerTitleChangeListener() {
        return this.f31524a;
    }

    public void setContentPositionDataProvider(a aVar) {
        this.f31525b = aVar;
    }

    public void setContentView(int i2) {
        a(LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) null), (FrameLayout.LayoutParams) null);
    }

    public void setContentView(View view) {
        a(view, (FrameLayout.LayoutParams) null);
    }

    public void setOnPagerTitleChangeListener(b bVar) {
        this.f31524a = bVar;
    }
}
