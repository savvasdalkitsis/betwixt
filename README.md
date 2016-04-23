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