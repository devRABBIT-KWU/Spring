package kr.co.carroteditor.domain.pixabay;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Pixabay {
    public int total;
    public int totalHits;
    public List<Hit> hits = new ArrayList<>();
    
    @Data
    public static class Hit {

        public int id;
        public String pageURL;
        public String type;
        public String tags;
        public String previewURL;
        public int previewWidth;
        public int previewHeight;
        public String webformatURL;
        public int webformatWidth;
        public int webformatHeight;
        public String largeImageURL;
        public int imageWidth;
        public int imageHeight;
        public int imageSize;
        public int views;
        public int downloads;
        public int collections;
        public int likes;
        public int comments;
        public int userId;
        public String user;
        public String userImageURL;


    }
}
