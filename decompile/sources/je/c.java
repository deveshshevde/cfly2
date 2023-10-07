package je;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.danikula.videocache.b;
import com.danikula.videocache.g;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.utils.FileUtils;
import com.shuyu.gsyvideoplayer.utils.StorageUtils;
import da.f;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import je.b;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class c implements b, b {

    /* renamed from: a  reason: collision with root package name */
    public static int f29484a = 536870912;

    /* renamed from: f  reason: collision with root package name */
    private static c f29485f;

    /* renamed from: g  reason: collision with root package name */
    private static da.c f29486g;

    /* renamed from: b  reason: collision with root package name */
    protected g f29487b;

    /* renamed from: c  reason: collision with root package name */
    protected File f29488c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f29489d;

    /* renamed from: e  reason: collision with root package name */
    protected d f29490e = new d();

    /* renamed from: h  reason: collision with root package name */
    private b.a f29491h;

    protected static g b(Context context) {
        g gVar = c().f29487b;
        if (gVar != null) {
            return gVar;
        }
        c c2 = c();
        g a2 = c().a(context);
        c2.f29487b = a2;
        return a2;
    }

    public static g b(Context context, File file) {
        if (file == null) {
            return b(context);
        }
        if (c().f29488c == null || c().f29488c.getAbsolutePath().equals(file.getAbsolutePath())) {
            g gVar = c().f29487b;
            if (gVar != null) {
                return gVar;
            }
            c c2 = c();
            g a2 = c().a(context, file);
            c2.f29487b = a2;
            return a2;
        }
        g gVar2 = c().f29487b;
        if (gVar2 != null) {
            gVar2.a();
        }
        c c3 = c();
        g a3 = c().a(context, file);
        c3.f29487b = a3;
        return a3;
    }

    public static synchronized c c() {
        c cVar;
        synchronized (c.class) {
            if (f29485f == null) {
                f29485f = new c();
            }
            cVar = f29485f;
        }
        return cVar;
    }

    public g a(Context context) {
        return new g.a(context.getApplicationContext()).a((db.b) this.f29490e).a();
    }

    public g a(Context context, File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        g.a aVar = new g.a(context);
        aVar.a(file);
        aVar.a((long) f29484a);
        aVar.a((db.b) this.f29490e);
        da.c cVar = f29486g;
        if (cVar != null) {
            aVar.a(cVar);
        }
        this.f29488c = file;
        return aVar.a();
    }

    public void a() {
        g gVar = this.f29487b;
        if (gVar != null) {
            try {
                gVar.a((com.danikula.videocache.b) this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(Context context, File file, String str) {
        if (TextUtils.isEmpty(str)) {
            FileUtils.deleteFiles(new File(StorageUtils.getIndividualCacheDirectory(context.getApplicationContext()).getAbsolutePath()));
            return;
        }
        da.c fVar = new f();
        da.c cVar = f29486g;
        if (cVar != null) {
            fVar = cVar;
        }
        String a2 = fVar.a(str);
        if (file != null) {
            String str2 = file.getAbsolutePath() + File.separator + a2 + ".download";
            CommonUtil.deleteFile(str2);
            CommonUtil.deleteFile(file.getAbsolutePath() + File.separator + a2);
            return;
        }
        String str3 = StorageUtils.getIndividualCacheDirectory(context.getApplicationContext()).getAbsolutePath() + File.separator + a2 + ".download";
        CommonUtil.deleteFile(str3);
        CommonUtil.deleteFile(StorageUtils.getIndividualCacheDirectory(context.getApplicationContext()).getAbsolutePath() + File.separator + a2);
    }

    public void a(Context context, IMediaPlayer iMediaPlayer, String str, Map<String, String> map, File file) {
        d.f29492a.clear();
        if (map != null) {
            d.f29492a.putAll(map);
        }
        if (str.startsWith("http") && !str.contains("127.0.0.1") && !str.contains(".m3u8")) {
            g b2 = b(context.getApplicationContext(), file);
            if (b2 != null) {
                String a2 = b2.a(str);
                boolean z2 = !a2.startsWith("http");
                this.f29489d = z2;
                if (!z2) {
                    b2.a((com.danikula.videocache.b) this, str);
                }
                str = a2;
            }
        } else if (!str.startsWith("http") && !str.startsWith("rtmp") && !str.startsWith("rtsp") && !str.contains(".m3u8")) {
            this.f29489d = true;
        }
        try {
            iMediaPlayer.setDataSource(context, Uri.parse(str), map);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(File file, String str, int i2) {
        b.a aVar = this.f29491h;
        if (aVar != null) {
            aVar.a(file, str, i2);
        }
    }

    public void a(b.a aVar) {
        this.f29491h = aVar;
    }

    public boolean b() {
        return this.f29489d;
    }

    public boolean b(Context context, File file, String str) {
        g b2 = b(context.getApplicationContext(), file);
        if (b2 != null) {
            str = b2.a(str);
        }
        return !str.startsWith("http");
    }
}
