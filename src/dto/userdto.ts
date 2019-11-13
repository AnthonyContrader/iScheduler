
import { EventDTO } from './eventdto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Vittorio Valent
 */
export class UserDTO {

   id: number;
   activated: true;
   authorities: string[]=[""];
   firstName: string;
   lastName: string;
   email: string;
   login: string;
   resetDate: string;
}

