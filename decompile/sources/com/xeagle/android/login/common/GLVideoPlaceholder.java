package com.xeagle.android.login.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blankj.utilcode.constant.MemoryConstants;
import com.xeagle.R;

public class GLVideoPlaceholder extends FrameLayout {
    private static final int sEnumHeight = 1;
    private static final int sEnumNop = -1;
    private static final int sEnumWidth = 0;
    private ImageView cover;
    private View full;
    private boolean fullScreenEnabled;
    private View icon;
    private View indicator;
    private int layout;
    private View mask;
    /* access modifiers changed from: private */
    public GLVideoModel model;
    private View.OnClickListener onPlayClicked;
    private View.OnClickListener onPlayClickedListener;
    private View pause;
    private int placeholderHeight;
    private int placeholderWidth;
    private float ratioHeight;
    private float ratioWidth;
    private int standard;
    private int videoHeight;
    private GLVideoView videoView;
    private int videoWidth;

    public GLVideoPlaceholder(Context context) {
        this(context, (AttributeSet) null);
    }

    public GLVideoPlaceholder(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GLVideoPlaceholder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.videoWidth = -1;
        this.videoHeight = -1;
        this.placeholderWidth = -1;
        this.placeholderHeight = -1;
        this.onPlayClickedListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (GLVideoPlaceholder.this.model != null) {
                    GLVideoPlaceholder.this.triggerPlayClicked(view);
                }
            }
        };
        setClickable(true);
        init(context, attributeSet, i2);
    }

    private void init(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VideoPlaceholder, i2, 0);
        if (obtainStyledAttributes != null) {
            this.ratioWidth = obtainStyledAttributes.getFloat(2, 1.0f);
            this.ratioHeight = obtainStyledAttributes.getFloat(1, 1.0f);
            this.standard = obtainStyledAttributes.getInt(3, -1);
            this.layout = obtainStyledAttributes.getResourceId(0, com.cfly.uav_pro.R.layout.widget_video_view_default);
            obtainStyledAttributes.recycle();
        }
        LayoutInflater.from(getContext()).inflate(this.layout, this, true);
        this.videoView = (GLVideoView) findViewById(com.cfly.uav_pro.R.id.widget_video_view_texture);
        this.cover = (ImageView) findViewById(com.cfly.uav_pro.R.id.widget_video_view_cover);
        this.icon = findViewById(com.cfly.uav_pro.R.id.widget_video_view_icon);
        this.pause = findViewById(com.cfly.uav_pro.R.id.widget_video_view_pause);
        this.indicator = findViewById(com.cfly.uav_pro.R.id.widget_video_view_indicator);
        this.full = findViewById(com.cfly.uav_pro.R.id.widget_video_view_full);
        this.mask = findViewById(com.cfly.uav_pro.R.id.widget_video_view_mask);
        this.icon.setOnClickListener(this.onPlayClickedListener);
    }

    private void resize() {
        int i2;
        int i3;
        GLVideoModel gLVideoModel = this.model;
        if (gLVideoModel != null) {
            if (gLVideoModel.getVideoWidth() != this.videoWidth || this.model.getViewHeight() != this.videoHeight || this.placeholderWidth != getMeasuredWidth() || this.placeholderWidth != getMeasuredHeight()) {
                this.videoWidth = this.model.getVideoWidth();
                this.videoHeight = this.model.getViewHeight();
                this.placeholderWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                this.placeholderHeight = measuredHeight;
                int i4 = this.placeholderWidth;
                if (i4 > 0 && measuredHeight > 0 && (i2 = this.videoWidth) > 0 && (i3 = this.videoHeight) > 0) {
                    if ((((float) i4) * 1.0f) / ((float) measuredHeight) < (((float) i2) * 1.0f) / ((float) i3)) {
                        measuredHeight = (int) (((((float) i4) * 1.0f) / ((float) i2)) * ((float) i3));
                    } else {
                        i4 = (int) (((((float) measuredHeight) * 1.0f) / ((float) i3)) * ((float) i2));
                    }
                    setLayout(this.videoView, i4, measuredHeight);
                    setLayout(this.cover, i4, measuredHeight);
                }
            }
        }
    }

    private void setCoverVisible(boolean z2) {
        this.cover.setVisibility(z2 ? 0 : 8);
        this.mask.setVisibility(this.cover.getVisibility());
    }

    private void setFullVisible(boolean z2) {
        this.full.setVisibility((!this.fullScreenEnabled || !z2) ? 8 : 0);
    }

    private void setLayout(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public void triggerPlayClicked(View view) {
        View.OnClickListener onClickListener = this.onPlayClicked;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.xeagle.android.login.common.GLVideoModel r5, boolean r6) {
        /*
            r4 = this;
            r4.model = r5
            boolean r0 = r5.isPlayerPlay()
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L_0x0021
            android.view.View r0 = r4.icon
            r0.setVisibility(r2)
            android.view.View r0 = r4.indicator
            r0.setVisibility(r2)
            android.view.View r0 = r4.pause
            r0.setVisibility(r1)
        L_0x001a:
            r4.setCoverVisible(r1)
            r4.setFullVisible(r1)
            goto L_0x0080
        L_0x0021:
            boolean r0 = r5.isPlayerLoading()
            if (r0 == 0) goto L_0x0037
            android.view.View r0 = r4.icon
            r0.setVisibility(r2)
            android.view.View r0 = r4.indicator
            r0.setVisibility(r1)
            android.view.View r0 = r4.pause
            r0.setVisibility(r2)
            goto L_0x001a
        L_0x0037:
            boolean r0 = r5.isPlayerPaused()
            r3 = 1
            if (r0 == 0) goto L_0x0056
            android.view.View r0 = r4.icon
            r0.setVisibility(r1)
            android.view.View r0 = r4.indicator
            r0.setVisibility(r2)
            android.view.View r0 = r4.pause
            r0.setVisibility(r2)
            boolean r0 = r5.isSurfaceAvailable()
            r0 = r0 ^ r3
            r4.setCoverVisible(r0)
            goto L_0x006e
        L_0x0056:
            boolean r0 = r5.isPlayerStopped()
            if (r0 == 0) goto L_0x0072
        L_0x005c:
            android.view.View r0 = r4.icon
            r0.setVisibility(r1)
            android.view.View r0 = r4.indicator
            r0.setVisibility(r2)
            android.view.View r0 = r4.pause
            r0.setVisibility(r2)
            r4.setCoverVisible(r3)
        L_0x006e:
            r4.setFullVisible(r3)
            goto L_0x0080
        L_0x0072:
            boolean r0 = r5.isPlayerComplete()
            if (r0 == 0) goto L_0x0079
            goto L_0x005c
        L_0x0079:
            boolean r0 = r5.isPlayerError()
            if (r0 == 0) goto L_0x0080
            goto L_0x005c
        L_0x0080:
            if (r6 == 0) goto L_0x008b
            android.widget.ImageView r6 = r4.cover
            android.net.Uri r5 = r5.getUri()
            com.xeagle.android.login.pickImage.loader.GlideImageLoader.displayVideo((android.widget.ImageView) r6, (android.net.Uri) r5)
        L_0x008b:
            r4.resize()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.GLVideoPlaceholder.bind(com.xeagle.android.login.common.GLVideoModel, boolean):void");
    }

    public GLVideoView getVideoView() {
        return this.videoView;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.standard != -1) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int i4 = this.standard;
            if (i4 == 0) {
                measuredHeight = (int) ((((float) measuredWidth) / this.ratioWidth) * this.ratioHeight);
            } else if (i4 == 1) {
                measuredWidth = (int) ((((float) measuredHeight) / this.ratioHeight) * this.ratioWidth);
            }
            setMeasuredDimension(measuredWidth, measuredHeight);
            measureChildren(View.MeasureSpec.makeMeasureSpec(measuredWidth, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(measuredHeight, MemoryConstants.GB));
        }
        resize();
    }

    public void setFullScreenEnabled(boolean z2) {
        this.fullScreenEnabled = z2;
    }

    public void setOnFullClicked(View.OnClickListener onClickListener) {
        this.full.setOnClickListener(onClickListener);
    }

    public void setOnPauseClicked(View.OnClickListener onClickListener) {
        this.pause.setOnClickListener(onClickListener);
    }

    public void setOnPlayClicked(View.OnClickListener onClickListener) {
        this.onPlayClicked = onClickListener;
    }
}
