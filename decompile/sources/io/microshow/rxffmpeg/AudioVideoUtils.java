package io.microshow.rxffmpeg;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

public class AudioVideoUtils {
    public static long getDuration(String str) {
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrack(mediaExtractor));
            long j2 = trackFormat.containsKey("durationUs") ? trackFormat.getLong("durationUs") : 0;
            mediaExtractor.release();
            return j2;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getFitBitRate(int i2) {
        if (i2 <= 230400) {
            return 1024000;
        }
        if (i2 <= 307200) {
            return 1536000;
        }
        if (i2 <= 384000) {
            return 1843200;
        }
        if (i2 <= 522240) {
            return 2097152;
        }
        if (i2 <= 921600) {
            return 2621440;
        }
        return i2 <= 2088960 ? 3145728 : 3584000;
    }

    public static int getVideoDuration(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        mediaMetadataRetriever.release();
        return Integer.parseInt(extractMetadata) / 1000;
    }

    public static int getVideoHeight(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
        if (!"90".equals(extractMetadata3) && !"270".equals(extractMetadata3)) {
            extractMetadata = extractMetadata2;
        }
        mediaMetadataRetriever.release();
        return Integer.parseInt(extractMetadata);
    }

    public static int getVideoRotation(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
        mediaMetadataRetriever.release();
        return Integer.parseInt(extractMetadata);
    }

    public static int getVideoWidth(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
        if ("90".equals(extractMetadata3) || "270".equals(extractMetadata3)) {
            extractMetadata = extractMetadata2;
        }
        mediaMetadataRetriever.release();
        return Integer.parseInt(extractMetadata);
    }

    public static boolean isHorizontalVideo(String str) {
        return getVideoWidth(str) >= getVideoHeight(str);
    }

    public static int selectAudioTrack(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i2 = 0; i2 < trackCount; i2++) {
            if (mediaExtractor.getTrackFormat(i2).getString(IMediaFormat.KEY_MIME).startsWith("audio/")) {
                return i2;
            }
        }
        return -1;
    }

    public static int selectVideoTrack(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i2 = 0; i2 < trackCount; i2++) {
            if (mediaExtractor.getTrackFormat(i2).getString(IMediaFormat.KEY_MIME).startsWith("video/")) {
                return i2;
            }
        }
        return -1;
    }
}
