# 🌈微信公众号每日推送

> 抖音临时起兴，凑个热闹！！！！！！！！！！

### 🧚🏼‍♂️重要的SDK

* ```maven
  <dependency>
    <groupId>com.github.binarywang</groupId>
    <artifactId>（不同模块参考下文）</artifactId>
    <version>4.4.0</version>
  </dependency>
  ```

  - 微信小程序：`weixin-java-miniapp`
  - 微信支付：`weixin-java-pay`
  - 微信开放平台：`weixin-java-open`
  - 公众号（包括订阅号和服务号）：`weixin-java-mp`
  - 企业号/企业微信：`weixin-java-cp`

### 🧚🏼‍♂️傻瓜式运行

1. 登录微信公众号测试账户，记住`appID`，`appsecret`，扫描测试的二维码并记住该微信号的`ID`，并新增一个模板消息接口，模板内容为`{{beizhu.DATA}} {{riqi.DATA}} 天气: {{tianqi.DATA}} 最低温度:{{low.DATA}}度 最高温度:{{high.DATA}}度 距离你的生日还有{{shengri.DATA}}天 舔狗日记:{{dog.DATA}} 每日一句:{{jinju.DATA}}`
2. 注册并登录百度地图的开发者工具，获取一个`ACK`
   1. https://lbsyun.baidu.com/
3. 注册并登录天行数据并找到对于的接口，并在控制台记住该账号的`ACK`
   1. 控制台：https://www.tianapi.com/console/
   2. 舔狗日记：https://www.tianapi.com/apiview/180
   3. 每日一句：https://www.tianapi.com/apiview/62
4. 克隆该项目并打开，修改上述所对应的`Id`，`ACK`等
5. 运行该项目
6. 部署（可选）
   1. 利用 maven打包工具进行打包并上传至服务器