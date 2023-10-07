package com.xeagle.android.login.ijkplayer;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaPlayerProxy;
import tv.danmaku.ijk.media.player.TextureMediaPlayer;

public class MediaPlayerCompat {
    public static void deselectTrack(IMediaPlayer iMediaPlayer, int i2) {
        IjkMediaPlayer ijkMediaPlayer = getIjkMediaPlayer(iMediaPlayer);
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.deselectTrack(i2);
        }
    }

    public static IjkMediaPlayer getIjkMediaPlayer(IMediaPlayer iMediaPlayer) {
        if (iMediaPlayer == null) {
            return null;
        }
        if (!(iMediaPlayer instanceof IjkMediaPlayer)) {
            if (!(iMediaPlayer instanceof MediaPlayerProxy)) {
                return null;
            }
            MediaPlayerProxy mediaPlayerProxy = (MediaPlayerProxy) iMediaPlayer;
            if (!(mediaPlayerProxy.getInternalMediaPlayer() instanceof IjkMediaPlayer)) {
                return null;
            }
            iMediaPlayer = mediaPlayerProxy.getInternalMediaPlayer();
        }
        return (IjkMediaPlayer) iMediaPlayer;
    }

    public static String getName(IMediaPlayer iMediaPlayer) {
        String str;
        if (iMediaPlayer == null) {
            return "null";
        }
        if (!(iMediaPlayer instanceof TextureMediaPlayer)) {
            return iMediaPlayer.getClass().getSimpleName();
        }
        StringBuilder sb = new StringBuilder("TextureMediaPlayer <");
        IMediaPlayer internalMediaPlayer = ((TextureMediaPlayer) iMediaPlayer).getInternalMediaPlayer();
        if (internalMediaPlayer == null) {
            str = "null>";
        } else {
            sb.append(internalMediaPlayer.getClass().getSimpleName());
            str = ">";
        }
        sb.append(str);
        return sb.toString();
    }

    public static int getSelectedTrack(IMediaPlayer iMediaPlayer, int i2) {
        IjkMediaPlayer ijkMediaPlayer = getIjkMediaPlayer(iMediaPlayer);
        if (ijkMediaPlayer == null) {
            return -1;
        }
        return ijkMediaPlayer.getSelectedTrack(i2);
    }

    public static void selectTrack(IMediaPlayer iMediaPlayer, int i2) {
        IjkMediaPlayer ijkMediaPlayer = getIjkMediaPlayer(iMediaPlayer);
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.selectTrack(i2);
        }
    }
}
