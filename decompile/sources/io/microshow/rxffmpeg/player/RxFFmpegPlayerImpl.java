package io.microshow.rxffmpeg.player;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import io.microshow.rxffmpeg.player.IMediaPlayer;
import java.lang.ref.WeakReference;

public class RxFFmpegPlayerImpl extends RxFFmpegPlayer implements TextureView.SurfaceTextureListener {
    private static SurfaceTexture mSurfaceTexture;
    private WeakReference<TextureView> mWeakTextureView;

    private TextureView getTextureView() {
        TextureView textureView;
        WeakReference<TextureView> weakReference = this.mWeakTextureView;
        if (weakReference == null || (textureView = (TextureView) weakReference.get()) == null) {
            return null;
        }
        return textureView;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        if (getTextureView() != null) {
            if (mSurfaceTexture == null) {
                mSurfaceTexture = surfaceTexture;
                setSurface(new Surface(mSurfaceTexture));
            } else if (getTextureView() != null) {
                getTextureView().setSurfaceTexture(mSurfaceTexture);
            }
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void play(String str, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            stop();
            setDataSource(str);
            setLooping(z2);
            setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
                public void onPrepared(IMediaPlayer iMediaPlayer) {
                    RxFFmpegPlayerImpl.this.start();
                }
            });
            prepare();
        }
    }

    public void release() {
        stop();
        super.release();
        SurfaceTexture surfaceTexture = mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            mSurfaceTexture = null;
        }
    }

    public void setTextureView(TextureView textureView) {
        if (textureView != null) {
            this.mWeakTextureView = new WeakReference<>(textureView);
            textureView.setSurfaceTextureListener(this);
        }
    }
}
