package com.example.services.ejbs;

import com.example.services.entities.Phone;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class Phones {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public List<Phone> getPhone(int id) {
        TypedQuery<Phone> q = entityManager.createNamedQuery(Phone.FIND_PHONE, Phone.class)
                .setParameter("id", id);
        return q.getResultList();
    }

    public List<Phone> getPhones() {
        TypedQuery<Phone> q = entityManager.createNamedQuery(Phone.GET_PHONES, Phone.class);
        return q.getResultList();
    }

    public Phone addPhone(Phone phone) {
        if (entityManager.contains(phone)) {
            entityManager.merge(phone);
        } else {
            entityManager.persist(phone);
        }
        return phone;
    }
}
