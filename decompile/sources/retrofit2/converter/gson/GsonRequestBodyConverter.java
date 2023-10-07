package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.aa;
import okhttp3.v;
import okio.c;
import retrofit2.Converter;

final class GsonRequestBodyConverter<T> implements Converter<T, aa> {
    private static final v MEDIA_TYPE = v.a("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    GsonRequestBodyConverter(Gson gson2, TypeAdapter<T> typeAdapter) {
        this.gson = gson2;
        this.adapter = typeAdapter;
    }

    public aa convert(T t2) throws IOException {
        c cVar = new c();
        JsonWriter newJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(cVar.d(), UTF_8));
        this.adapter.write(newJsonWriter, t2);
        newJsonWriter.close();
        return aa.create(MEDIA_TYPE, cVar.o());
    }
}
