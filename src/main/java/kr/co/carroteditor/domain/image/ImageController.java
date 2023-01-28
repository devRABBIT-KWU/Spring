package kr.co.carroteditor.domain.image;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;


    /**
     * 이미지 저장
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestPart("image") MultipartFile multipartFile) throws IOException {
        imageService.save(multipartFile);
        return ResponseEntity.ok("이미지 저장완료");
    }


    /**
     * 저장되어있는 이미지 리스트 반환하기
     *
     * @return ImageList
     */

    @GetMapping("/images")
    public ResponseEntity<?> getImageList() {
        List<Image> list = imageService.getList();
        return ResponseEntity.ok(list);

    }


}
