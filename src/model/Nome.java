package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Nome {
	public static ArrayList<String> nomePrincipalOfensiva = new ArrayList<String>(); // O nome principal para magias de classe ofensiva
	public static ArrayList<String> efeitoPrincipalOfensiva = new ArrayList<String>();
	public static ArrayList<String> nomePrincipalDefensiva = new ArrayList<String>();
	public static ArrayList<String> efeitoPrincipalDefensiva = new ArrayList<String>();
	public static ArrayList<String> nomePrincipalSuporte = new ArrayList<String>();
	public static ArrayList<String> efeitoPrincipalSuporte = new ArrayList<String>();
	
	File arquivoPrincipalOfensiva = new File(System.getProperty("user.dir")+File.separator+"data", "NomePrincipalOfensiva.csv");
	File arquivoPrincipalDefensiva = new File(System.getProperty("user.dir")+File.separator+"data", "NomePrincipalDefensiva.csv");
	File arquivoPrincipalSuporte = new File(System.getProperty("user.dir")+File.separator+"data", "NomePrincipalSuporte.csv");
	
	public void update() throws Exception{
		gerarPrincipalOfensiva();
		gerarPrincipalDefensiva();
		gerarPrincipalSuporte();
	}
	
	
	public void gerarPrincipalOfensiva() throws Exception{		
		BufferedReader leitor = new BufferedReader(new FileReader(arquivoPrincipalOfensiva));
		String linha;
		while((linha = leitor.readLine())!=null) {
			String[] sep = linha.split(";");
			nomePrincipalOfensiva.add(sep[0]);
			efeitoPrincipalOfensiva.add(sep[1]);
		}
		leitor.close();
	}
	
	public void gerarPrincipalDefensiva() throws Exception{
		BufferedReader leitor = new BufferedReader(new FileReader(arquivoPrincipalDefensiva));
		String linha;
		while((linha = leitor.readLine())!=null) {
			String[] sep = linha.split(";");
			nomePrincipalDefensiva.add(sep[0]);
			efeitoPrincipalDefensiva.add(sep[1]);
		}
		leitor.close();
	}
	
	public void gerarPrincipalSuporte() throws Exception{
		BufferedReader leitor = new BufferedReader(new FileReader(arquivoPrincipalSuporte));
		String linha;
		while((linha = leitor.readLine())!=null) {
			String[] sep = linha.split(";");
			nomePrincipalSuporte.add(sep[0]);
			efeitoPrincipalSuporte.add(sep[1]);
		}
		leitor.close();
	}
	
	
}
