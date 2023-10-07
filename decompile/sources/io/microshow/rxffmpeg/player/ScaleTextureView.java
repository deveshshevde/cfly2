package io.microshow.rxffmpeg.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;

public class ScaleTextureView extends TextureView {
    private float actionX;
    private float actionY;
    private float degree;
    private boolean enabledRotation;
    private boolean enabledTouch;
    private boolean enabledTranslation;
    private int moveType;
    private float rotation;
    private float scale;
    private float spacing;
    private float translationX;
    private float translationY;

    public ScaleTextureView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ScaleTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.scale = 1.0f;
        this.enabledTouch = true;
        this.enabledRotation = true;
        this.enabledTranslation = true;
        setClickable(true);
    }

    private float getDegree(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2((double) (motionEvent.getY(0) - motionEvent.getY(1)), (double) (motionEvent.getX(0) - motionEvent.getX(1))));
    }

    private float getSpacing(MotionEvent motionEvent) {
        float x2 = motionEvent.getX(0) - motionEvent.getX(1);
        float y2 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x2 * x2) + (y2 * y2)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r0 != 6) goto L_0x00a8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            boolean r0 = r3.enabledTouch
            if (r0 == 0) goto L_0x00a8
            int r0 = r4.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 1
            if (r0 == 0) goto L_0x009a
            if (r0 == r1) goto L_0x0096
            r2 = 2
            if (r0 == r2) goto L_0x002a
            r1 = 5
            if (r0 == r1) goto L_0x001a
            r1 = 6
            if (r0 == r1) goto L_0x0096
            goto L_0x00a8
        L_0x001a:
            r3.moveType = r2
            float r0 = r3.getSpacing(r4)
            r3.spacing = r0
            float r0 = r3.getDegree(r4)
            r3.degree = r0
            goto L_0x00a8
        L_0x002a:
            int r0 = r3.moveType
            if (r0 != r1) goto L_0x0055
            boolean r0 = r3.enabledTranslation
            if (r0 == 0) goto L_0x00a8
            float r0 = r3.translationX
            float r1 = r4.getRawX()
            float r0 = r0 + r1
            float r1 = r3.actionX
            float r0 = r0 - r1
            r3.translationX = r0
            float r0 = r3.translationY
            float r1 = r4.getRawY()
            float r0 = r0 + r1
            float r1 = r3.actionY
            float r0 = r0 - r1
            r3.translationY = r0
            float r0 = r3.translationX
            r3.setTranslationX(r0)
            float r0 = r3.translationY
            r3.setTranslationY(r0)
            goto L_0x009c
        L_0x0055:
            if (r0 != r2) goto L_0x00a8
            float r0 = r3.scale
            float r1 = r3.getSpacing(r4)
            float r0 = r0 * r1
            float r1 = r3.spacing
            float r0 = r0 / r1
            r3.scale = r0
            r3.setScaleX(r0)
            float r0 = r3.scale
            r3.setScaleY(r0)
            boolean r0 = r3.enabledRotation
            if (r0 == 0) goto L_0x00a8
            float r0 = r3.rotation
            float r1 = r3.getDegree(r4)
            float r0 = r0 + r1
            float r1 = r3.degree
            float r0 = r0 - r1
            r3.rotation = r0
            r1 = 1135869952(0x43b40000, float:360.0)
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L_0x0085
            float r0 = r0 - r1
            r3.rotation = r0
        L_0x0085:
            float r0 = r3.rotation
            r2 = -1011613696(0xffffffffc3b40000, float:-360.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0090
            float r0 = r0 + r1
            r3.rotation = r0
        L_0x0090:
            float r0 = r3.rotation
            r3.setRotation(r0)
            goto L_0x00a8
        L_0x0096:
            r0 = 0
            r3.moveType = r0
            goto L_0x00a8
        L_0x009a:
            r3.moveType = r1
        L_0x009c:
            float r0 = r4.getRawX()
            r3.actionX = r0
            float r0 = r4.getRawY()
            r3.actionY = r0
        L_0x00a8:
            boolean r4 = super.onTouchEvent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.microshow.rxffmpeg.player.ScaleTextureView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void reset(boolean z2) {
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.scale = 1.0f;
        this.rotation = 0.0f;
        this.actionX = 0.0f;
        this.actionY = 0.0f;
        this.spacing = 0.0f;
        this.degree = 0.0f;
        this.moveType = 0;
        if (!z2) {
            this.enabledTouch = true;
            this.enabledRotation = true;
            this.enabledTranslation = true;
        }
        setScaleX(1.0f);
        setScaleY(1.0f);
        setRotation(0.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
    }

    public void setEnabledRotation(boolean z2) {
        this.enabledRotation = z2;
    }

    public void setEnabledTouch(boolean z2) {
        this.enabledTouch = z2;
    }

    public void setEnabledTranslation(boolean z2) {
        this.enabledTranslation = z2;
    }
}
