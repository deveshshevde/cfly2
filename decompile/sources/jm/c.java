package jm;

import android.view.Surface;

public interface c {
    void onSurfaceAvailable(Surface surface);

    boolean onSurfaceDestroyed(Surface surface);

    void onSurfaceSizeChanged(Surface surface, int i2, int i3);

    void onSurfaceUpdated(Surface surface);
}
