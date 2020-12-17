package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class File {
    private String name;
    private String path;
    private Instant lastOpen;
}
