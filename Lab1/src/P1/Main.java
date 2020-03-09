package P1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int n = 0;
		int magic[][] = new int[n][n];
		int row = 0, col = n / 2, i, j, square = n * n;

		for (i = 1; i <= square; i++) {
			magic[row][col] = i;
			if (i % n == 0) 
				row++;
			else {
				if (row == 0)
					row = n - 1;
				else
					row--;
				if (col == (n - 1))
					col = 0;
				else
					col++; 
			}
		}
		File file = new File("src/P1/txt.txt");
		Writer er = new FileWriter(file);
		er.close();
		Writer out = new FileWriter(file, true);

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(magic[i][j]);
				int data = magic[i][j];
				out.write(data);
			}
			System.out.println();
			out.write("\n");
		}
		out.close();
	}
}