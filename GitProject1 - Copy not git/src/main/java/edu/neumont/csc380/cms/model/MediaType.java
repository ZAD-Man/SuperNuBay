package edu.neumont.csc380.cms.model;

import edu.neumont.csc380.cms.exception.BadMimeTypeException;

public enum MediaType {
	JPEG(false), PNG(false), MOV(true), MP4(true);

	public boolean isVideo;

	MediaType(boolean isVideo) {
		this.isVideo = isVideo;
	}

	public boolean isVideo() {
		return isVideo;
	}

	public String toMIME() {
		String type = this == MOV ? "quicktime" : this.toString();
		return (isVideo ? "video" : "image") + "/" + type;
	}

	public static MediaType parse(String mimeType) {

        String x = mimeType.toLowerCase();
        if(x.equals("image/png"))
            return PNG;
        if(x.equals("image/jpeg"))
            return JPEG;
        if(x.equals("video/mp4"))
            return MP4;
        if(x.equals("video/quicktime"))
            return MOV;

        throw new BadMimeTypeException();
	}
}
