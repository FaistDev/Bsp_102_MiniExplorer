
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class FileComparer {
    private ArrayList<Item> directorys = new ArrayList<>();
    private ArrayList<Item> files = new ArrayList<>();
    
    public void sort(ArrayList<Item> items){
        for (Item i : items) {
            if(i.isDirectory()){
                directorys.add(i);
            }
            if(i.isFile()){
                files.add(i);
            }
        }
        
        Collections.sort(directorys, new Comparator<Item>() {

            @Override
            public int compare(Item o1, Item o2) {
                return o1.compareTo(o2);
            }
        });
        
        Collections.sort(files, new Comparator<Item>() {

            @Override
            public int compare(Item o1, Item o2) {
                return o1.compareTo(o2);
            }
        });
    }
    
}
