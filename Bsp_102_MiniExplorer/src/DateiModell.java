
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class DateiModell extends AbstractListModel<Item> {

    private ArrayList<Item> items = new ArrayList<>();
    
    
    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public Item getElementAt(int index) {
        return items.get(index);
    }
    
    public void addFiles(Item i){
        items.add(i);
        fireIntervalAdded(this, items.size()-1, items.size()-1);
    }
    
}
