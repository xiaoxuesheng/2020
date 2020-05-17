package com.hjj.toy.util.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class HDFSUtil {


    private HDFSUtil() {

    }

    /**
     * 判断路径是否存在
     *
     * @param conf
     * @param path
     * @return
     * @throws java.io.IOException
     */
    public static boolean exits(Configuration conf,String uri,String path) throws IOException {

        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        return fs.exists(new Path(path));
    }

    /**
     * 创建文件
     *
     * @param conf
     * @param filePath
     * @param contents
     * @throws IOException
     */
    public static void createFile(Configuration conf,String uri, String filePath, byte[] contents) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        Path path = new Path(filePath);
        FSDataOutputStream outputStream = fs.create(path);
        outputStream.write(contents);
        outputStream.close();
        fs.close();
    }

    /**
     * 创建文件
     *
     * @param conf
     * @param filePath
     * @param fileContent
     * @throws IOException
     */
    public static void createFile(Configuration conf, String uri,String filePath, String fileContent) throws IOException {
        createFile(conf, uri,filePath, fileContent.getBytes());
    }

    /**
     * 文件copy
     * @param conf
     * @param localFilePath
     * @param remoteFilePath
     * @throws IOException
     */
    public static void copyFromLocalFile(Configuration conf,String uri, String localFilePath, String remoteFilePath) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        Path localPath = new Path(localFilePath);
        Path remotePath = new Path(remoteFilePath);
        fs.copyFromLocalFile(true, true, localPath, remotePath);
        fs.close();
    }

    /**
     * 删除目录或文件
     *
     * @param conf
     * @param remoteFilePath
     * @param recursive
     * @return
     * @throws IOException
     */
    public static boolean deleteFile(Configuration conf, String uri,String remoteFilePath, boolean recursive) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        boolean result = fs.delete(new Path(remoteFilePath), recursive);
        fs.close();
        return result;
    }

    /**
     * 删除目录或文件(如果有子目录,则级联删除)
     *
     * @param conf
     * @param remoteFilePath
     * @return
     * @throws IOException
     */
    public static boolean deleteFile(Configuration conf, String uri ,String remoteFilePath) throws IOException {
        return deleteFile(conf, uri,remoteFilePath, true);
    }

    /**
     * 文件重命名
     *
     * @param conf
     * @param oldFileName
     * @param newFileName
     * @return
     * @throws IOException
     */
    public static boolean renameFile(Configuration conf,String uri, String oldFileName, String newFileName) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        Path oldPath = new Path(oldFileName);
        Path newPath = new Path(newFileName);
        boolean result = fs.rename(oldPath, newPath);
        fs.close();
        return result;
    }

    /**
     * 创建目录
     *
     * @param conf
     * @param dirName
     * @return
     * @throws IOException
     */
    public static boolean createDirectory(Configuration conf,String uri, String dirName) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        Path dir = new Path(dirName);
        boolean result = fs.mkdirs(dir);
        fs.close();
        return result;
    }

    /**
     * 列出指定路径下的所有文件(不包含目录)
     *
     * @param fs
     * @param basePath
     * @param recursive
     */
    public static RemoteIterator<LocatedFileStatus> listFiles(FileSystem fs, String basePath, boolean recursive) throws IOException {

        RemoteIterator<LocatedFileStatus> fileStatusRemoteIterator = fs.listFiles(new Path(basePath), recursive);

        return fileStatusRemoteIterator;
    }

    /**
     * 列出指定路径下的文件（非递归）
     *
     * @param conf
     * @param basePath
     * @return
     * @throws IOException
     */
    public static RemoteIterator<LocatedFileStatus> listFiles(Configuration conf,String uri, String basePath) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        RemoteIterator<LocatedFileStatus> remoteIterator = fs.listFiles(new Path(basePath), false);
        fs.close();
        return remoteIterator;
    }

    /**
     * 列出指定目录下的文件\子目录信息（非递归）
     *
     * @param conf
     * @param dirPath
     * @return
     * @throws IOException
     */
    public static FileStatus[] listStatus(Configuration conf, String uri,String dirPath) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        FileStatus[] fileStatuses = fs.listStatus(new Path(dirPath));
        fs.close();
        return fileStatuses;
    }


    /**
     * 读取文件内容
     *
     * @param conf
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String readFile(Configuration conf,String uri, String filePath) throws IOException {
        String fileContent = null;
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        Path path = new Path(filePath);
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
            inputStream = fs.open(path);
            outputStream = new ByteArrayOutputStream(inputStream.available());
            IOUtils.copyBytes(inputStream, outputStream, conf);
            fileContent = outputStream.toString();
        } finally {
            IOUtils.closeStream(inputStream);
            IOUtils.closeStream(outputStream);
            fs.close();
        }
        return fileContent;
    }


    public static void main(String[] args) throws Exception{


        Configuration conf = new Configuration();
        String uri = "hdfs://10.24.21.83:9000";
        String newDir = "test";
        //01.检测路径是否存在 测试
        if (HDFSUtil.exits(conf,uri, newDir)) {
            System.out.println(newDir + " 已存在!");
        } else {
            //02.创建目录测试
            boolean result = HDFSUtil.createDirectory(conf,uri, newDir);
            if (result) {
                System.out.println(newDir + " 创建成功!");
            } else {
                System.out.println(newDir + " 创建失败!");
            }
        }
        String fileContent = "Hi,hadoop. I love you";
        String newFileName = newDir + "/myfile.txt";

        //03.创建文件测试
        HDFSUtil.createFile(conf,uri, newFileName, fileContent);
        System.out.println(newFileName + " 创建成功");

        //04.读取文件内容 测试
        System.out.println(newFileName + " 的内容为:\n" + HDFSUtil.readFile(conf,uri, newFileName));

        //05. 测试获取所有目录信息
        FileStatus[] dirs = HDFSUtil.listStatus(conf,uri, "/");
        System.out.println("--根目录下的所有子目录---");
        for (FileStatus s : dirs) {
            System.out.println(s);
        }

        //06. 测试获取所有文件
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        RemoteIterator<LocatedFileStatus> files = HDFSUtil.listFiles(fs, "/", true);
        System.out.println("--根目录下的所有文件---");
        while (files.hasNext()) {
            System.out.println(files.next());
        }
        fs.close();

        //删除文件测试
        boolean isDeleted = HDFSUtil.deleteFile(conf,uri, newDir);
        System.out.println(newDir + " 已被删除");

    }
}
