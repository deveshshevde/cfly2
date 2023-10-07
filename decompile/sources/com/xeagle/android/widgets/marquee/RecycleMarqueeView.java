package com.xeagle.android.widgets.marquee;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o;
import com.cfly.uav_pro.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.List;

public class RecycleMarqueeView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f25912a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayoutManager f25913b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<a> f25914c;

    /* renamed from: d  reason: collision with root package name */
    private a f25915d;

    /* renamed from: e  reason: collision with root package name */
    private View f25916e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25917f;

    public class SmoothLinearLayoutManager extends LinearLayoutManager {

        /* renamed from: a  reason: collision with root package name */
        private Context f25920a;

        public void a(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
            Context context = this.f25920a;
            if (context != null) {
                AnonymousClass1 r2 = new o(context) {
                    /* access modifiers changed from: protected */
                    public float a(DisplayMetrics displayMetrics) {
                        return 300.0f / ((float) displayMetrics.densityDpi);
                    }

                    public PointF d(int i2) {
                        return SmoothLinearLayoutManager.this.d(i2);
                    }
                };
                r2.c(i2);
                a((RecyclerView.r) r2);
            }
        }
    }

    public class a extends RecyclerView.Adapter<C0161a> {

        /* renamed from: b  reason: collision with root package name */
        private int f25923b = 0;

        /* renamed from: com.xeagle.android.widgets.marquee.RecycleMarqueeView$a$a  reason: collision with other inner class name */
        public class C0161a extends RecyclerView.v {

            /* renamed from: a  reason: collision with root package name */
            public MarqueeScrollerView f25924a;

            public C0161a(View view) {
                super(view);
                this.f25924a = (MarqueeScrollerView) view.findViewById(R.id.breaking_news_title);
            }
        }

        public a() {
        }

        /* renamed from: a */
        public C0161a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_marquee, viewGroup, false);
            inflate.getLayoutParams().width = viewGroup.getMeasuredWidth();
            return new C0161a(inflate);
        }

        /* renamed from: a */
        public void onBindViewHolder(C0161a aVar, int i2) {
            Log.i("picker", "onBindViewHolder: ---position--" + i2 + "---size---" + RecycleMarqueeView.this.f25914c.size());
            aVar.f25924a.setText(((a) RecycleMarqueeView.this.f25914c.get(i2 % RecycleMarqueeView.this.f25914c.size())).b());
            if (((a) RecycleMarqueeView.this.f25914c.get(i2 % RecycleMarqueeView.this.f25914c.size())).a() != 0) {
                aVar.f25924a.setTextColor(((a) RecycleMarqueeView.this.f25914c.get(i2 % RecycleMarqueeView.this.f25914c.size())).a());
            }
        }

        public int getItemCount() {
            return SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
    }

    public RecycleMarqueeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecycleMarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecycleMarqueeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f25917f = false;
        a();
    }

    private void a() {
        this.f25912a = new RecyclerView(getContext());
        this.f25913b = new LinearLayoutManager(getContext(), 0, false);
        this.f25915d = new a();
        this.f25912a.setLayoutManager(this.f25913b);
        this.f25912a.setAdapter(this.f25915d);
        addView(this.f25912a, new ViewGroup.LayoutParams(-1, -2));
        View view = new View(getContext());
        this.f25916e = view;
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f25912a.a((RecyclerView.l) new RecyclerView.l() {
            public void a(RecyclerView recyclerView, int i2) {
                View i3;
                super.a(recyclerView, i2);
                if (i2 == 0 && (i3 = recyclerView.getLayoutManager().i(0)) != null && (i3 instanceof MarqueeScrollerView)) {
                    ((MarqueeScrollerView) i3).a();
                }
            }
        });
    }

    public void setContentList(List<a> list) {
        this.f25914c = list;
        this.f25915d.notifyDataSetChanged();
    }
}
