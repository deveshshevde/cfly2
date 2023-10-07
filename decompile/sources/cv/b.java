package cv;

import com.ctoo.mediaedit.R;
import com.ctoo.mediaedit.filter.a;

public class b extends d {
    public b() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", a.a(R.raw.crosszoom));
    }

    public b(String str, String str2) {
        super(str, str2);
    }
}
