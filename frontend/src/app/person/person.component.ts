import { Component, OnInit } from '@angular/core';

import { PersonService } from '../shared/services/person.service';
import { Person } from '../shared/interfaces/person';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {
  public persons: Array<any>;
  public person: Person;

  public _name: string;
  public _age: number;

  submitted = false;
  constructor(private personService: PersonService) { this.persons=[] }

  ngOnInit() {
    this.getPersons();
  }

  getPersons(){
    this.persons = this.personService.getPersons();
  }

  onSubmit(){
    this.getPersons();

    this.person={id:0,name:this._name,age:this._age};
    this.personService.addPerson(this.person);
  }
}
