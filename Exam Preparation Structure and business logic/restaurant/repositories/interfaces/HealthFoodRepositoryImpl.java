package restaurant.repositories.interfaces;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

public class HealthFoodRepositoryImpl extends RepositoryImpl<HealthyFood> implements HealthFoodRepository<HealthyFood> {

    @Override
    public HealthyFood foodByName(String name) {
        return this.getAllEntities().stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}
