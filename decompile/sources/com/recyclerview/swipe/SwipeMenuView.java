package com.recyclerview.swipe;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeMenuView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public l f21526a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView.v f21527b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f21528c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public b f21529d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnClickListener f21530e;

    public SwipeMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21530e = new View.OnClickListener() {
            public void onClick(View view) {
                if (SwipeMenuView.this.f21529d != null && SwipeMenuView.this.f21526a != null && SwipeMenuView.this.f21526a.b()) {
                    SwipeMenuView.this.f21529d.a(SwipeMenuView.this.f21526a, SwipeMenuView.this.f21527b.getAdapterPosition(), view.getId(), SwipeMenuView.this.f21528c);
                }
            }
        };
    }

    private ImageView a(j jVar) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(jVar.b());
        return imageView;
    }

    private void a(j jVar, int i2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jVar.h(), jVar.i());
        layoutParams.weight = (float) jVar.j();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setId(i2);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        d.a((View) linearLayout, jVar.a());
        linearLayout.setOnClickListener(this.f21530e);
        addView(linearLayout);
        if (jVar.b() != null) {
            linearLayout.addView(a(jVar));
        }
        if (!TextUtils.isEmpty(jVar.e())) {
            linearLayout.addView(b(jVar));
        }
    }

    private TextView b(j jVar) {
        TextView textView = new TextView(getContext());
        textView.setText(jVar.e());
        textView.setGravity(17);
        int d2 = jVar.d();
        if (d2 > 0) {
            textView.setTextSize((float) d2);
        }
        ColorStateList c2 = jVar.c();
        if (c2 != null) {
            textView.setTextColor(c2);
        }
        int f2 = jVar.f();
        if (f2 != 0) {
            d.a(textView, f2);
        }
        Typeface g2 = jVar.g();
        if (g2 != null) {
            textView.setTypeface(g2);
        }
        return textView;
    }

    public void a(RecyclerView.v vVar) {
        this.f21527b = vVar;
    }

    public void a(b bVar, l lVar) {
        this.f21529d = bVar;
        this.f21526a = lVar;
    }

    public void a(g gVar, int i2) {
        removeAllViews();
        this.f21528c = i2;
        int i3 = 0;
        for (j a2 : gVar.b()) {
            a(a2, i3);
            i3++;
        }
    }
}
