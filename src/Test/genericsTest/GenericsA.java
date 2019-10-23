package Test.genericsTest;

import java.util.ArrayList;

public class GenericsA {
    public <T> void fooA(T b) {
        System.out.println(b.getClass());
    }

    public static void main(String[] args) {
        GenericsA genericsA = new GenericsA();
        genericsA.fooA(new ArrayList<>());
    }
}
