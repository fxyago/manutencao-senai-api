package br.com.senai.manutencaosenaiapi.view.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;

public class TipoPecaTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	private final int QTDE_COLUNAS = 2;
	
	private List<TipoDePeca> tipoPecas;
	
	public TipoPecaTableModel(List<TipoDePeca> tipoPecas) {
		this.tipoPecas = tipoPecas;
	}

	@Override
	public int getRowCount() {
		return tipoPecas.size();
	}

	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TipoDePeca tipo = tipoPecas.get(rowIndex);
		if (columnIndex == 0) return tipo.getId();
		if (columnIndex == 1) return tipo.getDescricao();
		throw new IllegalArgumentException("Índice inválido");
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) return "ID";
		if (column == 1) return "Descrição";
		throw new IllegalArgumentException("Índice inválido");
	}
	
	public TipoDePeca getPor(int linha) {
		return tipoPecas.get(linha);
	}
	
	public TipoDePeca removerPor(int linha) {
		return tipoPecas.remove(linha);
	}
	
}
