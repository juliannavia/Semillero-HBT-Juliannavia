import { ComicDTO } from 'src/app/semillero/dto/comic-dto';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'gestionar-compra-comic',
  templateUrl: './gestionar-compra-comic.component.html',
})
export class GestionarCompraComicComponent implements OnInit {

  public submitted : boolean;

  public gestionarComicForm : FormGroup;

  public comicDTO : ComicDTO;

  constructor(private fb : FormBuilder , private router : Router, private activatedRoute: ActivatedRoute) {
    this.gestionarComicForm = this.fb.group({
      cantidad : [null, Validators.required],
    });
   }

  ngOnInit() {
    this.submitted = false;
    let comic : any = this.activatedRoute.snapshot.params;
    this.comicDTO = comic;
    this.f.nombre.setValue(comic.nombre);

  }

  get f() {
    return this.gestionarComicForm.controls;
  }

}
