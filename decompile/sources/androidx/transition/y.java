package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f4886a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f4887b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<Transition> f4888c = new ArrayList<>();

    @Deprecated
    public y() {
    }

    public y(View view) {
        this.f4887b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f4887b == yVar.f4887b && this.f4886a.equals(yVar.f4886a);
    }

    public int hashCode() {
        return (this.f4887b.hashCode() * 31) + this.f4886a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f4887b + "\n") + "    values:";
        for (String next : this.f4886a.keySet()) {
            str = str + "    " + next + ": " + this.f4886a.get(next) + "\n";
        }
        return str;
    }
}
