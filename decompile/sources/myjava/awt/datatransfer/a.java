package myjava.awt.datatransfer;

import java.io.IOException;

public interface a {
    Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException;
}
