package com.xeagle.android.fragments.calibration.mag;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.variables.helpers.MagnetometerCalibration;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.lib.parcelables.ParcelableThreeSpacePoint;
import com.xeagle.android.widgets.scatterplot.ScatterPlot;
import dy.k;
import en.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import lp.b;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class FragmentSetupMAG extends Fragment implements DroneInterfaces.c, MagnetometerCalibration.OnMagCalibrationListener {
    private static final int CALIBRATION_COMPLETED = 2;
    private static final int CALIBRATION_IDLE = 0;
    private static final int CALIBRATION_IN_PROGRESS = 1;
    private static final String EXTRA_CALIBRATION_POINTS = "extra_calibration_points";
    private static final String EXTRA_CALIBRATION_STATUS = "extra_calibration_status";
    private Button buttonStep;
    private MagnetometerCalibration calibration;
    private ProgressBar calibrationFitness;
    private TextView calibrationProgress;
    /* access modifiers changed from: private */
    public int calibrationStatus = 0;
    private a drone;
    private View inProgressCalibrationView;
    private ScatterPlot plot1;
    private ScatterPlot plot2;
    private List<? extends b> startPoints;

    /* renamed from: com.xeagle.android.fragments.calibration.mag.FragmentSetupMAG$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType;

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
                $SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.calibration.mag.FragmentSetupMAG.AnonymousClass4.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void cancelCalibration() {
        MagnetometerCalibration magnetometerCalibration = this.calibration;
        if (magnetometerCalibration != null) {
            magnetometerCalibration.a();
            if (this.calibrationStatus == 1) {
                setCalibrationStatus(0);
            }
        }
        clearScreen();
    }

    /* access modifiers changed from: private */
    public void clearScreen() {
        this.plot1.a();
        this.plot2.a();
    }

    public static CharSequence getTitle(Context context) {
        return context.getText(R.string.setup_mag_title);
    }

    private void pauseCalibration() {
        MagnetometerCalibration magnetometerCalibration = this.calibration;
        if (magnetometerCalibration != null) {
            magnetometerCalibration.a();
        }
    }

    /* access modifiers changed from: private */
    public void setCalibrationStatus(int i2) {
        Button button;
        int i3;
        if (this.calibrationStatus != i2) {
            this.calibrationStatus = i2;
            if (i2 != 1) {
                if (i2 != 2) {
                    this.inProgressCalibrationView.setVisibility(8);
                    this.buttonStep.setVisibility(0);
                    button = this.buttonStep;
                    i3 = R.string.button_setup_calibrate;
                } else {
                    this.calibrationFitness.setIndeterminate(false);
                    this.calibrationFitness.setMax(100);
                    this.calibrationFitness.setProgress(100);
                    this.inProgressCalibrationView.setVisibility(8);
                    this.buttonStep.setVisibility(0);
                    button = this.buttonStep;
                    i3 = R.string.button_setup_done;
                }
                button.setText(i3);
                return;
            }
            this.buttonStep.setVisibility(8);
            this.inProgressCalibrationView.setVisibility(0);
            this.calibrationFitness.setIndeterminate(true);
            this.calibrationProgress.setText("0 / 100");
        }
    }

    @l(a = ThreadMode.MAIN)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            cancelCalibration();
            this.buttonStep.setEnabled(false);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneConnectEvent(k kVar) {
        if (kVar.a() == 0) {
            this.buttonStep.setEnabled(true);
        }
    }

    public void finished(lp.a aVar) {
        Log.d("MAG", "Calibration Finished: " + Arrays.toString(this.calibration.getOffsets()));
        FragmentActivity activity = getActivity();
        Toast.makeText(activity, "Calibration Finished: " + Arrays.toString(this.calibration.getOffsets()), 1).show();
        try {
            this.calibration.c();
        } catch (Exception e2) {
            e2.printStackTrace();
            Toast.makeText(getActivity(), e2.getMessage(), 1).show();
        }
        setCalibrationStatus(2);
    }

    public void newEstimation(lp.a aVar, lp.a aVar2, List<b> list, List<b> list2, int i2, int i3) {
        TextView textView;
        String str;
        int size = list.size();
        if (size != 0) {
            if (size < 10) {
                this.calibrationFitness.setIndeterminate(true);
                textView = this.calibrationProgress;
                str = "0 / 100";
            } else {
                if (i2 <= i3) {
                    i2 = i3;
                }
                this.calibrationFitness.setIndeterminate(false);
                this.calibrationFitness.setMax(100);
                this.calibrationFitness.setProgress((int) ((double) ((i2 * 100) / 16)));
                textView = this.calibrationProgress;
                str = this.calibrationFitness.getProgress() + " / 100";
            }
            textView.setText(str);
            b bVar = list.get(size - 1);
            this.plot1.a((float) bVar.f30971a);
            this.plot1.a((float) bVar.f30973c);
            if (aVar.f30965a.d() || aVar.f30966b.d()) {
                this.plot1.a((int[]) null);
            } else {
                this.plot1.a(new int[]{(int) aVar.f30965a.a(0), (int) aVar.f30965a.a(2), (int) aVar.f30966b.a(0), (int) aVar.f30966b.a(2)});
            }
            this.plot1.invalidate();
            this.plot2.a((float) bVar.f30972b);
            this.plot2.a((float) bVar.f30973c);
            if (aVar.f30965a.d() || aVar.f30966b.d()) {
                this.plot2.a((int[]) null);
            } else {
                this.plot2.a(new int[]{(int) aVar.f30965a.a(1), (int) aVar.f30965a.a(2), (int) aVar.f30966b.a(1), (int) aVar.f30966b.a(2)});
            }
            this.plot2.invalidate();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_setup_mag_main, viewGroup, false);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        Button button;
        int i2 = AnonymousClass4.$SwitchMap$com$flypro$core$drone$DroneInterfaces$DroneEventsType[droneEventsType.ordinal()];
        boolean z2 = true;
        if (i2 == 1) {
            button = this.buttonStep;
        } else if (i2 == 2) {
            cancelCalibration();
            button = this.buttonStep;
            z2 = false;
        } else {
            return;
        }
        button.setEnabled(z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = r0.getPoints();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSaveInstanceState(android.os.Bundle r5) {
        /*
            r4 = this;
            super.onSaveInstanceState(r5)
            int r0 = r4.calibrationStatus
            java.lang.String r1 = "extra_calibration_status"
            r5.putInt(r1, r0)
            com.flypro.core.drone.variables.helpers.MagnetometerCalibration r0 = r4.calibration
            if (r0 == 0) goto L_0x003b
            java.util.List r0 = r0.getPoints()
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x003b
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x0021:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.next()
            lp.b r1 = (lp.b) r1
            com.xeagle.android.lib.parcelables.ParcelableThreeSpacePoint r3 = new com.xeagle.android.lib.parcelables.ParcelableThreeSpacePoint
            r3.<init>((lp.b) r1)
            r2.add(r3)
            goto L_0x0021
        L_0x0036:
            java.lang.String r0 = "extra_calibration_points"
            r5.putParcelableArrayList(r0, r2)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.calibration.mag.FragmentSetupMAG.onSaveInstanceState(android.os.Bundle):void");
    }

    public void onStart() {
        super.onStart();
        if (!this.drone.j().a() || this.drone.d().d()) {
            cancelCalibration();
            this.buttonStep.setEnabled(false);
        } else {
            this.buttonStep.setEnabled(true);
        }
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        this.drone.a((DroneInterfaces.c) this);
        if (this.calibrationStatus == 1) {
            startCalibration();
        }
    }

    public void onStop() {
        super.onStop();
        if (c.a().b(this)) {
            c.a().c(this);
        }
        this.drone.b((DroneInterfaces.c) this);
        pauseCalibration();
    }

    public void onViewCreated(View view, Bundle bundle) {
        ArrayList parcelableArrayList;
        super.onViewCreated(view, bundle);
        ScatterPlot scatterPlot = (ScatterPlot) view.findViewById(R.id.scatterPlot1);
        this.plot1 = scatterPlot;
        scatterPlot.setTitle("XZ");
        ScatterPlot scatterPlot2 = (ScatterPlot) view.findViewById(R.id.scatterPlot2);
        this.plot2 = scatterPlot2;
        scatterPlot2.setTitle("YZ");
        this.inProgressCalibrationView = view.findViewById(R.id.in_progress_calibration_container);
        this.calibrationProgress = (TextView) view.findViewById(R.id.calibration_progress);
        Button button = (Button) view.findViewById(R.id.buttonStep);
        this.buttonStep = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (FragmentSetupMAG.this.calibrationStatus == 2) {
                    FragmentSetupMAG.this.clearScreen();
                    FragmentSetupMAG.this.setCalibrationStatus(0);
                    return;
                }
                FragmentSetupMAG.this.startCalibration();
            }
        });
        ((Button) view.findViewById(R.id.buttonCancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentSetupMAG.this.cancelCalibration();
            }
        });
        this.calibrationFitness = (ProgressBar) view.findViewById(R.id.calibration_progress_bar);
        a k2 = ((XEagleApp) getActivity().getApplication()).k();
        this.drone = k2;
        this.calibration = new MagnetometerCalibration(k2, this, new DroneInterfaces.b() {
            private final Handler handler = new Handler();

            public void post(Runnable runnable) {
                this.handler.post(runnable);
            }

            public void postDelayed(Runnable runnable, long j2) {
                this.handler.postDelayed(runnable, j2);
            }

            public void removeCallbacks(Runnable runnable) {
                this.handler.removeCallbacks(runnable);
            }
        });
        if (bundle != null) {
            int i2 = bundle.getInt(EXTRA_CALIBRATION_STATUS, 0);
            setCalibrationStatus(i2);
            if (i2 == 1 && (parcelableArrayList = bundle.getParcelableArrayList(EXTRA_CALIBRATION_POINTS)) != null && !parcelableArrayList.isEmpty()) {
                this.startPoints = parcelableArrayList;
                Iterator it2 = parcelableArrayList.iterator();
                while (it2.hasNext()) {
                    ParcelableThreeSpacePoint parcelableThreeSpacePoint = (ParcelableThreeSpacePoint) it2.next();
                    double d2 = parcelableThreeSpacePoint.f30971a;
                    double d3 = parcelableThreeSpacePoint.f30972b;
                    double d4 = parcelableThreeSpacePoint.f30973c;
                    this.plot1.a((float) d2);
                    float f2 = (float) d4;
                    this.plot1.a(f2);
                    this.plot2.a((float) d3);
                    this.plot2.a(f2);
                }
                this.plot1.invalidate();
                this.plot2.invalidate();
            }
        }
    }

    public void startCalibration() {
        FragmentActivity activity;
        int i2;
        if (this.calibration != null) {
            this.drone.e().c();
            this.drone.e().d();
            if (this.drone.B().h() == null) {
                this.drone.e().a();
                activity = getActivity();
                i2 = R.string.compass_calibration_1;
            } else if (this.drone.B().i() == null) {
                activity = getActivity();
                i2 = R.string.compass_calibration_2;
            } else {
                this.calibration.a(this.startPoints);
                this.startPoints = null;
                setCalibrationStatus(1);
                return;
            }
            Toast.makeText(activity, i2, 1).show();
        }
    }
}
