package com.google.android.gms.location;

import java.util.Comparator;

final class ai implements Comparator<ActivityTransition> {
    ai() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        ActivityTransition activityTransition = (ActivityTransition) obj;
        ActivityTransition activityTransition2 = (ActivityTransition) obj2;
        int a2 = activityTransition.a();
        int a3 = activityTransition2.a();
        if (a2 != a3) {
            return a2 < a3 ? -1 : 1;
        }
        int b2 = activityTransition.b();
        int b3 = activityTransition2.b();
        if (b2 == b3) {
            return 0;
        }
        return b2 < b3 ? -1 : 1;
    }
}
