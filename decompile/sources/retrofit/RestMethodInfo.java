package retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ok.b;
import retrofit.client.Header;

final class RestMethodInfo {
    private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
    private static final Pattern PARAM_NAME_REGEX = Pattern.compile(PARAM);
    private static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    String contentTypeHeader;
    List<Header> headers;
    final boolean isObservable;
    boolean isStreaming;
    final boolean isSynchronous;
    boolean loaded = false;
    final Method method;
    boolean requestHasBody;
    String requestMethod;
    Annotation[] requestParamAnnotations;
    String requestQuery;
    RequestType requestType = RequestType.SIMPLE;
    String requestUrl;
    Set<String> requestUrlParamNames;
    Type responseObjectType;
    final ResponseType responseType;

    enum RequestType {
        SIMPLE,
        MULTIPART,
        FORM_URL_ENCODED
    }

    private enum ResponseType {
        VOID,
        OBSERVABLE,
        OBJECT
    }

    private static final class RxSupport {
        private RxSupport() {
        }

        public static Type getObservableType(Type type, Class cls) {
            return Types.getSupertype(type, cls, b.class);
        }

        public static boolean isObservable(Class cls) {
            return cls == b.class;
        }
    }

    RestMethodInfo(Method method2) {
        boolean z2 = false;
        this.method = method2;
        ResponseType parseResponseType = parseResponseType();
        this.responseType = parseResponseType;
        this.isSynchronous = parseResponseType == ResponseType.OBJECT;
        this.isObservable = parseResponseType == ResponseType.OBSERVABLE ? true : z2;
    }

