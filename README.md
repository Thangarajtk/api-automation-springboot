# API automation using Spring Boot

## Use of Spring boot in Test Automation
```
1. Cleaner code & Easy to maintain dependencies like Selenium, Rest Assured etc..
2. Easy to play around with different environments, files, parallel execution etc..
3. Everything is annotated.
```

## SpringBoot Application Context
```
It represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the beans. 
The container gets its instructions on what objects to instantiate, configure, and assemble by reading configuration metadata. 
The configuration metadata is represented in XML, Java annotations, or Java code.
```

## Dependency Injection (Commonly used)
```
1. Constructor injection
2. Field injection
3. Setter injection
```

## Spring Annotations
```
1. @Component - Classes we create (automatic configuration)
2. @Bean - Explicity create a spring bean by doing your own configuration because we can not modify third
party classes source code. Instead we create an instance and request spring to manage it for us.
3. @Value - To read data from application.properties, environment variables and so on.
4. @SpringBootTest - It is useful when we need to bootstrap the entire container. The annotation works
by creating the ApplicationContext that will be utilized in our tests.
5. @Autowired - Annotation used to call component which connect through Dependency Injection.
```