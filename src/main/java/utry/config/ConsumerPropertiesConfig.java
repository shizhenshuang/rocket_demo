package utry.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * 消费者属性配置类
 */
@ConfigurationProperties(prefix = "rocketmq.consumer")
@Configuration
public class ConsumerPropertiesConfig {
    private String groupName;

    @Value("${namesrvAddr}")
    private String namesrvAddr;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    @Override
    public String toString() {
        return "ConsumerConfig [groupName=" + groupName + ", namesrvAddr=" + namesrvAddr + "]";
    }

}
