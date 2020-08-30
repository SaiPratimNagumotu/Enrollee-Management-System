import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router'
import { Enrollee } from 'src/app/models/enrollee';
import { EnrolleeService } from 'src/app/_service/enrollee.service'

@Component({
  selector: 'app-enrollee-list',
  templateUrl: './enrollee-list.component.html',
  styleUrls: ['./enrollee-list.component.css']
})
export class EnrolleeListComponent implements OnInit {

  enrollees: Observable<Enrollee[]>;

  @Input() enrollee: Enrollee;

  constructor(private enrolleeService: EnrolleeService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.enrollees = this.enrolleeService.getEnrolleeList();
  }

  deleteEnrollee(id: number) {
    this.enrolleeService.deleteEnrollee(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error)
    )
  }

  deleteAllEnrollees() {
    this.enrolleeService.deleteAllEnrollees().subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error)
    );
  }

  updateEnrollee(id: number) {
    this.router.navigate(['update', id]);
  }

}
