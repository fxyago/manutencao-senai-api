package br.com.senai.manutencaosenaiapi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.NoSuchElementException;

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

import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;
import br.com.senai.manutencaosenaiapi.service.TipoDePecaService;
import br.com.senai.manutencaosenaiapi.view.table.TipoPecaTableModel;

@Component
public class TelaConsultaDeTipoDePeca extends JFrameVoltavel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edtParametro;
	
	public static TelaConsultaDeTipoDePeca SELF;

	@Autowired
	private TelaCadastroDeTipoDePeca telaDeCadastroDeTipo;
	
	@Autowired
	private TipoDePecaService service;
	private JTable table;
	
	private JScrollPane scrollPane;
	
	private JPanel panel = new JPanel();
	
	public TelaConsultaDeTipoDePeca() {
		setTitle("Consulta de tipo de peça");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		scrollPane = new JScrollPane(table);
		
		JLabel lblParametro = new JLabel("Parâmetro");
		
		edtParametro = new JTextField();
		edtParametro.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<TipoDePeca> tipos = service.listarPor(edtParametro.getText());
					TipoPecaTableModel model = new TipoPecaTableModel(tipos);
					table.setModel(model);
					TableColumnModel cm = table.getColumnModel();
					cm.getColumn(0).setPreferredWidth(50);
					cm.getColumn(1).setPreferredWidth(500);
					table.updateUI();
				} catch (NoSuchElementException nsee) {
					JOptionPane.showMessageDialog(getContentPane(), "Nenhum tipo encontrado");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(), e2.getMessage());
				}
			}
		});
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaDeCadastroDeTipo.adicionarNovoTipo();
				trocarPara(telaDeCadastroDeTipo);
			}
		});
		
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es para a linha selecionada", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocarPara(telaAnterior);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(lblParametro)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(edtParametro, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdicionar)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnVoltar)
							.addPreferredGap(ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblParametro)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(edtParametro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdicionar)
						.addComponent(btnPesquisar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnVoltar)
							.addGap(29))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int linhaSelecionada = table.getSelectedRow();
					TipoPecaTableModel tipoModel = (TipoPecaTableModel) table.getModel();
					tipoModel.removerPor(linhaSelecionada);
					JOptionPane.showMessageDialog(getContentPane(), "Tipo de peça removido com sucesso");
					table.updateUI();
				} catch (IndexOutOfBoundsException ioobe) {
					JOptionPane.showMessageDialog(getContentPane(), "Nenhuma peça selecionada");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(), e2.getMessage());
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int linhaSelecionada = table.getSelectedRow();
					TipoPecaTableModel tipoModel = (TipoPecaTableModel) table.getModel();
					TipoDePeca tipoSalvo = tipoModel.getPor(linhaSelecionada);
					telaDeCadastroDeTipo.colocarEmEdicao(tipoSalvo);
					trocarPara(telaDeCadastroDeTipo);
				} catch (IndexOutOfBoundsException ioobe) {
					JOptionPane.showMessageDialog(getContentPane(), "Nenhuma peça selecionada");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getContentPane(), e2.getMessage());
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExcluir)
						.addComponent(btnEditar))
					.addGap(27))
		);
		scrollPane.setColumnHeaderView(table.getTableHeader());
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
}
