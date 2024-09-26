package org.example.hash;

class CustomKey {
    private String name;

    public CustomKey(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {

        return 1;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        CustomKey customKey = (CustomKey) obj;
//        return name.equals(customKey.name);
//    }

    @Override
    public String toString() {
        return name;
    }
}
