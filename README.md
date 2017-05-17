Proximity Places™
=================
GWT thick/fat client web application exposing a small set of 'gwit' cool features through the use of Google Places API.

Building, Running and Packaging
-------------------------------
This project has be created using **gwt-maven-plugin 2.8.1 archtype** and it is **primarily a [Maven](https://maven.apache.org/) project**. The `pom.xml` file covers the following aspects(for now):

1. **Profile management**: i.e. development, development-compile-report

2. **Dependencies**

3. **Java compilation**

4. **GWT setup, compilation, tuning**

5. **Shell scripts**: i.e. start-dev-env.sh, generate-dev-compile-report.sh


One-click development setup and run
-----------------------------------
Option 01: Run Eclipse maven run configuration `proximity-places-startDevEnv' and enjoy!

Option 02: Run shell script 'start-dev-env.sh' and enjoy!


Generate compile report in Development Mode
-------------------------------------------
Option 01: Run Eclipse maven run configuration 'proximity-places-generateDevCompileReport' and debug!

Option 02: Run shell script 'generate-dev-compile-report.sh' which after the run will also provide you with the means of auto-open the report in your browser.

To be extended....