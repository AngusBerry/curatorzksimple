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
     * Expect Args "<zookeeper node name>" "<zookeeper property path beginning with forward slash>"
     * e.g. "system" "/dev/db/host"
     */
    public static void main( String[] args ){
        String nameSpace = args[0];
        String propertyPath = args[1];
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
        System.out.println( "A simple test with Apache Curator reading a value from a localhost Zookeeper" );
        System.out.println( "...looking for the value of " + nameSpace + propertyPath);
        System.out.println();

        try{
            String data = new String(curatorClient.getData().forPath( propertyPath ),"gbk");
            System.out.println("Property from ZooKeeper = " + data);
            System.out.println();
        }
        catch (Exception ex){
            System.out.println("exception trying to read: " + ex.toString());
        }
        finally{
            curatorClient.close();
        }


    }

}
