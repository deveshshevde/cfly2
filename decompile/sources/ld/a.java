package ld;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ci.a;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.customeui.widget.SlideButton;
import com.cfly.uav_pro.R;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.FlightActionActivity;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.newUI.beans.OperationItemBean;
import com.xeagle.android.utils.y;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import com.xeagle.android.vjoystick.activity.DescActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import jo.al;
import jo.z;
import kotlin.text.Regex;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public final class a extends androidx.fragment.app.c implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f13951a;

    /* renamed from: b  reason: collision with root package name */
    private int f13952b;

    /* renamed from: c  reason: collision with root package name */
    private final List<OperationItemBean> f13953c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private Context f13954d;

    /* renamed from: e  reason: collision with root package name */
    private en.a f13955e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.xeagle.android.utils.prefs.a f13956f;

    /* renamed from: g  reason: collision with root package name */
    private FlightActionActivity f13957g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public kk.h f13958h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public kk.h f13959i;

    /* renamed from: j  reason: collision with root package name */
    private kk.g f13960j;

    /* renamed from: k  reason: collision with root package name */
    private kk.g f13961k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public kk.g f13962l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f13963m;

    /* renamed from: n  reason: collision with root package name */
    private int f13964n = 3;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f13965o = 3;

    /* renamed from: p  reason: collision with root package name */
    private int f13966p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f13967q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f13968r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public List<OperationItemBean> f13969s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private kk.f f13970t;

    /* renamed from: u  reason: collision with root package name */
    private kk.f f13971u;

    /* renamed from: v  reason: collision with root package name */
    private HashMap f13972v;

    /* renamed from: ld.a$a  reason: collision with other inner class name */
    static final class C0216a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30755a;

        C0216a(a aVar) {
            this.f30755a = aVar;
        }

        public final void onItemClick(ci.a<Object, ci.b> aVar, View view, int i2) {
            kk.h c2 = this.f30755a.f13958h;
            kotlin.jvm.internal.h.a((Object) c2);
            c2.a(i2);
            a aVar2 = this.f30755a;
            kk.h c3 = aVar2.f13958h;
            kotlin.jvm.internal.h.a((Object) c3);
            Object obj = c3.getData().get(i2);
            kotlin.jvm.internal.h.b(obj, "heightAdapter!!.data[position]");
            aVar2.f13963m = Integer.parseInt((String) obj);
        }
    }

    static final class b implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30756a;

        b(a aVar) {
            this.f30756a = aVar;
        }

        public final void onItemClick(ci.a<?, ?> aVar, View view, int i2) {
            if (aVar != null) {
                this.f30756a.a((OperationItemBean) this.f30756a.f13969s.get(i2));
            }
        }
    }

    static final class c implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30757a;

        c(a aVar) {
            this.f30757a = aVar;
        }

        public final void onItemClick(ci.a<Object, ci.b> aVar, View view, int i2) {
            kk.h e2 = this.f30757a.f13959i;
            kotlin.jvm.internal.h.a((Object) e2);
            e2.a(i2);
            a aVar2 = this.f30757a;
            kk.h e3 = aVar2.f13959i;
            kotlin.jvm.internal.h.a((Object) e3);
            Object obj = e3.getData().get(i2);
            kotlin.jvm.internal.h.b(obj, "radiusAdapter!!.data[position]");
            aVar2.f13965o = Integer.parseInt((String) obj);
        }
    }

    static final class d implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30758a;

        d(a aVar) {
            this.f30758a = aVar;
        }

        public final void onItemClick(ci.a<?, ?> aVar, View view, int i2) {
            if (aVar != null) {
                this.f30758a.b(i2);
            }
        }
    }

    static final class e implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30759a;

        e(a aVar) {
            this.f30759a = aVar;
        }

        public final void onItemClick(ci.a<?, ?> aVar, View view, int i2) {
            if (aVar != null) {
                this.f30759a.c(i2);
            }
        }
    }

    static final class f implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30760a;

        f(a aVar) {
            this.f30760a = aVar;
        }

        public final void onItemClick(ci.a<?, ?> aVar, View view, int i2) {
            if (aVar != null) {
                this.f30760a.d(i2);
            }
        }
    }

    public static final class g extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30761a;

        g(a aVar) {
            this.f30761a = aVar;
        }

        public void onClick(View view) {
            kotlin.jvm.internal.h.d(view, "widget");
            this.f30761a.startActivity(new Intent(this.f30761a.getActivity(), DescActivity.class));
        }

        public void updateDrawState(TextPaint textPaint) {
            kotlin.jvm.internal.h.d(textPaint, "ds");
            FragmentActivity activity = this.f30761a.getActivity();
            kotlin.jvm.internal.h.a((Object) activity);
            textPaint.setColor(androidx.core.content.b.c(activity, R.color.colorAccent_blue));
        }
    }

    static final class h implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30762a;

        h(a aVar) {
            this.f30762a = aVar;
        }

        public final void onItemClick(ci.a<Object, ci.b> aVar, View view, int i2) {
            a aVar2 = this.f30762a;
            kk.g a2 = aVar2.f13962l;
            kotlin.jvm.internal.h.a((Object) a2);
            Object obj = a2.getData().get(i2);
            kotlin.jvm.internal.h.b(obj, "mHadapter!!.data[position]");
            aVar2.f(((OperationItemBean) obj).a());
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30763a;

        i(a aVar) {
            this.f30763a = aVar;
        }

        public final void onClick(View view) {
            this.f30763a.dismiss();
        }
    }

    public static final class j implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30764a;

        j(a aVar) {
            this.f30764a = aVar;
        }

        public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            kotlin.jvm.internal.h.a((Object) seekBar);
            if (seekBar.getProgress() >= 70) {
                SlideButton slideButton = (SlideButton) this.f30764a.a(com.xeagle.R.id.unlock_slider);
                kotlin.jvm.internal.h.b(slideButton, "unlock_slider");
                slideButton.setProgress(100);
                com.xeagle.android.utils.prefs.a i2 = this.f30764a.f13956f;
                kotlin.jvm.internal.h.a((Object) i2);
                i2.aR();
                org.greenrobot.eventbus.c.a().d(new al(this.f30764a.f13968r, this.f30764a.f13967q, this.f30764a.f13963m, this.f30764a.f13965o, this.f30764a.f13951a));
                this.f30764a.dismiss();
            }
            SlideButton slideButton2 = (SlideButton) this.f30764a.a(com.xeagle.R.id.unlock_slider);
            kotlin.jvm.internal.h.b(slideButton2, "unlock_slider");
            slideButton2.setProgress(0);
        }
    }

    public static final class k implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30765a;

        k(a aVar) {
            this.f30765a = aVar;
        }

        public void onYes() {
            this.f30765a.f13967q = 0;
            org.greenrobot.eventbus.c.a().d(new al(this.f30765a.f13968r, this.f30765a.f13967q, 0, 0, 0));
        }
    }

    private final void a(int i2, int i3) {
        Object obj;
        String str;
        en.a aVar = this.f13955e;
        kotlin.jvm.internal.h.a((Object) aVar);
        com.flypro.core.drone.variables.a t2 = aVar.t();
        kotlin.jvm.internal.h.b(t2, "drone!!.altitude");
        int b2 = (int) t2.b();
        ArrayList arrayList = new ArrayList();
        for (int i4 = i2; i4 < i3; i4++) {
            arrayList.add(String.valueOf(i4) + "");
        }
        kk.h hVar = this.f13958h;
        kotlin.jvm.internal.h.a((Object) hVar);
        hVar.replaceData(arrayList);
        if (b2 <= i2) {
            kk.h hVar2 = this.f13958h;
            kotlin.jvm.internal.h.a((Object) hVar2);
            hVar2.a(0);
            kk.h hVar3 = this.f13958h;
            kotlin.jvm.internal.h.a((Object) hVar3);
            obj = hVar3.getData().get(0);
            str = "heightAdapter!!.data[0]";
        } else {
            kk.h hVar4 = this.f13958h;
            kotlin.jvm.internal.h.a((Object) hVar4);
            if (b2 >= i3) {
                hVar4.a(arrayList.size() - 1);
                kk.h hVar5 = this.f13958h;
                kotlin.jvm.internal.h.a((Object) hVar5);
                obj = hVar5.getData().get(arrayList.size() - 1);
                str = "heightAdapter!!.data[alts.size - 1]";
            } else {
                hVar4.a(arrayList.indexOf(String.valueOf(b2)));
                kk.h hVar6 = this.f13958h;
                kotlin.jvm.internal.h.a((Object) hVar6);
                obj = hVar6.getData().get(arrayList.indexOf(String.valueOf(b2)));
                str = "heightAdapter!!.data[alt…f(currentAlt.toString())]";
            }
        }
        kotlin.jvm.internal.h.b(obj, str);
        this.f13963m = Integer.parseInt((String) obj);
    }

    private final void a(View view) {
        View.OnClickListener onClickListener = this;
        ((IImageButton) a(com.xeagle.R.id.iv_fly_close)).setOnClickListener(onClickListener);
        ((IButton) a(com.xeagle.R.id.btn_next)).setOnClickListener(onClickListener);
        ((IButton) a(com.xeagle.R.id.ib_manual_circle)).setOnClickListener(onClickListener);
        ((IButton) a(com.xeagle.R.id.ib_automatic_circle)).setOnClickListener(onClickListener);
        if (this.f13953c.size() == 0) {
            this.f13953c.add(new OperationItemBean(0, getString(R.string.newui_op), R.drawable.newui_op_ui_selector, true, getString(R.string.newui_op_tip)));
            this.f13953c.add(new OperationItemBean(1, getString(R.string.newui_ai_follow), R.drawable.newui_ai_follow_selector, false, getString(R.string.newui_ai_follow_tip)));
            this.f13953c.add(new OperationItemBean(2, getString(R.string.newui_points_follow), R.drawable.newui_points_follow_selector, false, getString(R.string.newui_points_follow_tip)));
            this.f13953c.add(new OperationItemBean(3, getString(R.string.newui_fly_45), R.drawable.newui_fly_90_selector, false, getString(R.string.newui_fly_45_tip)));
            this.f13953c.add(new OperationItemBean(4, getString(R.string.newui_fly_90), R.drawable.newui_fly_45_selector, false, getString(R.string.newui_fly_90_tip)));
            this.f13953c.add(new OperationItemBean(5, getString(R.string.newui_round), R.drawable.newui_screw_selector, false, getString(R.string.newui_round_tip)));
            this.f13953c.add(new OperationItemBean(6, getString(R.string.newui_boomrang), R.drawable.newui_boomrang_selector, false, getString(R.string.newui_boomrang_tip)));
            this.f13953c.add(new OperationItemBean(7, getString(R.string.newui_screw), R.drawable.newui_round_selector, false, getString(R.string.newui_screw_tip)));
            FlightActionActivity flightActionActivity = this.f13957g;
            kotlin.jvm.internal.h.a((Object) flightActionActivity);
            Context applicationContext = flightActionActivity.getApplicationContext();
            Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
            if (((XEagleApp) applicationContext).c()) {
                com.xeagle.android.utils.prefs.a aVar = this.f13956f;
                kotlin.jvm.internal.h.a((Object) aVar);
                if (!aVar.j().equals(UserGlobal.DRONE_NAME_DF809_D)) {
                    com.xeagle.android.utils.prefs.a aVar2 = this.f13956f;
                    kotlin.jvm.internal.h.a((Object) aVar2);
                    if (!aVar2.j().equals(UserGlobal.DRONE_NAME_DF812_D)) {
                        this.f13953c.add(new OperationItemBean(8, getString(R.string.vision_follow), R.drawable.newui_vision_selector, false, getString(R.string.vision_tips)));
                        this.f13953c.add(new OperationItemBean(9, getString(R.string.panora_mode), R.drawable.quan_jing_selector, false, getString(R.string.panora_tips)));
                    }
                }
                this.f13953c.add(new OperationItemBean(10, getString(R.string.time_lapse_photography), R.drawable.time_lapse_selector, false, getString(R.string.panora_tips)));
            }
        }
        this.f13962l = new kk.g(this.f13953c);
        ((RecyclerView) a(com.xeagle.R.id.recyclerview)).setLayoutManager(new GridLayoutManager(this.f13954d, 4));
        ((RecyclerView) a(com.xeagle.R.id.recyclerview)).setAdapter(this.f13962l);
        ((RecyclerView) a(com.xeagle.R.id.recyclerview)).setFocusableInTouchMode(false);
        ((RecyclerView) a(com.xeagle.R.id.recyclerview)).requestFocus();
        int i2 = this.f13967q;
        if (!(i2 == 8 || i2 == 10)) {
            f(i2);
        }
        kk.g gVar = this.f13962l;
        kotlin.jvm.internal.h.a((Object) gVar);
        gVar.setOnItemClickListener(new h(this));
        f();
        g();
        d();
        c();
    }

    /* access modifiers changed from: private */
    public final void a(OperationItemBean operationItemBean) {
        this.f13964n = operationItemBean.a();
        if (!operationItemBean.d()) {
            kk.g gVar = this.f13960j;
            kotlin.jvm.internal.h.a((Object) gVar);
            for (OperationItemBean operationItemBean2 : gVar.getData()) {
                kotlin.jvm.internal.h.b(operationItemBean2, "tmp");
                operationItemBean2.a(kotlin.jvm.internal.h.a((Object) operationItemBean2, (Object) operationItemBean));
            }
        }
        kk.g gVar2 = this.f13960j;
        kotlin.jvm.internal.h.a((Object) gVar2);
        gVar2.notifyDataSetChanged();
    }

    private final void b() {
        int i2;
        IButton iButton;
        if (this.f13968r) {
            IButton iButton2 = (IButton) a(com.xeagle.R.id.btn_next);
            kotlin.jvm.internal.h.a((Object) iButton2);
            iButton2.setText(getString(R.string.newui_finish));
            iButton = (IButton) a(com.xeagle.R.id.btn_next);
            kotlin.jvm.internal.h.a((Object) iButton);
            i2 = R.drawable.newui_solid_red;
        } else {
            IButton iButton3 = (IButton) a(com.xeagle.R.id.btn_next);
            kotlin.jvm.internal.h.a((Object) iButton3);
            iButton3.setText(getString(R.string.next_step));
            iButton = (IButton) a(com.xeagle.R.id.btn_next);
            kotlin.jvm.internal.h.a((Object) iButton);
            i2 = R.drawable.newui_solid_accent;
        }
        iButton.setBackgroundResource(i2);
    }

    /* access modifiers changed from: private */
    public final void b(int i2) {
        kk.g gVar = this.f13961k;
        kotlin.jvm.internal.h.a((Object) gVar);
        OperationItemBean operationItemBean = (OperationItemBean) gVar.getData().get(i2);
        kotlin.jvm.internal.h.b(operationItemBean, "item");
        this.f13965o = operationItemBean.a();
        if (!operationItemBean.d()) {
            kk.g gVar2 = this.f13961k;
            kotlin.jvm.internal.h.a((Object) gVar2);
            List data = gVar2.getData();
            kotlin.jvm.internal.h.b(data, "mAdapter4!!.data");
            int size = data.size();
            int i3 = 0;
            while (i3 < size) {
                kk.g gVar3 = this.f13961k;
                kotlin.jvm.internal.h.a((Object) gVar3);
                Object obj = gVar3.getData().get(i3);
                kotlin.jvm.internal.h.b(obj, "mAdapter4!!.data[i]");
                ((OperationItemBean) obj).a(i3 == i2);
                i3++;
            }
        }
        kk.g gVar4 = this.f13961k;
        kotlin.jvm.internal.h.a((Object) gVar4);
        gVar4.notifyDataSetChanged();
    }

    private final void c() {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        arrayList.add(new OperationItemBean(2, getString(R.string.dir_time), R.drawable.dir_time_lag_selector, false, getString(R.string.newui_ai_follow_tip)));
        for (int i2 = 3; i2 <= 5; i2++) {
            arrayList2.add(new OperationItemBean(i2));
        }
        for (int i3 = 1; i3 <= 10; i3++) {
            arrayList3.add(new OperationItemBean(i3));
        }
        this.f13961k = new kk.g(arrayList);
        RecyclerView recyclerView = (RecyclerView) a(com.xeagle.R.id.rv_time1);
        kotlin.jvm.internal.h.b(recyclerView, "rv_time1");
        recyclerView.setLayoutManager(new GridLayoutManager(this.f13954d, 2));
        RecyclerView recyclerView2 = (RecyclerView) a(com.xeagle.R.id.rv_time1);
        kotlin.jvm.internal.h.b(recyclerView2, "rv_time1");
        recyclerView2.setAdapter(this.f13961k);
        b(0);
        kk.g gVar = this.f13961k;
        kotlin.jvm.internal.h.a((Object) gVar);
        gVar.setOnItemClickListener(new d(this));
        this.f13970t = new kk.f(arrayList2);
        RecyclerView recyclerView3 = (RecyclerView) a(com.xeagle.R.id.rv_time2);
        kotlin.jvm.internal.h.b(recyclerView3, "rv_time2");
        recyclerView3.setLayoutManager(new GridLayoutManager(this.f13954d, 5));
        RecyclerView recyclerView4 = (RecyclerView) a(com.xeagle.R.id.rv_time2);
        kotlin.jvm.internal.h.b(recyclerView4, "rv_time2");
        recyclerView4.setAdapter(this.f13970t);
        c(0);
        kk.f fVar = this.f13970t;
        kotlin.jvm.internal.h.a((Object) fVar);
        fVar.setOnItemClickListener(new e(this));
        this.f13971u = new kk.f(arrayList3);
        RecyclerView recyclerView5 = (RecyclerView) a(com.xeagle.R.id.rv_time3);
        kotlin.jvm.internal.h.a((Object) recyclerView5);
        recyclerView5.setLayoutManager(new LinearLayoutManager(this.f13954d, 0, false));
        RecyclerView recyclerView6 = (RecyclerView) a(com.xeagle.R.id.rv_time3);
        kotlin.jvm.internal.h.a((Object) recyclerView6);
        recyclerView6.setAdapter(this.f13971u);
        d(0);
        kk.f fVar2 = this.f13971u;
        kotlin.jvm.internal.h.a((Object) fVar2);
        fVar2.setOnItemClickListener(new f(this));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.time_desc3));
        spannableStringBuilder.setSpan(new UnderlineSpan(), 5, spannableStringBuilder.length(), 34);
        spannableStringBuilder.setSpan(new g(this), 5, spannableStringBuilder.length(), 33);
        TextView textView = (TextView) a(com.xeagle.R.id.tvDesc);
        kotlin.jvm.internal.h.b(textView, "tvDesc");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView2 = (TextView) a(com.xeagle.R.id.tvDesc);
        kotlin.jvm.internal.h.b(textView2, "tvDesc");
        textView2.setText(spannableStringBuilder);
    }

    /* access modifiers changed from: private */
    public final void c(int i2) {
        kk.f fVar = this.f13970t;
        kotlin.jvm.internal.h.a((Object) fVar);
        OperationItemBean operationItemBean = (OperationItemBean) fVar.getData().get(i2);
        kotlin.jvm.internal.h.b(operationItemBean, "item");
        this.f13963m = operationItemBean.a();
        if (!operationItemBean.d()) {
            kk.f fVar2 = this.f13970t;
            kotlin.jvm.internal.h.a((Object) fVar2);
            List data = fVar2.getData();
            kotlin.jvm.internal.h.b(data, "mAdapter2!!.data");
            int size = data.size();
            int i3 = 0;
            while (i3 < size) {
                kk.f fVar3 = this.f13970t;
                kotlin.jvm.internal.h.a((Object) fVar3);
                Object obj = fVar3.getData().get(i3);
                kotlin.jvm.internal.h.b(obj, "mAdapter2!!.data[i]");
                ((OperationItemBean) obj).a(i3 == i2);
                i3++;
            }
        }
        kk.f fVar4 = this.f13970t;
        kotlin.jvm.internal.h.a((Object) fVar4);
        fVar4.notifyDataSetChanged();
        e();
    }

    private final void d() {
        if (this.f13969s.size() == 0) {
            en.a aVar = this.f13955e;
            kotlin.jvm.internal.h.a((Object) aVar);
            if (aVar.z() > 5.3d) {
                this.f13969s.add(new OperationItemBean(2, getString(R.string.hu_xing_mode), R.drawable.quan_jing_03_selector, false, getString(R.string.newui_points_follow_tip)));
            }
            this.f13969s.add(new OperationItemBean(3, getString(R.string.shu_ping_mode), R.drawable.quan_jing_02_selector, false, getString(R.string.newui_ai_follow_tip)));
            this.f13969s.add(new OperationItemBean(4, getString(R.string.heng_ping_mode), R.drawable.quan_jing_01_selector, true, getString(R.string.newui_op_tip)));
        }
        this.f13960j = new kk.g(this.f13969s);
        RecyclerView recyclerView = (RecyclerView) a(com.xeagle.R.id.rvModel);
        kotlin.jvm.internal.h.a((Object) recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this.f13954d, 4));
        RecyclerView recyclerView2 = (RecyclerView) a(com.xeagle.R.id.rvModel);
        kotlin.jvm.internal.h.a((Object) recyclerView2);
        recyclerView2.setAdapter(this.f13960j);
        RecyclerView recyclerView3 = (RecyclerView) a(com.xeagle.R.id.rvModel);
        kotlin.jvm.internal.h.a((Object) recyclerView3);
        recyclerView3.setFocusableInTouchMode(false);
        RecyclerView recyclerView4 = (RecyclerView) a(com.xeagle.R.id.rvModel);
        kotlin.jvm.internal.h.a((Object) recyclerView4);
        recyclerView4.requestFocus();
        a(this.f13969s.get(0));
        kk.g gVar = this.f13960j;
        kotlin.jvm.internal.h.a((Object) gVar);
        gVar.setOnItemClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    public final void d(int i2) {
        kk.f fVar = this.f13971u;
        kotlin.jvm.internal.h.a((Object) fVar);
        OperationItemBean operationItemBean = (OperationItemBean) fVar.getData().get(i2);
        kotlin.jvm.internal.h.b(operationItemBean, "item");
        this.f13951a = operationItemBean.a();
        if (!operationItemBean.d()) {
            kk.f fVar2 = this.f13971u;
            kotlin.jvm.internal.h.a((Object) fVar2);
            List data = fVar2.getData();
            kotlin.jvm.internal.h.b(data, "mAdapter3!!.data");
            int size = data.size();
            int i3 = 0;
            while (i3 < size) {
                kk.f fVar3 = this.f13971u;
                kotlin.jvm.internal.h.a((Object) fVar3);
                Object obj = fVar3.getData().get(i3);
                kotlin.jvm.internal.h.b(obj, "mAdapter3!!.data[i]");
                ((OperationItemBean) obj).a(i3 == i2);
                i3++;
            }
        }
        kk.f fVar4 = this.f13971u;
        kotlin.jvm.internal.h.a((Object) fVar4);
        fVar4.notifyDataSetChanged();
        e();
    }

    private final void e() {
        this.f13952b = this.f13951a * 10 * 1000;
        Log.i("ServeTest", "initAtTime: =====" + this.f13952b);
        TextView textView = (TextView) a(com.xeagle.R.id.tvAtTime);
        kotlin.jvm.internal.h.b(textView, "tvAtTime");
        textView.setText(getString(R.string.at_video_time) + y.c(this.f13952b));
    }

    private final void e(int i2) {
        kk.g gVar = this.f13962l;
        if (gVar != null) {
            kotlin.jvm.internal.h.a((Object) gVar);
            if (gVar.getData().size() <= 0) {
                return;
            }
            if (i2 >= 0 && 9 >= i2) {
                TextView textView = (TextView) a(com.xeagle.R.id.newui_operation_title);
                kotlin.jvm.internal.h.b(textView, "newui_operation_title");
                textView.setVisibility(0);
                TextView textView2 = (TextView) a(com.xeagle.R.id.newui_operation_desc);
                kotlin.jvm.internal.h.b(textView2, "newui_operation_desc");
                textView2.setVisibility(0);
                TextView textView3 = (TextView) a(com.xeagle.R.id.tvDesc);
                kotlin.jvm.internal.h.b(textView3, "tvDesc");
                textView3.setVisibility(8);
                TextView textView4 = (TextView) a(com.xeagle.R.id.newui_operation_title);
                kotlin.jvm.internal.h.a((Object) textView4);
                kk.g gVar2 = this.f13962l;
                kotlin.jvm.internal.h.a((Object) gVar2);
                Object obj = gVar2.getData().get(i2);
                kotlin.jvm.internal.h.b(obj, "mHadapter!!.data[position]");
                textView4.setText(((OperationItemBean) obj).b());
                TextView textView5 = (TextView) a(com.xeagle.R.id.newui_operation_desc);
                kotlin.jvm.internal.h.a((Object) textView5);
                kk.g gVar3 = this.f13962l;
                kotlin.jvm.internal.h.a((Object) gVar3);
                Object obj2 = gVar3.getData().get(i2);
                kotlin.jvm.internal.h.b(obj2, "mHadapter!!.data[position]");
                textView5.setText(((OperationItemBean) obj2).e());
            } else if (i2 == 10) {
                TextView textView6 = (TextView) a(com.xeagle.R.id.newui_operation_title);
                kotlin.jvm.internal.h.b(textView6, "newui_operation_title");
                textView6.setVisibility(8);
                TextView textView7 = (TextView) a(com.xeagle.R.id.newui_operation_desc);
                kotlin.jvm.internal.h.b(textView7, "newui_operation_desc");
                textView7.setVisibility(8);
                TextView textView8 = (TextView) a(com.xeagle.R.id.tvDesc);
                kotlin.jvm.internal.h.b(textView8, "tvDesc");
                textView8.setVisibility(0);
            }
        }
    }

    private final void f() {
        List arrayList = new ArrayList();
        arrayList.add("10");
        arrayList.add("20");
        arrayList.add("30");
        arrayList.add("40");
        arrayList.add("50");
        arrayList.add("60");
        arrayList.add("70");
        this.f13958h = new kk.h(R.layout.newui_wheel_item_layout, arrayList);
        RecyclerView recyclerView = (RecyclerView) a(com.xeagle.R.id.rv_height);
        kotlin.jvm.internal.h.b(recyclerView, "rv_height");
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f13954d, 0, false));
        RecyclerView recyclerView2 = (RecyclerView) a(com.xeagle.R.id.rv_height);
        kotlin.jvm.internal.h.b(recyclerView2, "rv_height");
        recyclerView2.setAdapter(this.f13958h);
        RecyclerView recyclerView3 = (RecyclerView) a(com.xeagle.R.id.rv_height);
        kotlin.jvm.internal.h.b(recyclerView3, "rv_height");
        recyclerView3.setFocusableInTouchMode(false);
        ((RecyclerView) a(com.xeagle.R.id.rv_height)).requestFocus();
        kk.h hVar = this.f13958h;
        kotlin.jvm.internal.h.a((Object) hVar);
        hVar.a(3);
        kk.h hVar2 = this.f13958h;
        kotlin.jvm.internal.h.a((Object) hVar2);
        hVar2.setOnItemClickListener(new C0216a(this));
    }

    /* access modifiers changed from: private */
    public final void f(int i2) {
        int i3;
        int i4;
        int i5 = i2;
        this.f13966p = i5;
        this.f13968r = i5 == this.f13967q && i5 != 0;
        hf.d.a("tempFlyType---->" + this.f13966p + "nowFlyType---->" + this.f13967q + "type---->" + i5);
        b();
        kk.g gVar = this.f13962l;
        if (gVar != null) {
            kotlin.jvm.internal.h.a((Object) gVar);
            List<OperationItemBean> data = gVar.getData();
            kotlin.jvm.internal.h.b(data, "mHadapter!!.data");
            for (OperationItemBean operationItemBean : data) {
                kotlin.jvm.internal.h.b(operationItemBean, "item");
                operationItemBean.a(operationItemBean.a() == i5);
            }
            kk.g gVar2 = this.f13962l;
            kotlin.jvm.internal.h.a((Object) gVar2);
            gVar2.notifyDataSetChanged();
        }
        int i6 = 3;
        int i7 = 10;
        switch (i5) {
            case 0:
                LinearLayout linearLayout = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                kotlin.jvm.internal.h.b(linearLayout, "ll_fly_height");
                linearLayout.setVisibility(8);
                RecyclerView recyclerView = (RecyclerView) a(com.xeagle.R.id.rvModel);
                kotlin.jvm.internal.h.a((Object) recyclerView);
                recyclerView.setVisibility(8);
                LinearLayout linearLayout2 = (LinearLayout) a(com.xeagle.R.id.ll_fly_time);
                kotlin.jvm.internal.h.a((Object) linearLayout2);
                linearLayout2.setVisibility(8);
                LinearLayout linearLayout3 = (LinearLayout) a(com.xeagle.R.id.ll_fly_radius);
                kotlin.jvm.internal.h.a((Object) linearLayout3);
                linearLayout3.setVisibility(8);
                LinearLayout linearLayout4 = (LinearLayout) a(com.xeagle.R.id.ll_circle_shoot);
                kotlin.jvm.internal.h.a((Object) linearLayout4);
                linearLayout4.setVisibility(8);
                e(0);
                return;
            case 1:
                LinearLayout linearLayout5 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                kotlin.jvm.internal.h.b(linearLayout5, "ll_fly_height");
                linearLayout5.setVisibility(8);
                LinearLayout linearLayout6 = (LinearLayout) a(com.xeagle.R.id.ll_fly_time);
                kotlin.jvm.internal.h.a((Object) linearLayout6);
                linearLayout6.setVisibility(8);
                LinearLayout linearLayout7 = (LinearLayout) a(com.xeagle.R.id.ll_fly_radius);
                kotlin.jvm.internal.h.a((Object) linearLayout7);
                linearLayout7.setVisibility(8);
                RecyclerView recyclerView2 = (RecyclerView) a(com.xeagle.R.id.rvModel);
                kotlin.jvm.internal.h.a((Object) recyclerView2);
                recyclerView2.setVisibility(8);
                LinearLayout linearLayout8 = (LinearLayout) a(com.xeagle.R.id.ll_circle_shoot);
                kotlin.jvm.internal.h.a((Object) linearLayout8);
                linearLayout8.setVisibility(8);
                i3 = 1;
                break;
            case 2:
                LinearLayout linearLayout9 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                kotlin.jvm.internal.h.b(linearLayout9, "ll_fly_height");
                linearLayout9.setVisibility(8);
                LinearLayout linearLayout10 = (LinearLayout) a(com.xeagle.R.id.ll_fly_radius);
                kotlin.jvm.internal.h.a((Object) linearLayout10);
                linearLayout10.setVisibility(8);
                LinearLayout linearLayout11 = (LinearLayout) a(com.xeagle.R.id.ll_fly_time);
                kotlin.jvm.internal.h.a((Object) linearLayout11);
                linearLayout11.setVisibility(8);
                RecyclerView recyclerView3 = (RecyclerView) a(com.xeagle.R.id.rvModel);
                kotlin.jvm.internal.h.a((Object) recyclerView3);
                recyclerView3.setVisibility(8);
                LinearLayout linearLayout12 = (LinearLayout) a(com.xeagle.R.id.ll_circle_shoot);
                kotlin.jvm.internal.h.a((Object) linearLayout12);
                linearLayout12.setVisibility(8);
                e(2);
                a(10, 80);
                return;
            case 3:
                FlightActionActivity flightActionActivity = this.f13957g;
                kotlin.jvm.internal.h.a((Object) flightActionActivity);
                if (!flightActionActivity.d()) {
                    try {
                        f(0);
                        ToastUtils.showShort((int) R.string.sd_need_enough);
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    LinearLayout linearLayout13 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                    kotlin.jvm.internal.h.b(linearLayout13, "ll_fly_height");
                    linearLayout13.setVisibility(0);
                    LinearLayout linearLayout14 = (LinearLayout) a(com.xeagle.R.id.ll_fly_radius);
                    kotlin.jvm.internal.h.a((Object) linearLayout14);
                    linearLayout14.setVisibility(8);
                    LinearLayout linearLayout15 = (LinearLayout) a(com.xeagle.R.id.ll_fly_time);
                    kotlin.jvm.internal.h.a((Object) linearLayout15);
                    linearLayout15.setVisibility(8);
                    RecyclerView recyclerView4 = (RecyclerView) a(com.xeagle.R.id.rvModel);
                    kotlin.jvm.internal.h.a((Object) recyclerView4);
                    recyclerView4.setVisibility(8);
                    LinearLayout linearLayout16 = (LinearLayout) a(com.xeagle.R.id.ll_circle_shoot);
                    kotlin.jvm.internal.h.a((Object) linearLayout16);
                    linearLayout16.setVisibility(8);
                    e(3);
                    com.xeagle.android.utils.prefs.a aVar = this.f13956f;
                    kotlin.jvm.internal.h.a((Object) aVar);
                    if (aVar.m()) {
                        com.xeagle.android.utils.prefs.a aVar2 = this.f13956f;
                        kotlin.jvm.internal.h.a((Object) aVar2);
                        i4 = aVar2.n() - 2;
                    } else {
                        com.xeagle.android.utils.prefs.a aVar3 = this.f13956f;
                        kotlin.jvm.internal.h.a((Object) aVar3);
                        i4 = aVar3.aC();
                    }
                    double d2 = (double) i4;
                    en.a aVar4 = this.f13955e;
                    kotlin.jvm.internal.h.a((Object) aVar4);
                    com.flypro.core.drone.variables.a t2 = aVar4.t();
                    kotlin.jvm.internal.h.b(t2, "drone!!.altitude");
                    double b2 = t2.b();
                    Double.isNaN(d2);
                    if (d2 - b2 > ((double) 10)) {
                        en.a aVar5 = this.f13955e;
                        kotlin.jvm.internal.h.a((Object) aVar5);
                        com.flypro.core.drone.variables.a t3 = aVar5.t();
                        kotlin.jvm.internal.h.b(t3, "drone!!.altitude");
                        double b3 = t3.b();
                        double d3 = (double) 11;
                        Double.isNaN(d3);
                        LinearLayout linearLayout17 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                        kotlin.jvm.internal.h.b(linearLayout17, "ll_fly_height");
                        linearLayout17.setVisibility(0);
                        a((int) (b3 + d3), i4);
                        return;
                    }
                    en.a aVar6 = this.f13955e;
                    kotlin.jvm.internal.h.a((Object) aVar6);
                    com.flypro.core.drone.variables.a t4 = aVar6.t();
                    kotlin.jvm.internal.h.b(t4, "drone!!.altitude");
                    t4.b();
                    LinearLayout linearLayout18 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                    kotlin.jvm.internal.h.b(linearLayout18, "ll_fly_height");
                    linearLayout18.setVisibility(8);
                    ToastUtils.showShort((int) R.string.alt_limit_rocket);
                    return;
                }
            case 4:
                FlightActionActivity flightActionActivity2 = this.f13957g;
                kotlin.jvm.internal.h.a((Object) flightActionActivity2);
                if (!flightActionActivity2.d()) {
                    f(0);
                    ToastUtils.showShort((int) R.string.sd_need_enough);
                    return;
                }
                LinearLayout linearLayout19 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                kotlin.jvm.internal.h.b(linearLayout19, "ll_fly_height");
                linearLayout19.setVisibility(8);
                LinearLayout linearLayout20 = (LinearLayout) a(com.xeagle.R.id.ll_fly_time);
                kotlin.jvm.internal.h.a((Object) linearLayout20);
                linearLayout20.setVisibility(8);
                LinearLayout linearLayout21 = (LinearLayout) a(com.xeagle.R.id.ll_fly_radius);
                kotlin.jvm.internal.h.a((Object) linearLayout21);
                linearLayout21.setVisibility(0);
                LinearLayout linearLayout22 = (LinearLayout) a(com.xeagle.R.id.ll_circle_shoot);
                kotlin.jvm.internal.h.a((Object) linearLayout22);
                linearLayout22.setVisibility(8);
                RecyclerView recyclerView5 = (RecyclerView) a(com.xeagle.R.id.rvModel);
                kotlin.jvm.internal.h.a((Object) recyclerView5);
                recyclerView5.setVisibility(8);
                e(4);
                com.xeagle.android.utils.prefs.a aVar7 = this.f13956f;
                kotlin.jvm.internal.h.a((Object) aVar7);
                if (aVar7.m()) {
                    com.xeagle.android.utils.prefs.a aVar8 = this.f13956f;
                    kotlin.jvm.internal.h.a((Object) aVar8);
                    int o2 = aVar8.o();
                    en.a aVar9 = this.f13955e;
                    kotlin.jvm.internal.h.a((Object) aVar9);
                    com.flypro.core.drone.variables.j b4 = aVar9.b();
                    kotlin.jvm.internal.h.b(b4, "drone!!.gps");
                    if (b4.a()) {
                        en.a aVar10 = this.f13955e;
                        kotlin.jvm.internal.h.a((Object) aVar10);
                        com.flypro.core.drone.variables.h L = aVar10.L();
                        kotlin.jvm.internal.h.b(L, "drone!!.droneCoord");
                        double a2 = L.a();
                        en.a aVar11 = this.f13955e;
                        kotlin.jvm.internal.h.a((Object) aVar11);
                        com.flypro.core.drone.variables.h L2 = aVar11.L();
                        kotlin.jvm.internal.h.b(L2, "drone!!.droneCoord");
                        aq.a aVar12 = new aq.a(a2, L2.b());
                        en.a aVar13 = this.f13955e;
                        kotlin.jvm.internal.h.a((Object) aVar13);
                        com.flypro.core.drone.variables.j b5 = aVar13.b();
                        kotlin.jvm.internal.h.b(b5, "drone!!.gps");
                        ef.a b6 = b5.b();
                        kotlin.jvm.internal.h.b(b6, "drone!!.gps.position");
                        double d4 = b6.d();
                        en.a aVar14 = this.f13955e;
                        kotlin.jvm.internal.h.a((Object) aVar14);
                        com.flypro.core.drone.variables.j b7 = aVar14.b();
                        kotlin.jvm.internal.h.b(b7, "drone!!.gps");
                        ef.a b8 = b7.b();
                        kotlin.jvm.internal.h.b(b8, "drone!!.gps.position");
                        o2 -= (int) aq.b.b(aVar12, new aq.a(d4, b8.c())).a();
                        if (o2 < 10) {
                            r a3 = r.a();
                            FlightActionActivity flightActionActivity3 = this.f13957g;
                            kotlin.jvm.internal.h.a((Object) flightActionActivity3);
                            String string = flightActionActivity3.getString(R.string.warning);
                            FlightActionActivity flightActionActivity4 = this.f13957g;
                            kotlin.jvm.internal.h.a((Object) flightActionActivity4);
                            a3.a(string, flightActionActivity4.getString(R.string.mode_beginner_warn), (c.a) new k(this)).show(getChildFragmentManager(), "modeWarn");
                            i7 = 0;
                        }
                    }
                    i6 = o2;
                } else {
                    i6 = 200;
                }
                ArrayList arrayList = new ArrayList();
                while (i7 < i6) {
                    arrayList.add(String.valueOf(i7) + "");
                    i7++;
                }
                kk.h hVar = this.f13959i;
                if (hVar != null) {
                    kotlin.jvm.internal.h.a((Object) hVar);
                    hVar.replaceData(arrayList);
                    kk.h hVar2 = this.f13959i;
                    kotlin.jvm.internal.h.a((Object) hVar2);
                    hVar2.a(0);
                    kk.h hVar3 = this.f13959i;
                    kotlin.jvm.internal.h.a((Object) hVar3);
                    Object obj = hVar3.getData().get(0);
                    kotlin.jvm.internal.h.b(obj, "radiusAdapter!!.data[0]");
                    this.f13965o = Integer.parseInt((String) obj);
                    return;
                }
                return;
            case 5:
                FlightActionActivity flightActionActivity5 = this.f13957g;
                kotlin.jvm.internal.h.a((Object) flightActionActivity5);
                if (flightActionActivity5.d()) {
                    LinearLayout linearLayout23 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                    kotlin.jvm.internal.h.b(linearLayout23, "ll_fly_height");
                    linearLayout23.setVisibility(8);
                    LinearLayout linearLayout24 = (LinearLayout) a(com.xeagle.R.id.ll_fly_time);
                    kotlin.jvm.internal.h.a((Object) linearLayout24);
                    linearLayout24.setVisibility(8);
                    LinearLayout linearLayout25 = (LinearLayout) a(com.xeagle.R.id.ll_fly_radius);
                    kotlin.jvm.internal.h.a((Object) linearLayout25);
                    linearLayout25.setVisibility(8);
                    RecyclerView recyclerView6 = (RecyclerView) a(com.xeagle.R.id.rvModel);
                    kotlin.jvm.internal.h.a((Object) recyclerView6);
                    recyclerView6.setVisibility(8);
                    LinearLayout linearLayout26 = (LinearLayout) a(com.xeagle.R.id.ll_circle_shoot);
                    kotlin.jvm.internal.h.a((Object) linearLayout26);
                    linearLayout26.setVisibility(8);
                    i3 = 5;
                    break;
                } else {
                    f(0);
                    ToastUtils.showShort((int) R.string.sd_need_enough);
                    return;
                }
            case 6:
                FlightActionActivity flightActionActivity6 = this.f13957g;
                kotlin.jvm.internal.h.a((Object) flightActionActivity6);
                if (flightActionActivity6.d()) {
                    LinearLayout linearLayout27 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                    kotlin.jvm.internal.h.b(linearLayout27, "ll_fly_height");
                    linearLayout27.setVisibility(8);
                    LinearLayout linearLayout28 = (LinearLayout) a(com.xeagle.R.id.ll_fly_time);
                    kotlin.jvm.internal.h.a((Object) linearLayout28);
                    linearLayout28.setVisibility(8);
                    LinearLayout linearLayout29 = (LinearLayout) a(com.xeagle.R.id.ll_fly_radius);
                    kotlin.jvm.internal.h.a((Object) linearLayout29);
                    linearLayout29.setVisibility(8);
                    RecyclerView recyclerView7 = (RecyclerView) a(com.xeagle.R.id.rvModel);
                    kotlin.jvm.internal.h.a((Object) recyclerView7);
                    recyclerView7.setVisibility(8);
                    LinearLayout linearLayout30 = (LinearLayout) a(com.xeagle.R.id.ll_circle_shoot);
                    kotlin.jvm.internal.h.a((Object) linearLayout30);
                    linearLayout30.setVisibility(8);
                    i3 = 6;
                    break;
                } else {
                    f(0);
                    ToastUtils.showShort((int) R.string.sd_need_enough);
                    return;
                }
            case 7:
                this.f13965o = 0;
                LinearLayout linearLayout31 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                kotlin.jvm.internal.h.b(linearLayout31, "ll_fly_height");
                linearLayout31.setVisibility(8);
                LinearLayout linearLayout32 = (LinearLayout) a(com.xeagle.R.id.ll_fly_time);
                kotlin.jvm.internal.h.a((Object) linearLayout32);
                linearLayout32.setVisibility(8);
                LinearLayout linearLayout33 = (LinearLayout) a(com.xeagle.R.id.ll_fly_radius);
                kotlin.jvm.internal.h.a((Object) linearLayout33);
                linearLayout33.setVisibility(8);
                RecyclerView recyclerView8 = (RecyclerView) a(com.xeagle.R.id.rvModel);
                kotlin.jvm.internal.h.a((Object) recyclerView8);
                recyclerView8.setVisibility(8);
                LinearLayout linearLayout34 = (LinearLayout) a(com.xeagle.R.id.ll_circle_shoot);
                kotlin.jvm.internal.h.a((Object) linearLayout34);
                linearLayout34.setVisibility(0);
                i3 = 7;
                break;
            case 8:
                String c2 = com.xeagle.android.utils.a.c();
                kotlin.jvm.internal.h.b(c2, "appMem");
                new Regex("\\s").a(c2, "");
                long b9 = com.xeagle.android.utils.a.b(getContext());
                if (com.xeagle.android.utils.a.a() >= 50.0f || ((float) b9) < ((float) 1258291200)) {
                    f(0);
                    ToastUtils.showShort(getString(R.string.phone_no_support_vision), new Object[0]);
                    return;
                }
                com.xeagle.android.utils.prefs.a aVar15 = this.f13956f;
                if (kotlin.text.f.a(aVar15 != null ? aVar15.j() : null, UserGlobal.DRONE_NAME_DF808_D, false, 2, (Object) null)) {
                    en.a aVar16 = this.f13955e;
                    kotlin.jvm.internal.h.a((Object) aVar16);
                    if (aVar16.z() < 6.0d) {
                        f(0);
                        ToastUtils.showShort(getString(R.string.upgrade_drone_new_function), new Object[0]);
                        return;
                    }
                }
                com.xeagle.android.utils.prefs.a aVar17 = this.f13956f;
                if (kotlin.text.f.a(aVar17 != null ? aVar17.j() : null, UserGlobal.DRONE_NAME_DF809_E, false, 2, (Object) null)) {
                    en.a aVar18 = this.f13955e;
                    kotlin.jvm.internal.h.a((Object) aVar18);
                    if (aVar18.z() < 4.4d) {
                        f(0);
                        ToastUtils.showShort(getString(R.string.upgrade_drone_new_function), new Object[0]);
                        return;
                    }
                }
                LinearLayout linearLayout35 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                kotlin.jvm.internal.h.b(linearLayout35, "ll_fly_height");
                linearLayout35.setVisibility(8);
                RecyclerView recyclerView9 = (RecyclerView) a(com.xeagle.R.id.rvModel);
                kotlin.jvm.internal.h.a((Object) recyclerView9);
                recyclerView9.setVisibility(8);
                LinearLayout linearLayout36 = (LinearLayout) a(com.xeagle.R.id.ll_fly_time);
                kotlin.jvm.internal.h.a((Object) linearLayout36);
                linearLayout36.setVisibility(8);
                LinearLayout linearLayout37 = (LinearLayout) a(com.xeagle.R.id.ll_fly_radius);
                kotlin.jvm.internal.h.a((Object) linearLayout37);
                linearLayout37.setVisibility(8);
                LinearLayout linearLayout38 = (LinearLayout) a(com.xeagle.R.id.ll_circle_shoot);
                kotlin.jvm.internal.h.a((Object) linearLayout38);
                linearLayout38.setVisibility(8);
                e(8);
                return;
            case 9:
                FlightActionActivity flightActionActivity7 = this.f13957g;
                kotlin.jvm.internal.h.a((Object) flightActionActivity7);
                Context applicationContext = flightActionActivity7.getApplicationContext();
                Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
                if (((XEagleApp) applicationContext).c()) {
                    com.xeagle.android.utils.prefs.a aVar19 = this.f13956f;
                    if (kotlin.text.f.a(aVar19 != null ? aVar19.j() : null, UserGlobal.DRONE_NAME_DF808_D, false, 2, (Object) null)) {
                        en.a aVar20 = this.f13955e;
                        kotlin.jvm.internal.h.a((Object) aVar20);
                        if (aVar20.z() <= 5.2d) {
                            f(0);
                            ToastUtils.showShort(getString(R.string.upgrade_drone_new_function), new Object[0]);
                            return;
                        }
                    }
                    FlightActionActivity flightActionActivity8 = this.f13957g;
                    kotlin.jvm.internal.h.a((Object) flightActionActivity8);
                    if (flightActionActivity8.d()) {
                        LinearLayout linearLayout39 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                        kotlin.jvm.internal.h.b(linearLayout39, "ll_fly_height");
                        linearLayout39.setVisibility(8);
                        LinearLayout linearLayout40 = (LinearLayout) a(com.xeagle.R.id.ll_fly_radius);
                        kotlin.jvm.internal.h.a((Object) linearLayout40);
                        linearLayout40.setVisibility(8);
                        LinearLayout linearLayout41 = (LinearLayout) a(com.xeagle.R.id.ll_fly_time);
                        kotlin.jvm.internal.h.a((Object) linearLayout41);
                        linearLayout41.setVisibility(8);
                        RecyclerView recyclerView10 = (RecyclerView) a(com.xeagle.R.id.rvModel);
                        kotlin.jvm.internal.h.a((Object) recyclerView10);
                        recyclerView10.setVisibility(0);
                        LinearLayout linearLayout42 = (LinearLayout) a(com.xeagle.R.id.ll_circle_shoot);
                        kotlin.jvm.internal.h.a((Object) linearLayout42);
                        linearLayout42.setVisibility(8);
                        i3 = 9;
                        break;
                    } else {
                        f(0);
                        ToastUtils.showShort((int) R.string.sd_need_enough);
                        return;
                    }
                } else {
                    f(0);
                    return;
                }
            case 10:
                FlightActionActivity flightActionActivity9 = this.f13957g;
                kotlin.jvm.internal.h.a((Object) flightActionActivity9);
                Context applicationContext2 = flightActionActivity9.getApplicationContext();
                Objects.requireNonNull(applicationContext2, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
                if (!((XEagleApp) applicationContext2).c()) {
                    f(0);
                    return;
                }
                com.xeagle.android.utils.prefs.a aVar21 = this.f13956f;
                if (kotlin.text.f.a(aVar21 != null ? aVar21.j() : null, UserGlobal.DRONE_NAME_DF808_D, false, 2, (Object) null)) {
                    en.a aVar22 = this.f13955e;
                    kotlin.jvm.internal.h.a((Object) aVar22);
                    if (aVar22.z() <= 5.2d) {
                        f(0);
                        ToastUtils.showShort(getString(R.string.upgrade_drone_new_function), new Object[0]);
                        return;
                    }
                }
                FlightActionActivity flightActionActivity10 = this.f13957g;
                kotlin.jvm.internal.h.a((Object) flightActionActivity10);
                if (!flightActionActivity10.d()) {
                    f(0);
                    ToastUtils.showShort((int) R.string.sd_need_enough);
                    return;
                }
                this.f13965o = 2;
                LinearLayout linearLayout43 = (LinearLayout) a(com.xeagle.R.id.ll_fly_height);
                kotlin.jvm.internal.h.b(linearLayout43, "ll_fly_height");
                linearLayout43.setVisibility(8);
                LinearLayout linearLayout44 = (LinearLayout) a(com.xeagle.R.id.ll_fly_time);
                kotlin.jvm.internal.h.a((Object) linearLayout44);
                linearLayout44.setVisibility(0);
                LinearLayout linearLayout45 = (LinearLayout) a(com.xeagle.R.id.ll_fly_radius);
                kotlin.jvm.internal.h.a((Object) linearLayout45);
                linearLayout45.setVisibility(8);
                RecyclerView recyclerView11 = (RecyclerView) a(com.xeagle.R.id.rvModel);
                kotlin.jvm.internal.h.a((Object) recyclerView11);
                recyclerView11.setVisibility(8);
                LinearLayout linearLayout46 = (LinearLayout) a(com.xeagle.R.id.ll_circle_shoot);
                kotlin.jvm.internal.h.a((Object) linearLayout46);
                linearLayout46.setVisibility(8);
                e(10);
                return;
            default:
                return;
        }
        e(i3);
    }

    private final void g() {
        this.f13959i = new kk.h(R.layout.newui_wheel_item_layout, new ArrayList());
        RecyclerView recyclerView = (RecyclerView) a(com.xeagle.R.id.rv_radius);
        kotlin.jvm.internal.h.b(recyclerView, "rv_radius");
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f13954d, 0, false));
        RecyclerView recyclerView2 = (RecyclerView) a(com.xeagle.R.id.rv_radius);
        kotlin.jvm.internal.h.b(recyclerView2, "rv_radius");
        recyclerView2.setAdapter(this.f13959i);
        RecyclerView recyclerView3 = (RecyclerView) a(com.xeagle.R.id.rv_radius);
        kotlin.jvm.internal.h.b(recyclerView3, "rv_radius");
        recyclerView3.setFocusableInTouchMode(false);
        ((RecyclerView) a(com.xeagle.R.id.rv_radius)).requestFocus();
        kk.h hVar = this.f13959i;
        kotlin.jvm.internal.h.a((Object) hVar);
        hVar.a(3);
        kk.h hVar2 = this.f13959i;
        kotlin.jvm.internal.h.a((Object) hVar2);
        hVar2.setOnItemClickListener(new c(this));
        List arrayList = new ArrayList();
        arrayList.add("10");
        arrayList.add("20");
        arrayList.add("30");
        arrayList.add("50");
        arrayList.add("70");
        arrayList.add("90");
        arrayList.add("100");
        kk.h hVar3 = this.f13959i;
        kotlin.jvm.internal.h.a((Object) hVar3);
        hVar3.replaceData(arrayList);
    }

    public View a(int i2) {
        if (this.f13972v == null) {
            this.f13972v = new HashMap();
        }
        View view = (View) this.f13972v.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f13972v.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a() {
        HashMap hashMap = this.f13972v;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @l(a = ThreadMode.MAIN)
    public final void modePreStart(z zVar) {
        dismiss();
    }

    public void onAttach(Activity activity) {
        kotlin.jvm.internal.h.d(activity, "activity");
        super.onAttach(activity);
        this.f13957g = (FlightActionActivity) activity;
    }

    public void onClick(View view) {
        int i2;
        kotlin.jvm.internal.h.d(view, "v");
        switch (view.getId()) {
            case R.id.btn_next /*2131296697*/:
                int i3 = this.f13966p;
                this.f13967q = i3;
                this.f13968r = !this.f13968r;
                if (i3 == 9) {
                    this.f13965o = this.f13964n;
                    en.a aVar = this.f13955e;
                    kotlin.jvm.internal.h.a((Object) aVar);
                    if (aVar.z() <= 5.3d && ((i2 = this.f13964n) == 1 || i2 == 2)) {
                        ToastUtils.showShort(getString(R.string.upgrade_drone_new_function), new Object[0]);
                        return;
                    }
                }
                if (this.f13967q == 8) {
                    en.a aVar2 = this.f13955e;
                    kotlin.jvm.internal.h.a((Object) aVar2);
                    com.flypro.core.drone.variables.a t2 = aVar2.t();
                    kotlin.jvm.internal.h.b(t2, "drone!!.altitude");
                    double a2 = t2.a();
                    double d2 = (double) 10;
                    Double.isNaN(d2);
                    if (a2 / d2 < ((double) 4)) {
                        ToastUtils.showShort((int) R.string.flight_to_four);
                        return;
                    }
                    com.xeagle.android.utils.prefs.a aVar3 = this.f13956f;
                    kotlin.jvm.internal.h.a((Object) aVar3);
                    if (aVar3.aQ()) {
                        ((CardView) a(com.xeagle.R.id.card_layout)).setCardBackgroundColor(0);
                        CardView cardView = (CardView) a(com.xeagle.R.id.card_layout);
                        kotlin.jvm.internal.h.b(cardView, "card_layout");
                        cardView.setCardElevation(0.0f);
                        LinearLayout linearLayout = (LinearLayout) a(com.xeagle.R.id.ll_operation);
                        kotlin.jvm.internal.h.b(linearLayout, "ll_operation");
                        linearLayout.setVisibility(8);
                        CardView cardView2 = (CardView) a(com.xeagle.R.id.ll_tracker_dialog);
                        kotlin.jvm.internal.h.b(cardView2, "ll_tracker_dialog");
                        cardView2.setVisibility(0);
                        ((TextView) a(com.xeagle.R.id.tv_dialog_tracker_back)).setOnClickListener(new i(this));
                        ((SlideButton) a(com.xeagle.R.id.unlock_slider)).setOnSeekBarChangeListener(new j(this));
                        return;
                    }
                }
                org.greenrobot.eventbus.c.a().d(new al(this.f13968r, this.f13967q, this.f13963m, this.f13965o, this.f13951a));
                break;
            case R.id.ib_automatic_circle /*2131297387*/:
                this.f13965o = 0;
                IButton iButton = (IButton) a(com.xeagle.R.id.ib_manual_circle);
                kotlin.jvm.internal.h.a((Object) iButton);
                iButton.setTextColor(-7829368);
                IButton iButton2 = (IButton) a(com.xeagle.R.id.ib_automatic_circle);
                kotlin.jvm.internal.h.a((Object) iButton2);
                iButton2.setTextColor(-1);
                return;
            case R.id.ib_manual_circle /*2131297413*/:
                FlightActionActivity flightActionActivity = this.f13957g;
                kotlin.jvm.internal.h.a((Object) flightActionActivity);
                if (!flightActionActivity.d()) {
                    f(0);
                    ToastUtils.showShort((int) R.string.sd_need_enough);
                    return;
                }
                this.f13965o = 1;
                IButton iButton3 = (IButton) a(com.xeagle.R.id.ib_manual_circle);
                kotlin.jvm.internal.h.a((Object) iButton3);
                iButton3.setTextColor(-1);
                IButton iButton4 = (IButton) a(com.xeagle.R.id.ib_automatic_circle);
                kotlin.jvm.internal.h.a((Object) iButton4);
                iButton4.setTextColor(-7829368);
                return;
            case R.id.iv_fly_close /*2131297601*/:
                break;
            default:
                return;
        }
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i2;
        int i3;
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(true);
        kotlin.jvm.internal.h.b(create, "dialog");
        Window window = create.getWindow();
        kotlin.jvm.internal.h.a((Object) window);
        kotlin.jvm.internal.h.b(window, "dialog.window!!");
        window.setGravity(17);
        create.show();
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.h.a((Object) activity);
        kotlin.jvm.internal.h.b(activity, "activity!!");
        WindowManager windowManager = activity.getWindowManager();
        kotlin.jvm.internal.h.b(windowManager, "activity!!.windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        kotlin.jvm.internal.h.b(defaultDisplay, "activity!!.windowManager.defaultDisplay");
        int width = defaultDisplay.getWidth();
        FragmentActivity activity2 = getActivity();
        kotlin.jvm.internal.h.a((Object) activity2);
        kotlin.jvm.internal.h.b(activity2, "activity!!");
        WindowManager windowManager2 = activity2.getWindowManager();
        kotlin.jvm.internal.h.b(windowManager2, "activity!!.windowManager");
        Display defaultDisplay2 = windowManager2.getDefaultDisplay();
        kotlin.jvm.internal.h.b(defaultDisplay2, "activity!!.windowManager.defaultDisplay");
        int height = defaultDisplay2.getHeight();
        if (width >= height) {
            i3 = width - com.xeagle.android.utils.z.a(20);
            i2 = (height * 6) / 7;
        } else {
            i3 = (width * 4) / 5;
            i2 = (height * 2) / 5;
        }
        window.setLayout(i3, i2);
        return create;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.d(layoutInflater, "inflater");
        if (getDialog() != null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f13968r = arguments.getBoolean("isSetFlyModel");
                this.f13967q = arguments.getInt("nowFlyType");
            }
            Dialog dialog = getDialog();
            kotlin.jvm.internal.h.a((Object) dialog);
            kotlin.jvm.internal.h.b(dialog, "dialog!!");
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.addFlags(8);
            }
        }
        return layoutInflater.inflate(R.layout.default_model_fragment, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public void onStart() {
        super.onStart();
        org.greenrobot.eventbus.c.a().a((Object) this);
    }

    public void onStop() {
        super.onStop();
        org.greenrobot.eventbus.c.a().c(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.d(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        Context activity = getActivity();
        this.f13954d = activity;
        kotlin.jvm.internal.h.a((Object) activity);
        Context applicationContext = activity.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
        this.f13955e = ((XEagleApp) applicationContext).k();
        Context context = this.f13954d;
        kotlin.jvm.internal.h.a((Object) context);
        Context applicationContext2 = context.getApplicationContext();
        Objects.requireNonNull(applicationContext2, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
        this.f13956f = ((XEagleApp) applicationContext2).j();
        a(view);
        b();
    }
}
