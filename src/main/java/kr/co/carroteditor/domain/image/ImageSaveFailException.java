package kr.co.carroteditor.domain.image;

public class ImageSaveFailException extends RuntimeException {

    static final String message = "이미지 저장을 실패하였습니다.";

    public ImageSaveFailException() {
        super(message);
    }


}
