package lo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Collection;

public class a {
    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static TextView a(View view) {
        if (view instanceof TextView) {
            return (TextView) view;
        }
        if (view instanceof ViewGroup) {
            return a(((ViewGroup) view).getChildAt(0));
        }
        return null;
    }

    public static <V> boolean a(Collection<V> collection) {
        return collection == null || collection.size() == 0;
    }
}
