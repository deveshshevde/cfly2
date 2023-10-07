package bo;

import android.util.Log;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class c implements a<ByteBuffer> {
    public boolean a(ByteBuffer byteBuffer, File file, f fVar) {
        try {
            cc.a.a(byteBuffer, file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e2);
            }
            return false;
        }
    }
}
