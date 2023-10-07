package okhttp3.internal.http2;

public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    

    /* renamed from: l  reason: collision with root package name */
    public final int f32073l;

    private ErrorCode(int i2) {
        this.f32073l = i2;
    }

    public static ErrorCode a(int i2) {
        for (ErrorCode errorCode : values()) {
            if (errorCode.f32073l == i2) {
                return errorCode;
            }
        }
        return null;
    }
}
