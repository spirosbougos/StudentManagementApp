package com.example.services.ejbs;

import com.example.services.entities.Account;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class Accounts {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public List<Account> get(int id) {
        TypedQuery<Account> q = entityManager.createNamedQuery(Account.FIND_ACCOUNT, Account.class)
                .setParameter("p", id);
        return q.getResultList();
    }
}
