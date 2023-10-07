package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

final class zzg implements zzav {
    private final Context zza;

    public zzg(Context context) {
        this.zza = context;
    }

    public final void zza(Map<String, Object> map) {
        String queryParameter;
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null && (obj = map.get("gtm")) != null && (obj instanceof Map)) {
            obj2 = ((Map) obj).get(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        }
        if (obj2 != null && (obj2 instanceof String) && (queryParameter = Uri.parse((String) obj2).getQueryParameter("referrer")) != null) {
            zzcx.zzc(this.zza, queryParameter);
        }
    }
}
