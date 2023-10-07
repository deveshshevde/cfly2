package com.ctoo.mediaedit.tools;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;

public abstract class GLMultiTexProducerView extends GLMultiTexConsumerView {

    /* renamed from: d  reason: collision with root package name */
    protected List<Object> f10883d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private int f10884e = 36197;

    /* renamed from: f  reason: collision with root package name */
    private a f10885f;

    public interface a {
    }

    public GLMultiTexProducerView(Context context) {
        super(context);
    }

    public GLMultiTexProducerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GLMultiTexProducerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public int getInitialTexCount() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int getRenderMode() {
        return 0;
    }

    public void setProducedTextureTarget(int i2) {
        this.f10884e = i2;
    }

    public void setSurfaceTextureCreatedListener(a aVar) {
        this.f10885f = aVar;
    }
}
