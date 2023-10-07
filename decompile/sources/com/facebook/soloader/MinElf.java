package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class MinElf {

    private static class ElfError extends RuntimeException {
        ElfError(String str) {
            super(str);
        }
    }

    private static String a(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j3 = 1 + j2;
            short e2 = e(fileChannel, byteBuffer, j2);
            if (e2 == 0) {
                return sb.toString();
            }
            sb.append((char) e2);
            j2 = j3;
        }
    }

    private static void a(FileChannel fileChannel, ByteBuffer byteBuffer, int i2, long j2) throws IOException {
        int read;
        byteBuffer.position(0);
        byteBuffer.limit(i2);
        while (byteBuffer.remaining() > 0 && (read = fileChannel.read(byteBuffer, j2)) != -1) {
            j2 += (long) read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new ElfError("ELF file truncated");
    }

    public static String[] a(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return a(fileInputStream.getChannel());
        } finally {
            fileInputStream.close();
        }
    }

    public static String[] a(FileChannel fileChannel) throws IOException {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        FileChannel fileChannel2 = fileChannel;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (c(fileChannel2, allocate, 0) == 1179403647) {
            boolean z2 = true;
            if (e(fileChannel2, allocate, 4) != 1) {
                z2 = false;
            }
            if (e(fileChannel2, allocate, 5) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            long c2 = z2 ? c(fileChannel2, allocate, 28) : b(fileChannel2, allocate, 32);
            long d2 = z2 ? (long) d(fileChannel2, allocate, 44) : (long) d(fileChannel2, allocate, 56);
            int d3 = d(fileChannel2, allocate, z2 ? 42 : 54);
            if (d2 == 65535) {
                long c3 = z2 ? c(fileChannel2, allocate, 32) : b(fileChannel2, allocate, 40);
                d2 = c(fileChannel2, allocate, z2 ? c3 + 28 : c3 + 44);
            }
            long j7 = c2;
            long j8 = 0;
            while (true) {
                if (j8 >= d2) {
                    j2 = 0;
                    break;
                } else if (c(fileChannel2, allocate, j7 + 0) == 2) {
                    j2 = z2 ? c(fileChannel2, allocate, j7 + 4) : b(fileChannel2, allocate, j7 + 8);
                } else {
                    j7 += (long) d3;
                    j8++;
                }
            }
            long j9 = 0;
            if (j2 != 0) {
                long j10 = j2;
                long j11 = 0;
                int i2 = 0;
                while (true) {
                    boolean z3 = z2;
                    long c4 = z2 ? c(fileChannel2, allocate, j10 + j9) : b(fileChannel2, allocate, j10 + j9);
                    if (c4 == 1) {
                        j3 = j2;
                        if (i2 != Integer.MAX_VALUE) {
                            i2++;
                        } else {
                            throw new ElfError("malformed DT_NEEDED section");
                        }
                    } else {
                        j3 = j2;
                        if (c4 == 5) {
                            j11 = z3 ? c(fileChannel2, allocate, j10 + 4) : b(fileChannel2, allocate, j10 + 8);
                        }
                    }
                    long j12 = 16;
                    j10 += z3 ? 8 : 16;
                    j9 = 0;
                    if (c4 != 0) {
                        z2 = z3;
                        j2 = j3;
                    } else if (j11 != 0) {
                        int i3 = 0;
                        while (true) {
                            if (((long) i3) >= d2) {
                                j4 = 0;
                                break;
                            }
                            if (c(fileChannel2, allocate, c2 + j9) == 1) {
                                long c5 = z3 ? c(fileChannel2, allocate, c2 + 8) : b(fileChannel2, allocate, c2 + j12);
                                if (z3) {
                                    j5 = d2;
                                    j6 = c(fileChannel2, allocate, c2 + 20);
                                } else {
                                    j5 = d2;
                                    j6 = b(fileChannel2, allocate, c2 + 40);
                                }
                                if (c5 <= j11 && j11 < j6 + c5) {
                                    j4 = (z3 ? c(fileChannel2, allocate, c2 + 4) : b(fileChannel2, allocate, c2 + 8)) + (j11 - c5);
                                }
                            } else {
                                j5 = d2;
                            }
                            c2 += (long) d3;
                            i3++;
                            d2 = j5;
                            j12 = 16;
                            j9 = 0;
                        }
                        long j13 = 0;
                        if (j4 != 0) {
                            String[] strArr = new String[i2];
                            int i4 = 0;
                            while (true) {
                                long j14 = j3 + j13;
                                long c6 = z3 ? c(fileChannel2, allocate, j14) : b(fileChannel2, allocate, j14);
                                if (c6 == 1) {
                                    strArr[i4] = a(fileChannel2, allocate, (z3 ? c(fileChannel2, allocate, j3 + 4) : b(fileChannel2, allocate, j3 + 8)) + j4);
                                    if (i4 != Integer.MAX_VALUE) {
                                        i4++;
                                    } else {
                                        throw new ElfError("malformed DT_NEEDED section");
                                    }
                                }
                                j3 += z3 ? 8 : 16;
                                if (c6 != 0) {
                                    j13 = 0;
                                } else if (i4 == i2) {
                                    return strArr;
                                } else {
                                    throw new ElfError("malformed DT_NEEDED section");
                                }
                            }
                        } else {
                            throw new ElfError("did not find file offset of DT_STRTAB table");
                        }
                    } else {
                        throw new ElfError("Dynamic section string-table not found");
                    }
                }
            } else {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
        } else {
            throw new ElfError("file is not ELF");
        }
    }

    private static long b(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        a(fileChannel, byteBuffer, 8, j2);
        return byteBuffer.getLong();
    }

    private static long c(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        a(fileChannel, byteBuffer, 4, j2);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    private static int d(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        a(fileChannel, byteBuffer, 2, j2);
        return byteBuffer.getShort() & 65535;
    }

    private static short e(FileChannel fileChannel, ByteBuffer byteBuffer, long j2) throws IOException {
        a(fileChannel, byteBuffer, 1, j2);
        return (short) (byteBuffer.get() & 255);
    }
}
