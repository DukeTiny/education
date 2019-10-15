import java.util.*;

public class Test {
    private String name;
    private int age;

    public Test(Builder builder) {
        this.age = builder.age;
        this.name = builder.name;
    }

    public static class Builder {
        private String name;
        private int age;

        public Builder(int age) {
            this.age = age;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(int... age) {
            this.age = age[0];
            return this;
        }

        public Test build() {
            return new Test(this);
        }

    }

    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(null);
    }
}
