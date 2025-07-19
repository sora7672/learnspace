# Einführung in das Datenformat JSON

## Inhaltsverzeichnis

- [Einblick in eine typische Softwarearchitektur](#einblick-in-eine-typische-softwarearchitektur)
- [Was überträgt ein Frontend?](#was-überträgt-ein-frontend)
- [Was ist überhaupt JSON?](#was-ist-überhaupt-json)
- [Anwendungsbereiche von JSON](#anwendungsbereiche-von-json)
- [Stolpersteine mit JSON oder in der Anwendung](#stolpersteine-mit-json-oder-in-der-anwendung)
- [Beispiel Usage von JSON in verschiedenen Sprachen](#beispiel-usage-von-json-in-verschiedenen-sprachen)
- [Nice to Know](#nice-to-know)


---

## Einblick in eine typische Softwarearchitektur

![JSON_between_frontend_backend.png](JSON_between_frontend_backend.png)

### Architekturüberblick

Diese Grafik zeigt dir eine typische Struktur moderner Webanwendungen: mehrere Schichten (Layers) übernehmen verschiedene Aufgaben, arbeiten zusammen – und sprechen meist über JSON miteinander.

Ziel: Du sollst nachvollziehen können, wie eine JSON-Nachricht vom Frontend losgeschickt wird, was unterwegs mit ihr passiert – und wie sie schließlich als Antwort zurückkommt.

### Die Komponenten im Überblick:

- **Frontend**  
  Du gibst etwas ein – das Frontend schickt daraus eine JSON-Anfrage an das Backend.

- **Java-Backend (Validierungsschicht)**
  - Empfängt die JSON-Daten.
  - Prüft und bereinigt sie (Sanitizing & Validierung).
  - Filtert so problematische Daten schon vor der Verarbeitung raus.

- **Python-Backend (Verarbeitungsschicht)**
  - Arbeitet nicht mit JSON, sondern mit **gRPC**, einem schnellen Binärprotokoll.
  - Führt die eigentliche Auswertung oder Analyse durch.

- **Der Rückweg**
  - Die Ergebnisse gehen per gRPC zurück an die Java-Schicht.
  - Diese verpackt das Ergebnis wieder als JSON und gibt es ans Frontend zurück.

### Warum ist das so aufgebaut?

- **Klare Aufgabentrennung**
- **Schnelle Kommunikation** (gRPC dort, wo’s zählt)
- **Wartbare Schnittstellen**, unter anderem für mehr Übersicht und weniger Fehler

[⬅](#inhaltsverzeichnis)

---

## Was überträgt ein Frontend?

Das Internet kann, wie alle digitalen Systeme, nur 1 und 0 übertragen.  
Diese Bits werden in der Übertragung typischerweise als Binär, Hexadezimal oder Dezimalwerte interpretiert  
und anschließend durch sogenannte Zeichencodierungen (*Charsets*) in lesbaren Text übersetzt.

Damit solche Datenströme zwischen Programmen und Systemen korrekt verarbeitet werden können,  
wurden **einheitliche Standards** definiert, auch für die Struktur von HTTP-Anfragen.

Im folgenden Beispiel siehst du, **was tatsächlich (in Textform) übertragen wird**, wenn ein Client eine Anfrage an eine Backend-API stellt.

Der obere Teil nennt sich `Header` und enthält Metainformationen zur Anfrage.  
Der untere Teil ist der sogenannte `Payload`, also die eigentlichen Daten, die übertragen werden.  
Dieser Teil folgt dem **JSON-Format**, das in modernen Webanwendungen sehr häufig verwendet wird.

> JSON ist das **Standardformat für Payloads** bei REST-APIs, aber nicht die einzige Möglichkeit.

```http
POST /api/validate HTTP/1.1
Host: example.com
Content-Type: application/json
Content-Length: 78
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64)
Accept: */*
Connection: keep-alive

{
  "username": "nobody123",
  "email": "mister@nobody.com",
  "age": 30,
  "preferences": {
    "newsletter": true,
    "language": "en"
  }
}
```

[⬅](#inhaltsverzeichnis)

---
## Was ist überhaupt JSON?

- **JSON** steht für **JavaScript Object Notation**
- Die Struktur erinnert an:
  - ein **Object** in JavaScript
  - ein **Dictionary** in Python
  - eine **Map** oder ein Objekt in Java
- JSON besteht aus **Key-Value-Paaren**
- Eingefasst wird es durch **geschweifte Klammern** `{}`
- Erlaubt sind nur **primitive Datentypen**: Strings, Zahlen, Booleans, Arrays, Objekte und `null`

---

### Datentypen in JSON

JSON unterstützt nur wenige, aber sehr universelle Datentypen. Diese lassen sich in fast jeder Programmiersprache wiederfinden.

#### Unterstützte Typen

- **null**  
  Kennzeichnet ein leeres Feld oder bewusst weggelassene Werte.  
  Entspricht in Python `None`, in Java `null`.  
  Wichtig: `null` ist kein String, sondern ein eigener Datentyp.

- **string**  
  Zeichenketten in doppelten Anführungszeichen `"`.  
  Beispiel: `"name": "Anna"`

- **number**  
  Zahlenwerte, entweder:
  - **Integer** (Ganzzahlen), z.B. `42`
  - **Float** (Dezimalzahlen), z.B. `3.14`

- **boolean**  
  Wahrheitswerte: `true` oder `false`  
  Entspricht in Python `True` und `False`, in Java `true` und `false`

- **array**  
  Eine Liste von Werten, eingeschlossen in `[]`  
  Entspricht in Python der `list`, in JavaScript dem `Array`  
  Beispiel: `"farben": ["rot", "blau", "grün"]`

- **object**  
  Ein verschachteltes JSON-Objekt mit eigenen Key-Value-Paaren  
  Entspricht in Python einem `dict`, in JavaScript einem `Object`  
  Beispiel:
  ```json
  "adress": {
    "town": "Berlin",
    "zipcode": 10115,
    "street": "Unter den Linden",
    "streetnumber": 3
  }
  ```

**Wichtig:**

- **Schlüssel (Keys) müssen immer Strings sein**  
  Es sind keine Zahlen, Booleans oder `null` als Schlüssel erlaubt

- **Werte (Values)** können alle gültigen JSON-Typen haben:
  - einfache Werte: `string`, `number`, `boolean`, `null`
  - Listen: `array`
  - verschachtelte Objekte: `object`

[⬅](#inhaltsverzeichnis)

---

## Anwendungsbereiche von JSON

### JSON im Datenaustausch

Der Haupteinsatzbereich von JSON liegt in der **Kommunikation mit externen Schnittstellen**.  
Hier hat sich JSON als **aktuell gängigster Standard** etabliert – insbesondere in sogenannten `JSON-Payloads`,  
die über HTTP an Backend-APIs übermittelt, dort eingelesen und weiterverarbeitet werden.

Ein älterer, heute noch vereinzelt genutzter Standard ist **XML**, wird aber zunehmend von JSON abgelöst.

- **Extern (Client ↔ Server)**:
  - JSON ist **textbasiert**, **leicht lesbar** und lässt sich einfach in fast jeder Sprache verarbeiten.
  - Ideal für Webbrowser, mobile Apps und öffentliche APIs.

- **Intern (Service ↔ Service)**:
  - Auch hier kann JSON genutzt werden, wird aber oft durch **gRPC** ersetzt.
  - gRPC ist ein **binäres Protokoll**, deutlich **performanter** und effizienter in der Verarbeitung.
  - Nachteil: **Nicht browserkompatibel**, daher nur für interne Kommunikation geeignet.

> **Hinweis:**  
> **gRPC** steht für **g**oogle **R**emote **P**rocedure **C**all.  
> Es ist ein plattformübergreifender Standard, entwickelt von **Google**,  
> speziell für die **schnelle und effiziente Verarbeitung großer Datenmengen**  
> in verteilten Systemen und Microservice-Architekturen.

### JSON als Datei

JSON-Daten können auch **in Dateien gespeichert** werden, mit der Endung `.json` (z.B. unter Windows oder Linux).  
Solche Dateien sind weit verbreitet im Bereich:

- **Konfigurationsdaten**
- **Einstellungen**
- **Zwischenspeicherung von Informationen**

**Vergleich:**

- JSON-Dateien erfüllen einen ähnlichen Zweck wie **XML** oder **YAML**.
- Vorteil von JSON: strukturierte, klar lesbare und flexibel erweiterbare Syntax mit vielen Möglichkeiten zur Parametrisierung.

### JSON in Datenbanken:

- In **NoSQL-Datenbanken** wie **MongoDB** werden häufig **Objektstrukturen** verwendet, die **nahezu identisch zu JSON** sind.
- Die Anzeige erfolgt dort teilweise anders, aber die zugrundeliegende Struktur und die unterstützten Datentypen entsprechen dem JSON-Standard.

[⬅](#inhaltsverzeichnis)

---

## Stolpersteine mit JSON oder in der Anwendung

### Andere valide JSON-Schreibweisen
> *Viele unterschätzen, wie flexibel JSON eigentlich ist. Hier siehst du ein paar typische – aber gültige – Varianten.*

- Leeres JSON
```json
{}
```

- CamelCase, snake_case, UPPERCASE, minus-seperated keys
```json
{
  "MyValue": 37,
  "another_value": 1,
  "MYCONSTANT": 12,
  "my-cool-key": 77
}
```

- Weird spacing
```json
    {
  "mykey": "myvalue",
                     "anotherkey": 23}   
```

```json
{
                    "myobject"         : 
    {"mykey":  "thats a value"}
}
```

- One-liner
```json
{ "age": 12, "name":  "john", "adress":  { "street":  "example street", "streetnumber":  "3b", "town": {"name":  "Hannover", "zip":  30151, "region": "Lower Saxony"}}}
```

---

### Nicht valides JSON
> *Diese Fehler passieren besonders oft bei Einsteigern.*  
> Deshalb hier ein paar typische Stolpersteine:

- **Trailing comma**
> *Ein Komma nach dem letzten Eintrag ist im JSON-Standard nicht erlaubt.*
```json
{
  "age": 24,
  "name": "Boris",
  
}
```

- **Broken brackets**
> *JSON-Objekte müssen immer korrekt geschlossen sein,sonst ist der gesamte Block ungültig.*
```json
{
  "cartype": "Audi",
  "buildyear": 1992,
  "factory_setting": {
    "engine": "abc123",
    "ac": true
}
```

- **Wrong true/false**
> *Nur `true`/`false` (kleingeschrieben) sind gültig. Kein `True`, kein `FALSE`.*
```json
{
  "course": "python advanced",
  "enough_pupil": True
}
```

- **Enclosed comma / colon**
> *Typischer Tippfehler: Komma oder Doppelpunkt im String.*
```json
{
  "course": "python advanced,"
  "trainer": "Hermann",
  "hours": 50
}
```

```json
{
  "course: python advanced",
  "trainer": "Hermann",
  "hours": 50
}
```


**Fazit:**
>  Bau dir keinen eigenen JSON-Parser, auch wenn’s verlockend klingt.  
> Für jede gängige Programmiersprache gibt es **erprobte Bibliotheken**, die dir viel Zeit, Nerven und Debugging ersparen.  
> *Natürlich kannst du dich selbst challengen, aber nicht zum Üben. Der Aufwand steht für Einsteiger oft in keinem Verhältnis.*

---

### Wichtiger Punkt: Keine Bytes in JSON

- JSON unterstützt **keine Byte-Werte**.
- Sprachen wie Python erlauben die direkte Arbeit mit `bytes`, **JSON aber nicht**.
- Wenn man z.B. **Binärdaten** oder spezielle Zeichensätze übermitteln muss, muss man:
  1. Die Bytes **vorher in Strings umwandeln** (z.B. mit Base64 oder UTF-8-Encoding).
  2. Diese Strings im JSON mit übertragen.
  3. Auf der Empfängerseite **zurück in Bytes konvertieren**.


### Kann JSON validieren?

JSON selbst prüft **nicht**, ob Werte im richtigen Format, Typ oder Gültigkeitsbereich sind.  
Deshalb ist es **zwingend erforderlich**, dass an der jeweiligen Schnittstelle validiert wird.

### Sanitization

Bereits an der sendenden Stelle (z.B. dem Frontend) sollte **nur das übertragen werden**,  
was auch tatsächlich vom Backend erwartet wird.

**Bloating** (also das unnötige Anreichern mit zusätzlichen Daten) kann zu Fehlern führen.  
Gerade ältere APIs erwarten bestimmte Schlüssel in einer festen Reihenfolge,  
zum Beispiel `"name"` an Position 1 und `"email"` an Position 2.

Außerdem kann es passieren, dass zusätzliche Felder vom Backend **einfach ignoriert oder entfernt** werden.  
Im schlimmsten Fall werden sie geloggt oder unerwünscht weiterverarbeitet.

Auf der empfangenden Seite sollte grundsätzlich eine **Sanitization** erfolgen  
aus Gründen der Sicherheit, des Datenschutzes und zur Fehlervermeidung.

> **Datenschutz:** Wenn z.B. alle eingehenden Daten testweise geloggt werden,  
> kann das bereits ein DSGVO-Verstoß sein – vor allem bei personenbezogenen Daten.

> **Security:** Wird in einem JSON z.B. kompletter SQL-Code mitgeschickt,  
> deutet das auf eine Sicherheitslücke im nachgelagerten System oder einen Angriffsversuch hin.

### Was sollte validiert und sanitized werden?

- **Datentypen pro Feld**  
  Beispiel: `"age"` muss eine Zahl sein, kein String
- **Pflichtfelder und optionale Felder**  
  Alles andere sollte konsequent entfernt werden
- **Längenbeschränkungen**  
  Beispiel: `"id"` darf maximal 8 Zeichen lang sein
- **Formatvorgaben**  
  Beispiel: `"email"` muss eine gültige E-Mail-Adresse enthalten
- **Wertelisten / Enums**  
  Beispiel: `"status"` darf nur `"open"`, `"closed"` oder `"pending"` sein

### Typische Validierungs- und Sanitization-Fehler

Ein häufiger Fehler ist die **ungefilterte Übernahme von Formulareingaben** aus dem Frontend.

Beispiel:
```json
{
  "age": "25"
}
```

Das Beispiel ist formal gültiges JSON, aber `"25"` ist ein **String**, kein Integer.  
In stark typisierten Sprachen wie Java kann das ohne Konvertierung zu **Laufzeitfehlern** führen.

Auch sprachübergreifende Abweichungen wie `TRUE`, `True` oder `"True"` anstelle des gültigen Werts `true`  
verursachen häufig Probleme – vor allem in APIs mit strenger Typprüfung.

Ein weiterer Klassiker: **falsche Schreibweise von Keys**  
Statt `"mykey": 1` wird z.B. `"MyKey": 1` oder `"Mykey": 1` übermittelt.

Daher ist es empfehlenswert, in der API einen **klaren Key-Standard** zu definieren (z.B. nur lowercase)  
und bei Verstößen **gezielt Fehlermeldungen** zurückzugeben.

[⬅](#inhaltsverzeichnis)

---

## Beispiel: JSON in verschiedenen Programmiersprachen

### Java

#### JSON-Datei lesen und schreiben

Java ist – wie gewohnt – sehr strikt: Ohne passende Imports und Bibliotheken geht nichts.  
Für JSON-Arbeit empfehlen wir z.B. das Paket `jackson-databind`, das du über Maven oder ein ähnliches Build-Tool einbinden kannst.

-> Hilfe zur Installation findest du in [de_java_maven_import.md](de_java_maven_import.md).

---

**Zuerst die nötigen Imports:**
```java
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
```


**Ein Objekt ist nötig, denn Java speichert JSON nicht „einfach so“:**
```java
class TestObject {

  public String name = "John";
  public Integer age = 27;

  @JsonIgnore
  public String password = "start123";
}
```

> Standardmäßig speichert Jackson alle `public` Attribute.  
> Mit `@JsonIgnore` kannst du gezielt verhindern, dass bestimmte Felder ins JSON übernommen werden.  
> Diese sogenannte **Annotation** erweitert das Verhalten des Codes – vergleichbar mit einem **Decorator** in Python.  
> Typischer Anwendungsfall: Passwörter oder interne Informationen sollen nicht gespeichert oder übertragen werden.


**Eine wiederverwendbare Klasse für JSON-Funktionen:**

```Java
class Tester{

  private static String jsonPath = "test.json";

  public static void writeJson(){
    ObjectMapper mapper = new ObjectMapper();
    TestObject myTest = new TestObject();

    try {
      mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonPath), myTest);
    } catch (IOException err) {
      System.out.println("Error while writing the Car object into a JSON file("+ jsonPath +"): " + err.getMessage());
    }
  }

  public static void readJson(){
    ObjectMapper mapper = new ObjectMapper();
    try {
      JsonNode root = mapper.readTree(new File(jsonPath));

      System.out.println(root.toPrettyString());

    } catch (IOException err) {
      System.out.println("Error while reading in the JSON file (" + jsonPath + "): " + err.getMessage());
      return;
    }

  }
}
```

**Und jetzt der finale Aufruf, also Startpunkt des Programs:**

```Java
public class Main {
    public static void main(String[] args) {
        Tester.writeJson();
        Tester.readJson();
    }
}

```

### Hinweise zu Formatierung und Verhalten

- Standardmäßig schreibt `jackson-databind` (Import groupId `com.fasterxml.jackson`) das JSON **einzeilig** in die Datei.
- Möchtest du eine besser lesbare Ausgabe, verwende:
  - beim Schreiben: `.writerWithDefaultPrettyPrinter()`
  - beim Lesen: `.toPrettyString()`
- Achtung: Beim Schreiben wird **immer die gesamte Datei überschrieben**, kein Anhängen möglich!

---

### Python

Hier siehst du das gleiche Beispiel in einer dynamisch typisierten Sprache.  
Im Gegensatz zu Java (statisch typisiert – also **Typprüfung beim Kompilieren**) erfolgt die Typprüfung in Python **zur Laufzeit**.

#### JSON-Datei lesen und schreiben


**Zuerst die nötigen Imports:**
```python
import json
from os import path
```


**Klasse mit Methoden zum Speichern und Laden von JSON:**
```python
class Tester:
    json_path: str = "../test.json"

    @staticmethod
    def save_json() -> None:
        data: dict = {
            "brand": "Toyota",
            "build_year": 2021,
            "electric": False
        }
        with open(Tester.json_path, 'w', encoding='utf-8') as json_file:
            json.dump(data, json_file, indent=4)
        print(f"JSON saved to {Tester.json_path}")

    @staticmethod
    def load_json() -> None:
        if not path.exists(Tester.json_path):
            print(f"JSON file does not exist: {Tester.json_path}")
            return

        with open(Tester.json_path, 'r', encoding='utf-8') as json_file:
            data = json.load(json_file)
        print("Loaded JSON content:")
        print(json.dumps(data, indent=4))
```


**Ausführen der Methoden:**
```python
if __name__ == '__main__':
    Tester.save_json()
    Tester.load_json()
```

### Hinweis

- Python verwendet **dynamische Typisierung** – du musst keine Datentypen vorab festlegen.
- Beim Speichern sorgt `json.dump(..., indent=4)` für ein formatiertes (Pretty) JSON.
- Beim Laden nutzt man `json.load(...)` und zur Anzeige ggf. `json.dumps(..., indent=4)`.
- Dateien werden beim Schreiben **überschrieben**, nicht ergänzt. Achte also auf die Struktur!


[⬅](#inhaltsverzeichnis)


---  

## Nice to Know

### Erweiterte JSON-basierte Formate & Dateitypen

In modernen Softwarearchitekturen gibt es verschiedene **Formate und Dateitypen**,  
die auf JSON aufbauen oder dessen Struktur erweitern. Zwei wichtige Vertreter sind:


### HOCON (Human-Optimized Config Object Notation)

- **Ziel**: Konfigurationsdateien für Menschen besser lesbar und wartbar machen.
- **Kompatibilität**: Vollständig JSON-kompatibel – jedes JSON ist auch valides HOCON.
- **Erweiterungen gegenüber JSON**:
  - Kommentare erlaubt (`//` und `#`)
  - Schlüssel müssen nicht in Anführungszeichen stehen
  - Fallbacks, Includes, Variablenreferenzierung

**Beispiel:**
```hocon
# Einfache Key Nutzung:
server {
  host = "localhost"
  port = 8080
  url = ${server.host}:${server.port}
}

# Komplexe Key Verschachtelung:
jobs {
  names {
    "de.assasin" = "Attentäter"
    "eng.assasin" = "Rogue"
  }
}

player {
  language = "de"
  job_key = "assasin"
  job = ${jobs.names."${player.language}.${player.job_key}"}
  
  # Bei job steht am ende der string "Attentäter", 
  # wenn man language zu eng ändert würde rouge raus kommen
}
```

**Besonderheit bei der Syntax:**
- Die Reader können sehr dynamische Syntax zuweisungen übersetzen
```hocon
key = value
key : value
"key" = value
key {value}

```

> Wichtig!   
> Man kann zwar **JSON direkt in HOCON einfügen**, aber man kann HOCON nicht direkt in JSON einfügen ohne Translator.

---

### BSON (Binary JSON)

- **Ziel**: Effiziente Speicherung und Verarbeitung von JSON-ähnlichen Daten in binärer Form.
- **Verwendung**: Vor allem in **MongoDB**, einer NoSQL-Datenbank.
- **Erweiterung**: Unterstützt zusätzliche Typen (z.B. `Date`, `ObjectId`, `Binary`)
- **Nicht direkt lesbar** – dafür schneller und kompakter.

**Vergleich:**

| JSON (einfach lesbar)     | BSON (binär, MongoDB-intern)         |
|----------------------------|--------------------------------------|
| `"name": "Anna"`           | `"name": String("Anna")`             |
| `"created": "2024-01-01"`  | `"created": Date(ISODate("2024-01-01"))` |

---
#### Hinweis

> Diese Formate sind **nicht direkt im JSON-Datenaustausch verwendbar**,  
> da sie z.B. **nicht zwischen Browser und Server** übertragen werden können.  
> Sie kommen stattdessen in speziellen Szenarien zum Einsatz:
> - **HOCON**: für interne Konfigurationsdateien
> - **BSON**: für die binäre Speicherung in MongoDB
> - **Weitere Formate** wie GeoJSON oder JSON-LD für spezialisierte Anwendungsfälle


#### Auszug aus meinem persönlichen Projekt:

Sogar Datenbanken wie MySQL oder SQLite können JSON speichern, denn am Ende ist JSON einfach nur ein String.  
Ich habe das genutzt, um komplexe Filter- oder Bedingungssets in JSON-Form zu speichern, schnell abrufbar zu machen und sogar exportieren zu können.

In Java ausgedrückt habe ich dafür eine Klasse `ConditionList` gebaut, die mehrere `Condition`-Objekte enthalten kann.  
Jede `Condition` besteht aus genau vier Attributen:
- `value_type`
- `comp_operator`
- `attribute_name`
- `attribute_value`

Eine `ConditionList` wiederum kann:
- mehrere `Condition`-Objekte enthalten
- oder sogar weitere `ConditionList`-Instanzen  
  Zusätzlich besitzt sie ein eigenes Attribut `operator`, also `"and"` oder `"or"`.

Wenn du Lust auf eine Herausforderung hast: Versuch das mal nachzubauen.  
Die eigentliche Komplexität liegt dabei **nicht im JSON selbst**, sondern darin, die verschachtelte Struktur **richtig zu speichern und wieder korrekt einzulesen**.


[⬅](#inhaltsverzeichnis)

---


