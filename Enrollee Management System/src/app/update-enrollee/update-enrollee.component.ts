import { Component, OnInit } from '@angular/core';
import { Enrollee } from 'src/app/models/enrollee';
import { EnrolleeService } from 'src/app/_service/enrollee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-enrollee',
  templateUrl: './update-enrollee.component.html',
  styleUrls: ['./update-enrollee.component.css']
})
export class UpdateEnrolleeComponent implements OnInit {

  id: number;
  enrollee: Enrollee;

  constructor(private route: ActivatedRoute, private router: Router, private enrolleeService: EnrolleeService) { }

  ngOnInit(): void {
    this.enrollee = new Enrollee();
    this.id = this.route.snapshot.params['id'];

    this.enrolleeService.getEnrolleeById(this.id).subscribe(
      data => {
        console.log(data);
        this.enrollee = data;
      },
      error => console.log(error)
    );
  }

  updateEnrollee() {
    this.enrolleeService.updateEnrollee(this.id, this.enrollee).subscribe(
      data => {
        console.log(data);
        this.enrollee = new Enrollee();
        this.router.navigate(['/enrollees']);
      },
      error => console.log(error)
    );
  }

  onSubmit() {
    this.updateEnrollee();
  }

}
