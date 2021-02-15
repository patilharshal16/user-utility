# User Utility

## Prerequisite
### Installation
    1. Install Java 11
    2. Install Gradle

 
Plenty of IDEs are available for developing Java applications. Please use which one is comfortable for you. I am going to use IntelliJ IDE
Let us import the project.

### JUnits
Unit Testing is a one of the testing done by the developers to make sure individual unit or component functionalities are working fine.

## Run Application

Open a terminal and inside project root folder run below commands,

```
Gradle clean build 
Gradle run
```

### Run using docker compose 
Open a terminal and inside project root folder run below commands,
```
docker-compose build
docker-compose up
```

## CURL Requests

CURL request added for CREATE, GET, LIST, UPDATE, DELETE APIs in script folder at root location.

1. [Insert user batch](https://github.com/patilharshal16/user-utility/blob/master/script/addUsersList.sh)
2. [Create User](https://github.com/patilharshal16/user-utility/blob/master/script/addUser.sh)
3. [List users](https://github.com/patilharshal16/user-utility/blob/master/script/listUsers.sh)
4. [Get user by id](https://github.com/patilharshal16/user-utility/blob/master/script/getUser.sh)
5. [Update user](https://github.com/patilharshal16/user-utility/blob/master/script/updateUser.sh)
6. [Delete user](https://github.com/patilharshal16/user-utility/blob/master/script/deleteUser.sh)

