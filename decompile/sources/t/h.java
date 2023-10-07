package t;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static Field f34517a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f34518b;

    static class a implements LayoutInflater.Factory2 {

        /* renamed from: a  reason: collision with root package name */
        final i f34519a;

        a(i iVar) {
            this.f34519a = iVar;
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.f34519a.a(view, str, context, attributeSet);
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f34519a.a((View) null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f34519a + "}";
        }
    }

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                b(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                b(layoutInflater, factory2);
            }
        }
    }

    @Deprecated
    public static void a(LayoutInflater layoutInflater, i iVar) {
        a aVar = null;
        if (Build.VERSION.SDK_INT >= 21) {
            if (iVar != null) {
                aVar = new a(iVar);
            }
            layoutInflater.setFactory2(aVar);
            return;
        }
        if (iVar != null) {
            aVar = new a(iVar);
        }
        layoutInflater.setFactory2(aVar);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            b(layoutInflater, (LayoutInflater.Factory2) factory);
        } else {
            b(layoutInflater, aVar);
        }
    }

    private static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f34518b) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f34517a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e2);
            }
            f34518b = true;
        }
        Field field = f34517a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e3) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e3);
            }
        }
    }
}
