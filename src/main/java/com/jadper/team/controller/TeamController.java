package com.jadper.team.controller;

import com.jadper.team.model.Team;
import com.jadper.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
// @RequestMapping("")
public class TeamController {

    @Autowired
    TeamService teamService;




    @GetMapping("/teams")
    public List<Team> list() {
        return teamService.listTeams();
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<Team> get(@PathVariable Integer id) {
        try {
            Team team = teamService.getTeam(id);
            return new ResponseEntity<Team>(team, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/team")
    public ResponseEntity<?> add(@RequestBody Team team) {        
        teamService.saveTeam(team);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/team/{id}") // replace team
    public ResponseEntity<?> update(@RequestBody Team team, @PathVariable Integer id) {
        try {            
            teamService.getTeam(id);
            teamService.saveTeam(team);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/team/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {            
            teamService.getTeam(id);
            teamService.deleteTeam(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    
    @PatchMapping(value = "/team/{id}")  
    public ResponseEntity<?> partialUpdateGeneric(
        @RequestBody Map<String, Object> updates,
        @PathVariable("id") Integer id) {
        try {            
            teamService.updateTeam(updates, id);
            // get team by id and return for easy confirm
            Team p = teamService.getTeam(id);
            return new ResponseEntity<Team>(p, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}




