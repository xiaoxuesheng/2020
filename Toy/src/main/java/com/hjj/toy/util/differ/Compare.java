package com.hjj.toy.util.differ;

import difflib.*;

import java.util.ArrayList;
import java.util.List;

/**
 *         <dependency>
                <groupId>com.googlecode.java-diff-utils</groupId>
                <artifactId>diffutils</artifactId>
                <version>1.3.0</version>
            </dependency>
 */
public class Compare {

    public static void main(String[] args){

        List<String> original = new ArrayList<String>();
        original.add("dhjskaf");original.add("isjgsgka");

        List<String> revised = new ArrayList<String>();
        revised.add("xxogjsg");revised.add("dhjskaf");

        Patch patch = DiffUtils.diff(original, revised);

        for (Delta delta : (List<Delta>)patch.getDeltas()) {
            List<?> list = delta.getRevised().getLines();
            for (Object object : list) {
                System.out.println(object);
            }
        }

        DiffRowGenerator.Builder builder = new DiffRowGenerator.Builder();
        builder.showInlineDiffs(false);
        DiffRowGenerator generator = builder.build();
        for (Delta delta :  (List<Delta>)patch.getDeltas()) {
            List<DiffRow> generateDiffRows = generator.generateDiffRows((List<String>) delta.getOriginal().getLines(), (List<String>) delta.getRevised().getLines());
            int leftPos = delta.getOriginal().getPosition();
            int rightPos = delta.getRevised().getPosition();
            for (DiffRow row : generateDiffRows) {
                DiffRow.Tag tag = row.getTag();
                if (tag == DiffRow.Tag.INSERT) {
                    System.out.println("Insert: ");
                    System.out.println("new-> " + row.getNewLine());
                    System.out.println("");
                } else if (tag == DiffRow.Tag.CHANGE) {
                    System.out.println("change: ");
                    System.out.println("old-> " + row.getOldLine());
                    System.out.println("new-> " + row.getNewLine());
                    System.out.println("");
                } else if (tag == DiffRow.Tag.DELETE) {
                    System.out.println("delete: ");
                    System.out.println("old-> " + row.getOldLine());
                    System.out.println("");
                } else if (tag == DiffRow.Tag.EQUAL) {
                    System.out.println("equal: ");
                    System.out.println("old-> " +  row.getOldLine());
                    System.out.println("new-> " +  row.getNewLine());
                    System.out.println("");
                } else {
                    throw new IllegalStateException("Unknown pattern tag: " + tag);
                }
            }
        }
    }


}
