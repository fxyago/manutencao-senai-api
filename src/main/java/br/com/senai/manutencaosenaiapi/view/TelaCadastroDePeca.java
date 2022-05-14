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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.service.PecaService;

@Component
public class TelaCadastroDePeca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtId;
	private JTextField edtDescricao;
	private JTextArea jtaEspecificacoes;

	@Autowired
	private PecaService pecaService;
	private JTextField edtQuantidade;

	public TelaCadastroDePeca() {
		setTitle("Cadastro de Peça");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblId = new JLabel("ID");

		edtId = new JTextField();
		edtId.setEditable(false);
		edtId.setColumns(10);

		JLabel lblDescricao = new JLabel("Descrição");

		edtDescricao = new JTextField();
		edtDescricao.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (edtId.getText() != null && edtId.getText().length() > 0) {
						
						Peca pecaSalva = new Peca();
						pecaSalva.setDescricao(edtDescricao.getText());
						pecaSalva.setQtdeEmEstoque(Integer.parseInt(edtQuantidade.getText()));
						pecaSalva.setEspecificacoes(jtaEspecificacoes.getText());
						pecaSalva.setId(Integer.parseInt(edtId.getText()));
						JOptionPane.showMessageDialog(contentPane, "Peça alterada com sucesso");
						
					} else {
						Peca novaPeca = new Peca();
						novaPeca.setDescricao(edtDescricao.getText());
						novaPeca.setQtdeEmEstoque(Integer.parseInt(edtQuantidade.getText()));
						novaPeca.setEspecificacoes(jtaEspecificacoes.getText());

						Peca pecaSalva = pecaService.inserir(novaPeca);
						edtId.setText(pecaSalva.getId().toString());
						JOptionPane.showMessageDialog(contentPane, "Peça inserida com sucesso");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage());
					e1.printStackTrace();
				}
			}
		});

		JLabel lblQuantidade = new JLabel("Quantidade");

		edtQuantidade = new JTextField();
		edtQuantidade.setColumns(10);

		JLabel lblEspecificacoes = new JLabel("Especificações");

		jtaEspecificacoes = new JTextArea();
		jtaEspecificacoes.setLineWrap(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnSalvar).addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblEspecificacoes)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblId).addComponent(edtId, GroupLayout.PREFERRED_SIZE, 49,
														GroupLayout.PREFERRED_SIZE))
										.addGap(41)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(edtDescricao, GroupLayout.PREFERRED_SIZE, 216,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDescricao))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblQuantidade).addComponent(edtQuantidade,
														GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))))
						.addGap(31))
				.addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup().addGap(1)
								.addComponent(jtaEspecificacoes, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
								.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblId)
						.addComponent(lblDescricao).addComponent(lblQuantidade))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(edtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(edtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(edtQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblEspecificacoes)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(jtaEspecificacoes, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE).addComponent(btnSalvar)
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	public void colocarEmEdicao(Peca pecaSalva) {
		edtId.setText(pecaSalva.getId().toString());
		edtDescricao.setText(pecaSalva.getDescricao());
		jtaEspecificacoes.setText(pecaSalva.getEspecificacoes());
		edtQuantidade.setText(pecaSalva.getQtdeEmEstoque().toString());
	}
}
