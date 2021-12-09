# Spring Native + EnvironmentPostProcessor + Conditional Bean Problem

Conditional Beans based on a property cannot be loaded if the property defined by a `EnvironmentPostProcessor`.

Build and run this project: `mvn package`

It will fail with the error:

```txt
No qualifying bean of type 'com.example.problem.Application$Bar'
 ```

If you comment out the `spring-aot-maven-plugin` plugin in the `pom.xml` the project will build successfully.

Also, if you define the missing `foo` property in the `application.properties` the project will build successfully.