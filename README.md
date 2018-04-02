#### Game - Battle of Race
the game is designed for 2 players. Each player collects a team of three heroes. After this, a randomly selected (alive) hero from one team attacks a random (alive) hero from another.
the batle ends when all heroes of some team isn't alive.

#### the life cycle of game:
- Enter your name and oponent name
- Choose Race
- Choose 3 Heroes to your team from list: 
- Choose oponent Race
- Choose 3 Heroes to oponent team from list: 
- Automaticly batle:
- print viner;

#### Race and heroes:
```java
- Human------------damge---healing---%kritDamage-armor(%)
    - Paladin------[10]-------------------[10]----[13]
    - Archer-------[11]-------------------[ 5]----[15]
    - Mag----------[15]-----[15]----------[ 2]----[ 1]
- Elves
    - Warrior------[ 9]-------------------[12]----[15]
    - Super archer-[13]-------------------[ 7]----[ 3]
    - Druid--------[15]-----[15]----------[ 2]----[ 3]
- Demons
    - Varvar-------[15]-------------------[ 5]----[10]
    - Hells archer-[14]-------------------[ 2]----[ 1]
    - Necromant----[15]-----[15]----------[ 2]----[ 2]
```
#### how to start
 - download or git clone  
 - in directory with pom file: mvn package
 - java -cp target/Game-1.0-SNAPSHOT.jar Game
