package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.amap.api.offlineservice.a;
import com.cfly.uav_pro.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class ej extends a implements TextWatcher, View.OnTouchListener, AbsListView.OnScrollListener, OfflineMapManager.OfflineLoadedListener, OfflineMapManager.OfflineMapDownloadListener {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f8482b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f8483c;

    /* renamed from: d  reason: collision with root package name */
    private DownLoadExpandListView f8484d;

    /* renamed from: e  reason: collision with root package name */
    private ListView f8485e;

    /* renamed from: f  reason: collision with root package name */
    private ExpandableListView f8486f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f8487g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f8488h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public AutoCompleteTextView f8489i;

    /* renamed from: j  reason: collision with root package name */
    private RelativeLayout f8490j;

    /* renamed from: k  reason: collision with root package name */
    private RelativeLayout f8491k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ImageView f8492l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public ImageView f8493m;

    /* renamed from: n  reason: collision with root package name */
    private RelativeLayout f8494n;

    /* renamed from: o  reason: collision with root package name */
    private List<OfflineMapProvince> f8495o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private ed f8496p;

    /* renamed from: q  reason: collision with root package name */
    private OfflineMapManager f8497q = null;

    /* renamed from: r  reason: collision with root package name */
    private ec f8498r;

    /* renamed from: s  reason: collision with root package name */
    private ee f8499s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f8500t = true;

    /* renamed from: u  reason: collision with root package name */
    private boolean f8501u = true;

    /* renamed from: v  reason: collision with root package name */
    private int f8502v = -1;

    /* renamed from: w  reason: collision with root package name */
    private long f8503w = 0;

    /* renamed from: x  reason: collision with root package name */
    private ef f8504x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f8505y = true;

    private void f() {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f8493m.getLayoutParams();
            layoutParams.leftMargin = a(18.0f);
            this.f8493m.setLayoutParams(layoutParams);
            this.f8489i.setPadding(a(30.0f), 0, 0, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        i();
        ee eeVar = new ee(this.f8497q, this.f9849a);
        this.f8499s = eeVar;
        this.f8485e.setAdapter(eeVar);
    }

    private void h() {
        ec ecVar = new ec(this.f9849a, this, this.f8497q, this.f8495o);
        this.f8498r = ecVar;
        this.f8484d.setAdapter(ecVar);
        this.f8498r.notifyDataSetChanged();
    }

    private void i() {
        ArrayList<OfflineMapProvince> offlineMapProvinceList = this.f8497q.getOfflineMapProvinceList();
        this.f8495o.clear();
        this.f8495o.add((Object) null);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < offlineMapProvinceList.size(); i2++) {
            OfflineMapProvince offlineMapProvince = offlineMapProvinceList.get(i2);
            if (offlineMapProvince.getCityList().size() != 1) {
                this.f8495o.add(i2 + 1, offlineMapProvince);
            } else {
                String provinceName = offlineMapProvince.getProvinceName();
                if (!provinceName.contains("香港") && !provinceName.contains("澳门")) {
                    boolean contains = provinceName.contains("全国概要图");
                    ArrayList<OfflineMapCity> cityList = offlineMapProvince.getCityList();
                    if (contains) {
                        arrayList3.addAll(0, cityList);
                    } else {
                        arrayList3.addAll(cityList);
                    }
                } else {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                }
            }
        }
        OfflineMapProvince offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName("基本功能包+直辖市");
        offlineMapProvince2.setCityList(arrayList3);
        this.f8495o.set(0, offlineMapProvince2);
        OfflineMapProvince offlineMapProvince3 = new OfflineMapProvince();
        offlineMapProvince3.setProvinceName("直辖市");
        offlineMapProvince3.setCityList(arrayList);
        OfflineMapProvince offlineMapProvince4 = new OfflineMapProvince();
        offlineMapProvince4.setProvinceName("港澳");
        offlineMapProvince4.setCityList(arrayList2);
        this.f8495o.add(offlineMapProvince4);
    }

    private void j() {
        AutoCompleteTextView autoCompleteTextView = this.f8489i;
        if (autoCompleteTextView != null && autoCompleteTextView.isFocused()) {
            this.f8489i.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.f9849a.getSystemService("input_method");
            boolean z2 = false;
            if (inputMethodManager != null) {
                z2 = inputMethodManager.isActive();
            }
            if (z2) {
                inputMethodManager.hideSoftInputFromWindow(this.f8489i.getWindowToken(), 2);
            }
        }
    }

    public final void a(View view) {
        try {
            int id2 = view.getId();
            if (id2 == R.dimen.abc_button_padding_vertical_material) {
                this.f9849a.closeScr();
            } else if (id2 == R.dimen.abc_action_bar_content_inset_material) {
                if (this.f8501u) {
                    this.f8484d.setVisibility(8);
                    this.f8487g.setBackgroundResource(R.animator.fragment_close_exit);
                    this.f8501u = false;
                    return;
                }
                this.f8484d.setVisibility(0);
                this.f8487g.setBackgroundResource(R.animator.design_appbar_state_list_animator);
                this.f8501u = true;
            } else if (id2 != R.dimen.abc_action_bar_elevation_material) {
            } else {
                if (this.f8500t) {
                    this.f8496p.b();
                    this.f8488h.setBackgroundResource(R.animator.fragment_close_exit);
                    this.f8500t = false;
                    return;
                }
                this.f8496p.a();
                this.f8488h.setBackgroundResource(R.animator.design_appbar_state_list_animator);
                this.f8500t = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(OfflineMapCity offlineMapCity) {
        try {
            if (this.f8504x == null) {
                this.f8504x = new ef(this.f9849a, this.f8497q);
            }
            this.f8504x.a(offlineMapCity.getState(), offlineMapCity.getCity());
            this.f8504x.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(boolean z2) {
        int i2 = 0;
        if (z2) {
            this.f8490j.setVisibility(8);
            this.f8491k.setVisibility(8);
            this.f8484d.setVisibility(8);
            this.f8486f.setVisibility(8);
            this.f8494n.setVisibility(8);
            this.f8485e.setVisibility(0);
            return;
        }
        this.f8490j.setVisibility(0);
        this.f8491k.setVisibility(0);
        this.f8494n.setVisibility(0);
        this.f8484d.setVisibility(this.f8501u ? 0 : 8);
        ExpandableListView expandableListView = this.f8486f;
        if (!this.f8500t) {
            i2 = 8;
        }
        expandableListView.setVisibility(i2);
        this.f8485e.setVisibility(8);
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void b() {
        View a2 = el.a((Context) this.f9849a, (int) R.array.CH6_Options);
        DownLoadExpandListView downLoadExpandListView = (DownLoadExpandListView) a2.findViewById(R.dimen.abc_action_bar_default_padding_end_material);
        this.f8484d = downLoadExpandListView;
        downLoadExpandListView.setOnTouchListener(this);
        this.f8490j = (RelativeLayout) a2.findViewById(R.dimen.abc_action_bar_content_inset_material);
        this.f8487g = (ImageView) a2.findViewById(R.dimen.abc_action_bar_default_height_material);
        this.f8490j.setOnClickListener(this.f9849a);
        this.f8491k = (RelativeLayout) a2.findViewById(R.dimen.abc_action_bar_elevation_material);
        this.f8488h = (ImageView) a2.findViewById(R.dimen.abc_action_bar_icon_vertical_padding_material);
        this.f8491k.setOnClickListener(this.f9849a);
        this.f8494n = (RelativeLayout) a2.findViewById(R.dimen.abc_action_bar_default_padding_start_material);
        ImageView imageView = (ImageView) this.f8483c.findViewById(R.dimen.abc_button_padding_vertical_material);
        this.f8482b = imageView;
        imageView.setOnClickListener(this.f9849a);
        this.f8493m = (ImageView) this.f8483c.findViewById(R.dimen.abc_config_prefDialogWidth);
        ImageView imageView2 = (ImageView) this.f8483c.findViewById(R.dimen.abc_control_inset_material);
        this.f8492l = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                try {
                    ej.this.f8489i.setText("");
                    ej.this.f8492l.setVisibility(8);
                    ej.this.a(false);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ej.this.f8493m.getLayoutParams();
                    layoutParams.leftMargin = ej.this.a(95.0f);
                    ej.this.f8493m.setLayoutParams(layoutParams);
                    ej.this.f8489i.setPadding(ej.this.a(105.0f), 0, 0, 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        this.f8483c.findViewById(R.dimen.abc_control_padding_material).setOnTouchListener(this);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f8483c.findViewById(R.dimen.abc_control_corner_material);
        this.f8489i = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(this);
        this.f8489i.setOnTouchListener(this);
        this.f8485e = (ListView) this.f8483c.findViewById(R.dimen.abc_dialog_fixed_height_major);
        ExpandableListView expandableListView = (ExpandableListView) this.f8483c.findViewById(R.dimen.abc_dialog_corner_radius_material);
        this.f8486f = expandableListView;
        expandableListView.addHeaderView(a2);
        this.f8486f.setOnTouchListener(this);
        this.f8486f.setOnScrollListener(this);
        OfflineMapManager offlineMapManager = new OfflineMapManager(this.f9849a, this);
        this.f8497q = offlineMapManager;
        offlineMapManager.setOnOfflineLoadedListener(this);
        i();
        ed edVar = new ed(this.f8495o, this.f8497q, this.f9849a);
        this.f8496p = edVar;
        this.f8486f.setAdapter(edVar);
        this.f8486f.setOnGroupCollapseListener(this.f8496p);
        this.f8486f.setOnGroupExpandListener(this.f8496p);
        this.f8486f.setGroupIndicator((Drawable) null);
        if (this.f8500t) {
            this.f8488h.setBackgroundResource(R.animator.design_appbar_state_list_animator);
            this.f8486f.setVisibility(0);
        } else {
            this.f8488h.setBackgroundResource(R.animator.fragment_close_exit);
            this.f8486f.setVisibility(8);
        }
        if (this.f8501u) {
            this.f8487g.setBackgroundResource(R.animator.design_appbar_state_list_animator);
            this.f8484d.setVisibility(0);
            return;
        }
        this.f8487g.setBackgroundResource(R.animator.fragment_close_exit);
        this.f8484d.setVisibility(8);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final boolean c() {
        try {
            if (this.f8485e.getVisibility() == 0) {
                this.f8489i.setText("");
                this.f8492l.setVisibility(8);
                a(false);
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return super.c();
    }

    public final RelativeLayout d() {
        if (this.f8483c == null) {
            this.f8483c = (RelativeLayout) el.a((Context) this.f9849a, (int) R.array.ExampleWaypointType);
        }
        return this.f8483c;
    }

    public final void e() {
        this.f8497q.destroy();
    }

    public final void onCheckUpdate(boolean z2, String str) {
    }

    public final void onDownload(int i2, int i3, String str) {
        if (i2 == 101) {
            try {
                Toast.makeText(this.f9849a, "网络异常", 0).show();
                this.f8497q.pause();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (i2 == 2) {
            this.f8498r.a();
        }
        if (this.f8502v != i2) {
            ed edVar = this.f8496p;
            if (edVar != null) {
                edVar.notifyDataSetChanged();
            }
            ec ecVar = this.f8498r;
            if (ecVar != null) {
                ecVar.notifyDataSetChanged();
            }
            ee eeVar = this.f8499s;
            if (eeVar != null) {
                eeVar.notifyDataSetChanged();
            }
            this.f8502v = i2;
        } else if (System.currentTimeMillis() - this.f8503w > 1200) {
            if (this.f8505y) {
                this.f8498r.notifyDataSetChanged();
            }
            this.f8503w = System.currentTimeMillis();
        }
    }

    public final void onRemove(boolean z2, String str, String str2) {
        ec ecVar = this.f8498r;
        if (ecVar != null) {
            ecVar.b();
        }
    }

    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        this.f8505y = i2 != 2;
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (TextUtils.isEmpty(charSequence)) {
            a(false);
            this.f8492l.setVisibility(8);
            return;
        }
        this.f8492l.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        List<OfflineMapProvince> list = this.f8495o;
        if (list != null && list.size() > 0) {
            ArrayList<OfflineMapCity> arrayList2 = new ArrayList<>();
            for (OfflineMapProvince cityList : this.f8495o) {
                arrayList2.addAll(cityList.getCityList());
            }
            for (OfflineMapCity offlineMapCity : arrayList2) {
                String city = offlineMapCity.getCity();
                String pinyin = offlineMapCity.getPinyin();
                String jianpin = offlineMapCity.getJianpin();
                if (charSequence.length() == 1) {
                    if (!jianpin.startsWith(String.valueOf(charSequence))) {
                    }
                } else if (!jianpin.startsWith(String.valueOf(charSequence)) && !pinyin.startsWith(String.valueOf(charSequence)) && !city.startsWith(String.valueOf(charSequence))) {
                }
                arrayList.add(offlineMapCity);
            }
        }
        if (arrayList.size() > 0) {
            a(true);
            Collections.sort(arrayList, new Comparator<OfflineMapCity>() {
                private static int a(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
                    char[] charArray = offlineMapCity.getJianpin().toCharArray();
                    char[] charArray2 = offlineMapCity2.getJianpin().toCharArray();
                    return (charArray[0] >= charArray2[0] && charArray[1] >= charArray2[1]) ? 0 : 1;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return a((OfflineMapCity) obj, (OfflineMapCity) obj2);
                }
            });
            ee eeVar = this.f8499s;
            if (eeVar != null) {
                eeVar.a((List<OfflineMapCity>) arrayList);
                this.f8499s.notifyDataSetChanged();
                return;
            }
            return;
        }
        Toast.makeText(this.f9849a, "未找到相关城市", 0).show();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        j();
        if (view.getId() != R.dimen.abc_control_corner_material) {
            return false;
        }
        f();
        return false;
    }

    public final void onVerifyComplete() {
        g();
        h();
    }
}
