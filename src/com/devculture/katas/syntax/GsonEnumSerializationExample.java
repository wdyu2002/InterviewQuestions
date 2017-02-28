package com.devculture.katas.syntax;

import com.google.gson.annotations.SerializedName;

/**
 * Example demonstrating how Gson @SerializedName can be used to serialize and deserialize enums.
 */
public class GsonEnumSerializationExample {

    public enum MyEnum {
        // MyEnum.name() == 'A'
        // MyEnum.toString() == 'thisIsA'
        // MyEnum.value() == 'aValue'
        @SerializedName("thisIsA")
        A("aValue"),
        @SerializedName("thisIsB")
        B("bValue");

        private final String value;

        MyEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            String name = name();
            try {
                return MyEnum.class.getDeclaredField(name).getAnnotation(SerializedName.class).value();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            return name;
        }

        public static MyEnum fromName(String name) {
            if (name != null) {
                for (MyEnum myEnum : values()) {
                    if (name.equals(myEnum.toString())) {
                        return myEnum;
                    }
                }
            }
            return null; // or throw exception.
        }
    }

    public static class MyObject {
        MyEnum myEnum;

        public MyObject(MyEnum myEnum) {
            this.myEnum = myEnum;
        }
    }

}
