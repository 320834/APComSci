package characterMaker;

import java.util.ArrayList;

public class Test {
	//Run Config : "${string_prompt}"
	public static void main(String[] args) {
		AA_320951 chara = new AA_320951();
		ArrayList<char[][]> toPrint = new ArrayList<char[][]>();
		for(int z = 0; z < args[0].length(); z++)
				if(chara.characterSupported(args[0].toUpperCase().charAt(z)))
					toPrint.add(chara.characterToAscii(args[0].toUpperCase().charAt(z)));
		
		for(int r = 0; r < 10; r++){
			for(int i = 0; i < toPrint.size(); i++){
				for(int c = 0; c < 10; c++){
					System.out.print(toPrint.get(i)[r][c]);
				}
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}

