package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;s
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoredController {
    ArrayList<Bored> boreds = new ArrayList<>();

    private RestTemplate restTemplate;

    @Autowired
	public BoredController restTemplate(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

    @GetMapping("/bored")
    public Bored getBored(){
        String url = 'https://www.boredapi.com/api/activity?';
        Date data = new Date();
        int hour = data.toInstant().atZone(ZoneId.systemDefault()).getHour();
        tipo = discoverHour(hour)
        int participantes = 1;
        Bored bored = restTemplate.getForObject(url + "participants=" participantes + tipo, Bored.class)
        return bored;
    }

    public String discoverHour(int hour){
        String tip = "&types=";
        if (hour > 0 && (hour <6){
            List res = ["recreational", "relaxation", "music"];
            int num = random(res.size());
            return tip+res[num];

        }else if(hour < 10){
           return  tip+"education";

        }else if(hour < 13){
            return tip+"busywork";

        }else if(hour < 15){
            List res = ["education", "recreational", "social", "relaxation"];
            int num = random(res.size())
            return tip+res[num];

        }else if (hour < 19){
            return tip+"busywork";

        }else{
            List res = ["education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music"];
            int num =random(res.size())
            return tip+res[num];
        }
    }

    public int random(int limit){
        return Random.nextInt(0, limit);
    }
}