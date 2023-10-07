package hr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.models.sticker.entity.TextStickerData;
import java.util.ArrayList;
import java.util.List;

public class h extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private List<TextStickerData> f13488a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f13489b;

    public interface a {
        void a(String str);
    }

    public static class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f13492a;

        public b(View view) {
            super(view);
            this.f13492a = (TextView) view.findViewById(R.id.puzzle);
        }
    }

    public h(Context context, a aVar) {
        this.f13489b = aVar;
        this.f13488a.add(0, new TextStickerData(context.getString(R.string.text_sticker_hint_name_easy_photos), context.getString(R.string.text_sticker_hint_easy_photos)));
        this.f13488a.add(new TextStickerData(context.getString(R.string.text_sticker_date_easy_photos), "-1"));
        this.f13488a.addAll(hn.a.f13368a);
    }

    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_text_sticker_easy_photos, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i2) {
        final TextStickerData textStickerData = this.f13488a.get(i2);
        bVar.f13492a.setText(textStickerData.f20466a);
        bVar.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (h.this.f13489b != null) {
                    h.this.f13489b.a(textStickerData.f20467b);
                    h.this.notifyDataSetChanged();
                }
            }
        });
    }

    public int getItemCount() {
        List<TextStickerData> list = this.f13488a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
