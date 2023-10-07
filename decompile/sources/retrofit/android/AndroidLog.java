package retrofit.android;

import android.util.Log;
import retrofit.RestAdapter;

public class AndroidLog implements RestAdapter.Log {
    private static final int LOG_CHUNK_SIZE = 4000;
    private final String tag;

    public AndroidLog(String str) {
        this.tag = str;
    }

    public String getTag() {
        return this.tag;
    }

    public final void log(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + LOG_CHUNK_SIZE;
            logChunk(str.substring(i2, Math.min(length, i3)));
            i2 = i3;
        }
    }

    public void logChunk(String str) {
        Log.d(getTag(), str);
    }
}
