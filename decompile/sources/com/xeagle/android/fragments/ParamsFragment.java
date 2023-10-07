package com.xeagle.android.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.y;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.parameters.Parameter;
import com.flypro.core.parameters.ParameterMetadata;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.k;
import com.xeagle.android.utils.file.IO.h;
import com.xeagle.android.widgets.adapterViews.ParamsAdapterItem;
import com.xeagle.android.widgets.adapterViews.d;
import dy.aa;
import en.a;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import kx.g;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class ParamsFragment extends y implements DroneInterfaces.c, DroneInterfaces.d {

    /* renamed from: i  reason: collision with root package name */
    static final String f12532i = "ParamsFragment";

    /* renamed from: j  reason: collision with root package name */
    public static final String f12533j = (ParamsFragment.class.getName() + ".adapter.items");

    /* renamed from: k  reason: collision with root package name */
    private ProgressDialog f12534k;

    /* renamed from: l  reason: collision with root package name */
    private ProgressBar f12535l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public EditText f12536m;

    /* renamed from: n  reason: collision with root package name */
    private a f12537n;

    /* renamed from: o  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f12538o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public d f12539p;

    /* renamed from: com.xeagle.android.fragments.ParamsFragment$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23250a;

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
                f23250a = r0
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.TYPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23250a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.drone.DroneInterfaces$DroneEventsType r1 = com.flypro.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.fragments.ParamsFragment.AnonymousClass9.<clinit>():void");
        }
    }

    private void a(int i2, int i3) {
        if (this.f12534k == null) {
            i();
        }
        if (this.f12534k.isIndeterminate()) {
            this.f12534k.setIndeterminate(false);
            this.f12534k.setMax(i3);
        }
        this.f12534k.setProgress(i2);
        if (this.f12535l.isIndeterminate()) {
            this.f12535l.setIndeterminate(false);
            this.f12535l.setMax(i3);
        }
        this.f12535l.setProgress(i2);
    }

    /* access modifiers changed from: private */
    public void a(int i2, EditText editText) {
        ParamsAdapterItem paramsAdapterItem = (ParamsAdapterItem) this.f12539p.getItem(i2);
        ParameterMetadata b2 = paramsAdapterItem.b();
        if (b2 != null && b2.g()) {
            jx.a.a(paramsAdapterItem, editText, (Context) getActivity()).show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        f();
    }

    /* access modifiers changed from: private */
    public void a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f12539p.getFilter().filter("");
        } else {
            this.f12539p.getFilter().filter(charSequence);
        }
    }

    private void a(boolean z2, boolean z3) {
        if (z2) {
            this.f12536m.setVisibility(0);
            a((CharSequence) this.f12536m.getText());
            if (z3) {
                b();
            } else {
                c();
            }
        } else {
            c();
            this.f12536m.setVisibility(8);
            a((CharSequence) null);
        }
        this.f12538o.f12775b.edit().putBoolean("pref_params_filter_on", z2).apply();
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f12536m.setInputType(1);
        this.f12536m.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.f12536m, 1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        h();
    }

    /* access modifiers changed from: private */
    public void b(List<Parameter> list) {
        if (list != null && !list.isEmpty()) {
            this.f12539p.a(this.f12537n, new TreeSet(list));
            EditText editText = this.f12536m;
            if (editText == null || editText.getVisibility() != 0) {
                a((CharSequence) null);
            } else {
                this.f12536m.setText("");
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f12536m.setInputType(0);
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f12536m.getWindowToken(), 1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        e();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        boolean z2 = !d();
        a(z2, z2);
    }

    private boolean d() {
        return this.f12538o.f12775b.getBoolean("pref_params_filter_on", true);
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.f12537n.j().a()) {
            this.f12537n.e().a();
        } else {
            Toast.makeText(getActivity(), R.string.msg_connect_first, 0).show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        g();
    }

    private void f() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f12539p.getCount(); i3++) {
            ParamsAdapterItem paramsAdapterItem = (ParamsAdapterItem) this.f12539p.getItem(i3);
            if (paramsAdapterItem.d()) {
                this.f12537n.e().a(paramsAdapterItem.a());
                paramsAdapterItem.c();
                i2++;
            }
        }
        if (i2 > 0) {
            this.f12539p.notifyDataSetChanged();
        }
        FragmentActivity activity = getActivity();
        Toast.makeText(activity, i2 + " " + getString(R.string.msg_parameters_written_to_drone), 0).show();
    }

    private void g() {
        new jw.d() {
            public void a(List<Parameter> list) {
                ParamsFragment.this.b(list);
            }
        }.a((Context) getActivity());
    }

    private void h() {
        k.a(getActivity().getApplicationContext(), getString(R.string.label_enter_filename), g.a("Parameters-"), new k.a() {
            public void a() {
            }

            public void a(CharSequence charSequence) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < ParamsFragment.this.f12539p.getCount(); i2++) {
                    arrayList.add(((ParamsAdapterItem) ParamsFragment.this.f12539p.getItem(i2)).a());
                }
                if (arrayList.size() > 0 && new h(arrayList).a(ParamsFragment.this.getActivity().getApplicationContext(), charSequence.toString())) {
                    Toast.makeText(ParamsFragment.this.getActivity(), R.string.parameters_saved, 0).show();
                }
            }
        }).show(getChildFragmentManager(), "Parameters filename");
    }

    private void i() {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        this.f12534k = progressDialog;
        progressDialog.setTitle(R.string.refreshing_parameters);
        this.f12534k.setProgressStyle(1);
        this.f12534k.setIndeterminate(true);
        this.f12534k.setCancelable(false);
        this.f12534k.setCanceledOnTouchOutside(true);
        this.f12534k.show();
        this.f12535l.setIndeterminate(true);
        this.f12535l.setVisibility(0);
    }

    private void j() {
        ProgressDialog progressDialog = this.f12534k;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f12534k = null;
        }
        this.f12535l.setVisibility(8);
    }

    public void a() {
        i();
    }

    public void a(Parameter parameter, int i2, int i3) {
        a(i2, i3);
    }

    public void a(List<Parameter> list) {
        b(list);
        j();
    }

    @l(a = ThreadMode.MAIN)
    public void disConnectedEvent(dy.l lVar) {
        if (lVar.a() == 1) {
            j();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        XEagleApp xEagleApp = (XEagleApp) getActivity().getApplication();
        this.f12537n = xEagleApp.k();
        this.f12538o = xEagleApp.j();
        if (bundle != null) {
            this.f12539p = new d(getActivity(), R.layout.row_params, (ArrayList) bundle.getSerializable(f12533j));
        } else {
            this.f12539p = new d(getActivity(), R.layout.row_params);
            List<Parameter> b2 = this.f12537n.e().b();
            if (!b2.isEmpty()) {
                b(b2);
            }
        }
        a(this.f12539p);
        this.f12539p.a((d.a) new d.a() {
            public void a(int i2, EditText editText) {
                ParamsFragment.this.a(i2, editText);
            }
        });
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_parameters, menu);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_params, viewGroup, false);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        int i2 = AnonymousClass9.f23250a[droneEventsType.ordinal()];
        if (i2 == 1) {
            this.f12539p.a(aVar);
        } else if (i2 == 2) {
            j();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        this.f12539p.d();
        switch (menuItem.getItemId()) {
            case R.id.menu_filter_params /*2131298104*/:
                boolean z2 = !d();
                a(z2, z2);
                break;
            case R.id.menu_load_parameters /*2131298110*/:
                e();
                break;
            case R.id.menu_open_parameters /*2131298117*/:
                g();
                break;
            case R.id.menu_save_parameters /*2131298122*/:
                h();
                break;
            case R.id.menu_write_parameters /*2131298143*/:
                f();
                break;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(f12533j, new ArrayList(this.f12539p.c()));
    }

    public void onStart() {
        super.onStart();
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
        this.f12537n.a((DroneInterfaces.c) this);
        this.f12537n.e().a((DroneInterfaces.d) this);
        a(d(), false);
    }

    public void onStop() {
        super.onStop();
        if (c.a().b(this)) {
            c.a().c(this);
        }
        this.f12537n.b((DroneInterfaces.c) this);
        this.f12537n.e().a((DroneInterfaces.d) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.reload_progress);
        this.f12535l = progressBar;
        progressBar.setVisibility(8);
        EditText editText = (EditText) view.findViewById(R.id.parameter_filter);
        this.f12536m = editText;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z2) {
                if (!z2) {
                    ParamsFragment.this.c();
                }
            }
        });
        this.f12536m.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                ParamsFragment.this.b();
                return false;
            }
        });
        this.f12536m.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                ParamsFragment.this.a((CharSequence) editable.toString());
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.f12536m.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                ParamsFragment.this.a(textView.getText());
                if (i2 != 0 && i2 != 3) {
                    return true;
                }
                ParamsFragment.this.f12536m.clearFocus();
                return true;
            }
        });
        view.findViewById(16908292).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ParamsFragment.this.e();
            }
        });
        view.findViewById(R.id.menu_open_parameters).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ParamsFragment.this.e(view);
            }
        });
        view.findViewById(R.id.menu_filter_params).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ParamsFragment.this.d(view);
            }
        });
        view.findViewById(R.id.menu_load_parameters).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ParamsFragment.this.c(view);
            }
        });
        view.findViewById(R.id.menu_save_parameters).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ParamsFragment.this.b(view);
            }
        });
        view.findViewById(R.id.menu_write_parameters).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ParamsFragment.this.a(view);
            }
        });
    }

    @l(a = ThreadMode.ASYNC)
    public void typeEvent(aa aaVar) {
        if (aaVar.a() == 3) {
            this.f12539p.a(this.f12537n);
        }
    }
}
