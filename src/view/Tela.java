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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela {

	private JFrame frmGeradorDeMagias;
	private JTextField textField;

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
		
		JPanel principal = new JPanel();
		principal.setBorder(new LineBorder(new Color(0, 0, 0)));
		principal.setBounds(12, 12, 397, 287);
		frmGeradorDeMagias.getContentPane().add(principal);
		principal.setLayout(null);
		
		JLabel lblNivel = new JLabel("Nível da magia:");
		lblNivel.setBounds(12, 12, 93, 15);
		principal.add(lblNivel);
		
		textField = new JTextField();

		textField.setBounds(103, 10, 48, 19);
		principal.add(textField);
		textField.setColumns(10);
		
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
		
		JLabel lblNewLabel = new JLabel("Fogo");
		lblNewLabel.setBounds(12, 12, 55, 15);
		listaElementos.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gelo");
		lblNewLabel_1.setBounds(12, 32, 55, 15);
		listaElementos.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Elétrico");
		lblNewLabel_2.setBounds(12, 49, 55, 15);
		listaElementos.add(lblNewLabel_2);
		
		JRadioButton rdbtnFogo = new JRadioButton("");
		rdbtnFogo.setBounds(59, 8, 21, 23);
		listaElementos.add(rdbtnFogo);
		
		JRadioButton rdbtnGelo = new JRadioButton("");
		rdbtnGelo.setBounds(59, 28, 21, 23);
		listaElementos.add(rdbtnGelo);
		
		JRadioButton rdbtnEletrico = new JRadioButton("");
		rdbtnEletrico.setBounds(59, 45, 21, 23);
		listaElementos.add(rdbtnEletrico);
		
		JLabel lblNatureza = new JLabel("Natureza");
		lblNatureza.setBounds(94, 12, 55, 15);
		listaElementos.add(lblNatureza);
		
		JLabel lblMorte = new JLabel("Morte");
		lblMorte.setBounds(94, 32, 55, 15);
		listaElementos.add(lblMorte);
		
		JLabel lblDivino = new JLabel("Etéreo");
		lblDivino.setBounds(94, 49, 55, 15);
		listaElementos.add(lblDivino);
		
		JRadioButton rdbtnNatureza = new JRadioButton("");
		rdbtnNatureza.setBounds(152, 8, 21, 23);
		listaElementos.add(rdbtnNatureza);
		
		JRadioButton rdbtnMorte = new JRadioButton("");
		rdbtnMorte.setBounds(152, 28, 21, 23);
		listaElementos.add(rdbtnMorte);
		
		JRadioButton rdbtnEtereo = new JRadioButton("");
		rdbtnEtereo.setBounds(152, 45, 21, 23);
		listaElementos.add(rdbtnEtereo);
		
		JLabel lblAgua = new JLabel("Água");
		lblAgua.setBounds(187, 12, 55, 15);
		listaElementos.add(lblAgua);
		
		JLabel lblVento = new JLabel("Vento");
		lblVento.setBounds(187, 32, 55, 15);
		listaElementos.add(lblVento);
		
		JLabel lblImaginario = new JLabel("Imaginário");
		lblImaginario.setBounds(187, 49, 61, 15);
		listaElementos.add(lblImaginario);
		
		JRadioButton rdbtnAgua = new JRadioButton("");
		rdbtnAgua.setBounds(251, 8, 21, 23);
		listaElementos.add(rdbtnAgua);
		
		JRadioButton rdbtnVento = new JRadioButton("");
		rdbtnVento.setBounds(251, 28, 21, 23);
		listaElementos.add(rdbtnVento);
		
		JRadioButton rdbtnImaginario = new JRadioButton("");
		rdbtnImaginario.setBounds(251, 45, 21, 23);
		listaElementos.add(rdbtnImaginario);
		
		JLabel lblFada = new JLabel("Fada");
		lblFada.setBounds(286, 12, 55, 15);
		listaElementos.add(lblFada);
		
		JLabel lblPsiquico = new JLabel("Psíquico");
		lblPsiquico.setBounds(286, 32, 55, 15);
		listaElementos.add(lblPsiquico);
		
		JLabel lblQuantico = new JLabel("Quântico");
		lblQuantico.setBounds(286, 49, 55, 15);
		listaElementos.add(lblQuantico);
		
		JRadioButton rdbtnFada = new JRadioButton("");
		rdbtnFada.setBounds(341, 8, 21, 23);
		listaElementos.add(rdbtnFada);
		
		JRadioButton rdbtnPsiquico = new JRadioButton("");
		rdbtnPsiquico.setBounds(341, 28, 21, 23);
		listaElementos.add(rdbtnPsiquico);
		
		JRadioButton rdbtnQuantico = new JRadioButton("");
		rdbtnQuantico.setBounds(341, 45, 21, 23);
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
		
		JLabel lblOfensiva = new JLabel("Ofensiva");
		lblOfensiva.setBounds(12, 12, 55, 15);
		listaClasses.add(lblOfensiva);
		
		JLabel lblDefensiva = new JLabel("Defensiva");
		lblDefensiva.setBounds(135, 12, 58, 15);
		listaClasses.add(lblDefensiva);
		
		JLabel lblSuporte = new JLabel("Suporte");
		lblSuporte.setBounds(284, 12, 55, 15);
		listaClasses.add(lblSuporte);
		
		JRadioButton rdbtnOfensiva = new JRadioButton("");
		rdbtnOfensiva.setBounds(64, 8, 21, 23);
		listaClasses.add(rdbtnOfensiva);
		
		JRadioButton rdbtnDefensiva = new JRadioButton("");
		rdbtnDefensiva.setBounds(194, 8, 21, 23);
		listaClasses.add(rdbtnDefensiva);
		
		JRadioButton rdbtnSuporte = new JRadioButton("");
		rdbtnSuporte.setBounds(331, 8, 21, 23);
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
		lblA.setBounds(197, 254, 55, 15);
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
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)) {
					textField.setEditable(true);
				}else {
					textField.setEditable(false);
					return;
				}
				String num = textField.getText();
				int keyCode = e.getKeyCode();
				
				
				if(textField.getText().length()>=1) {
					textField.setEditable(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					textField.setEditable(true);
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
		
	}
}
