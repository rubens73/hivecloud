import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Prato } from '../models/prato.model';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})

export class ServiceService {

  constructor(private http:HttpClient) {}
  private url = 'http://localhost:8080/prato';

  public getPratos() {
    return this.http.get<Prato[]>(this.url);
  }

  getAll(): Observable<Prato[]> {
    return this.http.get(this.url).pipe(map(this.jsonDataToCategorias));
  }

  getPratoId(id:String){
    return this.http.get<Prato>(this.url+"/"+id);
  }

  editarPrato(prato:Prato){
    return this.http.put<Prato>(this.url+"/"+prato.nome, prato, httpOptions);
  }

  salvarPratos(prato:Prato):Observable<Prato>{
    return this.http.post<Prato>(this.url, prato, httpOptions);
  }

  deletarPrato(prato:Prato){
    return this.http.delete<Prato>(this.url+"/"+prato.nome);
  }

  private jsonDataToCategorias(jsonData: any[]): Prato[] {
    const aux: Prato[] = [];
    jsonData.forEach(element => aux.push(element as Prato));
    return aux;
  }
}

