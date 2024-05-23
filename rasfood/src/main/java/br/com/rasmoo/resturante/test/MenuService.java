package br.com.rasmoo.resturante.test;

import br.com.rasmoo.resturante.DAO.MenuDAO;
import br.com.rasmoo.resturante.entity.Menu;
import br.com.rasmoo.resturante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class MenuService {
    public static void main(String[] args) {
        Menu risoto = new Menu();
        risoto.setName("Risoto de frutos do mar");
        risoto.setDescription("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setMenuValue(BigDecimal.valueOf(88.50));

        Menu salmao = new Menu();
        salmao.setName("Salmão ao molho de maracujá");
        salmao.setDescription("Salmão grelhado ao molho de maracujá");
        salmao.setMenuValue(BigDecimal.valueOf(60.00));

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        MenuDAO dish = new MenuDAO(entityManager);
        entityManager.getTransaction().begin();
        dish.register(risoto);
        dish.register(salmao);
        System.out.println("O prato consultado foi: " + dish.consult(2));

        dish.delete(salmao);
        System.out.println("O prato consultado foi: " + dish.consult(2));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
