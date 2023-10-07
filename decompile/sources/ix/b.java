package ix;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import java.util.List;

public abstract class b extends Dialog {
    public b(Context context, int i2) {
        super(context, i2);
    }

    public abstract View a();

    public abstract View b();

    public abstract List<String> c();
}
