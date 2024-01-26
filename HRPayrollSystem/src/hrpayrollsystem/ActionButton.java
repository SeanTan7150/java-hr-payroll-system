package hrpayrollsystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

class ActionButton extends JButton {
    
    private boolean mousePressed;
    
    public ActionButton(String buttonText) {
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setText(buttonText);
        setSize(50, 150);
    }
}

class TableActionCellRender extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected, boolean bin1, int row, int col) {
        Component component = super.getTableCellRendererComponent(jtable, o, isSelected, bin1, row, col);
        
        ActionButtonPanel actionButtonPanel = new ActionButtonPanel();
        actionButtonPanel.setBackground(component.getBackground());
        return actionButtonPanel;
    }
}

class TableActionCellEditor extends DefaultCellEditor {
    
    private ActionButtonEvent event;
    
    public TableActionCellEditor(ActionButtonEvent event) {
        super(new JCheckBox());
        this.event = event;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bin, int row, int col) {
        ActionButtonPanel actionButtonPanel = new ActionButtonPanel(); 
        actionButtonPanel.initEvent(event, row);
        actionButtonPanel.setBackground(jtable.getSelectionBackground());
        return actionButtonPanel;
    }
}

interface ActionButtonEvent {
    public void onEdit(int row);
}