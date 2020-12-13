package net.oneqas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class OneqasMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(OneqasMain.class);
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        String dateToString = simpleDateFormat.format(date);
//        System.out.println(dateToString);
    }

}
