interface MealPlan {
    String getMeal();
}

class VegetarianMeal implements MealPlan {
    public String getMeal() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getMeal() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getMeal() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMeal() {
        return "High Protein Meal";
    }
}

class Meal<T extends MealPlan> {

    T meal;

    Meal(T meal) {
        this.meal = meal;
    }

    T getMeal() {
        return meal;
    }
}

public class MealDemo {

    static <T extends MealPlan> void generateMeal(T meal) {
        System.out.println("Generated: " + meal.getMeal());
    }

    public static void main(String[] args) {

        Meal<VegetarianMeal> veg = new Meal<>(new VegetarianMeal());
        Meal<KetoMeal> keto = new Meal<>(new KetoMeal());

        generateMeal(veg.getMeal());
        generateMeal(keto.getMeal());
    }
}