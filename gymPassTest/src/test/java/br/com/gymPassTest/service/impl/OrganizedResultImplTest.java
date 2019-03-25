package br.com.gymPassTest.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.gymPassTest.contants.FileConstants;
import br.com.gymPassTest.service.OrganizedResult;
import br.com.gymPassTest.service.ServiceFile;
import br.com.gymPassTest.service.TransformRunStatus;
import br.com.gymPassTest.vo.RacingStatus;

public class OrganizedResultImplTest {

	private OrganizedResult organizedResult;
	private ServiceFile serviceFile;
	TransformRunStatus transformRunStatus;

	@Before
	public void setUp() throws Exception {
		organizedResult = new OrganizedResultImpl();
		serviceFile = new ServiceFileImpl();
		transformRunStatus = new TransformRunStatusImpl();
	}

	@Test
	public void testOrganizeAsList() throws Exception {
		String contentFile = serviceFile.read(FileConstants.PATH_OF_FILE);
		String[] slitedStatus = serviceFile.split(contentFile);

		List<RacingStatus> listRunStatus = transformRunStatus.transform(slitedStatus);
		// errado no log ess MASS lol
		assertEquals(organizedResult.organizeAsList(listRunStatus).get(0).getPilotName(), "F.MASS");

	}

}
