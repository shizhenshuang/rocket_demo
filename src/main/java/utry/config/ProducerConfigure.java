package utry.config;


import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * 消息生产者
 */
@Configuration
public class ProducerConfigure {

    Logger logger = LoggerFactory.getLogger(ProducerConfigure.class);

    @Autowired
    private ProducerPropertiesConfig producerPropertiesConfig;

    @Bean
    public DefaultMQProducer defaultProducer() throws MQClientException {
        logger.info(producerPropertiesConfig.toString());
        logger.info("defaultProducer 正在创建---------------------------------------");
        DefaultMQProducer producer = new DefaultMQProducer(producerPropertiesConfig.getGroupName());
        producer.setNamesrvAddr(producerPropertiesConfig.getNamesrvAddr());
        producer.setVipChannelEnabled(false);
        //其他属性自行设置，这里才用默认
        producer.start();
        logger.info("rocketmq producer server开启成功---------------------------------.");
        return producer;
    }
}
