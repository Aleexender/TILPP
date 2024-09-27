package org.example.hash;

import java.lang.reflect.Field;

public class OpenAddressingPractice {
    public static void main(String[] args) throws Exception {
        // OpenAddressingHashMap 인스턴스 생성
        OpenAddressingHashMap<String, Integer> map = new OpenAddressingHashMap<>();

        // 값 삽입
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        map.put("key4", 4); // 충돌 가능성을 확인하기 위한 여러 데이터

        // 리플렉션을 이용하여 keys와 values 배열을 확인
        printOpenAddressingMapState(map);
    }

    // Reflection을 이용해 OpenAddressingHashMap의 상태를 출력
    public static void printOpenAddressingMapState(OpenAddressingHashMap<?, ?> map) throws Exception {
        // OpenAddressingHashMap 클래스의 'keys' 필드를 가져오기
        Field keysField = OpenAddressingHashMap.class.getDeclaredField("keys");
        keysField.setAccessible(true);

        // 'keys' 배열 값 가져오기
        Object[] keys = (Object[]) keysField.get(map);

        // OpenAddressingHashMap 클래스의 'values' 필드를 가져오기
        Field valuesField = OpenAddressingHashMap.class.getDeclaredField("values");
        valuesField.setAccessible(true);

        // 'values' 배열 값 가져오기
        Object[] values = (Object[]) valuesField.get(map);

        // keys와 values 배열 출력
        System.out.println("HashMap 상태 (Open Addressing):");
        for (int i = 0; i < keys.length; i++) {
            System.out.println("Bucket " + i + ": Key = " + keys[i] + ", Value = " + values[i]);
        }
    }
}
