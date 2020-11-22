# Struts 2 Login Webapp

Submission for CZ3002 Advanced Software Engineering | Implementation of Struts V2.0 Framework
![](./res/LoginJSP.png)

## Features

#### Blank input field validation

![](./res/LoginJSP_BlankError.png)

#### Login Verification - Fail

![](./res/LoginJSP_LoginFail.png)

#### Login Verification - Success

![](./res/LoginJSP_LoginSuccess.png)

## Setup

| <!-- -->          | <!-- -->                   |
| ----------------- | -------------------------- |
| **IDE**           | IntelliJ Community Edition |
| **MySQL version** | 8.0                        |

### A. MySQL Database

For Windows :

1. Go to SQL's [Windows MSI Installer Download Page](https://dev.mysql.com/downloads/installer/) and follow setup instructions (Default port should be 3306)
2. Create a database for our data with the following commands on MySQL Shell.
   ```
   \sql
   \connect root@localhost
   ```
3. Type in password for root.
4. Continue with the command below on MySQL Shell.
   ```
   create schema ase;
   use ase;
   CREATE TABLE `user` (
       `USERNAME` VARCHAR(50) DEFAULT NULL,
       `PASSWORD` VARCHAR(50) DEFAULT NULL
   );
   INSERT INTO user values ('root', 'toor');
   ```
5. If there are no errors, you should see the following.
   ![](./res/mysql_setup2.png)

### B. Maven

1. In the project directory, right click on `pom.xml` -> add to maven
2. In the terminal, run the command below to install all the dependencies hightlighted in `pom.xml`:
   ```sh
   mvn clean install
   ```
3. If there are no errors, you should see the following message.
   ![](./res/Maven_BuildSuccess.png)

### C. Tomcat Server

1. Download [Apache Tomcat Server](http://tomcat.apache.org/). In our implementation, we use [version 9.0.40](https://tomcat.apache.org/download-90.cgi).
2. Install 'Smart Tomcat' plugin in IntelliJ
   ![](./res/SmartTomcat_Plugin.png)
3. Follow the configuration below:
   ![](./res/SmartTomcat_Config.png)

### Running the web application

After setting up MySQL, Maven and Tomcat, you can run your application. The credentials inserted earlier into the database are as follows:
| <!-- --> | <!-- --> |
| ------ | ------ |
| **Username** | root |
| **Password** | toor |
