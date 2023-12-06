# UserManagerSpringBoot
User manager made in java SpringBoot using JpaRepository, SpringBoot Web, PostgreSQL Driver for JDBC.

## How it Works:

* Make sure you do have jdk 17 and jre 17 installed;
* Open the project in your favorite Java IDE, (I made it using IntelliJ, and it works fine);
* The ```/src/main/java/resources/application.properties``` has the parameters to configuration of your local PostgreSQL server, so if it's not working properly, take a look in the configs, maybe the login parameters aren't right;
* Create a DB called user in postgreSQL; (You can do this the way you like, by PGAdmin, DBeaver or via terminal);
* With all set, run the UserManagerApplication in your IDE, and check if you've got any ERROR;

Now you can test the features in the ```localhost:8080/users``` using https methods and json objects like this:
```
{
 "email":"test@mail.com",
 "username":"test"
}
```
(I made my tests using Insomnia, and everything worked fine).

I'll probably keep working on this to try other dependencies like Spring Security, JWT Auth and OAuth2.