package leetcode.top100;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author HuShengHengao
 * @Date 2022/7/25
 **/
public class L17 {
    public static List<String> letterCombinations(String digits){
        List<String> combinations =new ArrayList<>();
        if (StringUtils.isEmpty(digits)||digits.length()==0){
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(digits,combinations,phoneMap,0,new StringBuffer());

        return combinations;


    }

    private static void backtrack(String digits, List<String> combinations, Map<Character, String> phoneMap, int index, StringBuffer stringBuffer) {
        if (stringBuffer.length()==digits.length()){
            combinations.add(stringBuffer.toString());
        }else {
            for (int i = index; i < digits.length(); i++) {
                String temp = phoneMap.get(digits.charAt(i));
                for (int j = 0; j < temp.length(); j++) {
                    stringBuffer.append(temp.charAt(j));
                    backtrack(digits,combinations,phoneMap,i+1,stringBuffer);
                    stringBuffer.deleteCharAt(stringBuffer.length()-1);
                }
            }

        }
    }
    private static void backtrack1(String digits, List<String> combinations, Map<Character, String> phoneMap, int index, StringBuffer stringBuffer){
        if (stringBuffer.length()==digits.length()){
            combinations.add(stringBuffer.toString());
        }else {
            char digit = digits.charAt(index);
            String letter  = phoneMap.get(digit);
            for (int i = 0; i < letter.length(); i++) {
                stringBuffer.append(letter.charAt(i));
                backtrack1(digits, combinations, phoneMap, index+1, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }

        }



    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }


//    public List<String> letterCombinations1(String digits) {
//        List<String> combinations = new ArrayList<String>();
//        if (digits.length() == 0) {
//            return combinations;
//        }
//        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
//            put('2', "abc");
//            put('3', "def");
//            put('4', "ghi");
//            put('5', "jkl");
//            put('6', "mno");
//            put('7', "pqrs");
//            put('8', "tuv");
//            put('9', "wxyz");
//        }};
//        backtrack1(combinations, phoneMap, digits, 0, new StringBuffer());
//        return combinations;
//    }
//
//    public void backtrack1(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
//        if (index == digits.length()) {
//            combinations.add(combination.toString());
//        } else {
//            char digit = digits.charAt(index);
//            String letters = phoneMap.get(digit);
//            int lettersCount = letters.length();
//            for (int i = 0; i < lettersCount; i++) {
//                combination.append(letters.charAt(i));
//                backtrack1(combinations, phoneMap, digits, index + 1, combination);
//                combination.deleteCharAt(index);
//            }
//        }
//    }
}
