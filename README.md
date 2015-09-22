Insight
=======

[![Circle CI](https://circleci.com/gh/cowboysmall/insight.svg?style=svg)](https://circleci.com/gh/cowboysmall/insight)

A simple tool for logging and profiling objects managed within a Spring container.


Usage
-----

Simply include a dependency for the version you want to use in your maven pom:

```xml

        <dependency>
            <groupId>com.cowboysmall.insight</groupId>
            <artifactId>insight-logback</artifactId>
            <version>0.0.6</version>
        </dependency>

```


or include the following in your gradle build:

```groovy

        compile group: 'com.cowboysmall.insight', name: 'insight-logback', version: '0.0.6'

```

then let your application know to use the aspects:

```java

        @SpringBootApplication
        @ComponentScan(basePackages = {"com.cowboysmall.insight", "..."})
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
                │                   │   ├── impl
                │                   │   │   └── SampleServiceImpl.java
                │                   │   ├── SampleServiceException.java
                │                   │   └── SampleService.java
                │                   └── web
                │                       └── SampleController.java
                └── resources
                    ├── banner.txt
                    └── logback.xml

`

once built, either execute the following through maven:

`

        mvn spring-boot:run

`

or execute the following:

`

        java -jar insight-demo/target/insight-demo-0.0.6.jar

`

and you will see something like the following:

`

          ___         _      _   _     ___
         |_ _|_ _  __(_)__ _| |_| |_  |   \ ___ _ __  ___
          | || ' \(_-< / _` | ' \  _| | |) / -_) '  \/ _ \
         |___|_||_/__/_\__, |_||_\__| |___/\___|_|_|_\___/
                       |___/

         :: Insight Demo :: Spring Boot  (v1.2.6.RELEASE)


        23:17:00.002 [pool-1-thread-1] INFO  c.c.insight.sample.job.SampleJob - [ entering < execute > with args [] ]
        23:17:00.782 [pool-1-thread-1] INFO  c.c.i.s.s.impl.SampleServiceImpl - [ time taken to execute < scheduled > = 779ms ]
        23:17:00.783 [pool-1-thread-1] INFO  c.c.insight.sample.job.SampleJob - [ leaving < execute > returning null ]
        23:17:03.206 [qtp87581093-15] INFO  c.c.i.sample.web.SampleController - [ entering < logging > with args [] ]
        23:17:03.221 [qtp87581093-15] INFO  c.c.i.s.s.impl.SampleServiceImpl - [ entering < logging > with args [one, 2] ]
        23:17:04.021 [qtp87581093-15] INFO  c.c.i.s.s.impl.SampleServiceImpl - [ leaving < logging > returning Test Logging... ]
        23:17:04.022 [qtp87581093-15] INFO  c.c.i.sample.web.SampleController - [ leaving < logging > returning Test Logging... ]
        23:17:05.001 [pool-1-thread-1] INFO  c.c.insight.sample.job.SampleJob - [ entering < execute > with args [] ]
        23:17:05.510 [pool-1-thread-1] INFO  c.c.i.s.s.impl.SampleServiceImpl - [ time taken to execute < scheduled > = 508ms ]
        23:17:05.511 [pool-1-thread-1] INFO  c.c.insight.sample.job.SampleJob - [ leaving < execute > returning null ]

`


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

