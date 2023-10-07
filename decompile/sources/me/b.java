package me;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import it.sephiroth.android.library.widget.AbsHListView;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private a f31091a;

    /* renamed from: b  reason: collision with root package name */
    private AbsHListView f31092b;

    public b(AbsHListView absHListView) {
        this.f31092b = absHListView;
    }

    public void a(ActionMode actionMode, int i2, long j2, boolean z2) {
        this.f31091a.a(actionMode, i2, j2, z2);
        if (this.f31092b.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }

    public void a(a aVar) {
        this.f31091a = aVar;
    }

    public boolean a() {
        return this.f31091a != null;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f31091a.onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (!this.f31091a.onCreateActionMode(actionMode, menu)) {
            return false;
        }
        this.f31092b.setLongClickable(false);
        return true;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.f31091a.onDestroyActionMode(actionMode);
        this.f31092b.f29198c = null;
        this.f31092b.a();
        this.f31092b.f29282aj = true;
        this.f31092b.w();
        this.f31092b.requestLayout();
        this.f31092b.setLongClickable(true);
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.f31091a.onPrepareActionMode(actionMode, menu);
    }
}
