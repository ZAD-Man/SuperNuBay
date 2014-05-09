package edu.neumont.csc380.AuctionServer;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import edu.neumont.csc380.Database.Item;
import edu.neumont.csc380.cms.service.MediaService;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import javax.imageio.ImageIO;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by acottrill on 5/7/2014.
 */
public class CMSService {
    private MediaService service = JAXRSClientFactory.create(
            "http://localhost:8080/CMS-server/api", MediaService.class,
            Arrays.asList(new JacksonJaxbJsonProvider()));

    public Response getMedia(Long id) {
        return service.getMedia(id);
    }

    public Response getMediaData(Long id) {
        return service.getMediaData(id);
    }

    public Response getMediadata(Long id) {
        return service.getMediaThumb(id);
    }

    public void deleteMedia(Long id) {
        service.deleteMedia(id);
    }

    public Response getUserMedia(Long id) {
        return service.getMediaByUser(id);
    }

    public Response getAuctionMedia(Long id) {
        return service.getMediaByAuction(id);
    }

    public void setUserProfilePicture(Long id, String caption, byte[] data,
                                      String mimeType) {
        service.setUserProfilePicture(id, caption, data, mimeType);
    }

    public void addAuctionMedia(Long id, String caption, byte[] data,
                                String mimeType) {
        service.addAuctionMedia(id, caption, data, mimeType);
    }

	public void addAuctionMedia(Item item) {
        String url = item.getImageLink();
        File imgPath = new File(url);
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(imgPath);
            WritableRaster raster = bufferedImage.getRaster();
            DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
            addAuctionMedia(item.getId(), item.getDescription(), data.getData(),
                    "image/jpeg");
            String newLink = getMedia(item.getId()).toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
