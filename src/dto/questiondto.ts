import { RecruiterDTO } from './recruiterdto';
import { CompanyDTO } from './companydto';

export class QuestionDTO {
    id: number;

    question: string;

    topic: string;

    sector: string;

    recruiter: RecruiterDTO;

    company: CompanyDTO;
}
