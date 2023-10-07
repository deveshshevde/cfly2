package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class MultiDexExtractor implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final File f3813a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3814b;

    /* renamed from: c  reason: collision with root package name */
    private final File f3815c;

    /* renamed from: d  reason: collision with root package name */
    private final RandomAccessFile f3816d;

    /* renamed from: e  reason: collision with root package name */
    private final FileChannel f3817e;

    /* renamed from: f  reason: collision with root package name */
    private final FileLock f3818f;

    private static class ExtractedDex extends File {

        /* renamed from: a  reason: collision with root package name */
        public long f3820a = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    MultiDexExtractor(File file, File file2) throws IOException {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f3813a = file;
        this.f3815c = file2;
        this.f3814b = b(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f3816d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f3817e = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f3818f = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e2) {
                e = e2;
                a((Closeable) this.f3817e);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                a((Closeable) this.f3817e);
                throw e;
            } catch (Error e4) {
                e = e4;
                a((Closeable) this.f3817e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            a((Closeable) this.f3816d);
            throw e5;
        }
    }

    private static long a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private List<ExtractedDex> a() throws IOException {
        ExtractedDex extractedDex;
        boolean z2;
        String str = this.f3813a.getName() + ".classes";
        b();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f3813a);
        try {
            ZipEntry entry = zipFile.getEntry("classes" + 2 + ".dex");
            int i2 = 2;
            while (entry != null) {
                extractedDex = new ExtractedDex(this.f3815c, str + i2 + ".zip");
                arrayList.add(extractedDex);
                Log.i("MultiDex", "Extraction is needed for file " + extractedDex);
                int i3 = 0;
                boolean z3 = false;
                while (i3 < 3 && !z3) {
                    int i4 = i3 + 1;
                    a(zipFile, entry, (File) extractedDex, str);
                    extractedDex.f3820a = b(extractedDex);
                    z2 = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z2 ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(extractedDex.getAbsolutePath());
                    sb.append("': length ");
                    int i5 = i4;
                    sb.append(extractedDex.length());
                    sb.append(" - crc: ");
                    sb.append(extractedDex.f3820a);
                    Log.i("MultiDex", sb.toString());
                    if (!z2) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                        }
                    }
                    z3 = z2;
                    i3 = i5;
                }
                if (z3) {
                    i2++;
                    entry = zipFile.getEntry("classes" + i2 + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i2 + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to close resource", e2);
            }
            return arrayList;
        } catch (IOException e3) {
            Log.w("MultiDex", "Failed to read crc from " + extractedDex.getAbsolutePath(), e3);
            z2 = false;
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                zipFile.close();
            } catch (IOException e4) {
                Log.w("MultiDex", "Failed to close resource", e4);
            }
            throw th2;
        }
    }

    private List<ExtractedDex> a(Context context, String str) throws IOException {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        String str3 = this.f3813a.getName() + ".classes";
        SharedPreferences a2 = a(context);
        int i2 = a2.getInt(str2 + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i2 + -1);
        int i3 = 2;
        while (i3 <= i2) {
            ExtractedDex extractedDex = new ExtractedDex(this.f3815c, str3 + i3 + ".zip");
            if (extractedDex.isFile()) {
                extractedDex.f3820a = b(extractedDex);
                long j2 = a2.getLong(str2 + "dex.crc." + i3, -1);
                long j3 = a2.getLong(str2 + "dex.time." + i3, -1);
                long lastModified = extractedDex.lastModified();
                if (j3 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = a2;
                    if (j2 == extractedDex.f3820a) {
                        arrayList.add(extractedDex);
                        i3++;
                        a2 = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str2 + "\"), expected modification time: " + j3 + ", modification time: " + lastModified + ", expected crc: " + j2 + ", file crc: " + extractedDex.f3820a);
            }
            throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
        }
        return arrayList;
    }

    private static void a(Context context, String str, long j2, long j3, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(str + "timestamp", j2);
        edit.putLong(str + "crc", j3);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i2 = 2;
        for (ExtractedDex next : list) {
            edit.putLong(str + "dex.crc." + i2, next.f3820a);
            edit.putLong(str + "dex.time." + i2, next.lastModified());
            i2++;
        }
        edit.commit();
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to close resource", e2);
        }
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    a((Closeable) inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            a((Closeable) inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static boolean a(Context context, File file, long j2, String str) {
        SharedPreferences a2 = a(context);
        if (a2.getLong(str + "timestamp", -1) == a(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("crc");
            return a2.getLong(sb.toString(), -1) != j2;
        }
    }

    private static long b(File file) throws IOException {
        long a2 = b.a(file);
        return a2 == -1 ? a2 - 1 : a2;
    }

    private void b() {
        File[] listFiles = this.f3815c.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f3815c.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            } else {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<? extends File> a(Context context, String str, boolean z2) throws IOException {
        List<ExtractedDex> list;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f3813a.getPath() + ", " + z2 + ", " + str + ")");
        if (this.f3818f.isValid()) {
            if (z2 || a(context, this.f3813a, this.f3814b, str)) {
                Log.i("MultiDex", z2 ? "Forced extraction must be performed." : "Detected that extraction must be performed.");
            } else {
                try {
                    list = a(context, str);
                } catch (IOException e2) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
                }
                Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                return list;
            }
            List<ExtractedDex> a2 = a();
            a(context, str, a(this.f3813a), this.f3814b, a2);
            list = a2;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public void close() throws IOException {
        this.f3818f.release();
        this.f3817e.close();
        this.f3816d.close();
    }
}
