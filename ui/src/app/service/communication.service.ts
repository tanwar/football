import { HttpClient } from '@angular/common/http';

export class CommunicationService {
    constructor (private httpClient: HttpClient){

    }

    getCountry(){
    this.httpClient.get("")
    }
}