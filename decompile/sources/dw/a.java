package dw;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import java.util.ArrayList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private FragmentManager f26771a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Fragment> f26772b;

    /* renamed from: c  reason: collision with root package name */
    private int f26773c;

    public void a(int i2) {
        for (int i3 = 0; i3 < this.f26772b.size(); i3++) {
            s a2 = this.f26771a.a();
            Fragment fragment = this.f26772b.get(i3);
            if (i3 == i2) {
                a2.c(fragment);
            } else {
                a2.b(fragment);
            }
            a2.c();
        }
        this.f26773c = i2;
    }
}
