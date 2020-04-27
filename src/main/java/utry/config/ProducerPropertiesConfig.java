package utry.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * 消息生产者配置信息
 */
@Configuration
@ConfigurationProperties(prefix = "rocketmq.producer")
public class ProducerPropertiesConfig {

    @Value("${namesrvAddr}")
    private String namesrvAddr;

    private String groupName;

    private Integer maxMessageSize;

    private Integer sendMsgTimeout;

    private Integer retryTimesWhenSendFailed;

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getMaxMessageSize() {
        return maxMessageSize;
    }

    public void setMaxMessageSize(Integer maxMessageSize) {
        this.maxMessageSize = maxMessageSize;
    }

    public Integer getSendMsgTimeout() {
        return sendMsgTimeout;
    }

    public void setSendMsgTimeout(Integer sendMsgTimeout) {
        this.sendMsgTimeout = sendMsgTimeout;
    }

    public Integer getRetryTimesWhenSendFailed() {
        return retryTimesWhenSendFailed;
    }

    public void setRetryTimesWhenSendFailed(Integer retryTimesWhenSendFailed) {
        this.retryTimesWhenSendFailed = retryTimesWhenSendFailed;
    }

    @Override
    public String toString() {
        return "ProducerConfig [namesrvAddr=" + namesrvAddr + ", groupName=" + groupName + "]";
    }
}
