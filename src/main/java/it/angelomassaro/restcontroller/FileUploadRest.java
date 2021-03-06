package it.angelomassaro.restcontroller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;

@RestController
@RequestMapping("/api")
public class FileUploadRest {

	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file, @RequestPart("fileBis") MultipartFile fileBis, @RequestHeader Map<String, String> requestHeaders) {
		
		System.out.println("requestHeaders X-ReplyTo: " + requestHeaders.get("xreplyto"));
		if (null == file.getOriginalFilename()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get("C:/temp/upload/" + file.getOriginalFilename());
			Files.write( path, bytes);
			System.out.println(path.getFileName());
			
			bytes = fileBis.getBytes();
			path = Paths.get("C:/temp/upload/" + fileBis.getOriginalFilename());
			Files.write( path, bytes);
			System.out.println(path.getFileName());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String,String>();
		//headers.add("X-ReplyTo", "https://www.giustizia-amministrativa.it/replyqui");
		headers.add("X-Correlation-ID", "idAcaso");
		return new ResponseEntity<>("Good Job", new HttpHeaders(headers), HttpStatus.OK );
	}
	
	
}
