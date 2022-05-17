package br.com.senai.manutencaosenaiapi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TelaPrincipal extends JFrameVoltavel {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	@Autowired
	private TelaConsultaDeTipoDePeca telaTipoPecas;
	
	@Autowired
	private TelaConsultaDePeca telaPecas;
	
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 167, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnTipoPeca = new JButton("Tipos de Peça");
		btnTipoPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocarPara(telaTipoPecas);
			}
		});
		
		JButton btnPeca = new JButton("Peças");
		btnPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocarPara(telaPecas);
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fechar();
			}

			public void fechar() {
				TelaPrincipal.this.dispose();
				TelaPrincipal.this.dispatchEvent(new WindowEvent(TelaPrincipal.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPeca, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnTipoPeca, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(15))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnTipoPeca)
					.addGap(18)
					.addComponent(btnPeca)
					.addGap(20)
					.addComponent(btnSair)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
