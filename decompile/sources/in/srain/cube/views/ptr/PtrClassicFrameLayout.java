package in.srain.cube.views.ptr;

import android.content.Context;
import android.util.AttributeSet;

public class PtrClassicFrameLayout extends PtrFrameLayout {

    /* renamed from: d  reason: collision with root package name */
    private PtrClassicDefaultHeader f13642d;

    public PtrClassicFrameLayout(Context context) {
        super(context);
        g();
    }

    public PtrClassicFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public PtrClassicFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        g();
    }

    private void g() {
        PtrClassicDefaultHeader ptrClassicDefaultHeader = new PtrClassicDefaultHeader(getContext());
        this.f13642d = ptrClassicDefaultHeader;
        setHeaderView(ptrClassicDefaultHeader);
        a((b) this.f13642d);
    }

    public PtrClassicDefaultHeader getHeader() {
        return this.f13642d;
    }

    public void setLastUpdateTimeKey(String str) {
        PtrClassicDefaultHeader ptrClassicDefaultHeader = this.f13642d;
        if (ptrClassicDefaultHeader != null) {
            ptrClassicDefaultHeader.setLastUpdateTimeKey(str);
        }
    }

    public void setLastUpdateTimeRelateObject(Object obj) {
        PtrClassicDefaultHeader ptrClassicDefaultHeader = this.f13642d;
        if (ptrClassicDefaultHeader != null) {
            ptrClassicDefaultHeader.setLastUpdateTimeRelateObject(obj);
        }
    }
}
