# Contributing to Cryptacular

We welcome contributions! To maintain the high quality and modern functional style of this codebase, please adhere to the following guidelines:

## Core Paradigms

1. **Strict Immutability**: All new Beans, DTOs, and configuration classes MUST be strictly immutable. We enforce this via Lombok's `@Value` annotation.
2. **Builders**: Use Lombok's `@Builder(toBuilder = true)` for complex object instantiation to provide a fluent, Kotlin/Scala-esque developer experience. Do not write manual setters.
3. **Optional over Null**: Do not return `null` from methods. Wrap potentially absent values in `Optional`. When dealing with nullable variables, ALWAYS use the statically imported `java.util.Optional.ofNullable`.
4. **Functional Purity**: Favor pure functions. Minimize side effects. Use Java 8+ Streams (`map`, `flatMap`, `filter`, `reduce`) over imperative loops whenever transforming collections.
5. **Varargs**: Always prefer Java `...` varargs syntax over explicit arrays `[]` in method signatures (e.g. `public void process(String... inputs)` rather than `String[] inputs`).

## Testing Requirements

We maintain a strict code coverage floor.
* **Test Coverage**: All new code MUST include comprehensive unit and integration tests. We require JaCoCo branch and line coverage to remain above 95%.
* **Dependencies**: We rely on BouncyCastle's modern `.newInstance(...)` factories instead of their deprecated constructors.

## Submitting a PR
1. Ensure `mvn clean install` passes locally.
2. Check your Checkstyle warnings via `mvn checkstyle:check`.
3. Submit your PR against the `main` branch.
