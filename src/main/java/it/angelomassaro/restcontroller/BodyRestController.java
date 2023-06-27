package it.angelomassaro.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.Persona;

@RestController
@RequestMapping("/body")
public class BodyRestController {

	//Prende in input un body JSON e ritorna un ResponseEntity
	@PostMapping("/provaBody")
    @ResponseBody
    public ResponseEntity<HttpStatus>  provaBody(@RequestBody Persona persona) {
        return ResponseEntity.ok(HttpStatus.OK);
    }
	
	//Prende in input un body JSON e ritorna un JSON
	@PostMapping("/provaBody002")
    @ResponseBody
    public Persona  provaBody002(@RequestBody Persona persona) {
		persona.setEta(43);
        return persona;
    }
	
}
