package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import model.Elementos;
import model.Nome;
import model.Rank;

public class GerarMagia {
	String nomeMagia="";
	String alcance;
	String efeito;
	String rank;
	String duracao;
	public void getParameters(int nivel, String elementos, String classe, String rank) {
		try { 
			nomeMagia = gerarNome(classe, elementos);
			this.rank = gerarRank(rank);
			this.duracao = gerarDuracao(nivel, rank);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] alc = {"Singular", "Multiplos alvos", "Em área"};
		int tam = alc.length;
		alcance = alc[(int)(Math.random()*tam)];
		
		System.out.println(nomeMagia+" | "+efeito+" | "+alcance+" | "+this.rank+ " | "+duracao);
	}
	
	private String gerarNome(String classe, String elementos) throws Exception{
		File arquivoE = new File(System.getProperty("user.dir")+File.separator+"data"+File.separator+"Elementos"+File.separator+elementos+".csv");
		ArrayList<String> sufixo = new ArrayList<String>();
		int tamanho;
		String nome="";
		int rand;
		switch(classe) {
			case "Ofensiva": tamanho = Nome.nomePrincipalOfensiva.size();
			rand = (int) (Math.random()*tamanho);
			nome = Nome.nomePrincipalOfensiva.get(rand);
			efeito = Nome.efeitoPrincipalOfensiva.get(rand);
				break;
			case "Defensiva": tamanho = Nome.nomePrincipalDefensiva.size();
			rand = (int) (Math.random()*tamanho);
			nome = Nome.nomePrincipalDefensiva.get(rand);
			efeito = Nome.efeitoPrincipalDefensiva.get(rand);
				break;
			case "Suporte": tamanho = Nome.nomePrincipalSuporte.size();
			rand = (int) (Math.random()*tamanho);
			nome = Nome.nomePrincipalSuporte.get(rand);
			efeito = Nome.efeitoPrincipalSuporte.get(rand);
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
	
	public String gerarRank(String rank) throws Exception{
		ArrayList<String> nomeRank = new ArrayList<String>();
		File arquivo = new File(System.getProperty("user.dir")+File.separator+"data"+File.separator+"Rank", rank+".csv");
		
		for(String index : Rank.rank) {
			if(rank.equals(index)) {
				BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
				String linha;
				while((linha = leitor.readLine())!=null) {
					nomeRank.add(linha);
				}
				leitor.close();
				break;
			}
		}
		
		int tamanhoRank = nomeRank.size();
		int randRank = (int) (Math.random()*tamanhoRank);
		return nomeRank.get(randRank);
	}
	
	public String gerarDuracao(int nivel, String rank) {
		int mod=0;
		int escolhaRand = (int) (Math.random()*4);
		switch(rank) {
			case "C": mod=1;
				break;
			case "B": mod=2;
				break;
			case "A": mod=3;
				break;
			case "S": mod=5;
				break;
			case "SS": mod=8;
				break;
		}
		
		int formula = ((1+mod)*nivel)/2;
		if(formula<=0 || escolhaRand<2) {
			int rand = (int)(Math.random()*3);
			String[] um = {"Sustentada","Reflexo(Uso instantâneo)","Cena"};
			return um[rand];
		}else if(formula>20){
			int rand = (int)(Math.random()*3);
			String[] um = {"20 Rodadas", "Um dia", "Uma semana"};
			return um[rand];
		}else {	
			String dur = Integer.toString(formula) + " Rodadas";
			return dur;
		}
	}
}
