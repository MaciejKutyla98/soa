package pl.egu.agh.soa.lab.consume;

import pl.egu.agh.soa.lab.GetStudentsResponse;
import pl.egu.agh.soa.lab.Service;
import pl.egu.agh.soa.lab.ServiceService;

import javax.xml.ws.BindingProvider;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

public class APIconsumption {
    private static ServiceService service = new ServiceService();

    public static void consume() {
        Service studentServicePort = service.getServicePort();
        Map<String, Object> reqContext = ((BindingProvider)
                studentServicePort).getRequestContext();
        reqContext.put(BindingProvider.USERNAME_PROPERTY, "admin1");
        reqContext.put(BindingProvider.PASSWORD_PROPERTY, "password");

        GetStudentsResponse.Students students = studentServicePort.getStudents();
        String avatar = studentServicePort.getBase64Avatar(297242);
        studentServicePort.addNewStudent(297226, "Jacek Placek", 24);

        try (
                FileOutputStream fos = new FileOutputStream("/decodedImage.jpg")) {
            byte[] imageByteArray = Base64.getDecoder().decode(avatar);
            fos.write(imageByteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
