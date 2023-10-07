package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ac;
import retrofit2.Converter;

final class OptionalConverterFactory extends Converter.Factory {
    static final Converter.Factory INSTANCE = new OptionalConverterFactory();

    static final class OptionalConverter<T> implements Converter<ac, Optional<T>> {
        final Converter<ac, T> delegate;

        OptionalConverter(Converter<ac, T> converter) {
            this.delegate = converter;
        }

        public Optional<T> convert(ac acVar) throws IOException {
            return Optional.ofNullable(this.delegate.convert(acVar));
        }
    }

    OptionalConverterFactory() {
    }

    public Converter<ac, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit3) {
        if (getRawType(type) != Optional.class) {
            return null;
        }
        return new OptionalConverter(retrofit3.responseBodyConverter(getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
