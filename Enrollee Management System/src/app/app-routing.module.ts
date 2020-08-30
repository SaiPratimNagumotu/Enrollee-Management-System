import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EnrolleeListComponent } from './enrollee-list/enrollee-list.component';
import { UpdateEnrolleeComponent } from './update-enrollee/update-enrollee.component';

const routes: Routes = [
  {path:'', redirectTo:'/enrollees', pathMatch: 'full'},
  {path:'enrollees', component:EnrolleeListComponent},
  {path:'update/:id', component:UpdateEnrolleeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
