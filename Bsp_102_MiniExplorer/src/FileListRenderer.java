
import java.awt.Color;
import java.awt.Component;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ben
 */
public class FileListRenderer implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Item) {
            Item i = (Item) value;
            Component c = null;
            if (i.isDirectory()) {
                JLabel label = new JLabel(i.getName());
                label.setOpaque(true);
                label.setForeground(Color.red);
                c = label;
            }
            if (i.isFile()) {
                JLabel label = new JLabel(i.getName()+" "+i.getDatum().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))+" "+i.getKb()+" "+i.getAttribut());
                label.setOpaque(true);
                label.setForeground(Color.blue);
                c = label;
            }

            if (isSelected) {
                c.setBackground(Color.lightGray);
            } else {
                c.setBackground(Color.white);
            }
            return c;
        }
        return new JLabel("???");
    }

}
