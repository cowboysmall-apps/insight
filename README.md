Insight
=======

A simple tool for logging and profiling objects managed within a Spring container.


Usage
-----

Simpley include a dependency for the version you want to use in your maven pom:

```xml

        <dependency>
            <groupId>com.cowboysmall</groupId>
            <artifactId>insight-logback</artifactId>
            <version>0.0.1</version>
        </dependency>

```


or include the following in your gradle build:

```groovy

        compile group: 'com.cowboysmall', name: 'insight-logback', version: '0.0.1'

```

then let your application know to use the aspects:

```java

        @SpringBootApplication
        @ComponentScan(basePackages = {"com.cowboysmall.insight"})
        @EnableAspectJAutoProxy
        public class MyApplication {

            public static void main(String[] args) throws Exception {

                SpringApplication.run(MyApplication.class, args);
            }
        }

```

and then annotate your methods with @Loggable or @Profilable:

```java

        @Profilabe(LogLevel.INFO)
        public void someMethod() {

            // do something...
        }

```

and you are done.


Sample App
----------

A sample application is provided to demonstrate usage in a Spring Boot context. It includes the following:

`

    ├── pom.xml
    └── src
        └── main
            ├── java
            │   └── com
            │       └── cowboysmall
            │           └── insight
            │               └── sample
            │                   ├── job
            │                   │   └── SampleJob.java
            │                   ├── SampleApplication.java
            │                   ├── service
            │                   │   ├── SampleServiceException.java
            │                   │   ├── SampleServiceImpl.java
            │                   │   └── SampleService.java
            │                   └── web
            │                       └── SampleController.java
            └── resources
                └── logback.xml

`

Bugs and Feature Requests
-------------------------

Please submit all bugs and feature requests [here](https://github.com/cowboysmall/insight/issues/new).


Author
------

_Jerry Kiely_
- [github](https://github.com/cowboysmall)
- [linkedin](https://www.linkedin.com/in/cowboysmall)


License
-------

This software is licensed under the MIT License (MIT) quoted below:

The MIT License (MIT)

Copyright (c) 2015 Jerry Kiely

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

