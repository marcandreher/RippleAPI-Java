# Get Details of Users
First Init a User for that you need a UserType an ID or an Name
```java
User name = new User(UserType.NAME, "MarcPlaying");
User id = new User(UserType.ID, "32444");
```
Now you can request diffrent Things from the User.
```java
name.getID(); - Long
name.getCountry(); - String
name.getLatest_Activity(); - String
name.getUserName_aka(); - String
name.getID - Long
name.getCurrentAPICode(); - Long
name.isOnline(); - Boolean
name.getPrivileges() - Long
name.getRegistered_On() - String
name.getUserName() - String
```
