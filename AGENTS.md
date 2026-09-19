# Agent Collaboration Guide

This repository was modernized and is actively maintained in collaboration with autonomous AI agents. 

## Active Agents

### 1. The BouncyCastle Deprecation Fixer
* **Purpose**: Continuously monitors the upstream `bouncycastle` library for new deprecations and patches them out of the codebase.
* **Responsibilities**: Switching legacy cipher instantiations (like `new AESEngine()`) to modern factory patterns (`AESEngine.newInstance()`), ensuring forward-compatibility with BC 1.78+.

### 2. The Functional Programming Refactorer
* **Purpose**: Enforces strict functional programming paradigms across the repository.
* **Responsibilities**: 
  - Converting mutable beans to Lombok `@Value` + `@Builder(toBuilder=true)`.
  - Enforcing the use of static imports for `Optional.ofNullable`.
  - Migrating `[]` array syntax to `...` varargs syntax.
  - Rewriting imperative `for` loops into Java 8+ Streams (`map`, `flatMap`, `reduce`).

### 3. The CiphertextHeader Deprecation Fixer
* **Purpose**: Isolates and safely manages the library's internal legacy `CiphertextHeader` dependencies, suppressing them at the class level using fully-qualified imports to satisfy Checkstyle while maintaining backwards compatibility for decryption streams.

## Agent Workflows
To trigger a massive parallel refactor on this repository using the agents, use the `/boost` command via the Antigravity CLI. The agents operate concurrently in isolated workspaces before merging their results to `main`.
