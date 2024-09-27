package org.example.hash;

public class OpenAddressingHashMap<K, V> {

    private int capacity = 16; // 초기 테이블 크기
    private int size = 0;      // 현재 저장된 요소 수
    private K[] keys;          // 키 저장 배열
    private V[] values;        // 값 저장 배열

    public OpenAddressingHashMap() {
        keys = (K[]) new Object[capacity];    // 키 배열 초기화
        values = (V[]) new Object[capacity];  // 값 배열 초기화
    }

    // 해시 함수: key의 해시 코드를 테이블 크기로 나눔
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    // 값 삽입 (Open Addressing을 사용)
    public void put(K key, V value) {
        if (size >= capacity * 0.75) { // 로드 팩터가 0.75를 넘으면 크기 증가
            resize(capacity * 2);
        }

        int hash = hash(key);

        // 비어 있는 슬롯을 찾거나 키가 같은 경우 업데이트
        while (keys[hash] != null) {
            if (keys[hash].equals(key)) {
                values[hash] = value; // 기존 값 업데이트
                return;
            }
            hash = (hash + 1) % capacity; // 선형 탐사 (Linear Probing)
        }

        keys[hash] = key;     // 새로운 키 삽입
        values[hash] = value; // 새로운 값 삽입
        size++;
    }

    // 값 가져오기
    public V get(K key) {
        int hash = hash(key);

        while (keys[hash] != null) {
            if (keys[hash].equals(key)) {
                return values[hash]; // 값 반환
            }
            hash = (hash + 1) % capacity; // 다음 슬롯 탐색 (선형 탐사)
        }
        return null; // 키를 찾지 못한 경우
    }

    // 해시 테이블 크기 조정
    private void resize(int newCapacity) {
        OpenAddressingHashMap<K, V> temp = new OpenAddressingHashMap<>();
        temp.capacity = newCapacity;
        temp.keys = (K[]) new Object[newCapacity];
        temp.values = (V[]) new Object[newCapacity];

        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]); // 기존 키-값 쌍을 새로운 테이블에 삽입
            }
        }

        this.keys = temp.keys;
        this.values = temp.values;
        this.capacity = newCapacity;
    }

    // 테이블에 있는 요소 수
    public int size() {
        return size;
    }
}

