package view;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Image;


public final class ImageCellRenderer extends DefaultTableCellRenderer {
 
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {

        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        JLabel label = (JLabel)component;
        String cheminImage = String.valueOf(value);

        ImageIcon icon = new ImageIcon(cheminImage);

        if ( icon.getImageLoadStatus()==java.awt.MediaTracker.COMPLETE ) {
            label.setIcon(icon);
        }
        else {
            label.setIcon(null);
        }
        label.setText(""); // on efface le texte


        return component;
    }


}
