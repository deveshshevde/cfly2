package com.xeagle.android.activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.dialogs.al;
import com.xeagle.android.dialogs.k;
import com.xeagle.android.fragments.EditorListFragment;
import com.xeagle.android.fragments.EditorMapFragment;
import com.xeagle.android.fragments.EditorToolsFragment;
import com.xeagle.android.fragments.helpers.GestureMapFragment;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.utils.file.IO.d;
import com.xeagle.android.utils.prefs.AutoPanMode;
import com.xeagle.android.widgets.MenuImageview.RoundImageView;
import com.xeagle.android.widgets.button.FloatingActionButton;
import com.xeagle.android.widgets.button.FloatingActionsMenu;
import dy.ad;
import dy.ap;
import dy.ar;
import java.util.List;
import jo.af;
import jo.bf;
import jo.f;
import jq.a;
import jw.c;
import kn.b;
import kq.e;
import kx.g;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class EditorActivity extends SuperUI implements ActionMode.Callback, View.OnClickListener, View.OnLongClickListener, EditorToolsFragment.a, a, b.a {
    private ImageButton A;
    private RoundImageView B;
    private LinearLayout C;
    private TextView D;
    private FloatingActionsMenu E;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public kn.a f12260a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public EditorMapFragment f12261b;

    /* renamed from: c  reason: collision with root package name */
    private GestureMapFragment f12262c;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public EditorToolsFragment f12263k;

    /* renamed from: l  reason: collision with root package name */
    private e f12264l;

    /* renamed from: m  reason: collision with root package name */
    private FragmentManager f12265m;

    /* renamed from: n  reason: collision with root package name */
    private EditorListFragment f12266n;

    /* renamed from: o  reason: collision with root package name */
    private View f12267o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12268p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f12269q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f12270r;

    /* renamed from: s  reason: collision with root package name */
    private View f12271s;

    /* renamed from: t  reason: collision with root package name */
    private ActionMode f12272t;

    /* renamed from: u  reason: collision with root package name */
    private RadioButton f12273u;

    /* renamed from: v  reason: collision with root package name */
    private RadioButton f12274v;

    /* renamed from: w  reason: collision with root package name */
    private ImageButton f12275w;

    /* renamed from: x  reason: collision with root package name */
    private LinearLayout f12276x;

    /* renamed from: y  reason: collision with root package name */
    private RoundImageView f12277y;

    /* renamed from: z  reason: collision with root package name */
    private RoundImageView f12278z;

    /* renamed from: com.xeagle.android.activities.EditorActivity$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22114a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f22115b;

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
                f22115b = r0
                r1 = 1
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r2 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.MARKER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f22115b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r3 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.DRAW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f22115b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r4 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.POLY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f22115b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r4 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.TRASH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f22115b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r4 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.NONE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f22114a = r3
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r4 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_UPDATE     // Catch:{ NoSuchFieldError -> 0x004f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f22114a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r3 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.MISSION_RECEIVED     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f22114a     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.AUTOPILOT_WARNING     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.EditorActivity.AnonymousClass4.<clinit>():void");
        }
    }

    private void a(String str) {
        if (com.xeagle.android.camera.widgets.ablum.b.b("pref_maps_providers_key", DPMapProvider.GOOGLE_MAP.name()).equals(DPMapProvider.GOOGLE_MAP.name())) {
            com.xeagle.android.camera.widgets.ablum.b.a("pref_map_type", str);
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
        if (this.f12264l == null) {
            c(eVar);
        } else {
            a(eVar);
        }
    }

    private void b(boolean z2) {
        this.f12270r = z2;
        ActionMode actionMode = this.f12272t;
        if (actionMode != null) {
            actionMode.getMenu().findItem(R.id.menu_action_multi_edit).setIcon(this.f12270r ? R.drawable.ic_action_copy_blue : R.drawable.ic_action_copy);
        }
    }

    private void c(EditorToolsFragment.EditorTools editorTools) {
        this.f12261b.skipMarkerClickEvents(false);
        int i2 = AnonymousClass4.f22115b[editorTools.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                a(true);
            } else if (i2 == 3) {
                a(false);
                Toast.makeText(this, R.string.draw_the_survey_region, 0).show();
            } else if (i2 == 4 || i2 == 5) {
                a(false);
                this.f12262c.b();
                return;
            } else {
                return;
            }
            this.f12262c.a();
            return;
        }
        a(true);
        this.f12262c.b();
        this.f12261b.skipMarkerClickEvents(true);
    }

    private void c(e eVar) {
        this.f12264l = eVar;
        if (eVar != null) {
            if (this.f12271s == null) {
                eVar.show(this.f12265m, "Item Detail Window");
            } else {
                this.f12265m.a().b(R.id.containerItemDetail, this.f12264l, "Item Detail Window").c();
            }
        }
    }

    private void d() {
        new c(this.f12358g, getApplicationContext()) {
            public void a(d dVar) {
                EditorActivity.this.f12358g.r().d(dVar.a());
                EditorActivity.this.f12261b.a();
            }
        }.a((Context) this);
    }

    private void e() {
        final Context applicationContext = getApplicationContext();
        k.a(applicationContext, getString(R.string.label_enter_filename), g.b("waypoints"), new k.a() {
            public void a() {
            }

            public void a(CharSequence charSequence) {
                List<msg_mission_item> b2 = EditorActivity.this.f12358g.r().b(applicationContext);
                if (com.xeagle.android.utils.file.IO.e.a(applicationContext, b2, charSequence.toString())) {
                    Toast.makeText(applicationContext, R.string.file_saved_success, 0).show();
                    kt.a.a(new HitBuilders.EventBuilder().setCategory("Mission planning").setAction("Mission saved to file").setLabel("Mission items count").setValue((long) b2.size()));
                } else {
                    Toast.makeText(applicationContext, R.string.file_saved_error, 0).show();
                }
                EditorActivity.this.f12260a.f();
            }
        }).show(getSupportFragmentManager(), "Mission filename");
    }

    private void j() {
        e eVar = this.f12264l;
        if (eVar != null) {
            if (this.f12271s == null) {
                eVar.dismiss();
            } else {
                this.f12265m.a().a((Fragment) this.f12264l).c();
            }
            this.f12264l = null;
        }
    }

    private void k() {
        al a2 = al.a(getApplicationContext(), getString(R.string.dlg_clear_mission_title), getString(R.string.dlg_clear_mission_confirm), new al.a() {
            public void a() {
                EditorActivity.this.l();
                EditorActivity.this.f12260a.a(EditorActivity.this.f12260a.f13910a);
                if (EditorActivity.this.f12260a.f13910a.a().isEmpty()) {
                    EditorActivity.this.f12263k.a(EditorToolsFragment.EditorTools.NONE);
                }
            }

            public void b() {
                EditorActivity.this.f12263k.a(EditorToolsFragment.EditorTools.NONE);
            }
        });
        if (a2 != null) {
            a2.show(getSupportFragmentManager(), "clearMission");
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        kn.a aVar = this.f12260a;
        if (aVar != null) {
            aVar.f13910a.b(this.f12260a.b());
        }
    }

    public EditorToolsFragment.EditorTools a() {
        return this.f12263k.b();
    }

    public void a(EditorToolsFragment.EditorTools editorTools) {
        this.f12260a.f13910a.b();
        c(editorTools);
    }

    public void a(en.a aVar) {
        LinearLayout linearLayout;
        int i2;
        if (aVar.d().b()) {
            this.D.setText(aVar.d().f());
            linearLayout = this.C;
            i2 = 0;
        } else {
            linearLayout = this.C;
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
    }

    public void a(List<ko.a> list) {
        boolean isEmpty = list.isEmpty();
        this.f12266n.a(!isEmpty);
        if (!isEmpty && (this.f12272t == null || this.f12270r)) {
            b(b(list));
        } else {
            j();
        }
        this.f12261b.postUpdate();
    }

    public void a(ko.a aVar, boolean z2) {
        b(false);
        if (AnonymousClass4.f22115b[a().ordinal()] == 4) {
            this.f12260a.a(aVar);
            this.f12260a.f13910a.b();
            if (this.f12260a.b().size() <= 0) {
                this.f12263k.a(EditorToolsFragment.EditorTools.NONE);
            }
        } else if (this.f12272t != null) {
            if (this.f12260a.f13910a.d(aVar)) {
                this.f12260a.f13910a.a(aVar);
            } else {
                this.f12260a.f13910a.c(aVar);
            }
        } else if (this.f12260a.f13910a.d(aVar)) {
            this.f12260a.f13910a.b();
        } else {
            this.f12263k.a(EditorToolsFragment.EditorTools.NONE);
            this.f12260a.f13910a.b(aVar);
        }
        if (z2) {
            List<ko.a> a2 = this.f12260a.f13910a.a();
            if (a2.isEmpty()) {
                this.f12261b.a();
            } else {
                this.f12261b.a(kn.a.f(a2));
            }
        }
    }

    public void a(e eVar) {
        j();
        c(eVar);
    }

    public void a(boolean z2) {
        View view = this.f12267o;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 4);
        }
    }

    public boolean a(ko.a aVar) {
        b(false);
        if (this.f12272t == null) {
            this.f12263k.a(EditorToolsFragment.EditorTools.NONE);
            this.f12266n.a(2);
            this.f12272t = startActionMode(this);
            this.f12260a.f13910a.b(aVar);
            return true;
        } else if (this.f12260a.f13910a.d(aVar)) {
            this.f12260a.f13910a.b();
            return true;
        } else {
            this.f12260a.f13910a.b(this.f12260a.b());
            return true;
        }
    }

    public void b() {
    }

    public void b(EditorToolsFragment.EditorTools editorTools) {
        if (AnonymousClass4.f22115b[editorTools.ordinal()] == 4) {
            k();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void missionUpdateEvent(ar arVar) {
        if (arVar.a() == 20) {
            ej.c h2 = this.f12260a.h();
            ej.d d2 = this.f12358g.n().d();
            String str = "Distance " + h2;
            if (d2 != null) {
                int a2 = (int) (h2.a() / d2.a());
                str = str + String.format(", Flight time: %02d:%02d", new Object[]{Integer.valueOf(a2 / 60), Integer.valueOf(a2 % 60)});
            }
            this.f12269q.setText(str);
            if (this.f12260a.f13910a.a().isEmpty() && this.f12264l != null) {
                j();
            }
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void misssionRecEvent(ap apVar) {
        EditorMapFragment editorMapFragment;
        if (apVar.a() == 21 && (editorMapFragment = this.f12261b) != null) {
            editorMapFragment.a();
        }
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_action_delete /*2131298093*/:
                kn.a aVar = this.f12260a;
                aVar.a(aVar.f13910a);
                actionMode.finish();
                this.f12261b.a();
                return true;
            case R.id.menu_action_multi_edit /*2131298094*/:
                if (this.f12270r) {
                    j();
                    b(false);
                    return true;
                }
                List<ko.a> a2 = this.f12260a.f13910a.a();
                if (a2.size() >= 1) {
                    b(b(a2));
                    b(true);
                } else {
                    Toast.makeText(getApplicationContext(), "No Waypoint(s) selected.", 1).show();
                }
                kt.a.a(new HitBuilders.EventBuilder().setCategory("Editor").setAction("Action mode button").setLabel("Multi edit"));
                return true;
            case R.id.menu_action_reverse /*2131298095*/:
                this.f12260a.e();
                return true;
            default:
                return false;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.f12261b.saveCameraPosition();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0082, code lost:
        startActivity(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008d, code lost:
        r1.f12263k.a();
        r1.E.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        r1.f12268p = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r2) {
        /*
            r1 = this;
            int r2 = r2.getId()
            switch(r2) {
                case 2131297035: goto L_0x0098;
                case 2131297076: goto L_0x008a;
                case 2131297077: goto L_0x0086;
                case 2131297235: goto L_0x007b;
                case 2131297616: goto L_0x0069;
                case 2131297647: goto L_0x0057;
                case 2131297672: goto L_0x0045;
                case 2131298022: goto L_0x0037;
                case 2131298027: goto L_0x0023;
                case 2131298208: goto L_0x001c;
                case 2131298278: goto L_0x0013;
                case 2131298989: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x009d
        L_0x0009:
            android.widget.RadioButton r2 = r1.f12274v
            boolean r2 = r2.isChecked()
        L_0x000f:
            r1.f12268p = r2
            goto L_0x009d
        L_0x0013:
            android.widget.RadioButton r2 = r1.f12273u
            boolean r2 = r2.isChecked()
            r2 = r2 ^ 1
            goto L_0x000f
        L_0x001c:
            com.xeagle.android.fragments.EditorMapFragment r2 = r1.f12261b
            r2.goToMyLocation()
            goto L_0x009d
        L_0x0023:
            android.widget.LinearLayout r2 = r1.f12276x
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x0030
            android.widget.LinearLayout r2 = r1.f12276x
            r0 = 8
            goto L_0x0033
        L_0x0030:
            android.widget.LinearLayout r2 = r1.f12276x
            r0 = 0
        L_0x0033:
            r2.setVisibility(r0)
            goto L_0x009d
        L_0x0037:
            com.xeagle.android.fragments.EditorMapFragment r2 = r1.f12261b
            if (r2 == 0) goto L_0x009d
            r0 = 0
            r2.updateMapBearing(r0)
            com.xeagle.android.fragments.EditorMapFragment r2 = r1.f12261b
            r2.a()
            goto L_0x009d
        L_0x0045:
            r2 = 2131821741(0x7f1104ad, float:1.9276234E38)
            java.lang.String r2 = r1.getString(r2)
            r1.a((java.lang.String) r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.xeagle.android.activities.MainViewActivity> r0 = com.xeagle.android.activities.MainViewActivity.class
            r2.<init>(r1, r0)
            goto L_0x0082
        L_0x0057:
            r2 = 2131821740(0x7f1104ac, float:1.9276232E38)
            java.lang.String r2 = r1.getString(r2)
            r1.a((java.lang.String) r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.xeagle.android.activities.MainViewActivity> r0 = com.xeagle.android.activities.MainViewActivity.class
            r2.<init>(r1, r0)
            goto L_0x0082
        L_0x0069:
            r2 = 2131821739(0x7f1104ab, float:1.927623E38)
            java.lang.String r2 = r1.getString(r2)
            r1.a((java.lang.String) r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.xeagle.android.activities.MainViewActivity> r0 = com.xeagle.android.activities.MainViewActivity.class
            r2.<init>(r1, r0)
            goto L_0x0082
        L_0x007b:
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.xeagle.android.activities.FlightActionActivity> r0 = com.xeagle.android.activities.FlightActionActivity.class
            r2.<init>(r1, r0)
        L_0x0082:
            r1.startActivity(r2)
            goto L_0x009d
        L_0x0086:
            r1.e()
            goto L_0x008d
        L_0x008a:
            r1.d()
        L_0x008d:
            com.xeagle.android.fragments.EditorToolsFragment r2 = r1.f12263k
            r2.a()
            com.xeagle.android.widgets.button.FloatingActionsMenu r2 = r1.E
            r2.b()
            goto L_0x009d
        L_0x0098:
            com.xeagle.android.fragments.EditorMapFragment r2 = r1.f12261b
            r2.goToDroneLocation()
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.EditorActivity.onClick(android.view.View):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_editor);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.f12265m = supportFragmentManager;
        GestureMapFragment gestureMapFragment = (GestureMapFragment) supportFragmentManager.d((int) R.id.gestureMapFragment);
        this.f12262c = gestureMapFragment;
        this.f12261b = gestureMapFragment.c();
        EditorToolsFragment editorToolsFragment = (EditorToolsFragment) this.f12265m.d((int) R.id.flightActionsFragment);
        this.f12263k = editorToolsFragment;
        if (editorToolsFragment == null) {
            this.f12263k = new EditorToolsFragment();
            this.f12265m.a().a((int) R.id.flightActionsFragment, (Fragment) this.f12263k).c();
        }
        EditorListFragment editorListFragment = (EditorListFragment) this.f12265m.d((int) R.id.missionFragment1);
        this.f12266n = editorListFragment;
        if (editorListFragment == null) {
            this.f12266n = new EditorListFragment();
            this.f12265m.a().a((int) R.id.missionFragment1, (Fragment) this.f12266n).c();
        }
        View findViewById = findViewById(R.id.editorSplineToggleContainer);
        this.f12267o = findViewById;
        findViewById.setVisibility(0);
        this.C = (LinearLayout) findViewById(R.id.ll_failsfae);
        this.D = (TextView) findViewById(R.id.failsafeTextView);
        ImageButton imageButton = (ImageButton) findViewById(R.id.map_type_button);
        this.f12275w = imageButton;
        imageButton.setOnClickListener(this);
        this.f12276x = (LinearLayout) findViewById(R.id.ll_map_type);
        RoundImageView roundImageView = (RoundImageView) findViewById(R.id.iv_plain);
        this.f12277y = roundImageView;
        roundImageView.setOnClickListener(this);
        RoundImageView roundImageView2 = (RoundImageView) findViewById(R.id.iv_statellite);
        this.f12278z = roundImageView2;
        roundImageView2.setOnClickListener(this);
        RoundImageView roundImageView3 = (RoundImageView) findViewById(R.id.iv_hybird);
        this.B = roundImageView3;
        roundImageView3.setOnClickListener(this);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.flight_data);
        this.A = imageButton2;
        imageButton2.setOnClickListener(this);
        this.A.setOnLongClickListener(this);
        this.f12269q = (TextView) findViewById(R.id.editorInfoWindow);
        ((FloatingActionButton) findViewById(R.id.editor_tools_openFile)).setOnClickListener(this);
        ((FloatingActionButton) findViewById(R.id.editor_tools_saveFile)).setOnClickListener(this);
        this.E = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        ((ImageButton) findViewById(R.id.map_orientation_button)).setOnClickListener(this);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.my_location_button);
        imageButton3.setOnClickListener(this);
        imageButton3.setOnLongClickListener(this);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.drone_location_button);
        imageButton4.setOnClickListener(this);
        imageButton4.setOnLongClickListener(this);
        RadioButton radioButton = (RadioButton) findViewById(R.id.normalWpToggle);
        this.f12273u = radioButton;
        radioButton.setOnClickListener(this);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.splineWpToggle);
        this.f12274v = radioButton2;
        radioButton2.setOnClickListener(this);
        if (bundle != null) {
            this.f12268p = bundle.getBoolean("extra_is_spline_enabled");
        }
        this.f12264l = (e) this.f12265m.b("Item Detail Window");
        this.f12271s = findViewById(R.id.containerItemDetail);
        this.f12260a = ((XEagleApp) getApplication()).o();
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        actionMode.getMenuInflater().inflate(R.menu.action_mode_editor, menu);
        this.f12263k.getView().setVisibility(4);
        return true;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.f12266n.a(1);
        this.f12260a.f13910a.b();
        this.f12272t = null;
        b(false);
        this.f12263k.getView().setVisibility(0);
    }

    @l(a = ThreadMode.ASYNC)
    public void onDetailDialogDismissed(f fVar) {
        this.f12260a.f13910a.a(fVar.a());
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, en.a aVar) {
        super.onDroneEvent(droneEventsType, aVar);
        int i2 = AnonymousClass4.f22114a[droneEventsType.ordinal()];
        if (i2 == 1) {
            ej.c h2 = this.f12260a.h();
            ej.d d2 = aVar.n().d();
            String str = "Distance " + h2;
            if (d2 != null) {
                int a2 = (int) (h2.a() / d2.a());
                str = str + String.format(", Flight time: %02d:%02d", new Object[]{Integer.valueOf(a2 / 60), Integer.valueOf(a2 % 60)});
            }
            this.f12269q.setText(str);
            if (this.f12260a.f13910a.a().isEmpty() && this.f12264l != null) {
                j();
            }
        } else if (i2 == 2) {
            EditorMapFragment editorMapFragment = this.f12261b;
            if (editorMapFragment != null) {
                editorMapFragment.a();
            }
        } else if (i2 == 3) {
            a(aVar);
        }
    }

    public boolean onLongClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.drone_location_button) {
            this.f12261b.setAutoPanMode(AutoPanMode.DRONE);
            return true;
        } else if (id2 == R.id.flight_data) {
            Toast.makeText(this, "Click to preView flight data", 0).show();
            return true;
        } else if (id2 != R.id.my_location_button) {
            return false;
        } else {
            this.f12261b.setAutoPanMode(AutoPanMode.USER);
            return true;
        }
    }

    @l(a = ThreadMode.MAIN)
    public void onPathFinished(af afVar) {
        EditorToolsFragment editorToolsFragment;
        EditorToolsFragment.EditorTools editorTools;
        List<ef.a> a2 = afVar.a();
        List<ef.a> projectPathIntoMap = this.f12261b.projectPathIntoMap(a2);
        int i2 = AnonymousClass4.f22115b[a().ordinal()];
        if (i2 != 2) {
            if (i2 == 3) {
                if (a2.size() > 2) {
                    this.f12260a.b(projectPathIntoMap);
                } else {
                    editorToolsFragment = this.f12263k;
                    editorTools = EditorToolsFragment.EditorTools.POLY;
                }
            }
            editorToolsFragment = this.f12263k;
            editorTools = EditorToolsFragment.EditorTools.NONE;
        } else {
            Log.i("WPA", "PATH FINISHED DRAW.......");
            if (this.f12268p) {
                this.f12260a.d(projectPathIntoMap);
            } else {
                this.f12260a.c(projectPathIntoMap);
            }
            editorToolsFragment = this.f12263k;
            editorTools = EditorToolsFragment.EditorTools.NONE;
        }
        editorToolsFragment.a(editorTools);
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    public void onResume() {
        super.onResume();
        this.f12263k.b(a());
        c(a());
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("extra_is_spline_enabled", this.f12268p);
    }

    public void onStart() {
        super.onStart();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        this.f12260a.f13910a.a((b.a) this);
    }

    public void onStop() {
        super.onStop();
        this.f12260a.f13910a.b((b.a) this);
        org.greenrobot.eventbus.c.a().c(this);
    }

    @l(a = ThreadMode.ASYNC)
    public void onWaypointTypeChanged(bf bfVar) {
        this.f12260a.e(bfVar.a());
    }

    @l(a = ThreadMode.MAIN)
    public void warningEvent(ad adVar) {
        if (adVar.a() == 19) {
            a(this.f12358g);
        }
    }
}
