Inventory management System.

The objective of this project is to create an application using tools and technologiescovered during the training, the end user can interact with the application via a command line interface.


Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

Prerequisites

there are many tools that needed to be installed before executing the application.
1- You must download the JDK (java developement kit)at least version 8 depending on your operating system.
2- You need to install an IDE ( Integrated Developement environmen° like Eclipse , Netbeans ou autre, we used Eclipse as IDE.
3- You need to install Jenkins, an open automation server written in java.This tool can detect any change made on your project after you push it into github.
4- you need to install git a cmd to execute your commandes.
5- you need to install GitHub aVSC ( version system control).
6-  you need to install maven.
   

After installing JDK set the environment variable: JAVA_HOME and  the path must containd the location of the jdk




End with an example of getting some data out of the system or using it for a little demo

Running the tests


Unit Tests
Allow to test  each single method that not call others.
To proceed on a test , right click a class on your project, choose other and choose juit test, the system create a test class in the folder src/test.
once the test classe is created, right click on the class and choose run as java test,the green color means that the test pass the red color means that the test failed.
You must add the dependency related to junitest on your POM.XML file.

Integration Tests
Allow to test  each that call others..
To proceed on a test , right click a class on your project, choose other and choose juit test, the system create a test class in the folder src/test.
once the test classe is created, right click on the class and choose run as java test,the green color means that the test pass the red color means that the test failed.This dependency can be found easily by searchin on maven repository.




Built With
Maven - Dependency Management
Versioning
We use SemVer for versioning.
 To automate the test build and deploy , this can be done vi jenkins.
1- create a new item and give a name in jenkins.
2- you can give a description but it's optional.
3- In Management source g choose git and give the repository URL
4- Triggered build you can chose periodic many option are offered to you for example : * * * * *  means every minut.
5-In the build section choose bach execute command line : in this section use the maven command : mvn test,mvn deploy...


Authors
Brahim Azreg- Initial work - brahimazreg
License
This project is licensed under the MIT license - see the LICENSE.md file for details

For help in Choosing a license

Acknowledgments
Hat tip to anyone whose code was used
Inspiration
etc
