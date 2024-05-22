package DAO;

import br.com.rasmoo.resturante.entity.Dish;

import javax.persistence.EntityManager;

public class DishDAO {

    private EntityManager entityManager;

    public DishDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void register(Dish dish){
        this.entityManager.persist(dish);
        System.out.println("Entidade cadastrada: " + dish);
    }
}
