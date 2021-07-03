import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaProvComponent } from './lista-prov.component';

describe('ListaProvComponent', () => {
  let component: ListaProvComponent;
  let fixture: ComponentFixture<ListaProvComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaProvComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaProvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
