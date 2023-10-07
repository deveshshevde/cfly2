package com.blankj.utilcode.util;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class FragmentUtils {
    private static final String ARGS_ID = "args_id";
    private static final String ARGS_IS_ADD_STACK = "args_is_add_stack";
    private static final String ARGS_IS_HIDE = "args_is_hide";
    private static final String ARGS_TAG = "args_tag";
    private static final int TYPE_ADD_FRAGMENT = 1;
    private static final int TYPE_HIDE_FRAGMENT = 4;
    private static final int TYPE_REMOVE_FRAGMENT = 32;
    private static final int TYPE_REMOVE_TO_FRAGMENT = 64;
    private static final int TYPE_REPLACE_FRAGMENT = 16;
    private static final int TYPE_SHOW_FRAGMENT = 2;
    private static final int TYPE_SHOW_HIDE_FRAGMENT = 8;

    private static class Args {

        /* renamed from: id  reason: collision with root package name */
        final int f10023id;
        final boolean isAddStack;
        final boolean isHide;
        final String tag;

        Args(int i2, String str, boolean z2, boolean z3) {
            this.f10023id = i2;
            this.tag = str;
            this.isHide = z2;
            this.isAddStack = z3;
        }

        Args(int i2, boolean z2, boolean z3) {
            this(i2, (String) null, z2, z3);
        }
    }

    public static class FragmentNode {
        final Fragment fragment;
        final List<FragmentNode> next;

        public FragmentNode(Fragment fragment2, List<FragmentNode> list) {
            this.fragment = fragment2;
            this.next = list;
        }

        public Fragment getFragment() {
            return this.fragment;
        }

        public List<FragmentNode> getNext() {
            return this.next;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.fragment.getClass().getSimpleName());
            sb.append("->");
            List<FragmentNode> list = this.next;
            sb.append((list == null || list.isEmpty()) ? "no child" : this.next.toString());
            return sb.toString();
        }
    }

    public interface OnBackClickListener {
        boolean onBackClick();
    }

    private FragmentUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, (String) null, false, false);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, int i3, int i4) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, (String) null, false, i3, i4, 0, 0);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, int i3, int i4, int i5, int i6) {
        FragmentManager fragmentManager2 = fragmentManager;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Fragment fragment2 = fragment;
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, (String) null, false, i3, i4, i5, i6);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, String str) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, str, false, false);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, String str, int i3, int i4) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, str, false, i3, i4, 0, 0);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, String str, int i3, int i4, int i5, int i6) {
        FragmentManager fragmentManager2 = fragmentManager;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Fragment fragment2 = fragment;
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, str, false, i3, i4, i5, i6);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, String str, boolean z2) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, str, z2, false);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, String str, boolean z2, int i3, int i4) {
        FragmentManager fragmentManager2 = fragmentManager;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Fragment fragment2 = fragment;
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, str, z2, i3, i4, 0, 0);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, String str, boolean z2, int i3, int i4, int i5, int i6) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        s a2 = fragmentManager.a();
        putArgs(fragment, new Args(i2, str, false, z2));
        addAnim(a2, i3, i4, i5, i6);
        operate(1, fragmentManager, a2, (Fragment) null, fragment);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, String str, boolean z2, boolean z3) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        putArgs(fragment, new Args(i2, str, z2, z3));
        operateNoAnim(1, fragmentManager, (Fragment) null, fragment);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, String str, boolean z2, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(viewArr, "Argument 'sharedElements' of type View[] (#5 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        s a2 = fragmentManager.a();
        putArgs(fragment, new Args(i2, str, false, z2));
        addSharedElement(a2, viewArr);
        operate(1, fragmentManager, a2, (Fragment) null, fragment);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, String str, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(viewArr, "Argument 'sharedElements' of type View[] (#4 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, str, false, viewArr);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, boolean z2) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, (String) null, z2, false);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, boolean z2, int i3, int i4) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, (String) null, z2, i3, i4, 0, 0);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, boolean z2, int i3, int i4, int i5, int i6) {
        FragmentManager fragmentManager2 = fragmentManager;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Fragment fragment2 = fragment;
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, (String) null, z2, i3, i4, i5, i6);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, boolean z2, boolean z3) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, (String) null, z2, z3);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, boolean z2, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(viewArr, "Argument 'sharedElements' of type View[] (#4 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, (String) null, z2, viewArr);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i2, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'add' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(viewArr, "Argument 'sharedElements' of type View[] (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragment, i2, (String) null, false, viewArr);
    }

    public static void add(FragmentManager fragmentManager, List<Fragment> list, int i2, int i3) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(list, "Argument 'adds' of type List<Fragment> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, (Fragment[]) list.toArray(new Fragment[0]), i2, (String[]) null, i3);
    }

    public static void add(FragmentManager fragmentManager, List<Fragment> list, int i2, String[] strArr, int i3) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(list, "Argument 'adds' of type List<Fragment> (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, (Fragment[]) list.toArray(new Fragment[0]), i2, strArr, i3);
    }

    public static void add(FragmentManager fragmentManager, Fragment[] fragmentArr, int i2, int i3) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragmentArr, "Argument 'adds' of type Fragment[] (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        add(fragmentManager, fragmentArr, i2, (String[]) null, i3);
    }

    public static void add(FragmentManager fragmentManager, Fragment[] fragmentArr, int i2, String[] strArr, int i3) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragmentArr, "Argument 'adds' of type Fragment[] (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (strArr == null) {
            int length = fragmentArr.length;
            int i4 = 0;
            while (i4 < length) {
                putArgs(fragmentArr[i4], new Args(i2, (String) null, i3 != i4, false));
                i4++;
            }
        } else {
            int length2 = fragmentArr.length;
            int i5 = 0;
            while (i5 < length2) {
                putArgs(fragmentArr[i5], new Args(i2, strArr[i5], i3 != i5, false));
                i5++;
            }
        }
        operateNoAnim(1, fragmentManager, (Fragment) null, fragmentArr);
    }

    private static void addAnim(s sVar, int i2, int i3, int i4, int i5) {
        sVar.a(i2, i3, i4, i5);
    }

    private static void addSharedElement(s sVar, View... viewArr) {
        if (Build.VERSION.SDK_INT >= 21) {
            for (View view : viewArr) {
                sVar.a(view, view.getTransitionName());
            }
        }
    }

    public static boolean dispatchBackPress(Fragment fragment) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return fragment.isResumed() && fragment.isVisible() && fragment.getUserVisibleHint() && (fragment instanceof OnBackClickListener) && ((OnBackClickListener) fragment).onBackClick();
    }

    public static boolean dispatchBackPress(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> fragments = getFragments(fragmentManager);
        if (fragments != null && !fragments.isEmpty()) {
            for (int size = fragments.size() - 1; size >= 0; size--) {
                Fragment fragment = fragments.get(size);
                if (fragment != null && fragment.isResumed() && fragment.isVisible() && fragment.getUserVisibleHint() && (fragment instanceof OnBackClickListener) && ((OnBackClickListener) fragment).onBackClick()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Fragment findFragment(FragmentManager fragmentManager, Class<? extends Fragment> cls) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return fragmentManager.b(cls.getName());
    }

    public static Fragment findFragment(FragmentManager fragmentManager, String str) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'tag' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return fragmentManager.b(str);
    }

    public static List<FragmentNode> getAllFragments(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getAllFragments(fragmentManager, new ArrayList());
    }

    private static List<FragmentNode> getAllFragments(FragmentManager fragmentManager, List<FragmentNode> list) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> fragments = getFragments(fragmentManager);
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment != null) {
                list.add(new FragmentNode(fragment, getAllFragments(fragment.getChildFragmentManager(), new ArrayList())));
            }
        }
        return list;
    }

    public static List<FragmentNode> getAllFragmentsInStack(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getAllFragmentsInStack(fragmentManager, new ArrayList());
    }

    private static List<FragmentNode> getAllFragmentsInStack(FragmentManager fragmentManager, List<FragmentNode> list) {
        Bundle arguments;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> fragments = getFragments(fragmentManager);
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (!(fragment == null || (arguments = fragment.getArguments()) == null || !arguments.getBoolean(ARGS_IS_ADD_STACK))) {
                list.add(new FragmentNode(fragment, getAllFragmentsInStack(fragment.getChildFragmentManager(), new ArrayList())));
            }
        }
        return list;
    }

    private static Args getArgs(Fragment fragment) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = Bundle.EMPTY;
        }
        return new Args(arguments.getInt(ARGS_ID, fragment.getId()), arguments.getBoolean(ARGS_IS_HIDE), arguments.getBoolean(ARGS_IS_ADD_STACK));
    }

    public static List<Fragment> getFragments(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> g2 = fragmentManager.g();
        return (g2 == null || g2.isEmpty()) ? Collections.emptyList() : g2;
    }

    public static List<Fragment> getFragmentsInStack(FragmentManager fragmentManager) {
        Bundle arguments;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> fragments = getFragments(fragmentManager);
        ArrayList arrayList = new ArrayList();
        for (Fragment next : fragments) {
            if (!(next == null || (arguments = next.getArguments()) == null || !arguments.getBoolean(ARGS_IS_ADD_STACK))) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static String getSimpleName(Fragment fragment) {
        return fragment == null ? "null" : fragment.getClass().getSimpleName();
    }

    public static Fragment getTop(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getTopIsInStack(fragmentManager, (Fragment) null, false);
    }

    public static Fragment getTopInStack(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getTopIsInStack(fragmentManager, (Fragment) null, true);
    }

    private static Fragment getTopIsInStack(FragmentManager fragmentManager, Fragment fragment, boolean z2) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> fragments = getFragments(fragmentManager);
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment2 = fragments.get(size);
            if (fragment2 != null) {
                if (!z2) {
                    return getTopIsInStack(fragment2.getChildFragmentManager(), fragment2, false);
                }
                Bundle arguments = fragment2.getArguments();
                if (arguments != null && arguments.getBoolean(ARGS_IS_ADD_STACK)) {
                    return getTopIsInStack(fragment2.getChildFragmentManager(), fragment2, true);
                }
            }
        }
        return fragment;
    }

    public static Fragment getTopShow(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getTopShowIsInStack(fragmentManager, (Fragment) null, false);
    }

    public static Fragment getTopShowInStack(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getTopShowIsInStack(fragmentManager, (Fragment) null, true);
    }

    private static Fragment getTopShowIsInStack(FragmentManager fragmentManager, Fragment fragment, boolean z2) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> fragments = getFragments(fragmentManager);
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment2 = fragments.get(size);
            if (fragment2 != null && fragment2.isResumed() && fragment2.isVisible() && fragment2.getUserVisibleHint()) {
                if (!z2) {
                    return getTopShowIsInStack(fragment2.getChildFragmentManager(), fragment2, false);
                }
                Bundle arguments = fragment2.getArguments();
                if (arguments != null && arguments.getBoolean(ARGS_IS_ADD_STACK)) {
                    return getTopShowIsInStack(fragment2.getChildFragmentManager(), fragment2, true);
                }
            }
        }
        return fragment;
    }

    public static void hide(Fragment fragment) {
        Objects.requireNonNull(fragment, "Argument 'hide' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        putArgs(fragment, true);
        operateNoAnim(4, fragment.getFragmentManager(), (Fragment) null, fragment);
    }

    public static void hide(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> fragments = getFragments(fragmentManager);
        for (Fragment putArgs : fragments) {
            putArgs(putArgs, true);
        }
        operateNoAnim(4, fragmentManager, (Fragment) null, (Fragment[]) fragments.toArray(new Fragment[0]));
    }

    private static void operate(int i2, FragmentManager fragmentManager, s sVar, Fragment fragment, Fragment... fragmentArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (fragment == null || !fragment.isRemoving()) {
            int i3 = 0;
            if (i2 == 1) {
                int length = fragmentArr.length;
                while (i3 < length) {
                    Fragment fragment2 = fragmentArr[i3];
                    Bundle arguments = fragment2.getArguments();
                    if (arguments != null) {
                        String string = arguments.getString(ARGS_TAG, fragment2.getClass().getName());
                        Fragment b2 = fragmentManager.b(string);
                        if (b2 != null && b2.isAdded()) {
                            sVar.a(b2);
                        }
                        sVar.a(arguments.getInt(ARGS_ID), fragment2, string);
                        if (arguments.getBoolean(ARGS_IS_HIDE)) {
                            sVar.b(fragment2);
                        }
                        if (arguments.getBoolean(ARGS_IS_ADD_STACK)) {
                            sVar.a(string);
                        }
                        i3++;
                    } else {
                        return;
                    }
                }
            } else if (i2 == 2) {
                int length2 = fragmentArr.length;
                while (i3 < length2) {
                    sVar.c(fragmentArr[i3]);
                    i3++;
                }
            } else if (i2 == 4) {
                int length3 = fragmentArr.length;
                while (i3 < length3) {
                    sVar.b(fragmentArr[i3]);
                    i3++;
                }
            } else if (i2 == 8) {
                sVar.c(fragment);
                int length4 = fragmentArr.length;
                while (i3 < length4) {
                    Fragment fragment3 = fragmentArr[i3];
                    if (fragment3 != fragment) {
                        sVar.b(fragment3);
                    }
                    i3++;
                }
            } else if (i2 == 16) {
                Bundle arguments2 = fragmentArr[0].getArguments();
                if (arguments2 != null) {
                    String string2 = arguments2.getString(ARGS_TAG, fragmentArr[0].getClass().getName());
                    sVar.b(arguments2.getInt(ARGS_ID), fragmentArr[0], string2);
                    if (arguments2.getBoolean(ARGS_IS_ADD_STACK)) {
                        sVar.a(string2);
                    }
                } else {
                    return;
                }
            } else if (i2 == 32) {
                int length5 = fragmentArr.length;
                while (i3 < length5) {
                    Fragment fragment4 = fragmentArr[i3];
                    if (fragment4 != fragment) {
                        sVar.a(fragment4);
                    }
                    i3++;
                }
            } else if (i2 == 64) {
                int length6 = fragmentArr.length - 1;
                while (true) {
                    if (length6 < 0) {
                        break;
                    }
                    Fragment fragment5 = fragmentArr[length6];
                    if (fragment5 != fragmentArr[0]) {
                        sVar.a(fragment5);
                        length6--;
                    } else if (fragment != null) {
                        sVar.a(fragment5);
                    }
                }
            }
            sVar.d();
            fragmentManager.b();
            return;
        }
        Log.e("FragmentUtils", fragment.getClass().getName() + " is isRemoving");
    }

    private static void operateNoAnim(int i2, FragmentManager fragmentManager, Fragment fragment, Fragment... fragmentArr) {
        if (fragmentManager != null) {
            operate(i2, fragmentManager, fragmentManager.a(), fragment, fragmentArr);
        }
    }

    public static void pop(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        pop(fragmentManager, true);
    }

    public static void pop(FragmentManager fragmentManager, boolean z2) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z2) {
            fragmentManager.e();
        } else {
            fragmentManager.d();
        }
    }

    public static void popAll(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        popAll(fragmentManager, true);
    }

    public static void popAll(FragmentManager fragmentManager, boolean z2) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (fragmentManager.f() > 0) {
            FragmentManager.a b2 = fragmentManager.b(0);
            if (z2) {
                fragmentManager.b(b2.a(), 1);
            } else {
                fragmentManager.a(b2.a(), 1);
            }
        }
    }

    public static void popTo(FragmentManager fragmentManager, Class<? extends Fragment> cls, boolean z2) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        popTo(fragmentManager, cls, z2, true);
    }

    public static void popTo(FragmentManager fragmentManager, Class<? extends Fragment> cls, boolean z2, boolean z3) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        String name = cls.getName();
        if (z3) {
            fragmentManager.b(name, (int) z2);
        } else {
            fragmentManager.a(name, z2 ? 1 : 0);
        }
    }

    private static void putArgs(Fragment fragment, Args args) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            fragment.setArguments(arguments);
        }
        arguments.putInt(ARGS_ID, args.f10023id);
        arguments.putBoolean(ARGS_IS_HIDE, args.isHide);
        arguments.putBoolean(ARGS_IS_ADD_STACK, args.isAddStack);
        arguments.putString(ARGS_TAG, args.tag);
    }

    private static void putArgs(Fragment fragment, boolean z2) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            fragment.setArguments(arguments);
        }
        arguments.putBoolean(ARGS_IS_HIDE, z2);
    }

    public static void remove(Fragment fragment) {
        Objects.requireNonNull(fragment, "Argument 'remove' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        operateNoAnim(32, fragment.getFragmentManager(), (Fragment) null, fragment);
    }

    public static void removeAll(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        operateNoAnim(32, fragmentManager, (Fragment) null, (Fragment[]) getFragments(fragmentManager).toArray(new Fragment[0]));
    }

    public static void removeTo(Fragment fragment, boolean z2) {
        Objects.requireNonNull(fragment, "Argument 'removeTo' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        operateNoAnim(64, fragment.getFragmentManager(), z2 ? fragment : null, fragment);
    }

    public static void replace(Fragment fragment, Fragment fragment2) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, (String) null, false);
    }

    public static void replace(Fragment fragment, Fragment fragment2, int i2, int i3) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, (String) null, false, i2, i3, 0, 0);
    }

    public static void replace(Fragment fragment, Fragment fragment2, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, (String) null, false, i2, i3, i4, i5);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, str, false);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, int i2, int i3) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, str, false, i2, i3, 0, 0);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, str, false, i2, i3, i4, i5);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, boolean z2) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager != null) {
            replace(fragmentManager, fragment2, getArgs(fragment).f10023id, str, z2);
        }
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, boolean z2, int i2, int i3) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, str, z2, i2, i3, 0, 0);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, boolean z2, int i2, int i3, int i4, int i5) {
        Fragment fragment3 = fragment;
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Fragment fragment4 = fragment2;
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager != null) {
            replace(fragmentManager, fragment2, getArgs(fragment).f10023id, str, z2, i2, i3, i4, i5);
        }
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, boolean z2, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager != null) {
            replace(fragmentManager, fragment2, getArgs(fragment).f10023id, str, z2, viewArr);
        }
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, str, false, viewArr);
    }

    public static void replace(Fragment fragment, Fragment fragment2, boolean z2) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, (String) null, z2);
    }

    public static void replace(Fragment fragment, Fragment fragment2, boolean z2, int i2, int i3) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, (String) null, z2, i2, i3, 0, 0);
    }

    public static void replace(Fragment fragment, Fragment fragment2, boolean z2, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, (String) null, z2, i2, i3, i4, i5);
    }

    public static void replace(Fragment fragment, Fragment fragment2, boolean z2, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, (String) null, z2, viewArr);
    }

    public static void replace(Fragment fragment, Fragment fragment2, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'srcFragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'destFragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragment, fragment2, (String) null, false, viewArr);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, (String) null, false);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, int i3, int i4) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, (String) null, false, i3, i4, 0, 0);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, int i3, int i4, int i5, int i6) {
        FragmentManager fragmentManager2 = fragmentManager;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Fragment fragment2 = fragment;
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, (String) null, false, i3, i4, i5, i6);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, String str) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, str, false);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, String str, int i3, int i4) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, str, false, i3, i4, 0, 0);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, String str, int i3, int i4, int i5, int i6) {
        FragmentManager fragmentManager2 = fragmentManager;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Fragment fragment2 = fragment;
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, str, false, i3, i4, i5, i6);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, String str, boolean z2) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        s a2 = fragmentManager.a();
        putArgs(fragment, new Args(i2, str, false, z2));
        operate(16, fragmentManager, a2, (Fragment) null, fragment);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, String str, boolean z2, int i3, int i4) {
        FragmentManager fragmentManager2 = fragmentManager;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Fragment fragment2 = fragment;
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, str, z2, i3, i4, 0, 0);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, String str, boolean z2, int i3, int i4, int i5, int i6) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        s a2 = fragmentManager.a();
        putArgs(fragment, new Args(i2, str, false, z2));
        addAnim(a2, i3, i4, i5, i6);
        operate(16, fragmentManager, a2, (Fragment) null, fragment);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, String str, boolean z2, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        s a2 = fragmentManager.a();
        putArgs(fragment, new Args(i2, str, false, z2));
        addSharedElement(a2, viewArr);
        operate(16, fragmentManager, a2, (Fragment) null, fragment);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, String str, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, str, false, viewArr);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, boolean z2) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, (String) null, z2);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, boolean z2, int i3, int i4) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, (String) null, z2, i3, i4, 0, 0);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, boolean z2, int i3, int i4, int i5, int i6) {
        FragmentManager fragmentManager2 = fragmentManager;
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Fragment fragment2 = fragment;
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, (String) null, z2, i3, i4, i5, i6);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, boolean z2, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, (String) null, z2, viewArr);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i2, View... viewArr) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        replace(fragmentManager, fragment, i2, (String) null, false, viewArr);
    }

    public static void setBackground(Fragment fragment, Drawable drawable) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View view = fragment.getView();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(drawable);
            } else {
                view.setBackgroundDrawable(drawable);
            }
        }
    }

    public static void setBackgroundColor(Fragment fragment, int i2) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View view = fragment.getView();
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    public static void setBackgroundResource(Fragment fragment, int i2) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View view = fragment.getView();
        if (view != null) {
            view.setBackgroundResource(i2);
        }
    }

    public static void show(Fragment fragment) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        putArgs(fragment, false);
        operateNoAnim(2, fragment.getFragmentManager(), (Fragment) null, fragment);
    }

    public static void show(FragmentManager fragmentManager) {
        Objects.requireNonNull(fragmentManager, "Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        List<Fragment> fragments = getFragments(fragmentManager);
        for (Fragment putArgs : fragments) {
            putArgs(putArgs, false);
        }
        operateNoAnim(2, fragmentManager, (Fragment) null, (Fragment[]) fragments.toArray(new Fragment[0]));
    }

    public static void showHide(int i2, List<Fragment> list) {
        Objects.requireNonNull(list, "Argument 'fragments' of type List<Fragment> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        showHide(list.get(i2), list);
    }

    public static void showHide(int i2, List<Fragment> list, int i3, int i4, int i5, int i6) {
        Objects.requireNonNull(list, "Argument 'fragments' of type List<Fragment> (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        showHide(list.get(i2), list, i3, i4, i5, i6);
    }

    public static void showHide(int i2, Fragment... fragmentArr) {
        Objects.requireNonNull(fragmentArr, "Argument 'fragments' of type Fragment[] (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        showHide(fragmentArr[i2], fragmentArr);
    }

    public static void showHide(Fragment fragment, Fragment fragment2) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'hide' of type Fragment (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        showHide(fragment, (List<Fragment>) Collections.singletonList(fragment2));
    }

    public static void showHide(Fragment fragment, Fragment fragment2, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment2, "Argument 'hide' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        showHide(fragment, (List<Fragment>) Collections.singletonList(fragment2), i2, i3, i4, i5);
    }

    public static void showHide(Fragment fragment, List<Fragment> list) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(list, "Argument 'hide' of type List<Fragment> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Iterator<Fragment> it2 = list.iterator();
        while (true) {
            boolean z2 = false;
            if (it2.hasNext()) {
                Fragment next = it2.next();
                if (next != fragment) {
                    z2 = true;
                }
                putArgs(next, z2);
            } else {
                operateNoAnim(8, fragment.getFragmentManager(), fragment, (Fragment[]) list.toArray(new Fragment[0]));
                return;
            }
        }
    }

    public static void showHide(Fragment fragment, List<Fragment> list, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(list, "Argument 'hide' of type List<Fragment> (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Iterator<Fragment> it2 = list.iterator();
        while (true) {
            boolean z2 = false;
            if (!it2.hasNext()) {
                break;
            }
            Fragment next = it2.next();
            if (next != fragment) {
                z2 = true;
            }
            putArgs(next, z2);
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager != null) {
            s a2 = fragmentManager.a();
            addAnim(a2, i2, i3, i4, i5);
            operate(8, fragmentManager, a2, fragment, (Fragment[]) list.toArray(new Fragment[0]));
        }
    }

    public static void showHide(Fragment fragment, Fragment... fragmentArr) {
        Objects.requireNonNull(fragment, "Argument 'show' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragmentArr, "Argument 'hide' of type Fragment[] (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        showHide(fragment, (List<Fragment>) Arrays.asList(fragmentArr));
    }
}
