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
import javax.swing.DefaultListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNome;
	private int posicao = 0;

	public FrameCadastroAlunos() {

		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(10, 40, 56, 14);
		contentPane.add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(78, 37, 169, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 71, 38, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(78, 68, 169, 20);
		contentPane.add(txtNome);

		JLabel lblPeriodo = new JLabel("Per\u00EDodo");
		lblPeriodo.setBounds(10, 103, 56, 14);
		contentPane.add(lblPeriodo);

		JComboBox comboPeriodo = new JComboBox();

		DefaultComboBoxModel<String> modelPeriodo = new DefaultComboBoxModel<String>();

		// tipo da variavel deve ser o mesmo que vou extrair, a cada volta � extraido o
		// valor(nesse caso s�o os valores do per�odo) e guardado em p, : � apenas o separador
		
		for (Periodo p : Periodo.values()) {
			modelPeriodo.addElement(p.getDescricao());
		}

		comboPeriodo.setModel(modelPeriodo);
		comboPeriodo.setBounds(78, 99, 169, 22);
		contentPane.add(comboPeriodo);

		JButton btnSalvarAluno = new JButton("Salvar aluno");
		btnSalvarAluno.setBounds(91, 179, 143, 38);
		contentPane.add(btnSalvarAluno);

		JLabel lblListaDeAlunos = new JLabel("Lista de Alunos:");
		lblListaDeAlunos.setBounds(271, 24, 136, 14);
		contentPane.add(lblListaDeAlunos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 41, 136, 209);
		contentPane.add(scrollPane);

		JList listAlunos = new JList();
		DefaultListModel<String> listaModel = new DefaultListModel<String>();
		listAlunos.setModel(listaModel);
		scrollPane.setViewportView(listAlunos);
		
		JButton btnMostrarAlunos = new JButton("Exibir alunos");
		btnMostrarAlunos.setBounds(91, 228, 143, 14);
		contentPane.add(btnMostrarAlunos);
		
		AlunoRepository turma = new AlunoRepository(3);
		
		
		btnSalvarAluno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Aluno aluno = new Aluno();
				aluno.setMatricula(txtMatricula.getText());
				aluno.setNome(txtNome.getText());
				
				turma.gravar(aluno, posicao);
				
				posicao++;
				
				//Adicionar o nome do aluno ao model da lista
				
				listaModel.addElement(aluno.getNome());
			}
		});
		
		btnMostrarAlunos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (Aluno aluno : turma.listarTodos()) {
					System.out.println(aluno.getMatricula());
					System.out.println(aluno.getNome());
					System.out.println("-----------------------");
				}
				
			}
		});
	}
}
