package com.xeagle.android.newUI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.savedstate.c;
import com.cfly.uav_pro.R;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.newUI.fragment.remindFragment.e;
import com.xeagle.android.newUI.fragment.remindFragment.f;
import com.xeagle.android.newUI.fragment.remindFragment.g;
import com.xeagle.android.newUI.fragment.remindFragment.h;
import com.xeagle.android.newUI.widgets.NoScrollViewPager;
import java.util.ArrayList;

public class GuideActivity extends SuperUI {

    /* renamed from: a  reason: collision with root package name */
    private TextView f23868a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f23869b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f23870c;

    /* renamed from: k  reason: collision with root package name */
    private NoScrollViewPager f23871k;

    /* renamed from: l  reason: collision with root package name */
    private int f23872l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f23873m;

    private void a() {
        Bundle bundle;
        String str;
        c cVar;
        f fVar;
        this.f23869b = (TextView) findViewById(R.id.tv_guide_flying);
        this.f23868a = (TextView) findViewById(R.id.tv_guide_return);
        this.f23870c = (TextView) findViewById(R.id.tv_guide_title);
        this.f23871k = (NoScrollViewPager) findViewById(R.id.viewpager);
        ArrayList arrayList = new ArrayList();
        int i2 = this.f23873m;
        if (i2 == 1) {
            arrayList.add(new e());
            f fVar2 = new f();
            bundle = new Bundle();
            str = "809d";
            fVar = fVar2;
        } else if (i2 == 2) {
            arrayList.add(new g());
            cVar = new h();
            arrayList.add(cVar);
            this.f23871k.setAdapter(new kk.c(getSupportFragmentManager(), arrayList));
            this.f23870c.setText(R.string.guide_controller_title);
            this.f23868a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    GuideActivity.this.b(view);
                }
            });
            this.f23869b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    GuideActivity.this.a(view);
                }
            });
        } else if (i2 == 0) {
            arrayList.add(new e());
            f fVar3 = new f();
            bundle = new Bundle();
            str = "808D";
            fVar = fVar3;
        } else {
            if (i2 == 3) {
                arrayList.add(new e());
                f fVar4 = new f();
                bundle = new Bundle();
                str = "809e";
                fVar = fVar4;
            }
            this.f23871k.setAdapter(new kk.c(getSupportFragmentManager(), arrayList));
            this.f23870c.setText(R.string.guide_controller_title);
            this.f23868a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    GuideActivity.this.b(view);
                }
            });
            this.f23869b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    GuideActivity.this.a(view);
                }
            });
        }
        bundle.putString("droneType", str);
        fVar.setArguments(bundle);
        cVar = fVar;
        arrayList.add(cVar);
        this.f23871k.setAdapter(new kk.c(getSupportFragmentManager(), arrayList));
        this.f23870c.setText(R.string.guide_controller_title);
        this.f23868a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GuideActivity.this.b(view);
            }
        });
        this.f23869b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GuideActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
        startActivity(new Intent(this, FlightActionActivity.class));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r4 = this;
            int r0 = r4.f23872l
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0014
            com.xeagle.android.newUI.widgets.NoScrollViewPager r0 = r4.f23871k
            r0.setCurrentItem(r1)
            android.widget.TextView r0 = r4.f23870c
            r3 = 2131821448(0x7f110388, float:1.927564E38)
        L_0x0010:
            r0.setText(r3)
            goto L_0x0021
        L_0x0014:
            if (r0 != r2) goto L_0x0021
            com.xeagle.android.newUI.widgets.NoScrollViewPager r0 = r4.f23871k
            r0.setCurrentItem(r2)
            android.widget.TextView r0 = r4.f23870c
            r3 = 2131821453(0x7f11038d, float:1.927565E38)
            goto L_0x0010
        L_0x0021:
            int r0 = r4.f23872l
            r3 = 8
            if (r0 != r2) goto L_0x0035
            android.widget.TextView r0 = r4.f23868a
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0042
            android.widget.TextView r0 = r4.f23868a
            r0.setVisibility(r3)
            goto L_0x0042
        L_0x0035:
            android.widget.TextView r0 = r4.f23868a
            int r0 = r0.getVisibility()
            if (r0 != r3) goto L_0x0042
            android.widget.TextView r0 = r4.f23868a
            r0.setVisibility(r1)
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.activity.GuideActivity.b():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a(true);
    }

    public void a(boolean z2) {
        int i2;
        if (!z2) {
            i2 = this.f23871k.getCurrentItem() + 1;
        } else if (this.f23871k.getCurrentItem() == 0) {
            finish();
            return;
        } else {
            i2 = this.f23871k.getCurrentItem() - 1;
        }
        this.f23872l = i2;
        b();
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_guide);
        this.f23873m = getIntent().getIntExtra("position", 0);
        a();
    }
}
