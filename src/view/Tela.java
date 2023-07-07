package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.GerarMagia;
import model.Classes;
import model.Elementos;
import model.Magia;
import model.Nome;
import model.Rank;

public class Tela {
	
	private GerarMagia gerar = new GerarMagia();
	private JFrame frmGeradorDeMagias;
	private JTextField txtNivel;
	private Magia magiaGerada;
	private JTextField txtRankFundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
					window.frmGeradorDeMagias.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeradorDeMagias = new JFrame();
		frmGeradorDeMagias.setResizable(false);
		frmGeradorDeMagias.setTitle("RndMagia");
		frmGeradorDeMagias.setBounds(100, 100, 730, 700);
		frmGeradorDeMagias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeradorDeMagias.getContentPane().setLayout(null);
		
		Nome nome = new Nome();
		Rank updateRank = new Rank();
		
		try {
			nome.update();
			updateRank.updateRanks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel principal = new JPanel();
		principal.setBorder(new LineBorder(new Color(0, 0, 0)));
		principal.setBounds(12, 12, 397, 287);
		frmGeradorDeMagias.getContentPane().add(principal);
		principal.setLayout(null);
		
		JLabel lblNivel = new JLabel("Nível da magia:");
		lblNivel.setBounds(12, 12, 93, 15);
		principal.add(lblNivel);
		
		txtNivel = new JTextField();

		txtNivel.setBounds(103, 10, 48, 19);
		principal.add(txtNivel);
		txtNivel.setColumns(10);
		
		JLabel lblElementosAleatrios = new JLabel("Elementos Aleatórios");
		lblElementosAleatrios.setBounds(12, 44, 129, 15);
		principal.add(lblElementosAleatrios);
		
		JRadioButton rdbtnElementosAleatorios = new JRadioButton("");
		rdbtnElementosAleatorios.setToolTipText("Faz a escolha aleatoria de um dos elementos disponíveis");

		

		
		rdbtnElementosAleatorios.setBounds(133, 40, 21, 23);
		principal.add(rdbtnElementosAleatorios);
		
		JPanel listaElementos = new JPanel();
		listaElementos.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaElementos.setBounds(12, 71, 372, 75);
		principal.add(listaElementos);
		listaElementos.setLayout(null);
		
		JRadioButton rdbtnFogo = new JRadioButton("Fogo");
		rdbtnFogo.setToolTipText("Magias de fogo possuem um efeito flamejante que incinera seus alvos");
		rdbtnFogo.setBounds(12, 8, 82, 23);
		rdbtnFogo.setActionCommand("Fogo");
		listaElementos.add(rdbtnFogo);
		
		JRadioButton rdbtnGelo = new JRadioButton("Gelo");
		rdbtnGelo.setToolTipText("Magias de gelo possuem um fator congelante, capaz de interromper seus alvos");
		rdbtnGelo.setBounds(12, 28, 82, 23);
		rdbtnGelo.setActionCommand("Gelo");
		listaElementos.add(rdbtnGelo);
		
		JRadioButton rdbtnEletrico = new JRadioButton("Elétrico");
		rdbtnEletrico.setToolTipText("Magias elétricas tem um foco eletrizante, capaz de atingir vários alvos, e imobilizá-los");
		rdbtnEletrico.setBounds(12, 45, 82, 23);
		rdbtnEletrico.setActionCommand("Elétrico");
		listaElementos.add(rdbtnEletrico);
		
		JRadioButton rdbtnNatureza = new JRadioButton("Natureza");
		rdbtnNatureza.setToolTipText("Magias da natureza tem um aspecto natural, vindo da terra e das criaturas naturais");
		rdbtnNatureza.setBounds(91, 8, 82, 23);
		rdbtnNatureza.setActionCommand("Natureza");
		listaElementos.add(rdbtnNatureza);
		
		JRadioButton rdbtnMorte = new JRadioButton("Morte");
		rdbtnMorte.setToolTipText("Magias da morte possuem um toque mortal, capaz de nulificar alvos com o poder da morte");
		rdbtnMorte.setBounds(91, 28, 82, 23);
		rdbtnMorte.setActionCommand("Morte");
		listaElementos.add(rdbtnMorte);
		
		JRadioButton rdbtnEtereo = new JRadioButton("Etéreo");
		rdbtnEtereo.setToolTipText("Magias etéreas possuem um ar de divindade e um ar fantasmagórico, algo do além");
		rdbtnEtereo.setBounds(91, 45, 82, 23);
		rdbtnEtereo.setActionCommand("Etéreo");
		listaElementos.add(rdbtnEtereo);
		
		JRadioButton rdbtnAgua = new JRadioButton("Água");
		rdbtnAgua.setToolTipText("Magias aquáticas possuem um toque relaxante, molhado e refrescante, mas que também podem causar estragos a seus alvos");
		rdbtnAgua.setBounds(177, 8, 95, 23);
		rdbtnAgua.setActionCommand("Água");
		listaElementos.add(rdbtnAgua);
		
		JRadioButton rdbtnVento = new JRadioButton("Vento");
		rdbtnVento.setToolTipText("Magias de vento são ágeis, velozes, possuem uma brisa intrigante que podem causar estragos a seus alvos");
		rdbtnVento.setBounds(177, 28, 95, 23);
		rdbtnVento.setActionCommand("Vento");
		listaElementos.add(rdbtnVento);
		
		JRadioButton rdbtnImaginario = new JRadioButton("Imaginário");
		rdbtnImaginario.setToolTipText("Magias imaginárias são especiais, possuem o poder de criar e destruir de formas inimagináveis");
		rdbtnImaginario.setBounds(177, 45, 95, 23);
		rdbtnImaginario.setActionCommand("Imaginário");
		listaElementos.add(rdbtnImaginario);
		
		JRadioButton rdbtnFeerico = new JRadioButton("Feérico");
		rdbtnFeerico.setToolTipText("Magias feéricas tem um toque de fada, de espiritos carismáticos que podem enganar e enfeitiçar seus alvos");
		rdbtnFeerico.setBounds(276, 8, 86, 23);
		rdbtnFeerico.setActionCommand("Feérico");
		listaElementos.add(rdbtnFeerico);
		
		JRadioButton rdbtnPsiquico = new JRadioButton("Psíquico");
		rdbtnPsiquico.setToolTipText("Magias psíquicas usam o poder da mente para afetar seus alvos");
		rdbtnPsiquico.setBounds(276, 28, 86, 23);
		rdbtnPsiquico.setActionCommand("Psíquico");
		listaElementos.add(rdbtnPsiquico);
		
		JRadioButton rdbtnQuantico = new JRadioButton("Quântico");
		rdbtnQuantico.setToolTipText("Magias quânticas são especiais, possuem o poder absoluto, podem causar estragos extremos a seus alvos");
		rdbtnQuantico.setActionCommand("Quântico");
		rdbtnQuantico.setBounds(276, 45, 86, 23);
		listaElementos.add(rdbtnQuantico);
		
		ButtonGroup grupoElementos = new ButtonGroup();
		
		grupoElementos.add(rdbtnQuantico);
		grupoElementos.add(rdbtnPsiquico);
		grupoElementos.add(rdbtnFeerico);
		grupoElementos.add(rdbtnImaginario);
		grupoElementos.add(rdbtnVento);
		grupoElementos.add(rdbtnAgua);
		grupoElementos.add(rdbtnEtereo);
		grupoElementos.add(rdbtnMorte);
		grupoElementos.add(rdbtnNatureza);
		grupoElementos.add(rdbtnEletrico);
		grupoElementos.add(rdbtnGelo);
		grupoElementos.add(rdbtnFogo);
		
		JLabel lblClassesAleatrias = new JLabel("Classes Aleatórias");
		lblClassesAleatrias.setBounds(12, 162, 121, 15);
		principal.add(lblClassesAleatrias);
		
		JRadioButton rdbtnClassesAleatorias = new JRadioButton("");
		
		
		rdbtnClassesAleatorias.setBounds(121, 158, 21, 23);
		principal.add(rdbtnClassesAleatorias);
		
		JPanel listaClasses = new JPanel();
		listaClasses.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaClasses.setBounds(12, 189, 373, 34);
		principal.add(listaClasses);
		listaClasses.setLayout(null);
		
		JRadioButton rdbtnOfensiva = new JRadioButton("Ofensiva");
		rdbtnOfensiva.setToolTipText("Magias de classe ofensiva tendem a ter um foco em atacar alvos e conjurar efeitos de ataque");
		rdbtnOfensiva.setActionCommand("Ofensiva");
		rdbtnOfensiva.setBounds(12, 8, 87, 23);
		listaClasses.add(rdbtnOfensiva);
		
		JRadioButton rdbtnDefensiva = new JRadioButton("Defensiva");
		rdbtnDefensiva.setToolTipText("Magias de classe defensiva tem como foco a defesa e a proteção dos alvos afetados");
		rdbtnDefensiva.setActionCommand("Defensiva");
		rdbtnDefensiva.setBounds(145, 8, 87, 23);
		listaClasses.add(rdbtnDefensiva);
		
		JRadioButton rdbtnSuporte = new JRadioButton("Suporte");
		rdbtnSuporte.setToolTipText("Magias de suporte tem como foco ajudar os aliados no campo de batalha");
		rdbtnSuporte.setActionCommand("Suporte");
		rdbtnSuporte.setBounds(284, 8, 81, 23);
		listaClasses.add(rdbtnSuporte);
		
		ButtonGroup grupoClasses = new ButtonGroup();
		
		grupoClasses.add(rdbtnOfensiva);
		grupoClasses.add(rdbtnDefensiva);
		grupoClasses.add(rdbtnSuporte);
		
		JLabel lblRankDeMagia = new JLabel("Rank de Magia");
		lblRankDeMagia.setBounds(12, 235, 84, 15);
		principal.add(lblRankDeMagia);
		
		JSlider slider = new JSlider();
		slider.setValue(3);
		slider.setToolTipText("Determina o quâo forte vai ser a sua magia");
		slider.setSnapToTicks(true);
		slider.setMaximum(5);
		slider.setMinimum(1);
		slider.setBounds(102, 235, 200, 19);
		principal.add(slider);
		
		JLabel lblD = new JLabel("C");
		lblD.setBounds(112, 254, 46, 15);
		principal.add(lblD);
		
		JLabel lblB = new JLabel("B");
		lblB.setBounds(154, 254, 55, 15);
		principal.add(lblB);
		
		JLabel lblA = new JLabel("A");
		lblA.setBounds(199, 254, 53, 15);
		principal.add(lblA);
		
		JLabel lblS = new JLabel("S");
		lblS.setBounds(247, 254, 48, 15);
		principal.add(lblS);
		
		JLabel lblSs = new JLabel("SS");
		lblSs.setBounds(284, 254, 61, 15);
		principal.add(lblSs);
		
		JRadioButton rdbtnRankAleatorio = new JRadioButton("Aleatório");
		
		rdbtnRankAleatorio.setBounds(298, 231, 91, 23);
		principal.add(rdbtnRankAleatorio);
		
		JRadioButton rdbtnNivelAleatorio = new JRadioButton("Aleatório");
		
		rdbtnNivelAleatorio.setBounds(159, 8, 76, 23);
		principal.add(rdbtnNivelAleatorio);
		
		JButton btnGerar = new JButton("Gerar Magia");
		btnGerar.setToolTipText("Clique aqui para gerar a magia");
		
		btnGerar.setBounds(419, 268, 104, 31);
		frmGeradorDeMagias.getContentPane().add(btnGerar);
		
		JPanel sobre = new JPanel();
		sobre.setBorder(new LineBorder(new Color(0, 0, 0)));
		sobre.setBounds(421, 12, 293, 245);
		frmGeradorDeMagias.getContentPane().add(sobre);
		sobre.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("RndMagia - Gerador Automático de Magias");
		lblNewLabel_3.setBounds(12, 5, 269, 15);
		sobre.add(lblNewLabel_3);
		
		JTextPane txtpnSobre = new JTextPane();
		txtpnSobre.setBackground(UIManager.getColor("Panel.background"));
		txtpnSobre.setFont(new Font("Dialog", Font.BOLD, 12));
		txtpnSobre.setText("Um pequeno gerador de magias feito no Java, com o intuito de acelerar o processo criativo de criar magias para personagens de RPG                                                                      Espero que esse pequeno programa ajude!");
		txtpnSobre.setBounds(12, 23, 269, 179);
		sobre.add(txtpnSobre);
		
		JLabel lblMeuGithub = new JLabel("Meu GitHub");
		lblMeuGithub.setForeground(Color.BLUE.darker());
		
		lblMeuGithub.setBounds(22, 218, 73, 15);
		sobre.add(lblMeuGithub);
		
		JButton btnAjuda = new JButton("Ajuda");
		btnAjuda.setBounds(198, 202, 83, 31);
		sobre.add(btnAjuda);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 311, 560, 339);
		frmGeradorDeMagias.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRankMagia = new JLabel("");
		lblRankMagia.setHorizontalAlignment(SwingConstants.CENTER);
		lblRankMagia.setFont(new Font("Dialog", Font.BOLD, 26));
		lblRankMagia.setBounds(57, 49, 44, 43);
		panel.add(lblRankMagia);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 22, 55, 15);
		panel.add(lblNome);
		
		JLabel lblNomeMagia = new JLabel("");
		lblNomeMagia.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNomeMagia.setBounds(57, 12, 523, 36);
		panel.add(lblNomeMagia);
		
		JLabel lblRank = new JLabel("Rank:");
		lblRank.setBounds(12, 63, 55, 15);
		panel.add(lblRank);
		
		txtRankFundo = new JTextField();
		txtRankFundo.setEditable(false);
		txtRankFundo.setEnabled(false);
		txtRankFundo.setBounds(57, 49, 44, 44);
		panel.add(txtRankFundo);
		txtRankFundo.setColumns(10);
		
		JLabel lblClasse = new JLabel("Classe:");
		lblClasse.setBounds(115, 63, 55, 15);
		panel.add(lblClasse);
		
		JLabel lblClasseMagia = new JLabel("");
		lblClasseMagia.setBounds(163, 63, 108, 15);
		panel.add(lblClasseMagia);
		
		JLabel lblElemento = new JLabel("Elemento:");
		lblElemento.setBounds(283, 63, 64, 15);
		panel.add(lblElemento);
		
		JLabel lblElementoMagia = new JLabel("");
		lblElementoMagia.setBounds(345, 63, 101, 15);
		panel.add(lblElementoMagia);
		
		JLabel lblRankDescricao = new JLabel("");
		lblRankDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblRankDescricao.setBounds(22, 93, 108, 15);
		panel.add(lblRankDescricao);
		
		JLabel lblEfeito = new JLabel("Efeito:");
		lblEfeito.setBounds(12, 120, 55, 15);
		panel.add(lblEfeito);
		
		JLabel lblEfeitoMagia = new JLabel("");
		lblEfeitoMagia.setBounds(57, 120, 113, 15);
		panel.add(lblEfeitoMagia);
		
		JLabel lblAlcance = new JLabel("Alcance:");
		lblAlcance.setBounds(182, 120, 55, 15);
		panel.add(lblAlcance);
		
		JLabel lblAlcanceMagia = new JLabel("");
		lblAlcanceMagia.setBounds(238, 120, 108, 15);
		panel.add(lblAlcanceMagia);
		
		JLabel lblDurao = new JLabel("Duração:");
		lblDurao.setBounds(345, 120, 55, 15);
		panel.add(lblDurao);
		
		JLabel lblDuracaoMagia = new JLabel("");
		lblDuracaoMagia.setBounds(401, 120, 120, 15);
		panel.add(lblDuracaoMagia);
		
		JLabel lblNvel = new JLabel("Nível:");
		lblNvel.setBounds(445, 63, 32, 15);
		panel.add(lblNvel);
		
		JLabel lblNivelMagia = new JLabel("");
		lblNivelMagia.setBounds(481, 63, 64, 15);
		panel.add(lblNivelMagia);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(12, 147, 64, 15);
		panel.add(lblDescrio);
		
		JTextArea txtrDescricaoMagia = new JTextArea();
		txtrDescricaoMagia.setFont(new Font("Dialog", Font.BOLD, 12));
		txtrDescricaoMagia.setBounds(12, 164, 536, 124);
		panel.add(txtrDescricaoMagia);
		
		JButton btnSalvarMagia = new JButton("Salvar Magia");
		btnSalvarMagia.setToolTipText("Clique aqui para salvar a magia gerada ");
		
		btnSalvarMagia.setBounds(212, 300, 135, 27);
		panel.add(btnSalvarMagia);
		
		JButton btnNovoNomeElemento = new JButton("Novo Elemento");
		
		btnNovoNomeElemento.setToolTipText("Gera um novo nome para o elemento escolhido");
		btnNovoNomeElemento.setBounds(584, 369, 130, 31);
		frmGeradorDeMagias.getContentPane().add(btnNovoNomeElemento);
		
		JButton btnNewButton = new JButton("Novo Rank");
		
		btnNewButton.setToolTipText("Gera uma nova descrição de rank para o rank escolhido");
		btnNewButton.setBounds(584, 412, 130, 31);
		frmGeradorDeMagias.getContentPane().add(btnNewButton);
		
		JButton btnNovoAlcance = new JButton("Novo Alcance");
		
		btnNovoAlcance.setToolTipText("Gera um novo alcance");
		btnNovoAlcance.setBounds(584, 455, 130, 31);
		frmGeradorDeMagias.getContentPane().add(btnNovoAlcance);
		
		JButton btnNovaDuracao = new JButton("Nova Duração");
		
		btnNovaDuracao.setToolTipText("Gera uma nova duração para a sua magia, com base no nível e rank");
		btnNovaDuracao.setBounds(584, 498, 130, 31);
		frmGeradorDeMagias.getContentPane().add(btnNovaDuracao);
		
		JButton btnNovoEfeito = new JButton("Novo Efeito");
		
		btnNovoEfeito.setBounds(584, 541, 130, 31);
		frmGeradorDeMagias.getContentPane().add(btnNovoEfeito);
		
		JButton btnNovoTipo = new JButton("Novo Tipo");
		
		btnNovoTipo.setBounds(584, 326, 130, 31);
		frmGeradorDeMagias.getContentPane().add(btnNovoTipo);
		
		btnAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Nível da Magia: Uma magia pode ter um nível entre 1 a 9\n"
						+ "Elemento da magia: Determina qual vai ser o elemento da magia gerada\n"
						+ "Classe da Magia: Determina a classe e o comportamento geral da magia gerada\n"
						+ "Rank de Magia: Determina a qualidade e o poder geral da magia\n\n"
						+ "Uma magia é gerada de forma semi-aleatória, com base nos parâmetros selecionados\n"
						+ "Para editar (parte) da magia gerada, pode utilizar os botões abaixo\n"
						+ "Caso queira alterar os parametros para a geração da magia, edite o arquivo Parametros.ini na pasta \"data\"\n"
						+ "Caso queira adicionar uma descrição a sua magia, digite no campo de descrição ao lado"
						, "Ajuda", 1);
			}
		});
		
		rdbtnElementosAleatorios.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnElementosAleatorios.getSelectedObjects()!=null) {
					rdbtnFogo.setEnabled(false);
					rdbtnGelo.setEnabled(false);
					rdbtnEletrico.setEnabled(false);
					rdbtnNatureza.setEnabled(false);
					rdbtnMorte.setEnabled(false);
					rdbtnEtereo.setEnabled(false);
					rdbtnAgua.setEnabled(false);
					rdbtnVento.setEnabled(false);
					rdbtnImaginario.setEnabled(false);
					rdbtnFeerico.setEnabled(false);
					rdbtnPsiquico.setEnabled(false);
					rdbtnQuantico.setEnabled(false);
					
					grupoElementos.clearSelection();
					
				}else {
					rdbtnFogo.setEnabled(true);
					rdbtnGelo.setEnabled(true);
					rdbtnEletrico.setEnabled(true);
					rdbtnNatureza.setEnabled(true);
					rdbtnMorte.setEnabled(true);
					rdbtnEtereo.setEnabled(true);
					rdbtnAgua.setEnabled(true);
					rdbtnVento.setEnabled(true);
					rdbtnImaginario.setEnabled(true);
					rdbtnFeerico.setEnabled(true);
					rdbtnPsiquico.setEnabled(true);
					rdbtnQuantico.setEnabled(true);
				}
			}
		});
		
		rdbtnClassesAleatorias.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnClassesAleatorias.getSelectedObjects()!=null) {
					rdbtnOfensiva.setEnabled(false);
					rdbtnDefensiva.setEnabled(false);
					rdbtnSuporte.setEnabled(false);
					
					grupoClasses.clearSelection();
				}else {
					rdbtnOfensiva.setEnabled(true);
					rdbtnDefensiva.setEnabled(true);
					rdbtnSuporte.setEnabled(true);
				}
			}
		});
		
		rdbtnNivelAleatorio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnNivelAleatorio.isSelected()) {
					txtNivel.setText("");
					txtNivel.setEnabled(false);
				}else {
					txtNivel.setEnabled(true);
				}
			}
		});
		
		rdbtnRankAleatorio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnRankAleatorio.isSelected()) {
					slider.setEnabled(false);
				}else {
					slider.setEnabled(true);
				}
			}
		});
		
		txtNivel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)) {
					txtNivel.setEditable(true);
				}else {
					txtNivel.setEditable(false);
					return;
				}
				String num = txtNivel.getText();
				int keyCode = e.getKeyCode();
				
				
				if(txtNivel.getText().length()>=1) {
					txtNivel.setEditable(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					txtNivel.setEditable(true);
				}
			}
		});
		
		lblMeuGithub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/lant-silva"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			public void mouseEntered(MouseEvent e) {
				
				lblMeuGithub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblMeuGithub.setText("<html><a href=''>Meu Github</a></html>");
			}
			
			public void mouseExited(MouseEvent e) {
				lblMeuGithub.setText("Meu Github");
			}
		});
		
		btnGerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				String elemento="";
				String classe;
				int nivel=0;
				String rank="";
			
				if(rdbtnNivelAleatorio.isSelected()) {
					int random = (int) (Math.random()*9)+1;
					nivel = random;
				}else {
					String aux = txtNivel.getText();
					nivel = Integer.parseInt(aux);					
				}
				
				if(rdbtnElementosAleatorios.isSelected()){
					int random = (int) (Math.random()*12);
					elemento = Elementos.elemento[random];
				}else{
					elemento = grupoElementos.getSelection().getActionCommand();
				}
				if(rdbtnClassesAleatorias.isSelected()) {
					int random = (int) (Math.random()*3);
					classe = Classes.classe[random];
				}else {
					classe = grupoClasses.getSelection().getActionCommand();
				}
				
				if(rdbtnRankAleatorio.isSelected()) {
					int random = (int) (Math.random()*5);
					rank = Rank.rank[random];
				}else {
					rank = Rank.rank[slider.getValue()-1];					
				}
				
				try {
					magiaGerada = gerar.getParameters(nivel, elemento, classe, rank);
					
					lblNomeMagia.setText(magiaGerada.getNome());
					lblRankMagia.setText(magiaGerada.getNomeRank());
					lblRankDescricao.setText(magiaGerada.getRank());
					lblClasseMagia.setText(magiaGerada.getClasse());
					lblElementoMagia.setText(magiaGerada.getElemento());
					lblEfeitoMagia.setText(magiaGerada.getEfeito());
					lblAlcanceMagia.setText(magiaGerada.getAlcance());
					lblDuracaoMagia.setText(magiaGerada.getDuracao());
					lblNivelMagia.setText(Integer.toString(magiaGerada.getNivel()));
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNovoTipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					magiaGerada.setTipo(gerar.gerarNome(magiaGerada.getClasse()));
					lblNomeMagia.setText(magiaGerada.getNome());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNovoNomeElemento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					magiaGerada.setNomeElemento(gerar.gerarNomeElemento(magiaGerada.getElemento()));
					lblNomeMagia.setText(magiaGerada.getNome());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					magiaGerada.setRank(gerar.gerarRank(magiaGerada.getNomeRank()));
					lblRankDescricao.setText(magiaGerada.getRank());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		btnNovoAlcance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					magiaGerada.setAlcance(gerar.gerarAlcance());
					lblAlcanceMagia.setText(magiaGerada.getAlcance());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNovaDuracao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					magiaGerada.setDuracao(gerar.gerarDuracao(magiaGerada.getNivel(), magiaGerada.getNomeRank()));
					lblDuracaoMagia.setText(magiaGerada.getDuracao());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		btnNovoEfeito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				magiaGerada.setEfeito(gerar.gerarEfeito(magiaGerada.getNivel(), magiaGerada.getNomeRank(), magiaGerada.getEfeitoClasse()));
				lblEfeitoMagia.setText(magiaGerada.getEfeito());
			}
		});
		
		btnSalvarMagia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean sucesso = false;
				magiaGerada.setDescricao(txtrDescricaoMagia.getText());
				JFileChooser salvar = new JFileChooser();
				salvar.setCurrentDirectory(null);
				int escolha = salvar.showSaveDialog(null);
				if(escolha == JFileChooser.APPROVE_OPTION) {
					File novaMagia = new File(salvar.getSelectedFile().getAbsolutePath());
					String[] linha = magiaGerada.salvarTexto().split("\n");
					
					FileWriter escrita;
					try {
						escrita = new FileWriter(novaMagia);
						PrintWriter print = new PrintWriter(escrita);
						int tamanhoLinha = linha.length;
						for(int i=0;i<tamanhoLinha;i++) {
							if(i==tamanhoLinha-1) {
								print.write(linha[i]);
								print.flush();
							}else {
								print.write(linha[i]+"\n");
								print.flush();
							}
						}
						print.close();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
						sucesso = true;
					}
				}
				if(sucesso) {
					JOptionPane.showMessageDialog(null, "Magia salva.", "Salvar", 1);
				}
			}
		});
		
	}
}
