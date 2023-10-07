package com.xeagle.android.fragments;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.widgets.button.FloatingActionButton;
import com.xeagle.android.widgets.button.FloatingActionsMenu;

public class EditorToolsFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final EditorTools f23180a = EditorTools.NONE;

    /* renamed from: b  reason: collision with root package name */
    private a f23181b;

    /* renamed from: c  reason: collision with root package name */
    private EditorTools f23182c = EditorTools.NONE;

    /* renamed from: d  reason: collision with root package name */
    private kn.a f23183d;

    /* renamed from: e  reason: collision with root package name */
    private FloatingActionButton f23184e;

    /* renamed from: f  reason: collision with root package name */
    private FloatingActionButton f23185f;

    /* renamed from: g  reason: collision with root package name */
    private FloatingActionButton f23186g;

    /* renamed from: h  reason: collision with root package name */
    private FloatingActionsMenu f23187h;

    public interface a {
        void a(EditorTools editorTools);

        void b(EditorTools editorTools);
    }

    /* renamed from: com.xeagle.android.fragments.EditorToolsFragment$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23188a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f23189b;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools[] r0 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23189b = r0
                r1 = 1
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r2 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.MARKER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f23189b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r3 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.DRAW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f23189b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r3 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.TRASH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = f23189b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r3 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.NONE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.flypro.core.mission.MissionItemType[] r2 = com.flypro.core.mission.MissionItemType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f23188a = r2
                com.flypro.core.mission.MissionItemType r3 = com.flypro.core.mission.MissionItemType.LAND     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f23188a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.flypro.core.mission.MissionItemType r2 = com.flypro.core.mission.MissionItemType.RTL     // Catch:{ NoSuchFieldError -> 0x004e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.EditorToolsFragment.AnonymousClass1.<clinit>():void");
        }
    }

    public enum EditorTools {
        MARKER,
        DRAW,
        POLY,
        TRASH,
        NONE
    }

    private EditorTools a(int i2) {
        switch (i2) {
            case R.id.editor_tools_draw:
                this.f23187h.b();
                this.f23184e.setImageDrawable(getResources().getDrawable(R.drawable.mutil_waypoint_pre));
                this.f23185f.setImageDrawable(getResources().getDrawable(R.drawable.single_waypoint_nor));
                this.f23186g.setImageDrawable(getResources().getDrawable(R.drawable.eraser_nor));
                return EditorTools.DRAW;
            case R.id.editor_tools_marker:
                this.f23187h.b();
                this.f23184e.setImageDrawable(getResources().getDrawable(R.drawable.mutil_waypoint_nor));
                this.f23185f.setImageDrawable(getResources().getDrawable(R.drawable.single_waypoint_pre));
                this.f23186g.setImageDrawable(getResources().getDrawable(R.drawable.eraser_nor));
                return EditorTools.MARKER;
            case R.id.editor_tools_trash:
                this.f23187h.b();
                this.f23184e.setImageDrawable(getResources().getDrawable(R.drawable.mutil_waypoint_nor));
                this.f23185f.setImageDrawable(getResources().getDrawable(R.drawable.single_waypoint_nor));
                this.f23186g.setImageDrawable(getResources().getDrawable(R.drawable.eraser_pre));
                return EditorTools.TRASH;
            default:
                return EditorTools.NONE;
        }
    }

    private void a(EditorTools editorTools, boolean z2) {
        int i2;
        if (this.f23183d.b().size() <= 0 || editorTools == EditorTools.TRASH || editorTools == EditorTools.NONE || !((i2 = AnonymousClass1.f23188a[this.f23183d.b().get(this.f23183d.b().size() - 1).b().a().ordinal()]) == 1 || i2 == 2)) {
            this.f23182c = editorTools;
            if (editorTools == EditorTools.NONE) {
                a();
            }
            a aVar = this.f23181b;
            if (aVar != null && z2) {
                aVar.a(this.f23182c);
                return;
            }
            return;
        }
        EditorTools editorTools2 = EditorTools.NONE;
        a();
        Toast.makeText(getActivity(), getString(R.string.editor_err_land_rtl_added), 0).show();
    }

    private int c(EditorTools editorTools) {
        int i2 = AnonymousClass1.f23189b[editorTools.ordinal()];
        if (i2 == 1) {
            return R.id.editor_tools_marker;
        }
        if (i2 == 2) {
            return R.id.editor_tools_draw;
        }
        if (i2 != 3) {
            return -1;
        }
        return R.id.editor_tools_trash;
    }

    public void a() {
        this.f23184e.setImageDrawable(getResources().getDrawable(R.drawable.mutil_waypoint_nor));
        this.f23185f.setImageDrawable(getResources().getDrawable(R.drawable.single_waypoint_nor));
        this.f23186g.setImageDrawable(getResources().getDrawable(R.drawable.eraser_nor));
    }

    public void a(EditorTools editorTools) {
        a(editorTools, true);
    }

    public EditorTools b() {
        return this.f23182c;
    }

    public void b(EditorTools editorTools) {
        FloatingActionButton floatingActionButton;
        Resources resources;
        FloatingActionButton floatingActionButton2;
        Resources resources2;
        a(editorTools, false);
        int c2 = c(editorTools);
        int i2 = R.drawable.eraser_nor;
        int i3 = R.drawable.single_waypoint_nor;
        switch (c2) {
            case R.id.editor_tools_draw:
                this.f23184e.setImageDrawable(getResources().getDrawable(R.drawable.mutil_waypoint_pre));
                floatingActionButton2 = this.f23185f;
                resources2 = getResources();
                break;
            case R.id.editor_tools_marker:
                this.f23184e.setImageDrawable(getResources().getDrawable(R.drawable.mutil_waypoint_nor));
                floatingActionButton2 = this.f23185f;
                resources2 = getResources();
                i3 = R.drawable.single_waypoint_pre;
                break;
            case R.id.editor_tools_trash:
                this.f23184e.setImageDrawable(getResources().getDrawable(R.drawable.mutil_waypoint_nor));
                this.f23185f.setImageDrawable(getResources().getDrawable(R.drawable.single_waypoint_nor));
                floatingActionButton = this.f23186g;
                resources = getResources();
                i2 = R.drawable.eraser_pre;
                break;
            default:
                return;
        }
        floatingActionButton2.setImageDrawable(resources2.getDrawable(i3));
        floatingActionButton = this.f23186g;
        resources = getResources();
        floatingActionButton.setImageDrawable(resources.getDrawable(i2));
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof a) {
            this.f23183d = ((XEagleApp) activity.getApplication()).o();
            this.f23181b = (a) activity;
            return;
        }
        throw new IllegalStateException("Parent activity must be an instance of " + a.class.getName());
    }

    public void onClick(View view) {
        EditorTools a2 = a(view.getId());
        if (a2 == this.f23182c) {
            a2 = EditorTools.NONE;
            a();
        }
        a(a2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_editor_tools, viewGroup, false);
    }

    public boolean onLongClick(View view) {
        EditorTools a2 = a(view.getId());
        if (a2 == EditorTools.NONE) {
            return false;
        }
        this.f23181b.b(a2);
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("selected_tool", this.f23182c.name());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f23184e = (FloatingActionButton) view.findViewById(R.id.editor_tools_draw);
        this.f23185f = (FloatingActionButton) view.findViewById(R.id.editor_tools_marker);
        this.f23186g = (FloatingActionButton) view.findViewById(R.id.editor_tools_trash);
        this.f23187h = (FloatingActionsMenu) view.findViewById(R.id.multiple_actions);
        View[] viewArr = {this.f23184e, this.f23185f, this.f23186g};
        for (int i2 = 0; i2 < 3; i2++) {
            View view2 = viewArr[i2];
            view2.setOnClickListener(this);
            view2.setOnLongClickListener(this);
        }
        EditorTools editorTools = f23180a;
        if (bundle != null) {
            editorTools = EditorTools.valueOf(bundle.getString("selected_tool", editorTools.name()));
        }
        b(editorTools);
    }
}
