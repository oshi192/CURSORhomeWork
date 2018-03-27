#### RocketLauncher
In this application you need to build a rocket to fly the planet
destination point:    MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO

you can choose 1 of 5 variants of cabins
the Rocket can have 3-5 engines
each engine have a fuel tank;
There are also 5 options to choose fuel tank variants
when we install fuel tank we chek if the tank smaller than engine
when all of parts instaled the rocket start fly
if fuel ends in fuel tank engine stop working and when all engines stoped 
we look at velocity 
velocity > 11200 then we had left Earth and can drifting to our destination point
#### steps how to pack this project on jar file:
      1) download or git clone
      2) go to src directory
      3) javac RocketLauncher.java
      4) touch manifest.mf
      5) echo "Main-Class: RocketLauncher"> manifest.mf
      6) jar cmf manifest.mf Rocket.jar *
      7) java -jar Rocket.jar


