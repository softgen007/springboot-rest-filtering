package demo.webservices.rest.filtering;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	

	// password
	@GetMapping("/filtering/static")
	public UserStatic getUser() throws ParseException {
		UserStatic userStatic = new UserStatic(152626, "user1", "password1", "fname1", "lname1");
		
		return userStatic;
	}
	
	// userName, password
	@GetMapping("/filtering/dynamic")
	public MappingJacksonValue retrieveUser() throws ParseException {
		UserDynamic userDynamic = new UserDynamic(152626, "user1", "password1", "fname1", "lname1", sdf.parse("1999-06-06"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "firstName", "lastName", "birthDate");

		FilterProvider filters = new SimpleFilterProvider().addFilter("UserPropertyFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(userDynamic);

		mapping.setFilters(filters);

		return mapping;
	}

	// userName, password
	@GetMapping("/filtering/dynamic/list")
	public MappingJacksonValue retrieveListOfUsers() throws ParseException {
		List<UserDynamic> list = Arrays.asList(new UserDynamic(152626, "user1", "password1", "fname1", "lname1", sdf.parse( "1999-06-06")),
				new UserDynamic(156843, "user2", "password2", "fname2", "lname2", sdf.parse("1989-06-06")));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "firstName", "lastName", "birthDate");

		FilterProvider filters = new SimpleFilterProvider().addFilter("UserPropertyFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(list);

		mapping.setFilters(filters);

		return mapping;
	}

}
