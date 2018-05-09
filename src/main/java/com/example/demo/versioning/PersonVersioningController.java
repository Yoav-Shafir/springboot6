package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	// -- URI versioning (Twitter) -- //
	
//	@GetMapping("v1/person")
//	public PersonV1 personV1() {
//		return new PersonV1("Bob Charlie");
//	}
//	
//	@GetMapping("v2/person")
//	public PersonV2 personV2() {
//		return new PersonV2(new Name("Bob", "Charlie"));
//	}
	
	// -- Request Parameter versioning (Amazon) -- //
	
//	// This will be executed for: person/param?version=1
//	@GetMapping(value="person/param", params="version=1")
//	public PersonV1 paramV1() {
//		return new PersonV1("Bob Charlie");
//	}
//	
//	// This will be executed for: person/param?version=2
//	@GetMapping(value="person/param", params="version=2")
//	public PersonV2 paramV2() {
//		return new PersonV2(new Name("Bob", "Charlie"));
//	}
	
	// -- Header versioning (Microsoft) -- //
	
//	// This will be executed for:  curl -i -H "X-API-VERSION: 1" -X GET localhost:8080/person/header
//	@GetMapping(value="person/header", headers="X-API-VERSION=1")
//	public PersonV1 headerV1() {
//		return new PersonV1("Bob Charlie");
//	}
//	
//	// This will be executed for:  curl -i -H "X-API-VERSION: 2" -X GET localhost:8080/person/header
//	@GetMapping(value="person/header", headers="X-API-VERSION=2")
//	public PersonV2 headerV2() {
//		return new PersonV2(new Name("Bob", "Charlie"));
//	}
	
	// -- MIME Type/Media Type versioning (Github) -- //
	
	// "produces" (means, what is the output of this specific service), 
	// Also called Content Negotiation or Accept Versioning
	
	// This will be executed for:  curl -i -H "Accept: application/vnd.company.app-v1+json" -X GET localhost:8080/person/produces
	@GetMapping(value="person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Bob Charlie");
	}
	
	// This will be executed for:  curl -i -H "Accept: application/vnd.company.app-v2+json" -X GET localhost:8080/person/produces
	@GetMapping(value="person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
}
