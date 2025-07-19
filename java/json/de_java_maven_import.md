# Java Maven Import – Setup Guide für `jackson-databind`

## 1. Maven-Projekt anlegen

Wenn ihr noch kein Maven eingerichtet habt, aber schon im Projekt seid, einfach direkt unter `<Projektname>` eine Datei `pom.xml` erstellen.

## 2. Inhalt der `pom.xml`

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

## 3. Erklärung wichtiger Felder

- `<modelVersion>`  
  Maven-Modellversion, derzeit aktuell: 4.0.0 (Stand: 08.07.2025)

- `<groupId>`  
  Eindeutiger Bezeichner für das Projekt. Am besten aufgebaut wie `<domain>.<your_name>.<your_identifier>`.  
  Beispiel: `net.sora7672.java-examples`

- `<artifactId>`  
  Projektname, wird Teil der finalen `.jar` Datei

- `<version>`  
  Version des Projekts. Mit `-SNAPSHOT` wird markiert, dass es sich noch nicht um eine finale Version handelt

- `<dependencies>`  
  Liste benötigter Pakete. Jedes Paket wird einzeln in einem `<dependency>` Block angegeben

Hinweis:  
Wenn Maven eine `.jar` Datei erzeugt, wird sie wie folgt benannt:  
`<artifactId>-<version>.jar`  
Beispiel: `json-tester-1.0-SNAPSHOT.jar`

## 4. Maven in IntelliJ aktivieren

Nach dem Erstellen oder Speichern der Datei sollte unten rechts unten ein Popup erscheinen mit dem Hinweis:  
**Als Maven-Projekt importieren**  
Einfach anklicken.

Optional kann oben rechts ein Symbol mit einem "M" und einem "Refresh" Symbol erscheinen  
**Sync Maven Settings**  
Damit kann man die Abhängigkeiten manuell synchronisieren.

IntelliJ zeigt durch Fehlermarkierungen in der `pom.xml`, ob z.B. eine Dependency nicht gefunden wurde oder ein Syntaxfehler vorliegt.
