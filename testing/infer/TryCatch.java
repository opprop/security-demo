import java.io.IOException;
import java.io.OutputStream;

public class TryCatch {
    void foo(OutputStream os) {
        try {
            os.write(255);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

