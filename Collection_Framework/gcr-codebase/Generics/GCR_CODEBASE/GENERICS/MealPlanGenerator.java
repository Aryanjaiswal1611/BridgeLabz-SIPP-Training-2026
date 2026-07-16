interface MealPlan {
    String getDescription();
}

class VegetarianMeal implements MealPlan {
    private String dish;
    public VegetarianMeal(String dish) { this.dish = dish; }
    public String getDescription() { return "Vegetarian: " + dish; }
}

class VeganMeal implements MealPlan {
    private String dish;
    public VeganMeal(String dish) { this.dish = dish; }
    public String getDescription() { return "Vegan: " + dish; }
}

class KetoMeal implements MealPlan {
    private String dish;
    public KetoMeal(String dish) { this.dish = dish; }
    public String getDescription() { return "Keto: " + dish; }
}

class HighProteinMeal implements MealPlan {
    private String dish;
    public HighProteinMeal(String dish) { this.dish = dish; }
    public String getDescription() { return "High-Protein: " + dish; }
}

class Meal<T extends MealPlan> {
    private String name;
    private T mealType;

    public Meal(String name, T mealType) {
        this.name = name;
        this.mealType = mealType;
    }

    public String getName() { return name; }
    public T getMealType() { return mealType; }
}

class MealPlanUtils {
    public static <T extends MealPlan> boolean validateMeal(Meal<T> meal) {
        return meal != null && meal.getName() != null && !meal.getName().isEmpty() && meal.getMealType() != null;
    }

    public static <T extends MealPlan> Meal<T> generateMealPlan(String name, T mealType) {
        Meal<T> meal = new Meal<>(name, mealType);
        return validateMeal(meal) ? meal : null;
    }
}
