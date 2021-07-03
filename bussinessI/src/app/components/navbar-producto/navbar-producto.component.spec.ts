import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarProductoComponent } from './navbar-producto.component';

describe('NavbarProductoComponent', () => {
  let component: NavbarProductoComponent;
  let fixture: ComponentFixture<NavbarProductoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarProductoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarProductoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
