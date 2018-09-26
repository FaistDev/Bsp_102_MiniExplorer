
import java.io.File;
import java.util.ArrayList;
import javax.swing.AbstractListModel;


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

    public void sortieren() {
        ArrayList<Item> help = new ArrayList<>();
        FileComparer f = new FileComparer();
        help=f.sort(items);
        
        items.clear();
        items.addAll(help);
        
    }
    
    public void attributs(){
        for (Item item : items) {
            if(item.canRead()){
                item.setAttribut("R");
            }
            if(item.canWrite()){
                item.setAttribut("W");
            }
            if(item.canExecute()){
                item.setAttribut("X");
            }
        }
    }
    
    public void load() {

        File folder = new File("D:\\Privat\\Schule\\POS\\Git\\Bsp_102_MiniExplorer\\Bsp_102_MiniExplorer");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
                addFiles(new Item(file.getName(), file.lastModified(), (int) file.length(), file.getAbsolutePath()));
            } else if (file.isDirectory()) {
                addFiles(new Item(file.getName(), file.getAbsolutePath()));
            }
        }

    }

    public void goDeeper(int index) {
        File folder = new File(items.get(index).getAbsolutePath());
        File[] listOfFiles = folder.listFiles();
        items.clear();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
                addFiles(new Item(file.getName(), file.lastModified(), (int) file.length(), file.getAbsolutePath()));
            } else if (file.isDirectory()) {
                addFiles(new Item(file.getName(), file.getAbsolutePath()));
            }
        }
    }
}
