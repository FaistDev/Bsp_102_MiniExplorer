
import java.io.File;
import java.time.LocalDateTime;
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

    public void addFiles(Item i) {
        items.add(i);
        fireIntervalAdded(this, items.size() - 1, items.size() - 1);
    }

    public void load() {

        File folder = new File("D:\\Privat\\Schule\\POS\\Git\\Bsp_102_MiniExplorer\\Bsp_102_MiniExplorer");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
                addFiles(new Item(file.getName(), file.lastModified(), (int)file.length(), null, file.getAbsolutePath()));
            }else if(file.isDirectory()){
                addFiles(new Item(file.getName(),file.getAbsolutePath()));
            }
        }

    }
}
