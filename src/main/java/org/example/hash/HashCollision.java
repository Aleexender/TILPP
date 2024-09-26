package org.example.hash;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class HashCollision {

    public static void main(String[] args) throws Exception {
        // HashMap 생성
        Map<CustomKey, Integer> map = new HashMap<>();
        map.put(new CustomKey("Alex"), 1);
        map.put(new CustomKey("Alex2"), 2);
        map.put(new CustomKey("Alex3"), 10);

        // HashMap의 버킷(배열) 필드를 리플렉션으로 접근
        printHashMapBuckets(map);
    }

    // HashMap의 버킷 구조 출력 메소드
    public static void printHashMapBuckets(Map<CustomKey, Integer> map) throws Exception {
        // HashMap의 클래스 객체 가져오기
        Class<?> hashMapClass = map.getClass();

        // HashMap 클래스의 'table' 필드를 가져오기 (private이므로 리플렉션 필요)
        Field tableField = hashMapClass.getDeclaredField("table");
        tableField.setAccessible(true); // 필드를 접근 가능하도록 설정

        // table 필드의 값을 가져오기 (배열 형태)
        Object[] table = (Object[]) tableField.get(map);

        // 각 버킷 출력
        for (int i = 0; i < table.length; i++) {
            System.out.print("Bucket " + i + ": ");
            if (table[i] != null) {
                // 각 버킷 내부의 LinkedList를 출력 (Entry)
                Class<?> nodeClass = table[i].getClass();
                Field keyField = nodeClass.getDeclaredField("key");
                keyField.setAccessible(true);
                Field valueField = nodeClass.getDeclaredField("value");
                valueField.setAccessible(true);
                Field nextField = nodeClass.getDeclaredField("next");
                nextField.setAccessible(true);

                Object node = table[i];
                while (node != null) {
                    CustomKey key = (CustomKey) keyField.get(node);
                    Integer value = (Integer) valueField.get(node);
                    System.out.print(key + "=" + value + " ");
                    node = nextField.get(node); // 다음 노드로 이동
                }
            }
            System.out.println();
        }
    }
}
