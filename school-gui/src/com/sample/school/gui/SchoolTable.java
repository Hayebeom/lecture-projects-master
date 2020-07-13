package com.sample.school.gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class SchoolTable extends JTable {

	public SchoolTable(TableModel model) {
		super(model);
		this.setRowHeight(35);
		this.getTableHeader().setPreferredSize(new Dimension(100, 40));
		this.getTableHeader().setFont(new Font("굴림", Font.BOLD, 23));
		this.setFont(new Font("굴림", Font.PLAIN, 18));
		this.setDefaultRenderer(String.class, new SchoolTableCellRenderer());
	}
	
	class SchoolTableCellRenderer extends DefaultTableCellRenderer {
		
		@Override
		public int getHorizontalAlignment() {
			return CENTER;
		}
		
	}
}
