package com.hjj.toy.util.文件存储.fastdfs;

//import org.csource.fastdfs.*;

import java.io.File;
import java.io.FileOutputStream;

/**
 *
 *
 *  <dependency>
     <groupId>org.csource</groupId>
     <artifactId>fastdfs-client-java</artifactId>
     <version>1.27-SNAPSHOT</version>
    </dependency>
 */
/**
public class FdfsDemo {

    public static void main(String[] args) throws Exception{
        // 1、把FastDFS提供的jar包添加到工程中
        // 2、初始化全局配置。加载一个配置文件。
        ClientGlobal.initByProperties("client.properties");
        // 3、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        // 4、创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        // 6、获得StorageClient对象。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7、直接调用StorageClient对象方法上传文件即可。
//        String[] strings = storageClient.upload_file("file.txt", "txt", null);
//        for (String string : strings) {
//            System.out.println(string);
//        }

        byte[] data = storageClient.download_file("group1","M00/00/00/ChgVkFncf1-ALXzqAAAABIbR28Y412.txt");

        File file = new File("down.txt");
        new FileOutputStream(file).write(data);

    }
}

*/