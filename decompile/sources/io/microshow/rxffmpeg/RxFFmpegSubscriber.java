package io.microshow.rxffmpeg;

import io.microshow.rxffmpeg.RxFFmpegInvoke;
import ma.a;

public abstract class RxFFmpegSubscriber extends a<RxFFmpegProgress> implements RxFFmpegInvoke.IFFmpegListener {
    public static int STATE_CANCEL = -100;
    public static int STATE_PROGRESS = 100;

    public void onComplete() {
        onFinish();
    }

    public void onError(Throwable th) {
        onError(th.getMessage());
    }

    public void onNext(RxFFmpegProgress rxFFmpegProgress) {
        if (rxFFmpegProgress.state == STATE_CANCEL) {
            onCancel();
        } else {
            onProgress(rxFFmpegProgress.progress, rxFFmpegProgress.progressTime);
        }
    }
}
