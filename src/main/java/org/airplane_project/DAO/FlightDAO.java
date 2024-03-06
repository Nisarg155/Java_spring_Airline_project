package org.airplane_project.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.airplane_project.entity.Flight_Route;
import org.airplane_project.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightDAO {

    private EntityManager entityManager ;
    @Autowired
    public FlightDAO(EntityManager newentityManager){
        entityManager = newentityManager ;
    }



    public List<Flight_Route> findAll() {

        TypedQuery<Flight_Route> theQuery = entityManager.createQuery("from Flight_Route ", Flight_Route.class);

        List<Flight_Route> flight = theQuery.getResultList();

        return flight;
    }


    public Flight_Route findById(int Id) {

        Flight_Route flight = entityManager.find(Flight_Route.class, Id);

        return flight;
    }

    public void save(Flight_Route flight) {

        //System.out.println("Before setting:-"+flight.getId());

        Flight_Route dbflight = entityManager.merge(flight);

        // update with id from db ... so we can get generated id for save/insert
        // flight.setId(dbflight.getId());

        // System.out.println("After setting:-"+flight.getId());

    }


    public void deleteById(int Id) {


//        Flight_Route flight = entityManager.find(Flight_Route.class, Id);
//        entityManager.remove(flight);

        // delete object with primary key
        Query theQuery = entityManager.createQuery("delete from Flight_Route where id=:flightId");

        theQuery.setParameter("flightId", Id);
        theQuery.executeUpdate();
    }

}
