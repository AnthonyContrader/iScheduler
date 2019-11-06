
import { EventDTO } from './eventdto';

/**
 * Classe DTO di Event. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 	private Long id;

	private String description;

	private EventDTO eventDTO;
 */
export class NotificationDTO {

    id: number;
    description: String;
    eventDTO: EventDTO;

}

