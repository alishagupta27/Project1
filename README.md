# Prerequisites and how to use it

1. Install Java 10. If you have Java 8 then you might want to change a configuration in pom.xml

Java 8 

```
pom.xml (#14-21)

<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<version>3.5.1</version>
<configuration>
   <source>1.8</source>
   <target>1.8</target>
   <verbose>true</verbose>
</configuration>
```
2. Download and install Firefox as the program use a firefox driver.

3. Install Maven 3.7.0 and configure.

4. Download or clone from this repo

5. Start the command prompt and move to the Project1 folder and run

```
mvn test
```

It should open firefox and start testing! 

