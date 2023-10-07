package hl;

import android.util.Log;
import com.huantansheng.easyphotos.models.puzzle.slant.c;

public abstract class a extends c {

    /* renamed from: a  reason: collision with root package name */
    protected int f13365a;

    public a(int i2) {
        if (i2 >= i()) {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberSlantLayout: the most theme count is ");
            sb.append(i());
            sb.append(" ,you should let theme from 0 to ");
            sb.append(i() - 1);
            sb.append(" .");
            Log.e("NumberSlantLayout", sb.toString());
        }
        this.f13365a = i2;
    }

    public abstract int i();

    public int j() {
        return this.f13365a;
    }
}
