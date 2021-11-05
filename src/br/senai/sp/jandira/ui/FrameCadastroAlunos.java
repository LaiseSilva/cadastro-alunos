package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import br.senai.sp.jandira.model.Periodo;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;
	private JTextField textNome;

	public FrameCadastroAlunos() {
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(10, 27, 76, 14);
		contentPane.add(lblMatricula);

		textMatricula = new JTextField();
		textMatricula.setBounds(96, 23, 86, 22);
		contentPane.add(textMatricula);
		textMatricula.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 71, 38, 14);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(66, 68, 169, 20);
		contentPane.add(textNome);

		JLabel lblPeriodo = new JLabel("Per\u00EDodo");
		lblPeriodo.setBounds(10, 113, 56, 14);
		contentPane.add(lblPeriodo);

		JComboBox comboPeriodo = new JComboBox();
		comboPeriodo.setModel(new DefaultComboBoxModel(Periodo.values()));
		comboPeriodo.setBounds(94, 109, 141, 22);
		contentPane.add(comboPeriodo);

		JButton btnSalvarAluno = new JButton("Salvar aluno");
		btnSalvarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvarAluno.setBounds(66, 154, 143, 38);
		contentPane.add(btnSalvarAluno);

		JLabel lblListaDeAlunos = new JLabel("Lista de Alunos:");
		lblListaDeAlunos.setBounds(271, 24, 136, 14);
		contentPane.add(lblListaDeAlunos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 41, 136, 209);
		contentPane.add(scrollPane);

		JList listAlunos = new JList();
		 scrollPane.setViewportView(listAlunos);
	}
}
