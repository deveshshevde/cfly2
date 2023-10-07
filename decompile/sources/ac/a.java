package ac;

import android.os.Bundle;
import androidx.lifecycle.ad;
import androidx.lifecycle.n;
import androidx.loader.content.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {

    /* renamed from: ac.a$a  reason: collision with other inner class name */
    public interface C0001a<D> {
        c<D> onCreateLoader(int i2, Bundle bundle);

        void onLoadFinished(c<D> cVar, D d2);

        void onLoaderReset(c<D> cVar);
    }

    public static <T extends n & ad> a a(T t2) {
        return new b(t2, ((ad) t2).getViewModelStore());
    }

    public abstract <D> c<D> a(int i2, Bundle bundle, C0001a<D> aVar);

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
