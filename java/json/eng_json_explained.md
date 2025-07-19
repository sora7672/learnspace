# Introduction to the JSON Data Format

## Table of Contents

- [A Look into a Typical Software Architecture](#a-look-into-a-typical-software-architecture)
- [What Does a Frontend Transmit?](#what-does-a-frontend-transmit)
- [What Exactly Is JSON?](#what-exactly-is-json)
- [Use Cases for JSON](#use-cases-for-json)
- [Pitfalls with JSON or in Its Application](#pitfalls-with-json-or-its-usage)
- [Example Usage of JSON in Different Programming Languages](#example-json-in-different-programming-languages)
- [Nice to Know](#nice-to-know)

---

## A Look into a Typical Software Architecture

![JSON_between_frontend_backend.png](JSON_between_frontend_backend.png)

### Architecture Overview

This graphic shows a typical structure of modern web applications: multiple layers handle different tasks, work together – and usually communicate via JSON.

**Goal:** You'll understand how a JSON message is sent from the frontend, what happens to it along the way – and how it eventually returns as a response.

### The Components at a Glance:

- **Frontend**  
  You enter data – the frontend turns it into a JSON request and sends it to the backend.

- **Java Backend (Validation Layer)**
    - Receives the JSON data.
    - Validates and sanitizes it.
    - Filters out problematic inputs before further processing.

- **Python Backend (Processing Layer)**
    - Works with **gRPC**, a fast binary protocol instead of JSON.
    - Performs evaluation and analysis.

- **The Return Path**
    - Results are returned via gRPC to the Java layer.
    - The Java layer wraps the result back into JSON and sends it to the frontend.

### Why This Structure?

- **Clear separation of responsibilities**
- **Fast communication** (gRPC where performance matters)
- **Maintainable interfaces**, which improve clarity and reduce errors

[⬅](#table-of-contents)

---

## What Does a Frontend Transmit?

The internet, like all digital systems, can only transmit 1s and 0s.  
These bits are typically interpreted as binary, hexadecimal, or decimal values during transmission  
and then translated into readable text using character encodings (*charsets*).

To ensure such data streams are processed correctly between programs and systems,  
**standardized formats** were introduced – including for the structure of HTTP requests.

In the following example, you’ll see **what is actually transmitted (in plain text)** when a client sends a request to a backend API.

The top part is the `Header` containing metadata about the request.  
The lower part is the `Payload`, the actual data being transmitted.  
This part follows the **JSON format**, which is widely used in modern web applications.

> JSON is the **standard format for payloads** in REST APIs – but it's not the only option.


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

[⬅](#table-of-contents)

---

## What Exactly Is JSON?

- **JSON** stands for **JavaScript Object Notation**
- Its structure resembles:
    - an **Object** in JavaScript
    - a **Dictionary** in Python
    - a **Map** or object in Java
- JSON consists of **key-value pairs**
- Enclosed by **curly braces** `{}`
- Only **primitive data types** are allowed: strings, numbers, booleans, arrays, objects, and `null`

---

### Data Types in JSON

JSON supports only a few but highly universal data types. These can be found in almost every programming language.

#### Supported Types

- **null**  
  Represents an empty or intentionally omitted value.  
  Equivalent to `None` in Python and `null` in Java.  
  Important: `null` is **not** a string, but its own data type.

- **string**  
  Text enclosed in double quotes `"`.  
  Example: `"name": "Anna"`

- **number**  
  Numeric values, either:
    - **Integer**, e.g. `42`
    - **Float**, e.g. `3.14`

- **boolean**  
  Logical values: `true` or `false`  
  Equivalent to `True` and `False` in Python, `true` and `false` in Java

- **array**  
  A list of values, enclosed in `[]`  
  Equivalent to a `list` in Python, an `Array` in JavaScript  
  Example: `"colors": ["red", "blue", "green"]`

- **object**  
  A nested JSON object with its own key-value pairs  
  Equivalent to a `dict` in Python or an `Object` in JavaScript  
  Example:
  ```json
  "address": {
    "town": "Berlin",
    "zipcode": 10115,
    "street": "Unter den Linden",
    "streetnumber": 3
  }
  ```

**Important:**

- **Keys must always be strings**  
  Numbers, booleans, or `null` are not allowed as keys.

- **Values** can be any valid JSON type:
  - simple values: `string`, `number`, `boolean`, `null`
  - lists: `array`
  - nested structures: `object`

[⬅](#table-of-contents)

---

## Use Cases for JSON

### JSON in Data Exchange

The primary use case for JSON is **communication with external interfaces**.  
JSON has become the **most widely adopted standard** – especially in so-called `JSON payloads`,  
which are transmitted over HTTP to backend APIs, parsed, and processed there.

An older standard that is still occasionally used is **XML**, but JSON is increasingly taking its place.

- **External (Client ↔ Server):**
  - JSON is **text-based**, **human-readable**, and easy to process in nearly every language.
  - Ideal for web browsers, mobile apps, and public APIs.

- **Internal (Service ↔ Service):**
  - JSON is still used but often replaced by **gRPC**.
  - gRPC is a **binary protocol**, much **faster** and more efficient in processing.
  - Downside: **Not browser-compatible**, so it’s used only for internal communication.

> **Note:**  
> **gRPC** stands for **g**oogle **R**emote **P**rocedure **C**all.  
> It’s a cross-platform standard developed by **Google**,  
> designed for **fast and efficient handling of large data volumes**  
> in distributed systems and microservice architectures.

### JSON as a File

JSON data can also be **stored in files**, typically with the `.json` extension (e.g. on Windows or Linux).  
Such files are widely used for:

- **Configuration data**
- **Application settings**
- **Temporary information storage**

**Comparison:**

- JSON files serve a similar role as **XML** or **YAML**.
- JSON’s advantage: structured, readable, and easily extensible syntax with strong parameterization support.

### JSON in Databases

- In **NoSQL databases** like **MongoDB**, data is stored in **object structures** that are **very similar to JSON**.
- The visual display may differ slightly, but the underlying structure and supported data types match the JSON standard.

[⬅](#table-of-contents)

---

## Pitfalls with JSON or Its Usage

### Alternative Valid JSON Syntax
> *Many people underestimate how flexible JSON actually is. Here are a few common but still valid formatting variants.*


- Empty JSON
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

### Non-valid JSON
> *These errors are especially common for beginners.*
> Here are a few typical pitfalls:

- **Trailing comma**
> *A comma after the last entry is not allowed in the JSON standard.*
```json
{
  "age": 24,
  "name": "Boris",
  
}
```

- **Broken brackets**
> *JSON objects must always be properly closed, otherwise the whole block is invalid.*
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
> *Only `true`/`false` (lowercase) are valid. Not `True` and also not `FALSE`.*
```json
{
  "course": "python advanced",
  "enough_pupil": True
}
```

- **Enclosed comma / colon**
> *Typical typo: comma or colon accidentally included in the string.*
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

**Conclusion:**
> Don’t build your own JSON parser, even if it sounds tempting.  
> Every major programming language already has **battle-tested libraries** that save you time, nerves, and endless debugging.  
> *Sure, you can challenge yourself, but not just for practice. For beginners, the effort usually isn’t worth it.*

---

### Important Note: No Bytes in JSON

- JSON does **not support byte values**.
- While languages like Python can work directly with `bytes`, **JSON cannot**.
- If you need to send **binary data** or special character sets, you must:
    1. **Convert the bytes into strings** beforehand (e.g., using Base64 or UTF-8 encoding).
    2. Include those strings in your JSON.
    3. On the receiving side, **convert them back into bytes**.

### Can JSON validate anything?

JSON itself does **not check** if values are in the correct format, type, or valid range.  
That’s why you **must implement validation** at each interface.

### Sanitization

Ideally, even the sending side (like a frontend) should **only transmit**  
what the backend actually expects.

**Bloating** (adding unnecessary extra data) can cause issues.  
Some older APIs expect certain keys in a fixed order,  
like `"name"` as the first field and `"email"` as the second.

Extra fields might be **ignored, deleted**, or in the worst case,  
**logged or mistakenly processed** by the backend.

The receiving side should always include **sanitization**  
for security, privacy, and error prevention.

> **Privacy risk:** If all incoming data is logged for testing purposes,  
> it can be a GDPR violation, especially with personal data.

> **Security risk:** If full SQL commands are sent inside a JSON field,  
> that could signal a vulnerability in the backend or even a direct attack attempt.

### What should be validated and sanitized?

- **Data types per field**  
  Example: `"age"` must be a number, not a string
- **Required and optional fields**  
  Anything else should be removed
- **Length restrictions**  
  Example: `"id"` should be max 8 characters
- **Format rules**  
  Example: `"email"` must be a valid email address
- **Allowed values / enums**  
  Example: `"status"` must be one of `"open"`, `"closed"`, or `"pending"`

### Common Validation and Sanitization Mistakes

A typical issue is directly **passing through unfiltered user input**  
from a frontend form to the backend.


Example:
```json
{
  "age": "25"
}
```

This example is technically valid JSON, but `"25"` is a **string**, not an integer.  
In strongly typed languages like Java, this can lead to **runtime errors** if not properly converted.

Cross-language inconsistencies like `TRUE`, `True`, or `"True"` instead of the correct value `true`  
also frequently cause problems — especially in APIs with strict type checking.

Another common issue: **inconsistent key spelling**  
Instead of `"mykey": 1`, the JSON might contain `"MyKey": 1` or `"Mykey": 1`.

That’s why it’s a good idea to define a **clear key-naming standard** in your API (e.g., all lowercase)  
and return **explicit error messages** if the rules are violated.

[⬅](#table-of-contents)

---

## Example: JSON in Different Programming Languages

### Java

#### Reading and Writing JSON Files

As usual, Java is very strict — nothing works without the right imports and libraries.  
For working with JSON, a widely used package is `jackson-databind`,  
which you can include using Maven or a similar build tool.

-> For setup help, see [eng_java_maven_import.md](eng_java_maven_import.md).



**First the needed imports:**
```java
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
```


**You need a object in Java, otherwise you can't save JSON:**
```java
class TestObject {

  public String name = "John";
  public Integer age = 27;

  @JsonIgnore
  public String password = "start123";
}
```

> By default, Jackson includes all `public` attributes when serializing to JSON.  
> With `@JsonIgnore`, you can explicitly exclude specific fields from the output.  
> This so-called **annotation** modifies the behavior of the code — similar to a **decorator** in Python.  
> Typical use case: passwords or internal information should not be stored or transmitted.

**A reusable class for JSON-related functions:**

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

**And finally the call, basically the start of the program:**

```Java
public class Main {
    public static void main(String[] args) {
        Tester.writeJson();
        Tester.readJson();
    }
}

```

### Notes on Formatting and Behavior

- By default, `jackson-databind` (import groupId `com.fasterxml.jackson`) writes JSON as a **single line**.
- For more readable output, use:
    - when writing: `.writerWithDefaultPrettyPrinter()`
    - when reading: `.toPrettyString()`
- Warning: Writing always **overwrites the entire file** — appending is not possible!

---

### Python

Here’s the same example in a dynamically typed language.  
Unlike Java (which is statically typed — meaning **type checks at compile time**), Python performs type checking **at runtime**.

#### Reading and Writing JSON Files

**Start with the necessary imports:**
```python
import json
from os import path
```


**Create a class, to have the same setup as in Java(but not needed in Python):**
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


**Execute the methods:**
```python
if __name__ == '__main__':
    Tester.save_json()
    Tester.load_json()
```

### Note

- Python uses **dynamic typing** – you don't need to declare data types in advance.
- When saving, `json.dump(..., indent=4)` creates formatted (pretty) JSON.
- When loading, use `json.load(...)` and optionally `json.dumps(..., indent=4)` to print it nicely.
- Files are **overwritten** when writing, not appended. So be careful with your structure!

[⬅](#table-of-contents)

---

## Nice to Know

### Extended JSON-Based Formats & File Types

In modern software architectures, there are several **formats and file types**  
that build upon JSON or extend its structure. Two important examples:

### HOCON (Human-Optimized Config Object Notation)

- **Goal**: Make configuration files more human-readable and maintainable.
- **Compatibility**: Fully JSON-compatible – every valid JSON file is also valid HOCON.
- **Enhancements over JSON**:
    - Allows comments (`//` and `#`)
    - Keys don’t need to be in quotation marks
    - Supports fallbacks, includes, and variable referencing

**Example:**
```hocon
# Simple key usage:
server {
  host = "localhost"
  port = 8080
  url = ${server.host}:${server.port}
}

# Complex key nesting:
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
  
  # In the end job returns the string "Attentäter"
  # if you would change "language" to "eng", you would get "Rogue"
}
```

**Special Syntax Feature:**
- HOCON parsers are capable of interpreting very flexible syntax patterns and assignments.

```hocon
key = value
key : value
"key" = value
key {value}

```

> Important!  
> While you can **embed JSON directly into HOCON**, the reverse is not possible without a translator.

---

### BSON (Binary JSON)

- **Purpose**: Efficient storage and processing of JSON-like data in binary form.
- **Usage**: Primarily used in **MongoDB**, a NoSQL database.
- **Extension**: Supports additional data types such as `Date`, `ObjectId`, `Binary`
- **Not human-readable** – but faster and more compact.

**Comparison:**

| JSON (human-readable)     | BSON (binary, MongoDB internal)         |
|---------------------------|------------------------------------------|
| `"name": "Anna"`          | `"name": String("Anna")`                 |
| `"created": "2024-01-01"` | `"created": Date(ISODate("2024-01-01"))` |

---

#### Note

> These formats are **not directly usable in JSON-based data exchange**,  
> as they **cannot be sent between browser and server** in standard form.  
> Instead, they are used in specific scenarios:
> - **HOCON**: for internal configuration files
> - **BSON**: for binary storage in MongoDB
> - **Other formats** like GeoJSON or JSON-LD for specialized use cases


#### Insights from my personal project:

Even relational databases like MySQL or SQLite can store JSON –  
because in the end, JSON is just a string.

I took advantage of this to store complex filtering or condition sets as JSON,  
making them easily retrievable and even exportable.

In Java terms, I built a class `ConditionList`, which can contain multiple `Condition` objects.  
Each `Condition` holds exactly four attributes:
- `value_type`
- `comp_operator`
- `attribute_name`
- `attribute_value`

A `ConditionList` can:
- contain multiple `Condition` objects
- or even other nested `ConditionList` instances  
  It also has its own `operator` attribute, either `"and"` or `"or"`.

If you’re up for a challenge: Try recreating this setup.  
The real complexity isn’t in the JSON itself,  
but in storing and loading such a nested structure **correctly**.

[⬅](#table-of-contents)

---

