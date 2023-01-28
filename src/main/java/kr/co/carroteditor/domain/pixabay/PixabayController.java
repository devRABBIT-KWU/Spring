package kr.co.carroteditor.domain.pixabay;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PixabayController {

    /**
     * Pixabay 이미지 검색 API
     * @param search
     * @return
     */
    @GetMapping("/api/images")
    public ResponseEntity<?> image(@RequestParam String search) {
        RestTemplate restTemplate = new RestTemplate();
        Pixabay pixabay = restTemplate.getForObject("https://pixabay.com/api/?key=29867997-f6043e3d346a57cb9812020e0&q=" + search, Pixabay.class);
        return ResponseEntity.ok(pixabay);
    }
}
