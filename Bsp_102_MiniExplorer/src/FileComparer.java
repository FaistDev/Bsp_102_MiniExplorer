
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FileComparer {

    ArrayList<Item> files = new ArrayList<>();
    ArrayList<Item> directories = new ArrayList<>();
    ArrayList<Item> all = new ArrayList<>();
    
    public ArrayList<Item> sort(ArrayList<Item> items) {
        for (Item item : items) {
            if (item.isDirectory()) {
                directories.add(item);
            } else if (item.isFile()) {
                files.add(item);
            }
        }

        Collections.sort(files, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.compareTo(o2);
            }

        });

        Collections.sort(directories, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.compareTo(o2);
            }

        });
        
        all.addAll(directories);
        all.addAll(files);
        
        return all;
    }

}
