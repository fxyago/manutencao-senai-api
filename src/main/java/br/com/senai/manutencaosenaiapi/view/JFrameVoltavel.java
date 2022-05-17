package br.com.senai.manutencaosenaiapi.view;

import javax.swing.JFrame;

public abstract class JFrameVoltavel extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	protected JFrameVoltavel telaAnterior;

	public void setAnterior(JFrameVoltavel anterior) {
		this.telaAnterior = anterior;
	}
	
	protected void trocarPara(JFrameVoltavel tela) {
		this.setVisible(false);
		tela.setLocation(this.getLocation());
		tela.setAnterior(this);
		tela.setVisible(true);
	}
	
	protected void voltarPara(JFrameVoltavel tela) {
		this.setVisible(false);
		tela.setLocation(this.getLocation());
		tela.setVisible(true);
	}
	
}
