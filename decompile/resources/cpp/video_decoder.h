//
// Created by Lenovo on 2022/5/17.
//

#ifndef FFMPEGANDROID_MASTER_VIDEO_DECODER_H
#define FFMPEGANDROID_MASTER_VIDEO_DECODER_H

#ifdef __cplusplus
extern "C" {
#endif
#include "libavcodec/avcodec.h"
#ifdef __cplusplus
}
#endif

/**
 视频流解码器初始化
 @param ctx 解码参数结构体AVCodecParameters
 @see FFmpeg_H264DecoderInit，此为解码H264视频流
 @return 初始化成功返回0，否则<0
 *//*
int decoderInit(AVCodecParameters *ctx);*/

/**
 释放解码器
 @return 初始化成功返回0，否则<0
 */
int decoderRelease();

#endif //FFMPEGANDROID_MASTER_VIDEO_DECODER_H
