package services;

import java.io.File;

public class BuscadorDeTxt implements BuscadorDeArquivo {

	@Override
	public File getFile(String pathName) {
		return new File(pathName);
	}

}
