package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Rank {
	public static String[] rank = {"C","B","A","S","SS"};
	public static ArrayList<Integer> duracaoRanks = new ArrayList<Integer>();
	public static ArrayList<Integer> efeitoRanks = new ArrayList<Integer>();
	File arquivo = new File(System.getProperty("user.dir")+File.separator+"data", "Parametros.ini");
	
	public void updateRanks() throws Exception{
		BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
		String linha;
		
		while((linha = leitor.readLine())!=null) {
			if(linha.substring(0)=="#"){
				break;
			}
			if(linha.contains("duration")){
				linha = linha.replaceAll("[^0-9]", "");
				duracaoRanks.add(Integer.parseInt(linha));
			}
			if(linha.contains("effect")) {
				linha = linha.replaceAll("[^0-9]", "");
				efeitoRanks.add(Integer.parseInt(linha));
			}
		}
		leitor.close();
	}
}
