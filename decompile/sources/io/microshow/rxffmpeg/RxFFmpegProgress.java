package io.microshow.rxffmpeg;

public class RxFFmpegProgress {
    public int progress;
    public long progressTime;
    public int state;

    public RxFFmpegProgress(int i2) {
        this(i2, 0, 0);
    }

    public RxFFmpegProgress(int i2, int i3, long j2) {
        this.state = 0;
        this.state = i2;
        this.progress = i3;
        this.progressTime = j2;
    }
}
