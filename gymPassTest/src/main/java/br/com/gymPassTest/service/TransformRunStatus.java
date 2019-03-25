package br.com.gymPassTest.service;

import java.util.List;

import br.com.gymPassTest.vo.RacingStatus;

public interface TransformRunStatus {

	/**
	 * Transform array of String in a object of RunStatus;
	 * 
	 * @param slitedStatus
	 * @return {@link RacingStatus}
	 */
	public List<RacingStatus> transform(String[] slitedStatus);
}
