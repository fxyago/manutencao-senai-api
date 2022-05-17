package br.com.senai.manutencaosenaiapi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.service.PecaService;
import br.com.senai.manutencaosenaiapi.view.table.PecaTableModel;

@Component
public class TelaConsultaDePeca extends JFrameVoltavel {

	@Autowired
	private PecaService service;
	
	@Autowired
	private TelaCadastroDePeca telaDeCadastro;
	
	private static final long serialVersionUID = 1L;
	private JPanel TelaConsultaDePeca;
	private JTextField edtFiltro;
	private JTable table;

	public TelaConsultaDePeca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 421);
		TelaConsultaDePeca = new JPanel();
		TelaConsultaDePeca.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(TelaConsultaDePeca);

		table = new JTable();
		JLabel lblFiltro = new JLabel("Filtro");

		edtFiltro = new JTextField();
		edtFiltro.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Peca> pecas = service.listarPor(edtFiltro.getText());
					PecaTableModel model = new PecaTableModel(pecas);
					table.setModel(model);
					TableColumnModel cm = table.getColumnModel();
					cm.getColumn(0).setPreferredWidth(50);
					cm.getColumn(1).setPreferredWidth(500);
					cm.getColumn(2).setPreferredWidth(50);
					table.updateUI();					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(getContentPane(), e1.getMessage());
				}
			}
		});

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaDeCadastro.setLocation(getLocation());
				trocarPara(telaDeCadastro);
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int linhaSelecionada = table.getSelectedRow();
					PecaTableModel model = (PecaTableModel) table.getModel();
					var pecaSelecionada = model.getPor(linhaSelecionada);
					telaDeCadastro.colocarEmEdicao(pecaSelecionada);
					trocarPara(telaDeCadastro);
				} catch (IndexOutOfBoundsException ioobe) {
					JOptionPane.showMessageDialog(getContentPane(), "Nenhuma peça selecionada");
				}
				
			
			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int linhaSelecionada = table.getSelectedRow();
					PecaTableModel model = (PecaTableModel) table.getModel();
					Peca pecaSalva = model.getPor(linhaSelecionada);
					service.removerPor(pecaSalva.getId());
					model.removerPor(linhaSelecionada);
					table.updateUI();
					JOptionPane.showMessageDialog(getContentPane(), "Peça removida com sucesso");					
				} catch (IndexOutOfBoundsException ioobe) {
					JOptionPane.showMessageDialog(getContentPane(), "Nenhuma peça selecionada");
				}
			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es para linha selecionada", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocarPara(telaAnterior);
			}
		});
		GroupLayout gl_TelaDeConsultaDePeca = new GroupLayout(TelaConsultaDePeca);
		gl_TelaDeConsultaDePeca.setHorizontalGroup(
			gl_TelaDeConsultaDePeca.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TelaDeConsultaDePeca.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_TelaDeConsultaDePeca.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_TelaDeConsultaDePeca.createSequentialGroup()
							.addComponent(edtFiltro, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdicionar))
						.addGroup(gl_TelaDeConsultaDePeca.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_TelaDeConsultaDePeca.createSequentialGroup()
								.addComponent(btnVoltar)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblFiltro))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_TelaDeConsultaDePeca.setVerticalGroup(
			gl_TelaDeConsultaDePeca.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TelaDeConsultaDePeca.createSequentialGroup()
					.addComponent(lblFiltro)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_TelaDeConsultaDePeca.createParallelGroup(Alignment.BASELINE)
						.addComponent(edtFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdicionar)
						.addComponent(btnPesquisar))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_TelaDeConsultaDePeca.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_TelaDeConsultaDePeca.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(24))
						.addGroup(gl_TelaDeConsultaDePeca.createSequentialGroup()
							.addGap(41)
							.addComponent(btnVoltar)
							.addContainerGap())))
		);
		
		scrollPane.setColumnHeaderView(table.getTableHeader());

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE).addComponent(btnExcluir)
						.addGap(23)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel
						.createParallelGroup(Alignment.BASELINE).addComponent(btnExcluir).addComponent(btnEditar))
						.addContainerGap(29, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		TelaConsultaDePeca.setLayout(gl_TelaDeConsultaDePeca);
	}
	
}
