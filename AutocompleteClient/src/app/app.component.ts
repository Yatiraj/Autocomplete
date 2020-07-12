import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  myControl = new FormControl();
  
  req = { "input": null };
  resArray;
  static uiresp=[];

  constructor(private httpClient: HttpClient) {
  }

  onKey(value) {
    this.req.input = value;
    this.callApi(this.req, function (resp: any) {
    AppComponent.uiresp=resp
    })
  }

  callApi(req: any, callback: any) {
    let url = 'http://localhost:8080/matches';
    this.httpClient.post(url, req, { headers: { "Content-Type": "application/json" } }).subscribe(response => {
      return callback(response);
    }
    )
  }
  get uiresp(){
    return AppComponent.uiresp;
  }

}
