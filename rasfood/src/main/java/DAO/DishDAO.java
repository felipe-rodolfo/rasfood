package DAO;

import br.com.rasmoo.resturante.entity.Dish;

import javax.persistence.EntityManager;

public class DishDAO {

    private EntityManager entityManager;

    public DishDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(final Dish dish) {
        this.entityManager.persist(dish);
        System.out.println("Entidade cadastrada: " + dish);
    }

    public Dish consult(final Integer id) {
        return this.entityManager.find(Dish.class, id);
    }

    public void update(final Dish dish){
        this.entityManager.merge(dish);
    }

    public void delete(final Dish dish){
        this.entityManager.remove(dish);
    }
}
