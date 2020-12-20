package recentfiles;

import model.File;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecentFilesTest {

    private RecentFiles recentFiles = new RecentFiles();
    private static final String NAME = "NAME";
    private static final String PATH = "PATH";
    private static final int MAX_SIZE_LIST = 10;

    @Test
    public void testWhenProgramStartsAndEmptyListIsExpected() {
        List<File> list = recentFiles.getList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testWhenFileIsAddedAndFeatureIsEnabled() {
        recentFiles.addFile(buildFile(), true);
        List<File> list = recentFiles.getList();
        assertFalse(list.isEmpty());
    }

    @Test
    public void testWhenMultipleEqualsFilesAreAddedAndFeatureIsEnabled() {
        recentFiles.addFile(buildFile(), true);
        recentFiles.addFile(buildFile(), true);
        List<File> list = recentFiles.getList();
        assertEquals(1, list.size());
    }

    @Test
    public void testWhenMultipleFilesAreAddedAndFeatureIsEnabled() {
        for(int i = 0; i < MAX_SIZE_LIST*2; i++) {
            recentFiles.addFile(buildFile().toBuilder()
                                           .name(NAME.concat(String.valueOf(i)))
                                           .build(), true);
        }
        List<File> list = recentFiles.getList();
        assertEquals(NAME.concat(String.valueOf((MAX_SIZE_LIST*2)-1)), list.get(0).getName());
        assertEquals(list.size(), MAX_SIZE_LIST);
    }

    @Test
    public void testWhenCleanRecentFilesAndFeatureIsEnabled() {
        for(int i = 0; i < MAX_SIZE_LIST*2; i++) {
            recentFiles.addFile(buildFile().toBuilder()
                                           .name(NAME.concat(String.valueOf(i)))
                                           .build(), true);
        }
        List<File> list = recentFiles.getList();
        assertFalse(list.isEmpty());
        recentFiles.cleanList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testWhenCleanRecentFilesAndFeatureIsNotEnabled() {
        for(int i = 0; i < MAX_SIZE_LIST*2; i++) {
            recentFiles.addFile(buildFile().toBuilder()
                    .name(NAME.concat(String.valueOf(i)))
                    .build(), false);
        }
        List<File> list = recentFiles.getList();
        assertTrue(list.isEmpty());
    }


    private File buildFile() {
        return File.builder()
                   .name(NAME)
                   .path(PATH)
                   .lastOpen(Instant.now())
                   .build();
    }

}
