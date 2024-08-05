package rocha.guilherme.jose.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import rocha.guilherme.jose.controller.EstabelecimentoProximoController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class EstabelecimentoProximoTela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeLocal;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JRadioButton rdbtn20;
	private JRadioButton rdbtn25;
	private JRadioButton rdbtn30;
	private JRadioButton rdbtn35;
	private JRadioButton rdbtn40;
	private JRadioButton rdbtn45;
	private ButtonGroup grupo;
	
	private EstabelecimentoProximoController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstabelecimentoProximoTela frame = new EstabelecimentoProximoTela();
					frame.setLocationRelativeTo(null);;
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EstabelecimentoProximoTela() {
		controller = new EstabelecimentoProximoController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 325);
		contentPane = new JPainelGradient();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocaisProximos = new JLabel("Locais Pr\u00F3ximos");
		lblLocaisProximos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLocaisProximos.setForeground(Color.WHITE);
		lblLocaisProximos.setBounds(178, 28, 144, 24);
		contentPane.add(lblLocaisProximos);
		
		JLabel lblNomeLocal = new JLabel("Nome do estabelecimento:");
		lblNomeLocal.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeLocal.setForeground(Color.WHITE);
		lblNomeLocal.setBounds(20, 90, 149, 16);
		contentPane.add(lblNomeLocal);
		
		textFieldNomeLocal = new JTextField();
		textFieldNomeLocal.setBounds(20, 110, 180, 28);
		textFieldNomeLocal.setForeground(Color.WHITE);
		textFieldNomeLocal.setOpaque(false);
		textFieldNomeLocal.setColumns(10);
		contentPane.add(textFieldNomeLocal);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setBounds(220, 90, 43, 16);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setBounds(360, 90, 43, 16);
		contentPane.add(lblEstado);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(220, 110, 120, 28);
		textFieldCidade.setForeground(Color.WHITE);
		textFieldCidade.setOpaque(false);
		textFieldCidade.setColumns(10);
		contentPane.add(textFieldCidade);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(360, 110, 120, 28);
		textFieldEstado.setForeground(Color.WHITE);
		textFieldEstado.setOpaque(false);
		textFieldEstado.setColumns(10);
		contentPane.add(textFieldEstado);
		
		JButton btnPesquisar = new JButton("BUSCAR NO MAPA");
		btnPesquisar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPesquisar.setBackground(Color.decode("#0F2027"));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnPesquisar.setForeground(Color.WHITE);
				btnPesquisar.setBorder(new LineBorder(Color.WHITE));
				btnPesquisar.setBackground(Color.decode("#2C5364"));
			}
		});
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.pesquisarNoMapa();
			}
		});
		btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setBorder(new LineBorder(Color.WHITE));
		btnPesquisar.setBackground(Color.decode("#2C5364"));
		btnPesquisar.setBounds(112, 222, 140, 28);
		contentPane.add(btnPesquisar);
		
		JButton btnLimparTela = new JButton("LIMPAR TELA");
		btnLimparTela.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLimparTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLimparTela.setBackground(Color.decode("#2C5364"));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnLimparTela.setForeground(Color.WHITE);
				btnLimparTela.setBorder(new LineBorder(Color.WHITE));
				btnLimparTela.setBackground(Color.decode("#0F2027"));
			}
		});
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.limparTela();
			}
		});
		btnLimparTela.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimparTela.setForeground(Color.WHITE);
		btnLimparTela.setBorder(new LineBorder(Color.WHITE));
		btnLimparTela.setBackground(Color.decode("#0F2027"));
		btnLimparTela.setBounds(272, 222, 115, 28);
		contentPane.add(btnLimparTela);
		
		JLabel lblAvaliacaoMinima = new JLabel("Avalia\u00E7\u00E3o Min\u00EDma:");
		lblAvaliacaoMinima.setForeground(Color.WHITE);
		lblAvaliacaoMinima.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAvaliacaoMinima.setBounds(36, 162, 100, 16);
		contentPane.add(lblAvaliacaoMinima);
		
		rdbtn20 = new JRadioButton("2.0");
		rdbtn20.setToolTipText("Estrelas ou mais");
		rdbtn20.setOpaque(false);
		rdbtn20.setForeground(Color.WHITE);
		rdbtn20.setBounds(152, 158, 42, 24);
		contentPane.add(rdbtn20);
		
		rdbtn25 = new JRadioButton("2.5");
		rdbtn25.setToolTipText("Estrelas ou mais");
		rdbtn25.setOpaque(false);
		rdbtn25.setForeground(Color.WHITE);
		rdbtn25.setBounds(206, 158, 42, 24);
		contentPane.add(rdbtn25);
		
		rdbtn30 = new JRadioButton("3.0");
		rdbtn30.setToolTipText("Estrelas ou mais");
		rdbtn30.setOpaque(false);
		rdbtn30.setForeground(Color.WHITE);
		rdbtn30.setBounds(260, 158, 42, 24);
		contentPane.add(rdbtn30);
		
		rdbtn35 = new JRadioButton("3.5");
		rdbtn35.setToolTipText("Estrelas ou mais");
		rdbtn35.setOpaque(false);
		rdbtn35.setForeground(Color.WHITE);
		rdbtn35.setBounds(314, 158, 42, 24);
		contentPane.add(rdbtn35);
		
		rdbtn40 = new JRadioButton("4.0");
		rdbtn40.setToolTipText("Estrelas ou mais");
		rdbtn40.setOpaque(false);
		rdbtn40.setForeground(Color.WHITE);
		rdbtn40.setBounds(368, 158, 42, 24);
		contentPane.add(rdbtn40);
		
		rdbtn45 = new JRadioButton("4.5");
		rdbtn45.setToolTipText("Estrelas ou mais");
		rdbtn45.setOpaque(false);
		rdbtn45.setForeground(Color.WHITE);
		rdbtn45.setBounds(422, 158, 42, 24);
		contentPane.add(rdbtn45);
	
		grupo = new ButtonGroup();
		grupo.add(rdbtn20);
		grupo.add(rdbtn25);
		grupo.add(rdbtn30);
		grupo.add(rdbtn35);
		grupo.add(rdbtn40);
		grupo.add(rdbtn45);
		
	}
	
	public void exibeMensagemInformativa(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Atenção", JOptionPane.WARNING_MESSAGE);
	}
	
	public JTextField getTextFieldNomeLocal() {
		return textFieldNomeLocal;
	}
	
	public void setTextFieldNomeLocal(JTextField textFieldNomeLocal) {
		this.textFieldNomeLocal = textFieldNomeLocal;
	}

	public JTextField getTextFieldCidade() {
		return textFieldCidade;
	}

	public void setTextFieldCidade(JTextField textFieldCidade) {
		this.textFieldCidade = textFieldCidade;
	}

	public JTextField getTextFieldEstado() {
		return textFieldEstado;
	}

	public void setTextFieldEstado(JTextField textFieldEstado) {
		this.textFieldEstado = textFieldEstado;
	}

	public JRadioButton getRdbtn20() {
		return rdbtn20;
	}

	public void setRdbtn20(JRadioButton rdbtn20) {
		this.rdbtn20 = rdbtn20;
	}

	public JRadioButton getRdbtn25() {
		return rdbtn25;
	}

	public void setRdbtn25(JRadioButton rdbtn25) {
		this.rdbtn25 = rdbtn25;
	}

	public JRadioButton getRdbtn30() {
		return rdbtn30;
	}

	public void setRdbtn30(JRadioButton rdbtn30) {
		this.rdbtn30 = rdbtn30;
	}

	public JRadioButton getRdbtn35() {
		return rdbtn35;
	}

	public void setRdbtn35(JRadioButton rdbtn35) {
		this.rdbtn35 = rdbtn35;
	}

	public JRadioButton getRdbtn40() {
		return rdbtn40;
	}

	public void setRdbtn40(JRadioButton rdbtn40) {
		this.rdbtn40 = rdbtn40;
	}

	public JRadioButton getRdbtn45() {
		return rdbtn45;
	}

	public void setRdbtn45(JRadioButton rdbtn45) {
		this.rdbtn45 = rdbtn45;
	}

	public ButtonGroup getGrupo() {
		return grupo;
	}

	public void setGrupo(ButtonGroup grupo) {
		this.grupo = grupo;
	}
	
	
}
