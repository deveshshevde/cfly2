package info.hannes.logcat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;
import kotlin.jvm.internal.h;

public final class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public static final C0187a f28624a = new C0187a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private String f28625b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f28626c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f28627d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f28628e = "";

    /* renamed from: f  reason: collision with root package name */
    private HashMap f28629f;

    /* renamed from: info.hannes.logcat.a$a  reason: collision with other inner class name */
    public static final class C0187a {
        private C0187a() {
        }

        public /* synthetic */ C0187a(f fVar) {
            this();
        }

        public final a a(String str, String str2, String str3, String str4) {
            h.d(str, "targetFileName");
            h.d(str2, "searchHintLogfile");
            h.d(str3, "searchHintLogcat");
            h.d(str4, "logMail");
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString("file name", str);
            bundle.putString("searchHintfile", str2);
            bundle.putString("searchHintlogcat", str3);
            bundle.putString("mail_logger", str4);
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    public void a() {
        HashMap hashMap = this.f28629f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.d(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_both_logs, (ViewGroup) null);
        TabHost tabHost = (TabHost) inflate.findViewById(16908306);
        tabHost.setup();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("file name", "");
            h.b(string, "it.getString(TARGET_FILE_NAME, \"\")");
            this.f28625b = string;
            String string2 = arguments.getString("searchHintlogcat", "");
            h.b(string2, "it.getString(SEARCH_HINT_LOGCAT, \"\")");
            this.f28626c = string2;
            String string3 = arguments.getString("searchHintfile", "");
            h.b(string3, "it.getString(SEARCH_HINT_LOGFILE, \"\")");
            this.f28627d = string3;
            String string4 = arguments.getString("mail_logger");
            if (string4 != null) {
                h.b(string4, "address");
                this.f28628e = string4;
            }
        }
        ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.pager);
        FragmentActivity requireActivity = requireActivity();
        h.b(requireActivity, "requireActivity()");
        h.b(tabHost, "mTabHost");
        h.b(viewPager, "mViewPager");
        d dVar = new d(requireActivity, tabHost, viewPager);
        b a2 = b.f28630a.a(this.f28625b, this.f28626c, this.f28628e);
        c a3 = c.f28659a.a(this.f28625b, this.f28627d, this.f28628e);
        TabHost.TabSpec indicator = tabHost.newTabSpec("nameC").setIndicator("Logcat");
        h.b(indicator, "mTabHost.newTabSpec(\"nam…\").setIndicator(\"Logcat\")");
        dVar.a(indicator, a2);
        TabHost.TabSpec indicator2 = tabHost.newTabSpec("nameF").setIndicator("Logfile");
        h.b(indicator2, "mTabHost.newTabSpec(\"nam…).setIndicator(\"Logfile\")");
        dVar.a(indicator2, a3);
        if (bundle != null) {
            try {
                tabHost.setCurrentTabByTag(bundle.getString("tab"));
            } catch (Exception unused) {
            }
        }
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }
}
