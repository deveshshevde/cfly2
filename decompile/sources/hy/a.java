package hy;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import hg.b;

public class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private b f13510a;

    /* renamed from: b  reason: collision with root package name */
    private hg.a f13511b;

    public void onActivityResult(int i2, int i3, Intent intent) {
        hg.a aVar;
        super.onActivityResult(i2, i3, intent);
        if (-1 == i3) {
            if (i2 != 68) {
                if (i2 == 85 && this.f13511b != null) {
                    this.f13511b.a((Photo) intent.getParcelableExtra("keyOfEasyPhotosResult"));
                }
            } else if (this.f13510a != null) {
                this.f13510a.a(intent.getParcelableArrayListExtra("keyOfEasyPhotosResult"), intent.getBooleanExtra("keyOfEasyPhotosResultSelectedOriginal", false));
            }
        } else if (i3 != 0) {
        } else {
            if (i2 == 68) {
                b bVar = this.f13510a;
                if (bVar != null) {
                    bVar.a();
                }
            } else if (i2 == 85 && (aVar = this.f13511b) != null) {
                aVar.a();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }
}
