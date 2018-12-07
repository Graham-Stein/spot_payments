package com.example.codeclanbank.spots.repositories.MerchantRepository;

import com.example.codeclanbank.spots.models.Merchant;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class MerchantRepositoryImpl implements MerchantRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    //TODO: GIve list of merchants given customer has made payments to
    @Transactional
    public List<Merchant> merchantsCustomerHasPaid(Long customerId){
        List<Merchant> results = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Merchant.class);
            cr.createAlias("payments", "paymentAlias");
            cr.add(Restrictions.eq("paymentAlias.customer.id", customerId));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }




    @Transactional
    public List<Merchant> merchantsCustomerHasPaidWhoAreOver(Long customerId, int age){
        List<Merchant> results = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Merchant.class);
            cr.createAlias("payments", "paymentAlias");
            cr.createAlias("paymentAlias.customer","customerAlias" );
            cr.add(Restrictions.gt("customerAlias.age", age));
            cr.add(Restrictions.eq("customerAlias.id", customerId));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
