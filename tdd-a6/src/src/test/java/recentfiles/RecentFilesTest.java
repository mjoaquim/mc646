package recentfiles;

import model.File;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testWhenMultipleEqualsFilesAreAdded() {
        recentFiles.addFile(buildFile());
        recentFiles.addFile(buildFile());
        List<File> list = recentFiles.getList();
        assertEquals(1, list.size());
    }

    @Test
    public void testWhenMultipleFilesAreAdded() {
        final File file1  = buildFile();
        recentFiles.addFile(file1);
        recentFiles.addFile(buildFile2());
        recentFiles.addFile(file1);
        List<File> list = recentFiles.getList();
        assertFalse(list.isEmpty());
        assertEquals(file1, list.get(0));
    }

    private File buildFile() {
        return File.builder()
                   .name(name)
                   .path(path)
                   .lastOpen(Instant.now())
                   .build();
    }

    private File buildFile2() {
        return File.builder()
                .name(name + "_2")
                .path(path)
                .lastOpen(Instant.now())
                .build();
    }

}
