#### RocketLauncher

destination point:    MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO

#### steps how to pack this project on jar file:
1) download or git clone
2) go to src directory
3) javac RocketLauncher.java
4) touch manifest.mf
5) echo "Manifest-Version: 1.0" >> manifest.mf
6) echo "Main-Class: RocketLauncher"
7) jar cmf manifest.mf Rocket.jar *
8) java -jar Rocket.jar


