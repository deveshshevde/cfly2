package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

public interface b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f15840a = new b() {
        public a a() throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.a();
        }

        public List<a> a(String str, boolean z2, boolean z3) throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.b(str, z2, z3);
        }
    };

    a a() throws MediaCodecUtil.DecoderQueryException;

    List<a> a(String str, boolean z2, boolean z3) throws MediaCodecUtil.DecoderQueryException;
}
