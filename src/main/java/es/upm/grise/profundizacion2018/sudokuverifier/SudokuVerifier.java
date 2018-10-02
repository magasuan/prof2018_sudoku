package es.upm.grise.profundizacion2018.sudokuverifier;

//import java.util.Arrays;

public class SudokuVerifier 
{
	public static int verify (String candidateSolution) 
	{
		String [] rows;
		String [] columns;
		String[] str = new String[9];
		int[][] matriz = new int[9][9];
		char[] numb_row;
		// Checking first Rule #1 
		if(candidateSolution.length()!=81) {
			return -1;
		}
		//		if (isNumeric(candidateSolution) != true) {
		//			return -1;
		//		}
		columns = getColumns(candidateSolution,str);
		rows = getRows(candidateSolution,str);
		int rule_1 = validateRule1(columns,rows);
		if (rule_1 == -1) {
			return -1;
		}

		//Checking second Rule #2
		// Creating matriz 
		for(int i = 0; i < 9;i++) {
			numb_row = rows[i].toCharArray();
			for(int j=0; j<9; j++) {
				matriz[i][j] = Character.getNumericValue(numb_row[j]);
			}
		}
		int [][] submat = new int[3][3];
		for (int i = 0; i < 9; i=i+3) {
			for (int j = 0; j < 9; j=j+3) {
				for (int j2 = 0; j2 < 3; j2++) {
					for (int k = 0; k < 3; k++) {
						submat[j2][k] = matriz[i+j2][j+k];
					}
				}
				int rule_2 = validateRule2(submat);
				if(rule_2 == -1) {
					return -2;
				}else {
					submat = new int[3][3];
				}
			}

		}		
		//Checking third Rule #3	
		int rule_3 = validateRule3_4(rows);
		if(rule_3 == -1) {
			return -3;
		}
		//Checking fourth Rule #4
		int rule_4 = validateRule3_4(columns);
		if(rule_4 == -1) {
			return -4;
		}
		return 0;
	}

	private static int validateRule3_4(String[] mat) {
		// TODO Auto-generated method stub
		int res = 0;
		char[] arrayCh;
		int[] arrayNum;
		for (int i = 0; i < mat.length; i++) {
			arrayCh = mat[i].toCharArray();
			arrayNum = new int[9];
			for (int j = 0; j < arrayNum.length; j++) {
				arrayNum[j] = Character.getNumericValue(arrayCh[j]);
			}
			for (int j2 = 0; j2 < arrayNum.length-1; j2++) {
				for (int k = j2+1; k < arrayNum.length; k++) {
					if(arrayNum[j2] == arrayNum[k]) {
						res= -1;
					}
				}
			}
		}
		return res;
	}

	private static int validateRule2(int[][] submat) {
		// TODO Auto-generated method stub
		int[] array = new int[9];
		int res = 0;
		int cont = 0;
		int tam = array.length;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				array[cont] = submat[i][j];
				cont ++;
			}
		}
		for (int i = 0; i < tam-1; i++) {
			for (int j = i+1; j < tam; j++) {
				if(array[i] == array[j]) {
					res = -1;
				}
			}
		}
		return res;
	}

	private static int validateRule1(String[] columns, String[] rows) {

		// TODO Auto-generated method stub
		char[] row;
		int res = 0;
		for(int i = 0; i<rows.length;i++) {
			row = rows[i].toCharArray();
			for(int j = 0; j< row.length;j++) {
				if(Character.getNumericValue(row[j]) < 1 || Character.getNumericValue(row[j]) > 9) {
					res = -1;
				}else {

				}
			}
		}
		return res;
	}

	public static boolean isNumeric(String cadena) {

		boolean resultado;

		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

	// This method returns the rows in a String
	static String[] getRows(String candidateSolution, String[] str) {
		// TODO Auto-generated method stub
		int first = 0;
		int last = 9;
		String row_str;

		for(int i=0;i<9;i++, first = first+9,last = last+=9) {
			row_str = candidateSolution.substring(first,last);
			str[i] = row_str;
		}
		return str;
	}
	private static String[] getColumns(String candidateSolution, String[] str) {
		// TODO Auto-generated method stub
		int columns = 0;
		boolean first = true;
		int tam = candidateSolution.length();
		char[] toChar = candidateSolution.toCharArray();
		int number;
		for(int i=0; i<tam;i++, columns++)
		{
			//Reset
			if(columns == 9) {
				columns = 0;
				first = false;
			}
			number = Character.getNumericValue(toChar[i]);
			if(first) {
				str[columns] = "" + String.valueOf(number);
			}else {
				str[columns] += String.valueOf(number);
			}
		}

		return str;

	}
}
