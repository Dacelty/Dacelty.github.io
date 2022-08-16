import java.util.*;

public class Main
{
    public static void main(String[] args) {
        String romanNumber1="MCMXCIV";
        String romanNumber2="LVIII";
        System.out.println(romanToInteger(romanNumber1));
        System.out.println(romanToInteger(romanNumber2));
    }


    public static int romanToInteger(String s)
    {
        Map<Character,Integer> numbersMap = new HashMap<>();
        numbersMap.put('I',1);
        numbersMap.put('V',5);
        numbersMap.put('X',10);
        numbersMap.put('L',50);
        numbersMap.put('C',100);
        numbersMap.put('D',500);
        numbersMap.put('M',1000);

        int result=0;

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(i>0 && numbersMap.get(ch) > numbersMap.get(s.charAt(i-1))) {
                result += numbersMap.get(ch) - 2*numbersMap.get(s.charAt(i-1));
            } else {
                result += numbersMap.get(ch);
            }
        }

        return result;
    }
}