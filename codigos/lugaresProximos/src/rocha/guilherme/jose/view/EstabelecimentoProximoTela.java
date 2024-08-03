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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class EstabelecimentoProximoTela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeLocal;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	
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
		setBounds(100, 100, 486, 266);
		contentPane = new JPainelGradient();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocaisProximos = new JLabel("Locais pr\u00F3ximos");
		lblLocaisProximos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLocaisProximos.setForeground(Color.WHITE);
		lblLocaisProximos.setBounds(157, 28, 156, 24);
		contentPane.add(lblLocaisProximos);
		
		JLabel lblNomeLocal = new JLabel("Nome do estabelecimento:");
		lblNomeLocal.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeLocal.setForeground(Color.WHITE);
		lblNomeLocal.setBounds(10, 90, 149, 16);
		contentPane.add(lblNomeLocal);
		
		textFieldNomeLocal = new JTextField();
		textFieldNomeLocal.setBounds(10, 110, 190, 28);
		textFieldNomeLocal.setForeground(Color.WHITE);
		textFieldNomeLocal.setOpaque(false);
		textFieldNomeLocal.setColumns(10);
		contentPane.add(textFieldNomeLocal);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setBounds(210, 90, 43, 16);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setBounds(340, 90, 43, 16);
		contentPane.add(lblEstado);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(210, 110, 120, 28);
		textFieldCidade.setForeground(Color.WHITE);
		textFieldCidade.setOpaque(false);
		textFieldCidade.setColumns(10);
		contentPane.add(textFieldCidade);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(340, 110, 120, 28);
		textFieldEstado.setForeground(Color.WHITE);
		textFieldEstado.setOpaque(false);
		textFieldEstado.setColumns(10);
		contentPane.add(textFieldEstado);
		
		JButton btnPesquisar = new JButton("Pesquisar");
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
		btnPesquisar.setBounds(125, 171, 100, 28);
		contentPane.add(btnPesquisar);
		
		JButton btnLimparTela = new JButton("Limpar tela");
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
		btnLimparTela.setBounds(245, 171, 100, 28);
		contentPane.add(btnLimparTela);
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
	
}
