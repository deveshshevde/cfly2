package info.hannes.logcat;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import info.hannes.logcat.c;

public final class LogfileActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_log);
        if (findViewById(R.id.fragment_container) != null && bundle == null) {
            getSupportFragmentManager().a().a(R.id.fragment_container, (Fragment) c.a.a(c.f28659a, "logfile.log", "search logfile", (String) null, 4, (Object) null)).c();
        }
    }
}
