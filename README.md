# Java LAME - daberkow edition
[![Run Gradle on Push](https://github.com/daberkow/java-lame/actions/workflows/test.yml/badge.svg)](https://github.com/daberkow/java-lame/actions/workflows/test.yml)

[This java port](https://github.com/nwaldispuehl/java-lame) of LAME 3.98.4 was created by Ken Händel for his [jump3r -
Java Unofficial MP3 EncodeR project:](http://sourceforge.net/projects/jsidplay2/), then modified by daberkow to support
in memory mp3 conversions. While this Java app/library maintains the code currently from the upstream project, I am
mostly focused on maintaining the in memory conversion pipeline, and promise nothing about the rest of the codebase.

Original sources by the authors of LAME: http://www.sourceforge.net/projects/lame

The code is - as the original - licensed under the LGPL (see LICENSE).

## Key Features
* Reading MP3 Files and converting them to PCM audio
* Java 11+ compatible
* Tested, Built, Signed, and Published with GitHub actions
* No dependencies, 100% self contained and native code

## Future plans
Remove some of the, to me, extra code around the command line application and streamline.

## How to build

First run the ./scripts/download_test_assets.sh script to download a test track.

To create a JAR file, you may start the gradle build process with the included gradle wrapper:

    $ ./gradlew clean build test

## How to run

After having created a JAR file, you certainly can run it as a command line application:

    $ cd /build/libs
    $ java -jar java-lame-1.0.0.jar

## Getting Started
### Installation

This library is available in [Maven Central!](https://mvnrepository.com/artifact/co.ntbl/lame)

Gradle
``` groovy
implementation group: 'co.ntbl', name: 'lame', version: '1.0.0'
```

Maven
``` xml
<dependency>
    <groupId>co.ntbl</groupId>
    <artifactId>lame</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Converting MP3 To PCM In Memory

``` java
File mp3TestFile = new File("./test_assets/house.mp3");

LameDecoder decoder = new LameDecoder(Files.readAllBytes(mp3TestFile.toPath()));

ByteBuffer buffer = ByteBuffer.allocate(decoder.getBufferSize());
ByteArrayOutputStream pcm = new ByteArrayOutputStream();

while (decoder.decode(buffer)) {
    pcm.write(buffer.array());
}

byte[] wavBytes = asWav(pcm.toByteArray(), decoder.getSampleRate(), decoder.getChannels());
```

### Credits

Test sound 'Jingle004' (CC BY-NC 3.0) by 'cydon': https://freesound.org/people/cydon/sounds/133054/

Download script for house music from: https://mixkit.co/free-stock-music/
