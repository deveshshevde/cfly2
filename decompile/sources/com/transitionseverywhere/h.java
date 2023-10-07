package com.transitionseverywhere;

import android.view.View;
import j.a;
import java.util.ArrayList;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final View f21926a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Object> f21927b = new a();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<Transition> f21928c = new ArrayList<>();

    public h(View view) {
        this.f21926a = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f21926a == hVar.f21926a && this.f21927b.equals(hVar.f21927b);
    }

    public int hashCode() {
        return (this.f21926a.hashCode() * 31) + this.f21927b.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f21926a + "\n") + "    values:";
        for (String next : this.f21927b.keySet()) {
            str = str + "    " + next + ": " + this.f21927b.get(next) + "\n";
        }
        return str;
    }
}
