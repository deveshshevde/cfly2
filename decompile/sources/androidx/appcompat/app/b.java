package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;

public class b extends e implements DialogInterface {

    /* renamed from: a  reason: collision with root package name */
    final AlertController f654a = new AlertController(getContext(), this, getWindow());

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.a f655a;

        /* renamed from: b  reason: collision with root package name */
        private final int f656b;

        public a(Context context) {
            this(context, b.a(context, 0));
        }

        public a(Context context, int i2) {
            this.f655a = new AlertController.a(new ContextThemeWrapper(context, b.a(context, i2)));
            this.f656b = i2;
        }

        public Context a() {
            return this.f655a.f532a;
        }

        public a a(int i2) {
            AlertController.a aVar = this.f655a;
            aVar.f537f = aVar.f532a.getText(i2);
            return this;
        }

        public a a(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f655a;
            aVar.f540i = aVar.f532a.getText(i2);
            this.f655a.f542k = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f655a.f552u = onKeyListener;
            return this;
        }

        public a a(Drawable drawable) {
            this.f655a.f535d = drawable;
            return this;
        }

        public a a(View view) {
            this.f655a.f538g = view;
            return this;
        }

        public a a(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            this.f655a.f554w = listAdapter;
            this.f655a.f555x = onClickListener;
            this.f655a.I = i2;
            this.f655a.H = true;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f655a.f554w = listAdapter;
            this.f655a.f555x = onClickListener;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f655a.f537f = charSequence;
            return this;
        }

        public a a(boolean z2) {
            this.f655a.f549r = z2;
            return this;
        }

        public a b(int i2) {
            AlertController.a aVar = this.f655a;
            aVar.f539h = aVar.f532a.getText(i2);
            return this;
        }

        public a b(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f655a;
            aVar.f543l = aVar.f532a.getText(i2);
            this.f655a.f545n = onClickListener;
            return this;
        }

        public a b(View view) {
            this.f655a.f557z = view;
            this.f655a.f556y = 0;
            this.f655a.E = false;
            return this;
        }

        public b b() {
            b bVar = new b(this.f655a.f532a, this.f656b);
            this.f655a.a(bVar.f654a);
            bVar.setCancelable(this.f655a.f549r);
            if (this.f655a.f549r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f655a.f550s);
            bVar.setOnDismissListener(this.f655a.f551t);
            if (this.f655a.f552u != null) {
                bVar.setOnKeyListener(this.f655a.f552u);
            }
            return bVar;
        }

        public b c() {
            b b2 = b();
            b2.show();
            return b2;
        }
    }

    protected b(Context context, int i2) {
        super(context, a(context, i2));
    }

    static int a(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView a() {
        return this.f654a.b();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f654a.a();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f654a.a(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f654a.b(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f654a.a(charSequence);
    }
}
