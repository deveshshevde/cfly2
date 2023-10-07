package com.xeagle.android.login.ijkplayer;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.app.b;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.config.Settings;
import com.xeagle.android.login.ijkplayer.IRenderView;
import com.xeagle.android.login.listener.IjkPlayerListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

public class IjkVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    public static final int RENDER_NONE = 0;
    public static final int RENDER_SURFACE_VIEW = 1;
    public static final int RENDER_TEXTURE_VIEW = 2;
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static final int[] s_allAspectRatio = {0, 1, 2, 4, 5};
    /* access modifiers changed from: private */
    public String TAG = "IjkVideoView";
    private IjkPlayerListener ijkPlayerListener;
    private List<Integer> mAllRenders = new ArrayList();
    /* access modifiers changed from: private */
    public Context mAppContext;
    private IMediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() {
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i2) {
            int unused = IjkVideoView.this.mCurrentBufferPercentage = i2;
        }
    };
    private boolean mCanPause = true;
    private boolean mCanSeekBack = true;
    private boolean mCanSeekForward = true;
    private IMediaPlayer.OnCompletionListener mCompletionListener = new IMediaPlayer.OnCompletionListener() {
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            int unused = IjkVideoView.this.mCurrentState = 5;
            int unused2 = IjkVideoView.this.mTargetState = 5;
            if (IjkVideoView.this.mMediaController != null) {
                IjkVideoView.this.mMediaController.hide();
            }
            if (IjkVideoView.this.mOnCompletionListener != null) {
                IjkVideoView.this.mOnCompletionListener.onCompletion(IjkVideoView.this.mMediaPlayer);
            }
        }
    };
    private int mCurrentAspectRatio = s_allAspectRatio[0];
    private int mCurrentAspectRatioIndex = 0;
    /* access modifiers changed from: private */
    public int mCurrentBufferPercentage;
    private int mCurrentRender = 0;
    private int mCurrentRenderIndex = 0;
    /* access modifiers changed from: private */
    public int mCurrentState = 0;
    private IMediaPlayer.OnErrorListener mErrorListener = new IMediaPlayer.OnErrorListener() {
        public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3) {
            String access$1800 = IjkVideoView.this.TAG;
            Log.d(access$1800, "Error: " + i2 + "," + i3);
            int unused = IjkVideoView.this.mCurrentState = -1;
            int unused2 = IjkVideoView.this.mTargetState = -1;
            if (IjkVideoView.this.mMediaController != null) {
                IjkVideoView.this.mMediaController.hide();
            }
            if ((IjkVideoView.this.mOnErrorListener == null || !IjkVideoView.this.mOnErrorListener.onError(IjkVideoView.this.mMediaPlayer, i2, i3)) && IjkVideoView.this.getWindowToken() != null) {
                IjkVideoView.this.mAppContext.getResources();
                new b.a(IjkVideoView.this.getContext()).b(i2 == 200 ? R.string.VideoView_error_text_invalid_progressive_playback : R.string.VideoView_error_text_unknown).a((int) R.string.VideoView_error_button, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        IjkVideoView.this.mMediaPlayer.reset();
                        IjkVideoView.this.openVideo();
                        if (IjkVideoView.this.mOnCompletionListener != null) {
                            IjkVideoView.this.mOnCompletionListener.onCompletion(IjkVideoView.this.mMediaPlayer);
                        }
                    }
                }).a(false).c();
            }
            return true;
        }
    };
    private Map<String, String> mHeaders;
    /* access modifiers changed from: private */
    public InfoHudViewHolder mHudViewHolder;
    private IMediaPlayer.OnInfoListener mInfoListener = new IMediaPlayer.OnInfoListener() {
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
            String str;
            String str2;
            if (IjkVideoView.this.mOnInfoListener != null) {
                IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, i2, i3);
            }
            if (i2 == 3) {
                str2 = IjkVideoView.this.TAG;
                str = "MEDIA_INFO_VIDEO_RENDERING_START:---arg1--" + i2 + "---arg2---" + i3;
            } else if (i2 == 901) {
                str2 = IjkVideoView.this.TAG;
                str = "MEDIA_INFO_UNSUPPORTED_SUBTITLE:";
            } else if (i2 == 902) {
                str2 = IjkVideoView.this.TAG;
                str = "MEDIA_INFO_SUBTITLE_TIMED_OUT:";
            } else if (i2 == 10001) {
                int unused = IjkVideoView.this.mVideoRotationDegree = i3;
                Log.d(IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i3);
                if (IjkVideoView.this.mRenderView == null || i3 <= 0) {
                    return true;
                }
                IjkVideoView.this.mRenderView.setVideoRotation(i3);
                return true;
            } else if (i2 != 10002) {
                switch (i2) {
                    case 700:
                        str2 = IjkVideoView.this.TAG;
                        str = "MEDIA_INFO_VIDEO_TRACK_LAGGING:";
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START /*701*/:
                        str2 = IjkVideoView.this.TAG;
                        str = "MEDIA_INFO_BUFFERING_START:";
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END /*702*/:
                        str2 = IjkVideoView.this.TAG;
                        str = "MEDIA_INFO_BUFFERING_END:";
                        break;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /*703*/:
                        str2 = IjkVideoView.this.TAG;
                        str = "MEDIA_INFO_NETWORK_BANDWIDTH: " + i3;
                        break;
                    default:
                        switch (i2) {
                            case 800:
                                str2 = IjkVideoView.this.TAG;
                                str = "MEDIA_INFO_BAD_INTERLEAVING:";
                                break;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /*801*/:
                                str2 = IjkVideoView.this.TAG;
                                str = "MEDIA_INFO_NOT_SEEKABLE:";
                                break;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /*802*/:
                                str2 = IjkVideoView.this.TAG;
                                str = "MEDIA_INFO_METADATA_UPDATE:";
                                break;
                            default:
                                return true;
                        }
                }
            } else {
                str2 = IjkVideoView.this.TAG;
                str = "MEDIA_INFO_AUDIO_RENDERING_START:";
            }
            Log.d(str2, str);
            return true;
        }
    };
    /* access modifiers changed from: private */
    public IMediaController mMediaController;
    /* access modifiers changed from: private */
    public IMediaPlayer mMediaPlayer = null;
    /* access modifiers changed from: private */
    public IMediaPlayer.OnCompletionListener mOnCompletionListener;
    /* access modifiers changed from: private */
    public IMediaPlayer.OnErrorListener mOnErrorListener;
    /* access modifiers changed from: private */
    public IMediaPlayer.OnInfoListener mOnInfoListener;
    /* access modifiers changed from: private */
    public IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private IMediaPlayer.OnTimedTextListener mOnTimedTextListener = new IMediaPlayer.OnTimedTextListener() {
        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            if (ijkTimedText != null) {
                IjkVideoView.this.subtitleDisplay.setText(ijkTimedText.getText());
            }
        }
    };
    /* access modifiers changed from: private */
    public long mPrepareEndTime = 0;
    /* access modifiers changed from: private */
    public long mPrepareStartTime = 0;
    IMediaPlayer.OnPreparedListener mPreparedListener = new IMediaPlayer.OnPreparedListener() {
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            long unused = IjkVideoView.this.mPrepareEndTime = System.currentTimeMillis();
            if (IjkVideoView.this.mHudViewHolder != null) {
                IjkVideoView.this.mHudViewHolder.updateLoadCost(IjkVideoView.this.mPrepareEndTime - IjkVideoView.this.mPrepareStartTime);
            }
            int unused2 = IjkVideoView.this.mCurrentState = 2;
            if (IjkVideoView.this.mOnPreparedListener != null) {
                IjkVideoView.this.mOnPreparedListener.onPrepared(IjkVideoView.this.mMediaPlayer);
            }
            if (IjkVideoView.this.mMediaController != null) {
                IjkVideoView.this.mMediaController.setEnabled(true);
            }
            int unused3 = IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
            int unused4 = IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
            int access$1200 = IjkVideoView.this.mSeekWhenPrepared;
            if (access$1200 != 0) {
                IjkVideoView.this.seekTo(access$1200);
            }
            if (IjkVideoView.this.mVideoWidth == 0 || IjkVideoView.this.mVideoHeight == 0) {
                if (IjkVideoView.this.mTargetState == 3) {
                    IjkVideoView.this.start();
                }
            } else if (IjkVideoView.this.mRenderView != null) {
                IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                if (IjkVideoView.this.mRenderView.shouldWaitForResize() && (IjkVideoView.this.mSurfaceWidth != IjkVideoView.this.mVideoWidth || IjkVideoView.this.mSurfaceHeight != IjkVideoView.this.mVideoHeight)) {
                    return;
                }
                if (IjkVideoView.this.mTargetState == 3) {
                    IjkVideoView.this.start();
                    if (IjkVideoView.this.mMediaController != null) {
                        IjkVideoView.this.mMediaController.show();
                    }
                } else if (IjkVideoView.this.isPlaying()) {
                } else {
                    if ((access$1200 != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.mMediaController != null) {
                        IjkVideoView.this.mMediaController.show(0);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public IRenderView mRenderView;
    IRenderView.IRenderCallback mSHCallback = new IRenderView.IRenderCallback() {
        public void onSurfaceChanged(IRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i3, int i4) {
            if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                Log.e(IjkVideoView.this.TAG, "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            int unused = IjkVideoView.this.mSurfaceWidth = i3;
            int unused2 = IjkVideoView.this.mSurfaceHeight = i4;
            boolean z2 = true;
            boolean z3 = IjkVideoView.this.mTargetState == 3;
            if (IjkVideoView.this.mRenderView.shouldWaitForResize() && !(IjkVideoView.this.mVideoWidth == i3 && IjkVideoView.this.mVideoHeight == i4)) {
                z2 = false;
            }
            if (IjkVideoView.this.mMediaPlayer != null && z3 && z2) {
                if (IjkVideoView.this.mSeekWhenPrepared != 0) {
                    IjkVideoView ijkVideoView = IjkVideoView.this;
                    ijkVideoView.seekTo(ijkVideoView.mSeekWhenPrepared);
                }
                IjkVideoView.this.start();
            }
        }

        public void onSurfaceCreated(IRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i3) {
            if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                Log.e(IjkVideoView.this.TAG, "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            IRenderView.ISurfaceHolder unused = IjkVideoView.this.mSurfaceHolder = iSurfaceHolder;
            if (IjkVideoView.this.mMediaPlayer != null) {
                IjkVideoView ijkVideoView = IjkVideoView.this;
                ijkVideoView.bindSurfaceHolder(ijkVideoView.mMediaPlayer, iSurfaceHolder);
                return;
            }
            IjkVideoView.this.openVideo();
        }

        public void onSurfaceDestroyed(IRenderView.ISurfaceHolder iSurfaceHolder) {
            if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                Log.e(IjkVideoView.this.TAG, "onSurfaceDestroyed: unmatched render callback\n");
                return;
            }
            IRenderView.ISurfaceHolder unused = IjkVideoView.this.mSurfaceHolder = null;
            IjkVideoView.this.releaseWithoutStop();
        }
    };
    private IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() {
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            long unused = IjkVideoView.this.mSeekEndTime = System.currentTimeMillis();
            IjkVideoView.this.mHudViewHolder.updateSeekCost(IjkVideoView.this.mSeekEndTime - IjkVideoView.this.mSeekStartTime);
        }
    };
    /* access modifiers changed from: private */
    public long mSeekEndTime = 0;
    /* access modifiers changed from: private */
    public long mSeekStartTime = 0;
    /* access modifiers changed from: private */
    public int mSeekWhenPrepared;
    private Settings mSettings;
    IMediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i2, int i3, int i4, int i5) {
            int unused = IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
            int unused2 = IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
            int unused3 = IjkVideoView.this.mVideoSarNum = iMediaPlayer.getVideoSarNum();
            int unused4 = IjkVideoView.this.mVideoSarDen = iMediaPlayer.getVideoSarDen();
            Log.i("CmdChannel", "onVideoSizeChanged:--width-- " + i2 + "--height--" + i3);
            if (IjkVideoView.this.mVideoWidth != 0 && IjkVideoView.this.mVideoHeight != 0) {
                if (IjkVideoView.this.mRenderView != null) {
                    IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                    IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                }
                IjkVideoView.this.requestLayout();
            }
        }
    };
    /* access modifiers changed from: private */
    public int mSurfaceHeight;
    /* access modifiers changed from: private */
    public IRenderView.ISurfaceHolder mSurfaceHolder = null;
    /* access modifiers changed from: private */
    public int mSurfaceWidth;
    /* access modifiers changed from: private */
    public int mTargetState = 0;
    private Uri mUri;
    /* access modifiers changed from: private */
    public int mVideoHeight;
    /* access modifiers changed from: private */
    public int mVideoRotationDegree;
    /* access modifiers changed from: private */
    public int mVideoSarDen;
    /* access modifiers changed from: private */
    public int mVideoSarNum;
    /* access modifiers changed from: private */
    public int mVideoWidth;
    /* access modifiers changed from: private */
    public TextView subtitleDisplay;

    public IjkVideoView(Context context) {
        super(context);
        initVideoView(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initVideoView(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initVideoView(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        initVideoView(context);
    }

    private void attachMediaController() {
        IMediaController iMediaController;
        if (this.mMediaPlayer != null && (iMediaController = this.mMediaController) != null) {
            iMediaController.setMediaPlayer(this);
            this.mMediaController.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.mMediaController.setEnabled(isInPlaybackState());
        }
    }

    /* access modifiers changed from: private */
    public void bindSurfaceHolder(IMediaPlayer iMediaPlayer, IRenderView.ISurfaceHolder iSurfaceHolder) {
        if (iMediaPlayer != null) {
            if (iSurfaceHolder == null) {
                iMediaPlayer.setDisplay((SurfaceHolder) null);
            } else {
                iSurfaceHolder.bindToMediaPlayer(iMediaPlayer);
            }
        }
    }

    private String buildLanguage(String str) {
        return TextUtils.isEmpty(str) ? "und" : str;
    }

    private String buildResolution(int i2, int i3, int i4, int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        if (i4 > 1 || i5 > 1) {
            sb.append("[");
            sb.append(i4);
            sb.append(":");
            sb.append(i5);
            sb.append("]");
        }
        return sb.toString();
    }

    private String buildTimeMilli(long j2) {
        long j3 = j2 / 1000;
        long j4 = j3 / 3600;
        long j5 = (j3 % 3600) / 60;
        long j6 = j3 % 60;
        if (j2 <= 0) {
            return "--:--";
        }
        if (j4 >= 100) {
            return String.format(Locale.US, "%d:%02d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)});
        } else if (j4 > 0) {
            return String.format(Locale.US, "%02d:%02d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)});
        } else {
            return String.format(Locale.US, "%02d:%02d", new Object[]{Long.valueOf(j5), Long.valueOf(j6)});
        }
    }

    private String buildTrackType(int i2) {
        return getContext().getString(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? R.string.TrackType_unknown : R.string.TrackType_metadata : R.string.TrackType_subtitle : R.string.TrackType_timedtext : R.string.TrackType_audio : R.string.TrackType_video);
    }

    public static String getPlayerText(Context context, int i2) {
        return context.getString(i2 != 1 ? i2 != 2 ? i2 != 3 ? R.string.N_A : R.string.VideoView_player_IjkExoMediaPlayer : R.string.VideoView_player_IjkMediaPlayer : R.string.VideoView_player_AndroidMediaPlayer);
    }

    public static String getRenderText(Context context, int i2) {
        return context.getString(i2 != 0 ? i2 != 1 ? i2 != 2 ? R.string.N_A : R.string.VideoView_render_texture_view : R.string.VideoView_render_surface_view : R.string.VideoView_render_none);
    }

    private void initRenders() {
        this.mAllRenders.clear();
        if (this.mSettings.getEnableSurfaceView()) {
            this.mAllRenders.add(1);
        }
        if (this.mSettings.getEnableTextureView() && Build.VERSION.SDK_INT >= 14) {
            this.mAllRenders.add(2);
        }
        if (this.mSettings.getEnableNoView()) {
            this.mAllRenders.add(0);
        }
        if (this.mAllRenders.isEmpty()) {
            this.mAllRenders.add(1);
        }
        int intValue = this.mAllRenders.get(this.mCurrentRenderIndex).intValue();
        this.mCurrentRender = intValue;
        setRender(intValue);
    }

    private void initVideoView(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mSettings = new Settings(applicationContext);
        initRenders();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.mCurrentState = 0;
        this.mTargetState = 0;
        TextView textView = new TextView(context);
        this.subtitleDisplay = textView;
        textView.setTextSize(24.0f);
        this.subtitleDisplay.setGravity(17);
        addView(this.subtitleDisplay, new FrameLayout.LayoutParams(-1, -2, 80));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r3.mCurrentState;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isInPlaybackState() {
        /*
            r3 = this;
            tv.danmaku.ijk.media.player.IMediaPlayer r0 = r3.mMediaPlayer
            r1 = 1
            if (r0 == 0) goto L_0x000f
            int r0 = r3.mCurrentState
            r2 = -1
            if (r0 == r2) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            if (r0 == r1) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.ijkplayer.IjkVideoView.isInPlaybackState():boolean");
    }

    /* access modifiers changed from: private */
    public void openVideo() {
        Log.i("CmdChannel", "openVideo: ");
        if (this.mUri != null && this.mSurfaceHolder != null) {
            release(false);
            try {
                IMediaPlayer createPlayer = createPlayer(this.mSettings.getPlayer());
                this.mMediaPlayer = createPlayer;
                createPlayer.setOnPreparedListener(this.mPreparedListener);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
                this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
                this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
                this.mMediaPlayer.setOnSeekCompleteListener(this.mSeekCompleteListener);
                this.mMediaPlayer.setOnTimedTextListener(this.mOnTimedTextListener);
                this.mCurrentBufferPercentage = 0;
                String scheme = this.mUri.getScheme();
                if (Build.VERSION.SDK_INT >= 23 && this.mSettings.getUsingMediaDataSource() && (TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file"))) {
                    this.mMediaPlayer.setDataSource((IMediaDataSource) new FileMediaDataSource(new File(this.mUri.toString())));
                } else if (Build.VERSION.SDK_INT >= 14) {
                    this.mMediaPlayer.setDataSource(this.mAppContext, this.mUri, this.mHeaders);
                } else {
                    this.mMediaPlayer.setDataSource(this.mUri.toString());
                }
                bindSurfaceHolder(this.mMediaPlayer, this.mSurfaceHolder);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                this.mPrepareStartTime = System.currentTimeMillis();
                this.mMediaPlayer.prepareAsync();
                InfoHudViewHolder infoHudViewHolder = this.mHudViewHolder;
                if (infoHudViewHolder != null) {
                    infoHudViewHolder.setMediaPlayer(this.mMediaPlayer);
                }
                this.mCurrentState = 1;
                attachMediaController();
            } catch (IOException | IllegalArgumentException e2) {
                String str = this.TAG;
                Log.w(str, "Unable to open content: " + this.mUri, e2);
                this.mCurrentState = -1;
                this.mTargetState = -1;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            }
        }
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        this.mUri = uri;
        this.mHeaders = map;
        this.mSeekWhenPrepared = 0;
        openVideo();
        requestLayout();
        invalidate();
    }

    private void toggleMediaControlsVisiblity() {
        if (this.mMediaController.isShowing()) {
            this.mMediaController.hide();
        } else {
            this.mMediaController.show();
        }
    }

    public boolean canPause() {
        return this.mCanPause;
    }

    public boolean canSeekBackward() {
        return this.mCanSeekBack;
    }

    public boolean canSeekForward() {
        return this.mCanSeekForward;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public tv.danmaku.ijk.media.player.IMediaPlayer createPlayer(int r12) {
        /*
            r11 = this;
            r0 = 1
            if (r12 == r0) goto L_0x009e
            r1 = 3
            if (r12 == r1) goto L_0x0096
            r12 = 0
            android.net.Uri r1 = r11.mUri
            if (r1 == 0) goto L_0x008e
            tv.danmaku.ijk.media.player.IjkMediaPlayer r12 = new tv.danmaku.ijk.media.player.IjkMediaPlayer
            r12.<init>()
            r1 = 4
            tv.danmaku.ijk.media.player.IjkMediaPlayer.native_setLogLevel(r1)
            java.lang.String r2 = "analyzeduration"
            r3 = 1
            r12.setOption((int) r0, (java.lang.String) r2, (long) r3)
            r5 = 200(0xc8, double:9.9E-322)
            java.lang.String r2 = "probesize"
            r12.setOption((int) r0, (java.lang.String) r2, (long) r5)
            com.xeagle.android.login.config.Settings r2 = r11.mSettings
            boolean r2 = r2.getUsingMediaCodec()
            java.lang.String r5 = "mediacodec"
            r6 = 0
            if (r2 == 0) goto L_0x0050
            r12.setOption((int) r1, (java.lang.String) r5, (long) r3)
            com.xeagle.android.login.config.Settings r2 = r11.mSettings
            boolean r2 = r2.getUsingMediaCodecAutoRotate()
            java.lang.String r5 = "mediacodec-auto-rotate"
            if (r2 == 0) goto L_0x003f
            r12.setOption((int) r1, (java.lang.String) r5, (long) r3)
            goto L_0x0042
        L_0x003f:
            r12.setOption((int) r1, (java.lang.String) r5, (long) r6)
        L_0x0042:
            com.xeagle.android.login.config.Settings r2 = r11.mSettings
            boolean r2 = r2.getMediaCodecHandleResolutionChange()
            java.lang.String r5 = "mediacodec-handle-resolution-change"
            if (r2 == 0) goto L_0x0050
            r12.setOption((int) r1, (java.lang.String) r5, (long) r3)
            goto L_0x0053
        L_0x0050:
            r12.setOption((int) r1, (java.lang.String) r5, (long) r6)
        L_0x0053:
            com.xeagle.android.login.config.Settings r2 = r11.mSettings
            boolean r2 = r2.getUsingOpenSLES()
            java.lang.String r5 = "opensles"
            if (r2 == 0) goto L_0x0061
            r12.setOption((int) r1, (java.lang.String) r5, (long) r3)
            goto L_0x0064
        L_0x0061:
            r12.setOption((int) r1, (java.lang.String) r5, (long) r6)
        L_0x0064:
            com.xeagle.android.login.config.Settings r2 = r11.mSettings
            java.lang.String r2 = r2.getPixelFormat()
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r8 = "overlay-format"
            if (r5 == 0) goto L_0x0079
            r9 = 842225234(0x32335652, double:4.16114554E-315)
            r12.setOption((int) r1, (java.lang.String) r8, (long) r9)
            goto L_0x007c
        L_0x0079:
            r12.setOption((int) r1, (java.lang.String) r8, (java.lang.String) r2)
        L_0x007c:
            java.lang.String r2 = "framedrop"
            r12.setOption((int) r1, (java.lang.String) r2, (long) r3)
            java.lang.String r1 = "http-detect-range-support"
            r12.setOption((int) r0, (java.lang.String) r1, (long) r6)
            r0 = 2
            r1 = 48
            java.lang.String r3 = "skip_loop_filter"
            r12.setOption((int) r0, (java.lang.String) r3, (long) r1)
        L_0x008e:
            com.xeagle.android.login.listener.IjkPlayerListener r0 = r11.ijkPlayerListener
            if (r0 == 0) goto L_0x00a3
            r0.onIjkPlayer(r12)
            goto L_0x00a3
        L_0x0096:
            tv.danmaku.ijk.media.exo.IjkExoMediaPlayer r12 = new tv.danmaku.ijk.media.exo.IjkExoMediaPlayer
            android.content.Context r0 = r11.mAppContext
            r12.<init>(r0)
            goto L_0x00a3
        L_0x009e:
            tv.danmaku.ijk.media.player.AndroidMediaPlayer r12 = new tv.danmaku.ijk.media.player.AndroidMediaPlayer
            r12.<init>()
        L_0x00a3:
            com.xeagle.android.login.config.Settings r0 = r11.mSettings
            boolean r0 = r0.getEnableDetachedSurfaceTextureView()
            if (r0 == 0) goto L_0x00b1
            tv.danmaku.ijk.media.player.TextureMediaPlayer r0 = new tv.danmaku.ijk.media.player.TextureMediaPlayer
            r0.<init>(r12)
            r12 = r0
        L_0x00b1:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.ijkplayer.IjkVideoView.createPlayer(int):tv.danmaku.ijk.media.player.IMediaPlayer");
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    public Bitmap getCurrentFrame() {
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView instanceof TextureRenderView) {
            return ((TextureRenderView) iRenderView).getBitmap();
        }
        return null;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return (int) this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (isInPlaybackState()) {
            return (int) this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z2 = (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 == 5 || i2 == 6) ? false : true;
        if (isInPlaybackState() && z2 && this.mMediaController != null) {
            if (i2 == 79 || i2 == 85) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                } else {
                    start();
                    this.mMediaController.hide();
                }
                return true;
            } else if (i2 == 126) {
                if (!this.mMediaPlayer.isPlaying()) {
                    start();
                    this.mMediaController.hide();
                }
                return true;
            } else if (i2 == 86 || i2 == 127) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                }
                return true;
            } else {
                toggleMediaControlsVisiblity();
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isInPlaybackState() || this.mMediaController == null) {
            return false;
        }
        toggleMediaControlsVisiblity();
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!isInPlaybackState() || this.mMediaController == null) {
            return false;
        }
        toggleMediaControlsVisiblity();
        return false;
    }

    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void release(boolean z2) {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            if (z2) {
                this.mTargetState = 0;
            }
        }
    }

    public void releaseWithoutStop() {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay((SurfaceHolder) null);
        }
    }

    public void reset() {
        this.mMediaPlayer.reset();
    }

    public void resume() {
        openVideo();
    }

    public void seekTo(int i2) {
        if (isInPlaybackState()) {
            this.mSeekStartTime = System.currentTimeMillis();
            this.mMediaPlayer.seekTo((long) i2);
            i2 = 0;
        }
        this.mSeekWhenPrepared = i2;
    }

    public void setHudView(TableLayout tableLayout) {
        this.mHudViewHolder = new InfoHudViewHolder(getContext(), tableLayout);
    }

    public void setIjkPlayerListener(IjkPlayerListener ijkPlayerListener2) {
        this.ijkPlayerListener = ijkPlayerListener2;
    }

    public void setMediaController(IMediaController iMediaController) {
        IMediaController iMediaController2 = this.mMediaController;
        if (iMediaController2 != null) {
            iMediaController2.hide();
        }
        this.mMediaController = iMediaController;
        attachMediaController();
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.xeagle.android.login.ijkplayer.SurfaceRenderView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: com.xeagle.android.login.ijkplayer.SurfaceRenderView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: com.xeagle.android.login.ijkplayer.TextureRenderView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: com.xeagle.android.login.ijkplayer.SurfaceRenderView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: com.xeagle.android.login.ijkplayer.SurfaceRenderView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: com.xeagle.android.login.ijkplayer.SurfaceRenderView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setRender(int r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0065
            r0 = 1
            if (r5 == r0) goto L_0x005b
            r1 = 2
            if (r5 == r1) goto L_0x0021
            java.lang.String r1 = r4.TAG
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r3 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0[r3] = r5
            java.lang.String r5 = "invalid render %d\n"
            java.lang.String r5 = java.lang.String.format(r2, r5, r0)
            android.util.Log.e(r1, r5)
            goto L_0x0069
        L_0x0021:
            com.xeagle.android.login.ijkplayer.TextureRenderView r5 = new com.xeagle.android.login.ijkplayer.TextureRenderView
            android.content.Context r0 = r4.getContext()
            r5.<init>(r0)
            tv.danmaku.ijk.media.player.IMediaPlayer r0 = r4.mMediaPlayer
            if (r0 == 0) goto L_0x0066
            com.xeagle.android.login.ijkplayer.IRenderView$ISurfaceHolder r0 = r5.getSurfaceHolder()
            tv.danmaku.ijk.media.player.IMediaPlayer r1 = r4.mMediaPlayer
            r0.bindToMediaPlayer(r1)
            tv.danmaku.ijk.media.player.IMediaPlayer r0 = r4.mMediaPlayer
            int r0 = r0.getVideoWidth()
            tv.danmaku.ijk.media.player.IMediaPlayer r1 = r4.mMediaPlayer
            int r1 = r1.getVideoHeight()
            r5.setVideoSize(r0, r1)
            tv.danmaku.ijk.media.player.IMediaPlayer r0 = r4.mMediaPlayer
            int r0 = r0.getVideoSarNum()
            tv.danmaku.ijk.media.player.IMediaPlayer r1 = r4.mMediaPlayer
            int r1 = r1.getVideoSarDen()
            r5.setVideoSampleAspectRatio(r0, r1)
            int r0 = r4.mCurrentAspectRatio
            r5.setAspectRatio(r0)
            goto L_0x0066
        L_0x005b:
            com.xeagle.android.login.ijkplayer.SurfaceRenderView r5 = new com.xeagle.android.login.ijkplayer.SurfaceRenderView
            android.content.Context r0 = r4.getContext()
            r5.<init>(r0)
            goto L_0x0066
        L_0x0065:
            r5 = 0
        L_0x0066:
            r4.setRenderView(r5)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.ijkplayer.IjkVideoView.setRender(int):void");
    }

    public void setRenderView(IRenderView iRenderView) {
        int i2;
        int i3;
        if (this.mRenderView != null) {
            IMediaPlayer iMediaPlayer = this.mMediaPlayer;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay((SurfaceHolder) null);
            }
            View view = this.mRenderView.getView();
            this.mRenderView.removeRenderCallback(this.mSHCallback);
            this.mRenderView = null;
            removeView(view);
        }
        if (iRenderView != null) {
            this.mRenderView = iRenderView;
            iRenderView.setAspectRatio(this.mCurrentAspectRatio);
            int i4 = this.mVideoWidth;
            if (i4 > 0 && (i3 = this.mVideoHeight) > 0) {
                iRenderView.setVideoSize(i4, i3);
            }
            int i5 = this.mVideoSarNum;
            if (i5 > 0 && (i2 = this.mVideoSarDen) > 0) {
                iRenderView.setVideoSampleAspectRatio(i5, i2);
            }
            View view2 = this.mRenderView.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            addView(view2);
            this.mRenderView.addRenderCallback(this.mSHCallback);
            int i6 = this.mVideoRotationDegree;
            if (i6 > 0) {
                this.mRenderView.setVideoRotation(i6);
            }
        }
    }

    public void setRenderViewGone() {
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.getView().setVisibility(8);
        }
    }

    public void setRenderViewVisible() {
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.getView().setVisibility(0);
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, (Map<String, String>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String showMedia(tv.danmaku.ijk.media.player.IjkMediaPlayer r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = 1
            int r3 = com.xeagle.android.login.ijkplayer.MediaPlayerCompat.getSelectedTrack(r1, r2)
            r4 = 2
            int r5 = com.xeagle.android.login.ijkplayer.MediaPlayerCompat.getSelectedTrack(r1, r4)
            r6 = 3
            int r6 = com.xeagle.android.login.ijkplayer.MediaPlayerCompat.getSelectedTrack(r1, r6)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            tv.danmaku.ijk.media.player.misc.IjkTrackInfo[] r1 = r20.getTrackInfo()
            if (r1 == 0) goto L_0x0204
            r8 = -1
            int r9 = r1.length
            r10 = 0
            r11 = 0
        L_0x0022:
            if (r11 >= r9) goto L_0x01ff
            r12 = r1[r11]
            int r8 = r8 + r2
            java.lang.String r13 = "rtsp"
            java.lang.String r14 = "showMedia: "
            android.util.Log.i(r13, r14)
            int r14 = r12.getTrackType()
            java.lang.String r4 = "\n"
            if (r8 != r3) goto L_0x0066
            android.content.Context r15 = r19.getContext()
            r16 = r1
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.Integer r17 = java.lang.Integer.valueOf(r8)
            r1[r10] = r17
            r10 = 2131821808(0x7f1104f0, float:1.927637E38)
            java.lang.String r1 = r15.getString(r10, r1)
            r7.append(r1)
            java.lang.String r1 = "\n "
            r7.append(r1)
            android.content.Context r1 = r19.getContext()
            r10 = 2131821795(0x7f1104e3, float:1.9276343E38)
            java.lang.String r1 = r1.getString(r10)
        L_0x005e:
            r7.append(r1)
            r7.append(r4)
            r15 = 0
            goto L_0x00d4
        L_0x0066:
            r16 = r1
            java.lang.String r1 = " \n"
            if (r8 != r5) goto L_0x0093
            android.content.Context r10 = r19.getContext()
            java.lang.Object[] r15 = new java.lang.Object[r2]
            java.lang.Integer r18 = java.lang.Integer.valueOf(r8)
            r17 = 0
            r15[r17] = r18
            r2 = 2131821808(0x7f1104f0, float:1.927637E38)
            java.lang.String r2 = r10.getString(r2, r15)
            r7.append(r2)
            r7.append(r1)
            android.content.Context r1 = r19.getContext()
            r2 = 2131821793(0x7f1104e1, float:1.927634E38)
        L_0x008e:
            java.lang.String r1 = r1.getString(r2)
            goto L_0x005e
        L_0x0093:
            if (r8 != r6) goto L_0x00b9
            android.content.Context r2 = r19.getContext()
            r10 = 1
            java.lang.Object[] r15 = new java.lang.Object[r10]
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)
            r17 = 0
            r15[r17] = r10
            r10 = 2131821808(0x7f1104f0, float:1.927637E38)
            java.lang.String r2 = r2.getString(r10, r15)
            r7.append(r2)
            r7.append(r1)
            android.content.Context r1 = r19.getContext()
            r2 = 2131821794(0x7f1104e2, float:1.9276341E38)
            goto L_0x008e
        L_0x00b9:
            android.content.Context r1 = r19.getContext()
            r2 = 1
            java.lang.Object[] r10 = new java.lang.Object[r2]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            r15 = 0
            r10[r15] = r2
            r2 = 2131821808(0x7f1104f0, float:1.927637E38)
            java.lang.String r1 = r1.getString(r2, r10)
            r7.append(r1)
            r7.append(r4)
        L_0x00d4:
            r1 = 2131821809(0x7f1104f1, float:1.9276372E38)
            r7.append(r1)
            java.lang.String r1 = ":"
            r7.append(r1)
            java.lang.String r2 = r0.buildTrackType(r14)
            r7.append(r2)
            r7.append(r4)
            r2 = 2131821800(0x7f1104e8, float:1.9276353E38)
            r7.append(r2)
            r7.append(r1)
            java.lang.String r2 = r12.getLanguage()
            java.lang.String r2 = r0.buildLanguage(r2)
            r7.append(r2)
            r7.append(r4)
            tv.danmaku.ijk.media.player.misc.IMediaFormat r2 = r12.getFormat()
            if (r2 != 0) goto L_0x0108
            goto L_0x01f3
        L_0x0108:
            boolean r10 = r2 instanceof tv.danmaku.ijk.media.player.misc.IjkMediaFormat
            if (r10 == 0) goto L_0x01f3
            java.lang.String r10 = "ijk-bit-rate-ui"
            java.lang.String r15 = "ijk-profile-level-ui"
            java.lang.String r12 = "ijk-codec-long-name-ui"
            r0 = 1
            if (r14 == r0) goto L_0x0161
            r0 = 2
            if (r14 == r0) goto L_0x011a
            goto L_0x01da
        L_0x011a:
            r14 = 2131821798(0x7f1104e6, float:1.927635E38)
            r7.append(r14)
            r7.append(r1)
            java.lang.String r12 = r2.getString(r12)
            r7.append(r12)
            r7.append(r4)
            r12 = 2131821805(0x7f1104ed, float:1.9276364E38)
            r7.append(r12)
            r7.append(r1)
            java.lang.String r12 = r2.getString(r15)
            r7.append(r12)
            r7.append(r4)
            r12 = 2131821807(0x7f1104ef, float:1.9276368E38)
            r7.append(r12)
            r7.append(r1)
            java.lang.String r12 = "ijk-sample-rate-ui"
            java.lang.String r12 = r2.getString(r12)
            r7.append(r12)
            r7.append(r4)
            r12 = 2131821797(0x7f1104e5, float:1.9276347E38)
            r7.append(r12)
            r7.append(r1)
            java.lang.String r12 = "ijk-channel-ui"
            goto L_0x01bd
        L_0x0161:
            r0 = 2
            r14 = 2131821798(0x7f1104e6, float:1.927635E38)
            r7.append(r14)
            r7.append(r1)
            java.lang.String r12 = r2.getString(r12)
            r7.append(r12)
            r7.append(r4)
            r12 = 2131821805(0x7f1104ed, float:1.9276364E38)
            r7.append(r12)
            r7.append(r1)
            java.lang.String r12 = r2.getString(r15)
            r7.append(r12)
            r7.append(r4)
            r12 = 2131821803(0x7f1104eb, float:1.927636E38)
            r7.append(r12)
            r7.append(r1)
            java.lang.String r12 = "ijk-pixel-format-ui"
            java.lang.String r12 = r2.getString(r12)
            r7.append(r12)
            r7.append(r4)
            r12 = 2131821806(0x7f1104ee, float:1.9276366E38)
            r7.append(r12)
            r7.append(r1)
            java.lang.String r12 = "ijk-resolution-ui"
            java.lang.String r12 = r2.getString(r12)
            r7.append(r12)
            r7.append(r4)
            r12 = 2131821799(0x7f1104e7, float:1.9276351E38)
            r7.append(r12)
            r7.append(r1)
            java.lang.String r12 = "ijk-frame-rate-ui"
        L_0x01bd:
            java.lang.String r12 = r2.getString(r12)
            r7.append(r12)
            r7.append(r4)
            r12 = 2131821796(0x7f1104e4, float:1.9276345E38)
            r7.append(r12)
            r7.append(r1)
            java.lang.String r1 = r2.getString(r10)
            r7.append(r1)
            r7.append(r4)
        L_0x01da:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "showMedia: ---info---"
            r1.append(r2)
            java.lang.String r2 = r7.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r13, r1)
            goto L_0x01f4
        L_0x01f3:
            r0 = 2
        L_0x01f4:
            int r11 = r11 + 1
            r0 = r19
            r1 = r16
            r2 = 1
            r4 = 2
            r10 = 0
            goto L_0x0022
        L_0x01ff:
            java.lang.String r0 = r7.toString()
            return r0
        L_0x0204:
            java.lang.String r0 = "-1"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.ijkplayer.IjkVideoView.showMedia(tv.danmaku.ijk.media.player.IjkMediaPlayer):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x01c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showMediaInfo() {
        /*
            r18 = this;
            r0 = r18
            tv.danmaku.ijk.media.player.IMediaPlayer r1 = r0.mMediaPlayer
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            r2 = 1
            int r1 = com.xeagle.android.login.ijkplayer.MediaPlayerCompat.getSelectedTrack(r1, r2)
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r0.mMediaPlayer
            r4 = 2
            int r3 = com.xeagle.android.login.ijkplayer.MediaPlayerCompat.getSelectedTrack(r3, r4)
            tv.danmaku.ijk.media.player.IMediaPlayer r5 = r0.mMediaPlayer
            r6 = 3
            int r5 = com.xeagle.android.login.ijkplayer.MediaPlayerCompat.getSelectedTrack(r5, r6)
            com.xeagle.android.login.ijkplayer.TableLayoutBinder r6 = new com.xeagle.android.login.ijkplayer.TableLayoutBinder
            android.content.Context r7 = r18.getContext()
            r6.<init>(r7)
            r7 = 2131821804(0x7f1104ec, float:1.9276362E38)
            r6.appendSection((int) r7)
            tv.danmaku.ijk.media.player.IMediaPlayer r8 = r0.mMediaPlayer
            java.lang.String r8 = com.xeagle.android.login.ijkplayer.MediaPlayerCompat.getName(r8)
            r6.appendRow2((int) r7, (java.lang.String) r8)
            r7 = 2131821802(0x7f1104ea, float:1.9276357E38)
            r6.appendSection((int) r7)
            int r7 = r0.mVideoWidth
            int r8 = r0.mVideoHeight
            int r9 = r0.mVideoSarNum
            int r10 = r0.mVideoSarDen
            java.lang.String r7 = r0.buildResolution(r7, r8, r9, r10)
            r8 = 2131821806(0x7f1104ee, float:1.9276366E38)
            r6.appendRow2((int) r8, (java.lang.String) r7)
            r7 = 2131821801(0x7f1104e9, float:1.9276355E38)
            tv.danmaku.ijk.media.player.IMediaPlayer r9 = r0.mMediaPlayer
            long r9 = r9.getDuration()
            java.lang.String r9 = r0.buildTimeMilli(r9)
            r6.appendRow2((int) r7, (java.lang.String) r9)
            tv.danmaku.ijk.media.player.IMediaPlayer r7 = r0.mMediaPlayer
            tv.danmaku.ijk.media.player.misc.ITrackInfo[] r7 = r7.getTrackInfo()
            if (r7 == 0) goto L_0x01d8
            r9 = -1
            int r10 = r7.length
            r11 = 0
            r12 = 0
        L_0x0066:
            if (r12 >= r10) goto L_0x01d8
            r13 = r7[r12]
            int r9 = r9 + r2
            int r14 = r13.getTrackType()
            java.lang.String r15 = " "
            if (r9 != r1) goto L_0x00ab
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.Context r8 = r18.getContext()
            r16 = r1
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.Integer r17 = java.lang.Integer.valueOf(r9)
            r1[r11] = r17
            r11 = 2131821808(0x7f1104f0, float:1.927637E38)
            java.lang.String r1 = r8.getString(r11, r1)
            r4.append(r1)
            r4.append(r15)
            android.content.Context r1 = r18.getContext()
            r8 = 2131821795(0x7f1104e3, float:1.9276343E38)
            java.lang.String r1 = r1.getString(r8)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
        L_0x00a5:
            r6.appendSection((java.lang.String) r1)
            r11 = 0
            goto L_0x0123
        L_0x00ab:
            r16 = r1
            if (r9 != r3) goto L_0x00e2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r4 = r18.getContext()
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
            r17 = 0
            r8[r17] = r11
            r11 = 2131821808(0x7f1104f0, float:1.927637E38)
            java.lang.String r4 = r4.getString(r11, r8)
            r1.append(r4)
            r1.append(r15)
            android.content.Context r4 = r18.getContext()
            r8 = 2131821793(0x7f1104e1, float:1.927634E38)
        L_0x00d6:
            java.lang.String r4 = r4.getString(r8)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            goto L_0x00a5
        L_0x00e2:
            if (r9 != r5) goto L_0x010c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r4 = r18.getContext()
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
            r17 = 0
            r8[r17] = r11
            r11 = 2131821808(0x7f1104f0, float:1.927637E38)
            java.lang.String r4 = r4.getString(r11, r8)
            r1.append(r4)
            r1.append(r15)
            android.content.Context r4 = r18.getContext()
            r8 = 2131821794(0x7f1104e2, float:1.9276341E38)
            goto L_0x00d6
        L_0x010c:
            android.content.Context r1 = r18.getContext()
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)
            r11 = 0
            r4[r11] = r8
            r8 = 2131821808(0x7f1104f0, float:1.927637E38)
            java.lang.String r1 = r1.getString(r8, r4)
            r6.appendSection((java.lang.String) r1)
        L_0x0123:
            r1 = 2131821809(0x7f1104f1, float:1.9276372E38)
            java.lang.String r4 = r0.buildTrackType(r14)
            r6.appendRow2((int) r1, (java.lang.String) r4)
            r1 = 2131821800(0x7f1104e8, float:1.9276353E38)
            java.lang.String r4 = r13.getLanguage()
            java.lang.String r4 = r0.buildLanguage(r4)
            r6.appendRow2((int) r1, (java.lang.String) r4)
            tv.danmaku.ijk.media.player.misc.IMediaFormat r1 = r13.getFormat()
            if (r1 != 0) goto L_0x0143
            goto L_0x01c8
        L_0x0143:
            boolean r4 = r1 instanceof tv.danmaku.ijk.media.player.misc.IjkMediaFormat
            if (r4 == 0) goto L_0x01c8
            java.lang.String r4 = "ijk-bit-rate-ui"
            java.lang.String r13 = "ijk-profile-level-ui"
            r15 = 2131821805(0x7f1104ed, float:1.9276364E38)
            java.lang.String r11 = "ijk-codec-long-name-ui"
            r8 = 2131821798(0x7f1104e6, float:1.927635E38)
            if (r14 == r2) goto L_0x018a
            r2 = 2
            if (r14 == r2) goto L_0x0159
            goto L_0x01c9
        L_0x0159:
            java.lang.String r11 = r1.getString(r11)
            r6.appendRow2((int) r8, (java.lang.String) r11)
            java.lang.String r8 = r1.getString(r13)
            r6.appendRow2((int) r15, (java.lang.String) r8)
            r8 = 2131821807(0x7f1104ef, float:1.9276368E38)
            java.lang.String r11 = "ijk-sample-rate-ui"
            java.lang.String r11 = r1.getString(r11)
            r6.appendRow2((int) r8, (java.lang.String) r11)
            r8 = 2131821797(0x7f1104e5, float:1.9276347E38)
            java.lang.String r11 = "ijk-channel-ui"
            java.lang.String r11 = r1.getString(r11)
            r6.appendRow2((int) r8, (java.lang.String) r11)
            java.lang.String r1 = r1.getString(r4)
            r4 = 2131821796(0x7f1104e4, float:1.9276345E38)
            r6.appendRow2((int) r4, (java.lang.String) r1)
            goto L_0x01c9
        L_0x018a:
            r2 = 2
            java.lang.String r11 = r1.getString(r11)
            r6.appendRow2((int) r8, (java.lang.String) r11)
            java.lang.String r8 = r1.getString(r13)
            r6.appendRow2((int) r15, (java.lang.String) r8)
            r8 = 2131821803(0x7f1104eb, float:1.927636E38)
            java.lang.String r11 = "ijk-pixel-format-ui"
            java.lang.String r11 = r1.getString(r11)
            r6.appendRow2((int) r8, (java.lang.String) r11)
            java.lang.String r8 = "ijk-resolution-ui"
            java.lang.String r8 = r1.getString(r8)
            r11 = 2131821806(0x7f1104ee, float:1.9276366E38)
            r6.appendRow2((int) r11, (java.lang.String) r8)
            r8 = 2131821799(0x7f1104e7, float:1.9276351E38)
            java.lang.String r13 = "ijk-frame-rate-ui"
            java.lang.String r13 = r1.getString(r13)
            r6.appendRow2((int) r8, (java.lang.String) r13)
            java.lang.String r1 = r1.getString(r4)
            r4 = 2131821796(0x7f1104e4, float:1.9276345E38)
            r6.appendRow2((int) r4, (java.lang.String) r1)
            goto L_0x01cc
        L_0x01c8:
            r2 = 2
        L_0x01c9:
            r11 = 2131821806(0x7f1104ee, float:1.9276366E38)
        L_0x01cc:
            int r12 = r12 + 1
            r1 = r16
            r2 = 1
            r4 = 2
            r8 = 2131821806(0x7f1104ee, float:1.9276366E38)
            r11 = 0
            goto L_0x0066
        L_0x01d8:
            androidx.appcompat.app.b$a r1 = r6.buildAlertDialogBuilder()
            r2 = 2131821679(0x7f11046f, float:1.9276108E38)
            r1.a((int) r2)
            r2 = 2131820894(0x7f11015e, float:1.9274516E38)
            r3 = 0
            r1.b(r2, r3)
            r1.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.ijkplayer.IjkVideoView.showMediaInfo():void");
    }

    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    public void stopPlayback() {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            InfoHudViewHolder infoHudViewHolder = this.mHudViewHolder;
            if (infoHudViewHolder != null) {
                infoHudViewHolder.setMediaPlayer((IMediaPlayer) null);
            }
            this.mCurrentState = 0;
            this.mTargetState = 0;
        }
    }

    public void suspend() {
        release(false);
    }

    public int toggleAspectRatio() {
        int i2 = this.mCurrentAspectRatioIndex + 1;
        this.mCurrentAspectRatioIndex = i2;
        int[] iArr = s_allAspectRatio;
        int length = i2 % iArr.length;
        this.mCurrentAspectRatioIndex = length;
        int i3 = iArr[length];
        this.mCurrentAspectRatio = i3;
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.setAspectRatio(i3);
        }
        return this.mCurrentAspectRatio;
    }

    public int togglePlayer() {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.release();
        }
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.getView().invalidate();
        }
        openVideo();
        return this.mSettings.getPlayer();
    }

    public int toggleRender() {
        int i2 = this.mCurrentRenderIndex + 1;
        this.mCurrentRenderIndex = i2;
        int size = i2 % this.mAllRenders.size();
        this.mCurrentRenderIndex = size;
        int intValue = this.mAllRenders.get(size).intValue();
        this.mCurrentRender = intValue;
        setRender(intValue);
        return this.mCurrentRender;
    }
}
