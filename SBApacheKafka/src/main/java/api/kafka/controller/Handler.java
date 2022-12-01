package api.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import api.kafka.dto.Student;

@RestController
public class Handler 
{
	@Autowired
	private KafkaTemplate<String,Object> template;
	
	@GetMapping("/send")
	public String test(@RequestBody Student student)
	{
		template.send("StudentTopic",student);
		System.out.println("sent : " + student.toString());
		return "student " + student.getName() + " sent to the department.";
	}
}