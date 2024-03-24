package org.airplane_project.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.airplane_project.entity.Flight_Route;
import org.airplane_project.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TicketDAO {

    private EntityManager entityManager ;
    @Autowired
    public TicketDAO(EntityManager newentityManager){
        entityManager = newentityManager ;
    }



    public List<Ticket> findAll() {

        TypedQuery<Ticket> theQuery = entityManager.createQuery("from Ticket ", Ticket.class);

        List<Ticket> ticket = theQuery.getResultList();

        return ticket;
    }


    public Ticket findById(int Id) {

        Ticket ticket = entityManager.find(Ticket.class, Id);

        return ticket;
    }

    public void save(Ticket ticket) {

        //System.out.println("Before setting:-"+ticket.getId());

        Ticket dbticket = entityManager.merge(ticket);

        // update with id from db ... so we can get generated id for save/insert
        // ticket.setId(dbticket.getId());

        // System.out.println("After setting:-"+ticket.getId());

    }


    public void deleteById(int Id) {


        Ticket ticket = entityManager.find(Ticket.class, Id);
        entityManager.remove(ticket);

    }



    public List<Ticket> getTicketsByPassengerId(int PId) {
        String query = "SELECT t FROM Ticket t WHERE t.p_id.p_id = :PId";
        return entityManager.createQuery(query, Ticket.class)
                .setParameter("PId", PId)
                .getResultList();
    }

    public List<Ticket> countTicketsByFlightRouteId(int flightRouteId) {
        String query = "SELECT t FROM Ticket t WHERE t.f_id.f_id = :flightRouteId";
        List<Ticket> totalticket =  entityManager.createQuery(query, Ticket.class)
                .setParameter("flightRouteId", flightRouteId)
                .getResultList();

//        String countquery = "SELECT COUNT(t) FROM Ticket t WHERE t.f_id.f_id = :flightRouteId" ;
//        long count =  entityManager.createQuery(countquery, long.class)
//                .setParameter("flightRouteId", flightRouteId)
//                .getSingleResult();
//
//        System.out.println(count);

        return totalticket ;
    }

    public long count(int flightRouteId) {
        String countquery = "SELECT COUNT(t) FROM Ticket t WHERE t.f_id.f_id = :flightRouteId" ;
        long count =  entityManager.createQuery(countquery, long.class)
                .setParameter("flightRouteId", flightRouteId)
                .getSingleResult();

        System.out.println(count);
        return count ;
    }
}
