
abstract class BasePizza {

	public abstract int cost();

}

class MargeritaPizza extends BasePizza {
	@Override
	public int cost() {
		return 100;
	}
}

class VegDelightPizza extends BasePizza {
	@Override
	public int cost() {
		return 80;
	}
}

abstract class ToppingsDecorator extends BasePizza {

}

class ExtraCheesePizza extends ToppingsDecorator {

	BasePizza basePizza;

	ExtraCheesePizza(BasePizza basePizza) {
		this.basePizza = basePizza;
	}

	@Override
	public int cost() {
		return basePizza.cost() + 20;
	}

}

class MushroomPizza extends ToppingsDecorator {
	BasePizza basePizza;

	MushroomPizza(BasePizza basePizza) {
		this.basePizza = basePizza;
	}

	@Override
	public int cost() {
		return basePizza.cost() + 60;
	}

}

class ChickenPizza extends ToppingsDecorator {
	BasePizza basePizza;

	ChickenPizza(BasePizza basePizza) {
		this.basePizza = basePizza;
	}

	@Override
	public int cost() {
		return basePizza.cost() + 100;
	}
}

public class Main {

	public static void main(String[] args) {
		
		//we can try all combinations and permutations  with pizza if we will not use decorator Design pattern then we 
		//have to create N! classes for pizzas we can avoid these to n by decorator Design Pattern
		
		//chicken cheese MargeritaPizza
		BasePizza ccpPizza=new ChickenPizza(new ExtraCheesePizza(new MargeritaPizza()));
		System.out.println(ccpPizza.cost());
		
		//Mushroom cheese vegDelight Pizza
		
		BasePizza mcvPizza=new MushroomPizza(new ExtraCheesePizza(new VegDelightPizza()));
		System.out.println(mcvPizza.cost());
		
		//mushroom chicken MargeritaPizza
		
		BasePizza mcmPizza=new MushroomPizza(new ChickenPizza(new MargeritaPizza()));
		System.out.println(mcmPizza.cost());

	}

}
