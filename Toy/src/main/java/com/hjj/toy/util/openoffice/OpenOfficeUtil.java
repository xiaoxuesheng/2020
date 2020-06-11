package com.hjj.toy.util.openoffice;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;

import java.io.File;
import java.net.ConnectException;

public class OpenOfficeUtil {

    static String ip = "";

    static int port ;

    public static boolean convert(String sourcePath,String targetPath) throws ConnectException{

        OpenOfficeConnection connection = new SocketOpenOfficeConnection(ip,port);
        connection.connect();
        DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
        File source = new File(sourcePath);
        File target = new File(targetPath);
        converter.convert(source, target);
        connection.disconnect();

        return true;
    }

}
