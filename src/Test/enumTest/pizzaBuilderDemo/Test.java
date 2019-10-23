package Test.enumTest.pizzaBuilderDemo;

import static Test.enumTest.pizzaBuilderDemo.NyPizza.Size.SMALL;

public class Test {
    public static void main(String[] args) {
        Pizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();
    }
}
