Insight
=======

[![Circle CI](https://circleci.com/gh/cowboysmall/insight.svg?style=svg)](https://circleci.com/gh/cowboysmall/insight)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/cowboysmall/insight.svg)](http://isitmaintained.com/project/cowboysmall/insight "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/cowboysmall/insight.svg)](http://isitmaintained.com/project/cowboysmall/insight "Percentage of issues still open")
[![codecov.io](http://codecov.io/github/cowboysmall/insight/coverage.svg?branch=master)](http://codecov.io/github/cowboysmall/insight?branch=master)
[![Download](https://api.bintray.com/packages/cowboysmall/maven/com.cowboysmall.insight/images/download.svg)](https://bintray.com/cowboysmall/maven/com.cowboysmall.insight/_latestVersion)
[![Join the chat at https://gitter.im/cowboysmall/insight](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/cowboysmall/insight?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

A simple tool for logging and profiling objects managed within a Spring container.


Usage
-----

add a dependency for the version you want to use in your maven pom:

```xml

        <dependency>
            <groupId>com.cowboysmall.insight</groupId>
            <artifactId>insight-logback</artifactId>
            <version>0.9.3</version>
        </dependency>

```


or include the following in your gradle build:

```groovy

        compile 'com.cowboysmall.insight:insight-logback:0.9.3'

```

then let your application know to use the aspects, and override the default properties if you chose to (see demo):

```java

        @SpringBootApplication
        @ComponentScan(basePackages = {"com.cowboysmall.insight", "..."})
        @EnableAspectJAutoProxy
        public class MyApplication {

            public static void main(String... args) {

                SpringApplication.run(MyApplication.class, args);
            }
        }

```

and then annotate your methods with @Loggable or @Profilable:

```java

        @Profilabe(Level.INFO)
        public void someMethod() {

            // do something...
        }

```

and you are done.


Demo App
--------

A demo application is provided to demonstrate usage in a Spring Boot context. It includes the following:

```

        ├── pom.xml
        └── src
            └── main
                ├── java
                │   └── com
                │       └── cowboysmall
                │           └── insight
                │               └── demo
                │                   ├── DemoApplication.java
                │                   ├── job
                │                   │   └── DemoJob.java
                │                   ├── service
                │                   │   ├── DemoServiceException.java
                │                   │   ├── DemoService.java
                │                   │   └── impl
                │                   │       └── DemoServiceImpl.java
                │                   └── web
                │                       └── DemoController.java
                └── resources
                    ├── application.properties
                    ├── banner.txt
                    └── logback.xml

```

once built, either execute the following through maven:

```

        mvn spring-boot:run

```

or execute the following:

```

        java -jar insight-demo/target/insight-demo-0.9.3.jar

```

and you will see something like the following:

```

          ___         _      _   _     ___
         |_ _|_ _  __(_)__ _| |_| |_  |   \ ___ _ __  ___
          | || ' \(_-< / _` | ' \  _| | |) / -_) '  \/ _ \
         |___|_||_/__/_\__, |_||_\__| |___/\___|_|_|_\___/
                       |___/

         :: Insight Demo :: Spring Boot  (v1.5.12.RELEASE)


        23:17:00.002 [pool-1-thread-1] INFO  c.c.insight.demo.job.DemoJob - [ entering < execute > with args [] ]
        23:17:00.782 [pool-1-thread-1] INFO  c.c.i.d.s.impl.DemoServiceImpl - [ time taken to execute < scheduled > = 779ms ]
        23:17:00.783 [pool-1-thread-1] INFO  c.c.insight.demo.job.DemoJob - [ leaving < execute > returning null ]
        23:17:03.206 [qtp87581093-15] INFO  c.c.i.demo.web.DemoController - [ entering < logging > with args [] ]
        23:17:03.221 [qtp87581093-15] INFO  c.c.i.d.s.impl.DemoServiceImpl - [ entering < logging > with args [one, 2] ]
        23:17:04.021 [qtp87581093-15] INFO  c.c.i.d.s.impl.DemoServiceImpl - [ leaving < logging > returning Test Logging... ]
        23:17:04.022 [qtp87581093-15] INFO  c.c.i.demo.web.DemoController - [ leaving < logging > returning Test Logging... ]
        23:17:05.001 [pool-1-thread-1] INFO  c.c.insight.demo.job.DemoJob - [ entering < execute > with args [] ]
        23:17:05.510 [pool-1-thread-1] INFO  c.c.i.d.s.impl.DemoServiceImpl - [ time taken to execute < scheduled > = 508ms ]
        23:17:05.511 [pool-1-thread-1] INFO  c.c.insight.demo.job.DemoJob - [ leaving < execute > returning null ]

```


Bugs and Feature Requests
-------------------------

Please submit all bugs and feature requests [here](https://github.com/cowboysmall/insight/issues/new).


Author
------

__Jerry Kiely__
- [github](https://github.com/cowboysmall)
- [linkedin](https://www.linkedin.com/in/cowboysmall)


License
-------

This software is licensed under the MIT License (MIT) quoted below:

The MIT License (MIT)

Copyright (c) 2017 Jerry Kiely

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

