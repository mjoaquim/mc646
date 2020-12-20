package recentfiles;

import lombok.AllArgsConstructor;
import model.File;

import java.util.*;

@AllArgsConstructor
public class RecentFiles {

    private final List<File> elements = new ArrayList<>();
    private static final int MAX_SIZE_LIST = 10;

    public List<File> getList(){
        return elements;
    }

    public void addFile(final File file) {
        elements.remove(file);
        elements.add(0, file);
        reduce();
    }

    private void reduce() {
        while(elements.size() > MAX_SIZE_LIST) {
            elements.remove(elements.size() - 1);
        }
    }
}
