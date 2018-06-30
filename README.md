# The RippleAPI for Java
To use it download the Release.

## Introduce Users
You must create a User First You have 2 diffrent Types for that:
```java
UserType.ID
UserType.NAME
```

```java
User u = new User(UserType.NAME, "MarcPlaying");
```
You can get Diffrent Things from a User
```java
u.getCurrentAPICode() - Long
u.getCountry() - String
u.getID() - Long
u.getLatest_Activity() - String
u.getPrivileges() - Long
u.getRegistered_On() - String
u.getUserName() - String
u.getUserName_aka() - String
u.getRawJSON() - String
u.getBestScore() - Score
u.getLastScore() - Score
```

## isOnline and getUserpage
For get the Userpage you must have a Player
```java
Userpage.getUserpage(u)
```
and for check if the Player is Online you can make
```java
isOnline.check(u)
```
## Introduce Cats
Ripple implemented a Little function that randomly generate Cats for use that in Java i implemented that function
```java
Cat c = new Cat()
```
```java
getCode() - Long
getCat() - String
getRawJSON() - String
Refresh() - Refresh
```
The getCat() is important for that! Refresh() generates a new Cat

## Introduce onlineUserChecker
If you want to check how many Users are Online
```java
Cat c = new Cat()
```
```java
getResult() - Long
getAPIStatus() - Long
getAPIMessage() - String
Refresh() - void
```
The getResult() are the Online Players! Refresh() refresh the Counter

## Introduce Scores
In the [User](https://gist.github.com/MarcPlaying/f9d5962ba28da78d56a3c5eee4da79bd#introduce-users) Method i introduced 2 Method that are
```java
u.getBestScore() - Score
u.getLastScore() - Score
```
for get a Score from that u need to make it to an Score
```java
Score s = u.getBestScore()
```
There are many Things that you can make with that Method
```java
s.getID()
s.getBeatmap_md5()
s.getScore()
s.getMax_Combo()
s.getFull_Combo()
s.getMods()
s.getCount_300()
s.getCount_100()
s.getCount_50()
s.getCount_Geki()
s.getCount_Katu()
s.getCount_Miss()
s.getTime()
s.getPlay_Mode()
s.getaccuracy()
s.getPP()
s.getRank()
s.getcompleted()
s.getbeatmap_id()
s.getbeatmapset_id()
s.getsong_name()
s.getAR()
s.getOD()
s.getdifficulty()
s.getmap_max_combo()
s.gethit_length()
s.getranked()
s.getranked_status_frozen()
s.getlatest_update()
```
## Get Server Informations or Change it
```java
RippleAPI.setServer(default: "ripple.moe") - Without protocol - void
RippleAPI.isReachable() - Boolean
RippleAPI.getServer() - String
```
