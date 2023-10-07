package com.xeagle.android.activities.helpers;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.utils.Utils;
import com.xeagle.android.widgets.actionProviders.InfoBarActionProvider;
import en.a;

public abstract class b extends Fragment implements DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12361a = (SuperUI.class.getName() + ".ACTION_TOGGLE_DRONE_CONNECTION");

    /* renamed from: b  reason: collision with root package name */
    public XEagleApp f12362b;

    /* renamed from: c  reason: collision with root package name */
    public a f12363c;

    /* renamed from: d  reason: collision with root package name */
    protected com.xeagle.android.utils.prefs.a f12364d;

    /* renamed from: e  reason: collision with root package name */
    private a f12365e = new a(getActivity());

    /* renamed from: f  reason: collision with root package name */
    private InfoBarActionProvider f12366f;

    /* renamed from: com.xeagle.android.activities.helpers.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22368a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.flypro.core.drone.DroneInterfaces$DroneEventsType[] r0 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22368a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22368a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.activities.helpers.b.AnonymousClass1.<clinit>():void");
        }
    }

    private void a(Intent intent) {
        if (intent != null) {
            if (f12361a.equals(intent.getAction())) {
                a();
            }
        }
    }

    private void b() {
        if (this.f12364d.N()) {
            AudioManager audioManager = (AudioManager) getActivity().getSystemService("audio");
            audioManager.setStreamVolume(3, audioManager.getStreamMaxVolume(3), 0);
        }
    }

    public void a() {
        this.f12363c.j().a(11);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        XEagleApp xEagleApp = (XEagleApp) getActivity().getApplication();
        this.f12362b = xEagleApp;
        this.f12363c = xEagleApp.k();
        com.xeagle.android.utils.prefs.a j2 = this.f12362b.j();
        this.f12364d = j2;
        if (j2.M()) {
            getActivity().getWindow().addFlags(128);
        }
        getActivity().setVolumeControlStream(3);
        Utils.b(getActivity().getApplicationContext());
        a(getActivity().getIntent());
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        InfoBarActionProvider infoBarActionProvider = this.f12366f;
        if (infoBarActionProvider != null) {
            infoBarActionProvider.onDroneEvent(droneEventsType, aVar);
        }
        int i2 = AnonymousClass1.f22368a[droneEventsType.ordinal()];
    }

    public void onStart() {
        super.onStart();
        b();
    }

    public void onStop() {
        super.onStop();
        InfoBarActionProvider infoBarActionProvider = this.f12366f;
        if (infoBarActionProvider != null) {
            infoBarActionProvider.a((a) null);
            this.f12366f = null;
        }
    }
}
