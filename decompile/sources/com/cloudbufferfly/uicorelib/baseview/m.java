package com.cloudbufferfly.uicorelib.baseview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;
import com.cloudbufferfly.uicorelib.utils.a;
import com.cloudbufferfly.uicorelib.utils.b;
import java.util.HashMap;
import kotlin.jvm.internal.h;

public abstract class m extends b {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f10734a;

    public void f() {
        HashMap hashMap = this.f10734a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public int g() {
        return 80;
    }

    public final float h() {
        return 0.0f;
    }

    public final float m() {
        return 0.0f;
    }

    public final float n() {
        return 0.3f;
    }

    public final int o() {
        return 16973826;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            h.a((Object) window, "it");
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = g();
            b bVar = b.f10757a;
            Context context = getContext();
            if (context == null) {
                h.a();
            }
            h.a((Object) context, "context!!");
            attributes.x = bVar.a(context, h());
            b bVar2 = b.f10757a;
            Context context2 = getContext();
            if (context2 == null) {
                h.a();
            }
            h.a((Object) context2, "context!!");
            attributes.y = bVar2.a(context2, m());
            attributes.width = p();
            attributes.height = q();
            window.setAttributes(attributes);
            window.setDimAmount(n());
            window.setWindowAnimations(o());
            a aVar = a.f10756a;
            Context context3 = getContext();
            if (context3 == null) {
                h.a();
            }
            h.a((Object) context3, "context!!");
            window.setBackgroundDrawable(new ColorDrawable(aVar.a(context3, 17170445)));
        }
    }

    public abstract int p();

    public abstract int q();
}
