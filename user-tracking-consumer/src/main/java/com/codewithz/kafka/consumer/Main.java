package com.codewithz.kafka.consumer;


import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.graalvm.compiler.asm.sparc.SPARCAssembler.RCondition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        SuggestionEngine suggestionEngine = new SuggestionEngine();
        
        Properties props=new Properties();
    	props.put("bootstrap.servers","localhost:9092,localhost:9093");
    	props.put("group.id","user-tracking-consumer");
    	props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
    	props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
    	
    	Consumer<String, String> consumer=new KafkaConsumer<>(props);
    	
    	consumer.subscribe(Arrays.asList("user-tracking"));
    	
    	while(true) {
	    	ConsumerRecords<String, String> records=consumer.poll(Duration.ofMillis(100));
	    	
	    	for(ConsumerRecord<String, String> record:records) {
	    		System.out.println("Raw Record-->"+record.key()+"--"+record.value());
	    		suggestionEngine.processSuggestions(record.key(),record.value());
	    	}
    	}
    }
}
