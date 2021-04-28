package com.jadper.team;

import com.jadper.team.model.Team;

import org.junit.jupiter.api.Test;


class TeamTests {

	@Test
	void createTeamAndSetName() {
		String teamName = "Boll Noll Koll";
		Team t = new Team();
		t.setName(teamName);
		assert(t.getName()==teamName);
	}


}

