package dk;

import android.graphics.drawable.Animatable;

public interface d<INFO> {
    void a(String str);

    void a(String str, Object obj);

    void a(String str, INFO info2, Animatable animatable);

    void a(String str, Throwable th);

    void b(String str, INFO info2);

    void b(String str, Throwable th);
}
