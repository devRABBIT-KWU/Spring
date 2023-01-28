package kr.co.carroteditor.domain.image;

import lombok.Data;

@Data
public class ImageSave {

    private final String title;
    private final String image;

    public Image toEntity() {
        return Image.builder().titie(title).image(image).build();
    }
}
