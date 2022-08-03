

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hornet
 */
import java.io.File;
import javax.swing.filechooser.FileFilter;
 
public class FileTypeFilter extends FileFilter {
 
    private String extension;
    private String description;
     
    public FileTypeFilter(String extension, String description) {
        this.extension = extension;
        this.description = description;
    }
     
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        return file.getName().toLowerCase().endsWith(extension);
    }
     
    public String getDescription() {
        return description + String.format(" (*%s)", extension);
    }
}