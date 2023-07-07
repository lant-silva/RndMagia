package model;
public class Magia {
	String tipo;
	String nomeElemento;
	String nome = tipo + " " + nomeElemento;
	int nivel;
	String elemento;
	String classe;
	String rank;
	String nomeRank;
	String alcance;
	String duracao;
	String efeito;
	String efeitoClasse;
	String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getEfeitoClasse() {
		return efeitoClasse;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNome() {
		return tipo + " " + nomeElemento;
	}
	
	public String getNomeElemento() {
		return nomeElemento;
	}

	public void setNomeElemento(String nomeElemento) {
		this.nomeElemento = nomeElemento;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getNomeRank() {
		return nomeRank;
	}

	public void setNomeRank(String nomeRank) {
		this.nomeRank = nomeRank;
	}

	public String getAlcance() {
		return alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getEfeito() {
		return efeito;
	}

	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}

	public Magia(String tipo, String nomeElemento, int nivel, String elemento, String classe, String rank, String nomeRank, String alcance,
			String duracao, String efeito, String efeitoClasse) {
		super();
		this.tipo = tipo;
		this.nomeElemento = nomeElemento;
		this.nome = this.tipo+" "+this.nomeElemento;
		this.nivel = nivel;
		this.elemento = elemento;
		this.classe = classe;
		this.rank = rank;
		this.nomeRank = nomeRank;
		this.alcance = alcance;
		this.duracao = duracao;
		this.efeito = efeito;
		this.efeitoClasse = efeitoClasse;
	}

	public String salvarTexto() {
		return "===========[Magia criada com o RndMagia]===========\n"
			 + "Nome: "+nome+" | Rank: "+nomeRank+"("+rank+") | Nível: "+Integer.toString(nivel)+"\n"
			 + "Classe: "+classe+" | Elemento: "+elemento+"\n"
			 + "Alcance: "+alcance+" | Duração: "+duracao+" | Efeito: "+efeito+"\n"
			 + "Descrição: "+descricao;
	}
}
