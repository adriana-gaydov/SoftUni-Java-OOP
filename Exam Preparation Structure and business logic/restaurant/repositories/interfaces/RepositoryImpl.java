package restaurant.repositories.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class RepositoryImpl<T> implements Repository<T> {

    private ArrayList<T> entities;

    public RepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Collection<T> getAllEntities() {
        return Collections.unmodifiableList(entities);
    }

    @Override
    public void add(T entity) {
        this.entities.add(entity);
    }
}
