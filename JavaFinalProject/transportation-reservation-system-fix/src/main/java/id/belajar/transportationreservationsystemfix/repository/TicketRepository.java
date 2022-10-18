package id.belajar.transportationreservationsystemfix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.belajar.transportationreservationsystemfix.entity.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}

