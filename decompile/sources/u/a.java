package u;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private final int f34524a;

    /* renamed from: b  reason: collision with root package name */
    private final c f34525b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34526c;

    public a(int i2, c cVar, int i3) {
        this.f34524a = i2;
        this.f34525b = cVar;
        this.f34526c = i3;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f34524a);
        this.f34525b.a(this.f34526c, bundle);
    }
}
