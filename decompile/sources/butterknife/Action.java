package butterknife;

import android.view.View;

public interface Action<T extends View> {
    void apply(T t2, int i2);
}
