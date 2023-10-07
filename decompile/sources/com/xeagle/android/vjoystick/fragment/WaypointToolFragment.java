package com.xeagle.android.vjoystick.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import jo.l;
import jo.m;
import kn.a;
import org.greenrobot.eventbus.c;

public class WaypointToolFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final EditorTools f25030a = EditorTools.MARKER;

    /* renamed from: b  reason: collision with root package name */
    private EditorTools f25031b = EditorTools.NONE;

    /* renamed from: c  reason: collision with root package name */
    private a f25032c;

    /* renamed from: d  reason: collision with root package name */
    private IImageButton f25033d;

    /* renamed from: com.xeagle.android.vjoystick.fragment.WaypointToolFragment$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25034a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f25035b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools[] r0 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25035b = r0
                r1 = 1
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r2 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.TRASH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f25035b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.fragments.EditorToolsFragment$EditorTools r3 = com.xeagle.android.fragments.EditorToolsFragment.EditorTools.NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.flypro.core.mission.MissionItemType[] r2 = com.flypro.core.mission.MissionItemType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f25034a = r2
                com.flypro.core.mission.MissionItemType r3 = com.flypro.core.mission.MissionItemType.LAND     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f25034a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.flypro.core.mission.MissionItemType r2 = com.flypro.core.mission.MissionItemType.RTL     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.fragment.WaypointToolFragment.AnonymousClass1.<clinit>():void");
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
                return EditorTools.DRAW;
            case R.id.editor_tools_marker:
                return EditorTools.MARKER;
            case R.id.editor_tools_trash:
                return EditorTools.TRASH;
            default:
                return EditorTools.MARKER;
        }
    }

    private void a(EditorTools editorTools, boolean z2) {
        int i2;
        a aVar = this.f25032c;
        if (aVar == null || aVar.b().size() <= 0 || editorTools == EditorTools.TRASH || editorTools == EditorTools.NONE || !((i2 = AnonymousClass1.f25034a[this.f25032c.b().get(this.f25032c.b().size() - 1).b().a().ordinal()]) == 1 || i2 == 2)) {
            this.f25031b = editorTools;
            EditorTools editorTools2 = EditorTools.NONE;
            if (z2) {
                c.a().d(new l(this.f25031b));
                return;
            }
            return;
        }
        EditorTools editorTools3 = EditorTools.NONE;
        Toast.makeText(getActivity(), getString(R.string.editor_err_land_rtl_added), 0).show();
    }

    public EditorTools a() {
        return this.f25031b;
    }

    public void a(EditorTools editorTools) {
        a(editorTools, true);
    }

    public void onClick(View view) {
        EditorTools a2 = a(view.getId());
        if (a2 == this.f25031b) {
            a2 = EditorTools.NONE;
        }
        a(a2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.waypoint_tool_fragment, viewGroup, false);
    }

    public boolean onLongClick(View view) {
        EditorTools a2 = a(view.getId());
        if (a2 == EditorTools.NONE) {
            return false;
        }
        c.a().d(new m(a2));
        return false;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("selected_tool", this.f25031b.name());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f25032c = ((XEagleApp) getActivity().getApplication()).o();
        IImageButton iImageButton = (IImageButton) view.findViewById(R.id.waypoint_clear);
        this.f25033d = iImageButton;
        View[] viewArr = {iImageButton};
        for (int i2 = 0; i2 < 1; i2++) {
            View view2 = viewArr[i2];
            view2.setOnClickListener(this);
            view2.setOnLongClickListener(this);
        }
    }
}
