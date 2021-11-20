package restaurant.repositories.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;

public class BeverageRepositoryImpl extends RepositoryImpl<Beverages> implements BeverageRepository<Beverages> {

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return this.getAllEntities().stream().filter(e -> e.getName().equals(drinkName) && e.getBrand().equals(drinkBrand))
                .findFirst().orElse(null);
    }
}
