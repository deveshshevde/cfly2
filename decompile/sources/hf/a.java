package hf;

public class a {
    public static int a(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255);
    }
}
