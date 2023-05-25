# Citation

Welcome to QuickCite! QuickCite is a citation generator for ISBN-10, ISBN-13, and DOI references.

To use, download the binary and run from the command-line with `java -jar citation-all.jar`.

## Libraries

This project uses the following libraries:
- [Gradle](https://gradle.org/) for building and package management
- [ShadowJar](https://github.com/johnrengelman/shadow) for packaging
- [Jackson](https://github.com/FasterXML/jackson) for processing JSON
- [JUnit](https://junit.org/junit5/) for testing

## APIs

This project integrates with the following APIs:
- [Google Books API](https://developers.google.com/books) for ISBN lookup
- [CrossRef Unified Resource API](https://api.crossref.org/swagger-ui/index.html) for DOI lookup

