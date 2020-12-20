package recentfiles;

import lombok.AllArgsConstructor;
import model.File;

import java.util.*;

@AllArgsConstructor
public class RecentFiles {

    private final List<File> elements = new ArrayList<>();

    public List<File> getList(){
        return elements;
    }

    public void addFile(final File file) {
        elements.remove(file);
        elements.add(0, file);
    }
}
