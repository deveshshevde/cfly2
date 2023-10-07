package la;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.n;
import java.util.List;

public class b extends n {

    /* renamed from: a  reason: collision with root package name */
    private List<Fragment> f30691a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f30692b;

    public b(List<Fragment> list, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f30691a = list;
    }

    public int getCount() {
        return this.f30691a.size();
    }

    public Fragment getItem(int i2) {
        return this.f30691a.get(i2);
    }

    public CharSequence getPageTitle(int i2) {
        List<String> list = this.f30692b;
        return list != null ? list.get(i2) : super.getPageTitle(i2);
    }
}
