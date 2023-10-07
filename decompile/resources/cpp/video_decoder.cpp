//
// Created by Lenovo on 2022/5/17.
//
#include <jni.h>
#include <cstdlib>
#include <android/native_window.h>
#include <android/native_window_jni.h>
#include <stdio.h>
#include <unistd.h>
#include <mutex.h>

#ifdef __cplusplus
extern "C" {
#endif

#include "libavformat/avformat.h"
#include "libswscale/swscale.h"
#include "libavutil/imgutils.h"
#include "video_decoder.h"
#include "ffmpeg_jni_define.h"

#ifdef __cplusplus
}
#endif

struct AVCodecContext *pAVCodecCtx_decoder;
struct AVCodec *pAVCodec_decoder;
struct AVPacket *mAVPacket_decoder;
struct AVFrame *pAVFrame_decoder;
struct AVFrame *pFrameYUV_decoder;
struct SwsContext *sws_ctx;

int video_width, video_height;

ANativeWindow *nativeWindow;
ANativeWindow_Buffer windowBuffer;

using namespace std;
Mutex mutex;

#define TAG "VideoPlayer"

int decoderRelease() {
    mutex.lock();
    if (pAVCodecCtx_decoder) {
        avcodec_close(pAVCodecCtx_decoder);
        avcodec_free_context(&pAVCodecCtx_decoder);
        pAVCodecCtx_decoder = NULL;
    }

    if (pAVFrame_decoder) {
        av_frame_unref(pAVFrame_decoder);
        av_free(pAVFrame_decoder);
        pAVFrame_decoder = NULL;
    }

    if (pFrameYUV_decoder) {
        av_frame_unref(pFrameYUV_decoder);
        av_free(pFrameYUV_decoder);
        pFrameYUV_decoder = NULL;
    }

    if (mAVPacket_decoder) {
        av_packet_unref(mAVPacket_decoder);
    }

    if (nativeWindow) {
        ANativeWindow_release(nativeWindow);
        nativeWindow = NULL;
    }
    mutex.unlock();
    return 0;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_cfly_lib_VideoPlayer_decoderInit(JNIEnv *env, jobject thiz, jobject surface,
                                          jint videoWidth, jint videoHeight) {
    avcodec_register_all();

    pAVCodec_decoder = avcodec_find_decoder(AV_CODEC_ID_H264);
    if (!pAVCodec_decoder) {
        LOGE(TAG, "can not find H264 codec\n");
        return -1;
    }

    pAVCodecCtx_decoder = avcodec_alloc_context3(pAVCodec_decoder);
    if (pAVCodecCtx_decoder == NULL) {
        LOGE(TAG, "Could not alloc video context!\n");
        return -2;
    }

    video_width = videoWidth;
    video_height = videoHeight;

    pAVCodecCtx_decoder->codec_id = AV_CODEC_ID_H264;
    pAVCodecCtx_decoder->codec_type  = AVMEDIA_TYPE_VIDEO;
    pAVCodecCtx_decoder->pix_fmt     = AV_PIX_FMT_YUV420P; //解码器的输出格式
    pAVCodecCtx_decoder->width = videoWidth;//视频宽
    pAVCodecCtx_decoder->height = videoHeight;//视频高
    pAVCodecCtx_decoder->thread_count = 8;

    if (avcodec_open2(pAVCodecCtx_decoder, pAVCodec_decoder, NULL) < 0) {
        LOGE(TAG, "Failed to open h264 decoder");
        return -4;
    }

    pAVFrame_decoder = av_frame_alloc();
    pFrameYUV_decoder = av_frame_alloc();

    nativeWindow = ANativeWindow_fromSurface(env, surface);
    return 0;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_cfly_lib_VideoPlayer_decoderRelease(JNIEnv *env, jobject thiz) {
    return decoderRelease();
}

extern "C" JNIEXPORT jint JNICALL
Java_com_cfly_lib_VideoPlayer_decoderFrame(JNIEnv *env, jobject thiz, jbyteArray frame,
                                           jint frameSize) {
    if (!pAVCodecCtx_decoder || !pAVFrame_decoder || !pFrameYUV_decoder) {
        return -1;
    }

    unsigned char *buf = new unsigned char[frameSize];
    env->GetByteArrayRegion(frame, 0, frameSize, reinterpret_cast<jbyte *>(buf));

/*    av_frame_unref(pAVFrame_decoder);
    av_frame_unref(pFrameYUV_decoder);*/

    mAVPacket_decoder = (AVPacket *) av_malloc(sizeof(AVPacket));
    av_init_packet(mAVPacket_decoder);
    mAVPacket_decoder->data = buf;
    mAVPacket_decoder->size = frameSize;

    int got_frame;

    mutex.lock();
    avcodec_decode_video2(pAVCodecCtx_decoder, pAVFrame_decoder, &got_frame, mAVPacket_decoder);

    LOGE(TAG, "avcodec_send_packet %d, fmt = %d\n", got_frame, pAVCodecCtx_decoder->pix_fmt);

    if (got_frame) {
/*        u_int8_t *out_buffer = (u_int8_t *) av_malloc(avpicture_get_size(AV_PIX_FMT_RGBA, pAVCodecCtx_decoder->width, pAVCodecCtx_decoder->height));
        // 基于指定的图像参数设置图像字段
        // 以及所提供的图像数据缓冲区。
        avpicture_fill((AVPicture *) (pFrameYUV_decoder), out_buffer, AV_PIX_FMT_RGBA, pAVCodecCtx_decoder->width, pAVCodecCtx_decoder->height);*/

        int numBytes = av_image_get_buffer_size(AV_PIX_FMT_RGBA, pAVCodecCtx_decoder->width, pAVCodecCtx_decoder->height, 1);
        u_int8_t *buffer = (uint8_t *)av_malloc(numBytes * sizeof(uint8_t));
        av_image_fill_arrays(pFrameYUV_decoder->data, pFrameYUV_decoder->linesize, buffer, AV_PIX_FMT_RGBA, pAVCodecCtx_decoder->width, pAVCodecCtx_decoder->height, 1);

        ANativeWindow_setBuffersGeometry(nativeWindow, pAVCodecCtx_decoder->width, pAVCodecCtx_decoder->height,
                                         WINDOW_FORMAT_RGBA_8888);

        ANativeWindow_lock(nativeWindow, &windowBuffer, NULL);

        sws_ctx = sws_getContext(pAVCodecCtx_decoder->width,
                                 pAVCodecCtx_decoder->height,
                                 AV_PIX_FMT_YUV420P,
                                 pAVCodecCtx_decoder->width,
                                 pAVCodecCtx_decoder->height,
                                 AV_PIX_FMT_RGBA,
                                 SWS_FAST_BILINEAR,
                                 NULL,
                                 NULL,
                                 NULL);

        // 从srcFrame中的数据（h264）解析成rgb存放到dstFrame中去
        sws_scale(sws_ctx, (const uint8_t *const *)(pAVFrame_decoder->data), pAVFrame_decoder->linesize, 0,
                  pAVCodecCtx_decoder->height, pFrameYUV_decoder->data,
                  pFrameYUV_decoder->linesize
        );

        uint8_t *dst = static_cast<uint8_t *>(windowBuffer.bits);
        int dstStride = windowBuffer.stride * 4;
        uint8_t *src = pFrameYUV_decoder->data[0];
        int srcStride = pFrameYUV_decoder->linesize[0];

        for (int h = 0; h < pAVCodecCtx_decoder->height; h++) {
            memcpy(dst + h * dstStride, src + h * srcStride, srcStride);
        }

        ANativeWindow_unlockAndPost(nativeWindow);
        av_free(buffer);
    }

    mutex.unlock();
    av_packet_unref(mAVPacket_decoder);
    av_free(buf);
    return 0;
}