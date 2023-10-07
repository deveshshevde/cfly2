package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.aa;
import okhttp3.ac;

public interface Converter<F, T> {

    public static abstract class Factory {
        protected static Type getParameterUpperBound(int i2, ParameterizedType parameterizedType) {
            return Utils.getParameterUpperBound(i2, parameterizedType);
        }

        protected static Class<?> getRawType(Type type) {
            return Utils.getRawType(type);
        }

        public Converter<?, aa> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit3) {
            return null;
        }

        public Converter<ac, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit3) {
            return null;
        }

        public Converter<?, String> stringConverter(Type type, Annotation[] annotationArr, Retrofit retrofit3) {
            return null;
        }
    }

    T convert(F f2) throws IOException;
}
