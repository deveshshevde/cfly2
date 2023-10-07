package dk;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class f<INFO> implements d<INFO> {

    /* renamed from: a  reason: collision with root package name */
    private final List<d<? super INFO>> f26747a = new ArrayList(2);

    private synchronized void c(String str, Throwable th) {
        Log.e("FdingControllerListener", str, th);
    }

    public synchronized void a(d<? super INFO> dVar) {
        this.f26747a.add(dVar);
    }

    public synchronized void a(String str) {
        int size = this.f26747a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d dVar = this.f26747a.get(i2);
                if (dVar != null) {
                    dVar.a(str);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onRelease", e2);
            }
        }
    }

    public synchronized void a(String str, Object obj) {
        int size = this.f26747a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d dVar = this.f26747a.get(i2);
                if (dVar != null) {
                    dVar.a(str, obj);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onSubmit", e2);
            }
        }
    }

    public synchronized void a(String str, INFO info2, Animatable animatable) {
        int size = this.f26747a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d dVar = this.f26747a.get(i2);
                if (dVar != null) {
                    dVar.a(str, info2, animatable);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onFinalImageSet", e2);
            }
        }
    }

    public void a(String str, Throwable th) {
        int size = this.f26747a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d dVar = this.f26747a.get(i2);
                if (dVar != null) {
                    dVar.a(str, th);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onIntermediateImageFailed", e2);
            }
        }
    }

    public void b(String str, INFO info2) {
        int size = this.f26747a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d dVar = this.f26747a.get(i2);
                if (dVar != null) {
                    dVar.b(str, info2);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onIntermediateImageSet", e2);
            }
        }
    }

    public synchronized void b(String str, Throwable th) {
        int size = this.f26747a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                d dVar = this.f26747a.get(i2);
                if (dVar != null) {
                    dVar.b(str, th);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onFailure", e2);
            }
        }
    }
}
