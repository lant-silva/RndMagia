package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import model.Elementos;
import model.Magia;
import model.Nome;
import model.Rank;

public class GerarMagia {
	String tipo="";
	String nomeElemento="";
	String descEfeito;
	String alcance;
	String efeito;
	String rank;
	String duracao;
	File arquivoParametros = new File(System.getProperty("user.dir")+File.separator+"data", "Parametros.ini");
	public Magia getParameters(int nivel, String elementos, String classe, String rank) throws Exception{
		try { 
			tipo = gerarNome(classe);
			nomeElemento = gerarNomeElemento(elementos);
			this.rank = gerarRank(rank);
			this.duracao = gerarDuracao(nivel, rank);
			descEfeito = gerarEfeito(nivel, rank, this.efeito);
			alcance = gerarAlcance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Magia magia = new Magia(this.tipo, this.nomeElemento, nivel, elementos, classe, this.rank, rank, alcance, duracao, descEfeito, efeito);
		System.out.println(tipo+" "+nomeElemento+" | "+efeito+" | "+alcance+" | "+this.rank+ " | "+duracao+" | "+descEfeito);
		return magia;
	}
	
	public String gerarNome(String classe) throws Exception{
		
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
		
		return nome;
	}
	
	public String gerarEfeito(String classe) throws Exception{
		int tamanho;
		int rand;
		switch(classe) {
		case "Ofensiva": tamanho = Nome.efeitoPrincipalOfensiva.size();
			rand = (int) (Math.random()*tamanho);
			return Nome.efeitoPrincipalOfensiva.get(rand);
		case "Defensiva": tamanho = Nome.efeitoPrincipalDefensiva.size();
			rand = (int) (Math.random()*tamanho);
			return Nome.efeitoPrincipalDefensiva.get(rand);
		case "Suporte": tamanho = Nome.efeitoPrincipalSuporte.size();
			rand = (int) (Math.random()*tamanho);
			return Nome.efeitoPrincipalSuporte.get(rand);
		}
		return "";
	}
	
	public String gerarNomeElemento(String elemento) throws Exception{
		ArrayList<String> sufixo = new ArrayList<String>();
		File arquivoE = new File(System.getProperty("user.dir")+File.separator+"data"+File.separator+"Elementos"+File.separator+elemento+".csv");
		for(String index : Elementos.elemento) {			
			if(elemento.equals(index)) {
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
		return sufixo.get(randSufixo);
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
		int modMin=0;
		int modMax=0;
		int mod=0;
		int escolhaRand = (int) (Math.random()*6);
		switch(rank) {
			case "C": modMin=Rank.duracaoRanks.get(0);modMax=Rank.duracaoRanks.get(1);
				break;
			case "B": modMin=Rank.duracaoRanks.get(2);modMax=Rank.duracaoRanks.get(3);
				break;
			case "A": modMin=Rank.duracaoRanks.get(4);modMax=Rank.duracaoRanks.get(5);
				break;
			case "S": modMin=Rank.duracaoRanks.get(6);modMax=Rank.duracaoRanks.get(7);
				break;
			case "SS": modMin=Rank.duracaoRanks.get(8);modMax=Rank.duracaoRanks.get(9);
				break;
		}
		
		int formula = ((1+(mod = (int)((Math.random()*modMax)+modMin)))*nivel)/2;
		if(formula<=0 || escolhaRand<=2) {
			int rand = (int)(Math.random()*3);
			String[] um = {"Sustentada","Reflexo(Uso instantâneo)","Cena"};
			return um[rand];
		}else if(formula>20){
			int rand = (int)(Math.random()*6);
			String[] um = {"20 Rodadas", "Um dia", "Uma semana","20 Rodadas","Um dia","Uma semana"};
			return um[rand];
		}else {	
			String dur = Integer.toString(formula) + " Rodadas";
			return dur;
		}
	}
	
	public String gerarEfeito(int nivel, String rank, String efeito) {
		String nomeEfeito="";
		String principal="";
		String dados="";
		int modMin=0;
		int modMax=0;
		int mod=0;
		int formula=0;
		
		switch(rank) {
		case "C": modMin=Rank.efeitoRanks.get(0);modMax=Rank.efeitoRanks.get(1);
			break;
		case "B": modMin=Rank.efeitoRanks.get(2);modMax=Rank.efeitoRanks.get(3);
			break;
		case "A": modMin=Rank.efeitoRanks.get(4);modMax=Rank.efeitoRanks.get(5);
			break;
		case "S": modMin=Rank.efeitoRanks.get(6);modMax=Rank.efeitoRanks.get(7);
			break;
		case "SS":modMin=Rank.efeitoRanks.get(8);modMax=Rank.efeitoRanks.get(9);
			break;
	}
		
		mod = (int)(Math.random()*modMax)+modMin;
		
		switch(efeito) {
		case "Ataque": formula = (1+mod)*nivel;
			principal = Integer.toString(formula);
			dados = Integer.toString((int)(Math.random()*nivel)+1);
			int auxAtaque = Integer.parseInt(dados);
			if(auxAtaque>6) {
				dados = "6";
			}
			nomeEfeito = dados+"d"+principal+" de Dano"; 
			break;
			
		case "Conjuração": formula = (1+mod)*nivel;
			principal = Integer.toString(formula);
			dados = Integer.toString((int)(Math.random()*nivel)+1);
			int auxConjuracao = Integer.parseInt(dados);
			if(auxConjuracao>8) {
				dados = "8";
			}
			nomeEfeito = dados+"d"+principal+" de Dano";
			break;
			
		case "Defesa": formula = ((1+mod)*nivel+2)/2;
			principal = Integer.toString(formula);
			dados = Integer.toString((int)(Math.random()*nivel)+2);
			int auxDefesa = Integer.parseInt(dados);
			if(auxDefesa>5) {
				dados = "5";
			}
			nomeEfeito = dados+"d"+principal+" de Proteção";
			break;
			
		case "Inibição": formula = ((1+mod)*nivel)/2;
			principal = Integer.toString(formula);
			dados = Integer.toString((int)(Math.random()*nivel)/2);
			int auxInibicao = Integer.parseInt(dados);
			if(auxInibicao>3) {
				dados = "3";
			}
			nomeEfeito = dados+"d"+principal+" de Duração";
			break;
			
		case "Restauração": formula = ((1+mod)*(nivel-2));
			if(formula<1) {
				formula = 1;
			}
			principal = Integer.toString(formula);
			dados = Integer.toString((int)(Math.random()*nivel)+2);
			int auxRestauracao = Integer.parseInt(dados);
			if(auxRestauracao>8) {
				dados = "8";
			}
			nomeEfeito = dados+"d"+principal+" de Restauração";
			break;
		
		case "Bonificação": formula = ((1+mod)*nivel+2);
			principal = Integer.toString(formula);
			dados = Integer.toString((int)(Math.random()*nivel)+1);
			int auxBonificacao = Integer.parseInt(dados);
			if(auxBonificacao>6) {
				dados = "6";
			}
			nomeEfeito = dados+"d"+principal+" de Reforço";
			break;
			
		}
		return nomeEfeito;
	}          
	
	public String gerarAlcance() throws Exception{
		ArrayList<String> alcances = new ArrayList<String>();
		BufferedReader leitorAlcances = new BufferedReader(new FileReader(arquivoParametros));
		String linhaLeitor;
		while((linhaLeitor = leitorAlcances.readLine())!=null) {
			if(linhaLeitor.contains("#")) {
				
			}else if(linhaLeitor.contains("reach")) {
				String[] sep = linhaLeitor.split("=");
				alcances.add(sep[1]);
			}
		}
		leitorAlcances.close();
		
		int tam = alcances.size();
		return alcances.get((int)(Math.random()*tam));
	}
}
