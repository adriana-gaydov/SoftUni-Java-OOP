package restaurant.repositories.interfaces;

import restaurant.entities.tables.interfaces.Table;

public class TableRepositoryImpl extends RepositoryImpl<Table> implements TableRepository<Table>{

    @Override
    public Table byNumber(int number) {
        return this.getAllEntities().stream().filter(e -> e.getTableNumber() == number).findFirst().orElse(null);
    }
}
