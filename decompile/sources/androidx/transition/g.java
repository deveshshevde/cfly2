package androidx.transition;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;

class g extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f4831a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4832b = true;

    g(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f4831a = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, this);
        ae.a(this.f4831a).a(this);
    }

    private int a(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (i2 <= childCount) {
            int i3 = (i2 + childCount) / 2;
            a(((i) getChildAt(i3)).f4842c, (ArrayList<View>) arrayList2);
            if (a(arrayList, (ArrayList<View>) arrayList2)) {
                i2 = i3 + 1;
            } else {
                childCount = i3 - 1;
            }
            arrayList2.clear();
        }
        return i2;
    }

    static g a(ViewGroup viewGroup) {
        return (g) viewGroup.getTag(R.id.ghost_view_holder);
    }

    private static void a(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean a(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(ae.a(viewGroup, i2));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                break;
            }
        }
        return true;
    }

    private static boolean a(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i2 = 1; i2 < min; i2++) {
            View view = arrayList.get(i2);
            View view2 = arrayList2.get(i2);
            if (view != view2) {
                return a(view, view2);
            }
        }
        return arrayList2.size() == min;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f4832b) {
            ae.a(this.f4831a).b(this);
            ae.a(this.f4831a).a(this);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    /* access modifiers changed from: package-private */
    public void a(i iVar) {
        ArrayList arrayList = new ArrayList();
        a(iVar.f4842c, (ArrayList<View>) arrayList);
        int a2 = a((ArrayList<View>) arrayList);
        if (a2 < 0 || a2 >= getChildCount()) {
            addView(iVar);
        } else {
            addView(iVar, a2);
        }
    }

    public void onViewAdded(View view) {
        if (this.f4832b) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f4831a.setTag(R.id.ghost_view_holder, (Object) null);
            ae.a(this.f4831a).b(this);
            this.f4832b = false;
        }
    }
}
