package com.xeagle.android.login.ijkplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.xeagle.android.login.ijkplayer.IRenderView;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;
import tv.danmaku.ijk.media.player.ISurfaceTextureHost;

public class TextureRenderView extends TextureView implements IRenderView {
    private static final String TAG = "TextureRenderView";
    private MeasureHelper mMeasureHelper;
    /* access modifiers changed from: private */
    public SurfaceCallback mSurfaceCallback;
    private MediaRecorder mediaRecorder;

    private static final class InternalSurfaceHolder implements IRenderView.ISurfaceHolder {
        private SurfaceTexture mSurfaceTexture;
        private ISurfaceTextureHost mSurfaceTextureHost;
        private TextureRenderView mTextureView;

        public InternalSurfaceHolder(TextureRenderView textureRenderView, SurfaceTexture surfaceTexture, ISurfaceTextureHost iSurfaceTextureHost) {
            this.mTextureView = textureRenderView;
            this.mSurfaceTexture = surfaceTexture;
            this.mSurfaceTextureHost = iSurfaceTextureHost;
        }

        public void bindToMediaPlayer(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer != null) {
                if (Build.VERSION.SDK_INT < 16 || !(iMediaPlayer instanceof ISurfaceTextureHolder)) {
                    iMediaPlayer.setSurface(openSurface());
                    return;
                }
                ISurfaceTextureHolder iSurfaceTextureHolder = (ISurfaceTextureHolder) iMediaPlayer;
                this.mTextureView.mSurfaceCallback.setOwnSurfaceTexture(false);
                SurfaceTexture surfaceTexture = iSurfaceTextureHolder.getSurfaceTexture();
                if (surfaceTexture != null) {
                    this.mTextureView.setSurfaceTexture(surfaceTexture);
                    return;
                }
                iSurfaceTextureHolder.setSurfaceTexture(this.mSurfaceTexture);
                iSurfaceTextureHolder.setSurfaceTextureHost(this.mTextureView.mSurfaceCallback);
            }
        }

        public IRenderView getRenderView() {
            return this.mTextureView;
        }

        public SurfaceHolder getSurfaceHolder() {
            return null;
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public Surface openSurface() {
            if (this.mSurfaceTexture == null) {
                return null;
            }
            return new Surface(this.mSurfaceTexture);
        }
    }

    private static final class SurfaceCallback implements TextureView.SurfaceTextureListener, ISurfaceTextureHost {
        private boolean mDidDetachFromWindow = false;
        private int mHeight;
        private boolean mIsFormatChanged;
        private boolean mOwnSurfaceTexture = true;
        private Map<IRenderView.IRenderCallback, Object> mRenderCallbackMap = new ConcurrentHashMap();
        /* access modifiers changed from: private */
        public SurfaceTexture mSurfaceTexture;
        private WeakReference<TextureRenderView> mWeakRenderView;
        private int mWidth;
        private boolean mWillDetachFromWindow = false;

        public SurfaceCallback(TextureRenderView textureRenderView) {
            this.mWeakRenderView = new WeakReference<>(textureRenderView);
        }

        public void addRenderCallback(IRenderView.IRenderCallback iRenderCallback) {
            InternalSurfaceHolder internalSurfaceHolder;
            this.mRenderCallbackMap.put(iRenderCallback, iRenderCallback);
            if (this.mSurfaceTexture != null) {
                internalSurfaceHolder = new InternalSurfaceHolder((TextureRenderView) this.mWeakRenderView.get(), this.mSurfaceTexture, this);
                iRenderCallback.onSurfaceCreated(internalSurfaceHolder, this.mWidth, this.mHeight);
            } else {
                internalSurfaceHolder = null;
            }
            if (this.mIsFormatChanged) {
                if (internalSurfaceHolder == null) {
                    internalSurfaceHolder = new InternalSurfaceHolder((TextureRenderView) this.mWeakRenderView.get(), this.mSurfaceTexture, this);
                }
                iRenderCallback.onSurfaceChanged(internalSurfaceHolder, 0, this.mWidth, this.mHeight);
            }
        }