    private static Type getParameterUpperBound(ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
            Type type = actualTypeArguments[i2];
            if (type instanceof WildcardType) {
                actualTypeArguments[i2] = ((WildcardType) type).getUpperBounds()[0];
            }
        }
        return actualTypeArguments[0];
    }

    private RuntimeException methodError(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return new IllegalArgumentException(this.method.getDeclaringClass().getSimpleName() + "." + this.method.getName() + ": " + str);
    }

    private RuntimeException parameterError(int i2, String str, Object... objArr) {
        return methodError(str + " (parameter #" + (i2 + 1) + ")", objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.annotation.Annotation[]} */
    /* JADX WARNING: type inference failed for: r10v0, types: [java.lang.annotation.Annotation] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseMethodAnnotations() {
        /*
            r13 = this;
            java.lang.reflect.Method r0 = r13.method
            java.lang.annotation.Annotation[] r0 = r0.getAnnotations()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x0009:
            if (r3 >= r1) goto L_0x00e7
            r4 = r0[r3]
            java.lang.Class r5 = r4.annotationType()
            r6 = 0
            java.lang.annotation.Annotation[] r7 = r5.getAnnotations()
            int r8 = r7.length
            r9 = 0
        L_0x0018:
            if (r9 >= r8) goto L_0x002b
            r10 = r7[r9]
            java.lang.Class<retrofit.http.RestMethod> r11 = retrofit.http.RestMethod.class
            java.lang.Class r12 = r10.annotationType()
            if (r11 != r12) goto L_0x0028
            r6 = r10
            retrofit.http.RestMethod r6 = (retrofit.http.RestMethod) r6
            goto L_0x002b
        L_0x0028:
            int r9 = r9 + 1
            goto L_0x0018
        L_0x002b:
            r7 = 2
            r8 = 1
            if (r6 == 0) goto L_0x0074
            java.lang.String r9 = r13.requestMethod
            if (r9 != 0) goto L_0x0063
            java.lang.String r7 = "value"
            java.lang.Class[] r9 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0054 }
            java.lang.reflect.Method r7 = r5.getMethod(r7, r9)     // Catch:{ Exception -> 0x0054 }
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0054 }
            java.lang.Object r4 = r7.invoke(r4, r9)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0054 }
            r13.parsePath(r4)
            java.lang.String r4 = r6.value()
            r13.requestMethod = r4
            boolean r4 = r6.hasBody()
            r13.requestHasBody = r4
            goto L_0x00e3
        L_0x0054:
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r1 = r5.getSimpleName()
            r0[r2] = r1
            java.lang.String r1 = "Failed to extract String 'value' from @%s annotation."
            java.lang.RuntimeException r0 = r13.methodError(r1, r0)
            throw r0
        L_0x0063:
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r0[r2] = r9
            java.lang.String r1 = r6.value()
            r0[r8] = r1
            java.lang.String r1 = "Only one HTTP method is allowed. Found: %s and %s."
            java.lang.RuntimeException r0 = r13.methodError(r1, r0)
            throw r0
        L_0x0074:
            java.lang.Class<retrofit.http.Headers> r6 = retrofit.http.Headers.class
            if (r5 != r6) goto L_0x0091
            retrofit.http.Headers r4 = (retrofit.http.Headers) r4
            java.lang.String[] r4 = r4.value()
            int r5 = r4.length
            if (r5 == 0) goto L_0x0088
            java.util.List r4 = r13.parseHeaders(r4)
            r13.headers = r4
            goto L_0x00e3
        L_0x0088:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "@Headers annotation is empty."
            java.lang.RuntimeException r0 = r13.methodError(r1, r0)
            throw r0
        L_0x0091:
            java.lang.Class<retrofit.http.Multipart> r4 = retrofit.http.Multipart.class
            java.lang.String r6 = "Only one encoding annotation is allowed."
            if (r5 != r4) goto L_0x00a9
            retrofit.RestMethodInfo$RequestType r4 = r13.requestType
            retrofit.RestMethodInfo$RequestType r5 = retrofit.RestMethodInfo.RequestType.SIMPLE
            if (r4 != r5) goto L_0x00a2
            retrofit.RestMethodInfo$RequestType r4 = retrofit.RestMethodInfo.RequestType.MULTIPART
        L_0x009f:
            r13.requestType = r4
            goto L_0x00e3
        L_0x00a2:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.RuntimeException r0 = r13.methodError(r6, r0)
            throw r0
        L_0x00a9:
            java.lang.Class<retrofit.http.FormUrlEncoded> r4 = retrofit.http.FormUrlEncoded.class
            if (r5 != r4) goto L_0x00bd
            retrofit.RestMethodInfo$RequestType r4 = r13.requestType
            retrofit.RestMethodInfo$RequestType r5 = retrofit.RestMethodInfo.RequestType.SIMPLE
            if (r4 != r5) goto L_0x00b6
            retrofit.RestMethodInfo$RequestType r4 = retrofit.RestMethodInfo.RequestType.FORM_URL_ENCODED
            goto L_0x009f
        L_0x00b6:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.RuntimeException r0 = r13.methodError(r6, r0)
            throw r0
        L_0x00bd:
            java.lang.Class<retrofit.http.Streaming> r4 = retrofit.http.Streaming.class
            if (r5 != r4) goto L_0x00e3
            java.lang.reflect.Type r4 = r13.responseObjectType
            java.lang.Class<retrofit.client.Response> r5 = retrofit.client.Response.class
            if (r4 != r5) goto L_0x00ca
            r13.isStreaming = r8
            goto L_0x00e3
        L_0x00ca:
            java.lang.Object[] r0 = new java.lang.Object[r7]
            java.lang.Class<retrofit.client.Response> r1 = retrofit.client.Response.class
            java.lang.String r1 = r1.getSimpleName()
            r0[r2] = r1
            java.lang.Class<retrofit.http.Streaming> r1 = retrofit.http.Streaming.class
            java.lang.String r1 = r1.getSimpleName()
            r0[r8] = r1
            java.lang.String r1 = "Only methods having %s as data type are allowed to have @%s annotation."
            java.lang.RuntimeException r0 = r13.methodError(r1, r0)
            throw r0
        L_0x00e3:
            int r3 = r3 + 1
            goto L_0x0009
        L_0x00e7:
            java.lang.String r0 = r13.requestMethod
            if (r0 == 0) goto L_0x010f
            boolean r0 = r13.requestHasBody
            if (r0 != 0) goto L_0x010e
            retrofit.RestMethodInfo$RequestType r0 = r13.requestType
            retrofit.RestMethodInfo$RequestType r1 = retrofit.RestMethodInfo.RequestType.MULTIPART
            if (r0 == r1) goto L_0x0105
            retrofit.RestMethodInfo$RequestType r0 = r13.requestType
            retrofit.RestMethodInfo$RequestType r1 = retrofit.RestMethodInfo.RequestType.FORM_URL_ENCODED
            if (r0 == r1) goto L_0x00fc
            goto L_0x010e
        L_0x00fc:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST)."
            java.lang.RuntimeException r0 = r13.methodError(r1, r0)
            throw r0
        L_0x0105:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "Multipart can only be specified on HTTP methods with request body (e.g., @POST)."
            java.lang.RuntimeException r0 = r13.methodError(r1, r0)
            throw r0
        L_0x010e:
            return
        L_0x010f:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "HTTP method annotation is required (e.g., @GET, @POST, etc.)."
            java.lang.RuntimeException r0 = r13.methodError(r1, r0)
            goto L_0x0119
        L_0x0118:
            throw r0
        L_0x0119:
            goto L_0x0118
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit.RestMethodInfo.parseMethodAnnotations():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x0123 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseParameters() {
        /*
            r18 = this;
            r0 = r18
            java.lang.reflect.Method r1 = r0.method
            java.lang.Class[] r1 = r1.getParameterTypes()
            java.lang.reflect.Method r2 = r0.method
            java.lang.annotation.Annotation[][] r2 = r2.getParameterAnnotations()
            int r3 = r2.length
            boolean r4 = r0.isSynchronous
            if (r4 != 0) goto L_0x0019
            boolean r4 = r0.isObservable
            if (r4 != 0) goto L_0x0019
            int r3 = r3 + -1
        L_0x0019:
            java.lang.annotation.Annotation[] r4 = new java.lang.annotation.Annotation[r3]
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x001f:
            if (r6 >= r3) goto L_0x0172
            r10 = r1[r6]
            r11 = r2[r6]
            if (r11 == 0) goto L_0x015c
            int r12 = r11.length
            r13 = 0
        L_0x0029:
            if (r13 >= r12) goto L_0x015c
            r14 = r11[r13]
            java.lang.Class r15 = r14.annotationType()
            java.lang.Class<retrofit.http.Path> r5 = retrofit.http.Path.class
            r16 = 1
            if (r15 != r5) goto L_0x0042
            r5 = r14
            retrofit.http.Path r5 = (retrofit.http.Path) r5
            java.lang.String r5 = r5.value()
        L_0x003e:
            r0.validatePathName(r6, r5)
            goto L_0x008a
        L_0x0042:
            java.lang.Class<retrofit.http.EncodedPath> r5 = retrofit.http.EncodedPath.class
            if (r15 != r5) goto L_0x004e
            r5 = r14
            retrofit.http.EncodedPath r5 = (retrofit.http.EncodedPath) r5
            java.lang.String r5 = r5.value()
            goto L_0x003e
        L_0x004e:
            java.lang.Class<retrofit.http.Query> r5 = retrofit.http.Query.class
            if (r15 != r5) goto L_0x0053
            goto L_0x008a
        L_0x0053:
            java.lang.Class<retrofit.http.EncodedQuery> r5 = retrofit.http.EncodedQuery.class
            if (r15 != r5) goto L_0x0058
            goto L_0x008a
        L_0x0058:
            java.lang.Class<retrofit.http.QueryMap> r5 = retrofit.http.QueryMap.class
            if (r15 != r5) goto L_0x006f
            java.lang.Class<java.util.Map> r5 = java.util.Map.class
            boolean r5 = r5.isAssignableFrom(r10)
            if (r5 == 0) goto L_0x0065
            goto L_0x008a
        L_0x0065:
            r5 = 0
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "@QueryMap parameter type must be Map."
            java.lang.RuntimeException r1 = r0.parameterError(r6, r2, r1)
            throw r1
        L_0x006f:
            java.lang.Class<retrofit.http.EncodedQueryMap> r5 = retrofit.http.EncodedQueryMap.class
            if (r15 != r5) goto L_0x0086
            java.lang.Class<java.util.Map> r5 = java.util.Map.class
            boolean r5 = r5.isAssignableFrom(r10)
            if (r5 == 0) goto L_0x007c
            goto L_0x008a
        L_0x007c:
            r5 = 0
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "@EncodedQueryMap parameter type must be Map."
            java.lang.RuntimeException r1 = r0.parameterError(r6, r2, r1)
            throw r1
        L_0x0086:
            java.lang.Class<retrofit.http.Header> r5 = retrofit.http.Header.class
            if (r15 != r5) goto L_0x008e
        L_0x008a:
            r17 = r1
            goto L_0x011c
        L_0x008e:
            java.lang.Class<retrofit.http.Field> r5 = retrofit.http.Field.class
            if (r15 != r5) goto L_0x00a7
            retrofit.RestMethodInfo$RequestType r5 = r0.requestType
            retrofit.RestMethodInfo$RequestType r8 = retrofit.RestMethodInfo.RequestType.FORM_URL_ENCODED
            if (r5 != r8) goto L_0x009d
        L_0x0098:
            r17 = r1
            r8 = 1
            goto L_0x011c
        L_0x009d:
            r5 = 0
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "@Field parameters can only be used with form encoding."
            java.lang.RuntimeException r1 = r0.parameterError(r6, r2, r1)
            throw r1
        L_0x00a7:
            java.lang.Class<retrofit.http.FieldMap> r5 = retrofit.http.FieldMap.class
            if (r15 != r5) goto L_0x00ce
            retrofit.RestMethodInfo$RequestType r5 = r0.requestType
            retrofit.RestMethodInfo$RequestType r8 = retrofit.RestMethodInfo.RequestType.FORM_URL_ENCODED
            if (r5 != r8) goto L_0x00c4
            java.lang.Class<java.util.Map> r5 = java.util.Map.class
            boolean r5 = r5.isAssignableFrom(r10)
            if (r5 == 0) goto L_0x00ba
            goto L_0x0098
        L_0x00ba:
            r5 = 0
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "@FieldMap parameter type must be Map."
            java.lang.RuntimeException r1 = r0.parameterError(r6, r2, r1)
            throw r1
        L_0x00c4:
            r5 = 0
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "@FieldMap parameters can only be used with form encoding."
            java.lang.RuntimeException r1 = r0.parameterError(r6, r2, r1)
            throw r1
        L_0x00ce:
            java.lang.Class<retrofit.http.Part> r5 = retrofit.http.Part.class
            if (r15 != r5) goto L_0x00e6
            retrofit.RestMethodInfo$RequestType r5 = r0.requestType
            retrofit.RestMethodInfo$RequestType r9 = retrofit.RestMethodInfo.RequestType.MULTIPART
            if (r5 != r9) goto L_0x00dc
        L_0x00d8:
            r17 = r1
            r9 = 1
            goto L_0x011c
        L_0x00dc:
            r5 = 0
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "@Part parameters can only be used with multipart encoding."
            java.lang.RuntimeException r1 = r0.parameterError(r6, r2, r1)
            throw r1
        L_0x00e6:
            java.lang.Class<retrofit.http.PartMap> r5 = retrofit.http.PartMap.class
            if (r15 != r5) goto L_0x010d
            retrofit.RestMethodInfo$RequestType r5 = r0.requestType
            retrofit.RestMethodInfo$RequestType r9 = retrofit.RestMethodInfo.RequestType.MULTIPART
            if (r5 != r9) goto L_0x0103
            java.lang.Class<java.util.Map> r5 = java.util.Map.class
            boolean r5 = r5.isAssignableFrom(r10)
            if (r5 == 0) goto L_0x00f9
            goto L_0x00d8
        L_0x00f9:
            r5 = 0
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "@PartMap parameter type must be Map."
            java.lang.RuntimeException r1 = r0.parameterError(r6, r2, r1)
            throw r1
        L_0x0103:
            r5 = 0
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "@PartMap parameters can only be used with multipart encoding."
            java.lang.RuntimeException r1 = r0.parameterError(r6, r2, r1)
            throw r1
        L_0x010d:
            java.lang.Class<retrofit.http.Body> r5 = retrofit.http.Body.class
            if (r15 != r5) goto L_0x0154
            retrofit.RestMethodInfo$RequestType r5 = r0.requestType
            r17 = r1
            retrofit.RestMethodInfo$RequestType r1 = retrofit.RestMethodInfo.RequestType.SIMPLE
            if (r5 != r1) goto L_0x014a
            if (r7 != 0) goto L_0x0140
            r7 = 1
        L_0x011c:
            r1 = r4[r6]
            if (r1 != 0) goto L_0x0123
            r4[r6] = r14
            goto L_0x0156
        L_0x0123:
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = r4[r6]
            java.lang.Class r2 = r2.annotationType()
            java.lang.String r2 = r2.getSimpleName()
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = r15.getSimpleName()
            r1[r16] = r2
            java.lang.String r2 = "Multiple Retrofit annotations found, only one allowed: @%s, @%s."
            java.lang.RuntimeException r1 = r0.parameterError(r6, r2, r1)
            throw r1
        L_0x0140:
            r3 = 0
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = "Multiple @Body method annotations found."
            java.lang.RuntimeException r1 = r0.methodError(r2, r1)
            throw r1
        L_0x014a:
            r3 = 0
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = "@Body parameters cannot be used with form or multi-part encoding."
            java.lang.RuntimeException r1 = r0.parameterError(r6, r2, r1)
            throw r1
        L_0x0154:
            r17 = r1
        L_0x0156:
            int r13 = r13 + 1
            r1 = r17
            goto L_0x0029
        L_0x015c:
            r17 = r1
            r1 = r4[r6]
            if (r1 == 0) goto L_0x0168
            int r6 = r6 + 1
            r1 = r17
            goto L_0x001f
        L_0x0168:
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "No Retrofit annotation found."
            java.lang.RuntimeException r1 = r0.parameterError(r6, r2, r1)
            throw r1
        L_0x0172:
            r1 = 0
            retrofit.RestMethodInfo$RequestType r2 = r0.requestType
            retrofit.RestMethodInfo$RequestType r3 = retrofit.RestMethodInfo.RequestType.SIMPLE
            if (r2 != r3) goto L_0x0189
            boolean r2 = r0.requestHasBody
            if (r2 != 0) goto L_0x0189
            if (r7 != 0) goto L_0x0180
            goto L_0x0189
        L_0x0180:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Non-body HTTP method cannot contain @Body or @TypedOutput."
            java.lang.RuntimeException r1 = r0.methodError(r2, r1)
            throw r1
        L_0x0189:
            retrofit.RestMethodInfo$RequestType r2 = r0.requestType
            retrofit.RestMethodInfo$RequestType r3 = retrofit.RestMethodInfo.RequestType.FORM_URL_ENCODED
            if (r2 != r3) goto L_0x019b
            if (r8 == 0) goto L_0x0192
            goto L_0x019b
        L_0x0192:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Form-encoded method must contain at least one @Field."
            java.lang.RuntimeException r1 = r0.methodError(r2, r1)
            throw r1
        L_0x019b:
            retrofit.RestMethodInfo$RequestType r2 = r0.requestType
            retrofit.RestMethodInfo$RequestType r3 = retrofit.RestMethodInfo.RequestType.MULTIPART
            if (r2 != r3) goto L_0x01ad
            if (r9 == 0) goto L_0x01a4
            goto L_0x01ad
        L_0x01a4:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Multipart method must contain at least one @Part."
            java.lang.RuntimeException r1 = r0.methodError(r2, r1)
            throw r1
        L_0x01ad:
            r0.requestParamAnnotations = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit.RestMethodInfo.parseParameters():void");
    }

    private void parsePath(String str) {
        String str2;
        String str3;
        if (str == null || str.length() == 0 || str.charAt(0) != '/') {
            throw methodError("URL path \"%s\" must start with '/'.", str);
        }
        int indexOf = str.indexOf(63);
        if (indexOf == -1 || indexOf >= str.length() - 1) {
            str2 = null;
            str3 = str;
        } else {
            str3 = str.substring(0, indexOf);
            str2 = str.substring(indexOf + 1);
            if (PARAM_URL_REGEX.matcher(str2).find()) {
                throw methodError("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", str2);
            }
        }
        Set<String> parsePathParameters = parsePathParameters(str);
        this.requestUrl = str3;
        this.requestUrlParamNames = parsePathParameters;
        this.requestQuery = str2;
    }

    static Set<String> parsePathParameters(String str) {
        Matcher matcher = PARAM_URL_REGEX.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    private ResponseType parseResponseType() {
        Type type;
        Type genericReturnType = this.method.getGenericReturnType();
        Type[] genericParameterTypes = this.method.getGenericParameterTypes();
        Class cls = null;
        boolean z2 = true;
        if (genericParameterTypes.length > 0) {
            type = genericParameterTypes[genericParameterTypes.length - 1];
            Type rawType = type instanceof ParameterizedType ? ((ParameterizedType) type).getRawType() : type;
            if (rawType instanceof Class) {
                cls = (Class) rawType;
            }
        } else {
            type = null;
        }
        boolean z3 = genericReturnType != Void.TYPE;
        if (cls == null || !Callback.class.isAssignableFrom(cls)) {
            z2 = false;
        }
        if (z3 && z2) {
            throw methodError("Must have return type or Callback as last argument, not both.", new Object[0]);
        } else if (!z3 && !z2) {
            throw methodError("Must have either a return type or Callback as last argument.", new Object[0]);
        } else if (z3) {
            if (Platform.HAS_RX_JAVA) {
                Class<?> rawType2 = Types.getRawType(genericReturnType);
                if (RxSupport.isObservable(rawType2)) {
                    this.responseObjectType = getParameterUpperBound((ParameterizedType) RxSupport.getObservableType(genericReturnType, rawType2));
                    return ResponseType.OBSERVABLE;
                }
            }
            this.responseObjectType = genericReturnType;
            return ResponseType.OBJECT;
        } else {
            Type supertype = Types.getSupertype(type, Types.getRawType(type), Callback.class);
            if (supertype instanceof ParameterizedType) {
                this.responseObjectType = getParameterUpperBound((ParameterizedType) supertype);
                return ResponseType.VOID;
            }
            throw methodError("Last parameter must be of type Callback<X> or Callback<? super X>.", new Object[0]);
        }
    }

    private void validatePathName(int i2, String str) {
        if (!PARAM_NAME_REGEX.matcher(str).matches()) {
            throw parameterError(i2, "@Path parameter name must match %s. Found: %s", PARAM_URL_REGEX.pattern(), str);
        } else if (!this.requestUrlParamNames.contains(str)) {
            throw parameterError(i2, "URL \"%s\" does not contain \"{%s}\".", this.requestUrl, str);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void init() {
        if (!this.loaded) {
            parseMethodAnnotations();
            parseParameters();
            this.loaded = true;
        }
    }

    /* access modifiers changed from: package-private */
    public List<Header> parseHeaders(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                throw methodError("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
            }
            String substring = str.substring(0, indexOf);
            String trim = str.substring(indexOf + 1).trim();
            if ("Content-Type".equalsIgnoreCase(substring)) {
                this.contentTypeHeader = trim;
            } else {
                arrayList.add(new Header(substring, trim));
            }
        }
        return arrayList;
    }
}
