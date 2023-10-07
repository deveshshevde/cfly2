package com.afollestad.materialdialogs.internal.button;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import ay.e;
import ay.f;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.internal.main.BaseSubLayout;
import com.blankj.utilcode.constant.MemoryConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

public final class DialogActionButtonLayout extends BaseSubLayout {

    /* renamed from: c  reason: collision with root package name */
    public static final a f7576c = new a((f) null);

    /* renamed from: a  reason: collision with root package name */
    public DialogActionButton[] f7577a;

    /* renamed from: b  reason: collision with root package name */
    public AppCompatCheckBox f7578b;

    /* renamed from: e  reason: collision with root package name */
    private final int f7579e = (e.f5573a.a(this, R.dimen.md_action_button_frame_padding) - e.f5573a.a(this, R.dimen.md_action_button_inset_horizontal));

    /* renamed from: f  reason: collision with root package name */
    private final int f7580f = e.f5573a.a(this, R.dimen.md_action_button_frame_padding_neutral);

    /* renamed from: g  reason: collision with root package name */
    private final int f7581g = e.f5573a.a(this, R.dimen.md_action_button_frame_spec_height);

    /* renamed from: h  reason: collision with root package name */
    private final int f7582h = e.f5573a.a(this, R.dimen.md_checkbox_prompt_margin_vertical);

    /* renamed from: i  reason: collision with root package name */
    private final int f7583i = e.f5573a.a(this, R.dimen.md_checkbox_prompt_margin_horizontal);

    /* renamed from: j  reason: collision with root package name */
    private boolean f7584j;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DialogActionButtonLayout f7585a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WhichButton f7586b;

        b(DialogActionButtonLayout dialogActionButtonLayout, WhichButton whichButton) {
            this.f7585a = dialogActionButtonLayout;
            this.f7586b = whichButton;
        }

