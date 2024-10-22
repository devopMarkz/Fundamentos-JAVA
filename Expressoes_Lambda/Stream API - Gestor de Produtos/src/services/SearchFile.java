package services;

import java.io.File;

public class SearchFile implements SearchFileService {

	@Override
	public File getFile(String pathName) {
		return new File(pathName);
	}

}
