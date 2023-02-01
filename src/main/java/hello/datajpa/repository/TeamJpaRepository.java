package hello.datajpa.repository;

import hello.datajpa.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeamJpaRepository {

    @PersistenceContext
    EntityManager em;

    public Team save(Team team) {
        em.persist(team);
        return team;
    }

    public void delete(Team team) {
        em.remove(team);
    }

    public List<Team> findAll(){
        return em.createQuery("select t FROM Team t", Team.class)
                .getResultList();
    }

    public Optional<Team> findByID(Long id){
        Team Team = em.find(Team.class, id);
        return Optional.ofNullable(Team);
    }

    public long count() {
        return em.createQuery("select count(t) from Team t", Long.class)
                .getSingleResult();
    }
    public Team find(Long id) {
        return em.find(Team.class, id);
    }
}
