package info.hannes.logcat.base;

import android.app.ActionBar;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.material.snackbar.Snackbar;
import info.hannes.logcat.R;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.bg;

public abstract class b extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public static final a f28641b = new a((f) null);

    /* renamed from: a  reason: collision with root package name */
    private MenuItem f28642a;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f28643c;

    /* renamed from: d  reason: collision with root package name */
    private c f28644d;

    /* renamed from: e  reason: collision with root package name */
    private SearchView f28645e;

    /* renamed from: f  reason: collision with root package name */
    private final String f28646f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f28647g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f28648h;

    /* renamed from: i  reason: collision with root package name */
    private String f28649i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f28650j;

    /* renamed from: k  reason: collision with root package name */
    private HashMap f28651k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* renamed from: info.hannes.logcat.base.b$b  reason: collision with other inner class name */
    public static final class C0189b implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f28652a;

        C0189b(b bVar) {
            this.f28652a = bVar;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            h.d(menuItem, "item");
            this.f28652a.a("");
            return true;
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            h.d(menuItem, "item");
            return true;
        }
    }

    public static final class c implements SearchView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f28653a;

        c(b bVar) {
            this.f28653a = bVar;
        }

        public boolean a(String str) {
            h.d(str, "query");
            this.f28653a.a(str);
            return true;
        }

        public boolean b(String str) {
            h.d(str, "newText");
            this.f28653a.a(str);
            return true;
        }
    }

    public static final /* synthetic */ RecyclerView a(b bVar) {
        RecyclerView recyclerView = bVar.f28643c;
        if (recyclerView == null) {
            h.b("logsRecycler");
        }
        return recyclerView;
    }

    private final void a(List<String> list, String str) {
        FragmentActivity activity = getActivity();
        File file = new File(activity != null ? activity.getExternalCacheDir() : null, str);
        kotlin.io.b.a(file, kotlin.collections.h.a(list, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (mm.b) null, 62, (Object) null), (Charset) null, 2, (Object) null);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/zip");
        Parcelable fromFile = Uri.fromFile(file);
        intent.putExtra("android.intent.extra.STREAM", fromFile);
        intent.putExtra("android.intent.extra.EMAIL", this.f28647g);
        l lVar = l.f30252a;
        String format = String.format(str, Arrays.copyOf(new Object[]{getString(R.string.app_name)}, 1));
        h.b(format, "java.lang.String.format(format, *args)");
        intent.putExtra("android.intent.extra.SUBJECT", format);
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.STREAM", fromFile);
        try {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
            startActivity(Intent.createChooser(intent, str + " ..."));
        } catch (ActivityNotFoundException unused) {
            FragmentActivity activity2 = getActivity();
            h.a((Object) activity2);
            Snackbar a2 = Snackbar.a(activity2.findViewById(16908290), R.string.log_send_no_app, 0);
            h.b(a2, "Snackbar.make(\n         …LENGTH_LONG\n            )");
            a2.e();
        }
    }

    /* access modifiers changed from: private */
    public final void a(String... strArr) {
        MenuItem menuItem = this.f28642a;
        if (menuItem != null && !menuItem.isChecked() && strArr.length == 1 && (!h.a((Object) strArr[0], (Object) ""))) {
            menuItem.setChecked(true);
        }
        c cVar = this.f28644d;
        if (cVar != null) {
            cVar.a((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    /* access modifiers changed from: private */
    public final void f() {
        Lifecycle lifecycle = getLifecycle();
        h.b(lifecycle, "lifecycle");
        bg unused = g.a(androidx.lifecycle.l.a(lifecycle), ap.b(), (CoroutineStart) null, new LogBaseFragment$showLogContent$1(this, (kotlin.coroutines.c) null), 2, (Object) null);
    }

    private final void g() {
        SearchView searchView = this.f28645e;
        SearchView.SearchAutoComplete searchAutoComplete = searchView != null ? (SearchView.SearchAutoComplete) searchView.findViewById(R.id.search_src_text) : null;
        if (searchAutoComplete != null) {
            searchAutoComplete.setText("");
        }
        SearchView searchView2 = this.f28645e;
        if (searchView2 != null) {
            searchView2.setIconified(true);
        }
    }

    public abstract ArrayList<String> a();

    /* access modifiers changed from: protected */
    public final void a(boolean z2) {
        this.f28650j = z2;
    }

    public abstract void b();

    public void c() {
        HashMap hashMap = this.f28651k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final c d() {
        return this.f28644d;
    }

    /* access modifiers changed from: protected */
    public final boolean e() {
        return this.f28650j;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        h.d(menu, "menu");
        h.d(menuInflater, "inflater");
        menuInflater.inflate(R.menu.menu_log, menu);
        this.f28642a = menu.findItem(R.id.menu_show_verbose);
        MenuItem findItem = menu.findItem(R.id.menu_search);
        Object systemService = requireContext().getSystemService("search");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.SearchManager");
        SearchManager searchManager = (SearchManager) systemService;
        if (findItem != null) {
            View actionView = findItem.getActionView();
            Objects.requireNonNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
            SearchView searchView = (SearchView) actionView;
            this.f28645e = searchView;
            if (searchView != null) {
                searchView.setQueryHint(this.f28649i);
            }
        }
        SearchView searchView2 = this.f28645e;
        if (searchView2 != null) {
            FragmentActivity requireActivity = requireActivity();
            h.b(requireActivity, "requireActivity()");
            searchView2.setSearchableInfo(searchManager.getSearchableInfo(requireActivity.getComponentName()));
        }
        SearchView searchView3 = this.f28645e;
        SearchView.SearchAutoComplete searchAutoComplete = searchView3 != null ? (SearchView.SearchAutoComplete) searchView3.findViewById(R.id.search_src_text) : null;
        if (!h.a((Object) this.f28646f, (Object) "")) {
            if (searchAutoComplete != null) {
                searchAutoComplete.setText(this.f28646f);
            }
            SearchView searchView4 = this.f28645e;
            if (searchView4 != null) {
                searchView4.setIconified(false);
            }
        } else {
            if (searchAutoComplete != null) {
                searchAutoComplete.setText("");
            }
            SearchView searchView5 = this.f28645e;
            if (searchView5 != null) {
                searchView5.setIconified(true);
            }
        }
        c cVar = new c(this);
        if (findItem != null) {
            findItem.setOnActionExpandListener(new C0189b(this));
        }
        SearchView searchView6 = this.f28645e;
        if (searchView6 != null) {
            FragmentActivity activity = getActivity();
            h.a((Object) activity);
            h.b(activity, "activity!!");
            searchView6.setSearchableInfo(searchManager.getSearchableInfo(activity.getComponentName()));
            searchView6.setIconifiedByDefault(true);
            searchView6.setOnQueryTextListener(cVar);
            if (!(!(!h.a((Object) this.f28646f, (Object) "")) || searchAutoComplete == null || findItem == null)) {
                findItem.expandActionView();
                searchAutoComplete.setText(this.f28646f);
            }
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.d(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_log, viewGroup, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        View findViewById = inflate.findViewById(R.id.log_recycler);
        h.b(findViewById, "view.findViewById(R.id.log_recycler)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f28643c = recyclerView;
        if (recyclerView == null) {
            h.b("logsRecycler");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        this.f28644d = new c(new ArrayList(), this.f28646f);
        RecyclerView recyclerView2 = this.f28643c;
        if (recyclerView2 == null) {
            h.b("logsRecycler");
        }
        recyclerView2.setAdapter(this.f28644d);
        a("");
        FragmentActivity activity = getActivity();
        h.a((Object) activity);
        h.b(activity, "activity!!");
        ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (bundle == null) {
            f();
        }
        setHasOptionsMenu(true);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f28648h = arguments.getString("targetFilename");
            this.f28649i = arguments.getString("search_hint");
            String string = arguments.getString("mail_logger");
            if (string != null) {
                h.b(string, "address");
                this.f28647g = string;
            }
        }
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        c cVar;
        h.d(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_share) {
            String str = this.f28648h;
            if (str == null || (cVar = this.f28644d) == null) {
                return true;
            }
            a(cVar.a(), str);
            return true;
        } else if (itemId == R.id.menu_clear) {
            b();
            f();
            return true;
        } else if (itemId == R.id.menu_show_verbose) {
            menuItem.setChecked(true);
            g();
            a("");
            return true;
        } else if (itemId == R.id.menu_show_debug) {
            menuItem.setChecked(true);
            g();
            a("A: ", "E: ", "W: ", "I: ", "D: ");
            return true;
        } else if (itemId == R.id.menu_show_info) {
            menuItem.setChecked(true);
            g();
            a("A: ", "E: ", "W: ", "I: ");
            return true;
        } else if (itemId == R.id.menu_show_warning) {
            menuItem.setChecked(true);
            g();
            a("A: ", "E: ", "W: ");
            return true;
        } else if (itemId != R.id.menu_show_error) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            menuItem.setChecked(true);
            g();
            a("A: ", "E: ");
            return true;
        }
    }
}
