import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class AudioFiles {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("jora.txt");

		double[] result = null;

		try {
			File file = new File("jora.pcm");
			InputStream in = new FileInputStream(file);
			int bufferSize = (int) (file.length() / 2);

			result = new double[bufferSize];

			DataInputStream is = new DataInputStream(in);

			for (int i = 0; i < bufferSize; i++) {
				result[i] = is.readShort() / 32768.0;
			}

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < result.length; i++) {
			for (int z = 0; z < 10; z++) {
				fw.write(result[i] + "\n");
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
		// return result;
	}

}