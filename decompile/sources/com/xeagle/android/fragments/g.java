package com.xeagle.android.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.MAVLink.common.msg_mission_item;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.mission.MissionItemType;
import com.google.android.gms.analytics.HitBuilders;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.b;
import com.xeagle.android.dialogs.al;
import com.xeagle.android.dialogs.k;
import com.xeagle.android.fragments.EditorToolsFragment;
import com.xeagle.android.fragments.helpers.GestureMapFragment;
import com.xeagle.android.utils.file.IO.d;
import com.xeagle.android.utils.prefs.AutoPanMode;
import com.xeagle.android.widgets.MenuImageview.RoundImageView;
import com.xeagle.android.widgets.button.FloatingActionButton;
import java.util.List;
import jo.af;
import jo.bf;
import jo.f;
import jq.a;
import jw.c;
import kn.b;
import kq.e;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class g extends b implements ActionMode.Callback, View.OnClickListener, View.OnLongClickListener, EditorToolsFragment.a, a, b.a {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public kn.a f12654e;

    /* renamed from: f  reason: collision with root package name */
    private GestureMapFragment f12655f;

    /* renamed from: g  reason: collision with root package name */
    private EditorToolsFragment f12656g;

    /* renamed from: h  reason: collision with root package name */
    private e f12657h;

    /* renamed from: i  reason: collision with root package name */
    private FragmentManager f12658i;

    /* renamed from: j  reason: collision with root package name */
    private EditorListFragment f12659j;

    /* renamed from: k  reason: collision with root package name */
    private View f12660k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12661l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f12662m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12663n;

    /* renamed from: o  reason: collision with root package name */
    private View f12664o;

    /* renamed from: p  reason: collision with root package name */
    private ActionMode f12665p;

    /* renamed from: q  reason: collision with root package name */
    private RadioButton f12666q;

    /* renamed from: r  reason: collision with root package name */
    private RadioButton f12667r;

    /* renamed from: s  reason: collision with root package name */
    private ImageButton f12668s;

    /* renamed from: t  reason: collision with root package name */
    private LinearLayout f12669t;

    /* renamed from: u  reason: collision with root package name */
    private RoundImageView f12670u;

    /* renamed from: v  reason: collision with root package name */
    private RoundImageView f12671v;

    /* renamed from: w  reason: collision with root package name */
    private RoundImageView f12672w;

    /* renamed from: x  reason: collision with root package name */
    private String f12673x;

    /* renamed from: y  reason: collision with root package name */
    private LinearLayout f12674y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f12675z;

    /* renamed from: com.xeagle.android.fragments.g$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23382a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f23383b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0059 */
        static {
            /*
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools[] r0 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23383b = r0
                r1 = 1
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r2 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.MARKER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f23383b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r3 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.DRAW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f23383b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r4 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.POLY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f23383b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r4 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.TRASH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f23383b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r4 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.NONE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f23382a = r3
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r4 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_UPDATE     // Catch:{ NoSuchFieldError -> 0x004f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f23382a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_RECEIVED     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f23382a     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.AUTOPILOT_WARNING     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.g.AnonymousClass4.<clinit>():void");
        }
    }

    private e b(List<ko.a> list) {
        MissionItemType missionItemType = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (ko.a b2 : list) {
            MissionItemType a2 = b2.b().a();
            if (missionItemType == null) {
                missionItemType = a2;
            } else if (missionItemType != a2) {
                return new e();
            }
        }
        return e.a(missionItemType);
    }

    private void b(e eVar) {
        if (this.f12657h == null) {
            c(eVar);
        } else {
            a(eVar);
        }
    }

    private void b(boolean z2) {
        this.f12663n = z2;
        ActionMode actionMode = this.f12665p;
        if (actionMode != null) {
            actionMode.getMenu().findItem(R.id.menu_action_multi_edit).setIcon(this.f12663n ? R.drawable.ic_action_copy_blue : R.drawable.ic_action_copy);
        }
    }

    private void c(EditorToolsFragment.EditorTools editorTools) {
        EditorMapFragment c2 = this.f12655f.c();
        c2.skipMarkerClickEvents(false);
        int i2 = AnonymousClass4.f23383b[editorTools.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                a(true);
            } else if (i2 == 3) {
                a(false);
                Toast.makeText(getActivity(), R.string.draw_the_survey_region, 0).show();
            } else if (i2 == 4 || i2 == 5) {
                a(false);
                this.f12655f.b();
                return;
            } else {
                return;
            }
            this.f12655f.a();
            return;
        }
        a(true);
        this.f12655f.b();
        c2.skipMarkerClickEvents(true);
    }

    private void c(e eVar) {
        this.f12657h = eVar;
        if (eVar != null) {
            if (this.f12664o == null) {
                eVar.show(this.f12658i, "Item Detail Window");
            } else {
                this.f12658i.a().b(R.id.containerItemDetail, this.f12657h, "Item Detail Window").c();
            }
        }
    }

    private void d() {
        final EditorMapFragment c2 = this.f12655f.c();
        new c(this.f12363c, getActivity().getApplicationContext()) {
            public void a(d dVar) {
                g.this.f12363c.r().d(dVar.a());
                c2.a();
            }
        }.a((Context) getActivity());
    }

    private void e() {
        final Context applicationContext = getActivity().getApplicationContext();
        k.a(applicationContext, getString(R.string.label_enter_filename), kx.g.b("waypoints"), new k.a() {
            public void a() {
            }

            public void a(CharSequence charSequence) {
                List<msg_mission_item> b2 = g.this.f12363c.r().b(applicationContext);
                if (com.xeagle.android.utils.file.IO.e.a(applicationContext, b2, charSequence.toString())) {
                    Toast.makeText(applicationContext, R.string.file_saved_success, 0).show();
                    kt.a.a(new HitBuilders.EventBuilder().setCategory("Mission planning").setAction("Mission saved to file").setLabel("Mission items count").setValue((long) b2.size()));
                    return;
                }
                Toast.makeText(applicationContext, R.string.file_saved_error, 0).show();
            }
        }).show(getActivity().getSupportFragmentManager(), "Mission filename");
    }

    private void f() {
        e eVar = this.f12657h;
        if (eVar != null) {
            if (this.f12664o == null) {
                eVar.dismiss();
            } else {
                this.f12658i.a().a((Fragment) this.f12657h).c();
            }
            this.f12657h = null;
        }
    }

    private void g() {
        al a2 = al.a(getActivity().getApplicationContext(), getString(R.string.dlg_clear_mission_title), getString(R.string.dlg_clear_mission_confirm), new al.a() {
            public void a() {
                g.this.f12654e.f();
            }

            public void b() {
            }
        });
        if (a2 != null) {
            a2.show(getActivity().getSupportFragmentManager(), "clearMission");
        }
    }

    public void a(EditorToolsFragment.EditorTools editorTools) {
        this.f12654e.f13910a.b();
        c(editorTools);
    }

    public void a(en.a aVar) {
        LinearLayout linearLayout;
        int i2;
        if (aVar.d().b()) {
            this.f12675z.setText(aVar.d().f());
            linearLayout = this.f12674y;
            i2 = 0;
        } else {
            linearLayout = this.f12674y;
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
    }

    public void a(List<ko.a> list) {
        EditorMapFragment c2 = this.f12655f.c();
        boolean isEmpty = list.isEmpty();
        this.f12659j.a(!isEmpty);
        if (!isEmpty && (this.f12665p == null || this.f12663n)) {
            b(b(list));
        } else {
            f();
        }
        c2.postUpdate();
    }

    public void a(ko.a aVar, boolean z2) {
        EditorMapFragment c2 = this.f12655f.c();
        b(false);
        if (AnonymousClass4.f23383b[c().ordinal()] == 4) {
            this.f12654e.a(aVar);
            this.f12654e.f13910a.b();
            if (this.f12654e.b().size() <= 0) {
                this.f12656g.a(EditorToolsFragment.EditorTools.NONE);
            }
        } else if (this.f12665p != null) {
            if (this.f12654e.f13910a.d(aVar)) {
                this.f12654e.f13910a.a(aVar);
            } else {
                this.f12654e.f13910a.c(aVar);
            }
        } else if (this.f12654e.f13910a.d(aVar)) {
            this.f12654e.f13910a.b();
        } else {
            this.f12656g.a(EditorToolsFragment.EditorTools.NONE);
            this.f12654e.f13910a.b(aVar);
        }
        if (z2) {
            List<ko.a> a2 = this.f12654e.f13910a.a();
            if (a2.isEmpty()) {
                c2.a();
            } else {
                c2.a(kn.a.f(a2));
            }
        }
    }

    public void a(e eVar) {
        f();
        c(eVar);
    }

    public void a(boolean z2) {
        View view = this.f12660k;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 4);
        }
    }

    public boolean a(ko.a aVar) {
        b(false);
        if (this.f12665p == null) {
            this.f12656g.a(EditorToolsFragment.EditorTools.NONE);
            this.f12659j.a(2);
            this.f12665p = getActivity().startActionMode(this);
            this.f12654e.f13910a.b(aVar);
            return true;
        } else if (this.f12654e.f13910a.d(aVar)) {
            this.f12654e.f13910a.b();
            return true;
        } else {
            this.f12654e.f13910a.b(this.f12654e.b());
            return true;
        }
    }

    public void b() {
    }

    public void b(EditorToolsFragment.EditorTools editorTools) {
        if (AnonymousClass4.f23383b[editorTools.ordinal()] == 4) {
            g();
        }
    }

    public EditorToolsFragment.EditorTools c() {
        return this.f12656g.b();
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        EditorMapFragment c2 = this.f12655f.c();
        switch (menuItem.getItemId()) {
            case R.id.menu_action_delete /*2131298093*/:
                kn.a aVar = this.f12654e;
                aVar.a(aVar.f13910a);
                actionMode.finish();
                c2.a();
                return true;
            case R.id.menu_action_multi_edit /*2131298094*/:
                if (this.f12663n) {
                    f();
                    b(false);
                    return true;
                }
                List<ko.a> a2 = this.f12654e.f13910a.a();
                if (a2.size() >= 1) {
                    b(b(a2));
                    b(true);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "No Waypoint(s) selected.", 1).show();
                }
                kt.a.a(new HitBuilders.EventBuilder().setCategory("Editor").setAction("Action mode button").setLabel("Multi edit"));
                return true;
            case R.id.menu_action_reverse /*2131298095*/:
                this.f12654e.e();
                return true;
            default:
                return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b7, code lost:
        startActivity(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c2, code lost:
        r2.f12656g.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        r2.f12661l = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r3) {
        /*
            r2 = this;
            com.xeagle.android.fragments.helpers.GestureMapFragment r0 = r2.f12655f
            com.xeagle.android.fragments.EditorMapFragment r0 = r0.c()
            int r3 = r3.getId()
            java.lang.String r1 = "pref_map_type"
            switch(r3) {
                case 2131297035: goto L_0x00c8;
                case 2131297076: goto L_0x00bf;
                case 2131297077: goto L_0x00bb;
                case 2131297616: goto L_0x0093;
                case 2131297647: goto L_0x006e;
                case 2131297672: goto L_0x0049;
                case 2131298022: goto L_0x003e;
                case 2131298027: goto L_0x0029;
                case 2131298208: goto L_0x0024;
                case 2131298278: goto L_0x001b;
                case 2131298989: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x00cb
        L_0x0011:
            android.widget.RadioButton r3 = r2.f12667r
            boolean r3 = r3.isChecked()
        L_0x0017:
            r2.f12661l = r3
            goto L_0x00cb
        L_0x001b:
            android.widget.RadioButton r3 = r2.f12666q
            boolean r3 = r3.isChecked()
            r3 = r3 ^ 1
            goto L_0x0017
        L_0x0024:
            r0.goToMyLocation()
            goto L_0x00cb
        L_0x0029:
            android.widget.LinearLayout r3 = r2.f12669t
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L_0x0036
            android.widget.LinearLayout r3 = r2.f12669t
            r0 = 8
            goto L_0x0039
        L_0x0036:
            android.widget.LinearLayout r3 = r2.f12669t
            r0 = 0
        L_0x0039:
            r3.setVisibility(r0)
            goto L_0x00cb
        L_0x003e:
            if (r0 == 0) goto L_0x00cb
            r3 = 0
            r0.updateMapBearing(r3)
            r0.a()
            goto L_0x00cb
        L_0x0049:
            java.lang.String r3 = kj.a.f13885d
            r2.f12673x = r3
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            android.content.SharedPreferences r3 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3)
            android.content.SharedPreferences$Editor r3 = r3.edit()
            java.lang.String r0 = r2.f12673x
            android.content.SharedPreferences$Editor r3 = r3.putString(r1, r0)
            r3.commit()
            android.content.Intent r3 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            java.lang.Class<com.xeagle.android.activities.MainViewActivity> r1 = com.xeagle.android.activities.MainViewActivity.class
            r3.<init>(r0, r1)
            goto L_0x00b7
        L_0x006e:
            java.lang.String r3 = kj.a.f13887f
            r2.f12673x = r3
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            android.content.SharedPreferences r3 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3)
            android.content.SharedPreferences$Editor r3 = r3.edit()
            java.lang.String r0 = r2.f12673x
            android.content.SharedPreferences$Editor r3 = r3.putString(r1, r0)
            r3.commit()
            android.content.Intent r3 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            java.lang.Class<com.xeagle.android.activities.MainViewActivity> r1 = com.xeagle.android.activities.MainViewActivity.class
            r3.<init>(r0, r1)
            goto L_0x00b7
        L_0x0093:
            java.lang.String r3 = kj.a.f13886e
            r2.f12673x = r3
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            android.content.SharedPreferences r3 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3)
            android.content.SharedPreferences$Editor r3 = r3.edit()
            java.lang.String r0 = r2.f12673x
            android.content.SharedPreferences$Editor r3 = r3.putString(r1, r0)
            r3.commit()
            android.content.Intent r3 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            java.lang.Class<com.xeagle.android.activities.MainViewActivity> r1 = com.xeagle.android.activities.MainViewActivity.class
            r3.<init>(r0, r1)
        L_0x00b7:
            r2.startActivity(r3)
            goto L_0x00cb
        L_0x00bb:
            r2.e()
            goto L_0x00c2
        L_0x00bf:
            r2.d()
        L_0x00c2:
            com.xeagle.android.fragments.EditorToolsFragment r3 = r2.f12656g
            r3.a()
            goto L_0x00cb
        L_0x00c8:
            r0.goToDroneLocation()
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.g.onClick(android.view.View):void");
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        actionMode.getMenuInflater().inflate(R.menu.action_mode_editor, menu);
        this.f12656g.getView().setVisibility(4);
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.activity_editor, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().c(this);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.f12659j.a(1);
        this.f12654e.f13910a.b();
        this.f12665p = null;
        b(false);
        this.f12656g.getView().setVisibility(0);
    }

    @l(a = ThreadMode.ASYNC)
    public void onDetailDialogDismissed(f fVar) {
        this.f12654e.f13910a.a(fVar.a());
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        super.onDroneEvent(droneEventsType, aVar);
        EditorMapFragment c2 = this.f12655f.c();
        int i2 = AnonymousClass4.f23382a[droneEventsType.ordinal()];
        if (i2 == 1) {
            ej.c h2 = this.f12654e.h();
            ej.d d2 = aVar.n().d();
            String str = "Distance " + h2;
            if (d2 != null) {
                int a2 = (int) (h2.a() / d2.a());
                str = str + String.format(", Flight time: %02d:%02d", new Object[]{Integer.valueOf(a2 / 60), Integer.valueOf(a2 % 60)});
            }
            this.f12662m.setText(str);
            if (this.f12654e.f13910a.a().isEmpty() && this.f12657h != null) {
                f();
            }
        } else if (i2 != 2) {
            if (i2 == 3) {
                a(aVar);
            }
        } else if (c2 != null) {
            c2.a();
        }
    }

    public boolean onLongClick(View view) {
        AutoPanMode autoPanMode;
        EditorMapFragment c2 = this.f12655f.c();
        int id2 = view.getId();
        if (id2 == R.id.drone_location_button) {
            autoPanMode = AutoPanMode.DRONE;
        } else if (id2 != R.id.my_location_button) {
            return false;
        } else {
            autoPanMode = AutoPanMode.USER;
        }
        c2.setAutoPanMode(autoPanMode);
        return true;
    }

    @l(a = ThreadMode.MAIN)
    public void onPathFinished(af afVar) {
        EditorToolsFragment editorToolsFragment;
        EditorToolsFragment.EditorTools editorTools;
        List<ef.a> a2 = afVar.a();
        List<ef.a> projectPathIntoMap = this.f12655f.c().projectPathIntoMap(a2);
        int i2 = AnonymousClass4.f23383b[c().ordinal()];
        if (i2 != 2) {
            if (i2 == 3) {
                if (a2.size() > 2) {
                    this.f12654e.b(projectPathIntoMap);
                } else {
                    editorToolsFragment = this.f12656g;
                    editorTools = EditorToolsFragment.EditorTools.POLY;
                }
            }
            editorToolsFragment = this.f12656g;
            editorTools = EditorToolsFragment.EditorTools.NONE;
        } else {
            if (this.f12661l) {
                this.f12654e.d(projectPathIntoMap);
            } else {
                this.f12654e.c(projectPathIntoMap);
            }
            editorToolsFragment = this.f12656g;
            editorTools = EditorToolsFragment.EditorTools.NONE;
        }
        editorToolsFragment.a(editorTools);
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    public void onResume() {
        super.onResume();
        this.f12656g.b(c());
        c(c());
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("extra_is_spline_enabled", this.f12661l);
    }

    public void onStart() {
        super.onStart();
        org.greenrobot.eventbus.c.a().a((Object) this);
        this.f12654e.f13910a.a((b.a) this);
    }

    public void onStop() {
        super.onStop();
        this.f12654e.f13910a.b((b.a) this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        this.f12658i = supportFragmentManager;
        GestureMapFragment gestureMapFragment = (GestureMapFragment) supportFragmentManager.d((int) R.id.gestureMapFragment);
        this.f12655f = gestureMapFragment;
        if (gestureMapFragment == null) {
            this.f12655f = new GestureMapFragment();
            this.f12658i.a().a((int) R.id.gestureMapFragment, (Fragment) this.f12655f).c();
        }
        EditorToolsFragment editorToolsFragment = (EditorToolsFragment) this.f12658i.d((int) R.id.flightActionsFragment);
        this.f12656g = editorToolsFragment;
        if (editorToolsFragment == null) {
            this.f12656g = new EditorToolsFragment();
            this.f12658i.a().a((int) R.id.flightActionsFragment, (Fragment) this.f12656g).c();
        }
        EditorListFragment editorListFragment = (EditorListFragment) this.f12658i.d((int) R.id.missionFragment1);
        this.f12659j = editorListFragment;
        if (editorListFragment == null) {
            this.f12659j = new EditorListFragment();
            this.f12658i.a().a((int) R.id.missionFragment1, (Fragment) this.f12659j).c();
        }
        View findViewById = view.findViewById(R.id.editorSplineToggleContainer);
        this.f12660k = findViewById;
        findViewById.setVisibility(0);
        this.f12674y = (LinearLayout) view.findViewById(R.id.ll_failsfae);
        this.f12675z = (TextView) view.findViewById(R.id.failsafeTextView);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.map_type_button);
        this.f12668s = imageButton;
        imageButton.setOnClickListener(this);
        this.f12669t = (LinearLayout) view.findViewById(R.id.ll_map_type);
        RoundImageView roundImageView = (RoundImageView) view.findViewById(R.id.iv_plain);
        this.f12670u = roundImageView;
        roundImageView.setOnClickListener(this);
        RoundImageView roundImageView2 = (RoundImageView) view.findViewById(R.id.iv_statellite);
        this.f12671v = roundImageView2;
        roundImageView2.setOnClickListener(this);
        RoundImageView roundImageView3 = (RoundImageView) view.findViewById(R.id.iv_hybird);
        this.f12672w = roundImageView3;
        roundImageView3.setOnClickListener(this);
        this.f12662m = (TextView) view.findViewById(R.id.editorInfoWindow);
        ((FloatingActionButton) view.findViewById(R.id.editor_tools_openFile)).setOnClickListener(this);
        ((FloatingActionButton) view.findViewById(R.id.editor_tools_saveFile)).setOnClickListener(this);
        ((ImageButton) view.findViewById(R.id.map_orientation_button)).setOnClickListener(this);
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.my_location_button);
        imageButton2.setOnClickListener(this);
        imageButton2.setOnLongClickListener(this);
        ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.drone_location_button);
        imageButton3.setOnClickListener(this);
        imageButton3.setOnLongClickListener(this);
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.normalWpToggle);
        this.f12666q = radioButton;
        radioButton.setOnClickListener(this);
        RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.splineWpToggle);
        this.f12667r = radioButton2;
        radioButton2.setOnClickListener(this);
        if (bundle != null) {
            this.f12661l = bundle.getBoolean("extra_is_spline_enabled");
        }
        this.f12657h = (e) this.f12658i.b("Item Detail Window");
        this.f12664o = getActivity().findViewById(R.id.containerItemDetail);
        this.f12654e = ((XEagleApp) getActivity().getApplication()).o();
    }

    @l(a = ThreadMode.ASYNC)
    public void onWaypointTypeChanged(bf bfVar) {
        this.f12654e.e(bfVar.a());
    }
}
