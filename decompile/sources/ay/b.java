package ay;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import au.a;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.afollestad.materialdialogs.internal.message.DialogContentLayout;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

public final class b {
    public static final void a(com.afollestad.materialdialogs.b bVar) {
        h.c(bVar, "$this$preShow");
        Object obj = bVar.a().get("md.custom_view_no_vertical_padding");
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        boolean a2 = h.a((Object) (Boolean) obj, (Object) true);
        a.a(bVar.c(), bVar);
        DialogLayout b2 = bVar.b();
        if (b2.getTitleLayout().b() && !a2) {
            b2.getContentLayout().a(b2.getFrameMarginVertical$core(), b2.getFrameMarginVertical$core());
        }
        if (f.a(av.a.a(bVar))) {
            DialogContentLayout.a(b2.getContentLayout(), 0, 0, 1, (Object) null);
        } else if (b2.getContentLayout().a()) {
            DialogContentLayout.b(b2.getContentLayout(), 0, b2.getFrameMarginVerticalLess$core(), 1, (Object) null);
        }
    }

    public static final void b(com.afollestad.materialdialogs.b bVar) {
        h.c(bVar, "$this$hideKeyboard");
        Object systemService = bVar.d().getSystemService("input_method");
        if (systemService != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            View currentFocus = bVar.getCurrentFocus();
            inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : bVar.b().getWindowToken(), 0);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
