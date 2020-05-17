package com.hjj.toy.util.bigdataread.bigxecel2007up;

import java.sql.SQLException;
import java.util.List;


public class XxlsPrint extends XxlsAbstract{
    @Override
    public void optRows(int sheetIndex,int curRow, List<String> rowlist) throws SQLException {
        for (int i = 0; i < rowlist.size(); i++) {
            System.out.print("'" + rowlist.get(i) + "',");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        XxlsPrint howto = new XxlsPrint();
        howto.processOneSheet("F:/new.xlsx",1);
//      howto.processAllSheets("F:/new.xlsx");
    }
}
