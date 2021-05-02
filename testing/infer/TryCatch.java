import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TryCatch {

    private void writeFeatureVectors(OutputStream os) {
        try {
            os.write(255);
        } catch (IOException e) {
            System.out.println("IOException in method writeFeatureVectors: " + e.getMessage());

            System.out.println("IOException in method writeFeatureVectors: " + e);

            Logger.getLogger(TryCatch.class.getName()).log(Level.SEVERE, null, e);

            throw new RuntimeException("can't continue execution due to fatal error", e);
        }
    }
}
