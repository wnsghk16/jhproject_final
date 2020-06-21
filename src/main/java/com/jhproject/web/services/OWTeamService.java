package com.jhproject.web.services;

import com.jhproject.web.owleague.OWTeamDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OWTeamService {
    public List<OWTeamDTO> retriveAll();
}
