package com._2dland.sbkafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

@Service
@Slf4j
public class KafkaListenerTest {
    @KafkaListener(topics = "nginx-access-log")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        log.info(cr.toString());
        latch.countDown();
    }
    @Resource
    private KafkaTemplate<String, String> template;
    private final CountDownLatch latch = new CountDownLatch(3);

}
