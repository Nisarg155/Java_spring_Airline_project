package org.airplane_project.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.airplane_project.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassengerDAO {

    private EntityManager entityManager ;
    @Autowired
    public PassengerDAO(EntityManager newentityManager){
        entityManager = newentityManager ;
    }



    public List<Passenger> findAll() {

        TypedQuery<Passenger> theQuery = entityManager.createQuery("from Passenger", Passenger.class);

        List<Passenger> psngr = theQuery.getResultList();

        return psngr;
    }


    public Passenger findById(int Id) {

        Passenger psngr = entityManager.find(Passenger.class, Id);

        return psngr;
    }

    public void save(Passenger psngr) {

        //System.out.println("Before setting:-"+psngr.getId());

        Passenger dbpsngr = entityManager.merge(psngr);

        // update with id from db ... so we can get generated id for save/insert
        // psngr.setId(dbpsngr.getId());

       // System.out.println("After setting:-"+psngr.getId());

    }


    public void deleteById(int Id) {


        Passenger psngr = entityManager.find(Passenger.class, Id);
        entityManager.remove(psngr);

        // delete object with primary key
//        Query theQuery = entityManager.createQuery("delete from Passenger where id=:passengerId");
//
//        theQuery.setParameter("passengerId", Id);
//        theQuery.executeUpdate();
    }

}
