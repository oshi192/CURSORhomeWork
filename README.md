#### RocketLauncher
In this application you need to build a rocket to fly the planet
destination point:    MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO

You can choose 1 of 5 variants of cabins.
The Rocket can have 3-5 engines.
Each engine have a fuel tank.
There are also 5 variants of  fuel tank to choose.
When we install fuel tank, we chek if the tank is smaller than engine.
When all parts are instaled, the rocket starts flying.
If the fuel ends in the fuel tank, engine stops working, and when all engines are stoped, then we check the velocity.
If the velocity > 11200, this means that we have left the Earth and can drifting to our destination point.
#### steps how to pack this project on jar file:
      1) download or git clone
      2) go to src directory
      3) javac RocketLauncher.java
      4) touch manifest.mf
      5) echo "Main-Class: RocketLauncher"> manifest.mf
      6) jar cmf manifest.mf Rocket.jar *
      7) java -jar Rocket.jar


