package security;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import java.io.*;

public class QrCode {
	
	public QrCode() {
	}

    public ByteArrayOutputStream generate(String data){
        ByteArrayOutputStream bout =
                QRCode.from(data)
                        .withSize(250, 250)
                        .to(ImageType.PNG)
                        .stream();
        return bout;
        
    }
}