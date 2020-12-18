package recentfiles;

import model.File;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecentFilesTest {

    private RecentFiles recentFiles = new RecentFiles();
    private static final String name = "NAME";
    private static final String path = "PATH";

    @Test
    public void testWhenProgramStartsAndEmptyListIsExpected() {
        List<File> list = recentFiles.getList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testWhenFileIsAdded() {
        recentFiles.addFile(buildFile());
        List<File> list = recentFiles.getList();
        assertFalse(list.isEmpty());
    }

    private File buildFile() {
        return File.builder()
                   .name(name)
                   .path(path)
                   .lastOpen(Instant.now())
                   .build();
    }

}
