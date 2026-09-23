/* See LICENSE for licensing and NOTICE for copyright. */
package org.cryptacular.bean;

import static java.util.Optional.ofNullable;

import java.io.IOException;
import java.security.PublicKey;
import lombok.Builder;
import lombok.Value;
import org.cryptacular.EncodingException;
import org.cryptacular.StreamException;
import org.cryptacular.io.Resource;
import org.cryptacular.util.KeyPairUtil;

/**
 * Immutable factory for creating a {@link PublicKey} from a {@link Resource}.
 *
 * <p>This factory utilizes Lombok's {@code @Value} and {@code @Builder} to provide a strictly
 * immutable, functional approach to key generation. It leverages {@code Optional} to handle data
 * extraction gracefully without resorting to deep imperative blocks.
 *
 * <h2>Usage Example:</h2>
 *
 * <pre>{@code
 * ResourceBasedPublicKeyFactoryBean factory = ResourceBasedPublicKeyFactoryBean.builder()
 *     .resource(new ClasspathResource("keys/public-key.pem"))
 *     .build();
 *
 * PublicKey key = factory.newInstance();
 *
 * // Create a derived factory using the builder copy method
 * ResourceBasedPublicKeyFactoryBean derived = factory.toBuilder()
 *     .resource(new FileResource(new File("/opt/keys/override.pem")))
 *     .build();
 * }</pre>
 *
 * @author Middleware Services
 * @see KeyPairUtil#readPublicKey(java.io.InputStream)
 */
@Value
@Builder(toBuilder = true)
public class ResourceBasedPublicKeyFactoryBean implements FactoryBean<PublicKey> {

    /** Resource containing key data. */
    private Resource resource;

    /** Creates a new instance. */
    public ResourceBasedPublicKeyFactoryBean() {
        this.resource = null;
    }

    /**
     * Creates a new instance by specifying all properties.
     *
     * @param resource Resource containing encoded key data.
     */
    public ResourceBasedPublicKeyFactoryBean(final Resource resource) {
        this.resource = resource;
    }

    @Override
    public PublicKey newInstance() throws EncodingException, StreamException {
        return ofNullable(resource)
                .map(
                        res -> {
                            try {
                                return KeyPairUtil.readPublicKey(res.getInputStream());
                            } catch (IOException e) {
                                throw new StreamException(e);
                            }
                        })
                .orElseThrow(
                        () ->
                                new IllegalStateException(
                                        "Resource must be configured before calling"
                                                + " newInstance()"));
    }
}
