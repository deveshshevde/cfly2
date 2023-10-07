package kk;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.n;
import java.util.List;

public class c extends n {

    /* renamed from: a  reason: collision with root package name */
    private List<Fragment> f30132a;

    public c(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.f30132a = list;
    }

    public int getCount() {
        List<Fragment> list = this.f30132a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Fragment getItem(int i2) {
        return this.f30132a.get(i2);
    }
}
