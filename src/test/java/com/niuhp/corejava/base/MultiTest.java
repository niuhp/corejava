package com.niuhp.corejava.base;

import org.junit.Test;

/**
 * Created by niuhaipeng on 2016/6/1.
 */
public class MultiTest {

    @Test
    public void testPrint() {
        print(null);
    }

    private void print(short num) {
        System.out.println("-----------short---------" + num);
    }
//    private void print(int num){
//        System.out.println("-----------int---------"+num);
//    }
//    private void print(Integer num){
//        System.out.println("-----------Integer---------"+num);
//    }

    //    private void print(long num) {
//        System.out.println("-----------long---------" + num);
//    }
//    private void print(double num){
//        System.out.println("-----------double---------"+num);
//    }
//    private void print(String s){
//        System.out.println("-----------String---------"+s);
//    }
//    private void print(List<?> l){
//        System.out.println("-----------List---------"+l);
//    }
//    private void print(Map<?,?> m){
//        System.out.println("-----------Map---------"+m);
//    }
    private void print(Object o) {
        System.out.println("-----------Object---------" + o);
    }
    @Test
    public void testEqual(){
        String s1="test";
        String s2="te"+"st";
        String s3="tes"+'t';
        String s4="tes"+new String("t");
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1==s4);
    }
}
