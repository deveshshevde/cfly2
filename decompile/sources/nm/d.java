package nm;

import java.io.IOException;
import java.net.Socket;

public final class d {
    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
        }
    }
}
