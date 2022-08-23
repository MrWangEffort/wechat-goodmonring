package com.gali.scheduling;


import com.gali.entity.Weather;
import com.gali.utils.BirthdayUtils;
import com.gali.utils.TianXingUtils;
import com.gali.utils.WeatherUtils;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.Map;

public class Pusher {

    public static void main(String[] args) {
        push();
    }

    //这里填公众平台上面的appID和appsecret
    private static String appId = "自己的appId";
    private static String secret = "自己的secret";

    public static void push(){
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("需要推送的人")//这里填需要推送的人的openid
                .templateId("模板id")//这里填模板id
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        Weather weather = WeatherUtils.getWeather();
        Map<String, String> map = TianXingUtils.getEnsentence();
        templateMessage.addData(new WxMpTemplateData("riqi",weather.getDate() + "  "+ weather.getWeek(),"#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianqi",weather.getText_now(),"#74b9ff"));
        templateMessage.addData(new WxMpTemplateData("low",weather.getLow() + "","#008272"));
        templateMessage.addData(new WxMpTemplateData("high",weather.getHigh()+ "","#FF6347" ));
        templateMessage.addData(new WxMpTemplateData("shengri", BirthdayUtils.getBirthday_Jo()+"","#FFA500"));
        templateMessage.addData(new WxMpTemplateData("jinju",map.get("zh") +"","#C71585"));
        templateMessage.addData(new WxMpTemplateData("dog", TianXingUtils.getDogPi() +"","#C71585"));
        String beizhu = "🌈";
        templateMessage.addData(new WxMpTemplateData("beizhu",beizhu,"#FF0000"));
        if(BirthdayUtils.getBirthday_Jo()  == 0){
            beizhu = "今天是**生日，生日快乐呀！";
        }
        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
