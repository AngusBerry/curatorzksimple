A simple working example of Apache Curator simplifying return of data from ZooKeeper.

This example is plain Java, without Spring! OK, I used Spring in the Maven POM to package into an executable Jar, but the code is POJO :-)

1. Install your own ZooKeeper on localhost:

2. Make life easy and install ZK-UI to edit ZooKeeper node and property values<br>
   https://github.com/DeemOpen/zkui

    mvn clean package<br>
    run with:<br>
    java -jar target/zkui-2.0-SNAPSHOT-jar-with-pendencies.jar<br>
    Go to http://localhost:9090<br>
    Login with admin/admin<br>
    Set up whatever ZooKeeper nodes and properties you require to test below<br>
    e.g. node:system property:/dev/db/host

3. Build, Run and Play with this code!!!

    1. Use your favorite IDE to run the main class 'App' and pass the 2 args for ZooKeeper node and property values
    2. Build and run the jar:<br>
    mvn clean install spring-boot:repackage<br>
    java -jar target/curator-zk-simple-1.0-SNAPSHOT.jar "zookeeper node name" "zookeeper property path"<br>
    e.g. java -jar target/curator-zk-simple-1.0-SNAPSHOT.jar "system" "/dev/db/host"