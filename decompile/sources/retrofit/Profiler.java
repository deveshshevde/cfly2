package retrofit;

public interface Profiler<T> {

    public static final class RequestInformation {
        private final String baseUrl;
        private final long contentLength;
        private final String contentType;
        private final String method;
        private final String relativePath;

        public RequestInformation(String str, String str2, String str3, long j2, String str4) {
            this.method = str;
            this.baseUrl = str2;
            this.relativePath = str3;
            this.contentLength = j2;
            this.contentType = str4;
        }

        public String getBaseUrl() {
            return this.baseUrl;
        }

        public long getContentLength() {
            return this.contentLength;
        }

        public String getContentType() {
            return this.contentType;
        }

        public String getMethod() {
            return this.method;
        }

        public String getRelativePath() {
            return this.relativePath;
        }
    }

    void afterCall(RequestInformation requestInformation, long j2, int i2, T t2);

    T beforeCall();
}
