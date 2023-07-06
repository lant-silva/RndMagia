package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import model.Elementos;
import model.Nome;

public class GerarMagia {
	public void getParameters(int nivel, String elementos, String classe, String rank) {
		String nomeMagia="";
		try {
			nomeMagia = gerarNome(classe, elementos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		System.out.println(nomeMagia);
		
		
		
		
		
		
		
		
		
		
	}
	
	private String gerarNome(String classe, String elementos) throws Exception{
		File arquivoE = new File(System.getProperty("user.dir")+File.separator+"data"+File.separator+"Elementos"+File.separator+elementos+".csv");
		ArrayList<String> sufixo = new ArrayList<String>();
		int tamanho;
		int rand;
		String nome="";
		
		switch(classe) {
			case "Ofensiva": tamanho = Nome.nomePrincipalOfensiva.size();
			rand = (int) (Math.random()*tamanho);
			nome = Nome.nomePrincipalOfensiva.get(rand);
				break;
			case "Defensiva": tamanho = Nome.nomePrincipalDefensiva.size();
			rand = (int) (Math.random()*tamanho);
			nome = Nome.nomePrincipalDefensiva.get(rand);
				break;
			case "Suporte": tamanho = Nome.nomePrincipalSuporte.size();
			rand = (int) (Math.random()*tamanho);
			nome = Nome.nomePrincipalSuporte.get(rand);
				break;
		}
		
		for(String index : Elementos.elemento) {			
			if(elementos.equals(index)) {
				BufferedReader leitor = new BufferedReader(new FileReader(arquivoE));
				String linha;
				while((linha = leitor.readLine())!=null) {
					sufixo.add(linha);
				}
				leitor.close();
				break;
			}
		}
		
		int tamanhoSufixo = sufixo.size();
		int randSufixo = (int) (Math.random()*tamanhoSufixo);
		nome = nome + " " + sufixo.get(randSufixo);
		
		return nome;
	}
	
}
