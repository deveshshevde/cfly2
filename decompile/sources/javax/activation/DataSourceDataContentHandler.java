package javax.activation;

import java.io.IOException;
import java.io.OutputStream;
import myjava.awt.datatransfer.DataFlavor;
import myjava.awt.datatransfer.UnsupportedFlavorException;

class DataSourceDataContentHandler implements DataContentHandler {
    private DataContentHandler dch = null;

    /* renamed from: ds  reason: collision with root package name */
    private DataSource f29471ds = null;
    private DataFlavor[] transferFlavors = null;

    public DataSourceDataContentHandler(DataContentHandler dataContentHandler, DataSource dataSource) {
        this.f29471ds = dataSource;
        this.dch = dataContentHandler;
    }

    public Object getContent(DataSource dataSource) throws IOException {
        DataContentHandler dataContentHandler = this.dch;
        return dataContentHandler != null ? dataContentHandler.getContent(dataSource) : dataSource.getInputStream();
    }

    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws UnsupportedFlavorException, IOException {
        DataContentHandler dataContentHandler = this.dch;
        if (dataContentHandler != null) {
            return dataContentHandler.getTransferData(dataFlavor, dataSource);
        }
        if (dataFlavor.equals(getTransferDataFlavors()[0])) {
            return dataSource.getInputStream();
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    public DataFlavor[] getTransferDataFlavors() {
        if (this.transferFlavors == null) {
            DataContentHandler dataContentHandler = this.dch;
            if (dataContentHandler != null) {
                this.transferFlavors = dataContentHandler.getTransferDataFlavors();
            } else {
                DataFlavor[] dataFlavorArr = new DataFlavor[1];
                this.transferFlavors = dataFlavorArr;
                dataFlavorArr[0] = new ActivationDataFlavor(this.f29471ds.getContentType(), this.f29471ds.getContentType());
            }
        }
        return this.transferFlavors;
    }

    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        DataContentHandler dataContentHandler = this.dch;
        if (dataContentHandler != null) {
            dataContentHandler.writeTo(obj, str, outputStream);
            return;
        }
        throw new UnsupportedDataTypeException("no DCH for content type " + this.f29471ds.getContentType());
    }
}
