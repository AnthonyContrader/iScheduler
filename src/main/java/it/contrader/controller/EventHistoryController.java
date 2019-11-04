package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.EventHistoryDTO;


@RestController
@RequestMapping("/eventhistory")
@CrossOrigin(origins ="http://localhost:4200")
public class EventHistoryController extends AbstractController<EventHistoryDTO> {

	
}
