# Cryptacular [![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.cryptacular/cryptacular/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/org.cryptacular/cryptacular)

The spectacular complement to the Bouncy Castle crypto API for Java.

Cryptacular in a nutshell:

* Utilities to perform common crypto operations (hash, encrypt, encode).
* Stateful, thread-safe bean components.
* Components to facilitate strict adherence to standards.
* Comprehensive documentation and examples.

## Quick Start & API Examples

Cryptacular embraces modern, functional Java paradigms, including immutability (`@Value`), builder patterns (`@Builder`), and `Optional` data flows. 

### 1. Functional Key Factories

Using the modernized components, you can elegantly create keys from files, streams, or classpath resources using the immutable builder pattern:

```java
import org.cryptacular.bean.ResourceBasedPublicKeyFactoryBean;
import org.cryptacular.io.FileResource;
import java.io.File;

// Build the immutable factory
ResourceBasedPublicKeyFactoryBean factory = ResourceBasedPublicKeyFactoryBean.builder()
    .resource(new FileResource(new File("public.pem")))
    .build();

// Functional instantiation
PublicKey publicKey = factory.newInstance();
```

### 2. Immutability and State

All core beans are designed to be thread-safe and stateless where possible, or strictly immutable when holding configuration state (like `Resource` bindings). You can use Lombok's `.toBuilder()` to cleanly derive new instances without mutating the original:

```java
// Create a new factory pointing to a different resource using the copy-builder pattern
ResourceBasedPublicKeyFactoryBean prodFactory = factory.toBuilder()
    .resource(new FileResource(new File("prod_public.pem")))
    .build();
```

### 3. Null-Safety & Options

Cryptacular aggressively leverages `java.util.Optional` for error handling and validation, keeping your data pipelines clean, declarative, and avoiding deep imperative try/catch blocks.

