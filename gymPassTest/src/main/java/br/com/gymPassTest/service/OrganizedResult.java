package br.com.gymPassTest.service;

import java.util.List;

import br.com.gymPassTest.vo.RacingResult;
import br.com.gymPassTest.vo.RacingStatus;

public interface OrganizedResult {

	public List<RacingResult> organizeAsList(List<RacingStatus> listRunStatus);
}
