package utry.config;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

/**
 * @author
 * 消息消费者
 */
@Configuration
public class CustomConsumer extends DefaultConsumerConfigure implements ApplicationListener<ContextRefreshedEvent> {

    Logger log = LoggerFactory.getLogger(CustomConsumer.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            super.listener("t_TopicTest", "Tag1");
        } catch (MQClientException e) {
            log.error("消费者监听器启动失败", e);
        }

    }

    @Override
    public ConsumeConcurrentlyStatus dealBody(List<MessageExt> messageExtList) {
        log.info("接收到消息");
        for (MessageExt msg : messageExtList) {
            try {
                String msgStr = new String(msg.getBody(), "utf-8");
                log.info(msgStr);
            } catch (Exception e) {
                log.error("body转字符串解析失败");
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

}
