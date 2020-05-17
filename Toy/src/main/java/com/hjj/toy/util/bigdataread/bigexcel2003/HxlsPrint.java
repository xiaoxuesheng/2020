package com.hjj.toy.util.bigdataread.bigexcel2003;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 将excel中数据输出到控制台，实现optRows方法
 */
public class HxlsPrint extends HxlsAbstract{
    public HxlsPrint(String filename) throws IOException,FileNotFoundException, SQLException {
        super(filename);
    }

    @Override
    public void optRows(int sheetIndex,int curRow, List<String> rowlist) throws SQLException {
        for (int i = 0 ;i< rowlist.size();i++){
            System.out.print("'"+rowlist.get(i)+"',");
        }
        System.out.println();
    }

    public static void main(String[] args){
        HxlsPrint xls2csv;
        try {
            xls2csv = new HxlsPrint("E:/new.xls");
            xls2csv.process();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
