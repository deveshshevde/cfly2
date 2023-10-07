package ll;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

public abstract class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private List<DataSetObserver> f30929a;

    public View a(View view, ViewGroup viewGroup) {
        return null;
    }

    public void a(DataSetObserver dataSetObserver) {
        if (this.f30929a == null) {
            this.f30929a = new LinkedList();
        }
        this.f30929a.add(dataSetObserver);
    }

    public void b(DataSetObserver dataSetObserver) {
        List<DataSetObserver> list = this.f30929a;
        if (list != null) {
            list.remove(dataSetObserver);
        }
    }
}
