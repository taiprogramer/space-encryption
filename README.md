# Space Encryption
## What is it?
Space Encryption is a simple text-file encryption tool.

![Space Encryption Image](docs/images/space-encryption-app.png)

## For users
- If you are using Windows machine, just simple checkout [releases](https://github.com/taiprogramer/space-encryption/releases) tab & download installer of any version you want.
- If you are using Linux or macOS, first you must install [OpenJDK 12](https://jdk.java.net/12/). After that, checkout [releases](https://github.com/taiprogramer/space-encryption/releases) tab & download .jar executable file. Finally, run program with simple command below

```
java -jar SpaceEncryption.jar
```

## For developers
- Checkout [documentation](./docs/README.md)

### Development environment
Here is everything we use to build Space Encryption:
- [NetBeans 11.0](https://netbeans.apache.org/download/nb110/nb110.html) (Optional)
- [OpenJDK 12.0.2](https://jdk.java.net/12/)
- [Ant 1.10.5](https://ant.apache.org/)
- [Launch4j 3.12](http://launch4j.sourceforge.net/) (run under Java 8) for creating Java executable wrapper.
- [Inno Setup version 6.0.2](http://www.jrsoftware.org/isinfo.php) for creating installer.

### Build & run
To build & run Space Encryption:
- Clone this project or [download zip file](https://github.com/taiprogramer/space-encryption/archive/master.zip)
- If you choose download a zip file, remember to extract
- Follow commands below

|Command|Description|
|---|---|
|`cd space-encryption`|cd into project root directory|
|`ant`|Build|
|`java -jar dist/SpaceEncryption.jar`|Run|

## Tests
This program has been tested with [big-text-file](https://norvig.com/big.txt).

## Contributors
- Nguyen Duy Kha (Inventor)
- taiprogramer (Java GUI Clone)
- Huynh Danh Lang (Designer)
