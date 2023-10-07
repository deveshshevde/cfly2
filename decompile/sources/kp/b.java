package kp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.cfly.uav_pro.R;
import eo.a;

public class b extends ArrayAdapter<String> {

    /* renamed from: a  reason: collision with root package name */
    public a f30517a = new a();

    /* renamed from: b  reason: collision with root package name */
    private ky.a f30518b;

    /* renamed from: c  reason: collision with root package name */
    private Context f30519c;

    /* renamed from: d  reason: collision with root package name */
    private String f30520d = "";

    public b(Context context, int i2) {
        super(context, i2);
        this.f30519c = context;
        this.f30518b = new ky.a(context);
        add(this.f30517a.f26931a);
        addAll(this.f30518b.a(context));
    }

    public a a(int i2) {
        try {
            return i2 == getPosition(this.f30517a.f26931a) ? this.f30517a : this.f30518b.a((String) getItem(i2));
        } catch (Exception unused) {
            Context context = this.f30519c;
            Toast.makeText(context, context.getString(R.string.error_when_opening_file), 0).show();
            return this.f30517a;
        }
    }

    public void a(String str) {
        this.f30520d = str;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) super.getView(i2, view, viewGroup);
        textView.setText(this.f30520d);
        return textView;
    }
}
