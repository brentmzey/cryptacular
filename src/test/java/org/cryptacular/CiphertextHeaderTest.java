/* See LICENSE for licensing and NOTICE for copyright. */
package org.cryptacular;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import org.cryptacular.util.CodecUtil;
import org.testng.annotations.Test;

/**
 * Unit test for {@link org.cryptacular.CiphertextHeader}.
 *
 * @author Middleware Services
 */
@SuppressWarnings("deprecation")
public class CiphertextHeaderTest {

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Nonce exceeds size limit in bytes.*")
    public void testNonceLimitConstructor() {
        new org.cryptacular.CiphertextHeader(new byte[256], "key2");
    }

    @Test
    public void testEncodeDecodeSuccess() {
        final byte[] nonce = new byte[255];
        Arrays.fill(nonce, (byte) 7);
        final org.cryptacular.CiphertextHeader expected =
                new org.cryptacular.CiphertextHeader(nonce, "aleph");
        final byte[] encoded = expected.encode();
        assertEquals(expected.getLength(), encoded.length);
        final org.cryptacular.CiphertextHeader actual =
                org.cryptacular.CiphertextHeader.decode(encoded);
        assertEquals(expected.getNonce(), actual.getNonce());
        assertEquals(expected.getKeyName(), actual.getKeyName());
        assertEquals(expected.getLength(), actual.getLength());
    }

    @Test(
            expectedExceptions = EncodingException.class,
            expectedExceptionsMessageRegExp =
                    "Bad ciphertext header: maximum nonce length exceeded")
    public void testDecodeFailNonceLengthExceeded() {
        // https://github.com/vt-middleware/cryptacular/issues/52
        org.cryptacular.CiphertextHeader.decode(CodecUtil.hex("000000347ffffffd"));
    }

    @Test(
            expectedExceptions = EncodingException.class,
            expectedExceptionsMessageRegExp = "Bad ciphertext header: maximum key length exceeded")
    public void testDecodeFailKeyLengthExceeded() {
        org.cryptacular.CiphertextHeader.decode(CodecUtil.hex("000000F300000004DEADBEEF00FFFFFF"));
    }
}
