# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Added
- Functional programming paradigms heavily integrated across configuration beans.
- Detailed `Quick Start` functional API examples added to `README.md`.
- Implemented Lombok `@Value` and `@Builder(toBuilder=true)` patterns for immutable beans.

### Fixed
- SpotBugs failures relating to null-storage in explicitly non-null fields (`NP_STORE_INTO_NONNULL_FIELD`).
- Lingering Checkstyle formatting errors (curly braces, unused imports, trailing whitespace).
- Javadoc heading sequence warnings in `ResourceBasedPublicKeyFactoryBean`.
- Disabled `japicmp` checking to allow for expected breaking API changes during immutability refactoring.

### Changed
- Converted `ResourceBasedPublicKeyFactoryBean` to fully immutable builder-based structure.
- Modernized internal null-handling using `Optional.ofNullable`.

## [1.2.7] - 2026-09-19
### Changed
- Standard maintenance and dependency bumps.
- Introduced `AGENTS.md` and `ARCHITECTURE.md` to define new multi-agent collaboration workflows.
