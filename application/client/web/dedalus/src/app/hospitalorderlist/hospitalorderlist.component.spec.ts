import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalorderlistComponent } from './hospitalorderlist.component';
import { HospitalorderlistService } from './hospitalorderlist.service'
import { of, throwError } from 'rxjs';
import { SharedService } from 'src/shared/shared.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';
import { NgSelectModule } from '@ng-select/ng-select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HospitalorderlistComponent } from './hospitalorderlist.component';


describe('HospitalorderlistComponent', () => {
  let component: HospitalorderlistComponent;
  let fixture: ComponentFixture<HospitalorderlistComponent>;
  let service: HospitalorderlistService;
  let sharedServiceMock = jasmine.createSpyObj('SharedService', ['methodName1', 'methodName2']);
  let httpClient: HttpClientTestingModule;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, 
        FormsModule, ReactiveFormsModule,
      ],
      declarations: [ HospitalorderlistComponent ],
      providers: [ HospitalorderlistService, 
        { provide: SharedService, useValue: sharedServiceMock},
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalorderlistComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(HospitalorderlistService);
    httpClient = TestBed.inject(HttpClient);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // ngOnInit application onload
  it('should set the created_by property with the value from sessionStorage', () => {
    const mockEmail = 'test@example.com';
    spyOn(sessionStorage, 'getItem').and.returnValue(mockEmail);
    component.ngOnInit();

    expect(sessionStorage.getItem).toHaveBeenCalledWith('email');
    expect(component.hospitalorderlist.created_by).toEqual(mockEmail);

  });
  


});