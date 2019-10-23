package Test.enumTest.pizzaBuilderDemo;

public class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private final boolean sauceInside = false;

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
