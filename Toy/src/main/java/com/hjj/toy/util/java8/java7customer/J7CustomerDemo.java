package com.hjj.toy.util.java8.java7customer;

public class J7CustomerDemo {
    public static void main(String[] args){

        //try-with-resource 自动调用close方法关闭资源
        //1.实现AutoCloseable接口的
        //2.会抛出try里面的exception，忽略掉finally后的exception，与try catch finally有区别
        //3.通过异常的getSuppressed()方法获取异常信息
        //4.捕获多个异常

        /*
        try(语句){

        };
        try(语句){
        }catch(异常1|异常2 ex){
        }
        */

        //文件操作Path

        //equals、hashCode、CompareTo
        //equals: return Objects.equals(first,other.first) && Objects.equals(last,other.last)
        //Objects.equals(a,b) 如果a\b都为null 则返回true 如果a为null 返回false 其他情况返回a.equals(b)
        //hashCode:return 31*Objects.hashCode(first)+Objects.hashCode(last)
        //更好的：return Objects.hash(first,last)
        //Objects.hashCode,对于null对象返回是0
        //toString:应该调用String.valueOf(obj),因为它可以安全处理null对象，会返回字符串"null"




    }
}
