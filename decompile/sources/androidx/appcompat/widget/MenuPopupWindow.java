package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import java.lang.reflect.Method;

public class MenuPopupWindow extends ListPopupWindow implements u {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1225a;

    /* renamed from: b  reason: collision with root package name */
    private u f1226b;

    public static class MenuDropDownListView extends r {

        /* renamed from: b  reason: collision with root package name */
        final int f1227b;

        /* renamed from: c  reason: collision with root package name */
        final int f1228c;

        /* renamed from: d  reason: collision with root package name */
        private u f1229d;

        /* renamed from: e  reason: collision with root package name */
        private MenuItem f1230e;

        public MenuDropDownListView(Context context, boolean z2) {
            super(context, z2);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f1227b = 22;
                this.f1228c = 21;
                return;
            }
            this.f1227b = 21;
            this.f1228c = 22;
        }

        public /* bridge */ /* synthetic */ int a(int i2, int i3, int i4, int i5, int i6) {
            return super.a(i2, i3, i4, i5, i6);
        }

        public /* bridge */ /* synthetic */ boolean a(MotionEvent motionEvent, int i2) {
            return super.a(motionEvent, i2);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i2;
            int pointToPosition;
            int i3;
            if (this.f1229d != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i2 = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    i2 = 0;
                }
                f fVar = (f) adapter;
                i iVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i3 = pointToPosition - i2) >= 0 && i3 < fVar.getCount()) {
                    iVar = fVar.getItem(i3);
                }
                MenuItem menuItem = this.f1230e;
                if (menuItem != iVar) {
                    g a2 = fVar.a();
                    if (menuItem != null) {
                        this.f1229d.a(a2, menuItem);
                    }
                    this.f1230e = iVar;
                    if (iVar != null) {
                        this.f1229d.b(a2, iVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.f1227b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i2 != this.f1228c) {
                return super.onKeyDown(i2, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                }
                ((f) adapter).a().a(false);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(u uVar) {
            this.f1229d = uVar;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f1225a = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public r a(Context context, boolean z2) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z2);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    public void a(g gVar, MenuItem menuItem) {
        u uVar = this.f1226b;
        if (uVar != null) {
            uVar.a(gVar, menuItem);
        }
    }

    public void a(u uVar) {
        this.f1226b = uVar;
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1199g.setEnterTransition((Transition) obj);
        }
    }

    public void b(g gVar, MenuItem menuItem) {
        u uVar = this.f1226b;
        if (uVar != null) {
            uVar.b(gVar, menuItem);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1199g.setExitTransition((Transition) obj);
        }
    }

    public void c(boolean z2) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1225a;
            if (method != null) {
                try {
                    method.invoke(this.f1199g, new Object[]{Boolean.valueOf(z2)});
                } catch (Exception unused) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.f1199g.setTouchModal(z2);
        }
    }
}
