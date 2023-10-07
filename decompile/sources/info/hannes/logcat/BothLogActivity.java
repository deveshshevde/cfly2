package info.hannes.logcat;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public final class BothLogActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_log);
        if (findViewById(R.id.fragment_container) != null && bundle == null) {
            getSupportFragmentManager().a().a(R.id.fragment_container, (Fragment) a.f28624a.a("logfile.log", "search logfile", "search logcat", "your@mail.com")).c();
        }
    }
}
