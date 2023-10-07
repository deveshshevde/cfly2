package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.m;

class h implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, m.a {

    /* renamed from: a  reason: collision with root package name */
    e f889a;

    /* renamed from: b  reason: collision with root package name */
    private g f890b;

    /* renamed from: c  reason: collision with root package name */
    private b f891c;

    /* renamed from: d  reason: collision with root package name */
    private m.a f892d;

    public h(g gVar) {
        this.f890b = gVar;
    }

    public void a() {
        b bVar = this.f891c;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public void a(IBinder iBinder) {
        g gVar = this.f890b;
        b.a aVar = new b.a(gVar.f());
        e eVar = new e(aVar.a(), R.layout.abc_list_menu_item_layout);
        this.f889a = eVar;
        eVar.a((m.a) this);
        this.f890b.a((m) this.f889a);
        aVar.a(this.f889a.a(), (DialogInterface.OnClickListener) this);
        View p2 = gVar.p();
        if (p2 != null) {
            aVar.a(p2);
        } else {
            aVar.a(gVar.o()).a(gVar.n());
        }
        aVar.a((DialogInterface.OnKeyListener) this);
        b b2 = aVar.b();
        this.f891c = b2;
        b2.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f891c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f891c.show();
    }

    public void a(g gVar, boolean z2) {
        if (z2 || gVar == this.f890b) {
            a();
        }
        m.a aVar = this.f892d;
        if (aVar != null) {
            aVar.a(gVar, z2);
        }
    }

    public boolean a(g gVar) {
        m.a aVar = this.f892d;
        if (aVar != null) {
            return aVar.a(gVar);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f890b.a((MenuItem) (i) this.f889a.a().getItem(i2), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f889a.a(this.f890b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f891c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f891c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f890b.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f890b.performShortcut(i2, keyEvent, 0);
    }
}
