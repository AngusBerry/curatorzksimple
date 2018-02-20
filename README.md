# A basic working example of Apache Curator returning config data from ZooKeeper.

This example is plain Java, without Spring!  
OK, I used Spring in the Maven POM to package into an executable Jar if needed, but the code is a POJO :-)

#1. Install your own ZooKeeper on localhost or remote and install the config data explained in 'Notes' below.  
This should include the following hierarchy of config data:

    /config  
        /spring-cloud-zookeeper-example  
            /dbURL = some_value  
            /dbUser = some_value  
            /dbPassword = some_value  
            /other  
                /nestedproperty = nestedPropValue
                
...or install the data below on a remote Zookeeper and set the localhost:2181 to be the server:port of your remote Zookeeper.

#2. Build, Run and Play with this code!!!
Either run in your favorite IDE, or...

    mvn clean install spring-boot:repackage
    java -jar target/curator-zk-simple-1.0-SNAPSHOT.jar
   
...then watch the output on the command line... simple!
 
## Notes:  
Assuming you have a local (or remote) install of Zookeeper

1. Create your data with ZkCli using these scripts:  


    zkCli.sh
    create /config null  
    create /config/spring-cloud-zookeeper-example null  
    create /config/spring-cloud-zookeeper-example/dbURL jdbc:mysql://10.10.10.1:3306/    
    create /config/spring-cloud-zookeeper-example/dbUser zkDBUserValue  
    create /config/spring-cloud-zookeeper-example/dbPassword zkDBPasswordValue  
    create /config/spring-cloud-zookeeper-example/other  null
    create /config/spring-cloud-zookeeper-example/other/nestedproperty nestedPropValue



2. You can make life easier by using ZK UI:  
Install and run zkui from GitHub locally, to give you a quick graphical way to edit you localhost Zookeeper:  
https://github.com/DeemOpen/zkui 