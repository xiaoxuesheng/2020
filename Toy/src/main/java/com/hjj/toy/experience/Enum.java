package com.hjj.toy.experience;


/**
 * 枚举可用于替代常量 更灵活的方式
 */
public class Enum {
    enum SexEnum {
        //name 为MALE FEMALI orginal为 0 1
        MALE("男"),FEMALE("女");

        private String des ;
        //构造方法可带属性信息
        SexEnum(String des){
            this.des = des;
        }
        public String getDes(){
            return des;
        }
        //覆盖toString
        public String toString(){
            return "now:"+name();
        }
    }
    public static void main(String[] args){
        //1.配合switch
        SexEnum week = SexEnum.MALE;
        switch (week) {
            case MALE:
                System.out.println("我是男人");
                break;
            case FEMALE:
                System.out.println("我是女人");
                break;
        }
        //2.添加一些属性和方法

    }
}
