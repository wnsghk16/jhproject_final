package com.jhproject.web.owleague;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OWPlayerRepository extends JpaRepository<OWPlayer,Long> {
    public OWPlayer findByTeam(String team);
}