        public final void onClick(View view) {
            this.f7585a.getDialog().a(this.f7586b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogActionButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
    }

    private final int b() {
        if (getVisibleButtons().length == 0) {
            return 0;
        }
        if (!this.f7584j) {
            return this.f7581g;
        }
        return this.f7581g * getVisibleButtons().length;
    }

    public final DialogActionButton[] getActionButtons() {
        DialogActionButton[] dialogActionButtonArr = this.f7577a;
        if (dialogActionButtonArr == null) {
            h.b("actionButtons");
        }
        return dialogActionButtonArr;
    }

    public final AppCompatCheckBox getCheckBoxPrompt() {
        AppCompatCheckBox appCompatCheckBox = this.f7578b;
        if (appCompatCheckBox == null) {
            h.b("checkBoxPrompt");
        }
        return appCompatCheckBox;
    }

    public final boolean getStackButtons$core() {
        return this.f7584j;
    }

    public final DialogActionButton[] getVisibleButtons() {
        DialogActionButton[] dialogActionButtonArr = this.f7577a;
        if (dialogActionButtonArr == null) {
            h.b("actionButtons");
        }
        Collection arrayList = new ArrayList();
        for (DialogActionButton dialogActionButton : dialogActionButtonArr) {
            if (f.a(dialogActionButton)) {
                arrayList.add(dialogActionButton);
            }
        }
        Object[] array = ((List) arrayList).toArray(new DialogActionButton[0]);
        if (array != null) {
            return (DialogActionButton[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        h.c(canvas, "canvas");
        super.onDraw(canvas);
        if (getDrawDivider()) {
            canvas.drawLine(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getDividerHeight(), a());
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.md_button_positive);
        h.a((Object) findViewById, "findViewById(R.id.md_button_positive)");
        View findViewById2 = findViewById(R.id.md_button_negative);
        h.a((Object) findViewById2, "findViewById(R.id.md_button_negative)");
        View findViewById3 = findViewById(R.id.md_button_neutral);
        h.a((Object) findViewById3, "findViewById(R.id.md_button_neutral)");
        this.f7577a = new DialogActionButton[]{(DialogActionButton) findViewById, (DialogActionButton) findViewById2, (DialogActionButton) findViewById3};
        View findViewById4 = findViewById(R.id.md_checkbox_prompt);
        h.a((Object) findViewById4, "findViewById(R.id.md_checkbox_prompt)");
        this.f7578b = (AppCompatCheckBox) findViewById4;
        DialogActionButton[] dialogActionButtonArr = this.f7577a;
        if (dialogActionButtonArr == null) {
            h.b("actionButtons");
        }
        int length = dialogActionButtonArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            dialogActionButtonArr[i2].setOnClickListener(new b(this, WhichButton.f7497d.a(i2)));
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r8 == null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r8 == null) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            r3 = this;
            boolean r4 = com.afollestad.materialdialogs.internal.button.a.a(r3)
            if (r4 != 0) goto L_0x0007
            return
        L_0x0007:
            androidx.appcompat.widget.AppCompatCheckBox r4 = r3.f7578b
            java.lang.String r5 = "checkBoxPrompt"
            if (r4 != 0) goto L_0x0010
            kotlin.jvm.internal.h.b(r5)
        L_0x0010:
            android.view.View r4 = (android.view.View) r4
            boolean r4 = ay.f.a(r4)
            if (r4 == 0) goto L_0x005f
            boolean r4 = ay.f.c(r3)
            if (r4 == 0) goto L_0x0039
            int r4 = r3.getMeasuredWidth()
            int r6 = r3.f7583i
            int r4 = r4 - r6
            int r6 = r3.f7582h
            androidx.appcompat.widget.AppCompatCheckBox r7 = r3.f7578b
            if (r7 != 0) goto L_0x002e
            kotlin.jvm.internal.h.b(r5)
        L_0x002e:
            int r7 = r7.getMeasuredWidth()
            int r7 = r4 - r7
            androidx.appcompat.widget.AppCompatCheckBox r8 = r3.f7578b
            if (r8 != 0) goto L_0x0050
            goto L_0x004d
        L_0x0039:
            int r7 = r3.f7583i
            int r6 = r3.f7582h
            androidx.appcompat.widget.AppCompatCheckBox r4 = r3.f7578b
            if (r4 != 0) goto L_0x0044
            kotlin.jvm.internal.h.b(r5)
        L_0x0044:
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r7
            androidx.appcompat.widget.AppCompatCheckBox r8 = r3.f7578b
            if (r8 != 0) goto L_0x0050
        L_0x004d:
            kotlin.jvm.internal.h.b(r5)
        L_0x0050:
            int r8 = r8.getMeasuredHeight()
            int r8 = r8 + r6
            androidx.appcompat.widget.AppCompatCheckBox r0 = r3.f7578b
            if (r0 != 0) goto L_0x005c
            kotlin.jvm.internal.h.b(r5)
        L_0x005c:
            r0.layout(r7, r6, r4, r8)
        L_0x005f:
            boolean r4 = r3.f7584j
            if (r4 == 0) goto L_0x0091
            int r4 = r3.f7579e
            int r5 = r3.getMeasuredWidth()
            int r6 = r3.f7579e
            int r5 = r5 - r6
            int r6 = r3.getMeasuredHeight()
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r7 = r3.getVisibleButtons()
            java.util.List r7 = kotlin.collections.b.c(r7)
            java.util.Iterator r7 = r7.iterator()
        L_0x007c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x018c
            java.lang.Object r8 = r7.next()
            com.afollestad.materialdialogs.internal.button.DialogActionButton r8 = (com.afollestad.materialdialogs.internal.button.DialogActionButton) r8
            int r0 = r3.f7581g
            int r0 = r6 - r0
            r8.layout(r4, r0, r5, r6)
            r6 = r0
            goto L_0x007c
        L_0x0091:
            int r4 = r3.getMeasuredHeight()
            int r5 = r3.f7581g
            int r4 = r4 - r5
            int r5 = r3.getMeasuredHeight()
            boolean r6 = ay.f.c(r3)
            r7 = 1
            r8 = 0
            r0 = 2
            java.lang.String r1 = "actionButtons"
            if (r6 == 0) goto L_0x011a
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r6 = r3.f7577a
            if (r6 != 0) goto L_0x00ae
            kotlin.jvm.internal.h.b(r1)
        L_0x00ae:
            r6 = r6[r0]
            android.view.View r6 = (android.view.View) r6
            boolean r6 = ay.f.a(r6)
            if (r6 == 0) goto L_0x00d1
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r6 = r3.f7577a
            if (r6 != 0) goto L_0x00bf
            kotlin.jvm.internal.h.b(r1)
        L_0x00bf:
            r6 = r6[r0]
            int r0 = r3.getMeasuredWidth()
            int r2 = r3.f7580f
            int r0 = r0 - r2
            int r2 = r6.getMeasuredWidth()
            int r2 = r0 - r2
            r6.layout(r2, r4, r0, r5)
        L_0x00d1:
            int r6 = r3.f7579e
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r0 = r3.f7577a
            if (r0 != 0) goto L_0x00da
            kotlin.jvm.internal.h.b(r1)
        L_0x00da:
            r0 = r0[r8]
            android.view.View r0 = (android.view.View) r0
            boolean r0 = ay.f.a(r0)
            if (r0 == 0) goto L_0x00f6
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r0 = r3.f7577a
            if (r0 != 0) goto L_0x00eb
            kotlin.jvm.internal.h.b(r1)
        L_0x00eb:
            r8 = r0[r8]
            int r0 = r8.getMeasuredWidth()
            int r0 = r0 + r6
            r8.layout(r6, r4, r0, r5)
            r6 = r0
        L_0x00f6:
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r8 = r3.f7577a
            if (r8 != 0) goto L_0x00fd
            kotlin.jvm.internal.h.b(r1)
        L_0x00fd:
            r8 = r8[r7]
            android.view.View r8 = (android.view.View) r8
            boolean r8 = ay.f.a(r8)
            if (r8 == 0) goto L_0x018c
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r8 = r3.f7577a
            if (r8 != 0) goto L_0x010e
            kotlin.jvm.internal.h.b(r1)
        L_0x010e:
            r7 = r8[r7]
            int r8 = r7.getMeasuredWidth()
            int r8 = r8 + r6
            r7.layout(r6, r4, r8, r5)
            goto L_0x018c
        L_0x011a:
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r6 = r3.f7577a
            if (r6 != 0) goto L_0x0121
            kotlin.jvm.internal.h.b(r1)
        L_0x0121:
            r6 = r6[r0]
            android.view.View r6 = (android.view.View) r6
            boolean r6 = ay.f.a(r6)
            if (r6 == 0) goto L_0x013e
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r6 = r3.f7577a
            if (r6 != 0) goto L_0x0132
            kotlin.jvm.internal.h.b(r1)
        L_0x0132:
            r6 = r6[r0]
            int r0 = r3.f7580f
            int r2 = r6.getMeasuredWidth()
            int r2 = r2 + r0
            r6.layout(r0, r4, r2, r5)
        L_0x013e:
            int r6 = r3.getMeasuredWidth()
            int r0 = r3.f7579e
            int r6 = r6 - r0
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r0 = r3.f7577a
            if (r0 != 0) goto L_0x014c
            kotlin.jvm.internal.h.b(r1)
        L_0x014c:
            r0 = r0[r8]
            android.view.View r0 = (android.view.View) r0
            boolean r0 = ay.f.a(r0)
            if (r0 == 0) goto L_0x0169
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r0 = r3.f7577a
            if (r0 != 0) goto L_0x015d
            kotlin.jvm.internal.h.b(r1)
        L_0x015d:
            r8 = r0[r8]
            int r0 = r8.getMeasuredWidth()
            int r0 = r6 - r0
            r8.layout(r0, r4, r6, r5)
            r6 = r0
        L_0x0169:
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r8 = r3.f7577a
            if (r8 != 0) goto L_0x0170
            kotlin.jvm.internal.h.b(r1)
        L_0x0170:
            r8 = r8[r7]
            android.view.View r8 = (android.view.View) r8
            boolean r8 = ay.f.a(r8)
            if (r8 == 0) goto L_0x018c
            com.afollestad.materialdialogs.internal.button.DialogActionButton[] r8 = r3.f7577a
            if (r8 != 0) goto L_0x0181
            kotlin.jvm.internal.h.b(r1)
        L_0x0181:
            r7 = r8[r7]
            int r8 = r7.getMeasuredWidth()
            int r8 = r6 - r8
            r7.layout(r8, r4, r6, r5)
        L_0x018c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!a.a(this)) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        AppCompatCheckBox appCompatCheckBox = this.f7578b;
        if (appCompatCheckBox == null) {
            h.b("checkBoxPrompt");
        }
        if (f.a(appCompatCheckBox)) {
            int i4 = size - (this.f7583i * 2);
            AppCompatCheckBox appCompatCheckBox2 = this.f7578b;
            if (appCompatCheckBox2 == null) {
                h.b("checkBoxPrompt");
            }
            appCompatCheckBox2.measure(View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        Context context = getDialog().getContext();
        h.a((Object) context, "dialog.context");
        Context d2 = getDialog().d();
        for (DialogActionButton dialogActionButton : getVisibleButtons()) {
            dialogActionButton.a(context, d2, this.f7584j);
            dialogActionButton.measure(this.f7584j ? View.MeasureSpec.makeMeasureSpec(size, MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(this.f7581g, MemoryConstants.GB));
        }
        if ((!(getVisibleButtons().length == 0)) && !this.f7584j) {
            int i5 = 0;
            for (DialogActionButton measuredWidth : getVisibleButtons()) {
                i5 += measuredWidth.getMeasuredWidth();
            }
            if (i5 >= size && !this.f7584j) {
                this.f7584j = true;
                for (DialogActionButton dialogActionButton2 : getVisibleButtons()) {
                    dialogActionButton2.a(context, d2, true);
                    dialogActionButton2.measure(View.MeasureSpec.makeMeasureSpec(size, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(this.f7581g, MemoryConstants.GB));
                }
            }
        }
        int b2 = b();
        AppCompatCheckBox appCompatCheckBox3 = this.f7578b;
        if (appCompatCheckBox3 == null) {
            h.b("checkBoxPrompt");
        }
        if (f.a(appCompatCheckBox3)) {
            AppCompatCheckBox appCompatCheckBox4 = this.f7578b;
            if (appCompatCheckBox4 == null) {
                h.b("checkBoxPrompt");
            }
            b2 += appCompatCheckBox4.getMeasuredHeight() + (this.f7582h * 2);
        }
        setMeasuredDimension(size, b2);
    }

    public final void setActionButtons(DialogActionButton[] dialogActionButtonArr) {
        h.c(dialogActionButtonArr, "<set-?>");
        this.f7577a = dialogActionButtonArr;
    }

    public final void setCheckBoxPrompt(AppCompatCheckBox appCompatCheckBox) {
        h.c(appCompatCheckBox, "<set-?>");
        this.f7578b = appCompatCheckBox;
    }

    public final void setStackButtons$core(boolean z2) {
        this.f7584j = z2;
    }
}
