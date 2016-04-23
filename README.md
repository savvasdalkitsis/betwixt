betwixt
======

**Betwixt** _(/bɪˈtwɪkst/ - preposition & adverb - archaic term for between)_ is an
android library that aims to provide a unified composable api for animation
Interpolators, both provided already by the platform and for new ones provided
by the community

syntax
======

**Betwixt** provides a fluent syntax for creating and composing interpolators,
including ones provided by the Android platform, such as:

```java
linear()
```
![linear](resources/images/linear.png)

```java
fastOutSlowIn()
```
![fastOutSlowIn](resources/images/fastOutSlowIn.png)

but also new custom ones:

```java
step()
```
![step](resources/images/step.png)

The library's power, though, comes from its composable interpolators.
These allow you to create complex animations like:

```java
pingPong(accelerateDecelerate())
```
![pingPongAccelerateDecelerate](resources/images/pingPongAccelerateDecelerate.png)

and

```java
join(accelerateDecelerate(), flip(bounce()))
```
![joinAccelerateDecelerateFlipBounce](resources/images/joinAccelerateDecelerateFlipBounce.png)

Try it out
======

Click below to try an online sample app showing a few interpolators (with animations to show how they run)

[![appetize](resources/images/appetize.png)](https://appetize.io/app/p3848n7h6b950hzkxezyg5x06m?device=hammerhead&scale=50&orientation=portrait&osVersion=6.0.1)

Download
======

The library will soon be published on **JCenter**. Note that it is still in early development and things might
change with subsequent versions.

To use it in your project, add the following to your project

- Add custom maven repository until the library is published on JCenter
```groovy
repositories {
    maven {
        url 'https://dl.bintray.com/savvasdalkitsis/maven/'
    }
}
```

- Gradle:
```groovy
compile 'com.savvasdalkitsis:betwixt:0.0.1'
```
- Maven:
```xml
<dependency>
  <groupId>com.savvasdalkitsis</groupId>
  <artifactId>betwixt</artifactId>
  <version>0.0.1</version>
</dependency>
```

License
-------

    Copyright 2016 Savvas Dalkitsis

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.