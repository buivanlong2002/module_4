package codegym.vn.musicupload.controller;

import codegym.vn.musicupload.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final String UPLOAD_FOLDER = "D:\\uploads\\"; // Đảm bảo thư mục này tồn tại
    private final List<Song> songList = new ArrayList<>();

    private final Set<String> allowedExtensions =
            new HashSet<>(Arrays.asList("mp3", "wav", "ogg", "m4p"));

    @PostConstruct
    public void init() {
        File dir = new File(UPLOAD_FOLDER);
        if (!dir.exists()) dir.mkdirs();
    }

    @GetMapping("/upload")
    public String showForm(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("genres", Arrays.asList("Pop", "Rock", "Jazz", "EDM", "Classical"));
        return "upload";
    }

    @PostMapping("/upload")
    public String handleUpload(@ModelAttribute Song song,
                               @RequestParam("musicFile") MultipartFile file,
                               Model model) throws IOException {

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        String ext = getFileExtension(originalFilename);

        if (!allowedExtensions.contains(ext)) {
            model.addAttribute("error", "Chỉ chấp nhận file .mp3, .wav, .ogg, .m4p");
            model.addAttribute("genres", Arrays.asList("Pop", "Rock", "Jazz", "EDM", "Classical"));
            return "upload";
        }

        File saveFile = new File(UPLOAD_FOLDER, originalFilename);
        file.transferTo(saveFile);

        song.setFilePath(originalFilename);
        songList.add(song);

        return "redirect:/songs/list";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("songs", songList);
        return "list";
    }

    private String getFileExtension(String fileName) {
        if (fileName == null) return "";
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex >= 0) ? fileName.substring(dotIndex + 1).toLowerCase() : "";
    }
}

