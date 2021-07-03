import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaDetalleventaComponent } from './lista-detalleventa.component';

describe('ListaDetalleventaComponent', () => {
  let component: ListaDetalleventaComponent;
  let fixture: ComponentFixture<ListaDetalleventaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaDetalleventaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaDetalleventaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
