package af;

import ag.b;
import ag.e;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class c {
    public static int a(File file) throws IOException {
        FileChannel fileChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            fileChannel = new FileInputStream(file).getChannel();
            fileChannel.tryLock(60, 4, true);
            fileChannel.position(60);
            if (fileChannel.read(allocate) == 4) {
                allocate.rewind();
                return allocate.getInt();
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } finally {
            if (fileChannel != null) {
                fileChannel.close();
            }
        }
    }

    public static Cursor a(RoomDatabase roomDatabase, e eVar, boolean z2, CancellationSignal cancellationSignal) {
        Cursor a2 = roomDatabase.a(eVar, cancellationSignal);
        if (!z2 || !(a2 instanceof AbstractWindowedCursor)) {
            return a2;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) a2;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? b.a(abstractWindowedCursor) : a2;
    }

    /* JADX INFO: finally extract failed */
    public static void a(b bVar) {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor b2 = bVar.b("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (b2.moveToNext()) {
            try {
                arrayList.add(b2.getString(0));
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
        }
        b2.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.c("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }
}
