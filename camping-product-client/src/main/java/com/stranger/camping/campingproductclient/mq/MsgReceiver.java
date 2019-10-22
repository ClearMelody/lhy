package com.stranger.camping.campingproductclient.mq;


import com.alibaba.fastjson.JSON;
import com.stranger.camping.campingproductclient.dao.SplikeMerchangiseDao;
import com.stranger.camping.campingproductclient.model.Util;
import com.stranger.camping.campingproductclient.util.RedisConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.net.URI;
import java.util.*;

@Component
//通过@RabbitListener注解都得到队列名称里面队列的消息
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SplikeMerchangiseDao splikeMerchangiseDao;

    @RabbitHandler
    public void  process(Util util) {
        //先查redis缓存是否有name,没有就返回注册页进行注册，再存到redis
        //根据传入的name作为key查询redis数据库，若果不为空则有值，
        if (util.getName()!=null &&redisTemplate.boundValueOps(util.getName()).get()!= null) {//两个条件，任何一个为null，则说明当前用户没有被缓存
            System.out.println("从redis能查询出用户数据，可以参加抢购");
                Jedis jedis = RedisConnection.getJedis();//创建对象
//            jedis.watch("num");
                  Long lock = jedis.setnx("lock", "yes");//获得操作权，锁的意思
                if(lock != 0){
                    String proid = util.getId().toString();  //转换类型
                    String num = jedis.get(proid); //对变量操作
                    int n = Integer.parseInt(num);//数据类型转换
                    if(n < 20){
                        Transaction transaction = jedis.multi();//开启事务
                        transaction.incr(proid); //变量自增一
                        //添加记录到数据库（秒杀商品信息，用户信息）
                        // 调用service层
//                        UserInfo userInfo=new UserInfo();
//                        String s= UUID.randomUUID().toString().replace("-","");
//                        userInfo.setUserId(util.getId().toString()+s);
//                        userInfo.setUserName(util.getName());
//                        userInfoDao.insert(userInfo);
                        // 远程url
                        String url = "http://localhost:9001/insert";
                        String s = JSON.toJSONString(util);
                        Map<String, String> paramMap = new HashMap<>();
                        paramMap.put("s", s);
                    post(url, paramMap);//该请求可以跨域访问
                        transaction.exec(); //执行事务
                        jedis.del("lock");//解封操作权，释放锁
                    }
                }
                jedis.close();//关闭连接
        }
    }

    private void post(String url, Map<String, String> paramMap){
        // 创建HttpClient来发送请求
        HttpClient httpClient = new DefaultHttpClient();
        // 创建一个post请求
        HttpPost httpPost = new HttpPost();
        // 创建参数集合
        List<NameValuePair> formparams = new ArrayList<>();

        // 将map转成set
        Set<Map.Entry<String, String>> set = paramMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            // 添加到list中串
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        // 格式化请求参数：username=aaa&password=bbb
        String param = URLEncodedUtils.format(formparams, "UTF-8");
        // 使用?将参数拼接到url上，一般get请求如此  将token传入服务端
        httpPost.setURI(URI.create(url + "?" + param));
        try {
            // 发送请求，获得响应
            HttpResponse response = httpClient.execute(httpPost);
            // 得到请求结果
            HttpEntity entity = response.getEntity();
            // 将结果转换成字符串json格式
            String str = EntityUtils.toString(entity);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