        public void didDetachFromWindow() {
            Log.d(TextureRenderView.TAG, "didDetachFromWindow()");
            this.mDidDetachFromWindow = true;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.mSurfaceTexture = surfaceTexture;
            this.mIsFormatChanged = false;
            this.mWidth = 0;
            this.mHeight = 0;
            InternalSurfaceHolder internalSurfaceHolder = new InternalSurfaceHolder((TextureRenderView) this.mWeakRenderView.get(), surfaceTexture, this);
            for (IRenderView.IRenderCallback onSurfaceCreated : this.mRenderCallbackMap.keySet()) {
                onSurfaceCreated.onSurfaceCreated(internalSurfaceHolder, 0, 0);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.mIsFormatChanged = false;
            this.mWidth = 0;
            this.mHeight = 0;
            InternalSurfaceHolder internalSurfaceHolder = new InternalSurfaceHolder((TextureRenderView) this.mWeakRenderView.get(), surfaceTexture, this);
            for (IRenderView.IRenderCallback onSurfaceDestroyed : this.mRenderCallbackMap.keySet()) {
                onSurfaceDestroyed.onSurfaceDestroyed(internalSurfaceHolder);
            }
            Log.d(TextureRenderView.TAG, "onSurfaceTextureDestroyed: destroy: " + this.mOwnSurfaceTexture);
            return this.mOwnSurfaceTexture;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.mSurfaceTexture = surfaceTexture;
            this.mIsFormatChanged = true;
            this.mWidth = i2;
            this.mHeight = i3;
            InternalSurfaceHolder internalSurfaceHolder = new InternalSurfaceHolder((TextureRenderView) this.mWeakRenderView.get(), surfaceTexture, this);
            for (IRenderView.IRenderCallback onSurfaceChanged : this.mRenderCallbackMap.keySet()) {
                onSurfaceChanged.onSurfaceChanged(internalSurfaceHolder, 0, i2, i3);
            }
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {
            String str;
            String str2;
            String str3;
            if (surfaceTexture == null) {
                str2 = "releaseSurfaceTexture: null";
            } else {
                if (!this.mDidDetachFromWindow) {
                    if (this.mWillDetachFromWindow) {
                        if (surfaceTexture != this.mSurfaceTexture) {
                            str3 = "releaseSurfaceTexture: willDetachFromWindow(): release different SurfaceTexture";
                        } else if (!this.mOwnSurfaceTexture) {
                            str = "releaseSurfaceTexture: willDetachFromWindow(): re-attach SurfaceTexture to TextureView";
                        } else {
                            str2 = "releaseSurfaceTexture: willDetachFromWindow(): will released by TextureView";
                        }
                    } else if (surfaceTexture != this.mSurfaceTexture) {
                        str3 = "releaseSurfaceTexture: alive: release different SurfaceTexture";
                    } else if (!this.mOwnSurfaceTexture) {
                        str = "releaseSurfaceTexture: alive: re-attach SurfaceTexture to TextureView";
                    } else {
                        str2 = "releaseSurfaceTexture: alive: will released by TextureView";
                    }
                    Log.d(TextureRenderView.TAG, str);
                    setOwnSurfaceTexture(true);
                    return;
                } else if (surfaceTexture != this.mSurfaceTexture) {
                    str3 = "releaseSurfaceTexture: didDetachFromWindow(): release different SurfaceTexture";
                } else if (!this.mOwnSurfaceTexture) {
                    str3 = "releaseSurfaceTexture: didDetachFromWindow(): release detached SurfaceTexture";
                } else {
                    str2 = "releaseSurfaceTexture: didDetachFromWindow(): already released by TextureView";
                }
                Log.d(TextureRenderView.TAG, str3);
                surfaceTexture.release();
                return;
            }
            Log.d(TextureRenderView.TAG, str2);
        }

        public void removeRenderCallback(IRenderView.IRenderCallback iRenderCallback) {
            this.mRenderCallbackMap.remove(iRenderCallback);
        }

        public void setOwnSurfaceTexture(boolean z2) {
            this.mOwnSurfaceTexture = z2;
        }

        public void willDetachFromWindow() {
            Log.d(TextureRenderView.TAG, "willDetachFromWindow()");
            this.mWillDetachFromWindow = true;
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        initView(context);
    }

    private void initView(Context context) {
        this.mMeasureHelper = new MeasureHelper(this);
        SurfaceCallback surfaceCallback = new SurfaceCallback(this);
        this.mSurfaceCallback = surfaceCallback;
        setSurfaceTextureListener(surfaceCallback);
    }

    public void addRenderCallback(IRenderView.IRenderCallback iRenderCallback) {
        this.mSurfaceCallback.addRenderCallback(iRenderCallback);
    }

    public IRenderView.ISurfaceHolder getSurfaceHolder() {
        return new InternalSurfaceHolder(this, this.mSurfaceCallback.mSurfaceTexture, this.mSurfaceCallback);
    }

    public View getView() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.mSurfaceCallback.willDetachFromWindow();
        super.onDetachedFromWindow();
        this.mSurfaceCallback.didDetachFromWindow();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureRenderView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        this.mMeasureHelper.doMeasure(i2, i3);
        setMeasuredDimension(this.mMeasureHelper.getMeasuredWidth(), this.mMeasureHelper.getMeasuredHeight());
    }

    public void removeRenderCallback(IRenderView.IRenderCallback iRenderCallback) {
        this.mSurfaceCallback.removeRenderCallback(iRenderCallback);
    }

    public void setAspectRatio(int i2) {
        this.mMeasureHelper.setAspectRatio(i2);
        requestLayout();
    }

    public void setVideoRotation(int i2) {
        this.mMeasureHelper.setVideoRotation(i2);
        setRotation((float) i2);
    }

    public void setVideoSampleAspectRatio(int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            this.mMeasureHelper.setVideoSampleAspectRatio(i2, i3);
            requestLayout();
        }
    }

    public void setVideoSize(int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            this.mMeasureHelper.setVideoSize(i2, i3);
            requestLayout();
        }
    }

    public boolean shouldWaitForResize() {
        return false;
    }
}
