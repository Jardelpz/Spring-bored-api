package com.example.demo;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;s
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BoredController {
    ArrayList<Bored> boreds = new ArrayList<>();

    private RestTemplate restTemplate;

    @Autowired
	public void restTemplate(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

    @GetMapping("/bored")
    public Bored getBored(){
        String api = "https://www.boredapi.com/api/activity?";
        int participantes = 1;
        int hour = horaDia();
        String tipo = discoverHour(hour);
        String  url = makeUrl(api, participantes, tipo);
        Bored bored = restTemplate.getForObject(url, Bored.class);
        return bored;
    }

    public int horaDia(){
        Calendar data = Calendar.getInstance();
        return data.get(Calendar.HOUR_OF_DAY);  
    }

    public String makeUrl(String url, int participants, String tipo){
        return url + "participants=" + participants + tipo;
    }

    public String discoverHour(int hour){
        String tip = "&type=";
 
        if (hour >= 0 && hour < 5){
            String [] res = {"recreational", "relaxation", "music"};
            int num = gerarNum(res.length);
            return tip+res[num];

        }else if(hour < 9){
           return  tip+"education";

        }else if(hour < 12){
            return tip+"busywork";

        }else if(hour < 14){
            String[] res = {"education", "recreational", "social", "relaxation"};
            int num = gerarNum(res.length);
            return tip+res[num];

        }else if (hour < 18){
            return tip+"busywork";

        }else{
            String []res = {"education", "recreational", "social", "diy", "charity", "cooking", "relaxation", "music"};
            int num = gerarNum(res.length);
            return tip+res[num];
        }
    }

    public int gerarNum(int maxValue){
        Random r = new Random();
        return r.nextInt(maxValue);
    }
}