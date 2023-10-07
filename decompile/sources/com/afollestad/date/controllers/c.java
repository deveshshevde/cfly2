package com.afollestad.date.controllers;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Vibrator;
import androidx.core.content.b;
import com.afollestad.date.R;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

public final class c {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final a f7398a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private final boolean f7399b;

    /* renamed from: c  reason: collision with root package name */
    private final Vibrator f7400c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f7401d;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public c(Context context, TypedArray typedArray) {
        h.c(context, "context");
        h.c(typedArray, "typedArray");
        this.f7401d = context;
        this.f7399b = typedArray.getBoolean(R.styleable.DatePicker_date_picker_selection_vibrates, true);
        Object systemService = context.getSystemService("vibrator");
        if (systemService != null) {
            this.f7400c = (Vibrator) systemService;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.Vibrator");
    }

    private final boolean b() {
        return b.b(this.f7401d, "android.permission.VIBRATE") == 0;
    }

    public final void a() {
        if (this.f7399b && b()) {
            this.f7400c.vibrate(15);
        }
    }
}
