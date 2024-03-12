package org.airplane_project.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.airplane_project.entity.Airplane;
import org.airplane_project.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirplaneDAO {
    private EntityManager entityManager ;
    @Autowired
    public AirplaneDAO(EntityManager newentityManager){
        entityManager = newentityManager ;
    }



    public List<Airplane> findAll() {

        TypedQuery<Airplane> theQuery = entityManager.createQuery("from Airplane ", Airplane.class);

        List<Airplane> plane = theQuery.getResultList();

        return plane;
    }


    public Airplane findById(int Id) {

        Airplane plane = entityManager.find(Airplane.class, Id);

        return plane;
    }

    public void save(Airplane plane) {

        //System.out.println("Before setting:-"+plane.getId());

        Airplane dbplane = entityManager.merge(plane);

        // update with id from db ... so we can get generated id for save/insert
        // plane.setId(dbplane.getId());

        // System.out.println("After setting:-"+plane.getId());

    }


    public void deleteById(int Id) {


        Airplane plane = entityManager.find(Airplane.class, Id);
        entityManager.remove(plane);

        // delete object with primary key
//        Query theQuery = entityManager.createQuery("delete from Airplane where id=:Id");

//        theQuery.setParameter("AirplaneId", Id);
//        theQuery.executeUpdate();
    }

}
