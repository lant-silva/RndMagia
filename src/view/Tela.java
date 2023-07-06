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
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.GerarMagia;
import model.Classes;
import model.Elementos;
import model.Nome;
import model.Rank;

public class Tela {
	
	private GerarMagia gerar = new GerarMagia();
	private JFrame frmGeradorDeMagias;
	private JTextField txtNivel;

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
		frmGeradorDeMagias.setTitle("Gerador de Magias");
		frmGeradorDeMagias.setBounds(100, 100, 634, 352);
		frmGeradorDeMagias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeradorDeMagias.getContentPane().setLayout(null);
		
		Nome nome = new Nome();
		try {
			nome.update();
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

		

		
		rdbtnElementosAleatorios.setBounds(133, 40, 21, 23);
		principal.add(rdbtnElementosAleatorios);
		
		JPanel listaElementos = new JPanel();
		listaElementos.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaElementos.setBounds(12, 71, 372, 75);
		principal.add(listaElementos);
		listaElementos.setLayout(null);
		
		JRadioButton rdbtnFogo = new JRadioButton("Fogo");
		rdbtnFogo.setBounds(12, 8, 82, 23);
		rdbtnFogo.setActionCommand("Fogo");
		listaElementos.add(rdbtnFogo);
		
		JRadioButton rdbtnGelo = new JRadioButton("Gelo");
		rdbtnGelo.setBounds(12, 28, 82, 23);
		rdbtnGelo.setActionCommand("Gelo");
		listaElementos.add(rdbtnGelo);
		
		JRadioButton rdbtnEletrico = new JRadioButton("Elétrico");
		rdbtnEletrico.setBounds(12, 45, 82, 23);
		rdbtnEletrico.setActionCommand("Elétrico");
		listaElementos.add(rdbtnEletrico);
		
		JRadioButton rdbtnNatureza = new JRadioButton("Natureza");
		rdbtnNatureza.setBounds(91, 8, 82, 23);
		rdbtnNatureza.setActionCommand("Natureza");
		listaElementos.add(rdbtnNatureza);
		
		JRadioButton rdbtnMorte = new JRadioButton("Morte");
		rdbtnMorte.setBounds(91, 28, 82, 23);
		rdbtnMorte.setActionCommand("Morte");
		listaElementos.add(rdbtnMorte);
		
		JRadioButton rdbtnEtereo = new JRadioButton("Etéreo");
		rdbtnEtereo.setBounds(91, 45, 82, 23);
		rdbtnEtereo.setActionCommand("Etéreo");
		listaElementos.add(rdbtnEtereo);
		
		JRadioButton rdbtnAgua = new JRadioButton("Água");
		rdbtnAgua.setBounds(177, 8, 95, 23);
		rdbtnAgua.setActionCommand("Água");
		listaElementos.add(rdbtnAgua);
		
		JRadioButton rdbtnVento = new JRadioButton("Vento");
		rdbtnVento.setBounds(177, 28, 95, 23);
		rdbtnVento.setActionCommand("Vento");
		listaElementos.add(rdbtnVento);
		
		JRadioButton rdbtnImaginario = new JRadioButton("Imaginário");
		rdbtnImaginario.setBounds(177, 45, 95, 23);
		rdbtnImaginario.setActionCommand("Imaginário");
		listaElementos.add(rdbtnImaginario);
		
		JRadioButton rdbtnFada = new JRadioButton("Fada");
		rdbtnFada.setBounds(276, 8, 86, 23);
		rdbtnFada.setActionCommand("Fada");
		listaElementos.add(rdbtnFada);
		
		JRadioButton rdbtnPsiquico = new JRadioButton("Psíquico");
		rdbtnPsiquico.setBounds(276, 28, 86, 23);
		rdbtnPsiquico.setActionCommand("Psíquico");
		listaElementos.add(rdbtnPsiquico);
		
		JRadioButton rdbtnQuantico = new JRadioButton("Quântico");
		rdbtnQuantico.setToolTipText("Uma coisa");
		rdbtnQuantico.setActionCommand("Quântico");
		rdbtnQuantico.setBounds(276, 45, 86, 23);
		listaElementos.add(rdbtnQuantico);
		
		ButtonGroup grupoElementos = new ButtonGroup();
		
		grupoElementos.add(rdbtnQuantico);
		grupoElementos.add(rdbtnPsiquico);
		grupoElementos.add(rdbtnFada);
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
		rdbtnOfensiva.setActionCommand("Ofensiva");
		rdbtnOfensiva.setBounds(12, 8, 87, 23);
		listaClasses.add(rdbtnOfensiva);
		
		JRadioButton rdbtnDefensiva = new JRadioButton("Defensiva");
		rdbtnDefensiva.setActionCommand("Defensiva");
		rdbtnDefensiva.setBounds(145, 8, 87, 23);
		listaClasses.add(rdbtnDefensiva);
		
		JRadioButton rdbtnSuporte = new JRadioButton("Suporte");
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
		slider.setToolTipText("a");
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
		
		JButton btnGerar = new JButton("Gerar Magia");
		
		btnGerar.setBounds(419, 268, 104, 31);
		frmGeradorDeMagias.getContentPane().add(btnGerar);
		
		JPanel sobre = new JPanel();
		sobre.setBorder(new LineBorder(new Color(0, 0, 0)));
		sobre.setBounds(421, 12, 199, 245);
		frmGeradorDeMagias.getContentPane().add(sobre);
		sobre.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Gerador Automático de Magias");
		lblNewLabel_3.setBounds(12, 5, 191, 15);
		sobre.add(lblNewLabel_3);
		
		JTextPane txtpnSobre = new JTextPane();
		txtpnSobre.setBackground(UIManager.getColor("Panel.background"));
		txtpnSobre.setFont(new Font("Dialog", Font.BOLD, 12));
		txtpnSobre.setText("Um pequeno gerador de magias feito no Java, com o intuito de acelerar o processo criativo de criar magias para personagens de RPG                                 Espero que esse pequeno programa ajude!");
		txtpnSobre.setBounds(12, 23, 175, 179);
		sobre.add(txtpnSobre);
		
		JLabel lblMeuGithub = new JLabel("Meu GitHub");
		lblMeuGithub.setForeground(Color.BLUE.darker());
		
		lblMeuGithub.setBounds(65, 218, 73, 15);
		sobre.add(lblMeuGithub);
		
		JButton btnAjuda = new JButton("Ajuda");
		
		
		btnAjuda.setBounds(535, 268, 83, 31);
		frmGeradorDeMagias.getContentPane().add(btnAjuda);
		
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
					rdbtnFada.setEnabled(false);
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
					rdbtnFada.setEnabled(true);
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
				String aux = txtNivel.getText();
				int nivel = Integer.parseInt(aux);
				String elemento;
				String classe;
				if(rdbtnElementosAleatorios.isSelected()){
					int random = (int) (Math.random()*12);
					elemento = Elementos.elemento[random];
				}else {
					elemento = grupoElementos.getSelection().getActionCommand();
				}
				if(rdbtnClassesAleatorias.isSelected()) {
					int random = (int) (Math.random()*3);
					classe = Classes.classe[random];
				}else {
					classe = grupoClasses.getSelection().getActionCommand();
				}
				String rank = Rank.rank[slider.getValue()-1];
				
				gerar.getParameters(nivel, elemento, classe, rank);
				
			}
		});
		
		btnAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Nível da Magia: Uma magia pode ter um nível entre 1 a 9\n"
						+ "Elemento da magia: Determina qual vai ser o elemento da magia gerada\n"
						+ "Classe da Magia: Determina a classe e o comportamento geral da magia gerada\n"
						+ "Rank de Magia: Determina a qualidade e o poder geral da magia\n\n"
						+ "Uma magia é gerada de forma semi-aleatória, com base nos parâmetros selecionados"
						, "Ajuda", 1);
			}
		});
		
	}
}
