package hm;

import android.util.Log;
import hk.c;

public abstract class e extends c {

    /* renamed from: a  reason: collision with root package name */
    protected int f13366a;

    public e(int i2) {
        if (i2 >= i()) {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberStraightLayout: the most theme count is ");
            sb.append(i());
            sb.append(" ,you should let theme from 0 to ");
            sb.append(i() - 1);
            sb.append(" .");
            Log.e("NumberStraightLayout", sb.toString());
        }
        this.f13366a = i2;
    }

    public abstract int i();

    public int j() {
        return this.f13366a;
    }
}
