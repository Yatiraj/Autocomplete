import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Autocomplete';

  req = { "input": null };
  suggestions = ["ab", "abc", "abcd"];
  static uiresp=[];
  mySet = new Set();

  constructor(private httpClient: HttpClient) {
  }

  onKey(value) {
    this.req.input = value;
    this.callApi(this.req, function (resp: any) {
    console.log('--------------response-----------------');
    AppComponent.uiresp=resp
    console.log(AppComponent.uiresp);
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
