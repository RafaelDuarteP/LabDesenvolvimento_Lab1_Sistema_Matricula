package dados;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
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

		List<E> lista = new LinkedList<>();
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
			E c = (E) input.readObject();
			while (c != null) {
				lista.add(c);
				c = (E) input.readObject();
			}
//			lista = (List<E>) input.readObject();
		} catch (EOFException e) {
		} catch (IOException| ClassNotFoundException e) {
		}

		return lista;

	}

	public void salvar(List<E> list) {
		try {

			fos = new FileOutputStream(file);
			outputFile = new ObjectOutputStream(fos);

			for (E e : list) {
				outputFile.writeObject(e);
			}
		} catch (IOException e) {
		}
//		try {
//			outputFile.writeObject(list);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	public void close() throws IOException {
		outputFile.close();
		fos.close();
	}

	protected void finalize() throws Throwable {
		this.close();
	}

}
