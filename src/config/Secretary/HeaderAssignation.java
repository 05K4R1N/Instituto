/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package config.Secretary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author OscarT
 */
public class HeaderAssignation  extends JLabel implements TableCellRenderer{

    public HeaderAssignation(){
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("Lao UI", Font.BOLD, 16));
        setBackground(new Color(102, 102, 255));
        setForeground(Color.WHITE);
        setOpaque(true);
        setBorder(BorderFactory.createEtchedBorder());
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
    
}
