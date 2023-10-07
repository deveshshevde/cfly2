package ht;

public class a {
    public static int a(int i2) {
        return (((((i2 & 16711680) >> 16) * 38) + (((65280 & i2) >> 8) * 75)) + ((i2 & 255) * 15)) >> 7;
    }

    public static boolean b(int i2) {
        return a(i2) > 200;
    }
}
