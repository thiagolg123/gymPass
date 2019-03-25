package br.com.gymPassTest.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.gymPassTest.contants.FileConstants;
import br.com.gymPassTest.service.ServiceFile;
import br.com.gymPassTest.service.TransformRunStatus;

public class TransformRunStatusImplTest {

	private TransformRunStatus transformRunStatus;
	private ServiceFile serviceFile;

	@Before
	public void setUp() throws Exception {
		transformRunStatus = new TransformRunStatusImpl();
		serviceFile = new ServiceFileImpl();
	}

	@Test
	public void testTransform() throws Exception {
		String contentFile = serviceFile.read(FileConstants.PATH_OF_FILE);
		String[] slitedStatus = serviceFile.split(contentFile);

		assertEquals("F.MASSA", transformRunStatus.transform(slitedStatus).get(0).getNameOfPilot());

	}

}
