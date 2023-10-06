package pizzaFactory;
import Calculation.CalculationSingleton;

public class PizzaOrderFacade {
	private OutletFactory italianOutlet;
    private OutletFactory americanOutlet;
    private CalculationSingleton calculator;

    public PizzaOrderFacade() {
        italianOutlet = new ItalianPizzaOutlet();
        americanOutlet = new AmericanPizzaOutlet();
        calculator = CalculationSingleton.getInstance();
    }

    public void orderItalianThinCrustPizza(String title, float price, int size, int orderSize) {
        PizzaFactory thinCrustFactory = italianOutlet.getPizzaFactory("ThinCrust");
        Pizza italianThinPizza = thinCrustFactory.createPizza(title, price, size, orderSize);
        double italianPizzaTotalPrice = calculator.calculateTotalPrice(italianThinPizza);
        System.out.println("Italian Thin Crust Pizza Ordered: " + italianThinPizza);
        System.out.println("Total Price: $" + italianPizzaTotalPrice);
    }

    public void orderAmericanThickCrustPizza(String title, float price, int size, int orderSize) {
        PizzaFactory thickCrustFactory = americanOutlet.getPizzaFactory("ThickCrust");
        Pizza americanThickPizza = thickCrustFactory.createPizza(title, price, size, orderSize);
        double americanPizzaTotalPrice = calculator.calculateTotalPrice(americanThickPizza);
        System.out.println("American Thick Crust Pizza Ordered: " + americanThickPizza);
        System.out.println("Total Price: $" + americanPizzaTotalPrice);
    }
}
