<div align="center">
  <h1>🛡️ Cryptacular</h1>
  <p><b>The spectacular complement to the Bouncy Castle crypto API for Java.</b></p>

  [![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.cryptacular/cryptacular/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/org.cryptacular/cryptacular)
  [![Java Support](https://img.shields.io/badge/Java-8%2B-blue.svg)](#)
  [![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](#)
</div>

<br/>

> **Cryptacular** serves as a modern, functional, and strictly-typed abstraction layer on top of BouncyCastle's core cryptographic engine.

---

## ✨ Features at a Glance

* 🔒 **Common Crypto Utilities** — Simplified hashing, encryption, and encoding.
* 🛡️ **Thread-Safe by Design** — Stateful, strictly immutable bean components.
* 📜 **Standards Compliant** — Facilitates strict adherence to modern cryptography standards.
* 🚀 **Functional Paradigms** — Heavily leans on Lombok, Optionals, and Builder patterns.

---

## ⚡ Quick Start & API Examples

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

Cryptacular aggressively leverages `java.util.Optional` for error handling and validation, keeping your data pipelines clean, declarative, and completely avoiding deep imperative `try/catch` blocks.

---

## 📚 Documentation & Agents

* **[Architecture Guidelines](./docs/ARCHITECTURE.md)**: Deep-dive into our immutability strategy.
* **[Agent Workflows](./AGENTS.md)**: Learn how AI agents collaboratively maintain this repository.
* **[Contributing](./CONTRIBUTING.md)**: Standard contributor guidelines.
