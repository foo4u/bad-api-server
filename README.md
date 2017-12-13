# Bad API Server

Just a simple web service for testing out downstreams handle a broken GZIP stream.

## Endpoints

Provides 2 endpoints:

* `/api/zip/bad` returns a truncated gzipped response
* `/api/zip/good` returns a complete gzipped response

## Running

Requires Java JDK 8+.

### From Source

Clone this repository and run:

    $ ./gradlew bootRun

### From Release

Downlaod the jar file from GitHub and run:

    $ java -jar bad-api-server-1.0-SNAPSHOT.jar
