package bu;

import android.util.Log;
import cc.a;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import java.io.File;
import java.io.IOException;

public class d implements h<c> {
    public EncodeStrategy a(f fVar) {
        return EncodeStrategy.SOURCE;
    }

    public boolean a(s<c> sVar, File file, f fVar) {
        try {
            a.a(sVar.d().c(), file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }
}
