package com.cfly.customeui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ci.a;
import com.blankj.utilcode.util.ScreenUtils;
import com.cfly.customeui.R;
import com.cfly.customeui.widget.CommonUI;
import com.cfly.customeui.widget.a;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CommonUI {

    public enum DrawableGravity {
        NONE,
        TOP,
        LEFT,
        RIGHT,
        BOTTOM
    }

    public interface a {
        void a(int i2);
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();

        void a(Object... objArr);

        void b();
    }

    public interface d {
        void a();

        void a(Object... objArr);

        void b();
    }

    public interface e {
        void a();
    }

    public interface f {
        void a(ProgressBar progressBar, TextView textView);
    }

    public static a a(Context context, int i2, View view, a aVar) {
        final int[] iArr = new int[1];
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_channel_view, (ViewGroup) null);
        a a2 = new a.C0082a(context).a(inflate).a(true).a(0.7f).b(false).a((ScreenUtils.getScreenWidth() / 3) * 2, (ScreenUtils.getScreenHeight() / 5) * 4).a().a(view, 17, 0, 0);
        final ArrayList arrayList = new ArrayList();
        String[] stringArray = context.getResources().getStringArray(R.array.channel_switch);
        for (int i3 = 0; i3 < 14; i3++) {
            cf.a aVar2 = new cf.a();
            if (i3 == i2 - 1) {
                aVar2.a(true);
            } else {
                aVar2.a(false);
            }
            aVar2.a(stringArray[i3]);
            arrayList.add(aVar2);
        }
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.list_channel);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 5, 1, false));
        recyclerView.a((RecyclerView.g) new RecyclerView.g() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                super.getItemOffsets(rect, view, recyclerView, sVar);
                rect.top = 10;
                rect.bottom = 10;
            }
        });
        final ce.a aVar3 = new ce.a(context, R.layout.channel_item, arrayList);
        recyclerView.setAdapter(aVar3);
        aVar3.setOnItemChildClickListener(new a.C0069a() {
            public void a(ci.a aVar, View view, int i2) {
                if (view.getId() == R.id.cl_item) {
                    for (int i3 = 0; i3 < 14; i3++) {
                        boolean a2 = ((cf.a) arrayList.get(i3)).a();
                        if (i2 == i3) {
                            if (!a2) {
                                ((cf.a) arrayList.get(i3)).a(true);
                            }
                        } else if (a2) {
                            ((cf.a) arrayList.get(i3)).a(false);
                        }
                    }
                    iArr[0] = i2 + 1;
                    aVar3.notifyDataSetChanged();
                }
            }
        });
        inflate.findViewById(R.id.ib_cancel).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a();
            }
        });
        inflate.findViewById(R.id.ib_sumbit).setOnClickListener(new View.OnClickListener(iArr, a2) {
            public final /* synthetic */ int[] f$1;
            public final /* synthetic */ a f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                CommonUI.a(CommonUI.a.this, this.f$1, this.f$2, view);
            }
        });
        return a2;
    }

    public static a a(Context context, View view, String str, int i2, int i3, f fVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_progress_view, (ViewGroup) null);
        a a2 = new a.C0082a(context).a(inflate).a(true).a(0.7f).b(false).a(i2, i3).a().a(view, 17, 0, 0);
        ((TextView) inflate.findViewById(R.id.tv_progress)).setText(str);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.load_view_pb);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_progress_value);
        progressBar.setIndeterminate(false);
        if (fVar != null) {
            fVar.a(progressBar, textView);
        }
        return a2;
    }

    public static a a(Context context, View view, String str, final d dVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_slide_btn, (ViewGroup) null);
        final a a2 = new a.C0082a(context).a(inflate).a(true).a(0.7f).b(false).a(ScreenUtils.getScreenWidth() / 2, ScreenUtils.getScreenHeight() / 2).a().a(view, 17, 0, 0);
        inflate.findViewById(R.id.tv_dialog_tracker_back).setOnClickListener(new View.OnClickListener(a2) {
            public final /* synthetic */ a f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CommonUI.a(CommonUI.d.this, this.f$1, view);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        TextView textView2 = (TextView) inflate.findViewById(R.id.slider_text);
        textView.setText(str);
        if (dVar != null) {
            dVar.a(textView, textView2);
        }
        final SlideButton slideButton = (SlideButton) inflate.findViewById(R.id.unlock_slider);
        slideButton.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar.getProgress() >= 70) {
                    SlideButton.this.setProgress(100);
                    d dVar = dVar;
                    if (dVar != null) {
                        dVar.a();
                    }
                    a2.a();
                }
                SlideButton.this.setProgress(0);
            }
        });
        return a2;
    }

    public static a a(Context context, View view, String str, Integer num, String str2, int i2, b bVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_msg_ok, (ViewGroup) null);
        a a2 = new a.C0082a(context).a(inflate).a(true).a(0.7f).b(false).a(ScreenUtils.getScreenWidth() / 2, ScreenUtils.getScreenHeight() / 2).a().a(view, 17, 0, 0);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
        textView.setVisibility(0);
        textView.setText(str);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.mipmap.warning_third, 0, 0, 0);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_msg);
        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView2.setText(num.intValue());
        IButton iButton = (IButton) inflate.findViewById(R.id.ib_ok);
        iButton.setText(str2);
        a(context, (long) i2, iButton, a2);
        iButton.setOnClickListener(new View.OnClickListener(bVar) {
            public final /* synthetic */ CommonUI.b f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CommonUI.a(a.this, this.f$1, view);
            }
        });
        return a2;
    }

    public static a a(Context context, View view, String str, String str2, long j2, c cVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_dialog_btn, (ViewGroup) null);
        a a2 = new a.C0082a(context).a(inflate).a(true).a(0.7f).b(false).a(ScreenUtils.getScreenWidth() / 2, (ScreenUtils.getScreenHeight() / 5) * 3).a().a(view, 17, 0, 0);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_title);
        textView2.setText(str);
        if (cVar != null) {
            cVar.a(textView2, textView);
        }
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setText(str2);
        IButton iButton = (IButton) inflate.findViewById(R.id.ib_ok);
        a(context, j2, iButton, a2);
        iButton.setOnClickListener(new View.OnClickListener(cVar) {
            public final /* synthetic */ CommonUI.c f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CommonUI.b(a.this, this.f$1, view);
            }
        });
        ((IButton) inflate.findViewById(R.id.ib_cancel)).setOnClickListener(new View.OnClickListener(cVar) {
            public final /* synthetic */ CommonUI.c f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CommonUI.a(a.this, this.f$1, view);
            }
        });
        return a2;
    }

    public static void a(Context context, long j2, IButton iButton, a aVar) {
        final IButton iButton2 = iButton;
        final Context context2 = context;
        final a aVar2 = aVar;
        new CountDownTimer((j2 * 1000) + 50, 1000) {
            public void onFinish() {
                iButton2.setText(context2.getText(R.string.ib_confirm));
                aVar2.a();
            }

            public void onTick(long j2) {
                iButton2.setText(String.format(Locale.US, context2.getString(R.string.cancel_rtl_countdown), new Object[]{Long.valueOf(j2 / 1000)}));
            }
        }.start();
    }

    public static void a(Context context, View view, Integer num) {
        a(context, view, context.getString(num.intValue()), 0, DrawableGravity.NONE, 2, (e) null);
    }

    public static void a(Context context, View view, Integer num, String str, b bVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_msg_ok, (ViewGroup) null);
        a a2 = new a.C0082a(context).a(inflate).a(true).a(0.7f).b(false).a(ScreenUtils.getScreenWidth() / 2, ScreenUtils.getScreenHeight() / 2).a().a(view, 17, 0, 0);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setText(num.intValue());
        IButton iButton = (IButton) inflate.findViewById(R.id.ib_ok);
        iButton.setText(str);
        iButton.setOnClickListener(new View.OnClickListener(bVar) {
            public final /* synthetic */ CommonUI.b f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CommonUI.b(a.this, this.f$1, view);
            }
        });
    }

    public static void a(Context context, View view, String str) {
        a(context, view, str, 0, DrawableGravity.NONE, 2, (e) null);
    }

    public static void a(Context context, View view, String str, int i2, DrawableGravity drawableGravity, long j2, e eVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_toast_msg, (ViewGroup) null);
        a a2 = new a.C0082a(context).a(inflate).a(true).a(0.7f).b(false).a(-2, -2).a().a(view, 17, 0, 0);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        textView.setText(str);
        if (drawableGravity == DrawableGravity.TOP) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
        } else if (drawableGravity == DrawableGravity.LEFT) {
            textView.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        } else if (drawableGravity == DrawableGravity.BOTTOM) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, i2);
        } else if (drawableGravity == DrawableGravity.RIGHT) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, i2, 0);
        }
        io.reactivex.f.a(j2, TimeUnit.SECONDS).a(new lv.d(context, a2, eVar) {
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ a f$1;
            public final /* synthetic */ CommonUI.e f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                CommonUI.b(this.f$0, this.f$1, this.f$2, (Long) obj);
            }
        });
    }

    public static void a(Context context, View view, String str, long j2, e eVar) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_toast_msg, (ViewGroup) null);
        a a2 = new a.C0082a(context).a(inflate).a(true).a(0.7f).b(false).a(-2, -2).a().a(view, 17, 0, 0);
        ((TextView) inflate.findViewById(R.id.tv_msg)).setText(str);
        io.reactivex.f.a(j2, TimeUnit.SECONDS).a(new lv.d(context, a2, eVar) {
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ a f$1;
            public final /* synthetic */ CommonUI.e f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj) {
                CommonUI.a(this.f$0, this.f$1, this.f$2, (Long) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, a aVar, e eVar, Long l2) throws Exception {
        Objects.requireNonNull(aVar);
        ((AppCompatActivity) context).runOnUiThread(new Runnable() {
            public final void run() {
                a.this.a();
            }
        });
        if (eVar != null) {
            eVar.a();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, int[] iArr, a aVar2, View view) {
        if (aVar != null) {
            aVar.a(iArr[0]);
        }
        aVar2.a();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(d dVar, a aVar, View view) {
        if (dVar != null) {
            dVar.b();
        }
        aVar.a();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, b bVar, View view) {
        aVar.a();
        if (bVar != null) {
            bVar.a();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, c cVar, View view) {
        aVar.a();
        if (cVar != null) {
            cVar.a();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(Context context, a aVar, e eVar, Long l2) throws Exception {
        Objects.requireNonNull(aVar);
        ((AppCompatActivity) context).runOnUiThread(new Runnable() {
            public final void run() {
                a.this.a();
            }
        });
        if (eVar != null) {
            eVar.a();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(a aVar, b bVar, View view) {
        aVar.a();
        if (bVar != null) {
            bVar.a();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(a aVar, c cVar, View view) {
        aVar.a();
        if (cVar != null) {
            cVar.b();
        }
    }
}
