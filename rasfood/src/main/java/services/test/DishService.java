package services.test;

import DAO.DishDAO;
import br.com.rasmoo.resturante.entity.Dish;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class DishService {
    public static void main(String[] args) {
        Dish risoto = new Dish();
        risoto.setName("Risoto de frutos do mar");
        risoto.setDescription("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDishValue(BigDecimal.valueOf(88.50));

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        DishDAO dish = new DishDAO(entityManager);
        entityManager.getTransaction().begin();
        dish.register(risoto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
