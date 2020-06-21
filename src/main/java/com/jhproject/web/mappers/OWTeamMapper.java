package com.jhproject.web.mappers;


import com.jhproject.web.owleague.OWTeamDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OWTeamMapper {
    public List<OWTeamDTO> selectAll();
}
