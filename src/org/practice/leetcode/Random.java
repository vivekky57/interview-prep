package org.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Random {
    public Map<String, Integer> collectWord(String s) {
        int i = 0;
        StringBuilder word = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        while (i < s.length()) {
            if (s.charAt(i) ==  ' ') {
                map.put(word.toString(), map.getOrDefault(word.toString(), 0) + 1);
                word = new StringBuilder();
            } else {
                word.append(s.charAt(i));
            }
            i++;
        }
        map.put(word.toString(), map.getOrDefault(word.toString(), 0) + 1);
        return map;
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        StringBuilder s = new StringBuilder(s1 +" "+ s2);

        Map<String, Integer> map = collectWord(String.valueOf(s));
        List<String> ans = new ArrayList<>();
        map.forEach((s3, integer) -> {
            if(integer==1){
                ans.add(s3);
            }
        });
        return ans.toArray(new String[0]);
    }

}
