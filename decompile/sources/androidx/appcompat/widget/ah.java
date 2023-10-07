package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

public class ah {
    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            ai.a(view, charSequence);
        }
    }
}
