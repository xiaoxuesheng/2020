package com.hjj.toy.util.java8.stream;


import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class StreamDemo {


    //可以从集合、数组、生成器或者迭代器创建stream
    //使用filter来选择元素，使用map来改变元素


    //stream-
    //1.stream自己不会存储元素，元素可能被存储在底层的集合中，或者根据需要产生出来
    //2.stream操作符不会改变源对象。相反，它们会返回一个持续结果的新stream
    //3.stream延迟执行
    //4.stream只能消费一次，即创建后只能使用一次

    //使用stream 1.创建一个stream 2.转换stream 3.最终产生结果

    public static void main(String[] args) {

        //创建stream
        //字符串数组
        Stream<String> words = Stream.of("a,b,c".split(","));
        //变长字符串参数
        Stream<String> words2 = Stream.of("a","b","c");
        //空stream
        Stream<String> silence = Stream.empty();
        //无限值，接受一个无参数的函数
        Stream<String> echos = Stream.generate(()->"echo");
        Stream<Double> randoms = Stream.generate(()->Math.random());
        Stream<Double> randomss = Stream.generate(Math::random);
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO,n->n.add(BigInteger.ONE));

        List<String> list = new ArrayList<String>();
        //创建并发流
        Stream<String> wordsList  = list.parallelStream();


        //过滤filter
        Stream<String> filters = words.filter(w -> w.length() > 4);
        //转换map
        Stream<String> maps = words2.map(s -> s.toLowerCase());

        //提取子流limit、skip
        Stream<Double> limits = Stream.generate(() -> Math.random()).limit(2);
        Stream<String> skips = Stream.of("a","b","c").skip(2);

        //组合流
        Stream<String> combined = Stream.concat(Stream.of("a","b"),Stream.of("c","d"));

        //有状态的转换（会记住之前已读取的元素）
        //distinct返回一个具有相同顺序、抑制重复元素的新流
        Stream<String> uniqueWords = Stream.of("a","a","c").distinct();
        uniqueWords.forEach(p-> System.out.println(p));

        //sort方法 排序
        Stream<String> sortWords = Stream.of("bb","aaa","c");
        sortWords.sorted(Comparator.comparing(String::length)).forEach(p-> System.out.println(p));
        System.out.println("--------------");


        //简单的聚合方法：都是终止操作,返回optional
        //count：元素总数
        //max:最大值
        //min:最小值
        Stream<String> maxWords = Stream.of("bb","aaa","c");
        Optional<String> largest = maxWords.max((s,b)->s.compareToIgnoreCase(b));
        if(largest.isPresent()){
            System.out.println(largest.get());
        }

        //聚合操作
        //
        Stream<Integer> reduceChar = Stream.of(1,2,3);
        Optional<Integer> sum = reduceChar.reduce((x,y)->x+y);
        if(sum.isPresent()){
            System.out.println(sum.get());
        }




    }

}