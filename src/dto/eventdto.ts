import { UserDTO } from './userdto';
import { NotificationDTO } from './notificationdto';

/**
 * Classe DTO di Event. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 */
export class EventDTO {

    id: number;
    name: String;
    description: String;
    arguments: String;
    startDate: Date;
    endDate: Date;
    agentName: String;
    agentSurname: String;
    company: String;
    category: String;
    userDTO: UserDTO;
    

}

