package com.gali;

import com.gali.scheduling.Pusher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class WechatpushApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatpushApplication.class, args);
    }

    /**
     * 定时任务----每天八点半发送消息
     */
    @Scheduled(cron = "0 30 8 * * ?")
    public void goodMorning(){
        Pusher.push();
    }

}
