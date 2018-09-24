
import java.io.File;
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class Item extends File{

    private String dateiname;
    private LocalDateTime datum;
    private int kb;
    private String attribut;
    
    public Item(String pathname) {
        super(pathname);
    }
    
}
