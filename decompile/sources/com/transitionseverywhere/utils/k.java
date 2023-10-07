package com.transitionseverywhere.utils;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.os.Build;
import android.view.ViewGroup;
import com.transitionseverywhere.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final a f21971a = (Build.VERSION.SDK_INT >= 18 ? new b() : new a());

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Field f21972a;

        /* renamed from: b  reason: collision with root package name */
        private static LayoutTransition f21973b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f21974c;

        a() {
        }

        public void a(ViewGroup viewGroup, boolean z2) {
            LayoutTransition layoutTransition;
            if (f21973b == null) {
                AnonymousClass1 r0 = new LayoutTransition() {
                    public boolean isChangingLayout() {
                        return true;
                    }
                };
                f21973b = r0;
                r0.setAnimator(2, (Animator) null);
                f21973b.setAnimator(0, (Animator) null);
                f21973b.setAnimator(1, (Animator) null);
                f21973b.setAnimator(3, (Animator) null);
                f21973b.setAnimator(4, (Animator) null);
            }
            if (z2) {
                a(viewGroup);
                LayoutTransition layoutTransition2 = viewGroup.getLayoutTransition();
                if (!(layoutTransition2 == null || layoutTransition2 == f21973b)) {
                    viewGroup.setTag(R.id.group_layouttransition_backup, viewGroup.getLayoutTransition());
                }
                layoutTransition = f21973b;
            } else {
                viewGroup.setLayoutTransition((LayoutTransition) null);
                if (f21972a == null) {
                    f21972a = i.a(ViewGroup.class, "mLayoutSuppressed");
                }
                if (!Boolean.FALSE.equals((Boolean) i.a((Object) viewGroup, (Object) Boolean.FALSE, f21972a))) {
                    i.a((Object) viewGroup, f21972a, (Object) false);
                    viewGroup.requestLayout();
                }
                layoutTransition = (LayoutTransition) viewGroup.getTag(R.id.group_layouttransition_backup);
                if (layoutTransition != null) {
                    viewGroup.setTag(R.id.group_layouttransition_backup, (Object) null);
                } else {
                    return;
                }
            }
            viewGroup.setLayoutTransition(layoutTransition);
        }

        public boolean a(ViewGroup viewGroup) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition == null || !layoutTransition.isRunning()) {
                return false;
            }
            if (f21974c == null) {
                f21974c = i.b(LayoutTransition.class, "cancel", new Class[0]);
            }
            i.a((Object) viewGroup.getLayoutTransition(), (Object) null, f21974c);
            return true;
        }
    }

    static class b extends a {

        /* renamed from: a  reason: collision with root package name */
        private static Method f21976a;

        b() {
        }

        public void a(ViewGroup viewGroup, boolean z2) {
            if (f21976a == null) {
                f21976a = i.a((Class<?>) ViewGroup.class, "suppressLayout", (Class<?>[]) new Class[]{Boolean.TYPE});
            }
            i.a((Object) viewGroup, (Object) null, f21976a, (Object) Boolean.valueOf(z2));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z2) {
        if (viewGroup != null) {
            f21971a.a(viewGroup, z2);
        }
    }

    public static boolean a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            return f21971a.a(viewGroup);
        }
        return true;
    }
}
