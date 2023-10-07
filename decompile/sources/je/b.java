package je;

import android.content.Context;
import java.io.File;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public interface b {

    public interface a {
        void a(File file, String str, int i2);
    }

    void a();

    void a(Context context, File file, String str);

    void a(Context context, IMediaPlayer iMediaPlayer, String str, Map<String, String> map, File file);

    void a(a aVar);

    boolean b();

    boolean b(Context context, File file, String str);
}
