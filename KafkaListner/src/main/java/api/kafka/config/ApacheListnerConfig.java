package api.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import api.kafka.dto.Student;

@Configuration
@EnableKafka
public class ApacheListnerConfig 
{
	//for object 
	@Bean
	ConsumerFactory<String, Student> consumerFactoryForObject()
	{
		Map<String, Object> map = new HashMap<>();
		map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory(map,new StringDeserializer(),new JsonDeserializer(Student.class));
	}
	
	@Bean
	ConcurrentKafkaListenerContainerFactory<String, Student> kafkaListnerForObject()
	{
		ConcurrentKafkaListenerContainerFactory<String, Student> kafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		kafkaListenerContainerFactory.setConsumerFactory(consumerFactoryForObject());
		return kafkaListenerContainerFactory;
	}
}