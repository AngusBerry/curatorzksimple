A simple working example of Apache Curator simplifying return of data from ZooKeeper.

This example is plain Java, without Spring! OK, I used Spring in the Maven POM to package into an executable Jar, but the code is POJO :-)

1. Install your own ZooKeeper on localhost:

2. Make life easy and install ZK-UI

mvn clean package
run with ????
Go to http://localhost:9090
Login with admin/admin

3. Build, Run and Play with this code!!!

mvn clean install spring-boot:repackage
java -jar target/curator-zk-simple-1.0-SNAPSHOT.jar "zookeeper node name" "zookeeper property path"

e.g. java -jar target/curator-zk-simple-1.0-SNAPSHOT.jar "system" "/dev/db/host"