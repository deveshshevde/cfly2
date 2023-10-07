package info.hannes.logcat;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import info.hannes.logcat.b;

public final class LogcatActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_log);
        if (findViewById(R.id.fragment_container) != null && bundle == null) {
            getSupportFragmentManager().a().a(R.id.fragment_container, (Fragment) b.a.a(b.f28630a, "logcat.log", "search logcat", (String) null, 4, (Object) null)).c();
        }
    }
}
