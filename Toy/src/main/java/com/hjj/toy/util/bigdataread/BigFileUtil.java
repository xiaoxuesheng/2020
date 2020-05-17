package com.hjj.toy.util.bigdataread;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 高效读取大文件
 *
 *
 * 把文件所有的内容都放在内存中很快会耗尽可用内存——不论实际可用内存有多大，这点是显而易见的。

 此外，我们通常不需要把文件的所有行一次性地放入内存中——相反，我们只需要遍历文件的每一行，然后做相应的处理，处理完之后把它扔掉。所以，这正是我们将要做的——通过行迭代，而不是把所有行都放在内存中。
 */
public class BigFileUtil {


    //我们将使用java.util.Scanner类扫描文件的内容，一行一行连续地读取：
    public void bigFileHanler(String path) throws IOException{
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // System.out.println(line);
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    //可以使用Commons IO库实现，利用该库提供的自定义LineIterator:：
    public void bigFileHanler2(String path) throws IOException{
        LineIterator it = FileUtils.lineIterator(new File(path), "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                // do something with line
            }
        } finally {
            LineIterator.closeQuietly(it);
        }
    }
}
