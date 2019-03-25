package br.com.gymPassTest.service;

public abstract class ServiceFile {

	/**
	 * read file from path
	 * 
	 * @param pathname path of file
	 * @return file
	 */
	public abstract String read(String pathname);

	/**
	 * @return return log "slipt in(\r\n)"
	 */
	public String[] split(String log) {
		return log.split("\r\n");
	}
}
