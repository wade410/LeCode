package leetcode.testCase;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @Author HuShengHenGao
 * @Date 2022/8/9
 **/
public class KafaKaTest {
    public static final String bootStrap = "xxxxxx:9090";
    public static final String topic = "t_3_1";
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrap);
        // 序列化协议  下面两种写法都可以
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"o.a.k.clients.producer.internals.DefaultPartitioner");
        //过滤器 可配置多个用逗号隔开
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,"org.apache.kafka.clients.producer.SzzProducerInterceptorsTest");
        //构造 KafkaProducer
        KafkaProducer producer = new KafkaProducer(properties);

        ProducerRecord<String,String> record = new ProducerRecord(topic,"Hello World!");
//        producer.send(record,new SzzTestCallBack(record.topic(), record.key(), record.value()));
    }
}
