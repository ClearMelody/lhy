package com.stranger.camping.campingproductclient.mq;


import com.stranger.camping.campingproductclient.model.Util;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {
    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;
    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    /**
     * 此方法将消息保存到队列中
     */
    public void sendMsg(Util util) {   //存放消息
        //生成一个唯一的全局变量,用来确定不会被重复消费
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, util, correlationId);
        System.out.println("123");
    }

    /**
     * 此方法通过确认响应应答ack来确认是否被消费成功
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String reason) {
        if (ack) {
            System.out.println("消息消费成功");
        } else {
            System.out.println("消息消费失败:" + reason);
        }
    }
}
