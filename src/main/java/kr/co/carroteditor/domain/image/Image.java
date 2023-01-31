package kr.co.carroteditor.domain.image;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Table(name = "canvas_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    private String titie;
    private String image;

    private String uuid;


    @Builder
    public Image(String titie, String image) {
        this.titie = titie;
        this.image = image;
        this.uuid = UUID.randomUUID().toString();
    }
}
