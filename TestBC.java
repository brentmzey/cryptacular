import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.BufferedBlockCipher;
public class TestBC {
    public static void main(String[] args) {
        CBCBlockCipher.newInstance(AESEngine.newInstance());
        BufferedBlockCipher.newInstance(AESEngine.newInstance());
    }
}
