package com.jhproject.web.serviceImpls;

import com.jhproject.web.mappers.OWTeamMapper;
import com.jhproject.web.owleague.OWTeamDTO;
import com.jhproject.web.services.OWTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OWTeamServiceImpl implements OWTeamService {
    @Autowired
    OWTeamMapper owTeamMapper;

    @Override
    public List<OWTeamDTO> retriveAll() {
        return owTeamMapper.selectAll();
    }
}
