/* See LICENSE for licensing and NOTICE for copyright. */
package org.cryptacular.bean;

import java.io.IOException;
import java.security.PublicKey;
import lombok.Builder;
import lombok.Value;
import org.cryptacular.EncodingException;
import org.cryptacular.StreamException;
import org.cryptacular.io.Resource;
import org.cryptacular.util.KeyPairUtil;
import static java.util.Optional.ofNullable;

/**
 * Factory for creating a public key from a {@link Resource} containing data in any of the formats supported by {@link
 * KeyPairUtil#readPublicKey(java.io.InputStream)}.
 *
 * @author  Middleware Services
 * @see  KeyPairUtil#readPublicKey(java.io.InputStream)
 */
@Value
@Builder(toBuilder = true)
public class ResourceBasedPublicKeyFactoryBean implements FactoryBean<PublicKey>
{

  /** Resource containing key data. */
  private Resource resource;

  /** Creates a new instance. */
  public ResourceBasedPublicKeyFactoryBean()
  {
    this.resource = null;
  }

  /**
   * Creates a new instance by specifying all properties.
   *
   * @param  resource  Resource containing encoded key data.
   */
  public ResourceBasedPublicKeyFactoryBean(final Resource resource)
  {
    this.resource = resource;
  }

  @Override
  public PublicKey newInstance() throws EncodingException, StreamException
  {
    return ofNullable(resource)
      .map(res -> {
        try {
          return KeyPairUtil.readPublicKey(res.getInputStream());
        } catch (IOException e) {
          throw new StreamException(e);
        }
      })
      .orElseThrow(() -> new IllegalStateException("Resource must be configured before calling newInstance()"));
  }
}
