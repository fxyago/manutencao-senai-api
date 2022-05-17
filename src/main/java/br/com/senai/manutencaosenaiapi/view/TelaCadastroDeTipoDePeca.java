package br.com.senai.manutencaosenaiapi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;
import br.com.senai.manutencaosenaiapi.service.TipoDePecaService;

@Component
public class TelaCadastroDeTipoDePeca extends JFrameVoltavel {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	@Autowired
	private TipoDePecaService service;
	
	private JTextField edtId;
	private JTextField edtDescricao;
	
	public TelaCadastroDeTipoDePeca() {
		resetarTitulo();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblId = new JLabel("Id");
		
		edtId = new JTextField();
		edtId.setEnabled(false);
		edtId.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição");
		
		edtDescricao = new JTextField();
		edtDescricao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TipoDePeca novoTipo = new TipoDePeca();
					novoTipo.setDescricao(edtDescricao.getText());
					
					if (edtId != null) {
						novoTipo.setId(Integer.parseInt(edtId.getText()));
					}
					
					service.inserir(novoTipo);
					JOptionPane.showMessageDialog(getContentPane(), "Peça inserida com sucesso");
					trocarPara(telaAnterior);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(), e2.getMessage());
				}
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltarPara(telaAnterior);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId)
								.addComponent(edtId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescricao)
								.addComponent(edtDescricao, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
							.addComponent(btnSalvar)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(lblDescricao))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(edtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(edtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnVoltar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void colocarEmEdicao(TipoDePeca tipoSalvo) {
		this.setTitle("Edição de tipo de peça");
		edtId.setText(tipoSalvo.getId().toString());
		edtDescricao.setText(tipoSalvo.getDescricao());
	}
	
	public void adicionarNovoTipo() {
		this.resetarTitulo();
		this.limparCampos();
	}
	
	private void resetarTitulo() {
		this.setTitle("Cadastro de Tipo de Peça");
	}
	
	private void limparCampos() {
		this.edtId.setText("");
		this.edtDescricao.setText("");
	}
	
}
