package retrofit;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import retrofit.RequestInterceptor;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.converter.Converter;
import retrofit.http.Body;
import retrofit.http.EncodedPath;
import retrofit.http.EncodedQuery;
import retrofit.http.EncodedQueryMap;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import retrofit.mime.FormUrlEncodedTypedOutput;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedOutput;
import retrofit.mime.TypedString;

final class RequestBuilder implements RequestInterceptor.RequestFacade {
    private final String apiUrl;
    private TypedOutput body;
    private String contentTypeHeader;
    private final Converter converter;
    private final FormUrlEncodedTypedOutput formBody;
    private List<Header> headers;
    private final boolean isObservable;
    private final boolean isSynchronous;
    private final MultipartTypedOutput multipartBody;
    private final Annotation[] paramAnnotations;
    private StringBuilder queryParams;
    private String relativeUrl;
    private final String requestMethod;

    /* renamed from: retrofit.RequestBuilder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$retrofit$RestMethodInfo$RequestType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                retrofit.RestMethodInfo$RequestType[] r0 = retrofit.RestMethodInfo.RequestType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$retrofit$RestMethodInfo$RequestType = r0
                retrofit.RestMethodInfo$RequestType r1 = retrofit.RestMethodInfo.RequestType.FORM_URL_ENCODED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$retrofit$RestMethodInfo$RequestType     // Catch:{ NoSuchFieldError -> 0x001d }
                retrofit.RestMethodInfo$RequestType r1 = retrofit.RestMethodInfo.RequestType.MULTIPART     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$retrofit$RestMethodInfo$RequestType     // Catch:{ NoSuchFieldError -> 0x0028 }
                retrofit.RestMethodInfo$RequestType r1 = retrofit.RestMethodInfo.RequestType.SIMPLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit.RequestBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    private static class MimeOverridingTypedOutput implements TypedOutput {
        private final TypedOutput delegate;
        private final String mimeType;

        MimeOverridingTypedOutput(TypedOutput typedOutput, String str) {
            this.delegate = typedOutput;
            this.mimeType = str;
        }

        public String fileName() {
            return this.delegate.fileName();
        }

        public long length() {
            return this.delegate.length();
        }

        public String mimeType() {
            return this.mimeType;
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            this.delegate.writeTo(outputStream);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: retrofit.mime.FormUrlEncodedTypedOutput} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: retrofit.mime.MultipartTypedOutput} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: retrofit.mime.FormUrlEncodedTypedOutput} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: retrofit.mime.FormUrlEncodedTypedOutput} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    RequestBuilder(java.lang.String r2, retrofit.RestMethodInfo r3, retrofit.converter.Converter r4) {
        /*
            r1 = this;
            r1.<init>()
            r1.apiUrl = r2
            r1.converter = r4
            java.lang.annotation.Annotation[] r2 = r3.requestParamAnnotations
            r1.paramAnnotations = r2
            java.lang.String r2 = r3.requestMethod
            r1.requestMethod = r2
            boolean r2 = r3.isSynchronous
            r1.isSynchronous = r2
            boolean r2 = r3.isObservable
            r1.isObservable = r2
            java.util.List<retrofit.client.Header> r2 = r3.headers
            if (r2 == 0) goto L_0x0024
            java.util.ArrayList r2 = new java.util.ArrayList
            java.util.List<retrofit.client.Header> r4 = r3.headers
            r2.<init>(r4)
            r1.headers = r2
        L_0x0024:
            java.lang.String r2 = r3.contentTypeHeader
            r1.contentTypeHeader = r2
            java.lang.String r2 = r3.requestUrl
            r1.relativeUrl = r2
            java.lang.String r2 = r3.requestQuery
            if (r2 == 0) goto L_0x003f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r0 = 63
            r4.append(r0)
            r4.append(r2)
            r1.queryParams = r4
        L_0x003f:
            int[] r2 = retrofit.RequestBuilder.AnonymousClass1.$SwitchMap$retrofit$RestMethodInfo$RequestType
            retrofit.RestMethodInfo$RequestType r4 = r3.requestType
            int r4 = r4.ordinal()
            r2 = r2[r4]
            r4 = 1
            r0 = 0
            if (r2 == r4) goto L_0x007b
            r4 = 2
            if (r2 == r4) goto L_0x0071
            r4 = 3
            if (r2 != r4) goto L_0x0058
            r1.formBody = r0
            r1.multipartBody = r0
            goto L_0x0086
        L_0x0058:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Unknown request type: "
            r4.append(r0)
            retrofit.RestMethodInfo$RequestType r3 = r3.requestType
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.<init>(r3)
            throw r2
        L_0x0071:
            r1.formBody = r0
            retrofit.mime.MultipartTypedOutput r2 = new retrofit.mime.MultipartTypedOutput
            r2.<init>()
            r1.multipartBody = r2
            goto L_0x0084
        L_0x007b:
            retrofit.mime.FormUrlEncodedTypedOutput r2 = new retrofit.mime.FormUrlEncodedTypedOutput
            r2.<init>()
            r1.formBody = r2
            r1.multipartBody = r0
        L_0x0084:
            r1.body = r2
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit.RequestBuilder.<init>(java.lang.String, retrofit.RestMethodInfo, retrofit.converter.Converter):void");
    }

    private void addPathParam(String str, String str2, boolean z2) {
        String replace;
        if (str == null) {
            throw new IllegalArgumentException("Path replacement name must not be null.");
        } else if (str2 != null) {
            if (z2) {
                try {
                    String replace2 = URLEncoder.encode(String.valueOf(str2), "UTF-8").replace("+", "%20");
                    String str3 = this.relativeUrl;
                    replace = str3.replace("{" + str + "}", replace2);
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException("Unable to convert path parameter \"" + str + "\" value to UTF-8:" + str2, e2);
                }
            } else {
                String str4 = this.relativeUrl;
                replace = str4.replace("{" + str + "}", String.valueOf(str2));
            }
            this.relativeUrl = replace;
        } else {
            throw new IllegalArgumentException("Path replacement \"" + str + "\" value must not be null.");
        }
    }

    private void addQueryParam(String str, Object obj, boolean z2, boolean z3) {
        if (obj instanceof Iterable) {
            for (Object next : (Iterable) obj) {
                if (next != null) {
                    addQueryParam(str, next.toString(), z2, z3);
                }
            }
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj2 = Array.get(obj, i2);
                if (obj2 != null) {
                    addQueryParam(str, obj2.toString(), z2, z3);
                }
            }
        } else {
            addQueryParam(str, obj.toString(), z2, z3);
        }
    }

    private void addQueryParam(String str, String str2, boolean z2, boolean z3) {
        if (str == null) {
            throw new IllegalArgumentException("Query param name must not be null.");
        } else if (str2 != null) {
            try {
                StringBuilder sb = this.queryParams;
                if (sb == null) {
                    sb = new StringBuilder();
                    this.queryParams = sb;
                }
                sb.append(sb.length() > 0 ? '&' : '?');
                if (z2) {
                    str = URLEncoder.encode(str, "UTF-8");
                }
                if (z3) {
                    str2 = URLEncoder.encode(str2, "UTF-8");
                }
                sb.append(str);
                sb.append('=');
                sb.append(str2);
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("Unable to convert query parameter \"" + str + "\" value to UTF-8: " + str2, e2);
            }
        } else {
            throw new IllegalArgumentException("Query param \"" + str + "\" value must not be null.");
        }
    }

    private void addQueryParamMap(int i2, Map<?, ?> map, boolean z2, boolean z3) {
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            if (key != null) {
                Object value = next.getValue();
                if (value != null) {
                    addQueryParam(key.toString(), value.toString(), z2, z3);
                }
            } else {
                throw new IllegalArgumentException("Parameter #" + (i2 + 1) + " query map contained null key.");
            }
        }
    }

    public void addEncodedPathParam(String str, String str2) {
        addPathParam(str, str2, false);
    }

    public void addEncodedQueryParam(String str, String str2) {
        addQueryParam(str, str2, false, false);
    }

    public void addHeader(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Header name must not be null.");
        } else if ("Content-Type".equalsIgnoreCase(str)) {
            this.contentTypeHeader = str2;
        } else {
            List list = this.headers;
            if (list == null) {
                list = new ArrayList(2);
                this.headers = list;
            }
            list.add(new Header(str, str2));
        }
    }

    public void addPathParam(String str, String str2) {
        addPathParam(str, str2, true);
    }

    public void addQueryParam(String str, String str2) {
        addQueryParam(str, str2, false, true);
    }

    /* access modifiers changed from: package-private */
    public Request build() throws UnsupportedEncodingException {
        MultipartTypedOutput multipartTypedOutput = this.multipartBody;
        if (multipartTypedOutput == null || multipartTypedOutput.getPartCount() != 0) {
            String str = this.apiUrl;
            StringBuilder sb = new StringBuilder(str);
            if (str.endsWith("/")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(this.relativeUrl);
            StringBuilder sb2 = this.queryParams;
            if (sb2 != null) {
                sb.append(sb2);
            }
            TypedOutput typedOutput = this.body;
            List<Header> list = this.headers;
            String str2 = this.contentTypeHeader;
            if (str2 != null) {
                if (typedOutput != null) {
                    typedOutput = new MimeOverridingTypedOutput(typedOutput, str2);
                } else {
                    Header header = new Header("Content-Type", str2);
                    if (list == null) {
                        list = Collections.singletonList(header);
                    } else {
                        list.add(header);
                    }
                }
            }
            return new Request(this.requestMethod, sb.toString(), list, typedOutput);
        }
        throw new IllegalStateException("Multipart requests must contain at least one part.");
    }

    /* access modifiers changed from: package-private */
    public void setArguments(Object[] objArr) {
        MultipartTypedOutput multipartTypedOutput;
        TypedOutput body2;
        MultipartTypedOutput multipartTypedOutput2;
        TypedOutput body3;
        if (objArr != null) {
            int length = objArr.length;
            if (!this.isSynchronous && !this.isObservable) {
                length--;
            }
            for (int i2 = 0; i2 < length; i2++) {
                Map map = objArr[i2];
                Annotation annotation = this.paramAnnotations[i2];
                Class<? extends Annotation> annotationType = annotation.annotationType();
                if (annotationType == Path.class) {
                    Path path = (Path) annotation;
                    String value = path.value();
                    if (map != null) {
                        addPathParam(value, map.toString(), path.encode());
                    } else {
                        throw new IllegalArgumentException("Path parameter \"" + value + "\" value must not be null.");
                    }
                } else if (annotationType == EncodedPath.class) {
                    String value2 = ((EncodedPath) annotation).value();
                    if (map != null) {
                        addPathParam(value2, map.toString(), false);
                    } else {
                        throw new IllegalArgumentException("Path parameter \"" + value2 + "\" value must not be null.");
                    }
                } else if (annotationType == Query.class) {
                    if (map != null) {
                        Query query = (Query) annotation;
                        addQueryParam(query.value(), (Object) map, query.encodeName(), query.encodeValue());
                    }
                } else if (annotationType == EncodedQuery.class) {
                    if (map != null) {
                        addQueryParam(((EncodedQuery) annotation).value(), (Object) map, false, false);
                    }
                } else if (annotationType == QueryMap.class) {
                    if (map != null) {
                        QueryMap queryMap = (QueryMap) annotation;
                        addQueryParamMap(i2, map, queryMap.encodeNames(), queryMap.encodeValues());
                    }
                } else if (annotationType == EncodedQueryMap.class) {
                    if (map != null) {
                        addQueryParamMap(i2, map, false, false);
                    }
                } else if (annotationType == retrofit.http.Header.class) {
                    if (map != null) {
                        String value3 = ((retrofit.http.Header) annotation).value();
                        if (map instanceof Iterable) {
                            for (Object next : (Iterable) map) {
                                if (next != null) {
                                    addHeader(value3, next.toString());
                                }
                            }
                        } else if (map.getClass().isArray()) {
                            int length2 = Array.getLength(map);
                            for (int i3 = 0; i3 < length2; i3++) {
                                Object obj = Array.get(map, i3);
                                if (obj != null) {
                                    addHeader(value3, obj.toString());
                                }
                            }
                        } else {
                            addHeader(value3, map.toString());
                        }
                    }
                } else if (annotationType == Field.class) {
                    if (map != null) {
                        Field field = (Field) annotation;
                        String value4 = field.value();
                        boolean encodeName = field.encodeName();
                        boolean encodeValue = field.encodeValue();
                        if (map instanceof Iterable) {
                            for (Object next2 : (Iterable) map) {
                                if (next2 != null) {
                                    this.formBody.addField(value4, encodeName, next2.toString(), encodeValue);
                                }
                            }
                        } else if (map.getClass().isArray()) {
                            int length3 = Array.getLength(map);
                            for (int i4 = 0; i4 < length3; i4++) {
                                Object obj2 = Array.get(map, i4);
                                if (obj2 != null) {
                                    this.formBody.addField(value4, encodeName, obj2.toString(), encodeValue);
                                }
                            }
                        } else {
                            this.formBody.addField(value4, encodeName, map.toString(), encodeValue);
                        }
                    }
                } else if (annotationType == FieldMap.class) {
                    if (map != null) {
                        FieldMap fieldMap = (FieldMap) annotation;
                        boolean encodeNames = fieldMap.encodeNames();
                        boolean encodeValues = fieldMap.encodeValues();
                        for (Map.Entry entry : map.entrySet()) {
                            Object key = entry.getKey();
                            if (key != null) {
                                Object value5 = entry.getValue();
                                if (value5 != null) {
                                    this.formBody.addField(key.toString(), encodeNames, value5.toString(), encodeValues);
                                }
                            } else {
                                throw new IllegalArgumentException("Parameter #" + (i2 + 1) + " field map contained null key.");
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                } else if (annotationType == Part.class) {
                    if (map != null) {
                        Part part = (Part) annotation;
                        String value6 = part.value();
                        String encoding = part.encoding();
                        if (map instanceof TypedOutput) {
                            multipartTypedOutput2 = this.multipartBody;
                            body3 = (TypedOutput) map;
                        } else if (map instanceof String) {
                            this.multipartBody.addPart(value6, encoding, new TypedString((String) map));
                        } else {
                            multipartTypedOutput2 = this.multipartBody;
                            body3 = this.converter.toBody(map);
                        }
                        multipartTypedOutput2.addPart(value6, encoding, body3);
                    }
                } else if (annotationType == PartMap.class) {
                    if (map != null) {
                        String encoding2 = ((PartMap) annotation).encoding();
                        for (Map.Entry entry2 : map.entrySet()) {
                            Object key2 = entry2.getKey();
                            if (key2 != null) {
                                String obj3 = key2.toString();
                                Object value7 = entry2.getValue();
                                if (value7 != null) {
                                    if (value7 instanceof TypedOutput) {
                                        multipartTypedOutput = this.multipartBody;
                                        body2 = (TypedOutput) value7;
                                    } else if (value7 instanceof String) {
                                        this.multipartBody.addPart(obj3, encoding2, new TypedString((String) value7));
                                    } else {
                                        multipartTypedOutput = this.multipartBody;
                                        body2 = this.converter.toBody(value7);
                                    }
                                    multipartTypedOutput.addPart(obj3, encoding2, body2);
                                }
                            } else {
                                throw new IllegalArgumentException("Parameter #" + (i2 + 1) + " part map contained null key.");
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                } else if (annotationType != Body.class) {
                    throw new IllegalArgumentException("Unknown annotation: " + annotationType.getCanonicalName());
                } else if (map != null) {
                    this.body = map instanceof TypedOutput ? (TypedOutput) map : this.converter.toBody(map);
                } else {
                    throw new IllegalArgumentException("Body parameter value must not be null.");
                }
            }
        }
    }
}
