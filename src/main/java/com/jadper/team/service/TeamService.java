package com.jadper.team.service;

import com.jadper.team.model.Team;
import com.jadper.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    public List<Team> listTeams() {
        return teamRepository.findAll();
    }

    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    public Team getTeam(Integer id) {
        return teamRepository.findById(id).get();
    }

    public boolean deleteTeam(Integer id) {
        try { 
            teamRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }   
    }

    public void updateTeam(Map<String, Object> updates, Integer id){
        //pick out attributes for save
        Team t = teamRepository.findById(id).get();	

        if (updates.containsKey("name")){
            t.setName(updates.get("name").toString() );    
        }

        teamRepository.save(t);
    }

}
