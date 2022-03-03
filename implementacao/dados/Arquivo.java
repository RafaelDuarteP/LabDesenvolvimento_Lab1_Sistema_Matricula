package dados;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Arquivo<E> {

	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public Arquivo(String nomeArquivo) throws IOException {
		file = new File(nomeArquivo);
		fos = new FileOutputStream(file, true);
		outputFile = new ObjectOutputStream(fos);

	}

	@SuppressWarnings("unchecked")
	public List<E> recuperarDados() {
		List<E> list = new ArrayList<>();
		try (ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(file))) {
			E p;
			p = (E) inputFile.readObject();
			while (p != null) {
				list.add(p);
				p = (E) inputFile.readObject();
			}

		} catch (EOFException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace(System.err);
		}

		return list;
	}

	public void salvar(List<E> list) {

		try {
			close();

			fos = new FileOutputStream(file, true);
			outputFile = new ObjectOutputStream(fos);

			for (E E : list) {
				outputFile.writeObject(E);
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}

	}

	public void close() throws IOException {
		outputFile.close();
		fos.close();
	}

	protected void finalize() throws Throwable {
		this.close();
	}

}
