package me.yokeyword.fragmentation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.x;
import java.util.List;

public class g {
    public static c a(Fragment fragment) {
        List<Fragment> c2;
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null || (c2 = x.c(fragmentManager)) == null) {
            return null;
        }
        for (int indexOf = c2.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
            Fragment fragment2 = c2.get(indexOf);
            if (fragment2 instanceof c) {
                return (c) fragment2;
            }
        }
        return null;
    }

    public static c a(FragmentManager fragmentManager) {
        return a(fragmentManager, (c) null);
    }

    public static c a(FragmentManager fragmentManager, int i2) {
        for (int f2 = fragmentManager.f() - 1; f2 >= 0; f2--) {
            Fragment b2 = fragmentManager.b(fragmentManager.b(f2).i());
            if (b2 instanceof c) {
                c cVar = (c) b2;
                if (i2 == 0 || i2 == cVar.i().f31143d) {
                    return cVar;
                }
            }
        }
        return null;
    }

    private static c a(FragmentManager fragmentManager, c cVar) {
        List<Fragment> c2 = x.c(fragmentManager);
        if (c2 == null) {
            return cVar;
        }
        for (int size = c2.size() - 1; size >= 0; size--) {
            Fragment fragment = c2.get(size);
            if ((fragment instanceof c) && fragment.isResumed() && !fragment.isHidden() && fragment.getUserVisibleHint()) {
                return a(fragment.getChildFragmentManager(), (c) fragment);
            }
        }
        return cVar;
    }

    public static c b(FragmentManager fragmentManager) {
        return a(fragmentManager, 0);
    }
}
