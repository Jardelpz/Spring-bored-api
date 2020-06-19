package com.example.demo.Controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import com.example.demo.Model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BoredController {
    String api = "https://www.boredapi.com/api/activity?";
    private RestTemplate restTemplate;

    @Autowired
	public void restTemplate(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

    @GetMapping("/bored")
    public Bored getBored(){        
        int participantes = 1;
        int hour = horaDia();
        String tipo = discoverType(hour);
        String  url = makeUrl(api, participantes, tipo);
        Bored bored = restTemplate.getForObject(url, Bored.class);
        bored.setHour(hour);
        
       // list.addBored(bored);
        return bored;
    }

    
    @GetMapping("/resumo")
    public ArrayList<Bored> getResumo(){
        int horarios[] = {4,8,11,13,17};
        ArrayList<Bored> boreds = new ArrayList<>();
        Bored bored;
        String tipo, url;
        for(int i = 0; i < horarios.length; i++){
            tipo = discoverType(horarios[i]);
            url = makeUrlResumo(api, tipo);
            bored = restTemplate.getForObject(url, Bored.class);
            boreds.add(bored);
        }
        System.out.println(boreds);
        return boreds;
    }

    @GetMapping("/dupla")
    public Bored getDoubleActivity(){        
        int participantes = 2;
        String  url = makeUrl(api, participantes);
        Bored bored = restTemplate.getForObject(url, Bored.class);
        return bored;
    }

    @GetMapping("/cost")
    public Bored getMidnightActivity(){    
        float preco = 0;
        String tipo = discoverType(0);
        String  url = makeUrl(api, tipo, preco);
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

    public String makeUrl(String url, int participants){
        return url + "participants=" + participants;
    }

    public String makeUrl(String url, String tipo, float preco){
        return url + "price=" + preco + tipo;
    }

    public String makeUrlResumo(String url, String tipo){
        return url + tipo;
    }

    public String discoverType(int hour){
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