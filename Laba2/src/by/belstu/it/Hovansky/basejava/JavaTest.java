package by.belstu.it.Hovansky.basejava;

import static java.lang.Math.*;

/** 
 @author Hovanskiy
 @version 1.0
 */
public class JavaTest {
    
    final int finalInt= 10;
    public static int publicStaticInt = 10;
    public static final int publicStaticFinalInt = 10;
    
    public static void main(String[] args) {
        TaskB();
        TaskE();
        TaskF();
        TaskG();
        TaskD();
        TaskH();
    }
    public static void TaskB(){
        
        char charVariable = 'a';
        int intVariable = Integer.MIN_VALUE;
        byte byteVariable = Byte.MIN_VALUE;
        long longVariable = Long.MIN_VALUE;
        boolean booleanVariable = true;
        String stringVariable = "Simple string";
        double doubleVariable = Double.MIN_VALUE;
        
        
        System.out.println("String + int : " + stringVariable + intVariable);
        System.out.println("String + char : " + stringVariable + charVariable);
        System.out.println("String + double : " + stringVariable + doubleVariable);
        
        byte bytePlusInt = (byte) (byteVariable + intVariable);
        System.out.println("byte+int : " + bytePlusInt);
        
        int doublePlusLong = (int) (doubleVariable + longVariable);
        System.out.println("Double+long : " + doublePlusLong);
        
        long intPlusLiteral = intVariable + 2147483647 +2;
        System.out.println("int + 2147483647 : " + intPlusLiteral);
        
        boolean boolVariableFalse = false, booleanResult;
        booleanResult = boolVariableFalse && booleanVariable;
        System.out.println("True and false = " + booleanResult);
        booleanResult = boolVariableFalse ^ booleanVariable;
        System.out.println("True or false = " + booleanResult);
        //исключающее или //bool3=bool2+bool;нельзя
        
        long longForSpecialLitteral = 9223372036854775807l;
        long longForSpecialLitteral2 = 0x7ff_ffff_ffffl;
        
        
        
        System.out.println("3.45 % 2.4 = " + 3.45 % 2.4);
        System.out.println("1.0 / 0.0 = " + 1.0 / 0.0);
        System.out.println("0.0 / 0.0 = " + 0.0 / 0.0);
        System.out.println("log(-345) = " + log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000) = " + Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000) = " + Float.intBitsToFloat(0xFF800000));
        //в 2, в 10,в 16 - константы    
    }
    
    public static void TaskD(){
        System.out.println("---------------------");
        System.out.println(PI);
        System.out.println(E);  
        System.out.println(min(round(PI),round(E)));
            
        int randomValue = (int) ((Math.random() * ( 1 - 0 + 1 )) + 0);
        System.out.println(randomValue);


    }
    
    public static void TaskE(){
        Character characterVariable = Character.valueOf('c');
        var integerVariable = Integer.valueOf(12);
        var byteVariable = Byte.valueOf((byte)1);
        var shortVariable = Short.valueOf(Short.MAX_VALUE);
        var longVariable = Long.valueOf(Long.MAX_VALUE);
        var doubleVariable = Double.valueOf(Double.MAX_VALUE);
        System.out.printf("doub + int = %s%n", doubleVariable + integerVariable);
        int i = integerVariable;
        Integer i2 = i;
        var str = Integer.toString(integerVariable);
        System.out.println(str);
    }
    
    public static void TaskF(){
        var s34 = "2345";
        var sb = s34.getBytes();
        var bs = sb.toString();
        //
        var B1 = Boolean.parseBoolean(s34);
        var B2 = Boolean.getBoolean(s34);
        //
        var str1 = "BRUH";
        String str2 = "BRUH";
        var b1 = str1 == str2;
        b1 = str1.equals(str2);
        var b2 = str1.compareTo(str2);
        //
        var strin = "Test sample";
        var a1 = strin.split(" ");
        var a2 = strin.contains("Te");
        var a3 = strin.hashCode();
        var a4 = strin.indexOf("T");
        strin.replace("T", "t");
        var a5 = strin.length();
    }
    
    public static void TaskG(){
        char[][] c1;
        char[] c2[];
        char c3[][];
        char[] c4 = new char[0];
        c1 = new char[3][];
        c1[0] = new char[1];
        c1[1] = new char[2];
        c1[2] = new char[3];
        var d = c1.length;
        var d1 = c1[0].length;
        var d2 = c1[1].length;
        var d3 = c1[2].length;
        c1[0][0] = 'a';
        c1[1][0] = 'd';
        c1[1][1] = 'a';
        c1[2][0] = 'n';
        c1[2][1] = 'e';
        c1[2][2] = 't';
        for (char[] xz : c1) {
            System.out.println(xz);
        }
    }
    
    public static void TaskH() {
        var Wrapper = new StringWrapper("String");
        Wrapper.replace('S', 'P');
        System.out.println(Wrapper);
        
        var anon = new StringWrapper("bruh") {  
            @Override
            public void replace(char oldChar, char newChar) {
              
            }
            public void delete(String delete) {
               
            }
        };
       
    }
    
}

