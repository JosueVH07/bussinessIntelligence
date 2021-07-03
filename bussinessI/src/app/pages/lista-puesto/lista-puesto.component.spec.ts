import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaPuestoComponent } from './lista-puesto.component';

describe('ListaPuestoComponent', () => {
  let component: ListaPuestoComponent;
  let fixture: ComponentFixture<ListaPuestoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaPuestoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaPuestoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
