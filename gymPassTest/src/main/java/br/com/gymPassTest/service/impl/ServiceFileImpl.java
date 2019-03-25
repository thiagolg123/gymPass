package br.com.gymPassTest.service.impl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.com.gymPassTest.service.ServiceFile;

public class ServiceFileImpl extends ServiceFile {

	@Override
	public String read(String pathname) {
		byte[] byts = null;
		Charset encod = StandardCharsets.UTF_8;
		try {
			byts = Files.readAllBytes(Paths.get(pathname));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encod.decode(ByteBuffer.wrap(byts)).toString();
	}
}
