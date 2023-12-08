# UserManagerSpringBoot 🍃

User manager made in java SpringBoot using JpaRepository, SpringBoot Web, PostgreSQL Driver for JDBC.

## How it Works:

* Make sure you do have jdk 17 and jre 17 installed;
* Open the project in your favorite Java IDE, (I made it using IntelliJ, and it works fine);
* The ```/src/main/java/resources/application.properties``` has the parameters to configuration of your local PostgreSQL server, so if it's not working properly, take a look in the configs, maybe the login parameters aren't right;
* Create a DB called user in postgreSQL; (You can do this the way you like, by PGAdmin, DBeaver or via terminal);
* Make sure you do have a .env file in the root with this line: ```SECRET=yourSecretKeyHere``` (We use this to the token generation and validation) (I left a dumbass key there, so feel free to use it :D)
* With all set, run the UserManagerApplication in your IDE, and check if you've got any ERROR;

I've made a Insomnia Test Collectio with all requests that are necessary to test the endpoints and validations, so take a look in the collection at:
```InsomniaTestingCollection.json```
(You just need to import this to Insomnia and send the requests updating the Bearer tokens for each request after the login!).

I've finished implementing the JWT Stateless validation + Spring security with the endpoints permissions and the data base default admin! So, I will not keep working at this study project, but if you want to make a fork of it to try new dependencies, feel free to go!


