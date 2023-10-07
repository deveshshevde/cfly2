package androidx.fragment.app;

import java.util.List;

public class x {
    private static void a(FragmentManager fragmentManager, Runnable runnable) {
        if (fragmentManager instanceof k) {
            k kVar = (k) fragmentManager;
            if (a(fragmentManager)) {
                boolean z2 = kVar.mStateSaved;
                boolean z3 = kVar.mStopped;
                kVar.mStateSaved = false;
                kVar.mStopped = false;
                runnable.run();
                kVar.mStopped = z3;
                kVar.mStateSaved = z2;
                return;
            }
            runnable.run();
        }
    }

    public static boolean a(FragmentManager fragmentManager) {
        if (!(fragmentManager instanceof k)) {
            return false;
        }
        try {
            return ((k) fragmentManager).i();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void b(final FragmentManager fragmentManager) {
        a(fragmentManager, new Runnable() {
            public void run() {
                fragmentManager.d();
            }
        });
    }

    public static List<Fragment> c(FragmentManager fragmentManager) {
        return fragmentManager.g();
    }
}
