package com.mycompany.curatorzk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Hello ZooKeeper!
 *
 */
public class App{

    /**
     *
     */
    public static void main( String[] args ){
        String nameSpace = "config";
        String zkhost="127.0.0.1:2181";//ZooKeeper host IP & port

        RetryPolicy rp=new ExponentialBackoffRetry(1000, 3);//Retry mechanism
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder().connectString(zkhost)
                .connectionTimeoutMs(5000)
                .sessionTimeoutMs(5000)
                .retryPolicy(rp);
        builder.namespace(nameSpace);
        CuratorFramework curatorClient = builder.build();
        curatorClient.start();

        System.out.println();
        System.out.println( "A simple test with Apache Curator reading a value from a Zookeeper server, local or remote" );
        System.out.println( "...looking for the value(s) in the top level node: " + nameSpace);
        System.out.println();

        String bla;
        String[] zkValues = {
            "/spring-cloud-zookeeper-example/dbURL",
            "/spring-cloud-zookeeper-example/dbUser",
            "/spring-cloud-zookeeper-example/dbPassword",
            "/spring-cloud-zookeeper-example/other/nestedproperty"
        };


        //loop through the String array above, retrieving the properties from Zookeeper
        try{
            String data = null;
            for(int i=0; i<4; i++){
                data = new String(curatorClient.getData().forPath( zkValues[i] ),"gbk");
                System.out.println("Zookeeper property: " + nameSpace + zkValues[i] + " = " + data);
            }
        }
        catch (Exception ex){
            System.out.println("exception trying to read: " + ex.toString());
        }
        finally{
            curatorClient.close();
        }


    }

}
