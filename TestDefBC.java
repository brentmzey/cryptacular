import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
public class TestDefBC {
    public static void main(String[] args) {
        new DefaultBufferedBlockCipher(CBCBlockCipher.newInstance(AESEngine.newInstance()));
    }
}
