package api.kafka.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import api.kafka.dto.Student;

@RestController
public class Handler
{	
	private List<String> msgs = new ArrayList<>();
	
	private List<Student> studentList = new ArrayList<>();
	
	private int msgCounterForString = 1;
	private int msgCounterForStudent = 1;
	
	@KafkaListener(groupId = "listnerobject",topics = "StudentTopic",containerFactory = "kafkaListnerForObject")
	public void listnerForObject(Student student)
	{
		System.out.println("student received : " + msgCounterForStudent + "." + student.toString());
		studentList.add(student);
		studentList.forEach(a->{a.toString();});
	}
	
	@GetMapping("/receive/student")
	public List<Student> student()
	{
		studentList.forEach(a->{a.toString();});
		return studentList;
	}

}