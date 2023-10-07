package retrofit.client;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okio.d;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class OkClient implements Client {
    private final OkHttpClient client;

    public OkClient() {
        this(generateDefaultOkHttp());
    }

    public OkClient(OkHttpClient okHttpClient) {
        Objects.requireNonNull(okHttpClient, "client == null");
        this.client = okHttpClient;
    }

    private static List<Header> createHeaders(Headers headers) {
        int size = headers.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new Header(headers.name(i2), headers.value(i2)));
        }
        return arrayList;
    }

    static Request createRequest(Request request) {
        Request.Builder method = new Request.Builder().url(request.getUrl()).method(request.getMethod(), createRequestBody(request.getBody()));
        List<Header> headers = request.getHeaders();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            Header header = headers.get(i2);
            String value = header.getValue();
            if (value == null) {
                value = "";
            }
            method.addHeader(header.getName(), value);
        }
        return method.build();
    }

    private static RequestBody createRequestBody(final TypedOutput typedOutput) {
        if (typedOutput == null) {
            return null;
        }
        final MediaType parse = MediaType.parse(typedOutput.mimeType());
        return new RequestBody() {
            public long contentLength() {
                return typedOutput.length();
            }

            public MediaType contentType() {
                return parse;
            }

            public void writeTo(d dVar) throws IOException {
                typedOutput.writeTo(dVar.d());
            }
        };
    }

    private static TypedInput createResponseBody(final ResponseBody responseBody) {
        if (responseBody.contentLength() == 0) {
            return null;
        }
        return new TypedInput() {
            public InputStream in() throws IOException {
                return responseBody.byteStream();
            }

            public long length() {
                return responseBody.contentLength();
            }

            public String mimeType() {
                MediaType contentType = responseBody.contentType();
                if (contentType == null) {
                    return null;
                }
                return contentType.toString();
            }
        };
    }

    private static OkHttpClient generateDefaultOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(20000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    static Response parseResponse(Response response) {
        return new Response(response.request().urlString(), response.code(), response.message(), createHeaders(response.headers()), createResponseBody(response.body()));
    }

    public Response execute(Request request) throws IOException {
        return parseResponse(this.client.newCall(createRequest(request)).execute());
    }
}
