package ct250.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/f")
public class filter {

    @GetMapping()
    public void Temp() {
        RestTemplate restTemplate = new RestTemplate();
        String pythonApiUrl = "http://127.0.0.1:5000/hello";
        String response = restTemplate.getForObject(pythonApiUrl, String.class);

        System.out.println("fffff");
        // Xử lý phản hồi từ API Python ở đây
        System.out.println(response);
    }

}
