package recentfiles;

import lombok.AllArgsConstructor;
import model.File;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class RecentFiles {

    private final List<File> elements = new ArrayList<>();

    public List<File> getList(){
        return elements;
    }
}
