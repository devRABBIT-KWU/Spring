package kr.co.carroteditor.domain.image;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageService {

    private final ImageRepository repository;

    static final String FILEPATH = "C:\\study-project\\spring\\CarrotEditor\\src\\main\\resources\\images\\";


    @Transactional
    public void save(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            throw new ImageSaveFailException();
        }
        File file = new File(FILEPATH);
        file.mkdirs();
        String[] ext = multipartFile.getOriginalFilename().split("\\.");

        if (!extValidationCheck(ext[1])) {
            throw new ImageSaveFailException();
        }

        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_DD_ss_SSSS"));
        String fullPath = FILEPATH + now + "." + ext[1];
        multipartFile.transferTo(new File(fullPath));
        Image image = new Image(now, fullPath);
        repository.save(image);
    }

    private boolean extValidationCheck(String ext) {
        String[] validExt = {"jpg", "jpeg", "png", "gif"};
        for (String s : validExt) {
            if (s.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    public List<Image> getList() {
        return repository.findAll();
    }

    public Image getImage(String uuid) {
        return  repository.findByUuid(uuid);
    }
}
