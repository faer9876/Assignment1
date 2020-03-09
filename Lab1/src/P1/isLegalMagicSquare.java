package P1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class isLegalMagicSquare {

	private static final String FileName = null;

	public static boolean main(String[] args) throws FileNotFoundException, IOException {
		int linenumber = 0; int columnnumber = 0;
		try (FileReader reader = new FileReader("src/isLegalMagicSquare.P1/txt" + NameofFile);
				BufferedReader br = new BufferedReader(reader)) {
					String line;
					int i,j,k;
					i=0;
					j=0;
					k=0;
					
					while ((line = br.readLine()) != null) {
						j++;
						String[] word = line.split("\t");
						i = word.length;
						if(k<=1)
							k=i;
					}
					linenumber = j;
					columnnumber = k;
				}
				System.out.println(FileName + "linenumber" + "," + "columnnumber" );
				if (linenumber != columnnumber) {
					System.out.println("is not correct");
					return false;
				}
				
				int matrix[][] = new int [linenumber][columnnumber];
				int[] and = new int [linenumber + columnnumber + 2];
				
				String fileName = null;
				try (FileReader reader = new FileReader("src/isLegalMagicSquare.P1/txt" + fileName);
						BufferedReader br = new BufferedReader(reader)) {
					String line;
					int i,j,k;
					j=0;
					i = 0;
					while ((line = br.readLine()) != null) {
						String[] word = line.split("\t");
						for (i = 0; i < word.length; i++) {
							for (k = word[i].length(); --k >= 0;) {
								if (!Character.isDigit(word[i].charAt(k))) {
									System.out.println("");
									return false;
								}
							}
							matrix[j][i] = Integer.valueOf(word[i]);
						}
						j++;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				for (int m = 0; m < linenumber; m++) {
					for (int n = 0; n < columnnumber; n++) {
						if (matrix[m][n] == 0) {
							System.out.println("defalut"); 
							return false;
						}
						

					}
					
				}

				for (int m = 0; m < linenumber; m++) {
					int c = 0;
					for (int n = 0; n < columnnumber; n++) { 
						c = c + matrix[m][n];
					}
					and[m] = c;
				}

				for (int m = 0; m < columnnumber; m++) {
					int c = 0;
					for (int n = 0; n < linenumber; n++) { 
						c = c + matrix[n][m];
					}
					and[m + linenumber] = c;
				}

				int d = 0, p = 0;
				for (int m = 0; m < linenumber; m++) {
					d = d + matrix[m][m];
					p = p + matrix[m][columnnumber - m - 1];
				}
				and[linenumber + columnnumber] = d;
				and[linenumber + columnnumber + 1] = p;

				for (int q = 1; q < linenumber + columnnumber + 2; q++) {
					if (and[0] != and[q]) {
						System.out.println("defalut");
						return false;
					}
				}
				System.out.println("correct" + and[0]);
				return true;
					
				}
				
		// TODO Auto-generated method stub

	}