package codegym.vn.musicupload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private String name;
    private String artist;
    private String genre;
    private String filePath;
}
