package br.com.rasmoo.resturante.DAO;

import br.com.rasmoo.resturante.entity.Menu;

import javax.persistence.EntityManager;

public class MenuDAO {

    private EntityManager entityManager;

    public MenuDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(final Menu menu) {
        this.entityManager.persist(menu);
        System.out.println("Entidade cadastrada: " + menu);
    }

    public Menu consult(final Integer id) {
        return this.entityManager.find(Menu.class, id);
    }

    public void update(final Menu menu){
        this.entityManager.merge(menu);
    }

    public void delete(final Menu menu){
        this.entityManager.remove(menu);
    }
}
