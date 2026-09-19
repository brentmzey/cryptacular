# Cryptacular Architecture & Deep Dive

Cryptacular serves as a functional, strictly-typed abstraction layer on top of BouncyCastle's core cryptographic engine. This document details the specific architectural decisions made during its modernization.

## 1. Immutable Data Structures
Previously, Cryptacular relied on standard JavaBean patterns (mutable getters and setters). During our modernization phase, the entire configuration layer was migrated to **strict immutability**.
* By leveraging Lombok's `@Value` annotation, all fields are `private final` by default.
* State transitions or configuration changes are handled purely via the `@Builder(toBuilder = true)` pattern. This completely eliminates the entire class of concurrency and multi-threading bugs that arise when sharing Bean configurations across Spring Contexts.

## 2. Functional Paradigms
To reduce cognitive load and prevent `NullPointerException`s, we established strict functional rules:
* Arrays (`String[]`) are heavily discouraged in favor of `...` varargs, which provides better syntactic sugar when dynamically generating parameters.
* All loops over Collections are collapsed into Java Streams (`.stream().map().filter()`).
* **Optional**: The `java.util.Optional.ofNullable` method is statically imported into the classes. Values that may be absent are wrapped in `Optional` rather than returning `null` to the caller.

## 3. BouncyCastle Decoupling
BouncyCastle continuously deprecates internal engine constructors (like `new AESEngine()`). Our abstraction layer (`Spec` interfaces and Factories) absorbs this churn. We use `.newInstance(...)` dynamically to ensure that consuming applications never have to update their own code when BouncyCastle releases breaking changes to their cryptographic provider.

## 4. Test Driven Security
Coverage is king. We enforce JaCoCo test boundaries > 95%. Cryptography libraries cannot afford edge cases. Integration testing against live OpenSSL cipher streams and PBES2 data ensures that we maintain bit-for-bit accuracy against standard tooling.
