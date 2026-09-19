import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
public class test {
    public static void main(String[] args) {
        AESEngine aes = AESEngine.newInstance();
        CBCBlockCipher cbc = CBCBlockCipher.newInstance(aes);
        CFBBlockCipher cfb = CFBBlockCipher.newInstance(aes, aes.getBlockSize());
        BufferedBlockCipher bbc = new BufferedBlockCipher();
    }
}
