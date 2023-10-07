package ir;

public class d implements l<Number> {
    public Float a(float f2, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f2 * (number2.floatValue() - floatValue)));
    }
}
