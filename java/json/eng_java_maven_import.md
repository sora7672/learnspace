# Java Maven Import – Setup Guide for `jackson-databind`

## 1. Create a Maven Project

If you haven't set up Maven yet but you're already inside your project, simply create a `pom.xml` file directly under your `<project name>` root folder.

## 2. Contents of the `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>
    
    <!-- Your project info -->
    <groupId>net.sora7672.java-examples</groupId>
    <artifactId>json-tester</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!-- Needed extra packages -->
    <dependencies>
        <!-- A single package -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.17.0</version>
        </dependency>
        <!-- End single package -->
    </dependencies>

</project>
```


## 3. Explanation of Important Fields

- `<modelVersion>`  
  The Maven model version. Currently: 4.0.0 (as of 08.07.2025)

- `<groupId>`  
  A unique identifier for your project. Best practice is to use the format: `<domain>.<your_name>.<your_identifier>`  
  Example: `net.sora7672.java-examples`

- `<artifactId>`  
  The name of your project. This will become part of your final `.jar` file name.

- `<version>`  
  The version of your project. Adding `-SNAPSHOT` indicates that this is a development version, not yet final.

- `<dependencies>`  
  A list of required packages. Each package is listed in its own `<dependency>` block.

**Note:**  
When Maven generates a `.jar` file, it's named as follows:  
`<artifactId>-<version>.jar`  
Example: `json-tester-1.0-SNAPSHOT.jar`

## 4. Enable Maven in IntelliJ

After creating or saving your `pom.xml`, a popup should appear in the lower right corner saying:  
**Import Maven Project**  
Click it.

Alternatively, a small icon might appear in the top right corner with an "M" and a refresh symbol:  
**Sync Maven Settings**  
Click it to manually trigger dependency synchronization.

IntelliJ will show error markers directly in the `pom.xml` if any dependencies are missing or if there's a syntax error.
